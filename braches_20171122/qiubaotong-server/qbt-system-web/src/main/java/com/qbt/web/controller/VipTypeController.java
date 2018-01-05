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
import com.qbt.web.pojo.vipType.VipTypePageReqVo;
import com.qbt.web.pojo.vipType.VipTypeVo;
import com.qbt.web.support.VipTypeSupport;

@Controller
@RequestMapping("vipType")
public class VipTypeController {

	@Resource
	private VipTypeSupport vipTypeSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<VipTypeVo>> findByPage(@RequestBody VipTypePageReqVo reqVo){
		PageResult<List<VipTypeVo>> result = new PageResult<List<VipTypeVo>>();
		try {
			result.setDatas(vipTypeSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "会员卡种类分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<VipTypeVo> findById(Integer id){
		Result<VipTypeVo> result = new Result<VipTypeVo>();
		VipTypeVo vipTypeVo = null;
		try {
			vipTypeVo = vipTypeSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "会员卡种类详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vipTypeVo);
		return result;
	}
	
	
	@RequestMapping(value = "updateStatus", method = RequestMethod.POST)
	public Result<String> updateStatus(@RequestBody VipTypeVo vo){
		Result<String> result = new Result<String>();
		try {
			vipTypeSupport.updateStatus(vo);
			result.setDatas("更新状态成功");
		}catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody VipTypeVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			vipTypeSupport.add(vo);
			result.setDatas("添加会员卡类型成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加添加会员卡类型异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
