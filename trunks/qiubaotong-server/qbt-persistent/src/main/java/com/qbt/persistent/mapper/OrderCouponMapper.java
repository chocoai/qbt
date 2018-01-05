package com.qbt.persistent.mapper;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderCoupon;

public interface OrderCouponMapper {
    int insert(OrderCoupon orderCoupon);

    OrderCoupon findByCode(@Param("couponId")int couponId, @Param("orderId")int orderId); 
    
    int updateByOrderCancel(@Param("couponId")int couponId, @Param("orderId")int orderId,@Param("discount")double discount);

}