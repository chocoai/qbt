package com.qbt.web.mq.impl;

import java.util.ArrayList;
import java.util.List;

import com.qbt.common.logback.LogCvt;
import com.qbt.web.mq.RedisMQService;

/**
 *  Redis消息服务处理类
 * @author zjz
 *
 */
public class RedisMQServiceImpl implements RedisMQService {

	List<RedisMQThread> threadList = new ArrayList<RedisMQThread>();
	
	/**
	 *  服务注册
	 */
	@Override
	public void registerMQService(RedisMQThread thread) {
		// TODO Auto-generated method stub
		threadList.add(thread);
	}

	/**
	 *  注册服务启动
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		for(RedisMQThread thread : threadList){
			LogCvt.info("Redis MQ 服务："+thread.getProcessService().getClass().getSimpleName()+"启动...");
			new Thread(thread).start();
			
		}
	}

}
