package com.liusoft.baseWeb.common.util;

import com.liusoft.baseWeb.client.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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



}
