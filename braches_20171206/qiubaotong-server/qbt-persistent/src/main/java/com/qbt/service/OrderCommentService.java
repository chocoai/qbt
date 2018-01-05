package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderComment;

public interface OrderCommentService {
	
	int insert(OrderComment comment);
	
	int updateById(OrderComment comment);
	
	List<OrderComment> findByPage(PageEntity<OrderComment> pageEntity);
	
	List<OrderComment> queryForWechat(int lastRecordId, int pageSize);
	
	OrderComment findByOrderNumber(String orderNumber);
}
