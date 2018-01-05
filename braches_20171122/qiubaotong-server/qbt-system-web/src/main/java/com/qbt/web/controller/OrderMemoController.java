package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.order.OrderMemoVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderMemoSupport;

@Controller
@RequestMapping("/orderMemo")
public class OrderMemoController {
	
	@Resource
	private OrderMemoSupport orderMemoSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody OrderMemoVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setAccountId(sysUser.getId());
			vo.setAccountName(sysUser.getName());
			result.setDatas(orderMemoSupport.add(vo));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("新增订单便签异常");
		}
		return result;
	}
	
	@RequestMapping(value = "list")
	public Result<List<OrderMemoVo>> list(@RequestParam(value = "orderId", required = true)Integer orderId){
		Result<List<OrderMemoVo>> result = new Result<List<OrderMemoVo>>();
		try {
			result.setDatas(orderMemoSupport.findByOrderId(orderId));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单便签列表异常");
		}
		return result;
	}
	
}
