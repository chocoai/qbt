package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipType;

public interface VipTypeMapper {
	
    int insert(VipType vipType);

    VipType selectById(@Param("id")Integer id);

    int updateById(VipType vipType);

	List<VipType> findByPage(PageEntity<VipType> pageEntity);

    List<VipType> selectByStatus(@Param("status")int status);

	void updateStatus(int status);

	List<VipType> findByCondition(VipType condition);
    
	VipType findByName(@Param("name")String name);

	VipType findOne();
}