package com.liusoft.baseWeb.controller.foreground;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.module.Module;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.article.ArticleService;
import com.liusoft.baseWeb.service.module.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-10-7
 * Time: 下午12:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class ViewController extends BaseController{

    public static final String PREFIX = "foreground/";

    @Resource
    private ModuleService moduleService;

    @Resource
    private ArticleService articleService;

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="index.html",method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request){
        Result result = moduleService.getAllModule();
        if( result.isSuccess() ){

            List<Module> moduleList = (List<Module>) result.get("modulelist");

            for(Module module : moduleList){
                PageQuery pageQuery = new PageQuery();
                pageQuery.setCurrentPageNo(1);
                pageQuery.setPageSize(4);
                pageQuery.addQueryParam("moduleId",module.getId());
                Result innerResult = articleService.getArticleByPage(pageQuery);
                result.addDefaultModel(module.getMark(),innerResult.get("articleList"));
            }


        }

        return view(PREFIX+"index",result);
    }

    @RequestMapping(value="list.html",method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request){
        String moduleIdStr = request.getParameter("moduleId");
        Result resullt = new Result();
        if(StringUtils.isNotBlank(moduleIdStr)){
            Module module = moduleService.getModuleById(Integer.valueOf(moduleIdStr));
            resullt.addDefaultModel("module",module);
        }

        return view(PREFIX+"list",resullt);
    }

    @RequestMapping(value="listContent.html")
    @ResponseBody
    public Object listContent(HttpServletRequest request){
        PageQuery pageQuery = convertPageQuery(request);
        Result result = new Result();
        if( pageQuery != null ){
            result = articleService.getArticleByPage(pageQuery);
        }

        return result;
    }

    @RequestMapping(value="content.html")
    public ModelAndView content(HttpServletRequest request){
         String articleIdStr = request.getParameter("articleId");

        if(StringUtils.isNotBlank(articleIdStr)){
            Result result = articleService.getArticleById(Integer.valueOf(articleIdStr));
            return view(PREFIX+"content",result);
        }
        return view(PREFIX+"content");
    }

}
