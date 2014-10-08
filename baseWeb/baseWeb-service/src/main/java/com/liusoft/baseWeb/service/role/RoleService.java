package com.liusoft.baseWeb.service.role;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.role.Role;

/**
 * RoleService接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:30:51
 *
 */
public interface RoleService {

    /**
     * 添加并返回设置id的Role对象
     * 
     * @param role
     * @return
     */
    public Result addRole(Role role);
    
	/**
     * 更新Role
     * 
     * @param role
     */
    public Result updateRole(Role role);
    
	 /**
     * 根据主键删除Role
     * 
     * @param id
     */
    public Result deleteRole(Integer id);
    
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
    public Result getRoleByPage(PageQuery pageQuery);

    /**
     * 取得Role列表
     *
     * @return
     */
    public Result getAllRole();
	
}