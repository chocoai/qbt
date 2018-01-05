package com.qbt.bussiness.support.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.redis.RedisService;
import com.qbt.wechat.api.WechatApi;

@Service
public class WechatCommonSupportImpl implements WechatCommonSupport {

	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private RedisService redisManager;
	
	@Value("${access_token_request_url}")
	private String tokenRequestUrl;
	
	@Override
	public String getAccessToken(){
//		String accessToken = null;
//		try {
//			long resp = redisManager.setnx(RedisKeyUtil.access_token_Redis_lock_key(), "0");
//			if(resp == 1l){
//				LogCvt.info("accessToken为空，重新获取");
//				accessToken = wechatApi.getAccessToken();
//				if(accessToken == null){
//					redisManager.del(RedisKeyUtil.access_token_Redis_lock_key());
//				}else{
//					redisManager.del(RedisKeyUtil.access_token_Redis_key());
//					redisManager.setex(RedisKeyUtil.access_token_Redis_lock_key(), 7190, "0");
//					redisManager.setex(RedisKeyUtil.access_token_Redis_key(), 7190, accessToken);
//				}
//			}else{
//				// 防并发拿取空情况
//				accessToken = redisManager.get(RedisKeyUtil.access_token_Redis_key());
//				if(accessToken == null){
//					Thread.sleep(1000);
//					accessToken = redisManager.get(RedisKeyUtil.access_token_Redis_key());
//				}
//			}
//		} catch (Exception e) {
//			LogCvt.error(e.getMessage(), e);
//		}
		LogCvt.info("===获取球包通微信token===");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("sysId", "qbt");
		String resp = HttpClientUtil.httpPost(tokenRequestUrl, jsonObj.toJSONString());
		JSONObject respBody = JSonUtil.toObject(resp, JSONObject.class);
		return respBody.getString("accessToken");
	}

}
