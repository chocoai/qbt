package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSfSite;

public interface BaseSfSiteMapper {
    int insert(BaseSfSite record);

    BaseSfSite findById(Integer id);

    int updateById(BaseSfSite record);
    
    List<BaseSfSite> findList();

	List<BaseSfSite> findByPage(PageEntity<BaseSfSite> pageEntity);

	List<BaseSfSite> findByCondition(BaseSfSite condition);

	List<BaseSfSite> list();

	void deleteById(Integer id);

	int deleteById2(@Param("id")Integer id, @Param("isDelete")Boolean isDelete);
}