package com.qbt.web.support;

import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderCountVo;
import com.qbt.web.pojo.order.OrderDetailV2;

public interface OrderV2Support {

	public String orderCreate(OrderConfirm orderInfo);

	public OrderDetailV2 unpayOrderDetail(String orderId);
	
	public void paySuccess(OrderPayInfo payment);
	
	/**
	 * 
	 * orderCount:(根据订单状态获取数目统计).
	 *
	 * @author huangyihao
	 * 2017年4月12日 下午2:24:06
	 * @param userweixin 微信用户
	 * @return
	 *
	 */
	public OrderCountVo orderCountByStatus(UserWeixin userweixin);
	
	public OrderDetailV2 userLastOrder(int userId);
	
	public void reward(Orders orderInfo,UserWeixin userweixin);

	public Boolean isWinner(Integer orderId);
	
	public void saleOrderInfo(OrderInfo orderInfo);

	public OrderDetailV2 backOrder(String orderId);

}
