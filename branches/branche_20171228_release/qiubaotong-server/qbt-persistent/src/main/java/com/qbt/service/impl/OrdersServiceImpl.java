package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.mapper.OrdersMapper;
import com.qbt.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper ordersMapper;
	
	@Override
	public int insert(Orders order) {
		ordersMapper.insert(order);
		return order.getId();
	}

	@Override
	public Orders findById(int id) {
		return ordersMapper.findById(id);
	}

	@Override
	public int update(Orders bigOrder) {
		return ordersMapper.updateById(bigOrder);
	}

	@Override
	public Orders findByNumber(String number) {
		return ordersMapper.findByNumber(number);
	}

	/**
	 * 全部和待付款
	 */
	@Override
	public List<Orders> findByUserIdForWeiXin(OrderPageDto pageDto) {
		return ordersMapper.findByUserIdForWeiXin(pageDto);
	}

	@Override
	public List<Orders> queryPartnerOrder(OrderPageDto pageDto) {
		return ordersMapper.queryPartnerOrder(pageDto);
	}

	@Override
	public int updateSubNumber(String number, Integer orderId) {
		return ordersMapper.updateSubNumber(number,orderId);
	}

	@Override
	public void updateUserId(int id, int userId, String openId) {
		ordersMapper.updateUserId(id,userId,openId);
	}

}
