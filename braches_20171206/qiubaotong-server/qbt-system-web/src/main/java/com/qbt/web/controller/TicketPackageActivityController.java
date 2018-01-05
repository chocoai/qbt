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
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityPageReqVo;
import com.qbt.web.pojo.ticketPackageActivity.TicketPackageActivityVo;
import com.qbt.web.pojo.ticketPackageRule.TicketPackageRuleVo;
import com.qbt.web.support.TicketPackageActivitySupport;
import com.qbt.web.support.TicketPackageRuleSupport;


@Controller
@RequestMapping("/ticketPackageActivity")
public class TicketPackageActivityController {

	@Resource
	private TicketPackageActivitySupport ticketPackageActivitySupport;
	
	@Resource
	private TicketPackageRuleSupport ticketPackageRuleSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> insert(@RequestBody TicketPackageActivityVo reqVo){
		Result<Integer> result = new Result<Integer>();
		try {
			result.setDatas(ticketPackageActivitySupport.insert(reqVo));
		}
		catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}
		catch (Exception e) {
			String errMsg = "券包活动添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	} 
	
	@RequestMapping(value = "findByPage")
	public PageResult<List<TicketPackageActivityVo>> findByPage(@RequestBody TicketPackageActivityPageReqVo reqVo){
		
		PageResult<List<TicketPackageActivityVo>> result = new PageResult<List<TicketPackageActivityVo>>();
		try{
			
			List<TicketPackageActivityVo> ticketPackageActivitys = ticketPackageActivitySupport.findByPage(reqVo);
			
			if(ticketPackageActivitys != null) {
				for(TicketPackageActivityVo ticketPackage: ticketPackageActivitys) {
					try {
						TicketPackageRuleVo ticketPackageRuleVo = ticketPackageRuleSupport.findById(ticketPackage.getRuleId());
						ticketPackage.setTicketPackageRule(ticketPackageRuleVo);
					} catch (Exception e) {
						LogCvt.error(e.getMessage(), e);
					}
				}
			}
			
			result.setDatas(ticketPackageActivitys);
			result.setPage(reqVo);
		}catch(Exception e)
		{
			String errMsg = "券包活动查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		
		}
		
		return result;
	}

}
