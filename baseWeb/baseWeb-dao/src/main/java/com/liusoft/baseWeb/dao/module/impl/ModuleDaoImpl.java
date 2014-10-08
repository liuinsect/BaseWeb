package com.liusoft.baseWeb.dao.module.impl;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.module.Module;
import com.liusoft.baseWeb.dao.module.ModuleDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


/**
 * ModuleDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-02 22:49:18
 *
 */
@Component
public class ModuleDaoImpl extends SqlSessionDaoSupport implements ModuleDao {

    private static final String ADD = "Module.add";
    private static final String UPDATE = "Module.update";
    private static final String DELETE = "Module.delete";
    private static final String GET_BY_EXAMPLE = "Module.getByExample";
    private static final String GET_BY_ID = "Module.getById";
    private static final String GET_BY_PAGE = "Module.getByPage";
    private static final String COUNT = "Module.count";

    private static final String GET_ALL = "Module.geAll";
    
    public Module addModule(Module module) {
    	this.getSqlSession().insert(ADD, module);
    	return module;
    }
    
    public void updateModule(Module module) {
    	this.getSqlSession().update(UPDATE, module);
    }
    
    public void deleteModule(Integer id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<Module> getListByExample(Module module) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, module);
    }
    
    public Module getModuleById(Integer id) {
    	return (Module) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<Module> getModuleByPage(PageQuery pageQuery) {
        int total = this.count(pageQuery);
        pageQuery.setTotalCount(total);
    	return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }

    @Override
    public List<Module> getAllModule() {
        return this.getSqlSession().selectList(GET_ALL);
    }

}