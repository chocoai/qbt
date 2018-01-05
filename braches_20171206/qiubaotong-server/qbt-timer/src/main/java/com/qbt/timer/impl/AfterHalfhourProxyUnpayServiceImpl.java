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


/**
 * 当代下订单于下单时间30分钟后未支付，发手机短信至该客户手机号或该销售
 * @author wuwang
 *
 */
@Service("afterHalfhourProxyUnpayService")
public class AfterHalfhourProxyUnpayServiceImpl extends TimerService {

	@Resource
	private OrderInfoService orderInfoService; 
	
	@Resource
	private UserProxyService userProxyService;
	
	@Resource
	private SaleUserService saleUserService;
	
	@Resource
	private SmsMsgSupport smsMessageSupport;
	
	
	@Override
	public void process() {
		List<OrderInfo> orderInfoList =  orderInfoService.afterHalfhourProxyUnpayList();
		UserProxy userProxy = null;
		for (OrderInfo orderInfo : orderInfoList) {
			if(orderInfo.getUserId().equals(orderInfo.getProxySelfUserId())){
				//发送给客户，如果找不到客户就不用发了
				userProxy = userProxyService.findByUserId(orderInfo.getProxyUserId(), orderInfo.getUserId());
				if(Checker.isNotEmpty(userProxy)&&!orderInfo.getProxyUserId().equals(orderInfo.getProxySelfUserId())){
					smsMessageSupport.sendProxySelfOrderMsg(userProxy);
				}
			}else{
				//发送给销售
				SaleUser saleUser = saleUserService.findByUserId(orderInfo.getUserId());
				userProxy = userProxyService.findByUserId(orderInfo.getProxyUserId(), orderInfo.getProxySelfUserId());
				if(Checker.isNotEmpty(saleUser)){
					smsMessageSupport.sendSaleProxyOrderMsg(saleUser, userProxy, orderInfo);
				}
				
			}
			
		}
		
	}
	
}
