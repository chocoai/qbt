package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.CommonSfRoute;
import com.qbt.bussiness.support.OrderSfRouteCommonSupport;
import com.qbt.common.enums.DeliverCompany;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.MD5Util;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderWaybill;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderWaybillService;
import com.qbt.service.UserWeixinService;
import com.qbt.sf.api.bean.routepush.RoutePushReqDeliver;
import com.qbt.web.pojo.sf.WayBill;
import com.qbt.web.support.OrderWaybillSupport;

/**
 *  物流信息
  * @ClassName: OrderWaybillSupportImpl
  * @Description: TODO
  * @author share 2016年8月17日
  * @modify share 2016年8月17日
 */
@Service
public class OrderWaybillSupportImpl implements OrderWaybillSupport {

	@Resource
	private OrderWaybillService orderWaybillService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private OrderSfRouteCommonSupport orderSfRouteCommonSupport;
	
	/**
	 *  添加运单路由规则
	  * @Title: insert
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param deliver
	  * @see com.qbt.web.support.OrderWaybillSupport#insert(com.qbt.sf.api.bean.routepush.RoutePushReqDeliver)
	 */
	@Override
	public void insert(RoutePushReqDeliver deliver) {
		String sfId = MD5Util.MD5(deliver.getMailno() + deliver.getAcceptTime() + deliver.getOpCode());
		if(orderWaybillService.exists(sfId) > 0 )return;
		OrderInfo  orderInfo = orderInfoService.findByMailNo(deliver.getMailno());
		if(orderInfo == null){
			LogCvt.error("物流对于订单信息不存在");
			return;
		}
		
		CommonSfRoute commonSfRoute = new CommonSfRoute();
		commonSfRoute.setMailNo(deliver.getMailno());
		commonSfRoute.setAcceptTime(deliver.getAcceptTime());
		commonSfRoute.setAcceptAddress(deliver.getAcceptAddress());
		commonSfRoute.setRemark(deliver.getRemark());
		commonSfRoute.setOpCode(deliver.getOpCode());
		orderSfRouteCommonSupport.orderRoute(sfId, orderInfo, commonSfRoute);
	}

	/**
	 *  订单物流查询
	  * @Title: findByWayBill
	  * @Description: TODO
	  * @author: share 2016年8月18日
	  * @modify: share 2016年8月18日
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.OrderWaybillSupport#findByWayBill(java.lang.String)
	 */
	@Override
	public List<WayBill> findByWayBill(String orderId) {
		OrderInfo  orderInfo = orderInfoService.findByNumber(orderId);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "物流对于订单信息不存在");
		}
		List<OrderWaybill> wayList = orderWaybillService.findByOrderId(orderInfo.getId());
		List<WayBill> wayBillList = new ArrayList<WayBill>();
		for(OrderWaybill orderWaybill : wayList){
			WayBill way = new WayBill();
			way.setMailNo(orderWaybill.getMailNo());
			way.setDeliverCompany(DeliverCompany.SF.getDesc());
			way.setAcceptAddress(orderWaybill.getAcceptAddress());
			way.setAcceptTime(orderWaybill.getAcceptTime().getTime());
			way.setRemark(orderWaybill.getRemark());
			wayBillList.add(way);
		}
		return wayBillList;
	}
	
}
