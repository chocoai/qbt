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
import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteReqVo;
import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteVo;
import com.qbt.web.support.BaseCourseSfSiteSupport;

@Controller
@RequestMapping("baseCourseSfSite")
public class BaseCourseSfSiteController {

	@Resource
	private BaseCourseSfSiteSupport baseCourseSfSiteSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseCourseSfSiteVo>> findByPage(@RequestBody BaseCourseSfSiteReqVo reqVo){
		PageResult<List<BaseCourseSfSiteVo>> result = new PageResult<List<BaseCourseSfSiteVo>>();
		try {
			result.setDatas(baseCourseSfSiteSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "球场周边顺丰站点信息分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseCourseSfSiteVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseCourseSfSiteSupport.add(vo);
			result.setDatas("添加球场周边顺丰站点信息成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加球场周边顺丰站点信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseCourseSfSiteVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseCourseSfSiteSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新球场周边顺丰站点信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BaseCourseSfSiteVo> findById(Integer id){
		Result<BaseCourseSfSiteVo> result = new Result<BaseCourseSfSiteVo>();
		BaseCourseSfSiteVo baseWorkshopVo = null;
		try {
			baseWorkshopVo = baseCourseSfSiteSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看球场周边顺丰站点信息详情异常";
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
			baseCourseSfSiteSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除球场周边顺丰站点信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
