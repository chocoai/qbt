package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseTeachCenter;

public interface BaseTeachCenterMapper {
    int insert(BaseTeachCenter record);

    //int insertSelective(BaseTeachCenter record);

    BaseTeachCenter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseTeachCenter record);

   // int updateByPrimaryKey(BaseTeachCenter record);

	List<BaseTeachCenter> findByPage(PageEntity<BaseTeachCenter> pageEntity);

	BaseTeachCenter findById(Integer id);

	void deleteById(Integer id);
}