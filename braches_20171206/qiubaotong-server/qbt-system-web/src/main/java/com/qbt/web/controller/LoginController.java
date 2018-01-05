package com.qbt.web.controller;

import javax.annotation.Resource;
import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.login.LoginReqVo;
import com.qbt.web.pojo.login.LoginRespVo;
import com.qbt.web.support.LoginSupport;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Result<LoginRespVo> login(@RequestBody LoginReqVo reqVo){
		Result<LoginRespVo> result = new Result<LoginRespVo>();
		try {
			VlidationUtil.validate(reqVo);
			
			LoginRespVo vo =loginSupport.login(reqVo);
			result.setDatas(vo);
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}  catch (Exception e) {
			String errMsg = "登录异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("logout")
	public Result<String> logout(String token){
		Result<String> result = new Result<String>();
		try {
			if(Checker.isEmpty(token)){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "token不能为空");
			}
			loginSupport.logout(token);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "登出异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
}
