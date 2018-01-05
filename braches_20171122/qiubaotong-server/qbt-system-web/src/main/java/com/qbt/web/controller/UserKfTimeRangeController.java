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
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeMapVo;
import com.qbt.web.pojo.sfkf.UserKfTimeRangeVo;
import com.qbt.web.support.UserKfTimeRangeSupport;

@Controller
@RequestMapping("/kftime")
public class UserKfTimeRangeController {
	
	@Resource
	private UserKfTimeRangeSupport userKfTimeRangeSupport;
	
	@RequestMapping("list")
	public Result<List<UserKfTimeRangeMapVo>> list(){
		Result<List<UserKfTimeRangeMapVo>> result = new Result<List<UserKfTimeRangeMapVo>>();
		try {
			result.setDatas(userKfTimeRangeSupport.findAllMap());
		} catch (Exception e) {
			String errMsg = "查询顺丰客服服务列表异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userKfTimeRangeSupport.deleteById(id));
		} catch (Exception e) {
			String errMsg = "删除顺丰客服服务时间异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody UserKfTimeRangeVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			//参数校验
			VlidationUtil.validate(vo);
			if(vo.getBegin() == vo.getEnd()){
				throw new ValidationException("请选择正确的时间段");
			}
			result.setDatas(userKfTimeRangeSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增顺丰客服服务时间异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
