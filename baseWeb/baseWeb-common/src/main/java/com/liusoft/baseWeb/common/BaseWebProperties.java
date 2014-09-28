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
}
