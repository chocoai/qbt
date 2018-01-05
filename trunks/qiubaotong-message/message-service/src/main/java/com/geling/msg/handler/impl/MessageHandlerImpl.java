/**
 * Amendment History
 * 
 * 	Amended   By		: 
 * 	Amendment Date		: 
 *  Amendment Label		: 
 * 	Amendment Details	: 
 * 	
 * 
 * @author F-road
 * 
 * Copyright 2008-2015 F-ROAD Commercial Services Co.,Ltd. All rights reserved.
 *
 */

package com.geling.msg.handler.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.geling.msg.config.MessagePool;
import com.geling.msg.config.WechatServiceConfig;
import com.geling.msg.db.dao.impl.RedisDAOImpl;
import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.RequestType;
import com.geling.msg.entity.sms.SMSNotifyRequestEntity;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.util.HttpsClient;
import com.geling.msg.util.JSonUtil;
import com.geling.msg.util.RedisKeyUtil;

public class MessageHandlerImpl {
	
	
	
	/**
	 * Redis DAO
	 */
	private RedisDAOImpl redisDAO = null;
	
	/**
	 * The Redis channel to subscribe messages
	 */
	private String subscribeChannel = null;
	
	/**
	 * Default delivery priority list
	 */
	private String defaultList = null;
	
	/**
	 * Redis resend list
	 */
	private String redisResendList = null;
	
	/**
	 * Delivery priority map
	 */
	private Map<String, String> priorityMap = new LinkedHashMap<String, String>();
	
	/**
	 * Put request into redis list
	 * 
	 * @param requestVO
	 */
	public void rpush(NotifyRequestVO requestVO){
		String priorityList = null;
		RequestType requestType = null;
		SMSNotifyRequestEntity smsEntity = null;
		String smsType=null;
		String smsTypePattern = null;
		Iterator<String> keyKterator = null;
		String priorityKey = null;
		String priorityValue = null;
		
		requestType = requestVO.getType();

		/**
		 * For HTTP, EMAIL and some not predefined SMS type, which will set to default priority
		 */
		priorityList = this.defaultList;
		
		/**
		 * 发送短信，按照优先级发送
		 */
		if (requestType.equals(RequestType.SMS)){
			smsEntity = JSonUtil.toObject(requestVO.getRequestBody(), SMSNotifyRequestEntity.class);
			if(smsEntity.getSmsType()!=null){
				smsType = smsEntity.getSmsType().name();
			}else{
				smsType = "*";//默认级别
			}
			smsTypePattern = smsType + "_*";
			
			keyKterator = this.priorityMap.keySet().iterator();
			while (keyKterator.hasNext()){
				priorityKey = keyKterator.next();
				priorityValue = this.priorityMap.get(priorityKey);
				if (priorityValue.contains(smsTypePattern)) {
					priorityList = priorityKey;
					break;
				}
			}
		}

		/**
		 * Push request to the tail of the list
		 */
		this.redisDAO.rpush(priorityList, JSonUtil.toJSonString(requestVO));
	}
	
