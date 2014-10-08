package com.liusoft.baseWeb.service.article;

import java.util.List;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;

/**
 * ArticleService接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:06
 *
 */
public interface ArticleService {

    /**
     * 添加并返回设置id的Article对象
     * 
     * @param article
     * @return
     */
    public Result addArticle(Article article);
    
	/**
     * 更新Article
     * 
     * @param article
     */
    public Result updateArticle(Article article);
    
	 /**
     * 根据主键删除Article
     * 
     * @param id
     */
    public Result deleteArticle(Integer id);
    
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
    public Result getArticleById(Integer id);
    
	/**
     * 分页取得Article列表
     * 
     * @param pageQuery
     * @return
     */
    public Result getArticleByPage(PageQuery pageQuery);
	
}