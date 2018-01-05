package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseUserLabel;

public interface BaseUserLabelMapper {

	int insertByBatch(@Param("configs")List<BaseUserLabel> configs);

	void deleteByMobile(String mobile);

	List<BaseUserLabel> getByMobile(@Param("mobile") String mobile);

	List<BaseUserLabel> listContentByMobile(@Param("mobile") String mobile);

	List<BaseUserLabel> selectByUser(@Param("userType") Integer userType, @Param("userId") Integer userId);

	List<BaseUserLabel> selectContentByUser(@Param("userType") Integer userType, @Param("userId") Integer userId);

	void deleteByUser(@Param("userType")Integer userType, @Param("userId")Integer userId);
	
}
