package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.UserAssistantFee;
import com.qbt.persistent.mapper.UserAssistantFeeMapper;
import com.qbt.service.UserAssistantFeeService;

/**
 *  助理分润表
  * @ClassName: UserAssistantFeeServiceImpl
  * @Description: TODO
  * @author share 2016年8月22日
  * @modify share 2016年8月22日
 */
@Service
public class UserAssistantFeeServiceImpl implements UserAssistantFeeService{

	@Resource
	private UserAssistantFeeMapper userAssistantFeeMapper;
	
	@Override
	public int inserAssistant(UserAssistantFee user) {
		// TODO Auto-generated method stub
		return userAssistantFeeMapper.insert(user);
	}
	
}
