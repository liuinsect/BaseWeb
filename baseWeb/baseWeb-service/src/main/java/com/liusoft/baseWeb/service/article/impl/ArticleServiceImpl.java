
/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.article.impl.ArticleService.java
 */
package com.liusoft.baseWeb.service.article.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.service.article.ArticleService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;


/**
 * ArticleService接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:31:06
 *
 */
@Component
public class ArticleServiceImpl implements ArticleService {

	private static final Logger logger = Logger.getLogger(ArticleServiceImpl.class);
	

    public Result addArticle(Article article) {
		Result result = new Result();
		
		return result;
	}
	
	public Result updateArticle(Article article) {
		Result result = new Result();
		
		return result;
	}
	
	public Result deleteArticle(String id) {
		Result result = new Result();
		
		return result;
    }
	
	public List<Article> getListByExample(Article article) {
		
		
		return null;
	}
	
	public Article getArticleById(String id) {
		
		return null;
	}
	
	public Result getArticleByPage(PageQuery pageQuery) {
		Result result = new Result();
		
		return result;
	}
}