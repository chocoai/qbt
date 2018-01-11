
 /**
 * @Title: VipPaymentServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.VipPayment;
import com.qbt.persistent.mapper.VipPaymentMapper;
import com.qbt.service.VipPaymentService;

/**
  * @ClassName: VipPaymentServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */
@Service
public class VipPaymentServiceImpl implements VipPaymentService {

	@Resource
	private VipPaymentMapper vipPaymentMapper;


	@Override
	public int insert(VipPayment vipPayment) {
		return vipPaymentMapper.insert(vipPayment);
	}
	
	@Override
	public VipPayment findByUserId(int userId,int paymethod){
		return vipPaymentMapper.findByUserId(userId, paymethod);
	}

	
	
	@Override
	public VipPayment findByUuid(String uuid) {
		return vipPaymentMapper.findByUuid(uuid);
	}

	
	 /**
	  * @Title: update
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipPayment
	  * @return
	  * @see com.qbt.service.VipPaymentService#update(com.qbt.persistent.entity.VipPayment)
	  */
	
	@Override
	public int updateById(VipPayment vipPayment) {
		return vipPaymentMapper.updateById(vipPayment);
	}

}
