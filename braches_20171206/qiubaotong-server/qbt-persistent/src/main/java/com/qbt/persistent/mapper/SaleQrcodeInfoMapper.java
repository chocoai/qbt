package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SaleQrcodeInfo;

public interface SaleQrcodeInfoMapper {
	
    int insert(SaleQrcodeInfo record);

    SaleQrcodeInfo selectById(Integer id);

    int updateById(SaleQrcodeInfo record);

	int getMaxId();

	List<SaleQrcodeInfo> findByPage(PageEntity<SaleQrcodeInfo> pageEntity);

	List<SaleQrcodeInfo> findList();

	int insertByBatch(@Param("infos")List<SaleQrcodeInfo> infos);
	
	SaleQrcodeInfo selectByCode(@Param("salesmanCode")String salesmanCode);

	List<String> findNoApplySalesmanCode();

}