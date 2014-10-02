package com.liusoft.baseWeb.controller;

import com.liusoft.baseWeb.common.util.MD5Util;
import com.liusoft.baseWeb.controller.common.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-1
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    public static final String LOGIN = "login";

    @RequestMapping(value="doLogin.html")
    public ModelAndView doLogin( HttpServletRequest request , HttpServletResponse response ){
        String message= null;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if( StringUtils.isBlank(account) || StringUtils.isBlank(password) ){
            message="用户名或密码不能为空";
            return returnMessage(LOGIN, message);
        }

        account = MD5Util.encryptToMD5(account);
        password =MD5Util.encryptToMD5( password );

        return returnMessage(LOGIN, "用户名密码错误");
    }


}
