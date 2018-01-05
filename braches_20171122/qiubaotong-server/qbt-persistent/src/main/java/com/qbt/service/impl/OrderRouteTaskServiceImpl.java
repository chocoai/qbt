package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderRouteTask;
import com.qbt.persistent.mapper.OrderRouteTaskMapper;
import com.qbt.service.OrderRouteTaskService;

/**
 * 顺丰物流接口
  * @ClassName: OrderRouteTaskServiceImpl
  * @Description: TODO
  * @author share 2016年8月24日
  * @modify share 2016年8月24日
 */
@Service
public class OrderRouteTaskServiceImpl implements OrderRouteTaskService {

	@Resource
	private OrderRouteTaskMapper orderRouteTaskMapper;
	
	@Override
	public int insert(OrderRouteTask info) {
		// TODO Auto-generated method stub
		return orderRouteTaskMapper.insert(info);
	}

	@Override
	public OrderRouteTask findById(Integer id) {
		// TODO Auto-generated method stub
		return orderRouteTaskMapper.findById(id);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return orderRouteTaskMapper.update(id);
	}

	@Override
	public List<OrderRouteTask> findAll() {
		// TODO Auto-generated method stub
		return orderRouteTaskMapper.findAll();
	}

}
