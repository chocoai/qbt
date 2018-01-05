
 /**
 * @Title: UserWeixinSupportImpl.java
 * @Package com.qbt.web.support.impl
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年4月11日
 * @version V1.0
 **/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.UserCourse;
import com.qbt.persistent.entity.UserOrderContact;
import com.qbt.service.BaseCourseService;
import com.qbt.service.UserOrderAddressService;
import com.qbt.service.UserOrderContactService;
import com.qbt.web.pojo.user.Contacts;
import com.qbt.web.pojo.user.UserCourseVo;
import com.qbt.web.support.UserWeixinSupport;

/**
  * @ClassName: UserWeixinSupportImpl
  * @Description: TODO
  * @author chenxiaocong 2017年4月11日
  * @modify chenxiaocong 2017年4月11日
  */
@Service
public class UserWeixinSupportImpl implements UserWeixinSupport {

	@Resource
	private UserOrderAddressService userOrderAddressService;

	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private UserOrderContactService userOrderContactService;
	
	@Override
	public List<Contacts> findOldContactsByUserId(int userId) {
		
		//List<UserOrderAddress> list =  userOrderAddressService.findOldContactsByUserId(userId);
		List<UserOrderContact> list =  userOrderContactService.findOldContactsByUserId(userId);
		
		List<Contacts> listVo = new ArrayList<Contacts>();
		for(UserOrderContact info:list){
			Contacts c = new Contacts();
			c.setMobile(info.getMobile());
			c.setUserName(info.getContact());
			c.setId(info.getId());
			listVo.add(c);
		}
		return listVo;
	}

	
	 /**
	  * @Title: findCourseByUserId
	  * @Description: TODO
	  * @author: chenxiaocong 2017年4月11日
	  * @modify: chenxiaocong 2017年4月11日
	  * @param userId
	  * @return
	  * @see com.qbt.web.support.UserWeixinSupport#findCourseByUserId(int)
	  */
	
	@Override
	public List<UserCourseVo> findCourseByUserId(int userId) {
		
		List<UserCourse> list = baseCourseService.findUserCourseByUserId(userId);
		List<UserCourseVo> listVo = new ArrayList<UserCourseVo>();
		listVo = BeanUtil.list2list(list, UserCourseVo.class);
		
		return listVo;
	}


	@Override
	public void deleteOldContactsById(Integer userId, Integer id) throws BusinessException {
		UserOrderContact userOrderContact = userOrderContactService.findById(id); 
		if(!userOrderContact.getUserId().equals(userId)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "无权限删除");
		}
		userOrderContactService.deleteOldContactsById(id);
	}
}
