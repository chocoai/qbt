package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BossOrderPayInfo;
import com.qbt.service.OrderPayInfoService;
import com.qbt.web.pojo.payment.PaymentPageReqVo;
import com.qbt.web.pojo.payment.PaymentVo;
import com.qbt.web.support.PaymentSupport;

@Service
public class PaymentSupportImpl implements PaymentSupport {
	
	@Resource
	private OrderPayInfoService orderPayInfoService;
	
	@Override
	public List<PaymentVo> findByPage(PaymentPageReqVo reqVo) {
		PageEntity<BossOrderPayInfo> pageEntity = BeanUtil.pageConvert(reqVo, BossOrderPayInfo.class);
		List<BossOrderPayInfo> list = orderPayInfoService.findByPage(pageEntity);
		List<PaymentVo> voList = BeanUtil.list2list(list, PaymentVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
