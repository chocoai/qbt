package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.coupon.CouponPageReqVo;
import com.qbt.web.pojo.coupon.CouponVo;

public interface CouponSupport {
	
	/**
	 * 分页查询
	 * @param reqVo
	 * @return
	 */
	List<CouponVo> findByPage(CouponPageReqVo reqVo);
	
	/**
	 * 优惠券导出
	 * @param reqVo
	 * @return
	 */
	String exportCoupon(CouponPageReqVo reqVo) throws Exception;
	
	/**
	 * 更新券领取状态
	 * @param vo
	 * @return
	 */
	boolean update(CouponVo vo) throws BusinessException;
}
