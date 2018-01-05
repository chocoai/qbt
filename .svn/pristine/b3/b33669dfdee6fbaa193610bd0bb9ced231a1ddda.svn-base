package com.qbt.data.migration.process.impl;

import java.util.Date;
import java.util.List;

import com.qbt.common.enums.BigOrderPayStatus;
import com.qbt.common.enums.BigOrderStatus;
import com.qbt.common.enums.OrderSource;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Checker;
import com.qbt.common.util.ToolsUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.service.CommonService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderPayInfoService;
import com.qbt.service.OrdersService;

public class BigOrderProcess extends AbstractProcess {

	public BigOrderProcess(String name, ProcessServiceConfig config) {
		super(name, config);
	}

	@Override
	public void before() {
	}

	@Override
	public void process() throws Exception {
		OrdersService ordersService = SpringContextHolder.getBean("ordersServiceImpl");
		OrderPayInfoService orderPayInfoService = SpringContextHolder.getBean("orderPayInfoServiceImpl");
		OrderInfoService orderInfoService = SpringContextHolder.getBean("orderInfoServiceImpl");
		CommonService commonService = SpringContextHolder.getBean("commonServiceImpl");
		
		List<OrderInfo> orderList = orderInfoService.findAllSubOrder();
		if(Checker.isEmpty(orderList)){
			return;
		}
		for(OrderInfo orderInfo : orderList){
			Orders order = new Orders();
			order.setCreateTime(orderInfo.getCreateTime());
			order.setUpdateTime(orderInfo.getUpdateTime());
			if(orderInfo.getdAddrType() == 4){
				order.setdAddrName(orderInfo.getdAddress());
			}else{
				order.setdAddrName(orderInfo.getdAddrName());
			}
			order.setdContact(orderInfo.getdContact());
			order.setdMobile(orderInfo.getdMobile());
			order.setdTreePath(orderInfo.getdTreePath());
			order.setIsDelete(false);
			order.setIsHelped(orderInfo.getIsHelped());
			if(orderInfo.getjAddrType() == 4){
				order.setjAddrName(orderInfo.getjAddress());
			}else{
				order.setjAddrName(orderInfo.getjAddrName());
			}
			order.setjContact(orderInfo.getjContact());
			order.setjMobile(orderInfo.getjMobile());
			order.setjTreePath(orderInfo.getjTreePath());
			order.setNumber(commonService.createBigOrderId());
			order.setOpenId(orderInfo.getOpenid());
			order.setOrderSource(orderInfo.getOrderSource());
			order.setSubNumber(orderInfo.getNumber());
			int bigOrderStatus = BigOrderStatus.normal.getCode();
			int payStatus = BigOrderPayStatus.un_pay.getCode();
			int payMethod = 0;
			
			int orderStatus = orderInfo.getOrderStatus();
			Date payTime = orderInfo.getPayTime();
			if(orderStatus == 5 || orderStatus == 6 || orderStatus == 7){
				if(payTime !=null && payTime.getTime() > 0){
					Integer payId = orderInfo.getPayId();
					payStatus =  BigOrderPayStatus.paid.getCode();
					if(payId !=null && payId.intValue() > 0){
						OrderPayInfo payInfo = orderPayInfoService.findById(orderInfo.getPayId());
						payMethod = payInfo.getPayMethod();
					}else{
						payMethod = PaymethodEnum.weixin_pay.getCode();
					}
						
				}
				bigOrderStatus = BigOrderStatus.close.getCode();
			}else if(orderStatus == 3){
				Integer payId = orderInfo.getPayId();
				payStatus =  BigOrderPayStatus.paid.getCode();
				if(payId !=null && payId.intValue() > 0){
					OrderPayInfo payInfo = orderPayInfoService.findById(orderInfo.getPayId());
					payMethod = payInfo.getPayMethod();
				}else{
					payMethod = PaymethodEnum.weixin_pay.getCode();
				}
			}
			
			order.setOrderStatus(bigOrderStatus);
			order.setPayMethod(payMethod);
			order.setPayStatus(payStatus);
			order.setPayTime(payTime);
			order.setQuantity(1);
			order.setIsHelped(orderInfo.getIsHelped()==null?false:orderInfo.getIsHelped());
			order.setThirdId(orderInfo.getThirdId());
			order.setThirdName(orderInfo.getThirdName());
			order.setThirdType(orderInfo.getThirdType());
			order.setAssistantName(orderInfo.getAssistantName());
			order.setUserId(orderInfo.getUserId());
			order.setSubNumber(orderInfo.getNumber());
			order.setIsDelete(order.getIsDelete());
			order.setDeleteTime(order.getDeleteTime());
			order.setOrderSource(OrderSource.weixin.getCode());
			int id = ordersService.insert(order);
			
			orderInfo.setOrderId(id);
			orderInfo.setOrderNumber(orderInfo.getNumber());
			orderInfo.setMd5(ToolsUtil.getUUID());
			orderInfoService.updateByIdForBigOrder(orderInfo);
			
			orderPayInfoService.updateOrderIdByOrderId(orderInfo.getId(), id);
			
		}
	}

}
