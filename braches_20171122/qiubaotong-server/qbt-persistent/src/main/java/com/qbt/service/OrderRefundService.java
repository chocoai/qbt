package com.qbt.service;

import java.util.Date;
import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderRefund;
import com.qbt.persistent.entity.OrderRefund;

public interface OrderRefundService {

	int insert(OrderRefund info);

    OrderRefund findById(Integer id);

    int updateById(OrderRefund info);
	
    List<BossOrderRefund> findByPage(PageEntity<BossOrderRefund> pageEntity);
    
    OrderRefund findByOrderId(Integer orderId);
    
    List<OrderRefund> findByOrderDate(Date startDate, Date endDate);
}
