package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderPayInfo;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.mapper.OrderPayInfoMapper;
import com.qbt.service.OrderPayInfoService;

/**
 *  支付流水
  * @ClassName: OrderPayInfoServiceImpl
  * @Description: TODO
  * @author share 2016年8月15日
  * @modify share 2016年8月15日
 */
@Service
public class OrderPayInfoServiceImpl implements OrderPayInfoService {

	@Resource
	private OrderPayInfoMapper orderPayInfoMapper;
	
	@Override
	public int insert(OrderPayInfo payment) {
		return orderPayInfoMapper.insert(payment);
	}

	@Override
	public OrderPayInfo findByPayno(String payno) {
		return orderPayInfoMapper.findByPayno(payno);
	}

	@Override
	public OrderPayInfo findById(int id) {
		return orderPayInfoMapper.findById(id);
	}

	@Override
	public int updateById(OrderPayInfo payInfo) {
		return orderPayInfoMapper.updateById(payInfo);
	}

	public OrderPayInfo findByOrderId(int orderId, double payAmount, int paymethod) {
		return orderPayInfoMapper.findByOrderId(orderId, payAmount,paymethod);
	}

	@Override
	public List<BossOrderPayInfo> findByPage(PageEntity<BossOrderPayInfo> pageEntity) {
		return orderPayInfoMapper.findByPage(pageEntity);
	}
	
	public int updateOrderIdByOrderId(int oldOrderId, int newOrderId) {
		return orderPayInfoMapper.updateOrderIdByOrderId(oldOrderId,newOrderId);
	}

}
