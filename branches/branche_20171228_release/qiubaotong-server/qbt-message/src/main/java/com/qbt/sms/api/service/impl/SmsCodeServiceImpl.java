
/**
* @Title: SmsCodeServiceImpl.java
* @Package com.qbt.sms.api.service.impl
* @Description: TODO
* Copyright:2016 qiubaotong All Rights Reserved   
* Company:www.qiubaotong.com
* 
* @creater win10 2016年8月11日
* @version V1.0
**/

package com.qbt.sms.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.enums.SmsTemplate;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.RandomProvider;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.redis.RedisService;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.sms.api.service.SmsSendService;

/**
 * @ClassName: SmsCodeServiceImpl
 * @Description: 获取短信验证码
 * @author win10 2016年8月11日
 * @modify win10 2016年8月11日
 */
@Service
public class SmsCodeServiceImpl implements SmsCodeService {

	@Value("${sms.sms_timeout}")
	private int sms_timeout; // 单位/分钟

	@Resource
	private RedisService redisManager;

	@Resource
	private SmsSendService smsSendService;

	/**
	 * @Title: getSmsCode
	 * @Description: 获取短信验证码
	 * @author: win10 2016年8月11日
	 * @modify: win10 2016年8月11日
	 * @param mobile
	 * @return
	 * @see com.qbt.sms.api.service.SmsCodeService#getSmsCode(java.lang.String)
	 *      【球包通】验证码：{1}，请于{2}分钟内输入，请勿告诉别人。
	 */
	@Override
	public String getSmsCode(String mobile) {
		String code = RandomProvider.randomNumeric(6);
		String smsToken = ToolsUtil.getUUID();
		String key = RedisKeyUtil.User_SmsCode_Redis_SmsToke(smsToken);
		try {
			//send sms message
			HashMap<String, Object> map = smsSendService.sendSms(new String[] { mobile }, SmsTemplate.M_113079.getCode(),
					new String[] { code, Integer.toString(sms_timeout)+"分" });
			if (!"000000".equals(map.get("statusCode"))) {
				return null;
			}

			//set redis.
			HashMap<String, String> redisMap = new HashMap<String, String>();
			redisMap.put("mobile", mobile);
			redisMap.put("code", code);
			
			redisManager.putMap(key, redisMap);
			redisManager.expire(key, sms_timeout * 60);

			return smsToken;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * @Title: checkSmsCode
	 * @Description: 校验短信验证码
	 * @author: win10 2016年8月11日
	 * @modify: win10 2016年8月11日
	 * @param mobile
	 * @param smsCode
	 * @param smsToken
	 * @return 
	 * 0-校验成功   
	 * 1-验证码过期  
	 * 2-验证码错误
	 * @see com.qbt.sms.api.service.SmsCodeService#checkSmsCode(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void checkSmsCode(String mobile, String smsCode, String smsToken) {
		
		String key = RedisKeyUtil.User_SmsCode_Redis_SmsToke(smsToken);
		
		if(!redisManager.exists(key)){
			throw new WechatException("8003","验证码有误");
		}
		
		Map<String,String> redisMap=redisManager.getMap(key);
		if(redisMap==null){
			throw new WechatException("8003","验证码有误");
		}
		
		String t_mobile=redisMap.get("mobile");
		String code=redisMap.get("code");
		if(mobile.equals(t_mobile)&&smsCode.equals(code)){
			redisManager.del(key);
		}else{
			throw new WechatException("8003","验证码有误");
		}
		
	}

}
