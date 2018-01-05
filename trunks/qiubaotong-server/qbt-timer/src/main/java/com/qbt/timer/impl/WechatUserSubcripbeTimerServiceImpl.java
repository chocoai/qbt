/**
 * Project Name:qbt-timer
 * File Name:WechatUserSubcripbeTimerServiceImpl.java
 * Package Name:com.qbt.timer.impl
 * Date:2017年2月9日下午1:33:38
 *
*/

package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserWeixinService;
import com.qbt.timer.TimerService;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.WeixinUserInfo;

/**
 * ClassName:WechatUserSubcripbeTimerServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月9日 下午1:33:38
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("wechatUserSubcripbeTimerService")
public class WechatUserSubcripbeTimerServiceImpl extends TimerService {
	
	@Resource
	private WechatCommonSupport commonTimerSupport;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private WechatApi wechatApi;
	
	@Override
	public void process() {
		String accessToken = commonTimerSupport.getAccessToken();
		//查询所有微信用户信息
		List<UserWeixin> userList = userWeixinService.list();
		for(UserWeixin user : userList){
			WeixinUserInfo weixinUserInfo = wechatApi.queryUserInfo(accessToken, user.getOpenid());
			if(weixinUserInfo.getSubscribe() == 1){
				UserWeixin updateUser = new UserWeixin();
				updateUser.setId(user.getId());
				updateUser.setSubscribeStatus(1);
				updateUser.setSubscribeTime(weixinUserInfo.getSubscribe_time());
				userWeixinService.update(updateUser);
			}
		}
	}

}
