package com.liusoft.baseWeb.controller.admin;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.role.RoleService;
import com.liusoft.baseWeb.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-5
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin/userManage")
public class UserManageController extends BaseController {

    public static final String PREFIX = "admin/userManage/";

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="main.html")
    public ModelAndView main(HttpServletRequest request){
        Result result = roleService.getAllRole();
        return view(PREFIX +"main",result);
    }

    @RequestMapping(value="search.html")
    @ResponseBody
    public Object search(HttpServletRequest request){
        PageQuery pagequery = convertPageQuery(request);
        Result result =  userService.getUserByPage(pagequery);
        return result;
    }

    @RequestMapping(value="dialogAdd.html")
    public ModelAndView dialogAdd(HttpServletRequest request){

        Result result = roleService.getAllRole();
        return view(PREFIX +"dialogAdd",result);
    }

    @RequestMapping(value="dialogUpdate.html")
    public ModelAndView dialogUpdate(HttpServletRequest request){
        Result result = roleService.getAllRole();
        String userId = request.getParameter("userId");
        if( StringUtils.isNotBlank(userId) ){
            Result userResult = userService.getUserById(Integer.valueOf(userId));
            if( userResult.isSuccess() ){
                result.appendResult(userResult);
            }
        }
        return view(PREFIX +"dialogUpdate",result);
    }

    @RequestMapping(value="addUser.html")
    @ResponseBody
    public Object addUser(HttpServletRequest request){
        String roleIdStr = request.getParameter("roleId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String account = request.getParameter("account");

        if( StringUtils.isBlank(roleIdStr) ){
            Result result = new Result();
            result.setMessage("角色错误");
            result.setSuccess(false);
            return  result;
        }

        User user = new User();
        user.setRoleId(Integer.valueOf(roleIdStr));
        user.setPassword(password);
        user.setUserName(userName);
        user.setAccount(account);
        Result result = userService.addUser(user);
        return result;
    }

    @RequestMapping(value="updateUser.html")
    @ResponseBody
    public Object updateUser(HttpServletRequest request){
        String roleIdStr = request.getParameter("roleId");
        String oldPassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");

        String userName = request.getParameter("userName");
        String account = request.getParameter("account");

        String userIdStr = request.getParameter("userId");

        if( StringUtils.isBlank(roleIdStr) ){
            Result result = new Result();
            result.setMessage("角色错误");
            result.setSuccess(false);
            return  result;
        }

        if( StringUtils.isBlank(userIdStr) ){
            Result result = new Result();
            result.setMessage("用户ID错误");
            result.setSuccess(false);
            return  result;
        }

        Result userResult = userService.getUserById(Integer.valueOf(userIdStr));
        if( !userResult.isSuccess() ){
            return userResult;
        }

        User oldUser = (User) userResult.get("user");
        if( !oldPassword.equals(oldUser.getPassword()) ){
            Result result = new Result();
            result.setMessage("旧密码输入错误");
            result.setSuccess(false);
            return  result;
        }


        User user = new User();
        user.setRoleId(Integer.valueOf(roleIdStr));
        if( StringUtils.isNotBlank(password) ){
            user.setPassword(password);
        }

        if( StringUtils.isNotBlank(userName) ){
            user.setUserName(userName);
        }

        if( StringUtils.isNotBlank(account) ){
            user.setAccount(account);
        }

        user.setUserId(Integer.valueOf(userIdStr));
        Result result = userService.updateUser(user);
        return result;
    }

    @RequestMapping(value="delUser.html")
    @ResponseBody
    public Object delUser(HttpServletRequest request){
        String userIdStr = request.getParameter("userId");
        if( StringUtils.isBlank(userIdStr) ){
            Result result = new Result();
            result.setMessage("用户ID错误");
            result.setSuccess(false);
            return  result;
        }

        Result result = userService.deleteUser(Integer.valueOf(userIdStr));
        return result;

    }


}
