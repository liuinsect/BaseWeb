/**
 * Copyright(c) 2004-2014 www.jd.com
 * com.jd.baseWeb.dao.decorateinfo..impl.DecorateInfoDaoImpl.java
 */
package com.liusoft.baseWeb.dao.decorateinfo.impl;

import java.util.List;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;
import com.liusoft.baseWeb.dao.decorateinfo.DecorateInfoDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;


/**
 * DecorateInfoDao接口实现
 *
 * @author liukunyang
 * @date 2014-10-06 15:10:07
 *
 */
@Component
public class DecorateInfoDaoImpl extends SqlSessionDaoSupport implements DecorateInfoDao {

    private static final String ADD = "DecorateInfo.add";
    private static final String UPDATE = "DecorateInfo.update";
    private static final String DELETE = "DecorateInfo.delete";
    private static final String GET_BY_EXAMPLE = "DecorateInfo.getByExample";
    private static final String GET_BY_ID = "DecorateInfo.getById";
    private static final String GET_BY_PAGE = "DecorateInfo.getByPage";
    private static final String COUNT = "DecorateInfo.count";
    
    public DecorateInfo addDecorateInfo(DecorateInfo decorateInfo) {
    	this.getSqlSession().insert(ADD, decorateInfo);
    	return decorateInfo;
    }
    
    public void updateDecorateInfo(DecorateInfo decorateInfo) {
    	this.getSqlSession().update(UPDATE, decorateInfo);
    }
    
    public void deleteDecorateInfo(Integer id) {
    	this.getSqlSession().update(DELETE, id);
    }
    	
    public List<DecorateInfo> getListByExample(DecorateInfo decorateInfo) {
    	return this.getSqlSession().selectList(GET_BY_EXAMPLE, decorateInfo);
    }
    
    public DecorateInfo getDecorateInfoById(Integer id) {
    	return (DecorateInfo) this.getSqlSession().selectOne(GET_BY_ID, id);
    }
    
    public List<DecorateInfo> getDecorateInfoByPage(PageQuery pageQuery) {
		int total = this.count(pageQuery);
        pageQuery.setTotalCount(total);
    	return this.getSqlSession().selectList(GET_BY_PAGE, pageQuery.getParams());
    }
    	
    public int count(PageQuery pageQuery) {
    	return ((Integer) this.getSqlSession().selectOne(COUNT, pageQuery.getParams())).intValue();
    }
	
}