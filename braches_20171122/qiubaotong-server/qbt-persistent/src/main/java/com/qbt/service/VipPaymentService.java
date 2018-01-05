
 /**
 * @Title: VipPaymentService.java
 * @Package com.qbt.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2016年11月3日
 * @version V1.0
 **/

package com.qbt.service;

import com.qbt.persistent.entity.VipPayment;

/**
  * @ClassName: VipPaymentService
  * @Description: TODO
  * @author chenxiaocong 2016年11月3日
  * @modify chenxiaocong 2016年11月3日
  */

public interface VipPaymentService {

	int insert(VipPayment vipPayment);
	
	VipPayment findByUserId(int userId,int paymethod);
	
	VipPayment findByUuid(String uuid);
	
	int updateById(VipPayment vipPayment);
}
