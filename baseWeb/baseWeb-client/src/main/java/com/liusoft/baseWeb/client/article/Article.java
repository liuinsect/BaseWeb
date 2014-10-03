/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.client.article.Article.java
 */
package com.liusoft.baseWeb.client.article;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:06
 *
 *
 */
public class Article implements Serializable {

    /**
     * 
     */
	private String id;
	
    /**
     * 
     */
	private String title;
	
    /**
     * 
     */
	private String content;
	
    /**
     * 
     */
	private Long clickNum;
	
    /**
     * 
     */
	private String author;
	
    /**
     * 
     */
	private Timestamp createTime;
	
    /**
     * 
     */
	private String moduleId;
	
	
	public Article() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getClickNum() {
		return clickNum;
	}
	
	public void setClickNum(Long clickNum) {
		this.clickNum = clickNum;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public String getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	

}