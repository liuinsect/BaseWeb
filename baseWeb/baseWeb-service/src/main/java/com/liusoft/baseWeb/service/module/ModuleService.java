/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.module.ModuleService.java
 */
package com.liusoft.baseWeb.service.module;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.module.Module;

/**
 * ModuleService接口
 * 
 * @author liukunyang
 * @date 2014-10-02 22:49:18
 *
 */
public interface ModuleService {

    /**
     * 添加并返回设置id的Module对象
     * 
     * @param module
     * @return
     */
    public Result addModule(Module module);
    
	/**
     * 更新Module
     * 
     * @param module
     */
    public Result updateModule(Module module);
    
	 /**
     * 根据主键删除Module
     * 
     * @param id
     */
    public Result deleteModule(Integer id);
    
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
    public Result getModuleByPage(PageQuery pageQuery);

    public Result getAllModule();
	
}