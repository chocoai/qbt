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
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.pay.PayRequest;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.OrderV2Support;
import com.qbt.web.support.PaymentSupport;
import com.qbt.web.support.ShoppingCartOrderSupport;

/**
 *  支付接口
  * @ClassName: PyamentController
  * @Description: TODO
  * @author share 2016年8月11日
  * @modify share 2016年8月11日
 */
@Controller
@RequestMapping("/pay")
public class PyamentController {
	
	@Resource
	private OrderSupport orderSupport;
	@Resource
	private OrderV2Support orderV2Support;
	@Resource
	private ShoppingCartOrderSupport shoppingCartOrderSupport;
	@Resource
	private LoginSupport loginSupport;
	@Resource
	private PaymentSupport paymentSupport;
	
	/**
	 *  订单下单微信支付
	  * @Title: payOrder
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/order")
	public Result<Map<String,String>> payOrder(HttpServletRequest request,@RequestBody PayRequest payReq){
		Result<Map<String,String>> result = new Result<Map<String,String>>();
		/**
		 * 订单信息基本校验
		 */
		try {  
            VlidationUtil.validate(payReq);  
        } catch (ValidationException e) {  
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg(e.getMessage());
            return result;
        }
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			payReq.setUserId(userWeixin.getId());
			payReq.setOpenId(openid);
			result.setDatas(paymentSupport.pay(payReq));
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
	 *  订单下单微信支付
	  * @Title: payOrder
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/v2/order")
	public Result<Map<String,String>> payOrderV2(HttpServletRequest request,String orderId){
		Result<Map<String,String>> result = new Result<Map<String,String>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(paymentSupport.pay(orderId,openid));
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
	 *  0元支付
	  * @Title: payOrder
	  * @Description: TODO
	  * @author: share 2016年9月5日
	  * @modify: share 2016年9月5日
	  * @param request
	  * @param payReq
	  * @return
	 */
	@RequestMapping("/nopay_order")
	public Result<String> nopayOrder(HttpServletRequest request,@RequestBody PayRequest payReq){
		Result<String> result = new Result<String>();
		/**
		 * 订单信息基本校验
		 */
		try {  
            VlidationUtil.validate(payReq);  
        } catch (ValidationException e) {  
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg(e.getMessage());
            return result;
        }
		try {
			LogCvt.info("0元支付请求");
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			payReq.setUserId(userWeixin.getId());
			payReq.setOpenId(openid);
			OrderPayInfo payment = paymentSupport.noPay(payReq);
			orderSupport.paySuccess(payment);
			LogCvt.info("0元支付结束:"+payment.getOrderId());
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
	 *  0元支付
	  * @Title: payOrder
	  * @Description: TODO
	  * @author: share 2016年9月5日
	  * @modify: share 2016年9月5日
	  * @param request
	  * @param payReq
	  * @return
	 */
	@RequestMapping("/v2/nopay_order")
	public Result<String> nopayOrder(HttpServletRequest request,String orderId){
		Result<String> result = new Result<String>();
		try {
			LogCvt.info("0元支付请求");
			String openid = String.valueOf(request.getAttribute("openid"));
			OrderPayInfo payment = paymentSupport.noPay(orderId,openid);
			orderV2Support.paySuccess(payment);
			LogCvt.info("0元支付结束:"+payment.getOrderId());
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
