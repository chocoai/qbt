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
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.ticket.UserActivityOrderAddReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailPageReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderDetailVo;
import com.qbt.web.pojo.ticket.UserActivityOrderPageReqVo;
import com.qbt.web.pojo.ticket.UserActivityOrderVo;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserActivityOrderDetailSupport;
import com.qbt.web.support.UserActivityOrderSupport;
import com.qbt.web.support.UserActivityPackageSupport;
import com.qbt.web.support.UserPackageTicketSupport;

@Controller
@RequestMapping("/ticketPackageOrder")
public class TicketPackageOrderController {
	
	@Resource
	private UserActivityOrderSupport userActivityOrderSupport;
	
	@Resource
	private UserActivityOrderDetailSupport userActivityOrderDetailSupport;
	
	@Resource
	private UserActivityPackageSupport userActivityPackageSupport;
		
	@Resource
	private UserPackageTicketSupport ticketSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperatorId(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			
			vo.setUserId(sysUser.getId());
			
			result.setDatas(userActivityOrderSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增券包订单异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UserActivityOrderVo>> findByPage(@RequestBody UserActivityOrderPageReqVo reqVo){
		PageResult<List<UserActivityOrderVo>> result = new PageResult<List<UserActivityOrderVo>>();
		try {
			result.setDatas(userActivityOrderSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "订单分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<UserActivityOrderVo> detail(Integer id){
		Result<UserActivityOrderVo> result = new Result<UserActivityOrderVo>();
		try {
			UserActivityOrderVo userActivityOrderVo = userActivityOrderSupport.findById(id);
			
			// 获取订单详情
			UserActivityOrderDetailPageReqVo detailReqVo = new UserActivityOrderDetailPageReqVo();
			detailReqVo.setUserId(userActivityOrderVo.getUserId());
			detailReqVo.setOrderId(userActivityOrderVo.getId());
			List<UserActivityOrderDetailVo> details = userActivityOrderDetailSupport.findByPage(detailReqVo);
			userActivityOrderVo.setUserActivityOrderDetailVos(details);
			if(details != null) {
				for(UserActivityOrderDetailVo detail: details) {
					List<UserPackageTicketVo> tickets = ticketSupport.findTicketsForOrderDetail(detail.getId());
					detail.setTicketVos(tickets);
				}
			}
			
			result.setDatas(userActivityOrderVo);
		} catch (Exception e) {
			String errMsg = "查询订单异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateTicketPackageOrder")
	public Result<Boolean> updateOrder(@RequestBody UserActivityOrderVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userActivityOrderSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新订单异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateTicketPackageOrderDetail")
	public Result<Boolean> updateOrderDetail(@RequestBody UserActivityOrderDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userActivityOrderDetailSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新订单详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateTicketPackage")
	public Result<Boolean> updatePackage(@RequestBody UserActivityPackageVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userActivityPackageSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新券包异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateTicket")
	public Result<Boolean> updateTicket(@RequestBody UserPackageTicketVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(ticketSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新优惠券异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
