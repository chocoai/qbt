package com.qbt.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.support.SysConfigSupport;

@Controller
@RequestMapping("sysConfig")
public class SysController {
	@Resource
	private SysConfigSupport sysConfigSupport;
	
	@RequestMapping(value = "findByCode")
	public Result<String> findByCode(String code){
		Result<String> result = new Result<String>();
		try{
			result.setDatas(sysConfigSupport.findByCode(code));
		}catch(Exception e){
			String errMsg = "查询系统配置异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
