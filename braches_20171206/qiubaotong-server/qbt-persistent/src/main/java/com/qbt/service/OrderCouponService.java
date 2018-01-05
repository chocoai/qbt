package com.qbt.service;

import com.qbt.persistent.entity.OrderCoupon;

/**
 * 订单优惠券
 * @author wuwang
 *
 */
public interface OrderCouponService {

	void insert(OrderCoupon orderCoupon);
	
	OrderCoupon findByCode(int couponId, int orderId);
	
	int updateByOrderCancel(int couponId, int orderId,double discount);
	
}
