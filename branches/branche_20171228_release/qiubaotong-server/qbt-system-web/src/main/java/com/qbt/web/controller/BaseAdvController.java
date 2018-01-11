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
import com.qbt.web.pojo.baseAdv.BaseAdvPageReqVo;
import com.qbt.web.pojo.baseAdv.BaseAdvVo;
import com.qbt.web.support.BaseAdvSupport;

/**
 * 轮番广告模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseAdv")
public class BaseAdvController {

	@Resource
	private BaseAdvSupport baseAdvSupport;
	
	/**
	 * 添加
	 * @param baseBank
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseAdvVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseAdvSupport.add(vo);
			result.setDatas("添加轮播图广告成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加轮播图广告异常";
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
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(baseAdvSupport.delete(id));
		} catch (Exception e) {
			String errMsg = "删除轮播图广告异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 修改
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody BaseAdvVo reqVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(baseAdvSupport.update(reqVo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新轮播图广告异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 分页
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseAdvVo>> findByPage(@RequestBody BaseAdvPageReqVo reqVo) {
		PageResult<List<BaseAdvVo>> result = new PageResult<List<BaseAdvVo>>();
		try {
			result.setDatas(baseAdvSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "轮播图广告分页查询异常";
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
	public Result<BaseAdvVo> findById(Integer id){
		Result<BaseAdvVo> result = new Result<BaseAdvVo>();
		BaseAdvVo baseAdvVo = null;
		try {
			baseAdvVo = baseAdvSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看轮播图广告详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseAdvVo);
		return result;
	}
	
}
