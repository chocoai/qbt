package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderActivityBook;

public interface OrderActivityBookService {

	int insert(OrderActivityBook  orderActivityBook);
	
	List<OrderActivityBook> findByPage(PageEntity<OrderActivityBook> pageEntity);
	
	int updateStatus(int orderId);
	
}
