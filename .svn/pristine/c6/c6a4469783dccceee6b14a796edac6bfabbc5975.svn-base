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
import com.qbt.common.result.Paging;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.bspAreaConfig.BspAreaConfigVo;
import com.qbt.web.support.BspAreaConfigSupport;

@Controller
@RequestMapping("/bspAreaConfig")
public class BspAreaConfigController {
	
	@Resource
	private BspAreaConfigSupport bspAreaConfigSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BspAreaConfigVo>> findByPage(@RequestBody Paging paging){
		PageResult<List<BspAreaConfigVo>> result = new PageResult<List<BspAreaConfigVo>>();
		try {
			result.setDatas(bspAreaConfigSupport.findByPage(paging));
			result.setPage(paging);
		} catch (Exception e) {
			String errMsg = "bsp地区配置分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody BspAreaConfigVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(bspAreaConfigSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("新增bsp地区配置异常");
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(bspAreaConfigSupport.delete(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除bsp地区配置异常");
		}
		return result;
	}
	
}
