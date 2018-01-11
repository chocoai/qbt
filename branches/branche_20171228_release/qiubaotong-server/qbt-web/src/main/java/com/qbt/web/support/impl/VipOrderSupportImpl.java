
 /**
 * @Title: VipPyamentSupportImpl.java
 * @Package com.qbt.web.support.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.support.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.entity.VipPayment;
import com.qbt.service.CommonService;
import com.qbt.service.VipOrderService;
import com.qbt.web.support.VipOrderSupport;

/**
 * vip订单
  * @ClassName: VipOrderSupportImpl
  * @Description: TODO
  * @author chenxiaocong 2016年11月4日
  * @modify chenxiaocong 2016年11月4日
 */
@Service
public class VipOrderSupportImpl  implements VipOrderSupport{

	@Resource
	private CommonService commonService;
	
	@Resource
	private VipOrderService  vipOrderService;
	 
	/**
	 * 根据预支付订单，会员卡号 ，创建成功成功订单，
	  * @Title: createVipOrder
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月4日
	  * @modify: chenxiaocong 2016年11月4日
	  * @param vipPayment
	  * @return
	 */
	public VipOrder createVipOrder(VipPayment vipPayment,VipInfo vipInfo){
		
		VipOrder vipOrder = new VipOrder();
		
		vipOrder.setCreateTime(new Date());
		vipOrder.setUpdateTime(new Date());
		
		String number = commonService.createVipOrderId();
		vipOrder.setNumber(number);
		
		vipOrder.setVipNo(vipInfo.getVipNo());
		vipOrder.setUserId(vipPayment.getUserId());
		vipOrder.setPayAmount(vipPayment.getPayAmount().doubleValue());
		vipOrder.setPayMethod(vipPayment.getPayMethod());
		vipOrder.setVipTypeId(vipPayment.getVipTypeId());
		vipOrder.setName(vipPayment.getName());
		vipOrder.setUserName(vipPayment.getUserName());
		vipOrder.setMobile(vipPayment.getMobile());
		vipOrder.setValidDesc(vipPayment.getValidDesc());
		vipOrder.setValid(vipPayment.getValid());
		vipOrder.setSettlementStatus(1);
		vipOrder.setPayId(vipPayment.getId());
		vipOrder.setPayNumber(vipPayment.getUuid());//商户流水
		vipOrder.setPayBakNo(vipPayment.getPayBakNo());
		vipOrder.setVipCardType(1);
		vipOrderService.insert(vipOrder);
		
		vipOrder = vipOrderService.findByNumber(number);
				
		return vipOrder;

	}
}
