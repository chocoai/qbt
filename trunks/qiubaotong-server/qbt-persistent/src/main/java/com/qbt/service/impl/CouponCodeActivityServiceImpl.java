package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.CouponCodeActivity;
import com.qbt.persistent.mapper.CouponCodeActivityMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.CouponCodeActivityService;

@Service
public class CouponCodeActivityServiceImpl implements CouponCodeActivityService {

	@Resource
	private CouponCodeActivityMapper couponCodeActivityMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<CouponCodeActivity> findByPage(PageEntity<CouponCodeActivity> pageEntity) {
		return couponCodeActivityMapper.findByPage(pageEntity);
	}

	@Override
	public int add(CouponCodeActivity couponCodeActivity) {
		couponCodeActivityMapper.insert(couponCodeActivity);
		cacheCouponInfo(couponCodeActivity);
		return couponCodeActivity.getId();
	}

	@Override
	public CouponCodeActivity findById(Integer id) {
		CouponCodeActivity codeActivity = couponCodeActivityMapper.findById(id);
		cacheCouponInfo(codeActivity);
		return codeActivity;
	}

	@Override
	public void update(CouponCodeActivity couponCodeActivity) {
		couponCodeActivityMapper.updateById(couponCodeActivity);
	}

	@Override
	public CouponCodeActivity findByCode(String code) {
		CouponCodeActivity codeActivity = couponCodeActivityMapper.findByCode(code);
		cacheCouponInfo(codeActivity);
		return codeActivity;
	}
	
	
	/**
	 * 
	 * cacheCouponInfo:(缓存优惠券使用次数).
	 *
	 * @author huangyihao
	 * 2017年5月23日 下午3:42:41
	 * @param codeActivity
	 *
	 */
	private void cacheCouponInfo(CouponCodeActivity codeActivity){
		if(codeActivity != null){
			String useKey = RedisKeyUtil.coupon_code_activity_use_key(codeActivity.getCode());
			String useValue = redisService.getString(useKey);
			if(useValue == null){
				redisService.putString(useKey, codeActivity.getUseCount().toString());
			}
		}
	}
	
	@Override
	public int incrUseCountByCode(String code) {
		CouponCodeActivity codeActivity = this.findByCode(code);
		String useKey = RedisKeyUtil.coupon_code_activity_use_key(code);
		Long useValue = 0l;
		if(codeActivity.getCount() >= 0){
			useValue = redisService.incr(useKey, codeActivity.getCount().longValue());
		}else{
			useValue = redisService.incr(useKey);
		}
		couponCodeActivityMapper.updateUseCountByCode(useValue.intValue(), code);
		return useValue.intValue();
	}

}
