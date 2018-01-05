package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseTravelAgency;

public interface BaseTravelAgencyMapper {
    int insert(BaseTravelAgency record);

    int insertSelective(BaseTravelAgency record);

    BaseTravelAgency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseTravelAgency record);

    int updateByPrimaryKey(BaseTravelAgency record);

	List<BaseTravelAgency> findByPage(PageEntity<BaseTravelAgency> pageEntity);

	BaseTravelAgency findById(Integer id);

	void deleteById(Integer id);
}