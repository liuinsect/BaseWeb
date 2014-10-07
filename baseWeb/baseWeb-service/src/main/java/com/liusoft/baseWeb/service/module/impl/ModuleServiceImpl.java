
/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.module.impl.ModuleService.java
 */
package com.liusoft.baseWeb.service.module.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.module.Module;
import com.liusoft.baseWeb.dao.module.ModuleDao;
import com.liusoft.baseWeb.service.module.ModuleService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

/**
 * ModuleService接口实现
 *
 * @author liukunyang
 * @date 2014-10-02 22:49:18
 *
 */
@Component
public class ModuleServiceImpl implements ModuleService {

	private static final Logger logger = Logger.getLogger(ModuleServiceImpl.class);

    @Resource
    private ModuleDao moduleDao;

    public Result addModule(Module module) {
		Result result = new Result();
		
		return result;
	}
	
	public Result updateModule(Module module) {
		Result result = new Result();
		
		return result;
	}
	
	public Result deleteModule(Integer id) {
		Result result = new Result();
		
		return result;
    }
	
	public Result getListByExample(Module module) {
		
		
		return null;
	}
	
	public Module getModuleById(Integer id) {
		
		return moduleDao.getModuleById(id);
	}
	
	public Result getModuleByPage(PageQuery pageQuery) {
		Result result = new Result();
		return result;
	}

    @Override
    public Result getAllModule() {
        Result result = new Result();
        List<Module> modulelist = moduleDao.getAllModule();
        result.addDefaultModel("modulelist",modulelist);
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
}