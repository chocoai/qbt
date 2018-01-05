package com.qbt.persistent.mapper;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.SysConfig;

public interface SysConfigMapper {
	SysConfig findByCode(@Param("code")String code);
	void updateByCode(SysConfig sysConifg);
}
