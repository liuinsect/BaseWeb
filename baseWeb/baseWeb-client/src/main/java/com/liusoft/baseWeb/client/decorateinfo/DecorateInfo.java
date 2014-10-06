/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.client.decorateinfo.DecorateInfo.java
 */
package com.liusoft.baseWeb.client.decorateinfo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author liukunyang
 * @date 2014-10-06 16:39:52
 *
 *
 */
public class DecorateInfo implements Serializable {

    /**
     *
     */
    private Integer id;

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
    private String author;

    /**
     *
     */
    private Integer authorId;

    /**
     *
     */
    private Timestamp createTime;

    /**
     *
     */
    private Integer userId;


    private String userName;


    public DecorateInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}