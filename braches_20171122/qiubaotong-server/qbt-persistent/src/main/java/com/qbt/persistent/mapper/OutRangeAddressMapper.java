package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OutRangeAddress;

public interface OutRangeAddressMapper {
	
    int insert(OutRangeAddress record);

    OutRangeAddress findById(Integer id);

    int updateById(OutRangeAddress record);

	List<OutRangeAddress> findByPage(PageEntity<OutRangeAddress> pageEntity);
	
	OutRangeAddress findByAreaId(@Param("areaId")Integer areaId);

	void deleteById(Integer id);

	List<OutRangeAddress> findByCondition(OutRangeAddress condition);

}