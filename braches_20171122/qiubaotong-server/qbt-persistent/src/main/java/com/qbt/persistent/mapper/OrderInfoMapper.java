package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderInfo;
import com.qbt.persistent.dto.OrderCountDto;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.dto.VipOrderInfo;
import com.qbt.persistent.entity.OrderInfo;

public interface OrderInfoMapper {
	
    int insert(OrderInfo orderInfo);

    OrderInfo findById(Integer id);

	OrderInfo findByNumber(@Param("number")String number);

	List<OrderInfo> findByUserIdForWeiXin(OrderPageDto pageDto);

	int updateById(OrderInfo orderInfo);
	
	int updateByProxUserId(OrderInfo orderInfo);
	
	void updateMailChannelById(OrderInfo orderInfo);
	
	List<BossOrderInfo> findByPageBoss(PageEntity<BossOrderInfo> pageEntity);

	List<OrderInfo> queryAssistantOrder(@Param("applyType")int applyType,@Param("applyId")int applyId,@Param("type") int type,@Param("keyword") String keyword);
	
	OrderInfo queryKeyword(String keyword);
	/**
	 * 查询可关闭的订单
	 * @return
	 */
	List<OrderInfo> findCloseableOrders(@Param("minute")int minute);
	
	/**
	 * 获取可路由查询的订单
	 * @return
	 */
	List<OrderInfo> findRouteableOrders();
	
	/**
	 * 获取当天需确认的订单
	 * @return
	 */
	List<OrderInfo> findCurrentConfirmOrders();
	
	/**
	 * 查询可预约取包的订单
	 * @param type 2-进入球包预约时间 3-超过预约时间两小时
	 * @return
	 */
	List<OrderInfo> findSendableOrders(@Param("type")Integer type);
	
	/**
	 * 查询超时到达的订单
	 * @return
	 */
	List<OrderInfo> findTimeoutDeliverOrders();

	/**
	 *  客服修改订单
	  * @Title: updateByIdForBoss
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param newOrderInfo
	  * @return
	 */
	int updateByIdForBoss(OrderInfo newOrderInfo);

	int orderCount(@Param("orderSource")Integer orderSource, @Param("userId")Integer userId);
	
	OrderInfo findByMailNo(@Param("mailNo")String mailNo);

	List<OrderInfo> queryPartnerOrder(OrderPageDto pageDto);
    
	List<OrderInfo> findByOrderNumber(@Param("orderNumber")String orderNumber);
	
	OrderInfo trackOrder(@Param("keyword")String keyword);
	
	List<OrderInfo> findAllContactInfo();
	
	List<OrderInfo> findAllSubOrder();
	
	int updateByIdForBigOrder(OrderInfo orderInfo);
	
	List<OrderInfo> findRecentOrderByUserId(@Param("userId")int userId, @Param("day")int day);
	
	List<OrderInfoSummary> summaryOrderBySuperOrderIds(@Param("superOrderIds")List<Integer> superOrderIds);
    
	List<OrderInfo> findByMd5(@Param("orderId")int orderId,@Param("userId")int userId,@Param("md5")String md5);

	int countCouponOrder(@Param("orderId")int orderId, @Param("couponId")Integer couponId);
	
	List<OrderInfo> findNeedPayOrders(@Param("minute")int minute);
	
	List<VipOrderInfo> findVipOrderInfoByPage(PageEntity<VipOrderInfo> pageEntity);

	OrderInfo getLastVipOrder(@Param("userId")Integer userId,@Param("vipId")int vipId);

	OrderInfo getLastVipOrderByMobile(@Param("mobile")String jMobile, @Param("name")String jName,@Param("vipId")int vipId);
	
	/**
	 * 
	 * findReminderDeliverOrders:(查询到达时间前两小时未被签收的订单).
	 *
	 * @author huangyihao
	 * 2016年12月26日 下午3:09:34
	 * @return
	 *
	 */
	List<OrderInfo> findReminderDeliverOrders();

	double countTotalAmount(int bigOrderId);

	int updateUserId(@Param("bigOrderId")int bigOrderId,@Param("userId") int userId,@Param("openId")String openId);
    
	OrderInfo findLastOrderByProxyUserId(@Param("userId")Integer userId,@Param("proxyUserId")Integer proxyUserId);

	List<OrderInfo> afterHalfhourProxyUnpayList();
	
	List<OrderInfo> afterOnehourProxyUnpayList();
	
	List<OrderInfo> findCloseableOrdersForOfficial(@Param("minute")int minute);
	
	String findOrderMinDate();
	
	List<OrderInfo> findByCountDate(@Param("countDate")String countDate);
	
	int findUnpayCountForWeiXin(@Param("userId") int userId);
	
	OrderInfo getUserLastOrder(@Param("userId") int userId);
	
	OrderCountDto findUnsignCountForWeiXin(@Param("userId") int userId);

	List<OrderInfo> findByOrderId(@Param("orderId") int orderId);
	
	void updateWeixinPayCodeById(@Param("id")Integer id,@Param("weixinPayCode")String weixinPayCode,@Param("weixinPayCodeOperater")String weixinPayCodeOperater);

	void updateConfirmReceiveById(@Param("id")Integer id);
	
	void updateDrawedBillById(@Param("id")Integer id);
	
	List<OrderInfo> findByAutoConfirm(@Param("date")String date);
	List<OrderInfo> findByBill(@Param("userId")Integer userId,@Param("date")String date);
	List<OrderInfo> findByIds(@Param("ids")int[] ids);
	
	/**
	 * 找到已寄送的历史包裹所使用的address信息作为下一次寄送的选项 
	 * @param userId the user id
	 * @author michael.he
	 * @return
	 */
	List<OrderInfo> findOrderAddressById(@Param("userId")Integer userId);
	
	/**
	 * 获取当前用户的历史球场地址信息
	 * @param userId
	 * @return
	 */
	List<OrderInfo> findCourseAddressById(@Param("userId")Integer userId);

}