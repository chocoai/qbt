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

package com.geling.msg.entity;

import java.io.Serializable;

public class NotifyResponse  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Normal response
	 */
	public static final String NORMAL_RESPONSE = "0000";
	
	/**
	 * Abnormal response
	 */
	public static final String ABNORMAL_RESPONSE = "9999";

	/**
	 * Return Code
	 * 0000 - normal response
	 * 9999 - unexpected response
	 */
	private String returnCode = null;
	
	/**
	 * Return Message
	 * null for normal response, others with specified tips
	 */
	private String returnMessage = null;
	
	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * @return the returnMessage
	 */
	public String getReturnMessage() {
		return returnMessage;
	}
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @param returnMessage the returnMessage to set
	 */
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
}
