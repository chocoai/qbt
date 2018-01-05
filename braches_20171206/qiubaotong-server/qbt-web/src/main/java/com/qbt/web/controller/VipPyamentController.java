
 /**
 * @Title: VipPyamentController.java
 * @Package com.qbt.web.controller
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater Administrator 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.vip.VipPayRequest;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.VipPyamentSupport;

/**
  * 购买Vip支付接口
  * @ClassName: VipPyamentController
  * @Description: TODO
  * @author Administrator 2016年11月3日
  * @modify Administrator 2016年11月3日
  */
@Controller
@RequestMapping("/vipPay")
public class VipPyamentController {

	
	@Resource
	private LoginSupport loginSupport;
	
	@Resource
	private  VipPyamentSupport vipPyamentSupport;
	/**
	 * vip购买订单下单微信预支付
	  * @Title: vipPayOrder
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月3日
	  * @modify: chenxiaocong 2016年11月3日
	  * @param request
	  * @param payReq
	  * @return
	 */
	@RequestMapping("/vipOrder")
	public Result<Map<String,String>> vipPayOrder(HttpServletRequest request,@RequestBody VipPayRequest vipPayRequest){
		Result<Map<String,String>> result = new Result<Map<String,String>>();
		/**
		 * 订单信息基本校验
		 */
		try {  
           VlidationUtil.validate(vipPayRequest);  
       } catch (ValidationException e) {  
           result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
           result.setMsg(e.getMessage());
           return result;
       }
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			vipPayRequest.setUserId(userWeixin.getId());
			vipPayRequest.setOpenid(openid);
			result.setDatas(vipPyamentSupport.vipPay(vipPayRequest));
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
