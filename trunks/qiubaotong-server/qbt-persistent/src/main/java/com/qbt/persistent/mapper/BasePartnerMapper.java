package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BasePartner;

public interface BasePartnerMapper {

	List<BasePartner> findByPage(PageEntity<BasePartner> pageEntity);

	List<BasePartner> findByCondition(BasePartner condition);
	
	int insert(BasePartner basePartner);

	void updateByPrimaryKeySelective(BasePartner basePartner);

	BasePartner findById(Integer id);

	List<BasePartner> findAll(int type);

	void updateStatus(@Param("id")Integer id, @Param("status")int status);
	
}
