package com.qbt.common.util;

import java.util.List;
import java.util.Map;

public class MapUtil {
	
	/**
	 * @param map
	 * @param key
	 * @return
	 * 获取list类型数据
	 */
	public static List getList(Map map,String key){
		return (List)map.get(key);
	}

	/**
	 * @param map
	 * @param key
	 * @return
	 * 获取String类型数据
	 */
	public static String getString(Map map, String key) {
		if (map.get(key) == null)
			return null;
		
		if((map.get(key)+"").trim().length()==0){
			return null;
		}
		
		if((map.get(key)+"").trim().equals("null")){
			return null;
		}
		
		return (map.get(key)+"").trim();
	}

	/**
	 * @param map
	 * @param key
	 * @return
	 * 获取int类型数据
	 */
	public static Integer getInt(Map map, String key) {
		return getInt(map, key, null);
	}

	public static Integer getInt(Map map, String key, Integer defaultValue) {
		Object obj = map.get(key);
		if (obj == null)
			return defaultValue;
		
		if((obj instanceof String)&&((String)obj).trim().length()>0){
			return Integer.valueOf(((String)obj).trim());
		}

		if (obj instanceof Integer) {
			return (Integer) obj;
		}

		if (obj instanceof java.math.BigDecimal) {
			return ((java.math.BigDecimal) obj).intValue();
		}

		return defaultValue;
	}

	public static Double getDouble(Map map, String key,Double defaultValue) {
		Object obj = map.get(key);
		if (obj == null)
			return defaultValue;

		if((obj instanceof String)&&((String)obj).trim().length()>0){
			return Double.valueOf(((String)obj).trim());
		}

		
		if (obj instanceof Double) {
			return (Double) obj;
		}

		if (obj instanceof java.math.BigDecimal) {
			return ((java.math.BigDecimal) obj).doubleValue();
		}

		return defaultValue;
	}
	
	/**
	 * @param map
	 * @param key
	 * @return
	 * 获取double类型数据
	 */
	public static Double getDouble(Map map, String key) {
		return getDouble(map,key,null);
	}
	
}
