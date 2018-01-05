package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.activity.ActivityInfoVo;
import com.qbt.web.pojo.activity.ActivityOrderRequest;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.shoppingCart.ShoppingCart;

public interface ActivitySupport {

	/**
	 *  订单检查是否有优惠活动
	  * @Title: checkOrder
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param orderId
	  * @return
	 */
	public OrderActivity checkOrder(String orderId);
	
	/**
	 * 
	 * checkActivityOff:(订单检查是否有优惠活动).
	 *
	 * @author huangyihao
	 * 2017年2月20日 上午11:18:20
	 * @param freight
	 * @param jAddrType
	 * @param jAddrId
	 * @param jAreaId
	 * @param dAddrType
	 * @param dAddrId
	 * @param dAreaId
	 * @return
	 *
	 */
	public OrderActivity checkActivityOff(ActivityOrderRequest request);
	
	/**
	 *  缓存多个子订单多个活动的信息
	  * @Title: cachePayOrderActivity
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param activityList
	 */
	public void cachePayOrderActivity(int bigOrderId,List<OrderActivity> activityList);
	
	/**
	 *  获取多个子订单多个活动的信息
	  * @Title: cachePayOrderActivity
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param activityList
	 */
	public List<OrderActivity> getCachePayOrderActivity(int bigOrderId);
	
	/**
	 *  检查购物车球包订单是否参与满减
	  * @Title: checkShoppingCart
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param cart
	  * @return
	 */
	public void checkShoppingCart(ShoppingCart cart);
	
	/**
	 *  检待支付球包订单是否参与满减
	  * @Title: checkShoppingCart
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param cart
	  * @return
	 */
	public void checkSubOrderInfo(OrderDetail cart);
	
	/**
	 *  活动列表
	  * @Title: list
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param type
	  * @return
	 */
	public List<ActivityVo> list(int type);

	/**
	 *  活动详情
	  * @Title: detail
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param id
	  * @return
	 */
	public ActivityInfoVo detail(int id);
	
}
