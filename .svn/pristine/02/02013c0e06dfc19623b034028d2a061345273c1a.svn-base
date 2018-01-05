package com.qbt.web.support.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RandomProvider;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.support.LoginSupport;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.WeixinUserInfo;

/**
 * 微信用户授权登录
 * @author share
 *
 */
@Service
public class LoginSupportImpl implements LoginSupport {
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Resource
	private  UserAssistantService userAssistantService;
	
	@Override
	public Result<String> login(String code, String lat, String lon) {
		Result<String> result = new Result<String>();
		Map<String,String> bodyMap = wechatApi.getOpenId(code);
		String openid = bodyMap.get("openid");
		
		if(openid == null && bodyMap.get("errcode") != null){
			result.setCode(bodyMap.get("errcode"));
			result.setMsg(bodyMap.get("errmsg"));
			return result;
		}
		
		String access_token = bodyMap.get("access_token");
		// 查询微信用户信息
		WeixinUserInfo userInfo = wechatApi.queryUserInfo(access_token, openid);
		if(userInfo.getErrcode() != null && !"".equalsIgnoreCase(userInfo.getErrcode())){
			result.setCode(userInfo.getErrcode());
			result.setMsg(userInfo.getErrmsg());
			return result;
		}
		UserWeixin user = userWeixinService.findByOpenId(openid);
		if(user ==  null){
			user = new UserWeixin();
			user.setAcceptPromotion(true);
			user.setAcceptPush(true);
			user.setCity(userInfo.getCity());
			user.setCounty(userInfo.getCountry());
			user.setCoordsrc("");
			user.setCreateTime(new Date());
			user.setEmail("");
			user.setFirstLetter("");
			user.setHeadImgUrl(userInfo.getHeadimgurl());
			user.setIsValidated(true);
			user.setLastlat(lat);
			user.setLastlon(lon);
			user.setMobile("");
			user.setNickname(userInfo.getNickname());
			user.setOpenid(openid);
			user.setProvince(userInfo.getProvince());
			user.setSalt(RandomProvider.randomAlphanumericToLowerCase(8));
			user.setSex(Checker.isEmpty(userInfo.getSex()) ? 0 : Integer.parseInt(userInfo.getSex()));
			if(userInfo.getSubscribe() == 1){
				user.setSubscribeStatus(1);
				user.setSubscribeTime(userInfo.getSubscribe_time());
			}
			userWeixinService.insert(user);
		}else{
			// 更新用户信息
			user.setAcceptPush(true);
			user.setCity(userInfo.getCity());
			user.setCounty(userInfo.getCountry());
			user.setHeadImgUrl(userInfo.getHeadimgurl());
			user.setIsValidated(true);
			user.setLastlat(lat);
			user.setLastlon(lon);
			user.setNickname(userInfo.getNickname());
			user.setProvince(userInfo.getProvince());
			user.setSex(Integer.parseInt(userInfo.getSex()));
			if(userInfo.getSubscribe() == 1){
				user.setSubscribeStatus(1);
				user.setSubscribeTime(userInfo.getSubscribe_time());
			}
			userWeixinService.update(user);
		}
//		String openid = "ovy8Nw9Hc9gJLC35Eb7tcRPtp6RU";
		result.setDatas(userWeixinService.login(openid));
		return result;
	}

    /**
     *  更新用户信息
      * @Title: update
      * @Description: TODO
      * @author: share 2016年8月19日
      * @modify: share 2016年8月19日
      * @param userWeixin
     */
	@Override
	public void update(UserWeixin userWeixin) {
		userWeixinService.update(userWeixin);
	}
	
	/**
	 *  验证登录
	  * @Title: checkToken
	  * @Description: TODO
	  * @author: share 2016年8月19日
	  * @modify: share 2016年8月19日
	  * @param token
	  * @return
	 */
	@Override
	public String checkToken(String token) {
		return userWeixinService.checkToken(token);
	}

	/**
	 * 根据openId 查询用户信息
	 */
	@Override
	public UserWeixin findByOpenId(String openid) {
		return userWeixinService.findByOpenId(openid);
	}

	
	 /**
	  * @Title: checkUserIsAssistant
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param openId
	  * @return
	  * @see com.qbt.web.support.LoginSupport#checkUserIsAssistant(java.lang.String)
	  */
	
	@Override
	public UserAssistant checkUserIsAssistant(int  userId) {
		return userAssistantService.selectByUserId(userId);
	}

	@Override
	public UserWeixin findById(int userId) {
		return userWeixinService.findById(userId);
	}
	
	
	
	

}
