package com.liusoft.baseWeb.interceptor;

import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.common.util.CookieUtils;
import com.liusoft.baseWeb.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginInterceptor extends BaseInterceptor {

	@Resource
	private UserService userService;
	
	
	private Logger log = Logger.getLogger(LoginInterceptor.class);
	

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		for( String excludedUrl : excludedUrls ){
			String requestURI = request.getServletPath();
            int wildcardsPos = excludedUrl.lastIndexOf("*");
            if( wildcardsPos >= 0 ){
                excludedUrl = excludedUrl.substring( 0 , wildcardsPos );
            }
			if( requestURI.startsWith(excludedUrl)){
				return true;
			}
		}


        Map map = CookieUtils.validateLoginCookie(request);

        Integer userId = (Integer) map.get("userId");

        String password = (String) map.get("ps");

        if( userId == null || userId == 0 ){
            toLogin(request, response);
            return false;
        }

        User user = userService.getUserById(userId);

        if( user == null ){
            toLogin(request, response);
            return false;
        }

        if( user.getPassword().equals(password) ){
            CookieUtils.produceLoginCookie(response, user);
            request.setAttribute("loginUser", user);
            return true;
        }

        return false;

	}


	/**
	 * 跳转到ERP去登录
	 * @throws java.io.IOException
	 */
	private void toLogin(HttpServletRequest request , HttpServletResponse response) throws IOException{
        //否则直接redrect
        response.sendRedirect("login.html");

	}

}
