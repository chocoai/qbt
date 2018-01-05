package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

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
import com.qbt.web.pojo.baseSfTime.BaseSfTimePageReqVo;
import com.qbt.web.pojo.baseSfTime.BaseSfTimeVo;
import com.qbt.web.support.BaseSfTimeSupport;

/**
 * 顺丰时效调整
 * @author wuwang
 *
 */
@Controller
@RequestMapping("baseSfTime")
public class BaseSfTimeController {

	@Resource
	private BaseSfTimeSupport baseSfTimeSupport;
	
	/*
	 * 分页
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseSfTimeVo>> findByPage(@RequestBody BaseSfTimePageReqVo reqVo){
		PageResult<List<BaseSfTimeVo>> result = new PageResult<List<BaseSfTimeVo>>();
		try {
			result.setDatas(baseSfTimeSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰时效调整分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 添加
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseSfTimeVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseSfTimeSupport.add(vo);
			result.setDatas("添加顺丰时效调整成功");
		}catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加顺丰时效调整异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 编辑
	 * @param Vo
	 * @return
	 */
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseSfTimeVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseSfTimeSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findById")
	public Result<BaseSfTimeVo> findById(Integer id){
		Result<BaseSfTimeVo> result = new Result<BaseSfTimeVo>();
		BaseSfTimeVo vo = null;
		try {
			vo = baseSfTimeSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vo);
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseSfTimeSupport.deleteById(id);
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
