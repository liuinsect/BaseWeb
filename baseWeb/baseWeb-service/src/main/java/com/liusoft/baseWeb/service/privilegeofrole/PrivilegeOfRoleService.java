/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.privilegeofrole.PrivilegeOfRoleService.java
 */
package com.liusoft.baseWeb.service.privilegeofrole;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.privilegeofrole.PrivilegeOfRole;

/**
 * PrivilegeOfRoleService接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:34
 *
 */
public interface PrivilegeOfRoleService {

    /**
     * 添加并返回设置id的PrivilegeOfRole对象
     * 
     * @param privilegeOfRole
     * @return
     */
    public Result addPrivilegeOfRole(PrivilegeOfRole privilegeOfRole);
    
	/**
     * 更新PrivilegeOfRole
     * 
     * @param privilegeOfRole
     */
    public Result updatePrivilegeOfRole(PrivilegeOfRole privilegeOfRole);
    
	 /**
     * 根据主键删除PrivilegeOfRole
     * 
     * @param id
     */
    public Result deletePrivilegeOfRole(Integer id);
    
	/**
     * 根据example取得PrivilegeOfRole列表
     * 
     * @param  privilegeOfRole
     * @return
     */
    public List<PrivilegeOfRole> getListByExample(PrivilegeOfRole privilegeOfRole);
    
	/**
     * 根据主键获取PrivilegeOfRole
     * 
     * @param id
     * @return
     */	
    public PrivilegeOfRole getPrivilegeOfRoleById(Integer id);
    
	/**
     * 分页取得PrivilegeOfRole列表
     * 
     * @param pageQuery
     * @return
     */
    public Result getPrivilegeOfRoleByPage(PageQuery pageQuery);
	
}