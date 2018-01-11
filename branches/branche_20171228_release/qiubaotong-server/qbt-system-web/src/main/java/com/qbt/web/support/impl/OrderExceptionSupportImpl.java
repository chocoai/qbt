package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.service.OrderExceptionBookService;
import com.qbt.web.pojo.orderexception.OrderExceptionBookVo;
import com.qbt.web.pojo.orderexception.OrderExceptionPageReqVo;
import com.qbt.web.support.OrderExceptionSupport;

@Service
public class OrderExceptionSupportImpl implements OrderExceptionSupport {
	
	@Resource
	private OrderExceptionBookService orderExceptionBookService;
	
	@Override
	public List<OrderExceptionBookVo> findByPage(OrderExceptionPageReqVo reqVo) {
		PageEntity<OrderExceptionBook> pageEntity = BeanUtil.pageConvert(reqVo, OrderExceptionBook.class);
		List<OrderExceptionBook> list = orderExceptionBookService.findByPage(pageEntity);
		List<OrderExceptionBookVo> voList = BeanUtil.list2list(list, OrderExceptionBookVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public boolean dealOrderException(OrderExceptionBookVo vo) {
		OrderExceptionBook condition = new OrderExceptionBook();
		condition.setId(vo.getId());
		condition.setIsDealed(true);
		condition.setSysUserId(vo.getSysUserId());
		condition.setUserName(vo.getUserName());
		condition.setRemark(vo.getRemark());
		return orderExceptionBookService.update(condition) > 0;
	}

}
