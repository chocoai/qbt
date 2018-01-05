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
import com.qbt.web.pojo.activityRule.ActivityRuleDetailVo;
import com.qbt.web.pojo.activityRule.ActivityRulePageReqVo;
import com.qbt.web.pojo.activityRule.ActivityRuleVo;
import com.qbt.web.support.ActivityRuleSupport;

@Controller
@RequestMapping("/activityRule")
public class ActivityRuleController {
	
	@Resource
	private ActivityRuleSupport activityRuleSupport;
	
	@RequestMapping("list")
	public Result<List<ActivityRuleVo>> list(){
		Result<List<ActivityRuleVo>> result = new Result<List<ActivityRuleVo>>();
		try {
			result.setDatas(activityRuleSupport.list());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("查询有效活动规则列表异常");
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<ActivityRuleVo>> findByPage(@RequestBody ActivityRulePageReqVo reqVo){
		PageResult<List<ActivityRuleVo>> result = new PageResult<List<ActivityRuleVo>>();
		try {
			result.setDatas(activityRuleSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("活动规则分页查询异常");
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<ActivityRuleDetailVo> detail(Integer id){
		Result<ActivityRuleDetailVo> result = new Result<ActivityRuleDetailVo>();
		try {
			result.setDatas(activityRuleSupport.findById(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("活动规则详情查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody ActivityRuleDetailVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(activityRuleSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("新增活动规则异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody ActivityRuleDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(activityRuleSupport.update(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("新增活动规则异常");
		}
		return result;
	}
	
}
