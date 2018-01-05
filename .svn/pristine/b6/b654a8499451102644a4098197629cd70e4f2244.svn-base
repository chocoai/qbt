package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRulePageReqVo;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleVo;
import com.qbt.web.support.TicketPackageRuleSupport;


@Controller
@RequestMapping("/ticketPackageRule")
public class TicketPackageRuleController {
	
	@Resource
	private TicketPackageRuleSupport ticketPackageRulesupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> insert(@RequestBody TicketPackageRuleVo reqVo){
		Result<Integer> result = new Result<Integer>();
		try {
			result.setDatas(ticketPackageRulesupport.insert(reqVo));
		}
		catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}
		catch (Exception e) {
			String errMsg = "券包规则添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	} 
	
	
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<TicketPackageRuleVo>> findByPage(@RequestBody TicketPackageRulePageReqVo reqVo){
		PageResult<List<TicketPackageRuleVo>> result = new PageResult<List<TicketPackageRuleVo>>();
		try {
			result.setDatas(ticketPackageRulesupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "券包规则搜索异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	} 
	
	@RequestMapping(value = "findById")
	public Result<TicketPackageRuleVo> findById(Integer id){
		Result<TicketPackageRuleVo> result = new Result<TicketPackageRuleVo>();
		try {
			result.setDatas(ticketPackageRulesupport.findById(id));
		} catch (Exception e) {
			String errMsg = "券包规则搜索异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	} 
	
}
