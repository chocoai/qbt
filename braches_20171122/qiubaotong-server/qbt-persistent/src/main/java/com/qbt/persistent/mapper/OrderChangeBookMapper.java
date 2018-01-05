package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderChangeBook;
import com.qbt.persistent.entity.OrderChangeBook;

public interface OrderChangeBookMapper {
	
	List<OrderChangeBook> findByPage(PageEntity<BossOrderChangeBook> pageEntity);

	int insert(OrderChangeBook book);
	
	OrderChangeBook findByNewOrderNumber(String newOrderNumber);

	int update(OrderChangeBook book);

}