package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderOperateLog;

public interface OrderOperateLogMapper {
	
    int insert(OrderOperateLog log);
    
    OrderOperateLog findById(@Param("id")Integer id);
    
    List<OrderOperateLog> findByOrderId(@Param("orderId")Integer orderId);
    
    int insertByBatch(@Param("logs")List<OrderOperateLog> logs);
    
}