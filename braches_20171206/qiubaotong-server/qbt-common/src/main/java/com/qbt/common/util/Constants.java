package com.qbt.common.util;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String languesSessionKey = "languesKey";
	
	public static final String successCode = "0";
	
	public static final String sysUser = "sysUser";
	
	/**
	 *  webservice 调用sessionId
	 */
	public static String sessionId   = "";
	
	/**
	 * csv文件后缀
	 */
	public static final String CSV_SUFFIX = ".csv";
	
	/**
	 * 斜杠
	 */
	public static final String SLASH = "/";
	
	/**
	 * xls文件后缀
	 */
	public static final String XLS_SUFFIX = ".xlsx";
	
	/** 顺丰路由操作码 **/
	// 出库
	public static final List<String> waitCodes = Arrays.asList("647", "646");
	// 收件code
	public static final List<String> reciveCodes = Arrays.asList("50", "51", "46", "41", "43", "607");
	// 派送中
	public static final List<String> sendingCodes = Arrays.asList("44", "630", "634", "34", "47");
	// 已签收
	public static final List<String> overCodes = Arrays.asList("80");
	// 问题单
	public static final List<String> questionCodes = Arrays.asList("33", "99", "631", "70", "70A", "8000", "611");
	
	/** 球包通客户电话 */
	public static final String QBT_KF_TEL = "400-609-0990";
}
