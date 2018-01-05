
 /**
 * @Title: SmsSendServiceImpl.java
 * @Package com.qbt.sms.api.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月9日
 * @version V1.0
 **/

package com.qbt.sms.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.MessageLevel;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.sms.api.service.SmsSendService;

/**
  * @ClassName: SmsSendServiceImpl
  * @Description: TODO
  * @author win10 2016年8月9日
  * @modify win10 2016年8月9日
  */
@Service("sms")
public class SmsSendServiceImpl implements SmsSendService {
	
	//短信发送url
	@Value("${sms.sms_url}")
	private String sms_url;
	
	//短信发送port
	@Value("${sms.sms_port}")
	private String sms_port;
	
	//帐号
	@Value("${sms.sms_account_id}")
	private String account_id;
	
	//授权回话
	@Value("${sms.sms_auth_token}")
	private String auth_token;
	
	//应用id
	@Value("${sms.sms_app_id}")
	private String app_id;
	
	//请求地址
	@Value("${sms.request.url}")
	private String requestUrl;
	

	/**
	 * @Title: sendSms
	 * @Description: TODO
	 * @author: win10 2016年8月9日
	 * @modify: win10 2016年8月9日
	 * @param mobile
	 * @param templateId
	 * @param params
	 * @return
	 * @throws Exception
	 * @see com.qbt.sms.api.service.SmsSendService#sendSms(java.lang.String[], java.lang.String, java.lang.String[])
	 */

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> sendSms(String[] mobile, String templateId, String[] params) {
		if(mobile==null||mobile.length<1){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"手机号不能为空！");
		}
		if(templateId==null||"".equals(templateId)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"模版不能为空！");
		}
		
		StringBuffer buffer=new StringBuffer();
		for (String string : mobile) {
			buffer.append(string).append(",");
		}
		
		String mobiles=buffer.substring(0, buffer.length()-1).toString();
		
		HashMap<String, Object> result = null;
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uuid", null);
		jsonObj.put("smsType", MessageLevel.getByCode(templateId));
		jsonObj.put("mobiles", mobiles);
		jsonObj.put("smsData", params);
		jsonObj.put("type", "SMS");
		jsonObj.put("smsTemplateId", templateId);
		jsonObj.put("platform", "qbt");
		LogCvt.info("发送短信："+jsonObj.toJSONString());
		String resultSmg = HttpClientUtil.httpPost(requestUrl, jsonObj.toJSONString());
		try {
			result = (HashMap<String, Object>) JSonUtil.toObject(resultSmg, Map.class);
			if("0000".equals(result.get("returnCode").toString()))
				result.put("statusCode", "000000");
		}catch(Exception e){
			LogCvt.error(e.getMessage(), e);
		}
//		
//		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
//		
//		restAPI.init(sms_url,sms_port);
//		
//		restAPI.setAccount(account_id,auth_token);
//		restAPI.setAppId(app_id);
//		
//		result = restAPI.sendTemplateSMS(mobiles,templateId ,params);
		/*
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.err.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		*/
		return result;
	}

}
