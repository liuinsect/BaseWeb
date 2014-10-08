package com.liusoft.baseWeb.client.privilegeofrole;

import java.io.Serializable;

/**
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:34
 *
 *
 */
public class PrivilegeOfRole implements Serializable {

    /**
     * 
     */
	private Integer id;
	
    /**
     * 
     */
	private Integer roleId;
	
    /**
     * 
     */
	private Integer moduleId;
	
    /**
     * 
     */
	private Integer canAdd;
	
    /**
     * 
     */
	private Integer canModify;
	
    /**
     * 
     */
	private Integer canDelete;
	
	
	public PrivilegeOfRole() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	public Integer getCanAdd() {
		return canAdd;
	}
	
	public void setCanAdd(Integer canAdd) {
		this.canAdd = canAdd;
	}
	
	public Integer getCanModify() {
		return canModify;
	}
	
	public void setCanModify(Integer canModify) {
		this.canModify = canModify;
	}
	
	public Integer getCanDelete() {
		return canDelete;
	}
	
	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}
	

}