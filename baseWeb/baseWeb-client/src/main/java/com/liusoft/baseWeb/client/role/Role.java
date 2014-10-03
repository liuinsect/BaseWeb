/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.client.role.Role.java
 */
package com.liusoft.baseWeb.client.role;

import java.io.Serializable;

/**
 * 
 * @author liukunyang
 * @date 2014-10-03 10:30:51
 *
 *
 */
public class Role implements Serializable {

    /**
     * 
     */
	private Integer id;
	
    /**
     * 
     */
	private String roleName;
	
	
	public Role() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}