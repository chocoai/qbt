package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigAddReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigPageReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.SfNotifyConfigSupport;

@Controller
@RequestMapping("/sfnotify")
public class SfNotifyConfigController {
	
	@Resource
	private SfNotifyConfigSupport sfNotifyConfigSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "disable", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody SfNotifyConfigAddReqVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			
			VlidationUtil.validate(vo);
			result.setDatas(sfNotifyConfigSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "取消通知异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "enable", method = RequestMethod.POST)
	public Result<Boolean> enable(@RequestBody SfNotifyConfigPageReqVo reqVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			List<SfNotifyConfigVo> notifys = sfNotifyConfigSupport.findByPage(reqVo);
			if(notifys != null && notifys.size()>0) {
				result.setDatas(sfNotifyConfigSupport.deleteById(notifys.get(0).getId())>0);
			}else {
				result.setDatas(true);
			}
		} catch (Exception e) {
			String errMsg = "恢复通知异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<SfNotifyConfigVo>> findByPage(@RequestBody SfNotifyConfigPageReqVo reqVo){
		PageResult<List<SfNotifyConfigVo>> result = new PageResult<List<SfNotifyConfigVo>>();
		try {
			result.setDatas(sfNotifyConfigSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "通知分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

}
