package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BaseNewSfPrice;

public interface BaseNewSfPriceMapper {
	
    int insert(BaseNewSfPrice record);

    BaseNewSfPrice selectById(Integer id);

    int updateById(BaseNewSfPrice record);
    
    BaseNewSfPrice findByArea(BaseNewSfPrice record);

	List<BaseNewSfPrice> findByPage(PageEntity<BaseNewSfPrice> pageEntity);
	
    BaseNewSfPrice findByArea(@Param("startArea")String startArea, @Param("endArea")String endArea);

	void delete(Integer id);
}