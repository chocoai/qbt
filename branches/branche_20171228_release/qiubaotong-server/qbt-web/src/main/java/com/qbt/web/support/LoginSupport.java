package com.qbt.web.support;

import com.qbt.common.result.Result;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserWeixin;

public interface LoginSupport {

	/**
	 * 微信授权登录
	 * @param code
	 * @param lat
	 * @param lon
	 * @return
	 */
	public Result<String> login(String code,String lat,String lon);
	
	/**
	 *  微信用户更新
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年8月19日
	  * @modify: share 2016年8月19日
	  * @param userWeixin
	 */
	public void update(UserWeixin userWeixin);
	
	/**
	 *  检查是否登录成功
	 * @param token
	 * @return
	 */
	public String checkToken(String token);
	
	/**
	 * 根据微信号查询用户
	 * @param openid
	 * @return
	 */
	public UserWeixin findByOpenId(String openid);
	
	
	/**
	  * @Title: checkUserIsAssistant
	  * @Description: 检查用户是否开通球包助理
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param openId
	  * @return
	 */
	public UserAssistant checkUserIsAssistant(int userId);

	/**
	 *  根据用户ID 查找用户
	  * @Title: findById
	  * @Description: TODO
	  * @author: share 2017年2月7日
	  * @modify: share 2017年2月7日
	  * @param userId
	  * @return
	 */
	public UserWeixin findById(int userId);
	
}
