package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.UserAssistantApplyWX;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.mapper.UserAssistantApplyMapper;
import com.qbt.service.UserAsApService;
@Service
public class UserAsApServiceImpl implements UserAsApService{

	@Resource
	private UserAssistantApplyMapper userAssistantApplyMapper;
	
	@Override
	public List<UserAssistantApply> findByPage(PageEntity<UserAssistantApply> pageEntity) {
		return userAssistantApplyMapper.findByPage(pageEntity);
	}

	@Override
	public void updateStatus(UserAssistantApply u) {
		userAssistantApplyMapper.updateByPrimaryKeySelective(u);
	}

	@Override
	public UserAssistantApply findById(Integer id) {
		return userAssistantApplyMapper.selectByPrimaryKey(id);
	}

	
	 /**
	  * @Title: selectByUserId
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param userId
	  * @return
	  * @see com.qbt.service.UserAsApService#selectByUserId(java.lang.String)
	  */
	
	@Override
	public UserAssistantApply selectById(int id) {
		return userAssistantApplyMapper.selectByPrimaryKey(id);
	}

	
	 /**
	  * @Title: insertUserAssistantApply
	  * @Description: TODO
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param apply
	  * @return
	  * @see com.qbt.service.UserAsApService#insertUserAssistantApply(com.qbt.persistent.entity.UserAssistantApply)
	  */
	
	@Override
	public int insertUserAssistantApply(UserAssistantApply apply) {
		return userAssistantApplyMapper.insert(apply);
	}

	
	 /**
	  * @Title: updateApplyById
	  * @Description: TODO
	  * @author: win10 2016年8月19日
	  * @modify: win10 2016年8月19日
	  * @param apply
	  * @return
	  * @see com.qbt.service.UserAsApService#updateApplyById(com.qbt.persistent.entity.UserAssistantApply)
	  */
	
	@Override
	public int updateApplyByAssistantId(UserAssistantApply apply) {
		return userAssistantApplyMapper.updateByAssistantId(apply);
	}
	
	
	public UserAssistantApply selectByUserId(String userId) {
		return userAssistantApplyMapper.selectByUserId(userId);
	}

	@Override
	public UserAssistantApply findByAssitantId(int id) {
		return userAssistantApplyMapper.findByAssitantId(id);
	}

	@Override
	public void update(UserAssistantApply uAsAp) {
		userAssistantApplyMapper.updateByPrimaryKeySelective(uAsAp);
	}

	@Override
	public List<UserAssistantApplyWX> list(Integer applyId,int applyType) {
		return userAssistantApplyMapper.list(applyId, applyType);
	}

	@Override
	public List<UserAssistantApply> findByApplyIdAndApplyType(int applyId, int applyTyep) {
		return userAssistantApplyMapper.findByApplyIdApplyType(applyId,applyTyep);
	}

	@Override
	public void updatestatusStop(Integer applyId, int applyType, int status) {
		userAssistantApplyMapper.updatestatusStop(applyId,applyType,status);
	}
	/**
	 *  查询合作方助理
	  * @Title: findPartnerByUserId
	  * @Description: TODO
	  * @author: share 2016年10月9日
	  * @modify: share 2016年10月9日
	  * @param userId
	  * @return
	  * @see com.qbt.service.UserAsApService#findPartnerByUserId(int)
	 */
	@Override
	public UserAssistantApply findPartnerByUserId(int userId,int type) {
		return userAssistantApplyMapper.findPartnerByUserId(userId,type);
	} 

}
