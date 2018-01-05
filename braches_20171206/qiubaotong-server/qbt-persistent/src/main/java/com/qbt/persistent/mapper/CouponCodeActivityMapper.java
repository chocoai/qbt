package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.CouponCodeActivity;

public interface CouponCodeActivityMapper {
	
	Integer insert(CouponCodeActivity record);

    CouponCodeActivity findById(Integer id);

    int updateById(CouponCodeActivity record);

	List<CouponCodeActivity> findByPage(PageEntity<CouponCodeActivity> pageEntity);
	
	CouponCodeActivity findByCode(@Param("code")String code);
	
	int updateUseCountByCode(@Param("useCount")int useCount, @Param("code")String code);
}