/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.role.RoleDao.java
 */
package com.liusoft.baseWeb.dao.role;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.role.Role;

/**
 * RoleDao接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:30:51
 *
 */
public interface RoleDao {

    /**
     * 添加并返回设置id的Role对象
     * 
     * @param role
     * @return
     */
    public Role addRole(Role role);
    
    /**
     * 更新Role
     * 
     * @param role
     */
    public void updateRole(Role role);
    
	 /**
     * 根据主键删除Role
     * 
     * @param id
     */
    public void deleteRole(Integer id);
    
	/**
     * 根据example取得Role列表
     * 
     * @param  role
     * @return
     */
    public List<Role> getListByExample(Role role);
    
	/**
     * 根据主键获取Role
     * 
     * @param id
     * @return
     */	
    public Role getRoleById(Integer id);
    
	/**
     * 分页取得Role列表
     * 
     * @param pageQuery
     * @return
     */
    public List<Role> getRoleByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);


    public List<Role> getAllRole();
}