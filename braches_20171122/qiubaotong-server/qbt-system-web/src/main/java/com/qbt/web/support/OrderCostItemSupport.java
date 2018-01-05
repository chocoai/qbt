/**
 * Project Name:qbt-system-web
 * File Name:OrderCostItemSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月19日下午2:05:04
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderCostItem.OrderCostItemPageReqVo;
import com.qbt.web.pojo.orderCostItem.OrderCostItemVo;

/**
 * ClassName:OrderCostItemSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午2:05:04
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderCostItemSupport {
	
	boolean add(OrderCostItemVo vo);
	
	boolean delete(Integer id);
	
	List<OrderCostItemVo> findByPage(OrderCostItemPageReqVo reqVo);
}
