package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.Bill;
import com.qbt.persistent.entity.BillAddress;
import com.qbt.persistent.mapper.BillAddressMapper;
import com.qbt.service.BillAddressService;

@Service
public class BillAddressServiceImpl implements BillAddressService{
	@Resource
	private BillAddressMapper mapper;
	
	@Override
	public void insert(BillAddress billAddress) {
		mapper.insert(billAddress);
	}

	@Override
	public Integer isExistAddress(BillAddress billAddress) {
		// TODO Auto-generated method stub
		return mapper.isExistAddress(billAddress);
	}

	@Override
	public BillAddress findByProperty(BillAddress billAddress) {
		// TODO Auto-generated method stub
		return mapper.findByProperty(billAddress);
	}

	@Override
	public List<BillAddress> findByUserId(BillAddress billAddress) {
		// TODO Auto-generated method stub
		return mapper.findByUserId(billAddress);
	}

	@Override
	public void updateById(BillAddress billAddress) {
		// TODO Auto-generated method stub
		mapper.updateById(billAddress);
	}

	@Override
	public void deleteById(Integer id) {
		mapper.deleteById(id);
		
	}

	@Override
	public BillAddress findLastUseByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.findLastUseByUserId(userId);
	}
	
	
}
