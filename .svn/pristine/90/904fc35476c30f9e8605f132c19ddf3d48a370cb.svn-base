package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.OrderPageRequest;
import com.qbt.web.pojo.order.ShoppingCartOrderDetail;
import com.qbt.web.pojo.shoppingCart.CartRequest;

public interface ShoppingCartOrderSupport {

	public String orderCreate(CartRequest request);
	
	public ShoppingCartOrderDetail unpayOrderDetail(String orderId);
	
	public List<BigOrderDetail> orderList(OrderPageRequest order);

	public void paySuccess(OrderPayInfo payment);
 
	public List<BigOrderDetail> queryPartnerOrder(OrderPageRequest order);
}
