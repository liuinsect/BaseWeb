package com.liusoft.baseWeb.common.transaction;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * spring 声明式事务扩展类
 * @author liukunyang
 *
 */
public class SpringTransactionTemplate implements ApplicationContextAware{
	

	private static PlatformTransactionManager transactionManager;
	
	/**
	 * <p>封装获取TransactionTemplate的过程</p>
	 * <p>在使用回调函数包装的原因是spring 不会回滚非runtimeException</p>
	 * <p>手动try catch 保证所有exception都会回滚掉</p>
	 * <p>实现action时不需要try catch任何异常</p>
	 * @param action
	 * @return
	 */
	public static Object execute(final SpringTransactionCallback action){
		TransactionTemplate template = getTransactionTemplate();
		 Object result = null;
		 result = template.execute( new TransactionCallback() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				 Object result = action.doInTransaction();
				return result;
			}
		});
		
		return result;
	}
	
    public static TransactionTemplate getTransactionTemplate() {
        return new TransactionTemplate(transactionManager);
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringTransactionTemplate.transactionManager = (PlatformTransactionManager) applicationContext.getBean("transactionManager");
	}
}
