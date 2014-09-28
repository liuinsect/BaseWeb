package com.liusoft.baseWeb.client.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-9-19
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class ListUtils {

    public static boolean isBlank(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(List list) {
        return !isBlank(list);
    }


}
