package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseAdvertImage;

public interface BaseAdvertImageMapper {
	
    int insert(BaseAdvertImage record);

    BaseAdvertImage findById(Integer id);

    int updateById(BaseAdvertImage record);

	List<BaseAdvertImage> findListByAdvertCode(String advertCode);

	void deleteByAdvertCode(String advertCode);

	void insertByBatch(@Param("configs")List<BaseAdvertImage> configs);

}