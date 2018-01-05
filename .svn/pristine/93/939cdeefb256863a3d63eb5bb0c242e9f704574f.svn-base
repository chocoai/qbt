/**
 * Project Name:qbt-persistent
 * File Name:OrderEmailServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月19日下午5:21:11
 *
*/

package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderEmail;
import com.qbt.persistent.mapper.OrderEmailMapper;
import com.qbt.service.OrderEmailService;

/**
 * ClassName:OrderEmailServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月19日 下午5:21:11
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class OrderEmailServiceImpl implements OrderEmailService{

	@Resource
	private OrderEmailMapper orderEmailMapper;
	
	@Override
	public OrderEmail findByCode(String code) {
		return orderEmailMapper.findByCode(code);
	}

}
