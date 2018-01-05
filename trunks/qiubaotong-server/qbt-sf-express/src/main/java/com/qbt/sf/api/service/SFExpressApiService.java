package com.qbt.sf.api.service;

import java.util.List;

import com.qbt.sf.api.bean.delivertm.DeliverTmReq;
import com.qbt.sf.api.bean.delivertm.DeliverTmResp;
import com.qbt.sf.api.bean.identity.IdentityReq;
import com.qbt.sf.api.bean.identity.IdentitySearchResp;
import com.qbt.sf.api.bean.order.OrderReq;
import com.qbt.sf.api.bean.order.OrderResp;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseReq;
import com.qbt.sf.api.bean.orderOrdeReverse.OrderReverseResp;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmReq;
import com.qbt.sf.api.bean.orderconfirm.OrderConfirmResp;
import com.qbt.sf.api.bean.orderfilter.OrderFilterReq;
import com.qbt.sf.api.bean.orderfilter.OrderFilterResp;
import com.qbt.sf.api.bean.orderfilterpush.OrderFilterPushReq;
import com.qbt.sf.api.bean.orderfilterresult.OrderFilterResultResp;
import com.qbt.sf.api.bean.ordersearch.OrderSearchReq;
import com.qbt.sf.api.bean.ordersearch.OrderSearchResp;
import com.qbt.sf.api.bean.orderzd.OrderZDReq;
import com.qbt.sf.api.bean.orderzd.OrderZDResp;
import com.qbt.sf.api.bean.queryfreight.QueryFreightReq;
import com.qbt.sf.api.bean.queryfreight.QueryFreightResp;
import com.qbt.sf.api.bean.route.RouteReq;
import com.qbt.sf.api.bean.route.RouteResp;
import com.qbt.sf.api.bean.scope.ScopeReq;
import com.qbt.sf.api.bean.scope.ScopeResp;
import com.qbt.sf.api.bean.website.DeliverReq;
import com.qbt.sf.api.bean.website.DeliverResp;

public interface SFExpressApiService {
	public OrderResp orderService(OrderReq req)throws Exception; 
	
	public OrderReverseResp orderReverseService(OrderReverseReq req )throws Exception; 
	
	
	public OrderConfirmResp  orderConfirmService(OrderConfirmReq req )throws Exception; 
	
	
	public OrderSearchResp orderSearchService(OrderSearchReq req)throws Exception; 
	
	
	public OrderFilterResp orderFilterService(OrderFilterReq req)throws Exception; 
	
	
	public OrderFilterResultResp orderFilterPushService(OrderFilterPushReq req)throws Exception; 
	
	
	public RouteResp routeService(RouteReq req)throws Exception; 
	
	
	public DeliverTmResp deliverTmService(DeliverTmReq req)throws Exception;
	
	public List<DeliverResp> deliverTmServiceBySfWebSite(DeliverReq deliverReq)throws Exception; 
	
	public ScopeResp scopeService(ScopeReq req)throws Exception; 
	
	
	public OrderZDResp orderZDService(OrderZDReq req)throws Exception; 
	
	
	public IdentitySearchResp identitySearchService(IdentityReq req)throws Exception; 
	
	public QueryFreightResp queryFreightService (QueryFreightReq req)throws Exception;


}
