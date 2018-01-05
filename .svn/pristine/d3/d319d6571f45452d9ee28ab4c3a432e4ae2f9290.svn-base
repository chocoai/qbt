
 /**
 * @Title: UserOrderAddressMapper.java
 * @Package com.qbt.persistent.mapper
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.UserOrderAddress;

/**
  * @ClassName: UserOrderAddressMapper
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public interface UserOrderAddressMapper {

	int insert(UserOrderAddress userOrderAddress);
	
	UserOrderAddress findByUuid(@Param("uuid") String uuid);
	
	List<UserOrderAddress> findOldContactsByUserId(@Param("userId") int userId);
	
}
