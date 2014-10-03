/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.user.UserDao.java
 */
package com.liusoft.baseWeb.dao.user;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.user.User;

/**
 * UserDao接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:29:17
 *
 */
public interface UserDao {

    /**
     * 添加并返回设置id的User对象
     * 
     * @param user
     * @return
     */
    public User addUser(User user);
    
    /**
     * 更新User
     * 
     * @param user
     */
    public void updateUser(User user);
    
	 /**
     * 根据主键删除User
     * 
     * @param id
     */
    public void deleteUser(Integer id);
    
	/**
     * 根据example取得User列表
     * 
     * @param  user
     * @return
     */
    public List<User> getListByExample(User user);
    
	/**
     * 根据主键获取User
     * 
     * @param id
     * @return
     */	
    public User getUserById(Integer id);
    
	/**
     * 分页取得User列表
     * 
     * @param pageQuery
     * @return
     */
    public List<User> getUserByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);
	
}