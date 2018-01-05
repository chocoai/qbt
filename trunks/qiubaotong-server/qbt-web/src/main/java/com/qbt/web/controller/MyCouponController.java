
 /**
 * @Title: MyCouponController.java
 * @Package com.qbt.web.contorller
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月10日
 * @version V1.0
 **/

package com.qbt.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.web.pojo.coupon.CouponActivity;
import com.qbt.web.pojo.coupon.CouponActivityV2;
import com.qbt.web.pojo.coupon.CouponCode;
import com.qbt.web.pojo.coupon.MyCouponsCount;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.MyCoupon;

/**
  * @ClassName: MyCouponController
  * @Description: 我的优惠券
  * @author win10 2016年8月10日
  * @modify win10 2016年8月10日
  */
@Controller
@RequestMapping("/myCoupon")
public class MyCouponController {
	
	@Resource
	private MyCoupon myCoupon;
	@Resource
	private LoginSupport loginSupport;
	
	@Resource
	private SmsCodeService smsCodeService;
	
	/**
	  * @Title: list
	  * @Description: 优惠券查询
	  * @author: win10 2016年8月12日
	  * @modify: win10 2016年8月12日
	  * @param request
	  * @return
	 */
	@RequestMapping("/list")
	public Result<List<CouponActivity>> list(HttpServletRequest request){
		String openid = String.valueOf(request.getAttribute("openid"));
		Result<List<CouponActivity>> result = new Result<List<CouponActivity>>();
		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
		result.setDatas(myCoupon.findMyCoupon(userWeixin.getId()));
		return result;
	}
	
	/**
	 *  
	  * @Title: list
	  * @Description: TODO
	  * @author: share 2016年8月22日
	  * @modify: share 2016年8月22日
	  * @param request
	  * @return
	 */
	@RequestMapping("/valid_count")
	public Result<Integer> validCount(HttpServletRequest request){
		String openid = String.valueOf(request.getAttribute("openid"));
		Result<Integer> result = new Result<Integer>();
		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
		result.setDatas(myCoupon.validCount(userWeixin.getId()));
		return result;
	}
	
	
	
	/**
	  * @Title: getCode
	  * @Description: 根据暗码获取优惠券
	  * @author: win10 2016年8月12日
	  * @modify: win10 2016年8月12日
	  * @param request
	  * @param code
	  * @param mobile
	  * @param smsCode
	  * @return
	 */
	@RequestMapping("/getCouponCode")
	public Result<CouponActivity> getCode(HttpServletRequest request,@RequestBody CouponCode couponCode){
		Result<CouponActivity> result = new Result<CouponActivity>();
		
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			
			String mobile=couponCode.getMobile();
			String smsCode=couponCode.getSmsCode();
			String smsToken=couponCode.getSmsToken();
			smsCodeService.checkSmsCode(mobile, smsCode, smsToken);
			result.setDatas(myCoupon.getCouponCode(userWeixin, couponCode));
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
	
	/**
	 *  纸质输入券码校验
	  * @Title: valid_coupon_code
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param request
	  * @param body
	  * @return
	 */
	@RequestMapping("/valid_coupon")
	public Result<Double> valid_coupon_code(HttpServletRequest request,@RequestBody Map<String,String> body){
		Result<Double> result = new Result<Double>();
		String child_code = body.get("child_code");
		double amount = Double.parseDouble(body.get("amount"));
		if(StringUtil.isEmpty(child_code)){
			result.setError(ErrorCodeEnum.ERROR);
			return result;
		}
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(myCoupon.validCouponCode(userWeixin.getId(),child_code,amount));
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
	
	
	/***
	 * 
	 * <b>方法名：</b>：coupons<br>
	 * <b>功能说明：</b>：我的优惠券查询v2.0<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 上午10:53:23
	 * @param request
	 * @return 优惠券list
	 */
	@RequestMapping(value = "/coupons")
	public Result<List<CouponActivityV2>> coupons(HttpServletRequest request, @RequestParam(value = "status", required = false, defaultValue = "0")int status){
		String openId = String.valueOf(request.getAttribute("openid"));
		Result<List<CouponActivityV2>> result = new Result<List<CouponActivityV2>>();
		UserWeixin userWeixin = loginSupport.findByOpenId(openId);
		result.setDatas(myCoupon.findMyCoupos2(userWeixin.getId(), status));
		return result;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCouponsCount<br>
	 * <b>功能说明：</b>根据类型查询统计不同状态的用户优惠券数量<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 上午11:27:16
	 * @param request
	 * @param type 类型  1 未使用  2已使用  3 已过期
	 * @return
	 */
	@RequestMapping(value = "/couponsCount")
	public Result<MyCouponsCount> doFindCouponsCount(HttpServletRequest request){
		String openId = String.valueOf(request.getAttribute("openid"));
		Result<MyCouponsCount> result = new Result<MyCouponsCount>();
		UserWeixin userWeixin = loginSupport.findByOpenId(openId);
		result.setDatas(myCoupon.doCountUserCoupnsByUser(userWeixin.getId()));
		return result;
	}
	
	

}
