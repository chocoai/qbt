package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.refund.OrderRefundVo;
import com.qbt.web.pojo.refund.RefundPageReqVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderRefundSupport;

@RequestMapping("refund")
@Controller
public class OrderRefundController {
	
	@Resource
	private OrderRefundSupport orderRefundSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderRefundVo>> findByPage(@RequestBody RefundPageReqVo reqVo){
		PageResult<List<OrderRefundVo>> result = new PageResult<List<OrderRefundVo>>();
		try {
			result.setDatas(orderRefundSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "退款订单分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<OrderRefundVo> detail(Integer id){
		Result<OrderRefundVo> result = new Result<OrderRefundVo>();
		try {
			result.setDatas(orderRefundSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "退款详情查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody OrderRefundVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setKfName(sysUser.getName());
			vo.setKfMobile(sysUser.getMobile());
			result.setDatas(orderRefundSupport.update(vo));
		} catch (Exception e) {
			String errMsg = "退款修改异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
