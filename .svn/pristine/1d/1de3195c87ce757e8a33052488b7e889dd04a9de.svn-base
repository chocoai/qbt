/**
 * Project Name:qbt-support
 * File Name:OrderCommonSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年8月21日下午1:57:03
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.OrderCommonSupport;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.entity.Orders;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrdersService;

/**
 * ClassName:OrderCommonSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月21日 下午1:57:03
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderCommonSupportImpl implements OrderCommonSupport {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Resource
	private OrdersService ordersService;
	
	@Override
	public void closeBigOrder(List<Integer> superOrderIds) {
		//查询子订单的有效订单数
		if (Checker.isNotEmpty(superOrderIds)) {
			List<OrderInfoSummary> bigOrderList = orderInfoService.summaryOrderBySuperOrderIds(superOrderIds);
			for (OrderInfoSummary o : bigOrderList) {
				if (o.getValidOrder() == 0) {
					// 如果子订单没有有效订单,则关闭大订单
					Orders bigOrder = new Orders();
					bigOrder.setId(o.getOrderId());
					bigOrder.setOrderStatus(2);// 大订单状态：1-正常 2-订单关闭(子订单全部关闭)
					ordersService.update(bigOrder);
				}
			}
		}
	}

}
