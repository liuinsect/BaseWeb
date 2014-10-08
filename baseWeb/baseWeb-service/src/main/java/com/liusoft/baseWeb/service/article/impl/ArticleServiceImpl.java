package com.liusoft.baseWeb.service.article.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.util.StringUtils;
import com.liusoft.baseWeb.dao.article.ArticleDao;
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
public class ArticleServiceImpl implements ArticleService {

	private static final Logger logger = Logger.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;

    public Result addArticle(Article article) {
		Result result = new Result();
        article = articleDao.addArticle(article);
        result.addDefaultModel("article",article);
        result.setSuccess(true);
		return result;
	}
	
	public Result updateArticle(Article article) {
		Result result = new Result();

        Article old = articleDao.getArticleById(article.getId());

        old.setContent(article.getContent());
        if( StringUtils.isNotBlank( article.getTitle() ) ){
            old.setTitle(article.getTitle());
        }

        old.setModuleId(article.getModuleId());
        old.setModuleName(null);
        old.setAuthor(article.getAuthor());

        articleDao.updateArticle(old);
        result.setSuccess(true);
		return result;
	}
	
	public Result deleteArticle(Integer id) {
		Result result = new Result();
        articleDao.deleteArticle(id);
        result.setSuccess(true);
		return result;
    }
	
	public List<Article> getListByExample(Article article) {
		return  articleDao.getListByExample(article);
	}
	
	public Result getArticleById(Integer id) {
        Result result = new Result();
        Article article = articleDao.getArticleById(id);
        result.addDefaultModel("article",article);
        result.setSuccess(true);
        return result;
	}
	
	public Result getArticleByPage(PageQuery pageQuery) {
		Result result = new Result();
        List<Article> articleList = articleDao.getArticleByPage(pageQuery);
        result.addDefaultModel("articleList",articleList);
        result.addDefaultModel("pageQuery",pageQuery);
        result.setSuccess(true);
		return result;
	}
}