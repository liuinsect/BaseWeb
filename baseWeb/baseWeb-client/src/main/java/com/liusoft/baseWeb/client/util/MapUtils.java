package com.liusoft.baseWeb.client.util;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-9-26
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class MapUtils {

    public static boolean isBlank(Map map) {
        if ( map == null || map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank( Map map ) {
        return !isBlank( map );
    }


}
