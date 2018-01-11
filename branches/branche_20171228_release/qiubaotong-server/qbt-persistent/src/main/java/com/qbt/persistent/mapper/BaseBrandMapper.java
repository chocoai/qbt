package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossBaseBrand;
import com.qbt.persistent.entity.BaseBrand;

public interface BaseBrandMapper {
	
    int insert(BaseBrand baseBrand);

    BaseBrand selectById(Integer id);

    int updateById(BaseBrand baseBrand);
    
    int deleteById(Integer id);
    
    List<BossBaseBrand> findByPage(PageEntity<BossBaseBrand> pageEntity);
    
    int isExist(@Param("bagNo")String bagNo, @Param("rfidNo")String rfidNo);
}