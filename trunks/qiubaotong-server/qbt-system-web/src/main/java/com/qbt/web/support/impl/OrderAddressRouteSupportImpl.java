/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressRouteSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年3月13日下午4:43:41
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.CollectionsUtil;
import com.qbt.persistent.dto.OrderAddressRoutePageDto;
import com.qbt.service.OrderAddressRouteService;
import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageReqVo;
import com.qbt.web.pojo.orderAddressRoute.OrderAddressRoutePageRespVo;
import com.qbt.web.support.OrderAddressRouteSupport;

/**
 * ClassName:OrderAddressRouteSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午4:43:41
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrderAddressRouteSupportImpl implements OrderAddressRouteSupport {

	@Resource
	private OrderAddressRouteService orderAddressRouteService;
	
	@Override
	public List<OrderAddressRoutePageRespVo> findByPage(OrderAddressRoutePageReqVo reqVo) {
		PageEntity<OrderAddressRoutePageDto> pageEntity = BeanUtil.pageConvert(reqVo, OrderAddressRoutePageDto.class);
		List<OrderAddressRoutePageDto> list = orderAddressRouteService.findByPageForUserSummary(pageEntity);
		List<OrderAddressRoutePageRespVo> voList = new ArrayList<OrderAddressRoutePageRespVo>();
		for(OrderAddressRoutePageDto dto : list){
			OrderAddressRoutePageRespVo vo = BeanUtil.a2b(dto, OrderAddressRoutePageRespVo.class);
			
			List<String> jAddressList = new ArrayList<String>();
			jAddressList.add(dto.getjCountryAreaName());
			jAddressList.add(dto.getjProvinceAreaName());
			jAddressList.add(dto.getjCityAreaName());
			jAddressList.add(dto.getjDistrictAreaName());
			if(dto.getjAddrType() != 4){
				jAddressList.add(dto.getjAddrName());
			}else{
				jAddressList.add(dto.getjAddress());
			}
			vo.setjAddress(CollectionsUtil.listToStr(jAddressList, " "));
			
			List<String> dAddressList = new ArrayList<String>();
			dAddressList.add(dto.getdCountryAreaName());
			dAddressList.add(dto.getdProvinceAreaName());
			dAddressList.add(dto.getdCityAreaName());
			dAddressList.add(dto.getdDistrictAreaName());
			if(dto.getjAddrType() != 4){
				dAddressList.add(dto.getdAddrName());
			}else{
				dAddressList.add(dto.getdAddress());
			}
			vo.setdAddress(CollectionsUtil.listToStr(dAddressList, " "));
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
