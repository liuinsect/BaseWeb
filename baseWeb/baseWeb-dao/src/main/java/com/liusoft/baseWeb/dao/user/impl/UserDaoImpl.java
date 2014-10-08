package com.liusoft.baseWeb.dao.user.impl;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.dao.user.UserDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


/**
 * UserDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:29:17
 *
 */
@Component
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String ADD = "User.add";
    private static final String UPDATE = "User.update";
    private static final String DELETE = "User.delete";
    private static final String GET_BY_EXAMPLE = "User.getByExample";
    private static final String GET_BY_ID = "User.getById";
    private static final String GET_BY_PAGE = "User.getByPage";
    private static final String COUNT = "User.count";
    
    public User addUser(User user) {
    	this.getSqlSession().insert(ADD, user);
    	return user;
    }
    
    public void updateUser(User user) {
    	this.getSqlSession().update(UPDATE, user);
    }
    
    public void deleteUser(Integer id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<User> getListByExample(User user) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, user);
    }
    
    public User getUserById(Integer id) {
    	return (User) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<User> getUserByPage(PageQuery pageQuery) {
        int total = count(pageQuery);
        pageQuery.setTotalCount(total);
        return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }
	
}