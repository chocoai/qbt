/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressTypeSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年3月13日下午2:48:58
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.OrderAddressTypePageDto;
import com.qbt.service.OrderAddressTypeService;
import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageReqVo;
import com.qbt.web.pojo.orderAddressType.OrderAddressTypePageRespVo;
import com.qbt.web.support.OrderAddressTypeSupport;

/**
 * ClassName:OrderAddressTypeSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午2:48:58
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderAddressTypeSupportImpl implements OrderAddressTypeSupport {
	
	@Resource
	private OrderAddressTypeService orderAddressTypeService;
	
	@Override
	public List<OrderAddressTypePageRespVo> findByPage(OrderAddressTypePageReqVo reqVo) {
		PageEntity<OrderAddressTypePageDto> pageEntity = BeanUtil.pageConvert(reqVo, OrderAddressTypePageDto.class);
		if(Checker.isNotEmpty(reqVo.getSort())){
			if("country".equals(reqVo.getSort())){
				pageEntity.setOrderByColumn("country_area_id");
			}else if("province".equals(reqVo.getSort())){
				pageEntity.setOrderByColumn("province_area_id");
			}else if("city".equals(reqVo.getSort())){
				pageEntity.setOrderByColumn("city_area_id");
			}else if("district".equals(reqVo.getSort())){
				pageEntity.setOrderByColumn("district_area_id");
			}else if("address".equals(reqVo.getSort())){
				pageEntity.setOrderByColumn("address");
			}
		}
		List<OrderAddressTypePageDto> list = orderAddressTypeService.findByPageForUserSummary(pageEntity);
		List<OrderAddressTypePageRespVo> voList = BeanUtil.list2list(list, OrderAddressTypePageRespVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}
	
}
