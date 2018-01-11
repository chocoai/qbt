package com.geling.util;

import java.io.StringWriter;
import java.util.Map;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JsonUtil
 * 提供Json和对象之间的转换。
 * @author Kingo.Liang
 *
 */
public class JSonUtil {
	
	/**
	 * 把对象转换成Json字符串。
	 * @param obj 需要转换的对象。
	 * @return 转换好的字符串。如果出错会抛出RuntimeException
	 */
	public static String toJSonString(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		StringWriter out = new StringWriter();
		try {
			mapper.writeValue(out, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}
	
	/**
	 * 把Json字符串转换成对象
	 * @param <T> 所要转换的对象类型
	 * @param json Json字符串
	 * @param clazz 转换对象有类型
	 * @return 转换好的对象，如果出错会抛出RuntimeException
	 */
	public static <T> T toObject(String json,Class<T> clazz){
		ObjectMapper mapper = new ObjectMapper();
		T t = null;
		try {
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			t = mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return t;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map toMap(String json){
		ObjectMapper mapper = new ObjectMapper();
		Map map = null;
		
		try {
			map = mapper.readValue(json, Map.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return map;
	}
}
