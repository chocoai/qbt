package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BaseSfExpressLogDto;
import com.qbt.persistent.entity.BaseSfExpressLog;

public interface BaseSfExpressLogMapper {
	
    int insert(BaseSfExpressLog record);

    BaseSfExpressLog selectById(Integer id);

    int updateById(BaseSfExpressLog record);

	List<BaseSfExpressLog> findByPage(PageEntity<BaseSfExpressLogDto> pageEntity);
	
	int deleteByDay(@Param("day")int day);
}