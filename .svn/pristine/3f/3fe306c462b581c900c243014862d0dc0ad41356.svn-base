package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BossOrderChangeBook;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.service.OrderChangeBookService;
import com.qbt.web.pojo.orderChangeBook.OrderChangeBookPageReqVo;
import com.qbt.web.pojo.orderChangeBook.OrderChangeBookVo;
import com.qbt.web.support.OrderChangeBookSupport;

@Service
public class OrderChangeBookSupportImpl implements OrderChangeBookSupport {

	@Resource
	private OrderChangeBookService orderChangeBookService;
	
	@Override
	public List<OrderChangeBookVo> findByPage(OrderChangeBookPageReqVo reqVo) {
		PageEntity<BossOrderChangeBook> pageEntity = BeanUtil.pageConvert(reqVo, BossOrderChangeBook.class);
		List<OrderChangeBook> orderChangeBookList = orderChangeBookService.findByPage(pageEntity);
		List<OrderChangeBookVo> voList = BeanUtil.list2list(orderChangeBookList, OrderChangeBookVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
