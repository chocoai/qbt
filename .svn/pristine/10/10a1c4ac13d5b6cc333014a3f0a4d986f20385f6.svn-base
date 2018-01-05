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
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.baseSfArea.BaseSfAreaVo;
import com.qbt.web.support.BaseSfAreaSupport;

/**
 * 顺丰地区模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("baseSfArea")
public class BaseSfAreaController {

	@Resource
	private BaseSfAreaSupport baseSfAreaSupport;
	
	/**
	 * 添加
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseSfAreaVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseSfAreaSupport.add(vo);
			result.setDatas("添加成功");
		}catch (ValidationException e) {
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
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findById")
	public Result<BaseSfAreaVo> findById(int id){
		Result<BaseSfAreaVo> result = new Result<BaseSfAreaVo>();
		try {
			BaseSfAreaVo baseSfAreaVo = baseSfAreaSupport.findById(id);
			result.setDatas(baseSfAreaVo);
		} catch (Exception e) {
			String errMsg = "根据id查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 通过父级Id获取
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "findByParentId")
	public Result<List<BaseSfAreaVo>> findByParentId(int parentId){
		Result<List<BaseSfAreaVo>> result = new Result<List<BaseSfAreaVo>>();
		try {
			List<BaseSfAreaVo> baseSfAreaVoList = baseSfAreaSupport.findByParentId(parentId);
			result.setDatas(baseSfAreaVoList);
		} catch (Exception e) {
			String errMsg = "根据parentId查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	
	/**
	 * 通过父级Id获取
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "findDistrictById")
	public Result<List<BaseSfAreaVo>> findDistrictById(@RequestParam("id")int id){
		Result<List<BaseSfAreaVo>> result = new Result<List<BaseSfAreaVo>>();
		try {
			List<BaseSfAreaVo> baseSfAreaVoList = baseSfAreaSupport.findDistrictByParentId(id);
			result.setDatas(baseSfAreaVoList);
		} catch (Exception e) {
			String errMsg = "根据parentId查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *根据id更新
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody BaseSfAreaVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseSfAreaSupport.update(vo);
			result.setDatas("更新成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 根据名称获取
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "findByName")
	public Result<BaseSfAreaVo> findByName(String name){
		Result<BaseSfAreaVo> result = new Result<BaseSfAreaVo>();
		try {
			BaseSfAreaVo baseSfAreaVo = baseSfAreaSupport.findByName(name);
			result.setDatas(baseSfAreaVo);
		} catch (Exception e) {
			String errMsg = "根据名称查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 根据区查
	 * @param name
	 * @param district
	 * @return
	 */
	@RequestMapping(value = "findByDistrict")
	public Result<BaseSfAreaVo> findByDistrict(String name, String district){
		Result<BaseSfAreaVo> result = new Result<BaseSfAreaVo>();
		try {
			BaseSfAreaVo baseSfAreaVo = baseSfAreaSupport.findByDistrict(name, district);
			result.setDatas(baseSfAreaVo);
		} catch (Exception e) {
			String errMsg = "根据区查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *根据level查
	 * @param level
	 * @return
	 */
	@RequestMapping(value = "findByLevel")
	public Result<List<BaseSfAreaVo>> findByLevel(int level){
		Result<List<BaseSfAreaVo>> result = new Result<List<BaseSfAreaVo>>();
		try {
			List<BaseSfAreaVo> baseSfAreaVoList = baseSfAreaSupport.findByLevel(level);
			result.setDatas(baseSfAreaVoList);
		} catch (Exception e) {
			String errMsg = "根据名称查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
