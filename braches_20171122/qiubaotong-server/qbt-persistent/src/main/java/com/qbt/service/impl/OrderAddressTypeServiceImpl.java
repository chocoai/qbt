
 /**
 * @Title: OrderAddressTypeServiceImpl.java
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
import com.qbt.persistent.dto.OrderAddressTypePageDto;
import com.qbt.persistent.entity.OrderAddressType;
import com.qbt.persistent.mapper.OrderAddressTypeMapper;
import com.qbt.service.OrderAddressTypeService;

/**
  * @ClassName: OrderAddressTypeServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */
@Service
public class OrderAddressTypeServiceImpl implements OrderAddressTypeService {

	@Resource
	private OrderAddressTypeMapper orderAddressTypeMapper;
	
	@Override
	public String findMaxDate() {
		return orderAddressTypeMapper.findMaxDate();
	}

	@Override
	public int insert(OrderAddressType orderAddressType) {
		return orderAddressTypeMapper.insert(orderAddressType);
	}

	@Override
	public List<OrderAddressTypePageDto> findByPageForUserSummary(PageEntity<OrderAddressTypePageDto> pageEntity) {
		return orderAddressTypeMapper.findByPageForUserSummary(pageEntity);
	}

}
