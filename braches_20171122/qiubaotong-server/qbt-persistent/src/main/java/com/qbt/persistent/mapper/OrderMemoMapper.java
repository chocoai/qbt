package com.qbt.persistent.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderMemo;

public interface OrderMemoMapper {
	
    int insert(OrderMemo memo);

    OrderMemo selectById(Integer id);

    int updateById(OrderMemo memo);
    
    List<OrderMemo> selectByOrderId(@Param("orderId")Integer orderId);
    
    List<OrderMemo> findMemoByOrderDate(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}