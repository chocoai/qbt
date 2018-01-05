/**
 * Project Name:qbt-web
 * File Name:VipInfoController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年4月11日下午1:53:37
 *
*/

package com.qbt.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.vip.VipOrderConfirmVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.VipInfoSupport;

/**
 * ClassName:VipInfoController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年4月11日 下午1:53:37
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipInfo")
public class VipInfoController {
	
	@Resource
	private VipInfoSupport vipInfoSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "checkVipOrder")
	public Result<VipOrderConfirmVo> checkVipOrder(HttpServletRequest request,@RequestBody VipOrderConfirmRequest vipOrderConfirmRequest){
		Result<VipOrderConfirmVo> result = new Result<VipOrderConfirmVo>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			vipOrderConfirmRequest.setUserId(userWeixin.getId());
			result.setDatas(vipInfoSupport.checkVipOrderByUser(vipOrderConfirmRequest));
		} catch (WechatException e){
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR.getMsg());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
		}
		return result;
	}
	
}
