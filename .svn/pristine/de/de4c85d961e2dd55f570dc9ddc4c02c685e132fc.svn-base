package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderComment;
import com.qbt.persistent.mapper.OrderCommentMapper;
import com.qbt.service.OrderCommentService;

@Service
public class OrderCommentServiceImpl implements OrderCommentService {
	
	@Resource
	private OrderCommentMapper orderCommentMapper;
	
	@Override
	public int insert(OrderComment comment) {
		orderCommentMapper.insert(comment);
		return comment.getId();
	}

	@Override
	public int updateById(OrderComment comment) {
		return orderCommentMapper.updateById(comment);
	}

	@Override
	public List<OrderComment> findByPage(PageEntity<OrderComment> pageEntity) {
		return orderCommentMapper.findByPage(pageEntity);
	}

	@Override
	public List<OrderComment> queryForWechat(int lastRecordId, int pageSize) {
		return orderCommentMapper.queryForWechat(lastRecordId, pageSize);
	}

	@Override
	public OrderComment findByOrderNumber(String orderNumber) {
		return orderCommentMapper.findByOrderNumber(orderNumber);
	}

}
