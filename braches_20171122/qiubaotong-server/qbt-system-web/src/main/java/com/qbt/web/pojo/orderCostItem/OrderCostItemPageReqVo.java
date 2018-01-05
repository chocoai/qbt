/**
 * Project Name:qbt-system-web
 * File Name:OrderCostItemPageReqVo.java
 * Package Name:com.qbt.web.pojo.orderCostItem
 * Date:2017年1月19日下午2:21:54
 *
*/

package com.qbt.web.pojo.orderCostItem;

import com.qbt.common.result.Paging;

/**
 * ClassName:OrderCostItemPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午2:21:54
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCostItemPageReqVo extends Paging {
	
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
