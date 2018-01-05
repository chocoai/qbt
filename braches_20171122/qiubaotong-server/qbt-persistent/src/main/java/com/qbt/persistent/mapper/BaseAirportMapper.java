package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAirport;

public interface BaseAirportMapper {
	
    int insert(BaseAirport baseAirport);

    BaseAirport findById(Integer id);

    int updateById(BaseAirport baseAirport);
    
    List<BaseAirport> findList();
    
    List<BaseAirport> findByPage(PageEntity<BaseAirport> pageEntity);
    
    List<BaseAirport> findByCondition(BaseAirport baseAirport);
    
    int deleteById(Integer id);

	List<BaseAirport> list();

	int delete(@Param("id")Integer id, @Param("isDelete")Boolean isDelete);
}