package com.liusoft.baseWeb.common.util;

import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.common.BaseWebProperties;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-2-26
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public class CookieUtils {

    private static final String ENCODE = "UTF-8";

    /**
     * 获取request请求中的指定cookie值，并尝试解码
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name,String charset){
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if ( cookies != null ) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(name)) {
                    cookieValue = cookie.getValue();
                    if( StringUtils.isNotBlank(cookieValue) ){
                        try {
                            cookieValue = URLDecoder.decode(cookieValue, charset);
                        } catch (UnsupportedEncodingException e) {
                            //吃掉异常 返回null
                            cookieValue = null;
                        }

                    }
                }
            }
        }
        return cookieValue;
    }

    /**
     * 获取request请求中的指定cookie值，并尝试使用UTF-8解码
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        return getCookieValue(request,name,ENCODE);
    }


    public static void setCookie(HttpServletResponse servletResponse, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(BaseWebProperties.getDomain());
        cookie.setPath(BaseWebProperties.getCookiePath() );
        cookie.setMaxAge(BaseWebProperties.getCookieExpiry());
        servletResponse.addCookie(cookie);
    }

    public static void produceLoginCookie(HttpServletResponse response,User user){
        String loginCookieKey = BaseWebProperties.getLoginCookieKey();
        Map map = new HashMap();
        map.put("userId",user.getUserId());
        map.put("ps",user.getPassword());
        //TODO 差时间戳
        BASE64Encoder base64=new BASE64Encoder();
        String cookieValue = base64.encode(JsonUtils.toJson(map).getBytes());

        CookieUtils.setCookie(response, loginCookieKey, cookieValue);
    }

    public static Map validateLoginCookie(HttpServletRequest request){
        String loginCookie = getCookieValue( request, BaseWebProperties.getLoginCookieKey() );
        if( StringUtils.isBlank(loginCookie) ){
            return null;
        }

        BASE64Decoder base64Decoder=new BASE64Decoder();

        byte[] cookieByte = new byte[0];
        try {
            cookieByte = base64Decoder.decodeBuffer(loginCookie);
        } catch (IOException e) {
            return null;
        }

        Map map = JsonUtils.readToMap( new String(cookieByte) );
         return map;
    }

}
