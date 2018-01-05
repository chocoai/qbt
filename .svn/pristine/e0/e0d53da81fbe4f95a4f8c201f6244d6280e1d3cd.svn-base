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
import com.qbt.common.util.Checker;
import com.qbt.web.pojo.coupon.CouponPageReqVo;
import com.qbt.web.pojo.coupon.CouponVo;
import com.qbt.web.support.CouponSupport;

@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	@Resource
	private CouponSupport couponSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<CouponVo>> findByPage(@RequestBody CouponPageReqVo reqVo){
		PageResult<List<CouponVo>> result = new PageResult<List<CouponVo>>();
		try {
			result.setDatas(couponSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "优惠券分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "export", method = RequestMethod.POST)
	public Result<String> export(@RequestBody CouponPageReqVo reqVo){
		Result<String> result = new Result<String>();
		try {
			if(Checker.isEmpty(reqVo.getActivityId())){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "活动ID不能为空");
			}
			result.setDatas(couponSupport.exportCoupon(reqVo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "优惠券分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody CouponVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			couponSupport.update(vo);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "优惠券更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
