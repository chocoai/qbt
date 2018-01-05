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

public class NotifyResponseToken  extends NotifyResponse {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 微信授权
	 */
	private String accessToken = null;

	
	/**
	 * getter method 
	 * @Title: getAccessToken
	 * @return the accessToken
	 */
	
	public String getAccessToken() {
		return accessToken;
	}

	
	/**
	* setter method
	* @param accessToken the accessToken to set
	*/
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	

}
