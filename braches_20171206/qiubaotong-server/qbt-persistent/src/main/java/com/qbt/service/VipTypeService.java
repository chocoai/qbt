package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipType;

public interface VipTypeService {

	List<VipType> findByPage(PageEntity<VipType> pageEntity);

	VipType findById(Integer id);

	List<VipType> selectByStatus(Integer status);

	void updateStatus(VipType vipType);

	void add(VipType vipType);

	List<VipType> findByCondition(VipType condition);
	
	VipType findOne();
}
