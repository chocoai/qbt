package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderPayInfo;
import com.qbt.persistent.entity.OrderPayInfo;

public interface OrderPayInfoService {

	public int insert(OrderPayInfo payment);
	
	public OrderPayInfo findByPayno(String payno);

	public OrderPayInfo findById(int id);

	public int updateById(OrderPayInfo payInfo);

	public OrderPayInfo findByOrderId(int orderId,double payAmount,int paymethod);
	
	public List<BossOrderPayInfo> findByPage(PageEntity<BossOrderPayInfo> pageEntity);

	public int updateOrderIdByOrderId(int oldOrderId,int newOrderId);
	
}
