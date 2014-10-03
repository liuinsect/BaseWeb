package com.liusoft.daoTest;

import com.liusoft.baseWeb.client.role.Role;
import com.liusoft.baseWeb.client.user.User;
import com.liusoft.baseWeb.dao.role.RoleDao;
import com.liusoft.baseWeb.dao.user.UserDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class UserTest extends BaseTest {

    private static UserDao userDao;

    @BeforeClass
    public static void initLibraDao() {
        userDao = (UserDao) appContext.getBean("userDao");
    }

    @Test
    public void 获取所有角色_test() {
        User example = new User();
        example.setAccount("admin");
        example.setPassword("1");
        example.setRoleId(1);
        List<User> userList = userDao.getListByExample(example);

        System.out.println(userList);
    }

}
