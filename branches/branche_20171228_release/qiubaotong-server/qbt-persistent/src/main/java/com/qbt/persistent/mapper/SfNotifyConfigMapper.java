package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SfNotifyConfig;

public interface SfNotifyConfigMapper {
	
    int insert(SfNotifyConfig record);

    /**
     * 分页查询
     * @param pageEntity
     * @return
     */
    List<SfNotifyConfig> findByPage(PageEntity<SfNotifyConfig> pageEntity);
    
    
    int deleteById(Integer id);
    
    List<SfNotifyConfig> findByOrderNumber(@Param("orderNumber") String orderNumber);
}