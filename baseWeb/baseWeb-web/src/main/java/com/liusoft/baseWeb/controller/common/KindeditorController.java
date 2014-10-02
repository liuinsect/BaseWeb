package com.liusoft.baseWeb.controller.common;

import com.liusoft.baseWeb.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-2
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/kindeditor")
public class KindeditorController extends BaseController {

    public static final String KINDEDITOR = "kindeditor/";

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="index.html",method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request){
        return view(KINDEDITOR+"index");
    }

}
