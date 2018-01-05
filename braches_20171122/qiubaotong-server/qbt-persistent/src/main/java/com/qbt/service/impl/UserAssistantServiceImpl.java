package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.mapper.UserAssistantMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.UserAssistantService;

/**
 *  球包助理
  * @ClassName: UserAssistantServiceImpl
  * @Description: TODO
  * @author share 2016年8月17日
  * @modify share 2016年8月17日
 */
@Service
public class UserAssistantServiceImpl implements UserAssistantService{
	@Resource
	private UserAssistantMapper userAssistantMapper;
	@Resource
	private RedisService redisService;
	
	@Override
	public List<UserAssistant> findAssistantBySiteId(int courseId,int type) {
		return userAssistantMapper.findAssistantBySiteId(courseId,type);
	}
	
	 /**
	  * @Title: selectByUserId
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param userId
	  * @return
	  * @see com.qbt.service.UserAssistantService#selectByUserId(int)
	  */
	
	
	@Override
	public UserAssistant selectByUserId(int userId) {
		UserAssistant user = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.user_assistant_user_key(userId)), UserAssistant.class);
		if(user == null){
			user = userAssistantMapper.selectByUserId(userId);
			if(user != null){
				redisService.putMap(RedisKeyUtil.user_assistant_user_key(user.getUserId()), RedisUtil.hashsMap(user));
			}
		}
		
		return user;
	}
	
	 /**
	  * @Title: updateById
	  * @Description: TODO
	  * @author: win10 2016年8月19日
	  * @modify: win10 2016年8月19日
	  * @param user
	  * @return
	  * @see com.qbt.service.UserAssistantService#updateById(com.qbt.persistent.entity.UserAssistant)
	  */
	@Override
	public int updateById(UserAssistant user) {
		int result = userAssistantMapper.updateById(user);
		if(result > 0){
			String key = RedisKeyUtil.user_assistant_user_key(user.getUserId());
			if(!redisService.exists(key)){
				selectByUserId(user.getUserId());
			}else{
				redisService.putMap(key, RedisUtil.hashsMap(user));
			}
			
		}
		return result;
	}
	
	@Override
	public List<UserAssistant> findByPage(PageEntity<UserAssistant> pageEntity) {
		return userAssistantMapper.findByPage(pageEntity);
	}

	 /**
	  * @Title: inserAssistant
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param user
	  * @return
	  * @see com.qbt.service.UserAssistantService#inserAssistant(com.qbt.persistent.entity.UserAssistant)
	  */
	@Override
	public int inserAssistant(UserAssistant user) {
		int result = userAssistantMapper.insert(user);
		if(result > 0){
			redisService.putMap(RedisKeyUtil.user_assistant_user_key(user.getUserId()), RedisUtil.hashsMap(user));
		}
		return result;
	}
	
	@Override
	public UserAssistant findById(Integer id) {
		return userAssistantMapper.findById(id);
	}

	@Override
	public int queryAssistantByApply(int applyType, int applyId) {
		return userAssistantMapper.queryAssistantByApply(applyType, applyId);
	}

}


