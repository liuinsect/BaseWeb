package com.liusoft.baseWeb.client.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liukunyang
 * 
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 6028636097083630372L;

	/**
	 * 是否成功
	 */
	private boolean success = true;

	/**
	 * service返回的对象
	 */
	private Map<String, Object> result = new HashMap<String, Object>();
	
	/**
	 * 结果消息
	 */
	private String message;

	/**
	 * 默认的key
	 */
	public static final String DEFAULT_MODEL_KEY = "value";
	
	

	/**
	 * 当前的key
	 */
	private String modelKey = DEFAULT_MODEL_KEY;
	
	private T module;

	/**
	 * 返回码
	 */
	private String resultCode;
	private String[] resultCodeParams;

	/**
	 * 带是否成功的构造方法
	 * 
	 * @param success
	 */
	public Result(boolean success) {
		this.success = success;
	}


	/**
	 * 默认构造方法
	 */
	public Result() {
	}

	/**
	 * 新增一个返回结果
	 * 
	 * @param obj
	 * @return
	 */
	public Object addDefaultModel(T obj) {
		return module = obj;
	}
	
	/**
	 * 得到默认的模型
	 * @return
	 */
	public T getModel(){
		return module;
	}

	/**
	 * 新增一个带key的返回结果
	 * 
	 * @param key
	 * @param obj
	 * @return
	 */
	public Object addDefaultModel(String key, Object obj) {
		modelKey = key;
		return result.put(key, obj);
	}

	/**
	 * 取出所有的key
	 * 
	 * @return
	 */
	public Set<String> keySet() {
		return result.keySet();
	}

	/**
	 * 取出默认的值
	 * 
	 * @return
	 */
	public Object get() {
		return result.get(modelKey);
	}

	/**
	 * 取出值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return result.get(key);
	}
	
	public int getInt(String key) {
		String obj = this.getString(key);
		return Integer.parseInt(obj);
	}
	
	public String getString(String key) {
		Object obj = result.get(key);
        if(obj == null) return null;
        return obj.toString();
	}

	/**
	 * 取出值集合
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Collection values() {
		return result.values();
	}

	/**
	 * 返回是否成功
	 * 
	 * @return
	 */
//	public boolean getSuccess() {
//		return success;
//	}

	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置返回是否成功
	 * 
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultCode(String resultCode, String... args) {
		this.resultCode = resultCode;
		this.resultCodeParams = args;
	}

	public String[] getResultCodeParams() {
		return resultCodeParams;
	}

	public void setResultCodeParams(String[] resultCodeParams) {
		this.resultCodeParams = resultCodeParams;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    public void appendResult(Result outer){
        if( outer != null && outer.isSuccess() ){
            this.result.putAll( outer.getResult() );
        }
    }

	
}

