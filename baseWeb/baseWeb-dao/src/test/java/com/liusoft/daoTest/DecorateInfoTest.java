package com.liusoft.daoTest;

import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.decorateinfo.DecorateInfo;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.dao.decorateinfo.DecorateInfoDao;
import com.liusoft.baseWeb.dao.user.UserDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class DecorateInfoTest extends BaseTest {

    private static DecorateInfoDao decorateInfoDao;

    @BeforeClass
    public static void initLibraDao() {
        decorateInfoDao = (DecorateInfoDao) appContext.getBean("decorateInfoDao");
    }

    @Test
    public void 获取某個用戶下的裝修信息_test() {
        DecorateInfo decorateInfo = new DecorateInfo();
        decorateInfo.setUserId(1);
        List<DecorateInfo> decorateInfoList=decorateInfoDao.getListByExample(decorateInfo);
        System.out.println(decorateInfoList);
    }


}
