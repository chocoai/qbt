/**
 *  @Project if-notifycation-base
 *  @File cn.com.froad.jms.notification.base.request HttpRequestConstant.java
 *  Copyright 2006-2013 F-ROAD Commercial Services Co.,Ltd. All rights reserved.
 */
package com.geling.msg.entity;

/**
 * @description 
 * @author Fred
 * @time 2013-5-20 上午11:41:54
 */
public interface RequestConstant {
	
	/**
	 * 非FROM提交方式默认KEY
	 */
	public static final String STREAM_NOTIFY_KEY = "value";
	
	/**
	 * 流式通知模板
	 */
	public static final int STREAM_NOTIFY_TEMPLATE = 9000; 
	
	/**
	 * 流无影响SUCCESS通知模板
	 */
	public static final int STREAM_NO_RES_TEMPLATE = 9001;
	
	/**
	 * 短信无模板标识
	 */
	public static final int SMS_NON_TEMPLATE = 9100;
	
	/**
	 * 邮件无模板标识 
	 */
	public static final int EMAIL_NON_TEMPLATE = 9200;
	
	/**
	 * 忽略大小写
	 */
	public static final String SUCCESS_FLAG = "success";

}
