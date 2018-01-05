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
import com.qbt.web.pojo.outRangeAddress.OutRangeAddressPageReqVo;
import com.qbt.web.pojo.outRangeAddress.OutRangeAddressVO;
import com.qbt.web.support.OutRangeAddressSupport;

/**
 * 偏远地区
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/outRangeAddress")
public class OutRangeAddressController {

	@Resource
	private OutRangeAddressSupport outRangeAddressSupport; 
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OutRangeAddressVO>> findByPage(@RequestBody OutRangeAddressPageReqVo reqVo){
		PageResult<List<OutRangeAddressVO>> result = new PageResult<List<OutRangeAddressVO>>();
		try {
			result.setDatas(outRangeAddressSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody OutRangeAddressVO vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			outRangeAddressSupport.insert(vo);
			result.setDatas("添加成功。");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}	
	
	@RequestMapping(value = "findById")
	public Result<OutRangeAddressVO> findById(Integer id){
		Result<OutRangeAddressVO> result = new Result<OutRangeAddressVO>();
		OutRangeAddressVO vo = null;
		try {
			vo = outRangeAddressSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vo);
		return result;
	}
	
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			outRangeAddressSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody OutRangeAddressVO Vo){
		Result<String> result = new Result<String>();
		try {
			outRangeAddressSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
