package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.mapper.UserWeixinMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.UserWeixinService;

@Service
public class UserWeixinServiceImpl implements UserWeixinService {

	@Resource
	private UserWeixinMapper userWeixinMapper;
	@Resource
	private RedisService redisManager;
	
	private int user_session_time = 60 * 60;
	
	@Override
	public void insert(UserWeixin user) {
		// 保存mysql
		userWeixinMapper.insert(user);
		// 保存redis
		redisManager.putMap(RedisKeyUtil.user_weixin_redis_openid_key(user.getOpenid()), RedisUtil.hashsMap(user));
	}

	@Override
	public UserWeixin findByOpenId(String openId) {
		UserWeixin user = RedisUtil.getByRedis(redisManager.getMap(RedisKeyUtil.user_weixin_redis_openid_key(openId)),UserWeixin.class);
		if(user == null){
			user = userWeixinMapper.selectByOpenId(openId);
			if(user == null)return null;
			// 保存redis
			redisManager.putMap(RedisKeyUtil.user_weixin_redis_openid_key(user.getOpenid()), RedisUtil.hashsMap(user));
		}
		return user;
	}

	@Override
	public String login(String openId) {
		UserWeixin user = findByOpenId(openId);
		// 检查用户是否还存活历史有效token
		String userKey = RedisKeyUtil.User_weixin_token_Redis_UserId_key(user.getId());
		String token = redisManager.get(userKey);
		if(token == null)
			token = ToolsUtil.getUUID();
		redisManager.setex(RedisKeyUtil.User_weixin_token_Redis_UserId_key(user.getId()), user_session_time, token);
		redisManager.setex(RedisKeyUtil.user_weixin_token_redis_openid_key(token), user_session_time, openId);
		return token;
	}

	@Override
	public String checkToken(String token) {
		String key = RedisKeyUtil.user_weixin_token_redis_openid_key(token);
		boolean exists = redisManager.exists(key);
		if(exists){
			redisManager.expire(key, user_session_time);
			String openid = redisManager.get(key);
			UserWeixin user = findByOpenId(openid);
			String userKey = RedisKeyUtil.User_weixin_token_Redis_UserId_key(user.getId());
			redisManager.expire(userKey, user_session_time);
			return openid;
		}
		return null;
	}

	@Override
	public List<UserWeixin> findByPage(PageEntity<UserWeixin> pageEntity) {
		return userWeixinMapper.findByPage(pageEntity);
	}

	@Override
	public UserWeixin findById(Integer id) {
		return userWeixinMapper.selectById(id);
	}

	@Override
	public void update(UserWeixin userWeixin) {
		userWeixinMapper.updateById(userWeixin);
		redisManager.putMap(RedisKeyUtil.user_weixin_redis_openid_key(userWeixin.getOpenid()), RedisUtil.hashsMap(userWeixin));
	}

	@Override
	public List<UserWeixin> findByKfType(Integer kfType) {
		return userWeixinMapper.findByKfType(kfType);
	}

	@Override
	public List<UserWeixin> list() {
		return userWeixinMapper.list();
	}

	@Override
	public List<UserWeixin> isWeiXinUser(String mobile) {
		return userWeixinMapper.isWeiXinUser(mobile);
	}

	@Override
	public List<UserWeixin> findByMobileList(List<String> mobileList) {
		return userWeixinMapper.findByMobileList(mobileList);
	}


}
