package com.liusoft.baseWeb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * gemini基础拦截器
 * 扩展spring mvc中 拦截器无法过滤URL的功能
 * @author liukunyang
 *
 */
public abstract class BaseInterceptor implements HandlerInterceptor{
	
	/**
	 * 排除掉的interceptor
	 */
	protected List<String> excludedUrls;
	

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = new CopyOnWriteArrayList<String>(excludedUrls);
	}
	
	
}
