package com.qbt.persistent.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderRefund;
import com.qbt.persistent.entity.OrderRefund;

public interface OrderRefundMapper {
	
    int insert(OrderRefund info);

    OrderRefund findById(Integer id);

    int updateById(OrderRefund record);
    
    List<BossOrderRefund> findByPage(PageEntity<BossOrderRefund> pageEntity);
    
    OrderRefund findByOrderId(@Param("orderId")Integer orderId);
    
    List<OrderRefund> findByOrderDate(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}