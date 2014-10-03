/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.role..impl.RoleDaoImpl.java
 */
package com.liusoft.baseWeb.dao.role.impl;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.role.Role;
import com.liusoft.baseWeb.dao.role.RoleDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


/**
 * RoleDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:30:51
 *
 */
@Component
public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao {

    private static final String ADD = "Role.add";
    private static final String UPDATE = "Role.update";
    private static final String DELETE = "Role.delete";
    private static final String GET_BY_EXAMPLE = "Role.getByExample";
    private static final String GET_BY_ID = "Role.getById";
    private static final String GET_BY_PAGE = "Role.getByPage";
    private static final String COUNT = "Role.count";

    private static final String GET_ALL = "Role.getAll";
    
    public Role addRole(Role role) {
    	this.getSqlSession().insert(ADD, role);
    	return role;
    }
    
    public void updateRole(Role role) {
    	this.getSqlSession().update(UPDATE, role);
    }
    
    public void deleteRole(Integer id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<Role> getListByExample(Role role) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, role);
    }
    
    public Role getRoleById(Integer id) {
    	return (Role) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<Role> getRoleByPage(PageQuery pageQuery) {
    	return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }

    public List<Role> getAllRole() {
        return this.getSqlSession().selectList(GET_ALL);
    }

}