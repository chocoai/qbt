package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.payment.PaymentPageReqVo;
import com.qbt.web.pojo.payment.PaymentVo;

public interface PaymentSupport {
	
	List<PaymentVo> findByPage(PaymentPageReqVo reqVo);
	
}
