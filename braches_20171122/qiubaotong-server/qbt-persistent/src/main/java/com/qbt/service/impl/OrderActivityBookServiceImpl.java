package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderActivityBook;
import com.qbt.persistent.mapper.OrderActivityBookMapper;
import com.qbt.service.OrderActivityBookService;

@Service
public class OrderActivityBookServiceImpl implements OrderActivityBookService{

	@Resource
	private OrderActivityBookMapper orderActivityBookMapper;
	
	@Override
	public int insert(OrderActivityBook orderActivityBook) {
		// TODO Auto-generated method stub
		orderActivityBookMapper.insert(orderActivityBook);
		return orderActivityBook.getId();
	}

	@Override
	public List<OrderActivityBook> findByPage(
			PageEntity<OrderActivityBook> pageEntity) {
		// TODO Auto-generated method stub
		return orderActivityBookMapper.findByPage(pageEntity);
	}

	@Override
	public int updateStatus(int orderId) {
		// TODO Auto-generated method stub
		return orderActivityBookMapper.updateStatus(orderId);
	}

}
