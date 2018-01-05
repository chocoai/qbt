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
import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyPageReqVo;
import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyVo;
import com.qbt.web.support.BaseTravelAgencySupport;

@Controller
@RequestMapping("baseTravelAgency")
public class BaseTravelAgencyController {

	@Resource
	private BaseTravelAgencySupport baseTravelAgencySupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseTravelAgencyVo>> findByPage(@RequestBody BaseTravelAgencyPageReqVo reqVo){
		PageResult<List<BaseTravelAgencyVo>> result = new PageResult<List<BaseTravelAgencyVo>>();
		try {
			result.setDatas(baseTravelAgencySupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "旅行社信息分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseTravelAgencyVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseTravelAgencySupport.add(vo);
			result.setDatas("旅行社信息添加成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加旅行社信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseTravelAgencyVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseTravelAgencySupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新旅行社信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BaseTravelAgencyVo> findById(Integer id){
		Result<BaseTravelAgencyVo> result = new Result<BaseTravelAgencyVo>();
		BaseTravelAgencyVo baseTeachCenterVo = null;
		try {
			baseTeachCenterVo = baseTravelAgencySupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看教学中心详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseTeachCenterVo);
		return result;
	}
	
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseTravelAgencySupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除旅行社信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
