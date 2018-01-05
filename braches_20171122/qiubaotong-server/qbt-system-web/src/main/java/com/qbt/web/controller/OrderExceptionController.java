package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderexception.OrderExceptionBookVo;
import com.qbt.web.pojo.orderexception.OrderExceptionPageReqVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderExceptionSupport;

@Controller
@RequestMapping("/orderException")
public class OrderExceptionController {
	
	@Resource
	private OrderExceptionSupport orderExceptionSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderExceptionBookVo>> findByPage(@RequestBody OrderExceptionPageReqVo reqVo){
		PageResult<List<OrderExceptionBookVo>> result = new PageResult<List<OrderExceptionBookVo>>();
		try {
			result.setDatas(orderExceptionSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "异常订单分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "deal", method = RequestMethod.POST)
	public Result<Boolean> dealOrderException(HttpServletRequest request, @RequestBody OrderExceptionBookVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setSysUserId(sysUser.getId());
			vo.setUserName(sysUser.getName());
			result.setDatas(orderExceptionSupport.dealOrderException(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "异常订单处理异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
