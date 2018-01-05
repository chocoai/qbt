package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBank;

public interface BaseBankService {

	List<BaseBank> findByPage(PageEntity<BaseBank> pageEntity);

	void add(BaseBank baseBank);

	void updateById(BaseBank baseBank);

	List<BaseBank> findByCondition(BaseBank condition);

	int deleteById(Integer id, Boolean isDelete);

	BaseBank findById(Integer id);
	
	

}
