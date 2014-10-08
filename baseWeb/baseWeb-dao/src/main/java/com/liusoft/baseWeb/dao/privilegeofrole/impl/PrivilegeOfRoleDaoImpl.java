package com.liusoft.baseWeb.dao.privilegeofrole.impl;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.privilegeofrole.PrivilegeOfRole;
import com.liusoft.baseWeb.dao.privilegeofrole.PrivilegeOfRoleDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


/**
 * PrivilegeOfRoleDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:31:34
 *
 */
@Component
public class PrivilegeOfRoleDaoImpl extends SqlSessionDaoSupport implements PrivilegeOfRoleDao {

    private static final String ADD = "PrivilegeOfRole.add";
    private static final String UPDATE = "PrivilegeOfRole.update";
    private static final String DELETE = "PrivilegeOfRole.delete";
    private static final String GET_BY_EXAMPLE = "PrivilegeOfRole.getByExample";
    private static final String GET_BY_ID = "PrivilegeOfRole.getById";
    private static final String GET_BY_PAGE = "PrivilegeOfRole.getByPage";
    private static final String COUNT = "PrivilegeOfRole.count";
    
    public PrivilegeOfRole addPrivilegeOfRole(PrivilegeOfRole privilegeOfRole) {
    	this.getSqlSession().insert(ADD, privilegeOfRole);
    	return privilegeOfRole;
    }
    
    public void updatePrivilegeOfRole(PrivilegeOfRole privilegeOfRole) {
    	this.getSqlSession().update(UPDATE, privilegeOfRole);
    }
    
    public void deletePrivilegeOfRole(Integer id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<PrivilegeOfRole> getListByExample(PrivilegeOfRole privilegeOfRole) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, privilegeOfRole);
    }
    
    public PrivilegeOfRole getPrivilegeOfRoleById(Integer id) {
    	return (PrivilegeOfRole) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<PrivilegeOfRole> getPrivilegeOfRoleByPage(PageQuery pageQuery) {
    	return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }
	
}