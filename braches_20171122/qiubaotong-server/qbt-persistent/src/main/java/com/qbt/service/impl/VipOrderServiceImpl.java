package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.persistent.mapper.VipOrderMapper;
import com.qbt.service.VipOrderService;

@Service
public class VipOrderServiceImpl implements VipOrderService{

	@Resource
	private VipOrderMapper vipOrderMapper;
	
	@Override
	public List<VipOrder> findByPage(PageEntity<VipOrder> pageEntity) {
		return vipOrderMapper.findByPage(pageEntity);
	}

	@Override
	public VipOrder findById(Integer id) {
		return vipOrderMapper.selectById(id);
	}
	
	@Override
	public int insert(VipOrder vipOrder) {
		return vipOrderMapper.insert(vipOrder);
	}

	@Override
	public VipOrder findByNumber(String  number) {
		return vipOrderMapper.selectByNumber(number);
	}
	
	
	@Override
	public int updateById(VipOrder vipOrder) {
		return vipOrderMapper.updateById(vipOrder);
	}

	@Override
	public int updateByNumbers(VipOrder vipOrder) {
		return vipOrderMapper.updateByNumbers(vipOrder);
	}

	@Override
	public int insertBatch(List<VipOrder> vipOrders) {
		return vipOrderMapper.insertBatch(vipOrders);
	}

	@Override
	public int updateByNumber(VipOrder vipOrder) {
		// TODO Auto-generated method stub
		return vipOrderMapper.updateByNumber(vipOrder);
	}
}
