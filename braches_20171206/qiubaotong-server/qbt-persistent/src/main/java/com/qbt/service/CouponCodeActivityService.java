package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.CouponCodeActivity;

public interface CouponCodeActivityService {

	List<CouponCodeActivity> findByPage(PageEntity<CouponCodeActivity> pageEntity);

	int add(CouponCodeActivity couponCodeActivity);

	CouponCodeActivity findById(Integer id);

	void update(CouponCodeActivity couponCodeActivity);
	
	CouponCodeActivity findByCode(String code);
	
	int incrUseCountByCode(String code);
	
}
