package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.OrderActivityBook;
import com.qbt.service.OrderActivityBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.web.pojo.orderactivitybook.OrderActivityBookPageReqVo;
import com.qbt.web.pojo.orderactivitybook.OrderActivityBookVo;
import com.qbt.web.support.OrderActivityBookSupport;

@Service
public class OrderActivityBookSupportImpl implements OrderActivityBookSupport{

	@Resource
	private OrderActivityBookService orderActivityBookService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Override
	public List<OrderActivityBookVo> findByPage(OrderActivityBookPageReqVo reqVo) {
		PageEntity<OrderActivityBook> pageEntity = BeanUtil.pageConvert(reqVo, OrderActivityBook.class);
		List<OrderActivityBook> list = orderActivityBookService.findByPage(pageEntity);
		List<OrderActivityBookVo> voList = BeanUtil.list2list(list, OrderActivityBookVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
