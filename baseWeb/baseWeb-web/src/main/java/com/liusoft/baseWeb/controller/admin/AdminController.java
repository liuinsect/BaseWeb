package com.liusoft.baseWeb.controller.admin;

import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-9-28
 * Time: 下午7:24
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    public static final String ADMIN = "admin/";


    /**
     * 普通正常的配置
     */
    @RequestMapping(value="index.html",method = RequestMethod.GET)
    public ModelAndView menu(HttpServletRequest request){
        User loginUser = getLoginUser(request);
        Map param = new HashMap();
        param.put("loginUser",loginUser);
        return view(ADMIN+"index",param);
    }


}
