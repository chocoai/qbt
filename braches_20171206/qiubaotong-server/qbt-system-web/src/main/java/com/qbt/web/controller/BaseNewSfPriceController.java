package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPricePageReqVo;
import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPriceVo;
import com.qbt.web.support.BaseNewSfPriceSupport;

@Controller
@RequestMapping("baseNewSfPrice")
public class BaseNewSfPriceController {

	@Resource
	private BaseNewSfPriceSupport baseNewSfPriceSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseNewSfPriceVo>> findByPage(@RequestBody BaseNewSfPricePageReqVo reqVo){
		PageResult<List<BaseNewSfPriceVo>> result = new PageResult<List<BaseNewSfPriceVo>>();
		try {
			result.setDatas(baseNewSfPriceSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰价格管理分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseNewSfPriceVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseNewSfPriceSupport.add(vo);
			result.setDatas("添加成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BaseNewSfPriceVo> findById(Integer id){
		Result<BaseNewSfPriceVo> result = new Result<BaseNewSfPriceVo>();
		BaseNewSfPriceVo baseNewSfPriceVo = null;
		try {
			baseNewSfPriceVo = baseNewSfPriceSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseNewSfPriceVo);
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody BaseNewSfPriceVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseNewSfPriceSupport.update(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseNewSfPriceSupport.delete(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
