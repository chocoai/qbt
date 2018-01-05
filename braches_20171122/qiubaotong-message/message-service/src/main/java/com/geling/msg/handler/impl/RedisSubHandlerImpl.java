package com.geling.msg.handler.impl;

import java.util.HashMap;
import java.util.Map;

import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.RequestType;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.service.NotifySender;
import com.geling.msg.util.JSonUtil;

public class RedisSubHandlerImpl {
	
	/**
	 * Map for senders
	 */
	private Map<RequestType, NotifySender> senders = new HashMap<RequestType, NotifySender>();
	
	/**
	 * Message handler
	 */
	private MessageHandlerImpl messageHandler = null;
	
	/**
	 * Handle message
	 * 
	 * @param message
	 */
	public void HandleMessage(String signal) {
		String message = null;
		long popCount = 0;
		
		try {
			LogCvt.info("--Start processing message--");
			// retrieve message with priority
			message = messageHandler.retrievePubMessage();
			while (null != message) {
				// process message
				process(message);
				
				message = messageHandler.retrievePubMessage();
				popCount += 1;
			}
			
			LogCvt.info(popCount + " messages have been processed.");
		} catch (Exception e){
			LogCvt.error("message processing error", e);
		}
	}
	
	/**
	 * process request message
	 * 
	 * @param message
	 */
	private void process(String message){
		NotifyRequestVO requestVO = null;
		RequestType requestType = null;
		NotifySender sender = null;
		String requestId = null;
		boolean isSuccess = false;
		
		try {
			LogCvt.info("Start process message: " + message);
			requestVO = JSonUtil.toObject(message, NotifyRequestVO.class);
			requestType = requestVO.getType();
			requestId = requestVO.get_id();
			
			/**
			 * Convert to specified entity according to the request type
			 */
			if (requestType.equals(RequestType.HTTP) || requestType.equals(RequestType.EMAIL)
					|| requestType.equals(RequestType.SMS) 
					|| requestType.equals(RequestType.WECHAT)){
				/**
				 * Invoke sender to deliver the request
				 */
				sender = senders.get(requestType);
				isSuccess = sender.send(requestVO);
			} else {
				LogCvt.error("Unknow request type: " + requestType.name());
			}

			LogCvt.info(requestId + " delivery status: " + isSuccess);
			
			/**
			 * If failed and there's still retry count, put to redis resend list
			 * 暂时不需要失败重新发送
			 */
//			if (!isSuccess && requestVO.getRetryCount() > 0){
//				// Push resend message id to redis resend list
//				messageHandler.putToResendList(requestVO.get_id());
//			}
		} catch (Exception e){
			LogCvt.error("message subscriber error", e);
		}
	}

	/**
	 * @return the senders
	 */
	public Map<RequestType, NotifySender> getSenders() {
		return senders;
	}

	/**
	 * @param senders the senders to set
	 */
	public void setSenders(Map<RequestType, NotifySender> senders) {
		this.senders = senders;
	}



	/**
	 * @return the messageHandler
	 */
	public MessageHandlerImpl getMessageHandler() {
		return messageHandler;
	}

	/**
	 * @param messageHandler the messageHandler to set
	 */
	public void setMessageHandler(MessageHandlerImpl messageHandler) {
		this.messageHandler = messageHandler;
	}
}
