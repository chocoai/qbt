package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderDelayTask;
import com.qbt.persistent.mapper.OrderDelayTaskMapper;
import com.qbt.service.OrderDelayTaskService;


@Service
public class OrderDelayTaskServiceImpl implements OrderDelayTaskService {

	@Resource
	private OrderDelayTaskMapper orderDelayTaskMapper;
	
	@Override
	public int insert(OrderDelayTask task) {
		return orderDelayTaskMapper.insert(task);
	}

	@Override
	public OrderDelayTask findById(int id) {
		return orderDelayTaskMapper.findById(id);
	}

	@Override
	public int updateById(int status, int id) {
		return orderDelayTaskMapper.updateById(status, id);
	}

	@Override
	public List<OrderDelayTask> findValidTasks() {
		return orderDelayTaskMapper.findValidTasks();
	}

}
