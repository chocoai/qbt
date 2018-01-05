package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserContact;

public interface UserContactService {

	public int insert(UserContact contact);
	
	/**
	 * 按手机号查询
	 * @param mobile
	 * @return
	 */
	public UserContact findByMobile(String mobile);
	
	public int updateById(UserContact contact);
	
	public int deleteByMobile(String mobile, Boolean isDelete);
	
	public UserContact findById(Integer id);
	
	List<UserContact> findByPage(PageEntity<UserContact> pageEntity);
	
	int removeByMobile(String mobile);
}
