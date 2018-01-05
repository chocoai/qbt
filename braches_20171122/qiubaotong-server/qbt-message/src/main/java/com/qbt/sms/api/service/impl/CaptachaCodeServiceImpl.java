package com.qbt.sms.api.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.redis.RedisService;
import com.qbt.sms.api.service.CaptachaCodeService;

@Service
public class CaptachaCodeServiceImpl implements CaptachaCodeService {

	@Value("${sms.sms_timeout}")
	private int sms_timeout; // 单位/分钟

	@Resource
	private RedisService redisManager;
	
	@Override
	public String saveCaptachaCode(String codeText) {
		// TODO Auto-generated method stub
		String token = ToolsUtil.getUUID();
		String key = RedisKeyUtil.captacha_Code_Redis_Toke(token);
		try {
			
			redisManager.putString(key, codeText);
			redisManager.expire(key, sms_timeout * 60);

			return token;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void checkCaptachaCode(String code, String token) {
		// TODO Auto-generated method stub
		String key = RedisKeyUtil.captacha_Code_Redis_Toke(token);
		
		if(!redisManager.exists(key)){
			throw new WechatException("8002","图片验证码有误");
		}
		
		String codeText = redisManager.getString(key);
		if(codeText == null){
			throw new WechatException("8002","图片验证码有误");
		}
		
		if(codeText.equalsIgnoreCase(code)){
			redisManager.del(key);
		}else{
			throw new WechatException("8002","图片验证码有误");
		}
	}

}
