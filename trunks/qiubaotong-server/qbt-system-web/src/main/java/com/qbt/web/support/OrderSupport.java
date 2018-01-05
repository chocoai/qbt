package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderDetailVo;
import com.qbt.web.pojo.order.OrderOperateLogVo;
import com.qbt.web.pojo.order.OrderPageReqVo;
import com.qbt.web.pojo.order.OrderVo;
import com.qbt.web.pojo.order.OrderWaybillVo;
import com.qbt.web.pojo.refund.OrderCancelRefund;

public interface OrderSupport {

	/**
	 * 订单分页查询
	 * 
	 * @param reqVo
	 * @return
	 */
	List<OrderVo> findByPage(OrderPageReqVo reqVo);

	/**
	 * 查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	OrderDetailVo findById(int orderNo);

	/**
	 * 根据订单ID查询订单操作日志
	 * 
	 * @param orderId
	 * @return
	 */
	List<OrderOperateLogVo> findOperateLogByOrderId(Integer orderId);

	/**
	 * 根据订单ID查询订单物流信息
	 * 
	 * @param orderId
	 * @return
	 */
	List<OrderWaybillVo> findWaybillByOrderId(Integer orderId);

	/**
	  * 订单修改/BPS重新下单/纸质下单
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年8月26日
	  * @modify: share 2016年8月26日
	  * @param orderDetail
	 */
	void update(OrderDetailVo orderDetail, SysUser sysUser);

	/**
	  * 订单推送
	  * @Title: orderPush
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param id
	 */
	void orderPush(int id);

	/**
	  * 订单取消
	  * @Title: orderCancel
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param orderDetail
	  * @param sysUser
	 */
	void orderCancel(OrderCancelRefund orderDetail, SysUser sysUser);

	/**
	  * 客服确认已收件
	  * @Title: orderConfirmSfRecive
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param orderDetail
	  * @param sysUser
	 */
	void orderConfirmSfRecive(OrderDetailVo orderDetail, SysUser sysUser);
    
	/**
	  * boss下单
	  * @Title: createOrder
	  * @Description: TODO
	  * @author: share 2016年10月25日
	  * @modify: share 2016年10月25日
	  * @param orderConfirm
	 */
	void createOrder(OrderConfirm orderConfirm);

	/**
	  * 取消订单计算退款金额信息
	  * @Title: orderCancelCalcRefund
	  * @Description: TODO
	  * @author: share 2016年11月3日
	  * @modify: share 2016年11月3日
	  * @param orderDetail
	  * @return
	 */
	OrderCancelRefund orderCancelCalcRefund(OrderDetailVo orderDetail);
	
	
	/**
	 *  修改订单运营渠道
	 * @param orderInfo
	 */
	void updateMailChannelById(SysUser sysUser, Integer id, Integer mailChannel, String mailNumber);
	
	/**
	 * 
	 * receivable:(订单客服/财务收款).
	 *
	 * @author haungyihao
	 * 2016年11月7日 上午10:56:51
	 * @param id 订单id
	 * @param receivableType 1-客服 2-财务
	 * @param sysUser 后台登陆用户
	 * @return
	 *
	 */
	boolean receivable(Integer id, Integer receivableType, SysUser sysUser);
	
	
    void updateWeixinPayCodeById(Integer id, String weixinPayCode, String kfId);
}
