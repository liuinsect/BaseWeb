package com.liusoft.daoTest;

import com.liusoft.baseWeb.dao.userprivilege.LoginUserDao;
import com.liusoft.userprivilege.LoginUser;
import org.junit.Test;

import javax.annotation.Resource;


public class UserDaoTest extends BaseTest {

    private LoginUserDao userDao;



    @Test
    public void getUserById_Test(){
        if( userDao == null ){
            userDao = (LoginUserDao) applicationContext.getBean("userDao");
        }
        LoginUser user = userDao.getUserById(4l);
        System.out.printf(user.getAccount());

    }





}
