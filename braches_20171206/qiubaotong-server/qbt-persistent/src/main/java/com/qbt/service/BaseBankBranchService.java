package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBankBranch;


public interface BaseBankBranchService {
	public List<BaseBankBranch> findList();
	
	public BaseBankBranch findById(int id);

	public List<BaseBankBranch> findByPage(PageEntity<BaseBankBranch> pageEntity);

	public void add(BaseBankBranch baseBankBranch);

	public void udateById(BaseBankBranch baseBankBranch);

	public List<BaseBankBranch> findByCondition(BaseBankBranch condition);

	public List<BaseBankBranch> list();

	public void deleteById(Integer id);

	public int delete(Integer id, Boolean isDelete);

}
