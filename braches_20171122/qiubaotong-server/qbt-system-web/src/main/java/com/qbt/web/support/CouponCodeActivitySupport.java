package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityPageReqVo;
import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityVo;

public interface CouponCodeActivitySupport {

	List<CouponCodeActivityVo> findByPage(CouponCodeActivityPageReqVo reqVo);

	Integer add(CouponCodeActivityVo vo);

	CouponCodeActivityVo findById(Integer id);

	void updateById(CouponCodeActivityVo vo);

	
	
}
