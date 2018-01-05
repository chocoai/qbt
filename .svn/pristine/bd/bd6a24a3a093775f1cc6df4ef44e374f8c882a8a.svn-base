package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBank;

public interface BaseBankMapper {
    int insert(BaseBank record);

    int insertSelective(BaseBank record);

    BaseBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseBank record);

    int updateByPrimaryKey(BaseBank record);

	List<BaseBank> findByPage(PageEntity<BaseBank> pageEntity);

	List<BaseBank> findByCondition(BaseBank condition);

	int deleteById(@Param("id")Integer id, @Param("isDelete")Boolean isDelete);
    
}