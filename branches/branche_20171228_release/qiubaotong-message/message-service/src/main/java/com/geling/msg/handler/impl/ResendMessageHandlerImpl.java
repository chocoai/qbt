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

import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.logback.LogCvt;

public class ResendMessageHandlerImpl {

	/**
	 * Message handler
	 */
	private MessageHandlerImpl messageHandler = null;
	
	
	/**
	 * Retrieve uncompleted request from DB and resend
	 */
	public void resend() {
		NotifyRequestVO requestVO = null;
		int resendCount = 0;
		String messageId = null;
		
		try {
			
			messageId = messageHandler.popFromResendList();
			
			while (null != messageId){
				resendCount++;
				
				if (null == requestVO){
					LogCvt.info("Resend message is not found in mongodb: " + messageId);
					continue;
				}
				
				/**
				 * Insert message into Redis priority list
				 */
				messageHandler.rpush(requestVO);
				
				/**
				 * Send signal to publisher to start publishing
				 */
				messageHandler.sendPublishSignal(requestVO.get_id());
				
				// Pop next resend message from redis resend list
				messageId = messageHandler.popFromResendList();
			}
			
			LogCvt.info("Resend message count: " + resendCount);
		} catch (Exception e) {
			LogCvt.error("message resend error"+e.getMessage(), e);
		}
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
