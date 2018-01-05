
 /**
 * @Title: UserOrderAddressService.java
 * @Package com.qbt.service
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.UserOrderAddress;

/**
  * @ClassName: UserOrderAddressService
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public interface UserOrderAddressService {

	int insert(UserOrderAddress userOrderAddress);
	
	UserOrderAddress findByUuid(String uuid);
	
	List<UserOrderAddress> findOldContactsByUserId(int userId);
	
}
