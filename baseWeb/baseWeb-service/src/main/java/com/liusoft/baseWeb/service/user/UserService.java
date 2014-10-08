package com.liusoft.baseWeb.service.user;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.user.User;

/**
 * UserService接口
 * 
 * @author liukunyang
 * @date 2014-10-03 10:29:17
 *
 */
public interface UserService {

    /**
     * 添加并返回设置id的User对象
     * 
     * @param user
     * @return
     */
    public Result addUser(User user);
    
	/**
     * 更新User
     * 
     * @param user
     */
    public Result updateUser(User user);
    
	 /**
     * 根据主键删除User
     * 
     * @param id
     */
    public Result deleteUser(Integer id);
    
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
    public Result getUserById(Integer id);
    
	/**
     * 分页取得User列表
     * 
     * @param pageQuery
     * @return
     */
    public Result getUserByPage(PageQuery pageQuery);
	
}