package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserWeixin;

public interface UserWeixinService {

	/**
	 * 添加
	 * @param user
	 */
	public void insert(UserWeixin user);
	
	/**
	 * 根据OpenId查询用户
	 * @param mobile
	 * @return
	 */
	public UserWeixin findByOpenId(String openId);
	
	/**
	 * 用户登录
	 * @param openId
	 * @return
	 */
	public String login(String openId);
	
	/**
	 * 检查用户token是否有效
	 * @param token
	 * @return
	 */
	public String checkToken(String token);
	
	/**
	 * 获取用户列表
	 * @param pageEntity
	 * @return
	 */
	public List<UserWeixin> findByPage(PageEntity<UserWeixin> pageEntity);
	
	/**
	 * 获取 
	 * @param id
	 * @return
	 */
	public UserWeixin findById(Integer id);

	public void update(UserWeixin userWeixin);
	
	/**
	 * 根据客服类型查询微信用户
	 * @param kfType
	 * @return
	 */
	public List<UserWeixin> findByKfType(Integer kfType);

	public List<UserWeixin> list();

	public List<UserWeixin> isWeiXinUser(String mobile);
	
	public List<UserWeixin> findByMobileList(List<String> mobileList);

}
