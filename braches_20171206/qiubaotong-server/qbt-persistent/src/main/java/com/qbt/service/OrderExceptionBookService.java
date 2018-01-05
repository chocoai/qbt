package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderExceptionBook;

public interface OrderExceptionBookService {

	public int insert(OrderExceptionBook orderExceptionBook);
	
	public int update(OrderExceptionBook orderExceptionBook);
	
	public List<OrderExceptionBook> findByPage(PageEntity<OrderExceptionBook> pageEntity);
}
