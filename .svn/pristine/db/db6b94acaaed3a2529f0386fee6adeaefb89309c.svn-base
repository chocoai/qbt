package com.qbt.persistent.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderPayInfo;
import com.qbt.persistent.entity.OrderPayInfo;

public interface OrderPayInfoMapper {
    int insert(OrderPayInfo record);

    OrderPayInfo findById(Integer id);
    
    int updateById(OrderPayInfo record);

	OrderPayInfo findByPayno(String payno);

	OrderPayInfo findByOrderId(@Param("orderId")int orderId, @Param("payAmount")double payAmount,@Param("payMethod")int payMethod);
	
	List<BossOrderPayInfo> findByPage(PageEntity<BossOrderPayInfo> pageEntity);

	int updateOrderIdByOrderId(@Param("oldOrderId")int oldOrderId,@Param("newOrderId") int newOrderId);
}