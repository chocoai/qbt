package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.thirdOrder.ThirdOrderPageReqVo;
import com.qbt.web.pojo.thirdOrder.ThirdOrderVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.ThirdOrderSupport;

@Controller
@RequestMapping("/thirdOrder")
public class ThirdOrderController {

	@Resource
	private ThirdOrderSupport thirdOrderSupport;
	
	@Resource
	private LoginSupport loginSupport;

	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<ThirdOrderVo>> findByPage(@RequestBody ThirdOrderPageReqVo reqVo) {
		PageResult<List<ThirdOrderVo>> result = new PageResult<List<ThirdOrderVo>>();
		try {
			result.setDatas(thirdOrderSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("合作方订单分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "settlement", method = RequestMethod.POST)
	public Result<Boolean> settlement(HttpServletRequest request, @RequestBody ThirdOrderVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setSysUserId(sysUser.getId());
			vo.setSysUserName(sysUser.getName());
			result.setDatas(thirdOrderSupport.settlement(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("合作方订单结算异常");
		}
		return result;
	}
	
	@RequestMapping(value = "settlementBatch", method = RequestMethod.POST)
	public Result<Boolean> settlementBatch(HttpServletRequest request, @RequestBody ThirdOrderPageReqVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(thirdOrderSupport.settlementBatch(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("合作方订单批量结算异常");
		}
		return result;
	}
	
	@RequestMapping(value = "findSettlementBatch", method = RequestMethod.POST)
	public Result<Boolean> findSettlementBatch(@RequestBody ThirdOrderPageReqVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(thirdOrderSupport.findSettlementBatch(vo));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("查询批量结算合作方订单异常");
		}
		return result;
	}
	
}
