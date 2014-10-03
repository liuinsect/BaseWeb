
/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.user.impl.UserService.java
 */
package com.liusoft.baseWeb.service.user.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.dao.user.UserDao;
import com.liusoft.baseWeb.service.user.UserService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;



/**
 * UserService接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:29:17
 *
 */
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    public Result addUser(User user) {
		Result result = new Result();
		
		return result;
	}
	
	public Result updateUser(User user) {
		Result result = new Result();
		
		return result;
	}
	
	public Result deleteUser(Integer id) {
		Result result = new Result();
		
		return result;
    }
	
	public List<User> getListByExample(User user) {
        return userDao.getListByExample(user);
	}
	
	public User getUserById(Integer id) {
		
		return null;
	}
	
	public Result getUserByPage(PageQuery pageQuery) {
		Result result = new Result();
		
		return result;
	}
}