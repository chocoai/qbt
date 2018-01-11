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
import com.qbt.web.pojo.urgent.UrgentAddReqVo;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UrgentSupport;

@Controller
@RequestMapping("/urgent")
public class UrgentController {
	
	@Resource
	private UrgentSupport urgentSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody UrgentAddReqVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			
			VlidationUtil.validate(vo);
			result.setDatas(urgentSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增加急异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UrgentVo>> findByPage(@RequestBody UrgentPageReqVo reqVo){
		PageResult<List<UrgentVo>> result = new PageResult<List<UrgentVo>>();
		try {
			result.setDatas(urgentSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "加急分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<UrgentVo> detail(Integer id){
		Result<UrgentVo> result = new Result<UrgentVo>();
		try {
			result.setDatas(urgentSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "查询加急详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("update")
	public Result<Boolean> update(HttpServletRequest request, @RequestBody UrgentVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			
			result.setDatas(urgentSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "加急更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

	@RequestMapping("delete")
	public Result<Boolean> deleteById(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(urgentSupport.deleteById(id)>0);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	
	}
}
