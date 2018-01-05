package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.airport.AirportPageReqVo;
import com.qbt.web.pojo.airport.BaseAirportVo;
import com.qbt.web.support.AirportSupport;

@RequestMapping("/airport")
@Controller
public class AirportController {
	
	@Resource
	private AirportSupport airportSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseAirportVo>> findByPage(@RequestBody AirportPageReqVo reqVo){
		PageResult<List<BaseAirportVo>> result = new PageResult<List<BaseAirportVo>>();
		try {
			result.setDatas(airportSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "机场分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<BaseAirportVo> detail(Integer id){
		Result<BaseAirportVo> result = new Result<BaseAirportVo>();
		try {
			result.setDatas(airportSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "机场详情查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody BaseAirportVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(airportSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增机场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody BaseAirportVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(airportSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新机场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(airportSupport.delete(id));
		} catch (Exception e) {
			String errMsg = "删除机场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	//软删除
	@RequestMapping(value = "deleteById")
	public Result<Boolean> deleteById(@RequestParam(value = "id", required = true)Integer id
								, @RequestParam(value = "isDelete", required = false, defaultValue = "true")Boolean isDelete){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(airportSupport.deleteById(id, isDelete));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除顺丰站点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
