package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.userWeixin.UserWeixinPageReqVo;
import com.qbt.web.pojo.userWeixin.UserWeixinVo;
import com.qbt.web.pojo.userWeixin.WeiXinVO;
import com.qbt.web.support.UserWeixinSupport;

@Service
public class UserWeixinSupportImpl implements UserWeixinSupport{

	@Resource
	private UserWeixinService userWeixinService;
	
	@Override
	public List<UserWeixinVo> findByPage(UserWeixinPageReqVo reqVo) {
		PageEntity<UserWeixin> pageEntity = BeanUtil.pageConvert(reqVo, UserWeixin.class);
		List<UserWeixin> list = userWeixinService.findByPage(pageEntity);
		List<UserWeixinVo> voList = BeanUtil.list2list(list, UserWeixinVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public UserWeixinVo findById(Integer id) {
		UserWeixin userWeixin = userWeixinService.findById(id);
		UserWeixinVo userWeixinVo = BeanUtil.a2b(userWeixin, UserWeixinVo.class);
		return userWeixinVo;
	}

	@Override
	public void update(UserWeixinPageReqVo reqVo) {
		UserWeixin userWeixin = userWeixinService.findById(reqVo.getId());
		userWeixin.setName(reqVo.getName());
		userWeixin.setMobile(reqVo.getMobile());
		userWeixin.setEmail(reqVo.getEmail());
		userWeixinService.update(userWeixin);
	}

	@Override
	public List<UserWeixinVo> list() {
		List<UserWeixin> userWeixinList = userWeixinService.list();
		List<UserWeixinVo> userWeixinVoList = BeanUtil.list2list(userWeixinList, UserWeixinVo.class);
		return userWeixinVoList;
	}

	@Override
	public WeiXinVO isWeiXinUser(String mobile) {
		WeiXinVO weiXinVO = new WeiXinVO();
		List<UserWeixin> userWeixinList = userWeixinService.isWeiXinUser(mobile);
		List<Integer> idList = new ArrayList<Integer>();
		for (UserWeixin userWeixin : userWeixinList) {
			idList.add(userWeixin.getId());
		}
		if(userWeixinList.size() == 0){
			weiXinVO.setIdList(null);
			weiXinVO.setIsWeiXin(false);
		}else{
			weiXinVO.setIdList(idList);
			weiXinVO.setIsWeiXin(true);
		}
		return weiXinVO;
	}

	@Override
	public Integer findUserIdByOpenId(String openId) {
		UserWeixin userWeixin =  userWeixinService.findByOpenId(openId);
		return userWeixin.getId();
	}

}
