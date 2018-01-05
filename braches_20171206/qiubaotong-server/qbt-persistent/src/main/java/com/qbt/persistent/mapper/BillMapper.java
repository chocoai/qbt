package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Bill;

public interface BillMapper {
	void insert(Bill bill);
	void update(Bill bill);
	List<Bill> findByPage(PageEntity<Bill> pageEntity);
	Bill findById(@Param("id") Integer id);
	List<Bill> findByUserId(@Param("userId") Integer userId);
}
 