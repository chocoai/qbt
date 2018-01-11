
 /**
 * @Title: WechatSenderImpl.java
 * @Package com.geling.msg.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年10月28日
 * @version V1.0
 **/

package com.geling.msg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.geling.msg.config.MessagePool;
import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.wechat.WechatNotifyRequestEntity;
import com.geling.msg.handler.impl.MessageHandlerImpl;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.service.NotifySender;
import com.geling.msg.util.HttpsClient;
import com.geling.msg.util.JSonUtil;
import com.geling.msg.util.StringUtil;


/**
  * @ClassName: WechatSenderImpl
  * @Description: TODO
  * @author chenxiaocong 2016年10月29日
  * @modify chenxiaocong 2016年10月29日
 */
public class WechatSenderImpl implements NotifySender{
	private MessageHandlerImpl messageHandler = null;
	
	
	 /**
	  * @Title: send
	  * @Description: TODO
	  * @author: chenxiaocong 2016年10月28日
	  * @modify: chenxiaocong 2016年10月28日
	  * @param requestVO
	  * @return
	  * @see com.geling.msg.service.NotifySender#send(com.geling.msg.db.vo.NotifyRequestVO)
	  */
	@Override
	public boolean send(NotifyRequestVO requestVO) {

		LogCvt.info("-WechatSenderImpl-开始下推微信通知,NotifyRequest::" + requestVO);
		WechatNotifyRequestEntity  wechatRequest = null;
		
		try {
		
			wechatRequest = JSonUtil.toObject(requestVO.getRequestBody(), WechatNotifyRequestEntity.class);
			
			//下推模板url
			String template_url= MessagePool.getTemplate_url();
			//下推信息
			JSONObject json= wechatRequest.getWechatData() ;
			//获取平台编号
			String sysId = wechatRequest.getSysId();
				
			String accessToken = messageHandler.getAccessToken(sysId);
			
			String templateUrl = template_url.replace("{ACCESS_TOKEN}", accessToken);
			
			String jsonString = JSonUtil.toJSonString(json);
			//发送信息
			String body = HttpsClient.httpsPost(templateUrl,StringUtil.convertCharset(jsonString, "UTF-8", "ISO-8859-1"));
			
			LogCvt.info("response body:"+body);

		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
			return false;
		}
		
		return true;
	}

	
	/**
	 * getter method 
	 * @Title: getMessageHandler
	 * @return the messageHandler
	 */
	
	public MessageHandlerImpl getMessageHandler() {
		return messageHandler;
	}

	
	/**
	* setter method
	* @param messageHandler the messageHandler to set
	*/
	
	public void setMessageHandler(MessageHandlerImpl messageHandler) {
		this.messageHandler = messageHandler;
	}

}
