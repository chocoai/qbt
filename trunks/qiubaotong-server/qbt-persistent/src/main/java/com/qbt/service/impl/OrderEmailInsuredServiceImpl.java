/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailInsuredServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月19日下午5:30:09
 *
*/

package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderEmailInsured;
import com.qbt.persistent.mapper.OrderEmailInsuredMapper;
import com.qbt.service.OrderEmailInsuredService;

/**
 * ClassName:OrderEmailInsuredServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月19日 下午5:30:09
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class OrderEmailInsuredServiceImpl implements OrderEmailInsuredService {

	@Resource
	private OrderEmailInsuredMapper orderEmailInsuredMapper;
	
	@Override
	public OrderEmailInsured findByMinMaxAndOrderEmailId(Double insuredValue, int orderEmailId) {
		return orderEmailInsuredMapper.findByMinMaxAndOrderEmailId(insuredValue, orderEmailId);
	}

}
