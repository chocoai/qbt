package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.qbt.common.enums.ApplyTypeEnum;
import com.qbt.common.enums.BigOrderPayStatus;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.PayStatus;
import com.qbt.common.enums.PaymentStatus;
import com.qbt.common.enums.PaymethodEnum;
import com.qbt.common.enums.UnifiedOrderTradeType;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.RandomProvider;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.CouponCodeActivity;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.redis.RedisService;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.ActivityOffService;
import com.qbt.service.ActivityService;
import com.qbt.service.CommonService;
import com.qbt.service.CouponCodeActivityService;
import com.qbt.service.CouponService;
import com.qbt.service.OrderActivityBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderPayInfoService;
import com.qbt.service.OrdersService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.pojo.pay.PayRequest;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.PaymentSupport;
import com.qbt.wechat.api.WechatApi;
import com.qbt.wechat.entity.ScanQrcodeRequest;
import com.qbt.wechat.entity.ScanQrcodeResponse;
import com.qbt.wechat.entity.UnifiedOrderRequest;
import com.qbt.wechat.entity.UnifiedOrderResponse;

/**
 *  微信支付
  * @ClassName: PaymentSupportImpl
  * @Description: TODO
  * @author share 2016年8月14日
  * @modify share 2016年8月14日
 */
@Service
public class PaymentSupportImpl implements PaymentSupport {
	
	@Value("${sc.env}")
	private boolean isScEnv = true;
	@Value("${notify_url}")
	private String notifyUrl;
	@Value("${notify_url_v2}")
	private String notifyUrlV2;
	
	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private OrdersService ordersService;
	@Resource
	private CommonService commonService;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private CouponService couponService;
	@Resource
	private RedisService redisService;
	@Resource
	private OrderPayInfoService orderPayInfoService;
	@Resource
	private ActivityOffService activityOffService;
	@Resource
	private ActivitySupport activitySupport;
	@Resource
	private OrderActivityBookService orderActivityBookService;
	@Resource
	private UserAsApService userAsApService;
	@Resource
	private  VipUserService vipUserService;
	@Resource
	private ActivityService activityService;
	@Resource
	private FileuploadScpService fileuploadScpService;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private CouponCodeActivityService couponCodeActivityService;
	
	@Override
	public Map<String,String> pay(PayRequest request) {
		double discount = 0;
		double realAmount = 0;
		int bigOrderId = 0;
		String[] orderIds = request.getOrderId();
		int[] activityIds = request.getActivityId();
		List<Map<String,String>> orderInfoList = new ArrayList<Map<String,String>>();
		double couponTotalAmount = 0;
		List<OrderActivity> orderActivityList = new ArrayList<OrderActivity>();
		
		for(int i = 0; i < orderIds.length ; i++){
			String orderId = orderIds[i];
			OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
			/**
			 * 订单信息校验
			 */
			if(orderInfo == null){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的支付订单");
			}
			if(orderInfo.getOrderStatus().intValue() != OrderStatus.un_pay.getCode().intValue()){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单状态非未支付状态，不能进行支付");
			}
			// 若果是VIP订单不检查活动优惠
			List<String> vipOrderIds = request.getVipOrderIds();
			if(vipOrderIds.contains(orderId)){
				int index = vipOrderIds.indexOf(orderId);
				VipInfo type = vipUserService.findById(request.getVipIds().get(index));
				double vipOrderAmount = type.getOrderAmount().doubleValue();
				double vipTotalPrice = Arith.add(vipOrderAmount, orderInfo.getInsuredFee());
				double outRangePrice = Arith.add(orderInfo.getjOutRangePrice(),orderInfo.getdOutRangePrice());
				vipTotalPrice = Arith.add(vipTotalPrice, outRangePrice);
				realAmount = Arith.add(realAmount, vipTotalPrice);
			}else{
				/**
				 * 检查活动优惠券
				 */
				int activityId = activityIds[i];
				if(activityId > 0){
					OrderActivity orderActivity = activitySupport.checkOrder(orderId);
					if(orderActivity.getActivityId() != activityId){
						throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "优惠活动不存在或不匹配");
					}
					if(orderActivity.getjActivity()){
						discount = Arith.add(discount, orderActivity.getjAmount());
					}else if(orderActivity.getdActivity()){
						discount = Arith.add(discount, orderActivity.getdAmount());
					}
					orderActivityList.add(orderActivity);
				}else{
					couponTotalAmount = Arith.add(couponTotalAmount, orderInfo.getFreight());
				}
				double orderRealAmount = Arith.add(orderInfo.getFreight(), orderInfo.getInsuredFee());
				realAmount = Arith.add(realAmount, orderRealAmount);
			}
			
			bigOrderId = orderInfo.getOrderId();
			Map<String,String> orderInfoMap = new HashMap<String, String>();
			orderInfoMap.put("id", String.valueOf(orderInfo.getId()));
			orderInfoMap.put("remark", orderInfo.getRemark());
			orderInfoMap.put("number", orderInfo.getNumber());
			orderInfoList.add(orderInfoMap);
		}
		
