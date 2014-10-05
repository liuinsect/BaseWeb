package com.liusoft.baseWeb.common;

import java.util.Properties;

/**
 * 获取properties中的内容，代理获取 减少key改动时的改动量
 */
public class BaseWebProperties {


    private static Properties propertiesFactoryBean;

    public BaseWebProperties(Properties propertiesFactoryBean) {
        this.propertiesFactoryBean = propertiesFactoryBean;
    }

    public static  Integer getRenderFactoryCoreSize( ) {
        return Integer.valueOf(propertiesFactoryBean.get("render.factory.core.size").toString().trim());
    }

    public static Integer getRenderFactoryMaxSize() {
        return Integer.valueOf(propertiesFactoryBean.get("render.factory.max.size").toString().trim());
    }


    public static String getAdminPassword() {
        return propertiesFactoryBean.get("admin.password").toString().trim();
    }


    public static void setPropertiesFactoryBean(Properties propertiesFactoryBean) {
        BaseWebProperties.propertiesFactoryBean = propertiesFactoryBean;
    }

    public static  String getLoginCookieKey( ) {
        return propertiesFactoryBean.get("login.cookie.key").toString().trim();
    }


    public static String getDomain() {
        return propertiesFactoryBean.get("domain").toString().trim();
    }


    public static String getCookiePath() {
        return propertiesFactoryBean.get("cookie.path").toString().trim();
    }

    public static int getCookieExpiry() {
        return Integer.valueOf(propertiesFactoryBean.get("cookie.expiry").toString().trim());
    }

    public static String getHomeURL() {
        return propertiesFactoryBean.get("home.url").toString().trim();
    }


}
