/**
 * Project Name:qbt-persistent
 * File Name:ActivityCouponCodeDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日上午11:11:56
 *
*/

package com.qbt.aop.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.aop.DataColletionSearch;
import com.qbt.persistent.entity.Coupon;
import com.qbt.service.CouponService;

/**
 * ClassName:ActivityCouponCodeDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午11:11:56
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("activityCouponCodeDataSearch")
public class ActivityCouponCodeDataSearch implements DataColletionSearch {
	
	@Resource
	private CouponService couponService;
	
	@Override
	public List<String> searchData(Object... args) {
		int activityId = (Integer)args[0];
		List<Coupon> couponList = couponService.selectCouponByActivityId(activityId);
		Set<String> codeList = new HashSet<String>();
		for (Coupon c : couponList) {
			if (c.getClaimType() == 0) {
				codeList.add(c.getCode());
			}
		}
		return new ArrayList<String>(codeList);
	}

}
