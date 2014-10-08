package com.liusoft.baseWeb.dao.decorateinfo;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;

/**
 * DecorateInfoDao接口
 * 
 * @author liukunyang
 * @date 2014-10-06 15:10:07
 *
 */
public interface DecorateInfoDao {

    /**
     * 添加并返回设置id的DecorateInfo对象
     * 
     * @param decorateInfo
     * @return
     */
    public DecorateInfo addDecorateInfo(DecorateInfo decorateInfo);
    
    /**
     * 更新DecorateInfo
     * 
     * @param decorateInfo
     */
    public void updateDecorateInfo(DecorateInfo decorateInfo);
    
	 /**
     * 根据主键删除DecorateInfo
     * 
     * @param id
     */
    public void deleteDecorateInfo(Integer id);
    
	/**
     * 根据example取得DecorateInfo列表
     * 
     * @param  decorateInfo
     * @return
     */
    public List<DecorateInfo> getListByExample(DecorateInfo decorateInfo);
    
	/**
     * 根据主键获取DecorateInfo
     * 
     * @param id
     * @return
     */	
    public DecorateInfo getDecorateInfoById(Integer id);
    
	/**
     * 分页取得DecorateInfo列表
     * 
     * @param pageQuery
     * @return
     */
    public List<DecorateInfo> getDecorateInfoByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);
	
}