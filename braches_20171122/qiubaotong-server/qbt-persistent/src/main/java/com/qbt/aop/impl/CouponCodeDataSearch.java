/**
 * Project Name:qbt-persistent
 * File Name:CouponCodeDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日上午10:35:06
 *
*/

package com.qbt.aop.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.aop.DataColletionSearch;
import com.qbt.persistent.entity.Coupon;
import com.qbt.service.CouponService;

/**
 * ClassName:CouponCodeDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午10:35:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("couponCodeDataSearch")
public class CouponCodeDataSearch implements DataColletionSearch {
	
	@Resource
	private CouponService couponService;
	
	@Override
	public Set<String> searchData(Object... args) {
		List<Coupon> couponList = couponService.findAllCouponCode();
		Set<String> data = new HashSet<String>();
		for(Coupon c : couponList) {
			data.add(c.getCode());
			data.add(c.getChildCode());
		}
		return data;
	}
	
}
