package com.liusoft.baseWeb.controller;

import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.ListUtils;
import com.liusoft.baseWeb.common.BaseWebProperties;
import com.liusoft.baseWeb.common.util.CookieUtils;
import com.liusoft.baseWeb.common.util.JsonUtils;
import com.liusoft.baseWeb.common.util.MD5Util;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.role.RoleService;
import com.liusoft.baseWeb.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-1
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    public static final String LOGIN = "login";

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;


    @RequestMapping(value="/login.html")
    public ModelAndView index( HttpServletRequest request , HttpServletResponse response ){
        Result result = roleService.getAllRole();
        return view(LOGIN,result);
    }

    @RequestMapping(value="doLogin.html")
    @ResponseBody
    public Object doLogin( HttpServletRequest request , HttpServletResponse response ){
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Result result = new Result();;
        if( StringUtils.isBlank(account) || StringUtils.isBlank(password) ){

            result.setMessage("用户名或密码不能为空");
            result.setSuccess(false);
            return result;
        }

        String role = request.getParameter("roleId");

        User example = new User();
        example.setAccount(account);
        example.setPassword(password);
        example.setRoleId(Integer.valueOf(role));
        List<User> userList = userService.getListByExample(example);

        if( ListUtils.isNotBlank(userList) ){
            loginSuccess(response,userList.get(0));
            result.setSuccess(true);
            return result;
        }

        result.setMessage("用户名或密码错误");
        result.setSuccess(false);
        return result;
    }

    /**
     * 登录成功后写入cookie
     * @param response
     * @return
     */
    private void loginSuccess(HttpServletResponse response,User user){
        CookieUtils.produceLoginCookie(response, user);
    }


}
