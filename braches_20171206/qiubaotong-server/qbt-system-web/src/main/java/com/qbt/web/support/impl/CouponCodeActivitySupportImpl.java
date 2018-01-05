package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.CouponCodeActivity;
import com.qbt.service.CommonService;
import com.qbt.service.CouponCodeActivityService;
import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityPageReqVo;
import com.qbt.web.pojo.couponCodeActivity.CouponCodeActivityVo;
import com.qbt.web.support.CouponCodeActivitySupport;

@Service
public class CouponCodeActivitySupportImpl implements CouponCodeActivitySupport{

	@Resource
	private CouponCodeActivityService couponCodeActivityService;
	@Resource
	private CommonService commonService;
	
	@Override
	public List<CouponCodeActivityVo> findByPage(CouponCodeActivityPageReqVo reqVo) {
		PageEntity<CouponCodeActivity> pageEntity = BeanUtil.pageConvert(reqVo, CouponCodeActivity.class);
		List<CouponCodeActivity> list = couponCodeActivityService.findByPage(pageEntity);
		List<CouponCodeActivityVo> voList = BeanUtil.list2list(list, CouponCodeActivityVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public Integer add(CouponCodeActivityVo vo) {
		CouponCodeActivity couponCodeActivity = BeanUtil.a2b(vo, CouponCodeActivity.class);
		couponCodeActivity.setUseCount(0);
		couponCodeActivity.setRuleType(1);
		//优惠码6位大写字母与数字随机组合
		String code =  commonService.createCouponCodeActivityCode();
		couponCodeActivity.setCode(code);
		return couponCodeActivityService.add(couponCodeActivity);
		 
	}

	@Override
	public CouponCodeActivityVo findById(Integer id) {
		CouponCodeActivity couponCodeActivity =  couponCodeActivityService.findById(id);
		CouponCodeActivityVo vo = BeanUtil.a2b(couponCodeActivity, CouponCodeActivityVo.class);
		return vo;
	}

	@Override
	public void updateById(CouponCodeActivityVo vo) {
		CouponCodeActivity couponCodeActivity = BeanUtil.a2b(vo, CouponCodeActivity.class);
		couponCodeActivityService.update(couponCodeActivity);
	}

}
