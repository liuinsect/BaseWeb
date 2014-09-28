package com.liusoft.baseWeb.common.transaction;

/**
 * spring 声明式事务扩展 回调接口
 * @author liukunyang
 *
 */
public interface SpringTransactionCallback {

	Object doInTransaction();
	
}
