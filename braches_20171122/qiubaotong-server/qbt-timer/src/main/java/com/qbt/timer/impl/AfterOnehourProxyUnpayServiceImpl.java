package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.SmsMsgSupport;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.service.OrderInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.UserProxyService;
import com.qbt.timer.TimerService;

@Service("afterOnehourProxyUnpayService")
public class AfterOnehourProxyUnpayServiceImpl extends TimerService {

	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private SaleUserService saleUserService;
	
	@Resource
	private UserProxyService userProxyService;
	
	@Resource
	private SmsMsgSupport smsMessageSupport;
	
	@Override
	public void process() {
		List<OrderInfo> orderInfoList =  orderInfoService.afterOnehourProxyUnpayList();
		UserProxy userProxy = null;
		for (OrderInfo orderInfo : orderInfoList) {
			//推送用户支付
			if(orderInfo.getUserId().equals(orderInfo.getProxySelfUserId())){
				SaleUser saleUser = saleUserService.findByUserId(orderInfo.getProxyUserId());
				userProxy = userProxyService.findByUserId(orderInfo.getProxyUserId(), orderInfo.getProxySelfUserId());
				if(Checker.isNotEmpty(saleUser)&&!orderInfo.getProxyUserId().equals(orderInfo.getProxySelfUserId())){
					smsMessageSupport.sendSaleProxyOrderMsg(saleUser, userProxy, orderInfo);
				}
			}
		}
	}
	
}
