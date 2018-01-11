package com.qbt.service;

import java.util.List;


import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Bill;

public interface BillService {
	void insert(Bill bill);
	void update(Bill bill);
	List<Bill> findByPage(PageEntity<Bill> pageEntity);
	Bill findById(Integer id);
	List<Bill> findByUserId( Integer userId);
}
