package com.liusoft.baseWeb.dao.module;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.module.Module;

/**
 * ModuleDao接口
 * 
 * @author liukunyang
 * @date 2014-10-02 22:49:18
 *
 */
public interface ModuleDao {

    /**
     * 添加并返回设置id的Module对象
     * 
     * @param module
     * @return
     */
    public Module addModule(Module module);
    
    /**
     * 更新Module
     * 
     * @param module
     */
    public void updateModule(Module module);
    
	 /**
     * 根据主键删除Module
     * 
     * @param id
     */
    public void deleteModule(Integer id);
    
	/**
     * 根据example取得Module列表
     * 
     * @param  module
     * @return
     */
    public List<Module> getListByExample(Module module);
    
	/**
     * 根据主键获取Module
     * 
     * @param id
     * @return
     */	
    public Module getModuleById(Integer id);
    
	/**
     * 分页取得Module列表
     * 
     * @param pageQuery
     * @return
     */
    public List<Module> getModuleByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);

    public List<Module> getAllModule();
}