
package com.geling.msg.handler.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.alibaba.fastjson.JSONObject;
import com.geling.msg.entity.NotifyResponseToken;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.util.JSonUtil;
import com.geling.msg.util.Tools;

/**
 * 
  * @ClassName: RequestGetTokenHandlerImpl
  * @Description: TODO
  * @author chenxiaocong 2016年10月29日
  * @modify chenxiaocong 2016年10月29日
 */
public class RequestGetTokenHandlerImpl implements HttpRequestHandler {


	/**
	 * Default encoding
	 */
	private static String charset="UTF-8";
	
	private MessageHandlerImpl messageHandler = null;
	
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		int len = 0;
		byte[] inputData = null;
		byte[] outputData = null;
		String inputStr = null;
		ServletInputStream servletInputStream =null;
		DataInputStream dataInputStream = null;
		NotifyResponseToken responseEntity = null;
		OutputStream outputStream = null;
		String pk = Tools.getOnlyPK();
		Thread.currentThread().setName(pk);
		
		try {
			response.setHeader("content-type", "text/html");
			response.setCharacterEncoding(charset);
			
			/**
			 * Response message
			 */
			responseEntity = new NotifyResponseToken();
			responseEntity.setReturnCode(NotifyResponseToken.NORMAL_RESPONSE);
			
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
			JSONObject jsonObj = JSonUtil.toObject(inputStr,JSONObject.class);
			String sysId = jsonObj.getString("sysId");
			String accessToken = "";
			//获取需要Token的平台
			accessToken = messageHandler.getAccessToken(sysId);
			
			responseEntity.setAccessToken(accessToken);
		
		} catch (Exception e) {
			LogCvt.error("message request error", e);
			responseEntity.setReturnCode(NotifyResponseToken.ABNORMAL_RESPONSE);
			responseEntity.setReturnMessage(e.getMessage());
		} finally {
			try {
				dataInputStream.close();
				servletInputStream.close();
			} catch (IOException e) {
				LogCvt.error("dataInputStream close error", e);
			}

			/**
			 * Set Response Message
			 */
			try {
				
				LogCvt.info("Response Message："+JSonUtil.toJSonString(responseEntity));
				
		        outputData = JSonUtil.toJSonString(responseEntity).getBytes();
		        outputStream = response.getOutputStream();
		        outputStream.write(outputData);
		        outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				LogCvt.error("dataInputStream close error", e);
			}
		}

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
