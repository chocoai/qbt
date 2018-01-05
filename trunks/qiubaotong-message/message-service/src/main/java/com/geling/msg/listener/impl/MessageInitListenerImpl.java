package com.geling.msg.listener.impl;

import java.io.File;
import java.net.URI;

import com.geling.db.helper.DbConfig;
import com.geling.msg.config.MessagePool;
import com.geling.msg.config.XmlSms;
import com.geling.msg.config.XmlWechat;
import com.geling.msg.listener.MessageInitListener;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.util.XStreamHandle;

/**
  * @ClassName: MessageInitListenerImpl
  * @Description: TODO
  * @author Administrator 2016年11月1日
  * @modify Administrator 2016年11月1日
  */

public class MessageInitListenerImpl implements MessageInitListener{

	
	private String wechatXmlFilePath;
	
	private String smsXmlFilePath;
	
	private String dbFilePath;//数据库地址 
	
	 /**
	  * @Title: messageInit
	  * @Description: TODO
	  * @author: Administrator 2016年11月1日
	  * @modify: Administrator 2016年11月1日
	  * @see com.geling.msg.listener.MessageInitListener#messageInit()
	  */
	
	@Override
	public void messageInit() {
		// TODO Auto-generated method stub
		wechatInit();
		smsInit();
		//初始化数据库地址
		DbConfig.setPathname(dbFilePath);
	}
	
	
	public void wechatInit() {
		// TODO Auto-generated method stub
		try {
	//		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			
			LogCvt.info("微信xml加载配置文件开始");
	    	String filePath = wechatXmlFilePath;
	    	LogCvt.debug(filePath);
	    	File xml = new File(new URI(filePath));
			MessagePool.loadWechatService(XStreamHandle.toBean(xml, XmlWechat.class));
			LogCvt.info("微信xml加载配置文件结束");
		} catch (Exception e) {
			LogCvt.error("微信初始化配置文件信息错误"+e.getMessage(),e);
		}
		
		
	}

	public void smsInit() {
		try {
			LogCvt.info("短信xml加载配置文件开始");
	    	String filePath = smsXmlFilePath;
	    	LogCvt.debug(filePath);
	    	File xml = new File(new URI(filePath));
			MessagePool.loadSmsService(XStreamHandle.toBean(xml, XmlSms.class));
			LogCvt.info("短信xml加载配置文件结束");
		} catch (Exception e) {
			LogCvt.error("短信初始化配置文件信息错误"+e.getMessage(),e);
		}
		
		
	}


	
	/**
	 * getter method 
	 * @Title: getWechatXmlFilePath
	 * @return the wechatXmlFilePath
	 */
	
	public String getWechatXmlFilePath() {
		return wechatXmlFilePath;
	}


	
	/**
	* setter method
	* @param wechatXmlFilePath the wechatXmlFilePath to set
	*/
	
	public void setWechatXmlFilePath(String wechatXmlFilePath) {
		this.wechatXmlFilePath = wechatXmlFilePath;
	}


	
	/**
	 * getter method 
	 * @Title: getSmsXmlFilePath
	 * @return the smsXmlFilePath
	 */
	
	public String getSmsXmlFilePath() {
		return smsXmlFilePath;
	}


	
	/**
	* setter method
	* @param smsXmlFilePath the smsXmlFilePath to set
	*/
	
	public void setSmsXmlFilePath(String smsXmlFilePath) {
		this.smsXmlFilePath = smsXmlFilePath;
	}


	
	/**
	 * getter method 
	 * @Title: getDbFilePath
	 * @return the dbFilePath
	 */
	
	public String getDbFilePath() {
		return dbFilePath;
	}


	
	/**
	* setter method
	* @param dbFilePath the dbFilePath to set
	*/
	
	public void setDbFilePath(String dbFilePath) {
		this.dbFilePath = dbFilePath;
	}

}
