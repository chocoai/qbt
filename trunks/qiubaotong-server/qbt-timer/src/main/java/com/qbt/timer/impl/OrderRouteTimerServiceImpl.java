package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.CommonSfRoute;
import com.qbt.bussiness.support.OrderSfRouteCommonSupport;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.MD5Util;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderWaybillService;
import com.qbt.sf.api.bean.orderconfirm.Route;
import com.qbt.sf.api.bean.route.RouteRepOrder;
import com.qbt.sf.api.bean.route.RouteReq;
import com.qbt.sf.api.bean.route.RouteReqBody;
import com.qbt.sf.api.bean.route.RouteResp;
import com.qbt.sf.api.bean.route.RouteRespBody;
import com.qbt.sf.api.bean.route.RouteRespDeliver;
import com.qbt.sf.api.service.SFExpressApiService;
import com.qbt.sf.api.util.JaxbUtil;
import com.qbt.timer.TimerService;

@Service("orderRouteTimerService")
public class OrderRouteTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private SFExpressApiService sfExpressApiService;
	
	@Resource
	private OrderWaybillService orderWaybillService;
	
	@Resource
	private OrderSfRouteCommonSupport orderSfRouteCommonSupport;
	
	@Override
	public void process() {
		List<OrderInfo> orderList = orderInfoService.findRouteableOrders();
		if(Checker.isNotEmpty(orderList)){
			RouteRepOrder reporder = null;
			RouteReqBody reqBody = null;
			RouteReq req = null;
			RouteResp resp = null;
			RouteRespBody respBody = null;
			RouteRespDeliver deliverRoute = null;
			for(OrderInfo orderInfo : orderList){
				if(Checker.isNotEmpty(orderInfo.getMailNo())){
					reporder = new RouteRepOrder();
					reporder.setTracking_type(1);
					reporder.setTracking_number(orderInfo.getMailNo());
					reporder.setMethod_type("1");
					reqBody = new RouteReqBody();
					reqBody.setRoute(reporder);
					req = new RouteReq();
					req.setBody(reqBody);
					try {
						resp = sfExpressApiService.routeService(req);
						if(Checker.isEmpty(resp)){
							LogCvt.error("运单号[" + orderInfo.getMailNo() + "] 路由查询无数据");
							continue;
						}
						LogCvt.info(JaxbUtil.convertToXml(resp));
					} catch (Exception e) {
						LogCvt.error("运单号[" + orderInfo.getMailNo() + "] 路由查询异常", e);
						continue;
					}
					
					if("OK".equals(resp.getHead())){
						respBody = resp.getBody();
						deliverRoute = respBody.getDeliverRoute();
						if(Checker.isNotEmpty(deliverRoute)){
							List<Route> routeList = deliverRoute.getRoute();
							if(Checker.isNotEmpty(routeList)){
								for(Route route : routeList){
									try {
										String sfId = MD5Util.MD5(deliverRoute.getMailno() + route.getAccept_time() + route.getOpcode());
										
										if(orderWaybillService.exists(sfId) > 0 )continue;
										
										CommonSfRoute commonSfRoute = new CommonSfRoute();
										commonSfRoute.setMailNo(deliverRoute.getMailno());
										commonSfRoute.setAcceptTime(route.getAccept_time());
										commonSfRoute.setAcceptAddress(route.getAccept_address());
										commonSfRoute.setRemark(route.getRemark());
										commonSfRoute.setOpCode(route.getOpcode());
										orderSfRouteCommonSupport.orderRoute(sfId, orderInfo, commonSfRoute);
									} catch (Exception e) {
										LogCvt.error("物流编号[" + deliverRoute.getMailno() + "] 路由时间[" + route.getAccept_time() + "] 路由操作码[" + route.getOpcode() + "] 处理物流信息异常", e);
										continue;
									}
								}
							}
						}
					}else{
						LogCvt.error("运单号[" + orderInfo.getMailNo() + "] 路由查询失败");
						continue;
					}
				}else{
					LogCvt.error("订单编号[" + orderInfo.getNumber() + "] 查无运单号");
				}
			}
		}
	}
	
}
