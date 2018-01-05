/**
 * Project Name:qbt-persistent
 * File Name:OrderCostItemService.java
 * Package Name:com.qbt.service
 * Date:2017年1月19日下午1:40:30
 *
*/

package com.qbt.service;

import java.util.Date;
import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrderCostItem;

/**
 * ClassName:OrderCostItemService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午1:40:30
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderCostItemService {
	
	int insert(OrderCostItem orderCostItem);

    OrderCostItem findById(Integer id);
    
    int deleteById(Integer id);
    
    List<OrderCostItem> findByPage(PageEntity<OrderCostItem> pageEntity);

	List<OrderCostItem> findCostItemByOrderDate(Date startDate, Date endDate);
}
