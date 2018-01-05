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
import com.qbt.web.pojo.baseInsTemp.BaseInsTempPageReqVo;
import com.qbt.web.pojo.baseInsTemp.BaseInsTempVo;
import com.qbt.web.support.BaseInsTempSupport;

/**
 * 保价模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseInsTemp")
public class BaseInsTempController {
	
	@Resource
	private BaseInsTempSupport baseInsTempSupport;
	
	/**
	 * 获取列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseInsTempVo>> findByPage(@RequestBody BaseInsTempPageReqVo reqVo){
		PageResult<List<BaseInsTempVo>> result = new PageResult<List<BaseInsTempVo>>();
		try {
			result.setDatas(baseInsTempSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰保价分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 新增保价
	 * @param baseInsuredTemplate
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseInsTempVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseInsTempSupport.add(vo);
			result.setDatas("添加成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加顺丰价格异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseInsTempVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseInsTempSupport.update(vo);
			result.setDatas("更新成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			String errMsg = "更新顺丰价格异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
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
			baseInsTempSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除保价异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

}
