package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.UserOrderContact;
import com.qbt.persistent.mapper.UserOrderContactMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.UserOrderContactService;

@Service
public class UserOrderContactServiceImpl implements UserOrderContactService {

	@Resource
	private UserOrderContactMapper userOrderContactMapper;
	@Resource
	private RedisService redisManager;
	
	@Override
	public List<UserOrderContact> findOldContactsByUserId(int userId) {
		return userOrderContactMapper.findOldContactsByUserId(userId);
	}

	@Override
	public void deleteOldContactsById(Integer id) {
		UserOrderContact userOrderContact = userOrderContactMapper.findById(id);
		redisManager.del(RedisKeyUtil.qbt_user_order_contact_uuid_key(userOrderContact.getUuid()));
		userOrderContactMapper.deleteOldContactsById(id);
	}

	@Override
	public UserOrderContact findByUuid(String uuid) {
		UserOrderContact userOrderContact = RedisUtil.getByRedis(redisManager.getMap(RedisKeyUtil.qbt_user_order_contact_uuid_key(uuid)),
				UserOrderContact.class);
		if(userOrderContact == null){
			userOrderContact = userOrderContactMapper.findByUuid(uuid);
			if(userOrderContact == null)
				return null;
			// 保存redis
			redisManager.putMap(RedisKeyUtil.qbt_user_order_contact_uuid_key(userOrderContact.getUuid()), 
					RedisUtil.hashsMap(userOrderContact));
		}
		return userOrderContact;
	}
	
	@Override
	public int insert(UserOrderContact userOrderContact) {
		int index = userOrderContactMapper.insert(userOrderContact);
		// 保存redis
		redisManager.putMap(RedisKeyUtil.qbt_user_order_contact_uuid_key(userOrderContact.getUuid()), 
				RedisUtil.hashsMap(userOrderContact));
		return index;
		
	}
	
	@Override
	public String findMaxDate() {
		return userOrderContactMapper.findMaxDate();
	}

	@Override
	public UserOrderContact findById(Integer id) {
		return userOrderContactMapper.findById(id);
	}
	
}
