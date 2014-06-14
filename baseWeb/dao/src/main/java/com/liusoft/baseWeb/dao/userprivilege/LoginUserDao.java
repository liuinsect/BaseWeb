package com.liusoft.baseWeb.dao.userprivilege;

import com.liusoft.userprivilege.LoginUser;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Map;


public class LoginUserDao extends SqlSessionDaoSupport
{


	/**
	 * 通过id获取用户信息
	 * @return  String id
	 */
	public LoginUser getUserById(Long userId){

        return this.getSqlSession().selectOne("LoginUser.getUserById",userId);
	}


//
//
//	/**
//	 * 获得所有用户列表
//	 * @return
//	 */
//	public List<LoginUser> getUser(Map<String,Object> query){
//		return this.getSqlSession().selectList("User.getUser",query);
//	}
//
//	/**
//	 * 修改用户
//	 * @param User
//	 */
//	public void modifyUser(User user) {
//		this.getSqlSession().update("User.upDateUser", user);
//	}
//
//	/**
//	 * 写入用户登陆时间
//	 * @param String lastLoginTime、erpAccount
//	 */
//	public void modifyUserLoginTime(String erp) {
//		this.getSqlSession().update("User.upDateUserLoginTime", erp);
//	}
//
//	/**
//	 * 停用,启用用户
//	 * @param String is_del、id
//	 */
//	public void changUserStat(Map<String,Object> query){
//		this.getSqlSession().update("User.changUserStat",query);
//	}
//
//	/**
//	 * 授权用户
//	 * @param User
//	 */
//	public void addUser(User user){
//		this.getSqlSession().insert("User.addUser",user);
//	}
//
//	public void addUserTestCount(String erp){
//		this.getSqlSession().update("User.addCount", erp);
//	}
}
