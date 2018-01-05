package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderCoupon;
import com.qbt.persistent.mapper.OrderCouponMapper;
import com.qbt.service.OrderCouponService;

@Service
public class OrderCouponServiceImpl implements OrderCouponService {

	@Resource
	private OrderCouponMapper orderCouponMapper;
	
	@Override
	public void insert(OrderCoupon orderCoupon) {
		orderCouponMapper.insert(orderCoupon);
	}

	@Override
	public OrderCoupon findByCode(int activityId, int orderId) {
		return orderCouponMapper.findByCode(activityId,orderId);
	}

	@Override
	public int updateByOrderCancel(int couponId, int orderId,double discount) {
		return orderCouponMapper.updateByOrderCancel(couponId, orderId,discount);
	}

}
