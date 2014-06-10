package com.jd.gemini.dao.user;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.jd.gemini.User;

public class UserDao extends SqlSessionDaoSupport
{	
	
	/**
	 * 通过erp获取用户信息
	 * @return  String erpAccount
	 */
	public User  getUserByErp(Map<String,Object> query){
		return this.getSqlSession().selectOne("User.getUserErp",query);
	}
	
	/**
	 * 通过id获取用户信息
	 * @return  String id
	 */
	public User  getUserById(Map<String,Object> query){
		return this.getSqlSession().selectOne("User.getUserById",query);
	}
	
	/**
	 * 计数
	 * @return  String erpAccount
	 */
	public Integer  count(Map<String,Object> query){
		return this.getSqlSession().selectOne("User.count",query);
	}
	
	
	
	/**
	 * 获得所有用户列表
	 * @return
	 */
	public List<User> getUser(Map<String,Object> query){
		return this.getSqlSession().selectList("User.getUser",query);
	}
	
	/**
	 * 修改用户
	 * @param User
	 */
	public void modifyUser(User user) {
		this.getSqlSession().update("User.upDateUser", user);
	}

	/**
	 * 写入用户登陆时间
	 * @param String lastLoginTime、erpAccount
	 */
	public void modifyUserLoginTime(String erp) {
		this.getSqlSession().update("User.upDateUserLoginTime", erp);
	}

	/**
	 * 停用,启用用户
	 * @param String is_del、id
	 */
	public void changUserStat(Map<String,Object> query){
		this.getSqlSession().update("User.changUserStat",query);
	}
	
	/**
	 * 授权用户
	 * @param User
	 */
	public void addUser(User user){
		this.getSqlSession().insert("User.addUser",user);
	}
	
	public void addUserTestCount(String erp){
		this.getSqlSession().update("User.addCount", erp);
	}
}
