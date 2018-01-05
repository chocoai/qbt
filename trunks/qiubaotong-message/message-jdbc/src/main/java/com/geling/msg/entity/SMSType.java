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

public enum SMSType {
	/**
	 * PAYMENT - 支付验证码
	 * REMINDER - 消息提醒
	 * VERIFICATION - 普通验证码
	 */
	PAYMENT(1), REMINDER(2), VERIFICATION(3);
	
	private int value;
	
	SMSType(int value){
		this.value = value;
	}
	
	public SMSType fromInt(int value){
		switch (value) {
		case 1:
			return PAYMENT;
		case 2:
			return REMINDER;
		case 3:
			return VERIFICATION;
		}
		return null;
	}
	
	public int value(){
		return value;
	}
}
