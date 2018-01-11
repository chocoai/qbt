package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.TicketPackageRuleConfig;

public interface TicketPackageRuleConfigMapper {
	
	int insertByBatch(@Param("configs")List<TicketPackageRuleConfig> configs);
	
	List<TicketPackageRuleConfig> findById(@Param("id")int id);

}
