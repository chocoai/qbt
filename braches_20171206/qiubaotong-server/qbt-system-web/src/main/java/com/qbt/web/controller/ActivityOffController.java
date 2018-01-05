package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.activityOff.ActivityOffDetailVo;
import com.qbt.web.pojo.activityOff.ActivityOffPageReqVo;
import com.qbt.web.pojo.activityOff.ActivityOffVo;
import com.qbt.web.pojo.order.OrderActivityRequestVo;
import com.qbt.web.pojo.order.OrderActivityResponseVo;
import com.qbt.web.support.ActivityOffSupport;

@Controller
@RequestMapping("/activityOff")
public class ActivityOffController {
	
	@Resource
	private ActivityOffSupport activityOffSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<ActivityOffVo>> findByPage(@RequestBody ActivityOffPageReqVo reqVo){
		PageResult<List<ActivityOffVo>> result = new PageResult<List<ActivityOffVo>>();
		try {
			result.setDatas(activityOffSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "满减活动规则分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<ActivityOffDetailVo> detail(@RequestParam(value = "id", required = true)Integer id){
		Result<ActivityOffDetailVo> result = new Result<ActivityOffDetailVo>();
		try {
			result.setDatas(activityOffSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "满减活动规则详情查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody ActivityOffDetailVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(activityOffSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增满减活动规则异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update")
	public Result<Boolean> update(@RequestParam(value = "id", required = true)Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(activityOffSupport.update(id));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新满减活动规则异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(activityOffSupport.delete(id));
		} catch (Exception e) {
			String errMsg = "删除满减活动规则异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "checkActivity")
	public Result<OrderActivityResponseVo> checkActivity(@RequestBody OrderActivityRequestVo orderActivityVo){
		Result<OrderActivityResponseVo> result = new Result<OrderActivityResponseVo>();
		try {
			result.setDatas(activityOffSupport.checkActivity(orderActivityVo));
		} catch (Exception e) {
			String errMsg = "删除满减活动规则异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
