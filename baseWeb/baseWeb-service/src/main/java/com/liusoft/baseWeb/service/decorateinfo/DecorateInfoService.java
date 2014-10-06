/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.service.decorateinfo.DecorateInfoService.java
 */
package com.liusoft.baseWeb.service.decorateinfo;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;

import java.util.List;


/**
 * DecorateInfoService接口
 * 
 * @author liukunyang
 * @date 2014-10-06 15:10:07
 *
 */
public interface DecorateInfoService {

    /**
     * 添加并返回设置id的DecorateInfo对象
     * 
     * @param decorateInfo
     * @return
     */
    public Result addDecorateInfo(DecorateInfo decorateInfo);
    
	/**
     * 更新DecorateInfo
     * 
     * @param decorateInfo
     */
    public Result updateDecorateInfo(DecorateInfo decorateInfo);
    
	 /**
     * 根据主键删除DecorateInfo
     * 
     * @param id
     */
    public Result deleteDecorateInfo(Integer id);
    
	/**
     * 根据example取得DecorateInfo列表
     * 
     * @param  decorateInfo
     * @return
     */
    public Result getListByExample(DecorateInfo decorateInfo);
    
	/**
     * 根据主键获取DecorateInfo
     * 
     * @param id
     * @return
     */	
    public Result getDecorateInfoById(Integer id);
    
	/**
     * 分页取得DecorateInfo列表
     * 
     * @param pageQuery
     * @return
     */
    public Result getDecorateInfoByPage(PageQuery pageQuery);
	
}