	/**
	 * Send publish signal to publisher
	 * 
	 * @param signal
	 * @return the no. of subscribers
	 */
	public void sendPublishSignal(String signal){
		try {
			redisDAO.publish(subscribeChannel, signal);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Publish message to subscriber
	 * 
	 * @param message
	 * @return
	 */
	public long publishToSubscriber(String message){
		return this.redisDAO.publish(subscribeChannel, message);
	}
	
	/**
	 * Retrieve message from the list to publish
	 * 
	 * @return
	 */
	public String retrievePubMessage(){
		
		Iterator<String> listIt = null;
		String listName = null;
		String messageToPop = null;
		
		listIt = priorityMap.keySet().iterator();
		
		/**
		 * 短信优先级别先处理
		 */
		while (listIt.hasNext()){
			listName = listIt.next();
			messageToPop = redisDAO.lpop(listName);
			if (null != messageToPop){
				break;
			}
		}
		
		return messageToPop;
		
	}
	
	/**
	 * Push resend message to redis resend list
	 * 
	 * @param messageId
	 */
	public void putToResendList(String messageId){
		this.redisDAO.rpush(redisResendList, messageId);
	}
	
	/**
	 * Pop the 1st message id from resend list
	 * 
	 * @return String
	 */
	public String popFromResendList(){
		return this.redisDAO.lpop(redisResendList);
	}

	/**
	 * 微信获取Token
	  * @Title: getAccessToken
	  * @Description: TODO
	  * @author: chenxiaocong 2016年10月29日
	  * @modify: chenxiaocong 2016年10月29日
	  * @param sysId
	  * @param appid
	  * @param secret
	  * @return
	 */
	public String getAccessToken(String sysId){
		String accessToken = null;
		try {

			long resp = redisDAO.setnx(RedisKeyUtil.access_token_Redis_lock_key(sysId), "0");
			if(resp == 1l){
				LogCvt.info("accessToken为空，重新获取");
				accessToken = getWechatAccessToken(sysId);
				if(accessToken == null){
					redisDAO.del(RedisKeyUtil.access_token_Redis_lock_key(sysId));
				}else{
					redisDAO.del(RedisKeyUtil.access_token_Redis_key(sysId));
					redisDAO.setex(RedisKeyUtil.access_token_Redis_lock_key(sysId), 7190, "0");
					redisDAO.setex(RedisKeyUtil.access_token_Redis_key(sysId), 7190, accessToken);
				}
			}else{
				// 防并发拿取空情况
				accessToken = redisDAO.getString(RedisKeyUtil.access_token_Redis_key(sysId));
				if(accessToken == null){
					Thread.sleep(1000);
					accessToken = redisDAO.getString(RedisKeyUtil.access_token_Redis_key(sysId));
				}
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		
		return accessToken;
	}
	
	public String getWechatAccessToken(String sysId){
		try{
			
			
			WechatServiceConfig wechatConfig = MessagePool.getServiceWechatMap().get(sysId);
			
			//获取token url
			String acess_token_url = MessagePool.getAcess_token_url();
			//获取该平台下的 appid
			String appid = wechatConfig.getAppid();
			//获取该平台下的 secret
			String secret = wechatConfig.getSecret();
			
					
			String url = acess_token_url.replace("{APPID}", appid);
			url = url.replace("{APPSECRET}", secret);
			LogCvt.info("获取Access_token请求url：" + url);

			String resp = HttpsClient.httpsPost(url);
			LogCvt.info("获取AccessToken:"+resp);
			Map<?,?> respMap = JSonUtil.toObject(resp, HashMap.class);

			if (respMap.containsKey("errcode")){
				LogCvt.error("获取accessToken失败[错误码：" + respMap.get("errcode") + " 描述："+ respMap.get("errmsg") + "]");
				throw new Exception("获取accessToken失败[错误码：" + respMap.get("errcode") + " 描述："+ respMap.get("errmsg") + "]");
			}
			return respMap.get("access_token").toString();
		}catch (Exception ex){
			LogCvt.error("获取微信公共平台凭证失败",ex);
		}
		return null;
	}
	
	/**
	 * @return the redisDAO
	 */
	public RedisDAOImpl getRedisDAO() {
		return redisDAO;
	}

	/**
	 * @param redisDAO the redisDAO to set
	 */
	public void setRedisDAO(RedisDAOImpl redisDAO) {
		this.redisDAO = redisDAO;
	}

	/**
	 * @return the defaultList
	 */
	public String getDefaultList() {
		return defaultList;
	}

	/**
	 * @param defaultList the defaultList to set
	 */
	public void setDefaultList(String defaultList) {
		this.defaultList = defaultList;
	}

	/**
	 * @return the redisResendList
	 */
	public String getRedisResendList() {
		return redisResendList;
	}

	/**
	 * @param redisResendList the redisResendList to set
	 */
	public void setRedisResendList(String redisResendList) {
		this.redisResendList = redisResendList;
	}

	/**
	 * @return the subscribeChannel
	 */
	public String getSubscribeChannel() {
		return subscribeChannel;
	}

	/**
	 * @param subscribeChannel the subscribeChannel to set
	 */
	public void setSubscribeChannel(String subscribeChannel) {
		this.subscribeChannel = subscribeChannel;
	}
	
	/**
	 * @return the priorityMap
	 */
	public Map<String, String> getPriorityMap() {
		return priorityMap;
	}

	/**
	 * @param priorityMap the priorityMap to set
	 */
	public void setPriorityMap(Map<String, String> priorityMap) {
		this.priorityMap = priorityMap;
	}
}
