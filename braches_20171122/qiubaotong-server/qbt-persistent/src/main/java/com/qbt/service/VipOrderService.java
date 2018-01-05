package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipOrder;

public interface VipOrderService {

	List<VipOrder> findByPage(PageEntity<VipOrder> pageEntity);

	VipOrder findById(Integer id);
	
	int insert(VipOrder vipOrder);
	
	VipOrder findByNumber(String  number);
	
	int updateById(VipOrder vipOrder);
	
	int updateByNumber(VipOrder vipOrder);
	
	int updateByNumbers(VipOrder vipOrder);
	
	int insertBatch(List<VipOrder> vipOrders);
}
