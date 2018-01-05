package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.assistant.AdminUserAssistantVO;
import com.qbt.web.pojo.assistant.UserAssistantPageReqVo;
import com.qbt.web.support.AdminUserAssistantSupport;

@Service
public class AdminUserAssistantSupportImpl implements AdminUserAssistantSupport{

	@Resource
	private UserAssistantService userAssistantService;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private UserAsApService userAsApService;
	
	@Override
	public List<AdminUserAssistantVO> findByPage(UserAssistantPageReqVo reqVo) {
		PageEntity<UserAssistant> pageEntity = BeanUtil.pageConvert(reqVo, UserAssistant.class);
		
		List<UserAssistant> list = userAssistantService.findByPage(pageEntity);
		List<AdminUserAssistantVO> voList = BeanUtil.list2list(list, AdminUserAssistantVO.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
