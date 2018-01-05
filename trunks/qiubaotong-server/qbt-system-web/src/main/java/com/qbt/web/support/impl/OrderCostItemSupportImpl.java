/**
 * Project Name:qbt-system-web
 * File Name:OrderCostItemSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月19日下午2:49:24
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.OrderCostItem;
import com.qbt.service.OrderCostItemService;
import com.qbt.web.pojo.orderCostItem.OrderCostItemPageReqVo;
import com.qbt.web.pojo.orderCostItem.OrderCostItemVo;
import com.qbt.web.support.OrderCostItemSupport;

/**
 * ClassName:OrderCostItemSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午2:49:24
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderCostItemSupportImpl implements OrderCostItemSupport {
	
	@Resource
	private OrderCostItemService orderCostItemService;
	
	@Override
	public boolean add(OrderCostItemVo vo) {
		OrderCostItem item = BeanUtil.a2b(vo, OrderCostItem.class);
		orderCostItemService.insert(item);
		return item.getId() > 0;
	}

	@Override
	public boolean delete(Integer id) {
		return orderCostItemService.deleteById(id) > 0;
	}

	@Override
	public List<OrderCostItemVo> findByPage(OrderCostItemPageReqVo reqVo) {
		PageEntity<OrderCostItem> pageEntity = BeanUtil.pageConvert(reqVo, OrderCostItem.class);
		List<OrderCostItem> list = orderCostItemService.findByPage(pageEntity);
		List<OrderCostItemVo> voList = BeanUtil.list2list(list, OrderCostItemVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
