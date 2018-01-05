
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

import com.qbt.persistent.entity.TicketPackagePayment;

/**
  * @ClassName: TicketPackagePaymentService
  * @Description: TicketPackagePaymentService
  */

public interface TicketPackagePaymentService {

	int insert(TicketPackagePayment ticketPackagePayment);
	
	TicketPackagePayment findByUserId(int userId,int paymethod);
	
	TicketPackagePayment findByUuid(String uuid);
	
	int updateById(TicketPackagePayment ticketPackagePayment);
}
