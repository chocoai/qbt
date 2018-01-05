
 /**
 * @Title: SmsCodeController.java
 * @Package com.qbt.web.controller
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月12日
 * @version V1.0
 **/

package com.qbt.web.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.sms.api.service.SmsCodeService;

/**
  * @ClassName: SmsCodeController
  * @Description:获取短信验证码
  * @author win10 2016年8月12日
  * @modify win10 2016年8月12日
  */
@Controller
@RequestMapping("/smsCommon")
public class SmsCodeController {
	
	@Resource
	private SmsCodeService smsCodeService;
	
	/**
	  * @Title: getSmsCode
	  * @Description: 获取短信验证码
	  * @author: win10 2016年8月12日
	  * @modify: win10 2016年8月12日
	  * @param request
	  * @param mobile
	  * @return
	 */
	@RequestMapping("/getSmsCode")
	public Result<String> getSmsCode(HttpServletRequest request,String mobile){
		Result<String> result = new Result<String>();
		String smsToken=smsCodeService.getSmsCode(mobile);
		if(smsToken==null){
			result.setCode("8001");
			result.setMsg("获取验证码失败,请重新获取！");
			return result;
		}else{
			result.setDatas(smsToken);
			return result;
		}
	}
	
	@RequestMapping("/checkSmsCode")
	public Result<String> checkSmsCode(@RequestBody HashMap<String,String> map){
		Result<String> result = new Result<String>();
		try {
			String mobile=map.get("mobile");
			String smsCode=map.get("smsCode");
			String smsToken=map.get("smsToken");
			smsCodeService.checkSmsCode(mobile, smsCode, smsToken);
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}

}
