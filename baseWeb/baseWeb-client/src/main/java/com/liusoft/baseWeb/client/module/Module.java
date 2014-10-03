/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.client.module.Module.java
 */
package com.liusoft.baseWeb.client.module;

import java.io.Serializable;

/**
 * 
 * @author liukunyang
 * @date 2014-10-02 22:49:18
 *
 *
 */
public class Module implements Serializable {

    /**
     * 
     */
	private Integer id;
	
    /**
     * 
     */
	private String name;
	
    /**
     * 
     */
	private String mark;
	
	
	public Module() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	

}