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
import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityPageReqVo;
import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityVo;
import com.qbt.web.support.CouponCodeActivitySupport;

@Controller
@RequestMapping("/couponCodeActivity")
public class CouponCodeActivityController {

	@Resource
	private CouponCodeActivitySupport couponCodeActivitySupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<CouponCodeActivityVo>> findByPage(@RequestBody CouponCodeActivityPageReqVo reqVo){
		PageResult<List<CouponCodeActivityVo>> result = new PageResult<List<CouponCodeActivityVo>>();
		try {
			result.setDatas(couponCodeActivitySupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "优惠码管理查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody CouponCodeActivityVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(couponCodeActivitySupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<CouponCodeActivityVo> findById(Integer id){
		Result<CouponCodeActivityVo> result = new Result<CouponCodeActivityVo>();
		CouponCodeActivityVo vo = null;
		try {
			vo = couponCodeActivitySupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vo);
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody CouponCodeActivityVo Vo){
		Result<String> result = new Result<String>();
		try {
			couponCodeActivitySupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
