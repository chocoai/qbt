package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderComment;

public interface OrderCommentMapper {
	
	int insert(OrderComment comment);
	
	int updateById(OrderComment comment);
	
	List<OrderComment> findByPage(PageEntity<OrderComment> pageEntity);
	
	List<OrderComment> queryForWechat(@Param("lastRecordId")int lastRecordId, @Param("pageSize")int pageSize);
	
	OrderComment findByOrderNumber(@Param("orderNumber")String orderNumber);
}
