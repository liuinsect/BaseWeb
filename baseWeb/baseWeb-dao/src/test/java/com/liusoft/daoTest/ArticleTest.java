package com.liusoft.daoTest;

import com.liusoft.baseWeb.client.article.Article;
import com.liusoft.baseWeb.client.common.PageQuery;
import com.liusoft.baseWeb.client.role.Role;
import com.liusoft.baseWeb.dao.article.ArticleDao;
import com.liusoft.baseWeb.dao.role.RoleDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class ArticleTest extends BaseTest {

    private static ArticleDao articleDao;

    @BeforeClass
    public static void initLibraDao() {
        articleDao = (ArticleDao) appContext.getBean("articleDao");
    }

    @Test
    public void 新增文章_test() {
        Article article = new Article();
        article.setTitle("asdfasdf");
        article.setAuthor("管理员");
        article.setContent("asdfasdfsdaf");
        article.setModuleId(1);
        article = articleDao.addArticle(article);

        System.out.println(article);
    }

    @Test
    public void 搜索文章_test() {
        Article article = new Article();
        article.setAuthor("管理员");
        article.setModuleId(1);
        List<Article> articleList = articleDao.getListByExample(article);

        System.out.println(articleList);
    }

    @Test
    public void 搜索文章含模块名称_test() {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCurrentPageNo(1);
        pageQuery.setPageSize(10);
        pageQuery.addQueryParam("title","测");
        pageQuery.addQueryParam("moduleId","1");
        List<Article> articleList = articleDao.getArticleByPage(pageQuery);

        System.out.println(articleList);
    }

}
