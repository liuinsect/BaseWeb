package com.liusoft.baseWeb.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.controller.common.BaseController;
import com.liusoft.baseWeb.service.decorateinfo.DecorateInfoService;
import com.liusoft.baseWeb.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * DecorateInfo Controller
 *
 * @author liukunyang
 * @date 2014-10-06 15:10:07
 *
 */
@Controller
@RequestMapping("/admin/decorateInfoManage")
public class DecorateInfoController extends BaseController {

    public static final String PREFIX = "admin/decorateInfoManage/";

    public static final String VIEW_PREFIX = "admin/decorateInfoView/";

	@Resource
    private DecorateInfoService decorateInfoService;

    @Resource
    private UserService userService;

    /**
     * 普通正常的配置
     */
    @RequestMapping(value="main.html")
    public ModelAndView main(HttpServletRequest request){
        Result result = new Result();
        User user = new User();
        user.setRoleId(3);
        List<User> userList = userService.getListByExample(user);
        result.addDefaultModel("userList",userList);
        return view(PREFIX +"main",result);
    }

    /**
     * 浏览主入口
     */
    @RequestMapping(value="viewMain.html")
    public ModelAndView viewMain(HttpServletRequest request){
        Result result = new Result();
        User loginUser = getLoginUser(request);
        result.addDefaultModel("loginUser",loginUser);
        return view(VIEW_PREFIX +"main",result);
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
        User loginUser = getLoginUser(request);
        pagequery.addQueryParam("authorId",loginUser.getUserId());
        Result result =  decorateInfoService.getDecorateInfoByPage(pagequery);
        return result;
    }

    @RequestMapping(value="viewSearch.html")
    @ResponseBody
    public Object viewSearch(HttpServletRequest request){
        PageQuery pagequery = convertPageQuery(request);
        Result result =  decorateInfoService.getDecorateInfoByPage(pagequery);
        return result;
    }

    @RequestMapping(value="contentEditor.html")
    public Object contentEditor(HttpServletRequest request){
        String decorateIdStr = request.getParameter("decorateInfoId");
        if( StringUtils.isNotBlank(decorateIdStr) ){
            Result result = decorateInfoService.getDecorateInfoById(Integer.valueOf(decorateIdStr));
            return view(PREFIX +"contentEditor",result);
        }

        return view(PREFIX +"contentEditor");
    }

    @RequestMapping(value="dialogAdd.html")
    public Object dialogAdd(HttpServletRequest request){
        Result result = new Result();
        User user = new User();
        user.setRoleId(3);
        List<User> userList = userService.getListByExample(user);
        result.addDefaultModel("userList",userList);
        return view(PREFIX +"dialogAdd",result);
    }

    @RequestMapping(value="dialogUpdate.html")
    public Object dialogUpdate(HttpServletRequest request){
        String decorateInfoIdStr = request.getParameter("decorateInfoId");
        Result result= decorateInfoService.getDecorateInfoById(Integer.valueOf(decorateInfoIdStr));

        User user = new User();
        user.setRoleId(3);
        List<User> userList = userService.getListByExample(user);
        result.addDefaultModel("userList",userList);
        return view(PREFIX +"dialogUpdate",result);
    }

    @RequestMapping(value="dialogView.html")
    public Object dialogView(HttpServletRequest request){
        String decorateInfoIdStr = request.getParameter("decorateInfoId");
        Result result= decorateInfoService.getDecorateInfoById(Integer.valueOf(decorateInfoIdStr));
        return view(VIEW_PREFIX +"dialogView",result);
    }

    @RequestMapping(value="addDecorate.html")
    @ResponseBody
    public Object addDecorate(HttpServletRequest request){
        String title = request.getParameter("title");
        String userId = request.getParameter("userId");
        String content = request.getParameter("content");

        User loginUser = getLoginUser(request);
        DecorateInfo decorateInfo = new DecorateInfo();
        decorateInfo.setTitle(title);
        decorateInfo.setAuthor(loginUser.getUserName());
        decorateInfo.setAuthorId(loginUser.getUserId());
        decorateInfo.setContent(content);
        decorateInfo.setUserId(Integer.valueOf(userId));
        Result result = decorateInfoService.addDecorateInfo(decorateInfo);
        return result;
    }

    @RequestMapping(value="updateDecorate.html")
    @ResponseBody
    public Object updateDecorate(HttpServletRequest request){
        String decorateIdStr = request.getParameter("decorateInfoId");
        String title = request.getParameter("title");
        String moduleId = request.getParameter("userId");
        String content = request.getParameter("content");

        User loginUser = getLoginUser(request);

        DecorateInfo decorateInfo = new DecorateInfo();
        decorateInfo.setTitle(title);
        decorateInfo.setAuthor(loginUser.getUserName());
        decorateInfo.setContent(content);
        decorateInfo.setUserId(Integer.valueOf(moduleId));
        decorateInfo.setId(Integer.valueOf(decorateIdStr));

        Result result = decorateInfoService.updateDecorateInfo(decorateInfo);
        return result;
    }

    @RequestMapping(value="delDecorate.html")
       @ResponseBody
       public Object delDecorate(HttpServletRequest request){
        String decorateIdStr = request.getParameter("decorateInfoId");
        if( StringUtils.isBlank( decorateIdStr ) ){
            Result result = new Result();
            result.setMessage("id错误");
            result.setSuccess(false);
            return result;
        }

        Result result = decorateInfoService.deleteDecorateInfo(Integer.valueOf(decorateIdStr));
        return result;

    }

    @RequestMapping(value="searchUser.html")
    @ResponseBody
    public Object searchUser(HttpServletRequest request){
        User user = new User();
        user.setRoleId(3); //TODO 写死了业主为type3的
        List<User> userList = userService.getListByExample(user);
        return userList;

    }


}