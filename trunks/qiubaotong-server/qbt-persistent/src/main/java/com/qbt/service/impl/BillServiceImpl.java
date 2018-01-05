package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Bill;
import com.qbt.persistent.mapper.BillMapper;
import com.qbt.service.BillService;

@Service
public class BillServiceImpl implements BillService {
	@Resource
	private BillMapper mapper;

	@Override
	public void insert(Bill bill) {
		// TODO Auto-generated method stub
		mapper.insert(bill);
		
	}

	@Override
	public void update(Bill bill) {
		mapper.update(bill);
	}	

	@Override
	public List<Bill> findByPage(PageEntity<Bill> pageEntity) {
		return mapper.findByPage(pageEntity);
	}

	@Override
	public Bill findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<Bill> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.findByUserId(userId);
	}
	
	

}
