/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.article..impl.ArticleDaoImpl.java
 */
package com.liusoft.baseWeb.dao.article.impl;

import java.util.List;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.dao.article.ArticleDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

/**
 * ArticleDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:31:06
 *
 */
@Component
public class ArticleDaoImpl extends SqlSessionDaoSupport implements ArticleDao {

    private static final String ADD = "Article.add";
    private static final String UPDATE = "Article.update";
    private static final String DELETE = "Article.delete";
    private static final String GET_BY_EXAMPLE = "Article.getByExample";
    private static final String GET_BY_ID = "Article.getById";
    private static final String GET_BY_PAGE = "Article.getByPage";
    private static final String COUNT = "Article.count";
    
    public Article addArticle(Article article) {
    	this.getSqlSession().insert(ADD, article);
    	return article;
    }
    
    public void updateArticle(Article article) {
    	this.getSqlSession().update(UPDATE, article);
    }
    
    public void deleteArticle(String id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<Article> getListByExample(Article article) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, article);
    }
    
    public Article getArticleById(String id) {
    	return (Article) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<Article> getArticleByPage(PageQuery pageQuery) {
        int total = this.count(pageQuery);
        pageQuery.setTotalCount(total);
    	return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }
	
}