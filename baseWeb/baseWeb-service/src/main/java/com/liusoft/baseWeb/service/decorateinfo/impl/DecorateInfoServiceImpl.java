package com.liusoft.baseWeb.service.decorateinfo.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.common.Result;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;
import com.liusoft.baseWeb.dao.decorateinfo.DecorateInfoDao;
import com.liusoft.baseWeb.service.decorateinfo.DecorateInfoService;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

/**
 * DecorateInfoService接口实现
 *
 * @author liukunyang
 * @date 2014-10-06 15:10:07
 *
 */
@Component
public class DecorateInfoServiceImpl implements DecorateInfoService {

	private static final Logger logger = Logger.getLogger(DecorateInfoServiceImpl.class);
	
	@Resource
	private DecorateInfoDao decorateInfoDao;
    
    public Result addDecorateInfo(DecorateInfo decorateInfo) {
		Result result = new Result();
        decorateInfoDao.addDecorateInfo(decorateInfo);
        result.addDefaultModel("decorateInfo",decorateInfo);
        result.setSuccess(true);
		return result;
	}
	
	public Result updateDecorateInfo(DecorateInfo decorateInfo) {
		Result result = new Result();
        decorateInfoDao.updateDecorateInfo(decorateInfo);
        result.setSuccess(true);
		return result;
	}
	
	public Result deleteDecorateInfo(Integer id) {
		Result result = new Result();
        decorateInfoDao.deleteDecorateInfo(id);
        result.setSuccess(true);
		return result;
    }
	
	public Result getListByExample(DecorateInfo decorateInfo) {
        Result result = new Result();
        List<DecorateInfo> decorateInfoList = decorateInfoDao.getListByExample(decorateInfo);
        result.addDefaultModel("decorateInfoList",decorateInfoList);
        result.setSuccess(true);
		return result;
	}
	
	public Result getDecorateInfoById(Integer id) {
        Result result = new Result();
        DecorateInfo decorateInfo = decorateInfoDao.getDecorateInfoById(id);
        result.addDefaultModel("decorateInfo",decorateInfo);
        result.setSuccess(true);
		return result;
	}
	
	public Result getDecorateInfoByPage(PageQuery pageQuery) {
        Result result = new Result();
        List<DecorateInfo> decorateInfoList = decorateInfoDao.getDecorateInfoByPage(pageQuery);
        result.addDefaultModel("decorateInfoList",decorateInfoList);
        result.addDefaultModel("pageQuery",pageQuery);
        result.setSuccess(true);
		return result;
	}
}