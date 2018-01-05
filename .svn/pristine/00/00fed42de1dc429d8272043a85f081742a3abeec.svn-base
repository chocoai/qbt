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
import com.qbt.web.pojo.languageMobile.LanguageMobilePageReqVo;
import com.qbt.web.pojo.languageMobile.LanguageMobileVo;
import com.qbt.web.support.LanguageMobileSupport;

@Controller
@RequestMapping("/languageMobile")
public class LanguageMobileController {
	
	@Resource
	private LanguageMobileSupport languageMobileSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody LanguageMobileVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(languageMobileSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增白名单手机异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(String mobile){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(languageMobileSupport.delete(mobile));
		} catch (Exception e) {
			String errMsg = "删除白名单手机异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<LanguageMobileVo>> findByPage(@RequestBody LanguageMobilePageReqVo reqVo){
		PageResult<List<LanguageMobileVo>> result = new PageResult<List<LanguageMobileVo>>();
		try {
			result.setDatas(languageMobileSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "白名单手机分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
