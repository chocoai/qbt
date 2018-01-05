package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.refund.OrderRefundVo;
import com.qbt.web.pojo.refund.RefundPageReqVo;

public interface OrderRefundSupport {

	/**
	 * 分页查询
	 * @param reqVo
	 * @return
	 */
	List<OrderRefundVo> findByPage(RefundPageReqVo reqVo);
	
	/**
	 * 退款详情
	 * @param id
	 * @return
	 */
	OrderRefundVo findById(Integer id);
	
	/**
	 * 更新退款信息
	 * @param vo
	 * @return
	 */
	boolean update(OrderRefundVo vo);
	
}
