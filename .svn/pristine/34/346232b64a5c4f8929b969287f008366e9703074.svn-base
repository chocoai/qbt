package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBankBranch;

public interface BaseBankBranchMapper {
    int insert(BaseBankBranch record);

    BaseBankBranch findById(Integer id);

    int updateById(BaseBankBranch record);

    
    List<BaseBankBranch> findList();

	List<BaseBankBranch> findByPage(PageEntity<BaseBankBranch> pageEntity);

	List<BaseBankBranch> findByCondition(BaseBankBranch condition);

	List<BaseBankBranch> list();

	void deleteById(Integer id);

	int delete(@Param("id")Integer id, @Param("isDelete")Boolean isDelete);
	
	
}