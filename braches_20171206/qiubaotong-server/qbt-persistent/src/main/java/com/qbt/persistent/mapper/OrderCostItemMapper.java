package com.qbt.persistent.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderCostItem;

public interface OrderCostItemMapper {
	
    int insert(OrderCostItem record);

    OrderCostItem selectById(@Param("id")Integer id);
    
    int deleteById(@Param("id")Integer id);
    
    List<OrderCostItem> findByPage(PageEntity<OrderCostItem> pageEntity);

	List<OrderCostItem> findCostItemByOrderDate(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}