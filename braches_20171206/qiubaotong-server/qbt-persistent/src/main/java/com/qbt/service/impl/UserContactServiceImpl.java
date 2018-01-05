package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.UserContact;
import com.qbt.persistent.mapper.UserContactMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.UserContactService;

/**
 *  联系人信息表
 * @author share
 *
 */
@Service
public class UserContactServiceImpl implements UserContactService {

	@Resource
	private UserContactMapper userContactMapper;
	
	@Resource
	private RedisService redisManager;
	
	@Override
	public int insert(UserContact contact) {
		// 保存到mysql
		userContactMapper.insert(contact);
		if(contact.getId() > 0){
			// 保存至Redis
			redisManager.putMap(RedisKeyUtil.user_contact_redis_mobile_key(contact.getMobile()), RedisUtil.hashsMap(contact));
		}
		return contact.getId();
	}

	@Override
	public UserContact findByMobile(String mobile) {
		UserContact contact = RedisUtil.getByRedis(redisManager.getMap(RedisKeyUtil.user_contact_redis_mobile_key(mobile)), UserContact.class);
		if(contact == null){
			contact = userContactMapper.findByMobile(mobile);
			if(contact != null){
				redisManager.putMap(RedisKeyUtil.user_contact_redis_mobile_key(contact.getMobile()), RedisUtil.hashsMap(contact));
			}
		}
		return contact;
	}

	@Override
	public int updateById(UserContact contact) {
		if(contact.getId() > 0){
			int count = userContactMapper.updateById(contact);
			if(count > 0){
				redisManager.del(RedisKeyUtil.user_contact_redis_mobile_key(contact.getMobile()));
				this.findByMobile(contact.getMobile());
			}
			return count;
		}
		return 0;
	}

	@Override
	public int deleteByMobile(String mobile, Boolean isDelete) {
		int count = userContactMapper.deleteByMobile(mobile, isDelete);
		if(count > 0){
			redisManager.del(RedisKeyUtil.user_contact_redis_mobile_key(mobile));
			this.findByMobile(mobile);
		}
		return count;
	}

	@Override
	public UserContact findById(Integer id) {
		return userContactMapper.findById(id);
	}

	@Override
	public List<UserContact> findByPage(PageEntity<UserContact> pageEntity) {
		return userContactMapper.findByPage(pageEntity);
	}

	@Override
	public int removeByMobile(String mobile) {
		int result = userContactMapper.removeByMobile(mobile);
		if(result > 0){
			redisManager.del(RedisKeyUtil.user_contact_redis_mobile_key(mobile));
		}
		return result;
	}

}
