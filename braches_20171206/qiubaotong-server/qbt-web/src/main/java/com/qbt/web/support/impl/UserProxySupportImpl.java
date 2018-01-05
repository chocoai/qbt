/**
 * Project Name:qbt-web
 * File Name:UserProxySupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月27日下午2:16:49
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserProxyService;
import com.qbt.web.pojo.userProxy.UserProxyVo;
import com.qbt.web.support.UserProxySupport;

/**
 * ClassName:UserProxySupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午2:16:49
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserProxySupportImpl implements UserProxySupport {
	
	@Resource
	private UserProxyService userProxyService;
	
	@Override
	public List<UserProxyVo> list(UserWeixin proxyUser, String keyword) {
		List<UserProxy> userList = userProxyService.findByKeyword(proxyUser.getId(), keyword);
		List<UserProxyVo> voList = BeanUtil.list2list(userList, UserProxyVo.class);
		for(UserProxyVo vo : voList){
			vo.setUserIdStr(StringUtils.leftPad(vo.getUserId().toString(), 6, "0"));
		}
		return voList;
	}

	@Override
	public UserProxyVo detail(UserWeixin proxyUser, Integer userId) {
		UserProxy userProxy = userProxyService.findByUserId(proxyUser.getId(), userId);
		UserProxyVo vo = BeanUtil.a2b(userProxy, UserProxyVo.class);
		if(Checker.isNotEmpty(vo)){
			vo.setUserIdStr(StringUtils.leftPad(vo.getUserId().toString(), 6, "0"));
		}
		return vo;
	}

	@Override
	public int save(UserWeixin proxyUser, UserProxyVo vo) {
		UserProxy userProxy = userProxyService.findByUserId(proxyUser.getId(), vo.getUserId());
		if(Checker.isEmpty(userProxy)){
			userProxy = new UserProxy();
			userProxy.setProxyUserId(proxyUser.getId());
			userProxy.setUserId(vo.getUserId());
			userProxy.setName(vo.getName());
			userProxy.setMobile(vo.getMobile());
			userProxy.setNickname(vo.getNickname());
			userProxy.setHeadImgUrl(vo.getHeadImgUrl());
			userProxy.setOrderDayValue(vo.getOrderDayValue() == null ? 0 : vo.getOrderDayValue());
			userProxyService.insert(userProxy);
		}else{
			userProxy.setName(vo.getName());
			userProxy.setMobile(vo.getMobile());
			userProxy.setNickname(vo.getNickname());
			userProxy.setHeadImgUrl(vo.getHeadImgUrl());
			//就数据不能改变销售合作时间
			/*userProxy.setOrderDayValue(vo.getOrderDayValue());*/
			userProxyService.update(userProxy);
		}
		return userProxy.getUserId();
	}

}
