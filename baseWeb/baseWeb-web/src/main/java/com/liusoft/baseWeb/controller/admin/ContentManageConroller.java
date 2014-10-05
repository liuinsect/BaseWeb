package com.liusoft.baseWeb.controller.admin;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.module.Module;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.article.ArticleService;
import com.liusoft.baseWeb.service.module.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Resource
    private ModuleService moduleService;


    @Resource
    private ArticleService articleService;

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="main.html")
    public ModelAndView main(HttpServletRequest request){
        Result result =  moduleService.getAllModule();
        return view(PREFIX +"main",result);
    }

    /**
     * 搜索
     * @param request
     * @return
     */
    @RequestMapping(value="search.html")
    @ResponseBody
    public Object search(HttpServletRequest request){

        PageQuery pagequery = convertPageQuery(request);
        Result result =  articleService.getArticleByPage(pagequery);
        return result;
    }

    @RequestMapping(value="contentEditor.html")
     @ResponseBody
     public Object contentEditor(HttpServletRequest request){
        return view(PREFIX +"contentEditor");
    }

    @RequestMapping(value="dialog.html")
    @ResponseBody
    public Object dialog(HttpServletRequest request){
        Result result =  moduleService.getAllModule();
        String type = request.getParameter("type");
        if( "add".equals(type) ){
            result.addDefaultModel("submitUrl","/"+PREFIX+"contentAdd.html");
        }else{
            result.addDefaultModel("submitUrl","/"+PREFIX+"contentUpdate.html");
            result.addDefaultModel("articleId",request.getParameter("articleId"));
        }

        return view(PREFIX +"dialog",result);
    }

    @RequestMapping(value="contentAdd.html")
    @ResponseBody
    public Object contentAdd(HttpServletRequest request){
        String title = request.getParameter("articleTitle");
        String moduleId = request.getParameter("moduleId");
        String content = request.getParameter("content");

        User loginUser = getLoginUser(request);
        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(loginUser.getUserName());
        article.setContent(content);
        article.setModuleId(Integer.valueOf(moduleId));
        Result result = articleService.addArticle(article);
        return result;
    }
}
