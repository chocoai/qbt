package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderChangeBook;
import com.qbt.persistent.entity.OrderChangeBook;

public interface OrderChangeBookService {

	List<OrderChangeBook> findByPage(PageEntity<BossOrderChangeBook> pageEntity);

	void insert(OrderChangeBook book);
	
	int update(OrderChangeBook book);

	public OrderChangeBook findByNewOrderNumber(String newOrderNumber);
	
}
