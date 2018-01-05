package com.qbt.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.sysConfig.SysConfigVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.SysConfigSupport;

@Controller
@RequestMapping("sysConfig")
public class SysConfigController {
	
	@Resource
	private SysConfigSupport sysConfigSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
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
	@RequestMapping(value = "updateByCode")
	public Result<Boolean> updateByCode(HttpServletRequest request,@RequestBody SysConfigVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try{
			if(StringUtils.isEmpty(vo.getValue())){
				result.setMsg("系统配置值不能为空！");
				result.setDatas(false);
			}
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			sysConfigSupport.updateByCode(vo.getCode(), vo.getValue(), sysUser);
			result.setDatas(true);
		}catch(Exception e){
			String errMsg = "修改系统配置异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
