package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserContact;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserContactService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.contact.UserContactPageReqVo;
import com.qbt.web.pojo.contact.UserContactVo;
import com.qbt.web.pojo.userWeixin.UserWeixinVo;
import com.qbt.web.support.UserContactSupport;

@Service
public class UserContactSupportImpl implements UserContactSupport {
	
	@Resource
	private UserContactService userContactService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Override
	public int add(UserContactVo vo) throws BusinessException {
		//查询重复手机号
		UserContact query = userContactService.findByMobile(vo.getMobile());
		if(Checker.isNotEmpty(query) && !query.getIsDelete()){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "手机号已被占用");
		}
		
		UserContact contact = BeanUtil.a2b(vo, UserContact.class);
		contact.setIsDelete(false);
		contact.setType(0);
		return userContactService.insert(contact);
	}

	@Override
	public boolean update(UserContactVo vo) throws BusinessException {
		//查询重复手机号
		UserContact query = userContactService.findById(vo.getId());
		if(Checker.isNotEmpty(query)){
			if(!query.getMobile().equals(vo.getMobile())){
				UserContact mquery = userContactService.findByMobile(vo.getMobile());
				if(Checker.isNotEmpty(mquery) && !mquery.getIsDelete()){
					throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "手机号已被占用");
				}
			}
			UserContact contact = BeanUtil.a2b(vo, UserContact.class);
			return userContactService.updateById(contact) > 0;
		}
		return false;
	}

	@Override
	public boolean delete(String mobile, Boolean isDelete) {
		return userContactService.deleteByMobile(mobile, isDelete) > 0;
	}

	@Override
	public UserContactVo findById(Integer id) {
		UserContact contact = userContactService.findById(id);
		UserContactVo vo = BeanUtil.a2b(contact, UserContactVo.class);
		return vo;
	}

	@Override
	public List<UserContactVo> findByPage(UserContactPageReqVo reqVo) {
		PageEntity<UserContact> pageEntity = BeanUtil.pageConvert(reqVo, UserContact.class);
		List<UserContact> list = userContactService.findByPage(pageEntity);
		List<UserContactVo> voList = BeanUtil.list2list(list, UserContactVo.class);
		if(Checker.isNotEmpty(voList)){
			List<String> mobileList = new ArrayList<String>();
			for(UserContactVo v : voList){
				mobileList.add(v.getMobile());
			}
			List<UserWeixin> weixinList = userWeixinService.findByMobileList(mobileList);
			Map<String, List<UserWeixinVo>> uwMap = new HashMap<String, List<UserWeixinVo>>();
			List<UserWeixinVo> vList = null;
			for(UserWeixin w : weixinList){
				if(Checker.isEmpty(w.getMobile())) continue;
				vList = uwMap.containsKey(w.getMobile()) ? uwMap.get(w.getMobile()) : new ArrayList<UserWeixinVo>();
				vList.add(BeanUtil.a2b(w, UserWeixinVo.class));
				uwMap.put(w.getMobile(), vList);
			}
			for(UserContactVo v : voList){
				if(uwMap.containsKey(v.getMobile())) v.setUwList(uwMap.get(v.getMobile()));
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public UserContactVo findByMobile(String mobile) {
		UserContact contact = userContactService.findByMobile(mobile);
		UserContactVo vo = BeanUtil.a2b(contact, UserContactVo.class);
		return vo;
	}

	@Override
	public boolean remove(String mobile) {
		UserContact contact = userContactService.findByMobile(mobile);
		if(contact == null){
			throw new BusinessException("客户信息不存在!");
		}else if(contact.getType() == 1){
			throw new BusinessException("已支付客户信息不能删除!");
		}
		return userContactService.removeByMobile(mobile) > 0;
	}

}
