
/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.role.impl.RoleService.java
 */
package com.liusoft.baseWeb.service.role.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.role.Role;
import com.liusoft.baseWeb.dao.role.RoleDao;
import com.liusoft.baseWeb.service.role.RoleService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;


/**
 * RoleService接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:30:51
 *
 */
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	

    @Resource
    private RoleDao roleDao;

    public Result addRole(Role role) {
		Result result = new Result();
		
		return result;
	}
	
	public Result updateRole(Role role) {
		Result result = new Result();
		
		return result;
	}
	
	public Result deleteRole(Integer id) {
		Result result = new Result();
		
		return result;
    }
	
	public List<Role> getListByExample(Role role) {
		
		
		return null;
	}
	
	public Role getRoleById(Integer id) {
		
		return null;
	}
	
	public Result getRoleByPage(PageQuery pageQuery) {
		Result result = new Result();
		
		return result;
	}

    @Override
    public Result getAllRole() {
        Result result = new Result();
        List<Role> roleList = roleDao.getAllRole();
        result.addDefaultModel("roleList",roleList);
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
}