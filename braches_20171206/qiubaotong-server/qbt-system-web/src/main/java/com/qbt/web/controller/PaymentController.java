package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.payment.PaymentPageReqVo;
import com.qbt.web.pojo.payment.PaymentVo;
import com.qbt.web.support.PaymentSupport;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@Resource
	private PaymentSupport paymentSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<PaymentVo>> findByPage(@RequestBody PaymentPageReqVo reqVo){
		PageResult<List<PaymentVo>> result = new PageResult<List<PaymentVo>>();
		try {
			result.setDatas(paymentSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "支付流水分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
