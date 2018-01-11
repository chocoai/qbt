package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
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
import com.qbt.web.pojo.ticket.TicketPackageOrderAddReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderPageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageOrderVo;
import com.qbt.web.pojo.ticket.TicketPackagePageReqVo;
import com.qbt.web.pojo.ticket.TicketPackageVo;
import com.qbt.web.pojo.ticket.TicketPageReqVo;
import com.qbt.web.pojo.ticket.TicketVo;
import com.qbt.web.support.TicketPackageOrderSupport;
import com.qbt.web.support.TicketPackageSupport;
import com.qbt.web.support.TicketSupport;

@Controller
@RequestMapping("/ticketPackageOrder")
public class TicketPackageOrderController {
	
	@Resource
	private TicketPackageOrderSupport ticketPackageOrderSupport;
	
	@Resource
	private TicketPackageSupport ticketPackageSupport;
	
	@Resource
	private TicketSupport ticketSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody TicketPackageOrderAddReqVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(ticketPackageOrderSupport.add(vo));
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
	public PageResult<List<TicketPackageOrderVo>> findByPage(@RequestBody TicketPackageOrderPageReqVo reqVo){
		PageResult<List<TicketPackageOrderVo>> result = new PageResult<List<TicketPackageOrderVo>>();
		try {
			result.setDatas(ticketPackageOrderSupport.findByPage(reqVo));
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
	public Result<TicketPackageOrderVo> detail(Integer id){
		Result<TicketPackageOrderVo> result = new Result<TicketPackageOrderVo>();
		try {
			TicketPackageOrderVo ticketPackageOrder = ticketPackageOrderSupport.findById(id);
			
			// get the ticket packages by orderId
			TicketPackagePageReqVo packageReqVo = new TicketPackagePageReqVo();
			packageReqVo.setOrderId(ticketPackageOrder.getId());
			List<TicketPackageVo> packages = ticketPackageSupport.findByPage(packageReqVo);
			ticketPackageOrder.setTicketPackageVos(packages);
			if(packages != null) {
				
				// get the tickets by packageId
				for(TicketPackageVo tp: packages) {
					TicketPageReqVo ticketReqVo = new TicketPageReqVo();
					ticketReqVo.setPackageId(tp.getId());
					List<TicketVo> tickets = ticketSupport.findByPage(ticketReqVo);
					tp.setTicketVos(tickets);
				}
			}
			
			result.setDatas(ticketPackageOrder);
		} catch (Exception e) {
			String errMsg = "查询订单异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateTicketPackageOrder")
	public Result<Boolean> updateOrder(@RequestBody TicketPackageOrderVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(ticketPackageOrderSupport.update(vo));
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
	
	@RequestMapping("updateTicketPackage")
	public Result<Boolean> updatePackage(@RequestBody TicketPackageVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(ticketPackageSupport.update(vo));
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
	public Result<Boolean> updateTicket(@RequestBody TicketVo vo){
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
