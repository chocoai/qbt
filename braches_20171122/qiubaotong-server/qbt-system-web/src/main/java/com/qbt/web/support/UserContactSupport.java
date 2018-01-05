package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.contact.UserContactPageReqVo;
import com.qbt.web.pojo.contact.UserContactVo;

public interface UserContactSupport {
	
	int add(UserContactVo vo) throws BusinessException;
	
	boolean update(UserContactVo vo) throws BusinessException;
	
	boolean delete(String mobile, Boolean isDelete);
	
	UserContactVo findById(Integer id);
	
	List<UserContactVo> findByPage(UserContactPageReqVo reqVo);
	
	UserContactVo findByMobile(String mobile);
	
	boolean remove(String mobile);
}
