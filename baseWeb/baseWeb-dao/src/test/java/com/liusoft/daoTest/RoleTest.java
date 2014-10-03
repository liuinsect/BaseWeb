package com.liusoft.daoTest;

import com.liusoft.baseWeb.client.role.Role;
import com.liusoft.baseWeb.dao.role.RoleDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class RoleTest extends BaseTest {

    private static RoleDao roleDao;

    @BeforeClass
    public static void initLibraDao() {
        roleDao = (RoleDao) appContext.getBean("roleDao");
    }

    @Test
    public void 获取所有角色_test() {
        List<Role> roleList = roleDao.getAllRole();

        System.out.println(roleList);
    }

}
