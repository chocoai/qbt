package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseSfTime;

public interface BaseSfTimeMapper {
	
    int insert(BaseSfTime record);

    BaseSfTime selectById(Integer id);

    int updateById(BaseSfTime record);

	List<BaseSfTime> findByPage(PageEntity<BaseSfTime> pageEntity);
    
    BaseSfTime selectByDate(@Param("date")Date date);

	void deleteById(Integer id);

	List<BaseSfTime> findByCondition(BaseSfTime condition);
}