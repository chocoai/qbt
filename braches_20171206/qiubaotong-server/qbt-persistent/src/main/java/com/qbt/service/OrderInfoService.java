package com.qbt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderInfo;
import com.qbt.persistent.dto.OrderCountDto;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.dto.VipOrderInfo;
import com.qbt.persistent.entity.OrderInfo;

public interface OrderInfoService {

	public int inser(OrderInfo orderInfo);
	
	public OrderInfo findById(int id);
	
	public OrderInfo findByNumber(String number);

	public List<OrderInfo> findByUserIdForWeiXin(OrderPageDto pageDto);

	public int updateById(OrderInfo orderInfo);
	
	public int updateByProxUserId(OrderInfo orderInfo);
	
	public List<BossOrderInfo> findByPageBoss(PageEntity<BossOrderInfo> pageEntity);
	/**
	 * 分页查询Boss端订单列表
	 * @param condition
	 * @param limitIndex
	 * @param limitSize
	 * @return
	 */
	public List<BossOrderInfo> findByPageBossNew(BossOrderInfo condition,int limitIndex,int limitSize,String orderByColumn,String orderByType);
	/**
	 * 获取Boss分页查询总记录数
	 * @param condition
	 * @return
	 */
	public int findByPageBossNewCount(BossOrderInfo condition);

	public List<OrderInfo> queryAssistantOrder(int applyType, int applyId, int type, String keyword);
	
	public long orderCount(OrderInfo orderInfo);
	
	/**
	 * 查询可关闭的订单
	 * @return
	 */
	public List<OrderInfo> findCloseableOrders(int minute);
	
	/**
	 * 获取可路由查询的订单
	 * @return
	 */
	public List<OrderInfo> findRouteableOrders();
	
	/**
	 * 获取当天需确认的订单
	 * @return
	 */
	public List<OrderInfo> findCurrentConfirmOrders();
	
	public OrderInfo queryKeyword(String keyword);
	
	/**
	 * 查询可预约取包的订单
	 * @param type 2-进入球包预约时间 3-超过预约时间两小时
	 * @return
	 */
	public List<OrderInfo> findSendableOrders(Integer type);
	
	/**
	 * 查询超时到达的订单
	 * @return
	 */
	public List<OrderInfo> findTimeoutDeliverOrders();

	/**
	 *  更新订单信息，boss客服修改订单
	  * @Title: updateByIdForBoss
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param newOrderInfo
	  * @return
	 */
	public int updateByIdForBoss(OrderInfo newOrderInfo);
	
	public OrderInfo findByMailNo(String mailNo);
	
	public int updateCommentById(int orderId, String orderNumber, boolean isComment);
	// 备注更新
	public int updateRemarkById(int id, String orderNumber, String remark);
	// 更新下单语言
	public int updateLangEnameById(int id, String orderNumber, String langEname);
	
	public OrderInfo findLastOrderByUserId(Integer userId,Integer proxyUserId);

	public List<OrderInfo> queryPartnerOrder(OrderPageDto pageDto);
	/**
	 *  大订单查询子订单信息
	  * @Title: findByOrderNumber
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderId
	  * @return
	 */
	public List<OrderInfo> findByOrderNumber(String orderNumber);
	
	public OrderInfo trackOrder(String keyword);
	
	public List<OrderInfo> findAllContactInfo();
	
	public List<OrderInfo> findRecentOrderByUserId(int userId, int day);
	
	public List<OrderInfoSummary> summaryOrderBySuperOrderIds(List<Integer> superOrderIds);
	
	List<OrderInfo> findAllSubOrder();
	
	int updateByIdForBigOrder(OrderInfo orderInfo);
	
	List<OrderInfo> findByMd5(int orderId,int userId,String md5);

	public int countCouponOrder(int orderId, Integer couponId);
	
	public List<OrderInfo> findNeedPayOrders(int minute);
	
	public List<VipOrderInfo> findVipOrderInfoByPage(PageEntity<VipOrderInfo> pageEntity);

	public OrderInfo getLastVipOrder(Integer userId,int vipId);

	public OrderInfo getLastVipOrder(String jMobile, String jName,int vipId);
	
	/**
	 * 
	 * findReminderDeliverOrders:(查询到达时间前两小时未被签收的订单).
	 *
	 * @author huangyihao
	 * 2016年12月26日 下午3:09:22
	 * @return
	 *
	 */
	public List<OrderInfo> findReminderDeliverOrders();

	public double countTotalAmount(int id);

	public void updateUserId(int id, int user,String openId);

	/**
	 * 获取半小时内代下单未支付订单
	 * @return
	 */
	public List<OrderInfo> afterHalfhourProxyUnpayList();
	
	/**
	 * 获取一小时内代下单未支付订单
	 * @return
	 */
	public List<OrderInfo> afterOnehourProxyUnpayList();
	
	
	List<OrderInfo> findCloseableOrdersForOfficial(int minute);
	
	/**
	 * 获取最早的成功订单时间
	 */
	String findOrderMinDate();
	
	List<OrderInfo> findByCountDate(String countDate);
	
	int findUnpayCountForWeiXin(int userId);
	
	OrderInfo getUserLastOrder(int userId);
	
	OrderCountDto findUnsignCountForWeiXin(int userId);
	
	void updateMailChannelById(OrderInfo orderInfo);

	
	List<OrderInfo> findByOrderId(int bigOrderId);
	
	void updateWeixinPayCodeById(Integer id,String weixinPayCode,String kfId);
	
	
	void updateConfirmReceiveById(Integer id);
	
	void updateDrawedBillById(Integer id);
	
	List<OrderInfo> findByAutoConfirm(String date);
	List<OrderInfo> findByBill(Integer userId,String date);
	List<OrderInfo> findByIds(int[] ids);
	
	List<OrderInfo> findAddressHistoryById(Integer userId);
	
	List<OrderInfo> findCourseAddressById(Integer userId);
}
