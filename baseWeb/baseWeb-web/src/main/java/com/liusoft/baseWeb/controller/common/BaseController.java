package com.liusoft.baseWeb.controller.common;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.constant.SystemConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * gemini基础controller 
* @Package com.jd.gemini.controller 
* @author liukunyang
* @date 2013-10-11 下午06:15:34 
* @version V1.0
 */
public class BaseController {
	
	public static final String ADMIN = "admin";
	
	public static final String INDEX = "index";
	
	public static final String LOGIN_NO_AUTH = "loginNoAuth";
	

	/**
	 * 返回参数错误的Result
	 * @return
	 */
	public Result returnParamErrorResult(){
		return returnFailResult( SystemConstant.INVALIDATE_PARAM);
	}
	
	/**
	 * 返回含有错误信息的Result
	 * @param errorMsg
	 * @return
	 */
	public Result returnFailResult(String errorMsg){
		Result result = new Result();
		result.setSuccess(false);
		result.setMessage(errorMsg);
		return result;
	}
	

	/**
	 * 将请求参数里面的分页信息转化到PageQuery中去
	 * @param request
	 * @return
	 */
	public PageQuery convertPageQuery(HttpServletRequest request){
		PageQuery pageQuery = new PageQuery();

        //

        for (Iterator i = request.getParameterMap().entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<String,String[]> e = (Map.Entry)i.next();
            String key = e.getKey();
            String[] valueArray = e.getValue();
             if( valueArray.length > 0 && StringUtils.isNotBlank( valueArray[0] ) ){
                 pageQuery.addQueryParam(key,valueArray[0]);
             }
        }


		//当前页
		String currentPageNo = request.getParameter("page");
		if( StringUtils.isBlank(currentPageNo)){
			pageQuery.setCurrentPageNo(0);
		}else{
			pageQuery.setCurrentPageNo( new Integer(currentPageNo) );
		}
		//页大小
		String pageSize = request.getParameter("pageSize");
		if( StringUtils.isNotBlank(pageSize)){
			pageQuery.setPageSize( new Integer(pageSize) );
		}
		return pageQuery;
	}
	
	/**
	 * 返回简单msg
	 * @author liukunyang
	 * @date 2013-10-11	
	 * @param viewName
	 * @param param
	 * @return
	 */
	public ModelAndView returnMessage(String viewName,Object param){
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("message",param);
		return mv;
	}
	
	/**
	 * 返回到VM页面
	 * @param viewName
	 * @return
	 */
	public ModelAndView view(String viewName){
		ModelAndView mv = new ModelAndView(viewName);
		return mv;
	}
	
	/**
	 * 返回到VM页面
	 * @param viewName
	 * @return
	 */
	public ModelAndView view(String viewName , Result result){
		ModelAndView mv = new ModelAndView(viewName);
		Map<String, Object> o = result.getResult();
		for (Map.Entry<String, Object> entry : o.entrySet()) {
			mv.addObject(entry.getKey(), entry.getValue());
		}
		return mv;
	}


    /**
     * 返回标准的modelAndView
     * @author liukunyang
     * @date 2013-10-11
     * @param viewName
     * @param returnParam
     * @return
     */
    public ModelAndView view(String viewName,Map<String,?> returnParam){
        ModelAndView mv = new ModelAndView(viewName);
        mv.addAllObjects(returnParam);
        return mv;
    }


    /**
	 * 重定向
	 * @param viewName
	 * @return
	 */
	public ModelAndView redirect(String viewName){
		ModelAndView mv = new ModelAndView("redirect:"+viewName);
		return mv;
	}
	
}
