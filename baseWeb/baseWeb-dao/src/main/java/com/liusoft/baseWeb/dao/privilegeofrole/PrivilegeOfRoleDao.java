package com.liusoft.baseWeb.dao.privilegeofrole;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.privilegeofrole.PrivilegeOfRole;

/**
 * PrivilegeOfRoleDao接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:31:34
 *
 */
public interface PrivilegeOfRoleDao {

    /**
     * 添加并返回设置id的PrivilegeOfRole对象
     * 
     * @param privilegeOfRole
     * @return
     */
    public PrivilegeOfRole addPrivilegeOfRole(PrivilegeOfRole privilegeOfRole);
    
    /**
     * 更新PrivilegeOfRole
     * 
     * @param privilegeOfRole
     */
    public void updatePrivilegeOfRole(PrivilegeOfRole privilegeOfRole);
    
	 /**
     * 根据主键删除PrivilegeOfRole
     * 
     * @param id
     */
    public void deletePrivilegeOfRole(Integer id);
    
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
    public List<PrivilegeOfRole> getPrivilegeOfRoleByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);
	
}