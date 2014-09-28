/**
 * 
 */
package com.liusoft.baseWeb.common.util;

import com.liusoft.baseWeb.client.util.StringUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author liukunyang
 */
public class JsonUtils {
	
	
	/**
	 * 使用全局的mapper 提高效率
	 */
	private static final ObjectMapper mapper = new ObjectMapper(); 
	
	/**
	 * 初始化mapper配置
	 */
	static{
		
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, false);
		mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
		
	}

	/**
	 * 序列成JSON
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String toJson(Object obj) {
		String json = "";
		try {
			SerializationConfig c = mapper.getSerializationConfig();
			//过期的忽略Null值的属性方法
			c.set(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
			mapper.setSerializationConfig(c);
			json = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("转化为json 字符串失败了!",e);
		}
		return json;
	}

    /**
     * 格式化json 字符串
     * 或者 以格式化形式序列化对象
     * @param obj
     * @return
     */
    public static String toPrettyJson(Object obj) {
        String json = "";
        Writer w = new StringWriter();
        try {
            if( obj instanceof String ){
                obj = (Object)JsonUtils.readToMap((String)obj);
            }
            JsonGenerator jg = mapper.getJsonFactory().createJsonGenerator(w);
            jg.useDefaultPrettyPrinter();
            SerializationConfig c = mapper.getSerializationConfig();
            mapper.setSerializationConfig(c);
            mapper.writeValue(jg, obj);
            json = w.toString();
        } catch (Exception e) {
            throw new RuntimeException("转化为json 字符串失败了!",e);
        } finally {
            try {
                w.close();
                w = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }


	/**
	 * json 转化为泛型。 但是不能转化类似 List<xxx> 的类型，请用readToCollection
	 * @param <T>
	 * @param jsonText
	 * @param clazz
	 * @return
	 */
	public static <T> T readToT(String jsonText , Class<T> clazz) {
	
		try {
			T t = mapper.readValue(jsonText, clazz);
			return  t;
		} catch (Exception e) {
			throw new RuntimeException("将json转化为泛型"+clazz+"失败了!",e);
		} 
	}
	
	/**
	 * 转化为集合类型
	 * @param <T>
	 * @param jsonText
	 * @param clazz
	 * @return
	 */
	public static <T> T readToCollection(String jsonText , Class<T> collectionClass, Class<?>... elementClasses) {
		try {
			JavaType javaType = getCollectionType(collectionClass,elementClasses); 
//			T t = mapper.readValue(jsonText, javaType);
			return  (T)mapper.readValue(jsonText, javaType);
		} catch (Exception e) {
			throw new RuntimeException("将json转化为集合"+collectionClass+"失败了，elementClasses"+elementClasses+"! The Content is ："+jsonText,e);
		} 
	}
	
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
    }
	
	/**
	 * 返回JSON数据构造成的Map
	 *
	 * @param jsonText
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map readToMap(String jsonText) {
		return JsonUtils.readToT(jsonText, Map.class);
	}

    /**
     * 判断是否是json格式
     *
     * @param str
     * @return
     */
    public static  boolean isJson(String str) {
        // TODO 先简单判断下，可以再用正则匹配判断
        if( StringUtils.isNotBlank(str)){
            return str.startsWith("{");
        }
        return false;
    }

}