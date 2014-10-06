package com.liusoft.daoTest;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
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

    @Test
    public void 搜索用户_test() {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCurrentPageNo(1);
        pageQuery.setPageSize(10);
//        pageQuery.addQueryParam("title","测");
//        pageQuery.addQueryParam("moduleId","1");
        List<User> userList = userDao.getUserByPage(pageQuery);

        System.out.println(userList);
    }

    @Test
    public void 更新用户信息_test() {
        User user = new User();
        user.setUserName("管理员1");
        user.setUserId(1);

        System.out.println(userDao.getUserById(1));
        userDao.updateUser(user);
        System.out.println(userDao.getUserById(1));
    }


}
