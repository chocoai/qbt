package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrgGroupAmountConfig;

public interface OrgGroupAmountConfigMapper {
	
    int insert(OrgGroupAmountConfig record);

    OrgGroupAmountConfig selectById(Integer id);

    int updateById(OrgGroupAmountConfig record);
    
    List<OrgGroupAmountConfig> selectByOrgId(@Param("orgId")Integer orgId);
    
    int deleteByOrgId(@Param("orgId")Integer orgId);
    
    int insertByBatch(@Param("configs")List<OrgGroupAmountConfig> configs);

	List<OrgGroupAmountConfig> list();

	OrgGroupAmountConfig selectProperAmountConfig(@Param("amount")Double amount, @Param("orgId")Integer orgId);
}