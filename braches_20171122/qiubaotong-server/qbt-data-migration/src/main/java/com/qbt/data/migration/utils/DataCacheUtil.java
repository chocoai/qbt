package com.qbt.data.migration.utils;

import java.util.HashMap;
import java.util.Map;

import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.entity.BaseBankBranch;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.BaseSfSite;

public class DataCacheUtil {

	private static Map<String,BaseCourse>  courseMap = new HashMap<String, BaseCourse>();
	
	private static Map<String,BaseSfSite>  baseSfSiteMap = new HashMap<String, BaseSfSite>();
	
	private static Map<String,BaseAirport>  aiportMap = new HashMap<String, BaseAirport>();
	
	private static Map<String,BaseBankBranch>  brandMap = new HashMap<String, BaseBankBranch>();
	
	private static Map<String,BaseSfArea>  areaMap = new HashMap<String, BaseSfArea>();

	public static BaseCourse getCourseMap(String key) {
		return DataCacheUtil.courseMap.get(key);
	}

	public static void putCourseMap(String key,BaseCourse value) {
		DataCacheUtil.courseMap.put(key.trim(), value);
	}
	
	public static BaseSfSite getBaseSfSiteMap(String key) {
		return DataCacheUtil.baseSfSiteMap.get(key);
	}

	public static void putBaseSfSiteMap(String key,BaseSfSite value) {
		DataCacheUtil.baseSfSiteMap.put(key.trim(), value);
	}

	public static BaseAirport getBaseAirportMap(String key) {
		return DataCacheUtil.aiportMap.get(key);
	}

	public static void putBaseAirportMap(String key,BaseAirport value) {
		DataCacheUtil.aiportMap.put(key.trim(), value);
	}
	
	public static BaseBankBranch getBaseBankBranchMap(String key) {
		return DataCacheUtil.brandMap.get(key);
	}

	public static void putBaseBankBranchMap(String key,BaseBankBranch value) {
		DataCacheUtil.brandMap.put(key.trim(), value);
	}
	
	public static BaseSfArea getBaseSfAreaMap(String key) {
		return DataCacheUtil.areaMap.get(key);
	}

	public static void putBaseSfAreaMap(String key,BaseSfArea value) {
		DataCacheUtil.areaMap.put(key.trim(), value);
	}
	
	
	public static void main(String[] args) {
		long a = 11027481485l;
		long b = 22565l;
		System.out.println((a + b)%31800);
	}
}
