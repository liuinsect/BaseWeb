
package com.liusoft.baseWeb.service.privilegeofrole.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.privilegeofrole.PrivilegeOfRole;
import com.liusoft.baseWeb.service.privilegeofrole.PrivilegeOfRoleService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;


/**
 * PrivilegeOfRoleService接口实现
 *
 * @author liukunyang
 * @date 2014-10-03 10:31:35
 *
 */
@Component
public class PrivilegeOfRoleServiceImpl implements PrivilegeOfRoleService {

	private static final Logger logger = Logger.getLogger(PrivilegeOfRoleServiceImpl.class);
	

    public Result addPrivilegeOfRole(PrivilegeOfRole privilegeOfRole) {
		Result result = new Result();
		
		return result;
	}
	
	public Result updatePrivilegeOfRole(PrivilegeOfRole privilegeOfRole) {
		Result result = new Result();
		
		return result;
	}
	
	public Result deletePrivilegeOfRole(Integer id) {
		Result result = new Result();
		
		return result;
    }
	
	public List<PrivilegeOfRole> getListByExample(PrivilegeOfRole privilegeOfRole) {
		
		
		return null;
	}
	
	public PrivilegeOfRole getPrivilegeOfRoleById(Integer id) {
		
		return null;
	}
	
	public Result getPrivilegeOfRoleByPage(PageQuery pageQuery) {
		Result result = new Result();
		
		return result;
	}
}