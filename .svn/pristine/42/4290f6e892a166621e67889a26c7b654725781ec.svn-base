
 /**
 * @Title: SmsSenderImpl.java
 * @Package com.geling.msg.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年10月27日
 * @version V1.0
 **/
package com.geling.msg.service.impl;

import java.util.Date;
import java.util.HashMap;

import com.geling.dao.SmsDao;
import com.geling.dao.impl.SmsDaoImpl;
import com.geling.msg.config.MessagePool;
import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.sms.SMSNotifyRequestEntity;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.service.NotifySender;
import com.geling.msg.sms.api.utils.CCPRestSmsSDK;
import com.geling.msg.util.JSonUtil;


/**
  * @ClassName: SmsSenderImpl
  * @Description: TODO
  * @author chenxiaocong 2016年10月27日
  * @modify chenxiaocong 2016年10月27日
  */
public class SmsSenderImpl implements NotifySender{

	
	//短信发送url
	private String sms_url;
		
	//短信发送port
	private String sms_port;
		
	//帐号
	private String account_id;
		
	//授权回话
	private String auth_token;
		
	//应用id
	private String app_id;
	
	 /**
	  * @Title: send
	  * @Description: TODO
	  * @author: chenxiaocong 2016年10月27日
	  * @modify: chenxiaocong 2016年10月27日
	  * @param requestVO
	  * @return
	  * @see com.geling.msg.service.NotifySender#send(com.geling.msg.db.vo.NotifyRequestVO)
	  */
	public boolean send(NotifyRequestVO requestVO) {
		
		LogCvt.info("-SmsSenderImpl-开始发送短信,NotifyRequest::" + requestVO);
		SMSNotifyRequestEntity smsRequest = null;
		HashMap<String, Object> sendResult = null;
		int requestStatus = 0;
		boolean isSucc = true;
		//接受者手机号
		String mobiles = null;
		//消息内容
		String[] smsData = null;
		//消息模板
		String smsTemplateId = null;
		
		SmsDao smsDao = new SmsDaoImpl();
		try{
			
			smsRequest = JSonUtil.toObject(requestVO.getRequestBody(), SMSNotifyRequestEntity.class);
		
			mobiles = smsRequest.getMobiles();
			smsData = smsRequest.getSmsData();
			smsTemplateId = smsRequest.getSmsTemplateId();
			
			smsRequest.setRequestTime(new Date());
			smsRequest.setUpdateTime(new Date());
			smsRequest.setUuid(requestVO.getUuid());
			smsRequest.setRequestStatus(requestStatus);
			smsRequest.setSmsText(getSmsText(smsTemplateId,smsData));//正式消息内容
			
//			if(smsDao.countByUuid(requestVO.getUuid()) == 0){
				smsDao.insert(smsRequest);
//			}
			
			CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
			
			restAPI.init(sms_url,sms_port);
			restAPI.setAccount(account_id,auth_token);
			restAPI.setAppId(app_id);
			
			sendResult = restAPI.sendTemplateSMS(mobiles,smsTemplateId ,smsData);

			//解析结果
			String statusCode = sendResult.get("statusCode").toString();
			String dateCreated = "";
			String messageSid = "";
			String statusMsg = "";
			if("000000".equals(statusCode)){
				requestStatus = 1;
				
				@SuppressWarnings("unchecked")
				HashMap<String, Object> resultMap = (HashMap<String, Object>) sendResult.get("data");
				
				if(resultMap!= null){
					@SuppressWarnings("unchecked")
					HashMap<String, Object> dataMap = (HashMap<String, Object>) resultMap.get("templateSMS");
					
					if (resultMap!=null){
						messageSid = dataMap.get("smsMessageSid")==null?"":dataMap.get("smsMessageSid").toString();
						dateCreated =  dataMap.get("dateCreated")==null?"":dataMap.get("dateCreated").toString();
					}
				}
			}else {
				requestStatus = 2; 
				statusMsg = sendResult.get("statusMsg").toString();
			}
			
			smsRequest.setStatusCode(statusCode);
			smsRequest.setDateCreated(dateCreated);
			smsRequest.setMessageSid(messageSid);
			smsRequest.setStatusMsg(statusMsg);
			
		}catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
			isSucc = false;
			requestStatus = 2;
		}finally{
			smsRequest.setRequestStatus(requestStatus);
			smsDao.update(smsRequest);
		}
		
		return isSucc;
	}

	/**
	 * 根据消息模板获取正式消息信息
	  * @Title: getSmsText
	  * @Description: TODO
	  * @author: chenxiaocong 2016年10月28日
	  * @modify: chenxiaocong 2016年10月28日
	  * @param smsTemplateId
	  * @return
	 */
	public String getSmsText(String smsTemplateId,String[] smsData){
		
		Object obj = MessagePool.getServiceSmsMap().get("M_"+smsTemplateId);
		String smsTemplate = null;
		if (obj != null){
			smsTemplate = obj.toString();
		}
		String smsText = "";
		try {
			
			if(smsTemplate!=null && !smsTemplate.isEmpty()){
				
				for(int i=0;i<smsData.length;i++){
					smsTemplate = smsTemplate.replace("{"+(i+1)+"}", smsData[i]);
				}
				smsText = smsTemplate;
			}else{
				smsText = JSonUtil.toJSonString(smsData);
			}
		
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
		
		return smsText;
	} 
	
	/**
	 * getter method 
	 * @Title: getSms_url
	 * @return the sms_url
	 */
	
	public String getSms_url() {
		return sms_url;
	}

	
	/**
	* setter method
	* @param sms_url the sms_url to set
	*/
	
	public void setSms_url(String sms_url) {
		this.sms_url = sms_url;
	}

	
	/**
	 * getter method 
	 * @Title: getSms_port
	 * @return the sms_port
	 */
	
	public String getSms_port() {
		return sms_port;
	}

	
	/**
	* setter method
	* @param sms_port the sms_port to set
	*/
	
	public void setSms_port(String sms_port) {
		this.sms_port = sms_port;
	}

	
	/**
	 * getter method 
	 * @Title: getAccount_id
	 * @return the account_id
	 */
	
	public String getAccount_id() {
		return account_id;
	}

	
	/**
	* setter method
	* @param account_id the account_id to set
	*/
	
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	
	/**
	 * getter method 
	 * @Title: getAuth_token
	 * @return the auth_token
	 */
	
	public String getAuth_token() {
		return auth_token;
	}

	
	/**
	* setter method
	* @param auth_token the auth_token to set
	*/
	
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}

	
	/**
	 * getter method 
	 * @Title: getApp_id
	 * @return the app_id
	 */
	
	public String getApp_id() {
		return app_id;
	}

	
	/**
	* setter method
	* @param app_id the app_id to set
	*/
	
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
}
