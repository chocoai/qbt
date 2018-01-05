package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.base.BaseVersionVo;
import com.qbt.web.support.BaseVersionSupport;

@Controller
@RequestMapping("/version")
public class BaseVersionController {
	
	@Resource
	private BaseVersionSupport baseVersionSupport;
	
	@RequestMapping("list")
	public Result<List<BaseVersionVo>> list(){
		Result<List<BaseVersionVo>> result = new Result<List<BaseVersionVo>>();
		try {
			result.setDatas(baseVersionSupport.findAll());
		} catch (Exception e) {
			String errMsg = "里程碑查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody BaseVersionVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			result.setDatas(baseVersionSupport.add(vo));
		} catch (Exception e) {
			String errMsg = "新增里程碑异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
