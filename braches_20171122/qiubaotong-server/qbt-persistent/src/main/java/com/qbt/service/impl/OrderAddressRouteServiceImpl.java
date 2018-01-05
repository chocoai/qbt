
 /**
 * @Title: OrderAddressRouteServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.OrderAddressRoutePageDto;
import com.qbt.persistent.entity.OrderAddressRoute;
import com.qbt.persistent.mapper.OrderAddressRouteMapper;
import com.qbt.service.OrderAddressRouteService;

/**
  * @ClassName: OrderAddressRouteServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */
@Service
public class OrderAddressRouteServiceImpl implements OrderAddressRouteService {

	@Resource
	private OrderAddressRouteMapper orderAddressRouteMapper;
	
	@Override
	public String findMaxDate() {
		return orderAddressRouteMapper.findMaxDate();
	}

	@Override
	public int insert(OrderAddressRoute orderAddressRoute) {
		return orderAddressRouteMapper.insert(orderAddressRoute);
	}

	@Override
	public List<OrderAddressRoutePageDto> findByPageForUserSummary(PageEntity<OrderAddressRoutePageDto> pageEntity) {
		return orderAddressRouteMapper.findByPageForUserSummary(pageEntity);
	}

}
