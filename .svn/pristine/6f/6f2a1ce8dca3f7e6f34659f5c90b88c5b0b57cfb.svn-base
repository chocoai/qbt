package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.mapper.UserAddressMapper;
import com.qbt.service.UserAddressService;


@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Resource
	private UserAddressMapper addressMapper;
	
	@Override
	public int insert(UserAddress address) {
		addressMapper.insert(address);
		//checkIsDefault(address);
		return address.getId();
	}
	
	private void checkIsDefault(UserAddress address){
		if(address.getIsDefault()){
			addressMapper.updateOtherDefault(address);
		}
	}

	@Override
	public UserAddress findById(int id) {
		return addressMapper.findById(id);
	}

	@Override
	public List<UserAddress> findByUserId(int userId, Integer labelType) {
		return addressMapper.findByUserId(userId, labelType);
	}

	@Override
	public int update(UserAddress address) {
		 int result = addressMapper.update(address);
		 //checkIsDefault(address);
		 return result;
	}
	
	@Override
	public int updateUpdateTime(UserAddress address) {
		 int result = addressMapper.updateUpdateTime(address);
		 return result;
	}

	@Override
	public int delete(int id) {
		return addressMapper.delete(id);
	}

	@Override
	public UserAddress findByUuid(String uuid) {
		return addressMapper.findByUuid(uuid);
	}

	@Override
	public List<UserAddress> findByPage(PageEntity<UserAddress> pageEntity) {
		return addressMapper.findByPage(pageEntity);
	}

	@Override
	public int exists(Integer id, String uuid) {
		return addressMapper.exists(id, uuid);
	}

}
