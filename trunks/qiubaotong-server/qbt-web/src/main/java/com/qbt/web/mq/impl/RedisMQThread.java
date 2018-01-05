package com.qbt.web.mq.impl;

import java.util.List;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.redis.RedisService;
import com.qbt.web.mq.process.ProcessService;

/**
 *  RedisMQ 监听服务
 * @author zjz
 *
 */
public class RedisMQThread implements Runnable {

	// 处理队列消息Key
	protected String redisKey;
	
	// 处理队列消息类
	protected ProcessService processService;
	
	// 队列超时时间(单位秒)
	public  int timeout = 0; 
	
	// Redis服务实例
	private RedisService redisService;
	
	public RedisMQThread(String redisKey,ProcessService service){
		this.redisKey = redisKey;
		this.processService = service;
	}
	
	public RedisMQThread(){
		
	}

	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public void registerProcessService(ProcessService processService) {
		this.processService = processService;
	}
	
	public ProcessService getProcessService() {
		return processService;
	}

	@Override
	public void run() {
		while (true) {
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				LogCvt.error("MQ消息队列处理异常1...",e1);
//			}
			List<String> msgs = redisService.brpop(timeout, redisKey);
			if(Checker.isEmpty(msgs)){
				continue;
			}
			try {
				processService.processMsg(msgs);
			} catch (Exception e) {
				LogCvt.error("MQ消息队列处理异常...",e);
			}
		}
		
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
	

}
