/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailTempletServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月24日下午2:47:16
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderEmailTemplet;
import com.qbt.persistent.mapper.OrderEmailTempletMapper;
import com.qbt.service.OrderEmailTempletService;

/**
 * ClassName:OrderEmailTempletServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月24日 下午2:47:16
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class OrderEmailTempletServiceImpl implements OrderEmailTempletService{

	@Resource
	private OrderEmailTempletMapper orderEmailTempletMapper;
	
	@Override
	public List<OrderEmailTemplet> findByOrderEmailInsuredId(int orderEmailInsuredId) {
		return orderEmailTempletMapper.findByOrderEmailInsuredId(orderEmailInsuredId);
	}

}
