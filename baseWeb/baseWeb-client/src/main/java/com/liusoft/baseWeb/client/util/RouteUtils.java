package com.liusoft.baseWeb.client.util;


public class RouteUtils {

    public static Integer getRoute(String key) {
        if (key != null || !key.isEmpty()) {
            return Math.abs(key.hashCode())%8;
        }
        return null;
    }

}
