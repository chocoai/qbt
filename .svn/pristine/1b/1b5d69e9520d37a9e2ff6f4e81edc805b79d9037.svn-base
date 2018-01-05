package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BillAddress;

public interface BillAddressMapper {
	void insert(BillAddress billAddress);
	Integer isExistAddress(BillAddress billAddress);
	BillAddress findByProperty(BillAddress billAddress);
	List<BillAddress>	findByUserId(BillAddress billAddress);
	void updateById(BillAddress billAddress);
	void deleteById(@Param("id")Integer id);
	BillAddress findLastUseByUserId(@Param("userId")Integer userId);
}
