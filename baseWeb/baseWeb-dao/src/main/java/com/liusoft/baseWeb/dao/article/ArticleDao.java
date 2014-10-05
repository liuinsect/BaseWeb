/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.article.ArticleDao.java
 */
package com.liusoft.baseWeb.dao.article;

import java.util.List;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;

/**
 * ArticleDao接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:06
 *
 */
public interface ArticleDao {

    /**
     * 添加并返回设置id的Article对象
     * 
     * @param article
     * @return
     */
    public Article addArticle(Article article);
    
    /**
     * 更新Article
     * 
     * @param article
     */
    public void updateArticle(Article article);
    
	 /**
     * 根据主键删除Article
     * 
     * @param id
     */
    public void deleteArticle(String id);
    
	/**
     * 根据example取得Article列表
     * 
     * @param  article
     * @return
     */
    public List<Article> getListByExample(Article article);
    
	/**
     * 根据主键获取Article
     * 
     * @param id
     * @return
     */	
    public Article getArticleById(Integer id);
    
	/**
     * 分页取得Article列表
     * 
     * @param pageQuery
     * @return
     */
    public List<Article> getArticleByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);
	
}