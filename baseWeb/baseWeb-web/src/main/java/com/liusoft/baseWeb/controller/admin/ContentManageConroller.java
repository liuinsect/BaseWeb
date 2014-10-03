package com.liusoft.baseWeb.controller.admin;

import com.liusoft.baseWeb.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-2
 * Time: 下午7:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin/contentManage")
public class ContentManageConroller extends BaseController{

    public static final String PREFIX = "admin/contentManage/";

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="main.html")
    public ModelAndView main(HttpServletRequest request){
        return view(PREFIX +"main");
    }

}
