
 /**
 * @Title: UserOrderAddressServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.UserOrderAddress;
import com.qbt.persistent.mapper.UserOrderAddressMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.UserOrderAddressService;

/**
  * @ClassName: UserOrderAddressServiceImpl
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */
@Service
public class UserOrderAddressServiceImpl implements UserOrderAddressService {

	@Resource
	private UserOrderAddressMapper userOrderAddressMapper;
	@Resource
	private RedisService redisManager;
	
	@Override
	public int insert(UserOrderAddress userOrderAddress) {
		// TODO Auto-generated method stub
		int index = userOrderAddressMapper.insert(userOrderAddress);
		
		// 保存redis
		redisManager.putMap(RedisKeyUtil.qbt_user_order_address_uuid_key(userOrderAddress.getUuid()), 
				RedisUtil.hashsMap(userOrderAddress));
		return index;
	}

	@Override
	public UserOrderAddress findByUuid(String uuid) {
		UserOrderAddress userOrderAddress = RedisUtil.getByRedis(redisManager.getMap(RedisKeyUtil.qbt_user_order_address_uuid_key(uuid)),
				UserOrderAddress.class);
		if(userOrderAddress == null){
			userOrderAddress = userOrderAddressMapper.findByUuid(uuid);
			if(userOrderAddress == null)
				return null;
			
			// 保存redis
			redisManager.putMap(RedisKeyUtil.qbt_user_order_address_uuid_key(userOrderAddress.getUuid()), 
					RedisUtil.hashsMap(userOrderAddress));
		}
		return userOrderAddress;
	}


	@Override
	public List<UserOrderAddress> findOldContactsByUserId(int userId) {
		// TODO Auto-generated method stub
		return userOrderAddressMapper.findOldContactsByUserId(userId);
	}


}