		/**
		 * 券信息校验
		 */
		String childCode = request.getChidCode();
		
		int payExpireTime = 15 * 60;
		int type = request.getType();
		// 使用优惠券
		Coupon counpon = null;
		if(type == 1 || type == 2){
			if(StringUtil.isEmpty(childCode)){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效券码或已使用");
			}
			counpon = couponService.selectCouponByChildCode(childCode);
			double couponDiscount = validCoupon(request, counpon, couponTotalAmount, payExpireTime);
			discount = Arith.add(discount, couponDiscount);
		}
		
		/**
		 * 金额校验
		 */
		realAmount = Arith.sub(realAmount,discount);
		if(realAmount < 0)realAmount = 0;
		if( realAmount != request.getPayAmount().doubleValue()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "支付金额不正确");
		}

		// 登记订单备注信息
		for(Map<String,String> orderInfoMap : orderInfoList){
			if(!StringUtil.isEmpty(request.getRemark()) && !request.getRemark().equals(orderInfoMap.get("remark"))){
				orderInfoService.updateRemarkById(Integer.parseInt(orderInfoMap.get("id")),orderInfoMap.get("number"),request.getRemark());
			}
		}
		
		
		/**
		 * 检查是否重复支付，防止多次微信预下单预支付成功
		 */
		OrderPayInfo payInfo = orderPayInfoService.findByOrderId(bigOrderId, request.getPayAmount(), PaymethodEnum.weixin_pay.getCode());
		long now = System.currentTimeMillis();
		if(payInfo !=null && payInfo.getStartTime() <= now && now <= payInfo.getExpireTime()){
			LogCvt.info("微信支付使用原预支付包信息："+request.getOrderId());
			Map<String,String> paypackage = JSonUtil.toObject(payInfo.getPaypackage(), Map.class);
			return paypackage;
		}
		
		
		Date startTime = new Date();
		Date expireTime = new Date(startTime.getTime() + (payExpireTime * 1000));
		String payno = commonService.createPaymentId();
		UnifiedOrderRequest wechatRequest = new UnifiedOrderRequest();
		wechatRequest.setBody("球包通下单支付");
		wechatRequest.setOutTradeNo(payno);
		if(isScEnv){
			wechatRequest.setTotalFee(String.valueOf(request.getPayAmount()));
		}else{
			wechatRequest.setTotalFee("0.01");
		}
		wechatRequest.setTimeStart(DateUtil.formatDate(startTime, "yyyyMMddHHmmss") );
		wechatRequest.setTimeExpire(DateUtil.formatDate(expireTime, "yyyyMMddHHmmss"));
		wechatRequest.setOpenid(request.getOpenId());
		wechatRequest.setSpbillCreateIp("127.0.0.1");
		 //回调地址赋值
	    wechatRequest.setNotifyUrl(notifyUrl);
		// 微信预支付订单
		UnifiedOrderResponse response = wechatApi.unifiedOrder(wechatRequest, UnifiedOrderTradeType.JSAPI);
		
		if("FAIL".equals(response.getReturn_code())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, response.getReturn_msg());
		}
		/**
		 * 登记支付流水
		 */
		
		OrderPayInfo payment = new OrderPayInfo();
		payment.setNonceStr(wechatRequest.getNonceStr());
		payment.setOrderId(bigOrderId);
		payment.setUuid(payno);
		payment.setPayMethod(PaymethodEnum.weixin_pay.getCode());
		payment.setPaySign(wechatRequest.getSign());
		payment.setStatus(PaymentStatus.ready.getCode());
		payment.setPrepayId(response.getPrepay_id());
		payment.setPayStatus(PayStatus.init.getCode());
		payment.setPayAmount(request.getPayAmount());
		payment.setUserId(request.getUserId());
		payment.setCouponCode(childCode);
		payment.setCouponId(counpon!=null?counpon.getId():0);
		payment.setActivityId(0);
		// 满减
		payment.setActivityType(1);
		payment.setStartTime(startTime.getTime());
		payment.setExpireTime(expireTime.getTime());
		payment.setPaypackage(JSonUtil.toJSonString(response.getPaypackage()));
		orderPayInfoService.insert(payment);
		activitySupport.cachePayOrderActivity(bigOrderId,orderActivityList);
		// 	vip订单
		if(Checker.isNotEmpty(request.getVipOrderIds())){
			String redisKey = RedisKeyUtil.pay_vip_order_suborder_key(bigOrderId);
			commonService.unlock(redisKey);
			String values = JSonUtil.toJSonString(request.getVipOrderIds()) + "_" + JSONUtils.toJSONString(request.getVipIds());
			commonService.lock(redisKey, values, 30 * 60 *1000);
		}
		return response.getPaypackage();
	}

	/**
	 *  支付券码校验
	  * @Title: validCoupon
	  * @Description: TODO
	  * @author: share 2016年8月15日
	  * @modify: share 2016年8月15日
	  * @param request
	  * @param payExpireTime
	  * @return
	 */
	private double validCoupon(PayRequest request, Coupon coupon, double couponTotalAmount, int payExpireTime) {
		int type = request.getType();
		String childCode = request.getChidCode();
		double discount = 0d;
		// 检查券号是否锁定
		String lockKey = RedisKeyUtil.Coupon_Pay_Lock_Redis_Key(childCode);
		long flag  = redisService.setnx(lockKey, String.valueOf(request.getUserId()));
		if(flag == 1){
			redisService.setex(lockKey, payExpireTime, String.valueOf(request.getUserId()));
		}else{
			// 检查是否本人锁定定的券码
			int userId = Integer.parseInt(redisService.get(lockKey));
			if(userId != request.getUserId()){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券码已被他人锁定，在支付使用中");
			}
			// 重新刷新过期时间
			redisService.setex(lockKey, payExpireTime, String.valueOf(request.getUserId()));
		}
		// 券有效期校验
		if(coupon == null || coupon.getStatus() != 1){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效券码或已使用");
		}
		// 用户输入点子券信息，检查电子券是否被别人绑定
		if(type == 1){
			if(coupon.getUserId() != 0 && request.getUserId() != coupon.getUserId()){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无法使用该券");
			}
		}else if(request.getUserId() != coupon.getUserId()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无法使用他人领用券");
		}
		if(coupon.getLockStatus() != 0) {
			//throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "优惠券已被锁定，请在支付后再次使用");
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "在途订单签收后可使用");
		}
		// 检查券使用限额
		if(couponTotalAmount < coupon.getLimitAmount()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "未达到使用券限额");
		}
		int status = coupon.getStatus() == 1 && DateUtil.getDiffDaysForDay(new Date(), coupon.getEndTime()) < 0 ? 3 : coupon.getStatus();
		if(status == 3){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券已失效");
		}
		if(DateUtil.getDiffDaysForDay(new Date(), coupon.getStartTime()) > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券无法提前使用");
		}
		discount = coupon.getChildAmount();
		if(couponTotalAmount > discount){
			return discount;
		}
		return couponTotalAmount;
	}
	
	
	@Override
	public OrderPayInfo noPay(PayRequest request) {
		double discount = 0;
		double realAmount = 0;
		int bigOrderId = 0;
		String[] orderIds = request.getOrderId();
		int[] activityIds = request.getActivityId();
		List<Map<String,String>> orderInfoList = new ArrayList<Map<String,String>>();
		double couponTotalAmount = 0;
		List<OrderActivity> orderActivityList = new ArrayList<OrderActivity>();
		for(int i = 0; i < orderIds.length ; i++){
			String orderId = orderIds[i];
			OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
			/**
			 * 订单信息校验
			 */
			if(orderInfo == null){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效的支付订单");
			}
			if(orderInfo.getOrderStatus().intValue() != OrderStatus.un_pay.getCode().intValue()){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单状态非未支付状态，不能进行支付");
			}
			// 若果是VIP订单不检查活动优惠
			List<String> vipOrderIds = request.getVipOrderIds();
			if(vipOrderIds.contains(orderId)){
				int index = vipOrderIds.indexOf(orderId);
				VipInfo type = vipUserService.findById(request.getVipIds().get(index));
				double vipOrderAmount = type.getOrderAmount().doubleValue();
				double vipTotalPrice = Arith.add(vipOrderAmount, orderInfo.getInsuredFee());
				double outRangePrice = Arith.add(orderInfo.getjOutRangePrice(),orderInfo.getdOutRangePrice());
				vipTotalPrice = Arith.add(vipTotalPrice, outRangePrice);
				realAmount = Arith.add(realAmount, vipTotalPrice);
			}else{
				/**
				 * 检查活动优惠券
				 */
				int activityId = activityIds[i];
				if(activityId > 0){
					OrderActivity orderActivity = activitySupport.checkOrder(orderId);
					if(orderActivity.getActivityId() != activityId){
						throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "优惠活动不存在或不匹配");
					}
					double orderDiscount = 0;
					if(orderActivity.getjActivity()){
						orderDiscount = orderActivity.getjAmount();
						discount = Arith.add(discount, orderDiscount);
					}else if(orderActivity.getdActivity()){
						orderDiscount = orderActivity.getdAmount();
						discount = Arith.add(discount, orderDiscount);
					}
					orderActivityList.add(orderActivity);
				}else{
					couponTotalAmount = Arith.add(couponTotalAmount, orderInfo.getFreight());
				}
				double orderRealAmount = Arith.add(orderInfo.getFreight(), orderInfo.getInsuredFee());
				realAmount = Arith.add(realAmount, orderRealAmount);
			}
			
			bigOrderId = orderInfo.getOrderId();
			Map<String,String> orderInfoMap = new HashMap<String, String>();
			orderInfoMap.put("id", String.valueOf(orderInfo.getId()));
			orderInfoMap.put("remark", orderInfo.getRemark());
			orderInfoMap.put("number", orderInfo.getNumber());
			orderInfoMap.put("lang", orderInfo.getLangEname());
			orderInfoList.add(orderInfoMap);
		}
		
		/**
		 * 券信息校验
		 */
		String childCode = request.getChidCode();
		
		int payExpireTime = 15 * 60;
		int type = request.getType();
		// 使用优惠券
		Coupon counpon = null;
		if(type == 1 || type == 2){
			if(StringUtil.isEmpty(childCode)){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效券码或已使用");
			}
			counpon = couponService.selectCouponByChildCode(childCode);
			double couponDiscount = validCoupon(request, counpon, couponTotalAmount,payExpireTime);
			discount = Arith.add(discount, couponDiscount);
		}
		
		/**
		 * 金额校验
		 */
		realAmount = Arith.sub(realAmount,discount);
		if(realAmount < 0)realAmount = 0;
		if( realAmount != request.getPayAmount().doubleValue()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "支付金额不正确");
		}
		
		Orders orders = ordersService.findById(bigOrderId);
		int thridId = orders.getThirdId()==null?0:orders.getThirdId();
		if(thridId > 0){
			UserAssistantApply apply = userAsApService.findPartnerByUserId(orders.getUserId(), ApplyTypeEnum.partner.getCode());
			if(apply.getApplyId().intValue() != thridId){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息无权免支付下单");
			}
		}
		
		String payno = commonService.createPaymentId();
		
		for(Map<String,String> orderInfoMap : orderInfoList){
			// 登记订单备注信息
			if(!StringUtil.isEmpty(request.getRemark()) && !request.getRemark().equals(orderInfoMap.get("remark"))){
				orderInfoService.updateRemarkById(Integer.parseInt(orderInfoMap.get("id")),orderInfoMap.get("number"),request.getRemark());
			}
			
			if(!StringUtil.isEmpty(request.getLangName()) && !request.getLangName().equals(orderInfoMap.get("lang"))){
				orderInfoService.updateLangEnameById(Integer.parseInt(orderInfoMap.get("id")),orderInfoMap.get("number"),request.getLangName());
			}
		}
		
		/**
		 * 登记支付流水
		 */
		OrderPayInfo payment = new OrderPayInfo();
		payment.setNonceStr("");
		payment.setOrderId(bigOrderId);
		payment.setUuid(payno);
		if(thridId > 0){
			payment.setPayMethod(PaymethodEnum.partner_pay.getCode());
		}else{
			payment.setPayMethod(PaymethodEnum.un_pay.getCode());
		}
		payment.setPaySign("");
		payment.setStatus(PaymentStatus.ready.getCode());
		payment.setPrepayId("");
		payment.setPayStatus(PayStatus.init.getCode());
		payment.setPayAmount(request.getPayAmount());
		payment.setUserId(request.getUserId());
		payment.setCouponCode(childCode);
		payment.setCouponId(counpon!=null?counpon.getId():0);
		payment.setActivityId(0);
		// 满减
		payment.setActivityType(1);
		orderPayInfoService.insert(payment);
		activitySupport.cachePayOrderActivity(bigOrderId,orderActivityList);
		// vip订单
		if(Checker.isNotEmpty(request.getVipOrderIds())){
			String redisKey = RedisKeyUtil.pay_vip_order_suborder_key(bigOrderId);
			commonService.unlock(redisKey);
			String values = JSonUtil.toJSonString(request.getVipOrderIds()) + "_" + JSONUtils.toJSONString(request.getVipIds());
			commonService.lock(redisKey, values, 30 * 60 *1000);
		}
		return payment;
	}

	@Override
	public OrderPayInfo findById(int id) {
		return orderPayInfoService.findById(id);
	}

	@Override
	public OrderPayInfo findByPayno(String payno) {
		return orderPayInfoService.findByPayno(payno);
	}

	@Override
	public int updateById(OrderPayInfo payInfo) {
		return orderPayInfoService.updateById(payInfo);
	}

	@Override
	public String officialPay(String orderNumber) {
		Orders bigOrder = ordersService.findByNumber(orderNumber);
		if(Checker.isEmpty(bigOrder)){
			throw new WechatException("无效订单信息");
		}
		if(bigOrder.getPayStatus() != 1){
			throw new WechatException("订单已支付");
		}
		//生成二维码
		String qrcodeUrl = "";
		try {
			qrcodeUrl = fileuploadScpService.createQrcodeToScp(wechatApi.getBizPayUrl(orderNumber));
		} catch (Exception e) {
			throw new WechatException("二维码生成失败");
		}
		return qrcodeUrl;
	}
	
	/**
	 *  扫描支付统一下单
	  * @Title: pay
	  * @Description: TODO
	  * @author: share 2017年2月21日
	  * @modify: share 2017年2月21日
	  * @param request
	  * @return
	  * @see com.qbt.web.support.PaymentSupport#scanPay
	 */
	@Override
	public ScanQrcodeResponse scanPay(ScanQrcodeRequest request) {
		ScanQrcodeResponse qrcodeResponse = new ScanQrcodeResponse();
		// 大订单号
		String  orderNumber = request.getProduct_id();
		Orders order = ordersService.findByNumber(orderNumber);
		if(order == null){
			throw new WechatException("订单商品信息不存在");
		}
		
		if(order.getPayStatus().intValue() == BigOrderPayStatus.paid.getCode().intValue()){
			throw new WechatException("订单已支付");
		}
		
		double orderAmount = orderInfoService.countTotalAmount(order.getId());
		if(orderAmount <= 0){
			throw new WechatException("订单已过期，无效支付金额");
		}
		
		// 检查用户信息是否存在
		UserWeixin user = userWeixinService.findByOpenId(request.getOpenid());
		if(user == null){
			user = new UserWeixin();
			user.setAcceptPromotion(true);
			user.setAcceptPush(true);
			user.setCity("");
			user.setCounty("");
			user.setCoordsrc("");
			user.setCreateTime(new Date());
			user.setEmail("");
			user.setFirstLetter("");
			user.setHeadImgUrl("");
			user.setIsValidated(true);
			user.setMobile("");
			user.setNickname("");
			user.setOpenid(request.getOpenid());
			user.setProvince("");
			user.setSalt(RandomProvider.randomAlphanumericToLowerCase(8));
			user.setSex(0);
			user.setSubscribeStatus(2);
			user.setSalesmanId(0);
			user.setSalesmanCode("");
			userWeixinService.insert(user);
		}
		
		// 更新订单为此用户
		ordersService.updateUserId(order.getId(), user.getId(), user.getOpenid());
		orderInfoService.updateUserId(order.getId(), user.getId(), user.getOpenid());
		
		Date startTime = new Date();
		Date expireTime = new Date(startTime.getTime() + (15 * 60 * 1000));
		String payno = commonService.createPaymentId();
		UnifiedOrderRequest wechatRequest = new UnifiedOrderRequest();
		wechatRequest.setBody("球包通下单支付-官网");
		wechatRequest.setOutTradeNo(payno);
		if(isScEnv){
			wechatRequest.setTotalFee(String.valueOf(orderAmount));
		}else{
			wechatRequest.setTotalFee("0.01");
		}
		wechatRequest.setTimeStart(DateUtil.formatDate(startTime, "yyyyMMddHHmmss") );
		wechatRequest.setTimeExpire(DateUtil.formatDate(expireTime, "yyyyMMddHHmmss"));
		wechatRequest.setOpenid(request.getOpenid());
		wechatRequest.setSpbillCreateIp("127.0.0.1");
		 //回调地址赋值
	    wechatRequest.setNotifyUrl(notifyUrl);
		// 微信预支付订单
		UnifiedOrderResponse orderResponse = wechatApi.unifiedOrder(wechatRequest, UnifiedOrderTradeType.NATIVE);
		
		if("FAIL".equals(qrcodeResponse.getReturn_code())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, qrcodeResponse.getReturn_msg());
		}
		/**
		 * 登记支付流水
		 */
		
		OrderPayInfo payment = new OrderPayInfo();
		payment.setNonceStr(wechatRequest.getNonceStr());
		payment.setOrderId(order.getId());
		payment.setUuid(payno);
		payment.setPayMethod(PaymethodEnum.weixin_pay.getCode());
		payment.setPaySign(wechatRequest.getSign());
		payment.setStatus(PaymentStatus.ready.getCode());
		payment.setPrepayId(orderResponse.getPrepay_id());
		payment.setPayStatus(PayStatus.init.getCode());
		payment.setPayAmount(orderAmount);
		payment.setUserId(user.getId());
		payment.setCouponCode("");
		payment.setCouponId(0);
		payment.setActivityId(0);
		payment.setActivityType(0);
		payment.setStartTime(startTime.getTime());
		payment.setExpireTime(expireTime.getTime());
		payment.setPaypackage(JSonUtil.toJSonString(orderResponse.getPaypackage()));
		orderPayInfoService.insert(payment);
		
		qrcodeResponse.setAppid(request.getAppid());
		qrcodeResponse.setMch_id(request.getMch_id());
		qrcodeResponse.setNonce_str(request.getNonce_str());
		qrcodeResponse.setPrepay_id(orderResponse.getPrepay_id());
		// 签名
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("return_code", qrcodeResponse.getReturn_code());
		map.put("return_msg", qrcodeResponse.getReturn_msg());
		map.put("result_code", qrcodeResponse.getResult_code());
		map.put("err_code_des", qrcodeResponse.getErr_code_des());
		map.put("appid", qrcodeResponse.getAppid());
		map.put("mch_id", qrcodeResponse.getMch_id());
		map.put("nonce_str", qrcodeResponse.getNonce_str());
		map.put("prepay_id", qrcodeResponse.getPrepay_id());
		qrcodeResponse.setSign(wechatApi.sign(map));
		
		return qrcodeResponse;
	}

	/**
	 *  微信改版支付
	  * @Title: pay
	  * @Description: TODO
	  * @author: share 2017年4月11日
	  * @modify: share 2017年4月11日
	  * @param orderId
	  * @param openid
	  * @return
	  * @see com.qbt.web.support.PaymentSupport#pay(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> pay(String orderId, String openid) {
		Orders orders = ordersService.findByNumber(orderId);
		int bigOrderId = orders.getId();
		double amount = orderInfoService.countTotalAmount(bigOrderId);
		UserWeixin userInfo = userWeixinService.findByOpenId(openid);
		List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(orderId);
		Coupon coupon = null;
		CouponCodeActivity codeActivity = null;
		OrderInfo orderInfo = subOrderList.get(0);
		int couponType = 0;
		if(orderInfo.getCouponCode() != null && orderInfo.getCouponCode().length() == 8){
			couponType = 1;
			coupon = couponService.findById(orderInfo.getCouponId());
		}else if(orderInfo.getCouponCode() != null && orderInfo.getCouponCode().length() == 6){
			couponType = 2;
			codeActivity = couponCodeActivityService.findById(orderInfo.getCouponId());
		}
		/**
		 * 检查是否重复支付，防止多次微信预下单预支付成功
		 */
		OrderPayInfo payInfo = orderPayInfoService.findByOrderId(bigOrderId, amount, PaymethodEnum.weixin_pay.getCode());
		long now = System.currentTimeMillis();
		if(payInfo !=null && payInfo.getStartTime() <= now && now <= payInfo.getExpireTime()){
			LogCvt.info("微信支付使用原预支付包信息："+orderId);
			Map<String,String> paypackage = JSonUtil.toObject(payInfo.getPaypackage(), Map.class);
			return paypackage;
		}
		
		int payExpireTime = 15 * 60;
		Date startTime = new Date();
		Date expireTime = new Date(startTime.getTime() + (payExpireTime * 1000));
		String payno = commonService.createPaymentId();
		UnifiedOrderRequest wechatRequest = new UnifiedOrderRequest();
		wechatRequest.setBody("球包通下单支付");
		wechatRequest.setOutTradeNo(payno);
		if(isScEnv){
			wechatRequest.setTotalFee(String.valueOf(amount));
		}else{
			wechatRequest.setTotalFee("0.01");
		}
		wechatRequest.setTimeStart(DateUtil.formatDate(startTime, "yyyyMMddHHmmss") );
		wechatRequest.setTimeExpire(DateUtil.formatDate(expireTime, "yyyyMMddHHmmss"));
		wechatRequest.setOpenid(openid);
		wechatRequest.setSpbillCreateIp("127.0.0.1");
		 //回调地址赋值
	    wechatRequest.setNotifyUrl(notifyUrlV2);
		// 微信预支付订单
		UnifiedOrderResponse response = wechatApi.unifiedOrder(wechatRequest, UnifiedOrderTradeType.JSAPI);
		
		if("FAIL".equals(response.getReturn_code())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, response.getReturn_msg());
		}
		/**
		 * 登记支付流水
		 */
		OrderPayInfo payment = new OrderPayInfo();
		payment.setNonceStr(wechatRequest.getNonceStr());
		payment.setOrderId(bigOrderId);
		payment.setUuid(payno);
		payment.setPayMethod(PaymethodEnum.weixin_pay.getCode());
		payment.setPaySign(wechatRequest.getSign());
		payment.setStatus(PaymentStatus.ready.getCode());
		payment.setPrepayId(response.getPrepay_id());
		payment.setPayStatus(PayStatus.init.getCode());
		payment.setPayAmount(amount);
		payment.setUserId(userInfo.getId());
		if(couponType == 1){
			payment.setCouponCode(Checker.isNotEmpty(coupon) ? coupon.getChildCode() : "0");
			payment.setCouponId(Checker.isNotEmpty(coupon) ? coupon.getId() : 0);
		}else if(couponType == 2){
			payment.setCouponCode(Checker.isNotEmpty(codeActivity) ? codeActivity.getCode() : "0");
			payment.setCouponId(Checker.isNotEmpty(codeActivity) ? codeActivity.getId() : 0);
		}else{
			payment.setCouponCode("0");
			payment.setCouponId(0);
		}
		payment.setActivityId(0);
		// 满减
		payment.setActivityType(1);
		payment.setStartTime(startTime.getTime());
		payment.setExpireTime(expireTime.getTime());
		payment.setPaypackage(JSonUtil.toJSonString(response.getPaypackage()));
		orderPayInfoService.insert(payment);
		return response.getPaypackage();
	}
	
	/**
	 *  改版0元支付 v2.0
	  * @Title: noPay
	  * @Description: TODO
	  * @author: share 2017年4月11日
	  * @modify: share 2017年4月11日
	  * @param orderId
	  * @param openid
	  * @return
	  * @see com.qbt.web.support.PaymentSupport#noPay(java.lang.String, java.lang.String)
	 */
	@Override
	public OrderPayInfo noPay(String orderId, String openid) {
		Orders orders = ordersService.findByNumber(orderId);
		int bigOrderId = orders.getId();
		double amount = orderInfoService.countTotalAmount(bigOrderId);
		UserWeixin userInfo = userWeixinService.findByOpenId(openid);
		List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(orderId);
		Coupon coupon = null;
		CouponCodeActivity codeActivity = null;
		OrderInfo orderInfo = subOrderList.get(0);
		int couponType = 0;
		if(orderInfo.getCouponCode() != null && orderInfo.getCouponCode().length() == 8){
			couponType = 1;
			coupon = couponService.findById(orderInfo.getCouponId());
		}else if(orderInfo.getCouponCode() != null && orderInfo.getCouponCode().length() == 6){
			couponType = 2;
			codeActivity = couponCodeActivityService.findById(orderInfo.getCouponId());
		}
		/**
		 * 金额校验
		 */
		if(amount > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "支付金额不正确");
		}
		
		String payno = commonService.createPaymentId();
		/**
		 * 登记支付流水
		 */
		OrderPayInfo payment = new OrderPayInfo();
		payment.setNonceStr("");
		payment.setOrderId(bigOrderId);
		payment.setUuid(payno);
		payment.setPayMethod(PaymethodEnum.un_pay.getCode());
		payment.setPaySign("");
		payment.setStatus(PaymentStatus.ready.getCode());
		payment.setPrepayId("");
		payment.setPayStatus(PayStatus.init.getCode());
		payment.setPayAmount(amount);
		payment.setUserId(userInfo.getId());
		if(couponType == 1){
			payment.setCouponCode(Checker.isNotEmpty(coupon) ? coupon.getChildCode() : "0");
			payment.setCouponId(Checker.isNotEmpty(coupon) ? coupon.getId() : 0);
		}else if(couponType == 2){
			payment.setCouponCode(Checker.isNotEmpty(codeActivity) ? codeActivity.getCode() : "0");
			payment.setCouponId(Checker.isNotEmpty(codeActivity) ? codeActivity.getId() : 0);
		}else{
			payment.setCouponCode("0");
			payment.setCouponId(0);
		}
		payment.setActivityId(0);
		// 满减
		payment.setActivityType(1);
		orderPayInfoService.insert(payment);
		return payment;
	}
	
}
