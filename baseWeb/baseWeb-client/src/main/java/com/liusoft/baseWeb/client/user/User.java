/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.client.user.User.java
 */
package com.liusoft.baseWeb.client.user;

import java.io.Serializable;

/**
 * 
 * @author liukunyang
 * @date 2014-10-03 10:29:17
 *
 *
 */
public class User implements Serializable {

    /**
     * 用户ID
     */
	private Integer userId;
	
    /**
     * 用户名称
     */
	private String userName;
	
    /**
     * 账号
     */
	private String account;
	
    /**
     * 密码
     */
	private String password;
	
    /**
     * 
     */
	private Integer roleId;
	
	
	public User() {
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
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }

}