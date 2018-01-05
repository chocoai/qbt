/**
 * Project Name:qbt-persistent
 * File Name:OrderCostItemServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月19日下午1:44:59
 *
*/

package com.qbt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderCostItem;
import com.qbt.persistent.mapper.OrderCostItemMapper;
import com.qbt.service.OrderCostItemService;

/**
 * ClassName:OrderCostItemServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午1:44:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderCostItemServiceImpl implements OrderCostItemService {
	
	@Resource
	private OrderCostItemMapper orderCostItemMapper;
	
	@Override
	public int insert(OrderCostItem orderCostItem) {
		orderCostItemMapper.insert(orderCostItem);
		return orderCostItem.getId();
	}

	@Override
	public OrderCostItem findById(Integer id) {
		return orderCostItemMapper.selectById(id);
	}

	@Override
	public int deleteById(Integer id) {
		return orderCostItemMapper.deleteById(id);
	}

	@Override
	public List<OrderCostItem> findByPage(PageEntity<OrderCostItem> pageEntity) {
		return orderCostItemMapper.findByPage(pageEntity);
	}

	@Override
	public List<OrderCostItem> findCostItemByOrderDate(Date startDate, Date endDate) {
		return orderCostItemMapper.findCostItemByOrderDate(startDate, endDate);
	}

}
