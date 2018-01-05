package com.qbt.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BaseException;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.Orders;
import com.qbt.service.OrdersService;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.OfficialOrderConfirm;
import com.qbt.web.pojo.order.OrderDetailWaybill;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.PaymentSupport;

@Controller
@RequestMapping("/official")
public class OfficialController {

	@Resource
	private OrderSupport orderSupport;
	
	@Resource
	private PaymentSupport paymentSupport;
	
	@Resource
	private OrdersService ordersService;

	@RequestMapping(value="/track_order")
	public Result<OrderDetailWaybill> trackOrderOffical(@RequestParam("keyword")String keyword){
		Result<OrderDetailWaybill> result = new Result<OrderDetailWaybill>();
		try{
			result.setDatas(orderSupport.trackOrder(keyword));
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
	
	@RequestMapping(value="/order_create")
	public Result<String> officialOrderCreate(@RequestBody OfficialOrderConfirm orderConfirm){
		Result<String> result = new Result<String>();
		try{
			result.setDatas(orderSupport.officialOrderCreate(orderConfirm));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (BaseException e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/pay")
	public Result<String> officialPay(@RequestParam("orderNumber")String orderNumber){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(paymentSupport.officialPay(orderNumber));
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
	
	@RequestMapping("/order_detail")
	public Result<BigOrderDetail> orderDetail(@RequestParam("orderNumber")String orderNumber){
		Result<BigOrderDetail> result = new Result<BigOrderDetail>();
		try {
			result.setDatas(orderSupport.officialUnpayOrderDetail(orderNumber));
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
	
	@RequestMapping("/order_pay_status")
	public Result<Map<String, Object>> orderPayStatus(@RequestParam("orderNumber")String orderNumber){
		Result<Map<String, Object>> result = new Result<Map<String, Object>>();
		try {
			Orders bigOrder = ordersService.findByNumber(orderNumber);
			Map<String, Object> map = new HashMap<String, Object>();
			if(Checker.isNotEmpty(bigOrder)){
				map.put("payStatus", bigOrder.getPayStatus());
				map.put("orderStatus", bigOrder.getOrderStatus());
			}
			result.setDatas(map);
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
