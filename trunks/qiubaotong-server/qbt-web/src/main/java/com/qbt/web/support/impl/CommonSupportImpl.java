package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.redis.RedisService;
import com.qbt.web.support.CommonSupport;
import com.qbt.wechat.api.WechatApi;

@Service
public class CommonSupportImpl implements CommonSupport {

	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private RedisService redisManager;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	public String getJsapiTicket() {
		// 获取jspTicket,redis 同步锁
		String jsapi_ticket = null;
		try {
			long resp = redisManager.setnx(RedisKeyUtil.jsapi_ticket_Redis_lock_key(), "0");
			if(resp == 1l){
				LogCvt.info("jsapi_ticket为空，重新获取");
				jsapi_ticket = wechatApi.getJsapiTicket(commonSupport.getAccessToken());
				if(jsapi_ticket == null){
					redisManager.del(RedisKeyUtil.jsapi_ticket_Redis_lock_key());
				}else{
					redisManager.del(RedisKeyUtil.jsapi_ticket_Redis_key());
					redisManager.setex(RedisKeyUtil.jsapi_ticket_Redis_lock_key(), 7190, "0");
					redisManager.setex(RedisKeyUtil.jsapi_ticket_Redis_key(), 7190, jsapi_ticket);
				}
			}else{
				// 防并发拿取空情况
				jsapi_ticket = redisManager.get(RedisKeyUtil.jsapi_ticket_Redis_key());
				if(jsapi_ticket == null){
					Thread.sleep(1000);
					jsapi_ticket = redisManager.get(RedisKeyUtil.jsapi_ticket_Redis_key());
				}
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
		return jsapi_ticket;
	}


}
