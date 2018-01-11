package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseBank;
import com.qbt.persistent.entity.BaseInsuredTemplate;

public interface BaseInsuredTemplateMapper {
	
    int insert(BaseInsuredTemplate template);
    
    BaseInsuredTemplate findById(Integer id);

    int updateById(BaseInsuredTemplate template);
    
    BaseInsuredTemplate findValid();
    
    int updateState(@Param("id")int id,@Param("state")int state);
    
    int updateInvalid(@Param("id")int notInId);

	List<BaseInsuredTemplate> findByPage(PageEntity<BaseInsuredTemplate> pageEntity);

	void deleteById(Integer id);

	List<BaseBank> findByCondition(BaseInsuredTemplate condition);
}