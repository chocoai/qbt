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
import com.qbt.web.pojo.kf.UserKfPageReqVo;
import com.qbt.web.pojo.kf.UserKfVo;
import com.qbt.web.support.UserKfSupport;

@Controller
@RequestMapping("/kf")
public class UserKfController {
	
	@Resource
	private UserKfSupport userKfSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody UserKfVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(userKfSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		}catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增客服异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody UserKfVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userKfSupport.updateById(vo));
		} catch (Exception e) {
			String errMsg = "更新客服异常";
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
			result.setDatas(userKfSupport.delete(id));
		} catch (Exception e) {
			String errMsg = "删除客服异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<UserKfVo> detail(Integer id){
		Result<UserKfVo> result = new Result<UserKfVo>();
		try {
			result.setDatas(userKfSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "获取客服详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UserKfVo>> findByPage(@RequestBody UserKfPageReqVo reqVo){
		PageResult<List<UserKfVo>> result = new PageResult<List<UserKfVo>>();
		try {
			result.setDatas(userKfSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "分页查询客服异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
