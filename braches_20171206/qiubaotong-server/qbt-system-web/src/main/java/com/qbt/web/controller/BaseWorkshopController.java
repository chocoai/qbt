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
import com.qbt.web.pojo.baseWorkShop.BaseWorkshopPageReqVo;
import com.qbt.web.pojo.baseWorkShop.BaseWorkshopVo;
import com.qbt.web.support.BaseWorkshopSupport;

@Controller
@RequestMapping("baseWorkshop")
public class BaseWorkshopController {
	
	@Resource
	private BaseWorkshopSupport baseWorkshopSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseWorkshopVo>> findByPage(@RequestBody BaseWorkshopPageReqVo reqVo){
		PageResult<List<BaseWorkshopVo>> result = new PageResult<List<BaseWorkshopVo>>();
		try {
			result.setDatas(baseWorkshopSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "工坊信息表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseWorkshopVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseWorkshopSupport.add(vo);
			result.setDatas("添加工坊成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加工坊异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseWorkshopVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseWorkshopSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新工坊异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BaseWorkshopVo> findById(Integer id){
		Result<BaseWorkshopVo> result = new Result<BaseWorkshopVo>();
		BaseWorkshopVo baseWorkshopVo = null;
		try {
			baseWorkshopVo = baseWorkshopSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看工坊详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseWorkshopVo);
		return result;
	}
	
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseWorkshopSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除工坊异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
