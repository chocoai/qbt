package com.qbt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderRefund;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.mapper.OrderRefundMapper;
import com.qbt.service.OrderRefundService;

/**
 *  订单退款服务
  * @ClassName: OrderRefundServiceImpl
  * @Description: TODO
  * @author share 2016年8月16日
  * @modify share 2016年8月16日
 */
@Service
public class OrderRefundServiceImpl implements OrderRefundService {

	@Resource
	private OrderRefundMapper orderRefundMapper;
	
	@Override
	public int insert(OrderRefund info) {
		orderRefundMapper.insert(info);
		return info.getId();
	}

	@Override
	public OrderRefund findById(Integer id) {
		return orderRefundMapper.findById(id);
	}

	@Override
	public int updateById(OrderRefund info) {
		return orderRefundMapper.updateById(info);
	}

	@Override
	public List<BossOrderRefund> findByPage(PageEntity<BossOrderRefund> pageEntity) {
		return orderRefundMapper.findByPage(pageEntity);
	}

	@Override
	public OrderRefund findByOrderId(Integer orderId) {
		return orderRefundMapper.findByOrderId(orderId);
	}

	@Override
	public List<OrderRefund> findByOrderDate(Date startDate, Date endDate) {
		return orderRefundMapper.findByOrderDate(startDate, endDate);
	}

}
