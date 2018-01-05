
 /**
 * @Title: OrderAddressTypeMapper.java
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
import com.qbt.persistent.dto.OrderAddressTypePageDto;
import com.qbt.persistent.entity.OrderAddressType;

/**
  * @ClassName: OrderAddressTypeMapper
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public interface OrderAddressTypeMapper {

	String findMaxDate();
	
	int insert(OrderAddressType orderAddressType);
	
	List<OrderAddressTypePageDto> findByPageForUserSummary(PageEntity<OrderAddressTypePageDto> pageEntity);
}
