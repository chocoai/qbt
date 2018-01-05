package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderChangeBook;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.mapper.OrderChangeBookMapper;
import com.qbt.service.OrderChangeBookService;

@Service
public class OrderChangeBookServiceImpl implements OrderChangeBookService {

	@Resource
	private OrderChangeBookMapper orderChangeBookMapper;
	
	@Override
	public List<OrderChangeBook> findByPage(PageEntity<BossOrderChangeBook> pageEntity) {
		return orderChangeBookMapper.findByPage(pageEntity);
	}

	@Override
	public void insert(OrderChangeBook book) {
		orderChangeBookMapper.insert(book);
	}
	
	public OrderChangeBook findByNewOrderNumber(String newOrderNumber) {
		return orderChangeBookMapper.findByNewOrderNumber(newOrderNumber);
	}

	@Override
	public int update(OrderChangeBook book) {
		return orderChangeBookMapper.update(book);
	}

}
