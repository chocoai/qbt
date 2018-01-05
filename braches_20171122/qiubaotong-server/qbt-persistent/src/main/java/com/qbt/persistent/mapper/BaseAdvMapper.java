package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAdv;

public interface BaseAdvMapper {
	
    int insert(BaseAdv baseAdv);
    
    int updateByPrimaryKey(BaseAdv baseAdv);

	int delete(int id);
	
	List<BaseAdv> findByPage(PageEntity<BaseAdv> pageEntity);

	List<BaseAdv> findByCondition(BaseAdv condition);

	List<BaseAdv> list(@Param("type")String type, @Param("position")String position);

	BaseAdv findById(Integer id);

}