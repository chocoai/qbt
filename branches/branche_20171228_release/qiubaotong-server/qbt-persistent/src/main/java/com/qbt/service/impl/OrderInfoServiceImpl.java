package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.dto.BossOrderInfo;
import com.qbt.persistent.dto.OrderCountDto;
import com.qbt.persistent.dto.OrderInfoSummary;
import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.dto.VipOrderInfo;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.mapper.OrderInfoMapper;
import com.qbt.persistent.mapper.OrdersMapper;
import com.qbt.persistent.mapper.ReportOrderMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.OrderInfoService;

/**
 *  订单管理
  * @ClassName: OrderInfoServiceImpl
  * @Description: TODO
  * @author share 2016年8月11日
  * @modify share 2016年8月11日
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
	
	@Resource
	private OrderInfoMapper orderMapper;
	@Resource
	private OrdersMapper ordersMapper;
	@Resource
	private RedisService redisService;
	@Resource
	private ReportOrderMapper reportOrderMapper;
	
	@Override
	public int inser(OrderInfo orderInfo) {
		int result = orderMapper.insert(orderInfo);
		redisService.putMap(RedisKeyUtil.order_info_orderid_key(orderInfo.getNumber()), RedisUtil.hashsMap(orderInfo));
		return result;
	}

	@Override
	public OrderInfo findById(int id) {
		return orderMapper.findById(id);
	}

	@Override
	public OrderInfo findByNumber(String number) {
		OrderInfo info = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.order_info_orderid_key(number)), OrderInfo.class);
		if(info == null){
			info = orderMapper.findByNumber(number);
			if(info != null){
				redisService.putMap(RedisKeyUtil.order_info_orderid_key(info.getNumber()), RedisUtil.hashsMap(info));
			}
		}
		return info;
	}

	/**
	 *  用户订单列表查询
	  * @Title: findByUserIdForWeiXin
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param userId
	  * @return
	  * @see com.qbt.service.OrderInfoService#findByUserIdForWeiXin(int)
	  * 待签收已签收
	 */
	@Override
	public List<OrderInfo> findByUserIdForWeiXin(OrderPageDto pageDto) {
		return orderMapper.findByUserIdForWeiXin(pageDto);
	}

	@Override
	public int updateById(OrderInfo orderInfo) {
		int result = orderMapper.updateById(orderInfo);
		if(result > 0){
			redisService.putMap(RedisKeyUtil.order_info_orderid_key(orderInfo.getNumber()), RedisUtil.hashsMap(orderInfo));
		}
		return result;
	}

	@Override
	public List<BossOrderInfo> findByPageBoss(PageEntity<BossOrderInfo> pageEntity) {
		return orderMapper.findByPageBoss(pageEntity);
	}

	@Override
	public List<OrderInfo> queryAssistantOrder(int applyType, int applyId, int type, String keyword) {
		return orderMapper.queryAssistantOrder(applyType,applyId,type,keyword);
	}

	@Override
	public List<OrderInfo> findCloseableOrders(int minute) {
		return orderMapper.findCloseableOrders(minute);
	}

	@Override
	public List<OrderInfo> findRouteableOrders() {
		return orderMapper.findRouteableOrders();
	}

	@Override
	public List<OrderInfo> findCurrentConfirmOrders() {
		return orderMapper.findCurrentConfirmOrders();
	}
	
	public OrderInfo queryKeyword(String keyword) {
		return orderMapper.queryKeyword(keyword);
	}

	@Override
	public List<OrderInfo> findSendableOrders(Integer type) {
		return orderMapper.findSendableOrders(type);
	}

	@Override
	public List<OrderInfo> findTimeoutDeliverOrders() {
		return orderMapper.findTimeoutDeliverOrders();
	}

	@Override
	public int updateByIdForBoss(OrderInfo newOrderInfo) {
		int result = orderMapper.updateByIdForBoss(newOrderInfo);
		if(result > 0){
			OrderInfo orderInfo = orderMapper.findById(newOrderInfo.getId());
			redisService.putMap(RedisKeyUtil.order_info_orderid_key(newOrderInfo.getNumber()), RedisUtil.hashsMap(orderInfo));
		}
		return result;
	}

	@Override
	public long orderCount(OrderInfo orderInfo) {
		Integer realUserId = 0;
		if(orderInfo.getOrderSource()==1){
			realUserId = orderInfo.getProxySelfUserId();
		}else{
			realUserId = orderInfo.getUserId();
		}
		String key = RedisKeyUtil.order_user_count_userid_key(orderInfo.getOrderSource(), realUserId);
		String countstr = redisService.get(key);
		if(StringUtil.isEmpty(countstr) || Integer.parseInt(countstr) == 0){
			int count = orderMapper.orderCount(orderInfo.getOrderSource(), realUserId);
			redisService.set(key, String.valueOf(count));
		}
		long count = redisService.incr(key);
		return count;
	}
	
	public OrderInfo findByMailNo(String mailNo) {
		return orderMapper.findByMailNo(mailNo);
	}

	@Override
	public int updateCommentById(int orderId, String orderNumber, boolean isComment) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(orderId);
		orderInfo.setIsComment(isComment);
		int result = orderMapper.updateById(orderInfo);
		if(result > 0){
			redisService.hset(RedisKeyUtil.order_info_orderid_key(orderNumber), "isComment", String.valueOf(isComment));
		}
		return result;
	}

	@Override
	public int updateRemarkById(int id, String orderNumber, String remark) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(id);
		orderInfo.setRemark(remark);
		int result = orderMapper.updateById(orderInfo);
		if(result > 0){
			redisService.hset(RedisKeyUtil.order_info_orderid_key(orderNumber), "remark", String.valueOf(remark));
		}
		return result;
	}

	
	@Override
	public OrderInfo findLastOrderByUserId(Integer userId,Integer proxyUserId) {
		return orderMapper.findLastOrderByProxyUserId(userId,proxyUserId);
	}

	@Override
	public int updateLangEnameById(int id, String orderNumber, String langEname) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(id);
		orderInfo.setLangEname(langEname);
		int result = orderMapper.updateById(orderInfo);
		if(result > 0){
			redisService.hset(RedisKeyUtil.order_info_orderid_key(orderNumber), "langEname", String.valueOf(langEname));
		}
		return result;
	}

	/**
	 *  分页查询记录数
	  * @Title: queryPartnerOrder
	  * @Description: TODO
	  * @author: share 2016年10月10日
	  * @modify: share 2016年10月10日
	  * @param pageDto
	  * @return
	  * @see com.qbt.service.OrderInfoService#queryPartnerOrder(com.qbt.persistent.dto.OrderPageDto)
	 */
	@Override
	public List<OrderInfo> queryPartnerOrder(OrderPageDto pageDto) {
		return orderMapper.queryPartnerOrder(pageDto);
	}

	@Override
	public List<OrderInfo> findByOrderNumber(String orderNumber) {
		return orderMapper.findByOrderNumber(orderNumber);
	}
	
	public OrderInfo trackOrder(String keyword) {
		return orderMapper.trackOrder(keyword);
	}

	@Override
	public List<OrderInfo> findAllContactInfo() {
		return orderMapper.findAllContactInfo();
	}

	@Override
	public List<OrderInfo> findRecentOrderByUserId(int userId, int day) {
		return orderMapper.findRecentOrderByUserId(userId, day);
	}

	@Override
	public List<OrderInfoSummary> summaryOrderBySuperOrderIds(List<Integer> superOrderIds) {
		return orderMapper.summaryOrderBySuperOrderIds(superOrderIds);
	}

	@Override
	public List<OrderInfo> findAllSubOrder() {
		return orderMapper.findAllSubOrder();
	}

	@Override
	public int updateByIdForBigOrder(OrderInfo orderInfo) {
		int result = orderMapper.updateByIdForBigOrder(orderInfo);
		String key = RedisKeyUtil.order_info_orderid_key(orderInfo.getNumber());
		if(result > 0 && redisService.exists(key)){
			redisService.hset(key, "orderId", String.valueOf(orderInfo.getOrderId()));
			redisService.hset(key, "orderNumber", String.valueOf(orderInfo.getOrderNumber()));
			redisService.hset(key, "md5", String.valueOf(orderInfo.getMd5()));
		}
		return result;
	}

	@Override
	public List<OrderInfo> findByMd5(int orderId,int userId, String md5) {
		return orderMapper.findByMd5(orderId,userId, md5);
	}

	@Override
	public int countCouponOrder(int orderId, Integer couponId) {
		return orderMapper.countCouponOrder(orderId,couponId);
	}

	@Override
	public List<OrderInfo> findNeedPayOrders(int minute) {
		return orderMapper.findNeedPayOrders(minute);
	}

	@Override
	public List<VipOrderInfo> findVipOrderInfoByPage(PageEntity<VipOrderInfo> pageEntity) {
		return orderMapper.findVipOrderInfoByPage(pageEntity);
	}

	@Override
	public OrderInfo getLastVipOrder(Integer userId,int vipId) {
		return orderMapper.getLastVipOrder(userId,vipId);
	}

	@Override
	public OrderInfo getLastVipOrder(String jMobile, String jName,int vipId) {
		return orderMapper.getLastVipOrderByMobile(jMobile,jName,vipId);
	}

	@Override
	public List<OrderInfo> findReminderDeliverOrders() {
		return orderMapper.findReminderDeliverOrders();
	}

	@Override
	public double countTotalAmount(int bigOrderId) {
		return orderMapper.countTotalAmount(bigOrderId);
	}

	@Override
	public void updateUserId(int bigOrderId, int user,String openId) {
		orderMapper.updateUserId(bigOrderId,user,openId);
		List<OrderInfo> orderList = this.findByOrderId(bigOrderId);
		for(OrderInfo sub : orderList) {
			redisService.del(RedisKeyUtil.order_info_orderid_key(sub.getNumber()));
		}
	}
	
	public List<OrderInfo> afterHalfhourProxyUnpayList() {
		return orderMapper.afterHalfhourProxyUnpayList();
	}
	
	@Override
	public List<OrderInfo> afterOnehourProxyUnpayList() {
		return orderMapper.afterOnehourProxyUnpayList();
	}
	
	public int updateByProxUserId(OrderInfo orderInfo) {
		int result = orderMapper.updateByProxUserId(orderInfo);
		if(result > 0){
			ordersMapper.updateByProxUserId(orderInfo.getOrderId(), orderInfo.getProxySelfUserId());
		}
		String key = RedisKeyUtil.order_info_orderid_key(orderInfo.getNumber());
		if(result > 0 && redisService.exists(key)){
			redisService.hset(key, "proxySelfUserId", String.valueOf(orderInfo.getProxySelfUserId()));
		}
		return result;
	}

	@Override
	public List<OrderInfo> findCloseableOrdersForOfficial(int minute) {
		return orderMapper.findCloseableOrdersForOfficial(minute);
	}

	
	@Override
	public String findOrderMinDate() {
		return orderMapper.findOrderMinDate();
	}
	
	@Override
	public List<OrderInfo> findByCountDate(String countDate) {
		return orderMapper.findByCountDate(countDate);
	}

	@Override
	public int findUnpayCountForWeiXin(int userId) {
		return orderMapper.findUnpayCountForWeiXin(userId);
	}

	@Override
	public OrderInfo getUserLastOrder(int userId) {
		return orderMapper.getUserLastOrder(userId);
	}

	@Override
	public OrderCountDto findUnsignCountForWeiXin(int userId) {
		return orderMapper.findUnsignCountForWeiXin(userId);
	}

	@Override
	public void updateMailChannelById(OrderInfo orderInfo) {
		orderMapper.updateMailChannelById(orderInfo);
		OrderInfo order = this.findById(orderInfo.getId());
		redisService.del(RedisKeyUtil.order_info_orderid_key(order.getNumber()));
	}

	@Override
	public List<OrderInfo> findByOrderId(int bigOrderId) {
		return orderMapper.findByOrderId(bigOrderId);
	}

	@Override
	public void updateWeixinPayCodeById(Integer id, String weixinPayCode, String kfId) {
		orderMapper.updateWeixinPayCodeById(id, weixinPayCode,  kfId);
	}

	@Override
	public void updateConfirmReceiveById(Integer id) {
		orderMapper.updateConfirmReceiveById(id);
		OrderInfo order = this.findById(id);
		redisService.del(RedisKeyUtil.order_info_orderid_key(order.getNumber()));
	}

	@Override
	public void updateDrawedBillById(Integer id) {
		orderMapper.updateDrawedBillById(id);
	}

	@Override
	public List<OrderInfo> findByAutoConfirm(String date) {
		return orderMapper.findByAutoConfirm(date);
	}

	@Override
	public List<OrderInfo> findByBill(Integer userId,String date) {
		return orderMapper.findByBill(userId,date);
	}

	@Override
	public List<OrderInfo> findByIds(int[] ids) {
		return orderMapper.findByIds(ids);
	}
	
	@Override
	public List<OrderInfo> findAddressHistoryById(Integer userId) {
		return orderMapper.findOrderAddressById(userId);
	}
	
	@Override
	public List<OrderInfo> findCourseAddressById(Integer userId){
		return orderMapper.findCourseAddressById(userId);
	}
	
}
