package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrgGroup;

public interface OrgGroupMapper {
	
    int insert(OrgGroup record);

    OrgGroup selectById(Integer id);

    int updateById(OrgGroup record);
    
    List<OrgGroup> findByPage(PageEntity<OrgGroup> pageEntity);
    
    int exists(OrgGroup orgGroup);
    
    int deleteById(Integer id);
    
    List<OrgGroup> list();
}