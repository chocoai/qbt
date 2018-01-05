
 /**
 * @Title: OrderAddressRouteMapper.java
 * @Package com.qbt.persistent.mapper
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.OrderAddressRoutePageDto;
import com.qbt.persistent.entity.OrderAddressRoute;

/**
  * @ClassName: OrderAddressRouteMapper
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public interface OrderAddressRouteMapper {

	String findMaxDate();
	
	int insert(OrderAddressRoute orderAddressRoute);
	
	List<OrderAddressRoutePageDto> findByPageForUserSummary(PageEntity<OrderAddressRoutePageDto> pageEntity);
}
