package com.qbt.common.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.fastjson.JSONArray;

public class RedisUtil {
	
	public static Map<String,String> hashsMap(Object obj){
		if(obj == null) return null;
		String json = JSonUtil.toJSonString(obj);
		Map<String,String> hashes = JSonUtil.toObject(json, Map.class);
		for (String key : hashes.keySet()) {
			hashes.put(key,String.valueOf(hashes.get(key)));
		}
		return hashes;
	}
	
	public static <T> T  getByRedis(Map<String,String> map,Class<T> clasz){
		if(map == null || map.isEmpty()) return null;
		return JSonUtil.toObject(JSonUtil.toJSonString(map), clasz);
	}
	
	/*public static Map<String,String> hashsList(Object obj){
		if(obj == null) return null;
		String json = JSonUtil.toJSonString(obj);
		List<List> list = JSONArray.parseArray(json, List.class);; 
		
		for (String key : hashes.keySet()) {
			hashes.put(key,String.valueOf(hashes.get(key)));
		}
		return hashes;
	}*/
	
	
}
