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
        user = userDao.addUser(user);
        result.addDefaultModel("user",user);
        result.setSuccess(true);
		return result;
	}
	
	public Result updateUser(User user) {
		Result result = new Result();
        userDao.updateUser(user);
        result.setSuccess(true);
		return result;
	}
	
	public Result deleteUser(Integer id) {
		Result result = new Result();
        userDao.deleteUser(id);
        result.setSuccess(true);
		return result;
    }
	
	public List<User> getListByExample(User user) {
        return userDao.getListByExample(user);
	}
	
	public Result getUserById(Integer id) {
        Result result = new Result();
        User user = userDao.getUserById(id);
        result.addDefaultModel("user",user);
        result.setSuccess(true);
		return result;
	}
	
	public Result getUserByPage(PageQuery pageQuery) {
		Result result = new Result();
        List<User> userList = userDao.getUserByPage(pageQuery);
        result.addDefaultModel("userList",userList);
        result.addDefaultModel("pageQuery",pageQuery);
        result.setSuccess(true);
		return result;
	}
}