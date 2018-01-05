package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderWaybill;
import com.qbt.persistent.mapper.OrderWaybillMapper;
import com.qbt.service.OrderWaybillService;

@Service
public class OrderWaybillServiceImpl implements OrderWaybillService {
	
	@Resource
	private OrderWaybillMapper orderWaybillMapper;
	
	@Override
	public List<OrderWaybill> findByOrderId(Integer orderId) {
		return orderWaybillMapper.findByOrderId(orderId);
	}

	@Override
	public int insert(OrderWaybill orderWaybill) {
		// TODO Auto-generated method stub
		return orderWaybillMapper.insert(orderWaybill);
	}

	@Override
	public int exists(String sfid) {
		// TODO Auto-generated method stub
		return orderWaybillMapper.exists(sfid);
	}

}
