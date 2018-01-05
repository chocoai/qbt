package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.mapper.OrderExceptionBookMapper;
import com.qbt.service.OrderExceptionBookService;

/**
 *  订单异常登记
  * @ClassName: OrderExceptionBookServiceImpl
  * @Description: TODO
  * @author share 2016年8月16日
  * @modify share 2016年8月16日
 */
@Service
public class OrderExceptionBookServiceImpl implements OrderExceptionBookService {

	@Resource
	private OrderExceptionBookMapper orderExceptionBookMapper;
	
	@Override
	public int insert(OrderExceptionBook orderExceptionBook) {
		orderExceptionBookMapper.insert(orderExceptionBook);
		return orderExceptionBook.getId();
	}

	@Override
	public int update(OrderExceptionBook orderExceptionBook) {
		return orderExceptionBookMapper.updateById(orderExceptionBook);
	}

	@Override
	public List<OrderExceptionBook> findByPage(PageEntity<OrderExceptionBook> pageEntity) {
		return orderExceptionBookMapper.findByPage(pageEntity);
	}

}
