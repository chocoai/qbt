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

package com.geling.msg.listener.impl;

import com.geling.msg.handler.impl.RedisSubHandlerImpl;
import com.geling.msg.listener.RedisListener;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.util.Tools;

public class RedisSubListenerImpl implements RedisListener {

	
	/**
	 * Redis subscribe handler
	 */
	private RedisSubHandlerImpl redisSubHandler = null;
	
	public void onMessage(String signal) {
		
		try {
			String pk = Tools.getOnlyPK();
			Thread.currentThread().setName(pk);
			
			LogCvt.info("Subscriber received signal: " + signal);
			
			redisSubHandler.HandleMessage(signal);

			LogCvt.info("Subscriber finished to process signal: " + signal);
		} catch (Exception e){
			LogCvt.error("message subscriber error", e);
		}
	}

	/**
	 * @return the redisSubHandler
	 */
	public RedisSubHandlerImpl getRedisSubHandler() {
		return redisSubHandler;
	}

	/**
	 * @param redisSubHandler the redisSubHandler to set
	 */
	public void setRedisSubHandler(RedisSubHandlerImpl redisSubHandler) {
		this.redisSubHandler = redisSubHandler;
	}
}
