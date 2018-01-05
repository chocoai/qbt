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

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.NotifyRequestStatus;
import com.geling.msg.entity.NotifyResponse;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.util.JSonUtil;
import com.geling.msg.util.Tools;

public class RequestMessageHandlerImpl implements HttpRequestHandler {

	/**
	 * Message handler
	 */
	private MessageHandlerImpl messageHandler = null;
	
	/**
	 * Default encoding
	 */
	private static String charset="UTF-8";
	
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		int len = 0;
		byte[] inputData = null;
		byte[] outputData = null;
		String inputStr = null;
		
		String pk = Tools.getOnlyPK();
		Thread.currentThread().setName(pk);
		
		ServletInputStream servletInputStream =null;
		DataInputStream dataInputStream = null;
		NotifyRequestVO requestVO = null;
		NotifyResponse responseEntity = null;
		OutputStream outputStream = null;
		
		try {
			response.setHeader("content-type", "text/html");
			response.setCharacterEncoding(charset);
			
			/**
			 * Response message
			 */
			responseEntity = new NotifyResponse();
			responseEntity.setReturnCode(NotifyResponse.NORMAL_RESPONSE);
			
			servletInputStream = request.getInputStream();
			dataInputStream = new DataInputStream(servletInputStream) ;
			
			/**
			 * Retrieve request JSON message
			 */
			len = request.getContentLength();
			if (len <= 0) {
				return;
			}
			inputData = new byte[len];
			dataInputStream.readFully(inputData);			
			inputStr = new String(inputData, charset);
			LogCvt.info("Request Message: " + inputStr);
			
			/** 
			 * Create Mongo Document
			 */
			requestVO = JSonUtil.toObject(inputStr, NotifyRequestVO.class);
			requestVO.setUuid(requestVO.getUuid() == null || "".equals(requestVO.getUuid()) ? UUID.randomUUID().toString().replace("-", "") : requestVO.getUuid());
			requestVO.setRequestBody(inputStr);
			requestVO.setRequestTime(new Date());
			requestVO.setStatus(NotifyRequestStatus.IN_PROCESS);
			
			/**
			 * Insert message into Redis priority list
			 */
			messageHandler.rpush(requestVO);
			
			/**
			 * Send signal to publisher to start publishing
			 */
			messageHandler.sendPublishSignal(requestVO.get_id());
	        
		} catch (Exception e) {
			LogCvt.error("message request error", e);
			responseEntity.setReturnCode(NotifyResponse.ABNORMAL_RESPONSE);
			responseEntity.setReturnMessage(e.getMessage());
		} finally {
			try {
				dataInputStream.close();
				servletInputStream.close();
			} catch (IOException e) {
				LogCvt.error("IO close error",e);
			}

			/**
			 * Set Response Message
			 */
			try {
		        outputData = JSonUtil.toJSonString(responseEntity).getBytes();
		        outputStream = response.getOutputStream();
		        outputStream.write(outputData);
		        outputStream.flush();
				outputStream.close();
				LogCvt.info("Response Message："+JSonUtil.toJSonString(responseEntity));
			} catch (IOException e) {
				LogCvt.error("IO close error",e);
			}
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
