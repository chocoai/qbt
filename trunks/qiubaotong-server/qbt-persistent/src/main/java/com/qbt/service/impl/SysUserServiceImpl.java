package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.mapper.SysUserMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Resource
	private SysUserMapper sysUserMapper;
	
	@Resource
	private RedisService redisService;
	
	//过期时间, 30分钟
	private int sys_user_session_time = 1800;
	
	@Override
	public List<SysUser> list() {
		return sysUserMapper.list();
	}

	@Override
	public int insert(SysUser sysUser) {
		sysUserMapper.insert(sysUser);
		if(sysUser.getId() > 0){
			redisService.putMap(RedisKeyUtil.sys_user_userId_key(sysUser.getId()), RedisUtil.hashsMap(sysUser));
		}
		return sysUser.getId();
	}

	@Override
	public int delete(Integer id) {
		int count = sysUserMapper.delete(id);
		if(count > 0){
			redisService.del(RedisKeyUtil.sys_user_userId_key(id));
		}
		return count;
	}

	@Override
	public int update(SysUser sysUser) {
		if(sysUser.getId() > 0){
			int count = sysUserMapper.updateById(sysUser);
			if(count > 0){
				redisService.putMap(RedisKeyUtil.sys_user_userId_key(sysUser.getId()), RedisUtil.hashsMap(sysUser));
			}
			return count;
		}
		return 0;
	}

	@Override
	public SysUser selectById(Integer id) {
		SysUser sysUser = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.sys_user_userId_key(id)), SysUser.class);
		if(Checker.isEmpty(sysUser)){
			sysUser = sysUserMapper.selectById(id);
			if(Checker.isNotEmpty(sysUser)){
				redisService.putMap(RedisKeyUtil.sys_user_userId_key(sysUser.getId()), RedisUtil.hashsMap(sysUser));
			}
		}
		return sysUser;
	}

	@Override
	public List<SysUser> findByPage(PageEntity<SysUser> pageEntity) {
		return sysUserMapper.findByPage(pageEntity);
	}

	@Override
	public SysUser tokenCheck(String token) {
		//查询redis中的token
		String userId = redisService.getString(RedisKeyUtil.sys_user_token_key(token));
		
		// 如果找不到userId - 未登录或token过期
		if (userId == null) {
			return null;
		}
		
		// 重新设置 30分钟
		redisService.putExpire(RedisKeyUtil.sys_user_token_key(userId), ObjectUtils.toString(token, ""), sys_user_session_time);
		redisService.putExpire(RedisKeyUtil.sys_user_token_key(token), ObjectUtils.toString(userId, ""), sys_user_session_time);
		
		SysUser sysUser = this.selectById(Integer.valueOf(userId));
		return sysUser;
	}

	
	@Override
	public void logout(String token) {
		String userId = redisService.getString(RedisKeyUtil.sys_user_token_key(token));
		if (StringUtils.isNotBlank(userId)) {
			redisService.del(RedisKeyUtil.sys_user_token_key(userId));
		}
		redisService.del(RedisKeyUtil.sys_user_token_key(token));
	}

	@Override
	public String login(Integer sysUserId) {
		// 踢出已经登录的用户token
		tickOutToken(sysUserId);
		// 获取设置的新的token
		String token = setNewToken(sysUserId);
		return token;
	}
	
	
	// 踢出已经登录的用户token
	private void tickOutToken(Integer userId) {
		String oldToken = redisService.getString(RedisKeyUtil.sys_user_token_key(userId.toString()));
		if (StringUtils.isNotBlank(oldToken)) {
			LogCvt.info("SysUser:" + userId + " 已经登录, 将之前的token踢出");
			redisService.del(RedisKeyUtil.sys_user_token_key(userId.toString()));
			redisService.del(RedisKeyUtil.sys_user_token_key(oldToken));
		}
	}
	
	// 获取设置的新的token
	private String setNewToken(Integer userId) {
		String token = ToolsUtil.getUUID();
		redisService.putExpire(RedisKeyUtil.sys_user_token_key(String.valueOf(userId)), ObjectUtils.toString(token, ""), sys_user_session_time);
		redisService.putExpire(RedisKeyUtil.sys_user_token_key(token), ObjectUtils.toString(userId, ""), sys_user_session_time);
		return token;
	}

	@Override
	public List<SysUser> findByCondition(SysUser sysUser) {
		return sysUserMapper.findByCondition(sysUser);
	}

	@Override
	public SysUser findByMobile(String mobile) {
		return sysUserMapper.findByMobile(mobile);
	}

	@Override
	public SysUser getUserByToken(String token) {
		// TODO Auto-generated method stub
		//查询redis中的token
		String userId = redisService.getString(RedisKeyUtil.sys_user_token_key(token));
		
		// 如果找不到userId - 未登录或token过期
		if (userId == null) {
			return null;
		}
		SysUser sysUser = this.selectById(Integer.valueOf(userId));
		return sysUser;
	}

	@Override
	public List<SysUser> listUserByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return sysUserMapper.listUserByRoleId(roleId);
	}

	@Override
	public List<Integer> getPlatId(String mobile) {
		// TODO Auto-generated method stub
		return sysUserMapper.getPlatId(mobile);
	}

}
