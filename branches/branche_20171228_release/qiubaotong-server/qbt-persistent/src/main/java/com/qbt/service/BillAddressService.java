package com.qbt.service;

import java.util.List;


import com.qbt.persistent.entity.BillAddress;

public interface BillAddressService {
	void insert(BillAddress bill);
	Integer isExistAddress(BillAddress bill);
	BillAddress findByProperty(BillAddress bill);
	List<BillAddress>	findByUserId(BillAddress billAddress);
	void updateById(BillAddress billAddress);
	void deleteById(Integer id);
	BillAddress findLastUseByUserId(Integer userId);
}
