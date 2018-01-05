package com.qbt.service;

import java.util.List;

import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.entity.Orders;

public interface OrdersService {

	int insert(Orders order);
	
	Orders findById(int id);
	
	Orders findByNumber(String number);

	int update(Orders bigOrder);

	List<Orders> findByUserIdForWeiXin(OrderPageDto pageDto);
	
	List<Orders> queryPartnerOrder(OrderPageDto pageDto);

	int updateSubNumber(String number, Integer orderId);

	void updateUserId(int id, int userId,String openId);
}
