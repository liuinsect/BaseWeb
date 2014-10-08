package com.liusoft.baseWeb.client.article;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
	private int id;
	
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
	private Date createTime;
	
    /**
     * 
     */
	private int moduleId;


    /**
     *
     */
    private String moduleName;
	
	
	public Article() {
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", clickNum=" + clickNum +
                ", createTime=" + createTime +
                ", moduleId=" + moduleId +
                ", moduleName=" + moduleName +
                '}';
    }

}