package com.qbt.web.support.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.common.enums.AddrTypeEnum;
import com.qbt.common.enums.BagCodeOrderResult;
import com.qbt.common.enums.BigOrderPayStatus;
import com.qbt.common.enums.BigOrderStatus;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.enums.MqTypeEnum;
import com.qbt.common.enums.OrderOperateTypeEnum;
import com.qbt.common.enums.OrderSource;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.QuestionStatus;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.enums.SfBpsStatus;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Md5;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.persistent.dto.OrderCountDto;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.BagCodeOrder;
import com.qbt.persistent.entity.BagCodePartner;
import com.qbt.persistent.entity.BagCodeUser;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.CouponCodeActivity;
import com.qbt.persistent.entity.OrderActivityBook;
import com.qbt.persistent.entity.OrderCoupon;
import com.qbt.persistent.entity.OrderDelayTask;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.entity.OrgGroup;
import com.qbt.persistent.entity.OrgGroupAmountConfig;
import com.qbt.persistent.entity.OrgGroupUser;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.entity.RewardActitvity;
import com.qbt.persistent.entity.SaleOrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserAddress;
import com.qbt.persistent.entity.UserContact;
import com.qbt.persistent.entity.UserOrderContact;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.persistent.entity.WinnerList;
import com.qbt.redis.RedisService;
import com.qbt.service.ActivityService;
import com.qbt.service.BagCodeOrderService;
import com.qbt.service.BagCodePartnerService;
import com.qbt.service.BagCodeUserService;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfPriceService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.service.CommonService;
import com.qbt.service.CouponCodeActivityService;
import com.qbt.service.CouponService;
import com.qbt.service.OrderActivityBookService;
import com.qbt.service.OrderCouponService;
import com.qbt.service.OrderDelayTaskService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrdersService;
import com.qbt.service.OrgGroupAmountConfigService;
import com.qbt.service.OrgGroupService;
import com.qbt.service.OrgGroupUserService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.service.RewardActitvityService;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.UserAddressService;
import com.qbt.service.UserContactService;
import com.qbt.service.UserOrderContactService;
import com.qbt.service.UserProxyService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.VipUserService;
import com.qbt.service.WinnerListService;
import com.qbt.util.SignCalculator;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderCountVo;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.pojo.vip.VipInfoVo;
import com.qbt.web.pojo.vip.VipOrderConfirmVo;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.AreaSupport;
import com.qbt.web.support.CommonSupport;
import com.qbt.web.support.InsureTemplateSupport;
import com.qbt.web.support.OrderV2Support;
import com.qbt.web.support.SfExpressSupport;
import com.qbt.web.support.UrgentSupport;
import com.qbt.web.support.VipInfoSupport;

/**
 *  订单管理
  * @ClassName: OrderSupportImpl
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
@Service
public class OrderV2SupportImpl implements OrderV2Support {

	@Resource
	private BaseSfPriceService baseSfPriceService;
	@Resource
	private CommonService commonService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private BaseSfSiteService baseSfSiteService;
	@Resource
	private BaseAirportService baseAirportService;
	@Resource
	private BaseBankBranchService baseBankBranchService;
	@Resource
	private InsureTemplateSupport insureTemplateSupport;
	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private OrdersService ordersService;
	@Resource
	private OrderOperateLogService orderOperateLogService;
	@Resource
	private CommonSupport commonSupport;
	@Resource
	private CouponService couponService;
	@Resource
	private UserContactService userContactService;
	@Resource
	private  VipUserService vipUserService;
	@Resource
	private SfExpressSupport sfExpressSupport;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private OrderDelayTaskService orderDelayTaskService;
	@Resource
	private RedisService redisServer;
	@Resource
	private VipInfoSupport vipInfoSupport;
	@Resource
	private ActivitySupport activitySupport;
	@Resource
	private ActivityService activityService;
	@Resource
	private OrderActivityBookService orderActivityBookService;
	@Resource
	private OrderCouponService orderCouponService;
	@Resource
	private CouponCodeActivityService couponCodeActivityService;
	@Resource
	private UserOrderContactService userOrderContactService;
	@Resource
	private RewardActitvityService rewardService;
	@Resource
	private UserAddressService userAddressService;
	@Resource
	private WinnerListService winnerListService;
	@Resource
	private OutRangeAddressService outRangeAddressService;
	@Resource
	private OrgGroupUserService orgGroupUserService; 
	@Resource
	private OrgGroupService orgGroupService;
	@Resource
	private OrgGroupAmountConfigService orgGroupAmountConfigService;
	@Resource
	private SaleUserService saleUserService;
	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	@Resource
	private UserProxyService userProxyService;
	@Resource
	private BagCodeOrderService bagCodeOrderService;
	@Resource
	private BagCodePartnerService bagCodePartnerService;
	@Resource
	private BagCodeUserService bagCodeUserService;
	@Resource
	private UrgentSupport urgentSupport;
	@Resource
	private AreaSupport areaSupport;
	
	/**
	 *  订单下单
	  * @Title: orderCreate
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param orderConfirm
	  * @return
	  * @see com.qbt.web.support.OrderSupport#orderCreate(com.qbt.web.pojo.order.OrderConfirm)
	 */
	@Override
	public String orderCreate(OrderConfirm orderConfirm) {
		LogCvt.info("新版V2改版下单....");
		/**
		 * 业务订单校验
		 */
		//包包码
		//记得返回一个字段给前端是否可以使用包包码，使用了包包码就不能使用会员卡vip和群机构
		int bagCodeOrderId = checkBagCode(orderConfirm);
		
		// 预约取包时间校验
		String timeSection = orderConfirm.getConsigned_time();
		Date consignedTime = DateUtil.str2Date(timeSection.substring(0,16)+":00", DateUtil.DATE_TIME_FORMAT_01);
		if(consignedTime.getTime() < System.currentTimeMillis()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包时间已失效");
		}
		if(orderConfirm.getSrc_area_id() == orderConfirm.getDest_area_id() && orderConfirm.getSrc_address().equals(orderConfirm.getDest_address())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包和送包地址不能相同");
		}
		//时效校验
		String deliverDate = orderConfirm.getDeliver_time();
		if(consignedTime.getTime() > DateUtil.str2Date(deliverDate, DateUtil.DATE_TIME_FORMAT_01).getTime()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "取件时间不能大于到达时间");
		}
		/**
		 *  订单价格校验
		 */
		// 偏远寄件球场信息
		BaseCourse jCourse = null;
		BaseCourse dCourse = null;
		double outRangePrice = 0;
		if(orderConfirm.getSrc_type() == 1){
			orderConfirm.setSrc_course_id(orderConfirm.getSrc_id());
			jCourse = baseCourseService.findById(orderConfirm.getSrc_id());
			outRangePrice = Checker.isNotEmpty(jCourse) && jCourse.getIsOutRange() ? outRangePrice + jCourse.getOutRangePrice() : outRangePrice;
		}
		if(orderConfirm.getDest_type() == 1){
			orderConfirm.setDest_course_id(orderConfirm.getDest_id());
			dCourse = baseCourseService.findById(orderConfirm.getDest_id());
			outRangePrice = Checker.isNotEmpty(dCourse) && dCourse.getIsOutRange() ? outRangePrice + dCourse.getOutRangePrice() : outRangePrice;
		}
		// 顺丰速运价格计算
		double sfPrice = sfExpressSupport.query_sf_expect_price_v2(orderConfirm);
		
		// 加急费
		Integer urgentFee = 0;
		
		// 加急价格
		if("3".equals(orderConfirm.getBusiness_type())) {
			int src_area_id = orderConfirm.getSrc_area_id();
			int dest_area_id = orderConfirm.getDest_area_id();
			
			Area fromArea = areaSupport.findById(src_area_id);
			Area toArea = areaSupport.findById(dest_area_id);
			
			UrgentPageReqVo reqCityVo = new UrgentPageReqVo();
			reqCityVo.setFromCity(fromArea.getSuperId()+"");
			reqCityVo.setToCity(toArea.getSuperId()+"");		
			
			List<UrgentVo> urgentVos = urgentSupport.findByPage(reqCityVo);
			if(urgentVos != null && urgentVos.size()>0) {
				urgentFee = urgentVos.get(0).getPrice();
				sfPrice += urgentFee;
			}
		
			// 加急类型其实是一个快件
			orderConfirm.setBusiness_type("1");
		}
		
		
		// 保价金额
		Double insureRate = null;
		BaseInsuredTemplate template = insureTemplateSupport.findValid();
		double insurePrice = insureTemplateSupport.insureValidPrice(orderConfirm.getInsure_price(), 1);
		insureRate = template.getInsuredRates().doubleValue();
		double totalPrice = Arith.add(sfPrice, insurePrice);
		LogCvt.info("保价金额："+insurePrice+",单个包总金额:"+totalPrice);
		
		int quantity = orderConfirm.getQuantity();
		
		double orderTotalAmount = Arith.mul(quantity, sfPrice);
		double orderInsurePrice = Arith.mul(quantity, insurePrice);
		double orderRangePrice = Arith.mul(quantity, outRangePrice);
		double totalAmount = Arith.add(orderTotalAmount, orderInsurePrice);
		
		// 1-course球场，2-airport机场,3-bank银行,5-顺丰网店
		int srcType = orderConfirm.getSrc_type();
		int srcId = orderConfirm.getSrc_id();
		String jAddrName = "",dAddrName = "";
		jAddrName = getAddrName(srcType, srcId);
		int destType = orderConfirm.getDest_type();
		int destId = orderConfirm.getDest_id();
		dAddrName = getAddrName(destType, destId);
		
		// 检查优惠活动 1-优惠券优惠 2-会员卡优惠3-群优惠
		int discountType = orderConfirm.getDiscountType();
		String coupCode = orderConfirm.getCoupCode();
		String[] vipCodes = orderConfirm.getVipCodes();
		Integer orgId = orderConfirm.getOrgId();
		double[] coupDiscount = new double[quantity];
		double[] vipDiscount = new double[quantity];
//		double[] actOffDiscount = new double[quantity];
		double[] coupActDiscount = new double[quantity];
		double[] orgGroupDiscount = new double[quantity];//机构群优惠
		Coupon coupon = null;
		Activity activity = null;
//		OrderActivity orderActivity = null;
//		List<OrderActivity> orderActivityList = new ArrayList<OrderActivity>();
		CouponCodeActivity couponCodeActivity = null;
		OrgGroup orgGroup = null;//群机构
		Map<String, VipInfoVo> vipInfoMap = new HashMap<String, VipInfoVo>();
		if(discountType == 1  && Checker.isNotEmpty(coupCode)){
			LogCvt.info("优惠券优惠校验");
			if(coupCode.length() == 8){
				coupon = couponService.selectCouponByChildCode(coupCode);
				if(Checker.isEmpty(coupon)){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"无效的优惠券号");
				}
				activity = activityService.findById(coupon.getActivityId());
				//优惠券校验
				double childAmount = validCoupon(coupon, orderConfirm.getUserId(), orderTotalAmount - orderRangePrice);
				
				double usedAmount = 0;
				for(int i = 0; i < quantity;i++){
					// 计算分摊比例
					if(i != quantity-1){
						coupDiscount[i] = Arith.div(childAmount, quantity);
						usedAmount = Arith.add(usedAmount, coupDiscount[i]);
						totalAmount = Arith.sub(totalAmount, coupDiscount[i]);
					}else{
						double couponDiscount = Arith.sub(childAmount, usedAmount);
						coupDiscount[i] = couponDiscount;
						totalAmount = Arith.sub(totalAmount, coupDiscount[i]);
					}
				}
			}else if(coupCode.length() == 6){
				couponCodeActivity = couponCodeActivityService.findByCode(coupCode);
				if(Checker.isEmpty(couponCodeActivity) || couponCodeActivity.getStatus() != 1){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"无效的优惠券号");
				}
				if(couponCodeActivity.getStartTime().getTime() > System.currentTimeMillis()
						|| couponCodeActivity.getEndTime().getTime() < System.currentTimeMillis()){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"优惠券已过期");
				}
				if(couponCodeActivity.getCount() >= 0 && couponCodeActivity.getUseCount() >= couponCodeActivity.getCount()){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"优惠券已超过使用次数");
				}
				if(couponCodeActivity.getRuleFull() >= (orderTotalAmount - orderRangePrice)){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"订单金额不满足此券使用");
				}
				// 优惠部分运费金额情况
				double codeActityDiscound = couponCodeActivity.getRuleReduce();
				if((orderTotalAmount - orderRangePrice) <= codeActityDiscound){
					codeActityDiscound = (orderTotalAmount - orderRangePrice);
				}
				double usedAmount = 0;
				for(int i = 0; i < quantity;i++){
					// 计算分摊比例
					if(i != quantity-1){
						coupActDiscount[i] = Arith.div(codeActityDiscound, quantity);
						usedAmount = Arith.add(usedAmount, coupActDiscount[i]);
						totalAmount = Arith.sub(totalAmount, coupActDiscount[i]);
					}else{
						double couponDiscount = Arith.sub(codeActityDiscound, usedAmount);
						coupActDiscount[i] = couponDiscount;
						totalAmount = Arith.sub(totalAmount, coupActDiscount[i]);
					}
				}
			}
		}else if(discountType == 2 && vipCodes != null && vipCodes.length > 0){
			LogCvt.info("VIP优惠校验");
			VipOrderConfirmRequest vipReq = new VipOrderConfirmRequest();
			vipReq.setConsignedTime(orderConfirm.getConsigned_time());
			vipReq.setjMobile(orderConfirm.getSrc_moibile());
			vipReq.setjName(orderConfirm.getSrc_name());
			vipReq.setdMobile(orderConfirm.getDest_moibile());
			vipReq.setdName(orderConfirm.getDest_name());
			vipReq.setUserId(orderConfirm.getUserId());
			VipOrderConfirmVo vipOrderConfirmVo = vipInfoSupport.checkVipOrderByUser(vipReq);
			Map<String, Double> vipOrderMap = new HashMap<String, Double>();
			List<VipInfoVo> vipOrderList = vipOrderConfirmVo.getVipInfos();
			for(VipInfoVo vo : vipOrderList){
				double vipOrderAmount = Double.parseDouble(vo.getOrderAmount());
//				double vipOrderAmount = 50;
				vipOrderMap.put(vo.getVipNo(), sfPrice - outRangePrice - vipOrderAmount);
				vipInfoMap.put(vo.getVipNo(), vo);
			}
			int vipCount = vipCodes.length > quantity ? quantity : vipCodes.length;
			for(int i = 0; i < vipCount; i++){
				if(vipOrderMap.containsKey(vipCodes[i])){
					vipDiscount[i] = vipOrderMap.get(vipCodes[i]);
					totalAmount = Arith.sub(totalAmount, vipDiscount[i]);
				}else{
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,vipCodes[i]+"会员卡不满足使用条件");
				}
			}
		}else if(discountType == 3 && orgId != null && orgId !=0){
			//群机构
			OrgGroupUser orgGroupUser =  orgGroupUserService.findByNameAndMobile(orderConfirm.getSrc_name(), orderConfirm.getSrc_moibile());
			orgGroup = orgGroupService.selectById(orgId);
			//时间比较
			Boolean rightDate = false;
			Date nowDate = new Date();
			//结束时间往后加一天再比较
			Date endDate =  orgGroup.getEndDate();
			endDate = DateUtils.addDays(endDate, 1);
			if((nowDate.after(orgGroup.getStartDate()) && (nowDate.before(endDate)))){
				rightDate = true;
			}
			if(orgGroupUser.getStatus() == 1 && orgGroup.getStatus() == 1 && rightDate){
				OrgGroupAmountConfig orgGroupAmountConfig = orgGroupAmountConfigService.selectProperAmountConfig(sfPrice, orgId);
				Double discount = orgGroupAmountConfig ==null ? 0.0 : orgGroupAmountConfig.getDiscount();
				for(int i = 0; i < quantity;i++){
					orgGroupDiscount[i] = discount;
					totalAmount = Arith.sub(totalAmount, orgGroupDiscount[i]);
				}
			}
		}else{
//			LogCvt.info("满减校验");
//			ActivityOrderRequest activityOrderRequest = new ActivityOrderRequest();
//			activityOrderRequest.setdAddrId(destId);
//			activityOrderRequest.setdAddrName(dAddrName);
//			activityOrderRequest.setdAddrType(destType);
//			activityOrderRequest.setdAreaId(orderConfirm.getDest_area_id());
//			activityOrderRequest.setFreight(sfPrice);
//			activityOrderRequest.setjAddrId(srcId);
//			activityOrderRequest.setjAddrName(jAddrName);
//			activityOrderRequest.setjAddrType(srcType);
//			activityOrderRequest.setjAreaId(orderConfirm.getSrc_area_id());
//			orderActivity = activitySupport.checkActivityOff(activityOrderRequest);
//			if(orderActivity != null){
//				discountType = 3;
//				double  discount = 0;
//				if(orderActivity.getjActivity()){
//					discount = Arith.add(discount, orderActivity.getjAmount());
//				}else if(orderActivity.getdActivity()){
//					discount = Arith.add(discount, orderActivity.getdAmount());
//				}
//				for(int i = 0; i < quantity;i++){
//					actOffDiscount[i] = discount;
//					totalAmount = Arith.sub(totalAmount, actOffDiscount[i]);
//				}
//			}
		}
		
		if(totalAmount != orderConfirm.getPrice() || totalAmount < 0){
			LogCvt.error("计算订单总价格:" + totalAmount + "元, 页面订单总价格:"+ orderConfirm.getPrice() +"元");
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"订单金额无效");
		}
		
		/**
		 * 订单信息组装
		 */
		String remark = orderConfirm.getRemark();
		if(remark == null) remark = "";
		// 订单信息
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setProxySelfUserId(orderConfirm.getProxySelfUserId());
		orderInfo.setProxyUserId(orderConfirm.getProxyUserId());
		orderInfo.setUserId(orderConfirm.getUserId());
		
		orderInfo.setTotalAmount(totalPrice);
		orderInfo.setOrderStatus(OrderStatus.un_pay.getCode());
		orderInfo.setRefundStatus(RefundStatus.refund_normal.getCode());
		orderInfo.setDeliveryStatus(DeliveryStatus.un_send_sf.getCode());
		orderInfo.setBpsStatus(SfBpsStatus.un_send.getCode());
		orderInfo.setQuestionStatus(QuestionStatus.normal.getCode());
		orderInfo.setOrderSource(OrderSource.weixin.getCode());
		orderInfo.setSendSfUserTime(consignedTime);
		orderInfo.setFreight(sfPrice);
		orderInfo.setUrgentFee(urgentFee);
		orderInfo.setInsuredFee(insurePrice);
		orderInfo.setInsuredRates(insureRate);
		orderInfo.setInsuredValue((double)orderConfirm.getInsure_price());
		orderInfo.setExpressType(orderConfirm.getBusiness_type());
		orderInfo.setIsHandleQuestion(true);
		orderInfo.setDeliverDate(deliverDate);
		orderInfo.setSendTimeSection(orderConfirm.getConsigned_time());
		
		// 寄件信息
		orderInfo.setjAddrType(orderConfirm.getSrc_type());
		orderInfo.setjAddress(orderConfirm.getSrc_address());
		orderInfo.setjAddrId(orderConfirm.getSrc_type() != 4?orderConfirm.getSrc_id():0);
		orderInfo.setjAddrName(jAddrName);
		orderInfo.setjAreaId(orderConfirm.getSrc_area_id());
		orderInfo.setjContact(orderConfirm.getSrc_name());
		orderInfo.setjMobile(orderConfirm.getSrc_moibile());
		orderInfo.setjTreePath(orderConfirm.getSrc_province()+","+orderConfirm.getSrc_city()+","+orderConfirm.getSrc_district());
		// 收件信息
		orderInfo.setdAddrType(orderConfirm.getDest_type());
		orderInfo.setdAddress(orderConfirm.getDest_address());
		orderInfo.setdAddrId(orderConfirm.getDest_type() != 4?orderConfirm.getDest_id():0);
		orderInfo.setdAddrName(dAddrName);
		orderInfo.setdAreaId(orderConfirm.getDest_area_id());
		orderInfo.setdContact(orderConfirm.getDest_name());
		orderInfo.setdMobile(orderConfirm.getDest_moibile());
		orderInfo.setdTreePath(orderConfirm.getDest_province()+","+orderConfirm.getDest_city()+","+orderConfirm.getDest_district());
		// other
		orderInfo.setIsHelped(false);
		orderInfo.setIsDelete(false);
		orderInfo.setIsVip(false);
		orderInfo.setIsOrg(false);
		orderInfo.setIsBagCode(false);
		orderInfo.setRemark(remark);
		orderInfo.setOpenid(orderConfirm.getOpenid());
		orderInfo.setInputDiscount(0d);
		orderInfo.setPlayTime(orderConfirm.getPlayTime());
	
		orderInfo.setThirdType(1);
		orderInfo.setThirdId(0);
		// 微信支付：客服收款：无需收款。财务收款：是。
		orderInfo.setKfReceivableStatus(0);
		orderInfo.setCwReceivableStatus(1);
		orderInfo.setCouponCode("");
		orderInfo.setCouponId(0);
		/**
		 * 优惠活动
		 */
		double realAmount = sfPrice - outRangePrice;
		if(discountType == 1 && Checker.isNotEmpty(coupCode)){
			if(coupCode.length() == 8){
				double orderAmount = Arith.add(Arith.add(Arith.sub(realAmount, coupDiscount[0]), outRangePrice), insurePrice);
				orderAmount = orderAmount > 0 ? orderAmount : 0;
				orderInfo.setAmount(orderAmount);
				orderInfo.setDiscount(coupDiscount[0]);
				orderInfo.setCouponCode(coupon.getChildCode());
				orderInfo.setCouponId(coupon.getId());
				orderInfo.setFavorableDesc(activity.getName());
			}else if(coupCode.length() == 6){
				double orderAmount = Arith.add(Arith.add(Arith.sub(realAmount, coupActDiscount[0]), outRangePrice), insurePrice);
				orderAmount = orderAmount > 0 ? orderAmount : 0;
				orderInfo.setAmount(orderAmount);
				orderInfo.setDiscount(coupActDiscount[0]);
				orderInfo.setCouponCode(couponCodeActivity.getCode());
				orderInfo.setCouponId(couponCodeActivity.getId());
				orderInfo.setFavorableDesc(couponCodeActivity.getName());
			}
		}else if(discountType == 2 && vipCodes != null && vipCodes.length > 0){
			double orderAmount = Arith.add(Arith.add(Arith.sub(realAmount, vipDiscount[0]), outRangePrice), insurePrice);
			orderAmount = orderAmount > 0 ? orderAmount : 0;
			orderInfo.setAmount(orderAmount);
			orderInfo.setDiscount(vipDiscount[0]);
			if(vipDiscount[0]==0){
				orderInfo.setIsVip(false);
				orderInfo.setVipId(0);
				orderInfo.setFavorableDesc("");
			}else{
				orderInfo.setIsVip(true);
				orderInfo.setVipId(vipInfoMap.get(vipCodes[0]).getId());
				orderInfo.setFavorableDesc("会员卡订单");
			}
		}else if(discountType == 3 && orgId != null && orgId !=0){
			double orderAmount = Arith.add(Arith.sub(sfPrice, orgGroupDiscount[0]), insurePrice);;
			orderAmount = orderAmount > 0 ? orderAmount : 0;
			orderInfo.setAmount(orderAmount);
			orderInfo.setDiscount(orgGroupDiscount[0]);
			orderInfo.setFavorableDesc("机构群订单");
			orderInfo.setIsOrg(true);
			orderInfo.setOrgId(orgId);
			orderInfo.setOrgName(orgGroup.getName());
		}
		
//		else if(discountType == 3){
//			double orderAmount = Arith.add(Arith.sub(sfPrice,actOffDiscount[0]),insurePrice);
//			orderAmount = orderAmount > 0 ? orderAmount : 0;
//			orderInfo.setAmount(orderAmount);
//			orderInfo.setDiscount(actOffDiscount[0]);
//			orderInfo.setFavorableDesc(orderActivity.getActivitName());
//		}
		else{
			double orderAmount = Arith.add(sfPrice,insurePrice);
			orderAmount = orderAmount > 0 ? orderAmount : 0;
			orderInfo.setAmount(orderAmount);
			orderInfo.setDiscount(0d);
		}
		
		// 偏远寄件信息
		OutRangeAddress jAddress = outRangeAddressService.findByAreaId(orderInfo.getjAreaId(), orderInfo.getjAddress());
		OutRangeAddress dAddress = outRangeAddressService.findByAreaId(orderInfo.getdAreaId(), orderInfo.getdAddress());;
		if (orderInfo.getjAddrType() == AddrTypeEnum.address.getType() && Checker.isNotEmpty(jAddress)) {
			orderInfo.setjOutRangeType(4);
			orderInfo.setjOutRangeTime(jAddress.getOutRangeTime());
			orderInfo.setjOutRangePrice(jAddress.getOutRangePrice());
		} else if (orderInfo.getjAddrType() == AddrTypeEnum.course.getType() && Checker.isNotEmpty(jCourse)) {
			orderInfo.setjOutRangeType(jCourse.getIsOutRange() ? 1 : 0);
			orderInfo.setjOutRangeTime(jCourse.getOutRangeTime());
			orderInfo.setjOutRangePrice(jCourse.getOutRangePrice());
		} else {
			orderInfo.setjOutRangeType(0);
			orderInfo.setjOutRangeTime(0d);
			orderInfo.setjOutRangePrice(0d);
		}

		// 偏远收件信息
		if (orderInfo.getdAddrType() == AddrTypeEnum.address.getType() && Checker.isNotEmpty(dAddress)) {
			orderInfo.setdOutRangeType(4);
			orderInfo.setdOutRangeTime(dAddress.getOutRangeTime());
			orderInfo.setdOutRangePrice(dAddress.getOutRangePrice());
		} else if (orderInfo.getdAddrType() == AddrTypeEnum.course.getType() && Checker.isNotEmpty(dCourse)) {
			orderInfo.setdOutRangeType(dCourse.getIsOutRange() ? 1 : 0);
			orderInfo.setdOutRangeTime(dCourse.getOutRangeTime());
			orderInfo.setdOutRangePrice(dCourse.getOutRangePrice());
		} else {
			orderInfo.setdOutRangeType(0);
			orderInfo.setdOutRangeTime(0d);
			orderInfo.setdOutRangePrice(0d);
		}
		String subNumber = commonService.createOrderId();
		
		
		/**
		 * 添加大订单
		 */
		Orders order = new Orders();
		if(orderInfo.getdAddrType() == 4){
			order.setdAddrName(orderInfo.getdAddress());
		}else{
			order.setdAddrName(orderInfo.getdAddrName());
		}
		order.setdContact(orderInfo.getdContact());
		order.setdMobile(orderInfo.getdMobile());
		order.setdTreePath(orderInfo.getdTreePath());
		order.setIsDelete(false);
		order.setIsHelped(orderInfo.getIsHelped());
		if(orderInfo.getjAddrType() == 4){
			order.setjAddrName(orderInfo.getjAddress());
		}else{
			order.setjAddrName(orderInfo.getjAddrName());
		}
		order.setjContact(orderInfo.getjContact());
		order.setjMobile(orderInfo.getjMobile());
		order.setjTreePath(orderInfo.getjTreePath());
		order.setNumber(commonService.createBigOrderId());
		order.setOpenId(orderInfo.getOpenid());
		order.setOrderSource(orderInfo.getOrderSource());
		order.setOrderStatus(BigOrderStatus.normal.getCode());
		order.setPayMethod(0);
		order.setPayStatus(BigOrderPayStatus.un_pay.getCode());
		order.setPayTime(null);
		order.setQuantity(quantity);
		order.setThirdId(orderInfo.getThirdId());
		order.setThirdName(orderInfo.getThirdName());
		order.setThirdType(orderInfo.getThirdType());
		order.setAssistantName(orderInfo.getAssistantName());
		order.setUserId(orderConfirm.getUserId());
		order.setSubNumber(subNumber);
		int orderId = ordersService.insert(order);
		
		
		String uuid = ToolsUtil.getUUID();
		orderInfo.setNumber(subNumber);
		orderInfo.setOrderId(orderId);
		orderInfo.setOrderNumber(order.getNumber());
		orderInfo.setMd5(uuid);
		BagCodeOrder bagCodeOrderdb = bagCodeOrderService.selectById(bagCodeOrderId);
		if(Checker.isNotEmpty(bagCodeOrderdb)){
			orderInfo.setIsBagCode(true);
			orderInfo.setBagCode(bagCodeOrderdb.getBagCode());
			orderInfo.setBagCodePartnerId(bagCodeOrderdb.getBagCodePartnerId());
			orderInfo.setBagCodePartnerName(bagCodeOrderdb.getBagCodePartnerName());
		}
		orderInfoService.inser(orderInfo);
		//更新该包包码订单id和订单号
		BagCodeOrder bagCodeOrder = new BagCodeOrder(); 
		bagCodeOrder.setId(bagCodeOrderId);
		bagCodeOrder.setOrderId(orderInfo.getId());
		bagCodeOrder.setOrderNumber(subNumber);
		bagCodeOrderService.updateById(bagCodeOrder);

//		if(discountType == 3){
//			orderActivity.setOrderId(subNumber);
//			orderActivityList.add(orderActivity);
//		}
		
		// 添加客户信息
		saveUserContact(orderInfo, 0);
		
		for(int i = 1 ; i < order.getQuantity(); i++){
			orderInfo.setNumber(commonService.createOrderId());
			orderInfo.setOrderId(orderId);
			orderInfo.setOrderNumber(order.getNumber());
			orderInfo.setMd5(uuid);
			if(Checker.isNotEmpty(bagCodeOrderdb)){
				orderInfo.setIsBagCode(true);
				orderInfo.setBagCode(bagCodeOrderdb.getBagCode());
				orderInfo.setBagCodePartnerId(bagCodeOrderdb.getBagCodePartnerId());
				orderInfo.setBagCodePartnerName(bagCodeOrderdb.getBagCodePartnerName());
			}
			/**
			 * 优惠活动
			 */
			if(discountType == 1 && Checker.isNotEmpty(coupCode)){
				if(coupCode.length() == 8){
					double orderAmount = Arith.add(Arith.sub(sfPrice,coupDiscount[i]),insurePrice);
					orderAmount = orderAmount > 0 ? orderAmount : 0;
					orderInfo.setAmount(orderAmount);
					orderInfo.setDiscount(coupDiscount[i]);
					orderInfo.setCouponCode(coupon.getChildCode());
					orderInfo.setCouponId(coupon.getId());
					orderInfo.setFavorableDesc(activity.getName());
				}else if(coupCode.length() == 6){
					double orderAmount = Arith.add(Arith.sub(sfPrice,coupActDiscount[i]),insurePrice);
					orderAmount = orderAmount > 0 ? orderAmount : 0;
					orderInfo.setAmount(orderAmount);
					orderInfo.setDiscount(coupActDiscount[i]);
					orderInfo.setCouponCode(couponCodeActivity.getCode());
					orderInfo.setCouponId(couponCodeActivity.getId());
					orderInfo.setFavorableDesc(couponCodeActivity.getName());
				}
			}else if(discountType == 2 && vipCodes != null && vipCodes.length > 0){
				double orderAmount = Arith.add(Arith.sub(sfPrice,vipDiscount[i]),insurePrice);
				orderAmount = orderAmount > 0 ? orderAmount : 0;
				orderInfo.setAmount(orderAmount);
				orderInfo.setDiscount(vipDiscount[i]);
				if(vipDiscount[i] == 0){
					orderInfo.setIsVip(false);
					orderInfo.setVipId(0);
					orderInfo.setFavorableDesc("");
				}else{
					orderInfo.setIsVip(true);
					orderInfo.setVipId(vipInfoMap.get(vipCodes[i]).getId());
					orderInfo.setFavorableDesc("会员卡订单");
				}
			}else if(discountType == 3 && orgId != null && orgId !=0){
				double orderAmount = Arith.add(Arith.sub(sfPrice, orgGroupDiscount[i]), insurePrice);;
				orderAmount = orderAmount > 0 ? orderAmount : 0;
				orderInfo.setAmount(orderAmount);
				orderInfo.setDiscount(orgGroupDiscount[i]);
				orderInfo.setFavorableDesc("机构群订单");
				orderInfo.setIsOrg(true);
				orderInfo.setOrgId(orgId);
				orderInfo.setOrgName(orgGroup.getName());
			}
//			else if(discountType == 3){
//				double orderAmount = Arith.add(Arith.sub(sfPrice,actOffDiscount[i]),insurePrice);
//				orderAmount = orderAmount > 0 ? orderAmount : 0;
//				orderInfo.setAmount(orderAmount);
//				orderInfo.setDiscount(actOffDiscount[i]);
//				orderInfo.setFavorableDesc(orderActivity.getActivitName());
//				
//				OrderActivity subOrderActivity = BeanUtil.a2b(orderActivity, OrderActivity.class);
//				subOrderActivity.setOrderId(orderInfo.getNumber());
//				orderActivityList.add(subOrderActivity);
//			}
			else{
				double orderAmount = Arith.add(sfPrice,insurePrice);
				orderAmount = orderAmount > 0 ? orderAmount : 0;
				orderInfo.setAmount(orderAmount);
				orderInfo.setDiscount(0d);
			}
			
			orderInfoService.inser(orderInfo);
			/**
			 * 记录订单日志
			 */
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("下单");
			log.setDescription("客户下单");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName(orderConfirm.getUserName());
			log.setOperatorType(OrderOperateTypeEnum.weixin_user.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
		}
		//记录满减活动订单信息
//		if(Checker.isNotEmpty(orderActivityList)){
//			activitySupport.cachePayOrderActivity(orderId, orderActivityList);
//		}
		//增加优惠券使用次数
		if(discountType == 1 && Checker.isNotEmpty(coupCode) && coupCode.length() == 6){
			couponCodeActivityService.incrUseCountByCode(coupCode);
		}
		return order.getNumber();
	}

	/**
	 * 校验包包码
	 */
	public int checkBagCode(OrderConfirm orderConfirm) {
		String handleSrc_name = orderConfirm.getSrc_name().trim().replaceAll(" ", "");
		int srIndex = handleSrc_name.toUpperCase().lastIndexOf("sr".toUpperCase());
		UserWeixin userWeixin = userWeixinService.findById(orderConfirm.getUserId());
		String bagCode = null;
		int bagCodeOrderId = 0;
		BagCodeOrder bagCodeOrder = new BagCodeOrder();
		String srcName = "";
		/*if(srIndex>0&&(orderConfirm.getDiscountType()==2||orderConfirm.getDiscountType()==3)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"优惠重复");
		}*/
		if(srIndex>0){
			//截取寄件人
			srcName = handleSrc_name.substring(0, srIndex);
			orderConfirm.setSrc_name(srcName);
			//截取包包码
			bagCode =  handleSrc_name.substring(srIndex);
			bagCodeOrder.setBagCodePartnerId(0);
			bagCodeOrder.setBagCodePartnerName("");
			bagCodeOrder.setBagCode(bagCode);
			bagCodeOrder.setUserId(orderConfirm.getUserId());
			bagCodeOrder.setNickname(userWeixin.getNickname());
			bagCodeOrder.setName(srcName);
			bagCodeOrder.setMobile(orderConfirm.getSrc_moibile());
			bagCodeOrder.setActivityId(0);
			bagCodeOrder.setActivityName("");
			bagCodeOrder.setOrderId(0);
			bagCodeOrder.setOrderNumber("");
			bagCodeOrder.setStatus(0);
			bagCodeOrderId = bagCodeOrderService.insert(bagCodeOrder);
		}
		if(Checker.isNotEmpty(bagCode)){
			BagCodePartner bagCodePartner = bagCodePartnerService.findByBagCode(bagCode);
			if(Checker.isEmpty(bagCodePartner)){
				bagCodeOrder.setResult(BagCodeOrderResult.bagCode_un_exist.getDesc());
				bagCodeOrder.setStatus(2);
				bagCodeOrderService.updateById(bagCodeOrder);
				return bagCodeOrderId;
			}
			bagCodeOrder.setActivityId(bagCodePartner.getActivityId());
			bagCodeOrder.setActivityName(bagCodePartner.getActivityName());
			bagCodeOrder.setBagCodePartnerId(bagCodePartner.getId());
			bagCodeOrder.setBagCodePartnerName(bagCodePartner.getName());
			bagCodeOrderService.updateById(bagCodeOrder);
			//寄件人和收件人不一致
			if(bagCodePartner.getSameInfo()){
				if(!srcName.equals(orderConfirm.getDest_name())
				   ||!orderConfirm.getSrc_moibile().equals(orderConfirm.getDest_moibile())){
						bagCodeOrder.setResult(BagCodeOrderResult.jd_distinct.getDesc());
						bagCodeOrder.setStatus(2);
						bagCodeOrderService.updateById(bagCodeOrder);
						return bagCodeOrderId;
				}
			}
			if(bagCodePartner.getStatus()==2){
				bagCodeOrder.setResult(BagCodeOrderResult.bagCode_forbidden.getDesc());
				bagCodeOrder.setStatus(2);
				bagCodeOrderService.updateById(bagCodeOrder);
				return bagCodeOrderId;
			}
			//时间比较
			if(DateUtil.getDiffDaysForDay(new Date(), bagCodePartner.getStartDate())>0
					||DateUtil.getDiffDaysForDay(new Date(), bagCodePartner.getEndDate())<0){
				bagCodeOrder.setResult(BagCodeOrderResult.bagCode_un_date.getDesc());
				bagCodeOrder.setStatus(2);
				bagCodeOrderService.updateById(bagCodeOrder);
				return bagCodeOrderId;
			}
			//是否寄件人信息随意
			if(bagCodePartner.getSenderRandom()){
				//随意则使用成功，未支付
				bagCodeOrder.setResult(BagCodeOrderResult.un_pay.getDesc());
				bagCodeOrder.setStatus(0);
				bagCodeOrderService.updateById(bagCodeOrder);
				//如果包包码and寄件人and寄件人电话不存在就插入
				BagCodeUser bagCodeUser = bagCodeUserService.findIsSenderRandom(bagCode, srcName, orderConfirm.getSrc_moibile());
				if(Checker.isEmpty(bagCodeUser)){
					BagCodeUser bagCodeUserNew = new BagCodeUser();
					bagCodeUserNew.setBagCodePartnerId(bagCodePartner.getId());
					bagCodeUserNew.setBagCodePartnerName(bagCodePartner.getName());
					bagCodeUserNew.setBagCode(bagCode);
					bagCodeUserNew.setUserId(orderConfirm.getUserId());
					bagCodeUserNew.setNickname(userWeixin.getNickname());
					bagCodeUserNew.setName(srcName);
					bagCodeUserNew.setMobile(orderConfirm.getSrc_moibile());
					bagCodeUserNew.setActivityId(bagCodePartner.getActivityId());
					bagCodeUserNew.setActivityName(bagCodePartner.getActivityName());
					bagCodeUserService.insert(bagCodeUserNew);
				}
			}else{
				BagCodeUser bagCodeUser = bagCodeUserService.findSenderRandom(bagCode, srcName, orderConfirm.getSrc_moibile());
				if(Checker.isEmpty(bagCodeUser)){
					bagCodeOrder.setResult(BagCodeOrderResult.un_pay.getDesc());
					bagCodeOrder.setStatus(0);	
					bagCodeOrderService.updateById(bagCodeOrder);
					//(包包码是新的不管名称号码)和(存在包包码但姓名和手机有一个不和库里的一致)直接插入
					BagCodeUser bagCodeUserNew = new BagCodeUser();
					bagCodeUserNew.setBagCodePartnerId(bagCodePartner.getId());
					bagCodeUserNew.setBagCodePartnerName(bagCodePartner.getName());
					bagCodeUserNew.setBagCode(bagCode);
					bagCodeUserNew.setUserId(orderConfirm.getUserId());
					bagCodeUserNew.setNickname(userWeixin.getNickname());
					bagCodeUserNew.setName(srcName);
					bagCodeUserNew.setMobile(orderConfirm.getSrc_moibile());
					bagCodeUserNew.setActivityId(bagCodePartner.getActivityId());
					bagCodeUserNew.setActivityName(bagCodePartner.getActivityName());
					bagCodeUserService.insert(bagCodeUserNew);
				}else{
					//bagCodeUser该对象没有，比较包包码and名称and手机，完全一致，未支付。包包码一样的前提下姓名或手机号码有一个不一致的，寄件人信息不能随意。
					if(bagCodeUser.getBagCode().equals(bagCode)&&bagCodeUser.getName().equals(srcName)
					   &&bagCodeUser.getMobile().equals(orderConfirm.getSrc_moibile())){
						bagCodeOrder.setResult(BagCodeOrderResult.un_pay.getDesc());
						bagCodeOrder.setStatus(0);
						bagCodeOrderService.updateById(bagCodeOrder);
					}else{
						bagCodeOrder.setResult(BagCodeOrderResult.j_un_free.getDesc());
						bagCodeOrder.setStatus(2);
						bagCodeOrderService.updateById(bagCodeOrder);
					}
				}
			}
		}
		return bagCodeOrderId;
	}
	

	/**
	 *  获取站点名称
	  * @Title: getAddrName
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param srcType
	  * @param srcId
	  * @return
	 */
	private String getAddrName(int srcType, int srcId) {
		 String jAddrName = "";
		switch (AddrTypeEnum.getByType(srcType)) {
			case course:
				jAddrName = baseCourseService.findById(srcId).getName();
				break;
			case airport:
				jAddrName = baseAirportService.findById(srcId).getName();
				break;
			case bank:
				jAddrName = baseBankBranchService.findById(srcId).getName();
				break;
			case sfSite:
				jAddrName = baseSfSiteService.findById(srcId).getName();
				break;
			default:
				break;
		}
		return jAddrName;
	}

	

	/**
	 *  保存常用联系人
	  * @Title: saveUserContact
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderInfo
	 */
	private void saveUserContact(OrderInfo orderInfo, int type) {
		try{
			// 寄件人
			UserContact jContact = userContactService.findByMobile(orderInfo.getjMobile());
			if(Checker.isEmpty(jContact)){
				jContact = new UserContact();
				jContact.setMobile(orderInfo.getjMobile());
				jContact.setName(orderInfo.getjContact());
				jContact.setIsDelete(false);
				jContact.setType(type);
				userContactService.insert(jContact);
			}else if(jContact.getType() == 0 && type == 1){
				jContact.setType(type);
				userContactService.updateById(jContact);
			}
			// 收件人
			UserContact dContact = userContactService.findByMobile(orderInfo.getdMobile());
			if (Checker.isEmpty(dContact)) {
				dContact = new UserContact();
				dContact.setMobile(orderInfo.getdMobile());
				dContact.setName(orderInfo.getdContact());
				dContact.setIsDelete(false);
				dContact.setType(type);
				userContactService.insert(dContact);
			}else if(dContact.getType() == 0 && type == 1){
				dContact.setType(type);
				userContactService.updateById(dContact);
			}
		}catch(Exception e){
			LogCvt.error(e.getMessage(),e);
		}
	}


	@Override
	public OrderDetailV2 unpayOrderDetail(String orderId) {
		List<OrderInfo> orderInfoList = orderInfoService.findByOrderNumber(orderId);
		if(Checker.isEmpty(orderInfoList)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "查无记录");
		}
		Orders orders = ordersService.findByNumber(orderId);
		if(orders.getOrderStatus() == BigOrderStatus.close.getCode().intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单已失效，不能继续支付！");
		}
		
		OrderDetailV2 orderDetail = BeanUtil.a2b(orderInfoList.get(0), OrderDetailV2.class);
		
		double originInsuredFee = insureTemplateSupport.insureValidPrice(orderDetail.getInsuredValue(), 2);
		orderDetail.setDiscountInsuredFee(originInsuredFee - orderDetail.getInsuredFee());
		orderDetail.setAmount(0d);
		orderDetail.setDiscount(0d);
		for(OrderInfo subOrderInfo : orderInfoList){
			if(OrderStatus.user_close.getCode().equals(subOrderInfo.getOrderStatus())
					|| OrderStatus.sys_close.getCode().equals(subOrderInfo.getOrderStatus())
					|| OrderStatus.kf_close.getCode().equals(subOrderInfo.getOrderStatus())){
				continue;
			}
			if(Checker.isNotEmpty(subOrderInfo.getCouponCode())){
				orderDetail.setDiscountType(2);
			}else if(subOrderInfo.getIsVip()){
				orderDetail.setDiscountType(1);
			}else if(subOrderInfo.getIsOrg()){
				orderDetail.setDiscountType(3);
			}
			orderDetail.setAmount(Arith.add(subOrderInfo.getAmount(), orderDetail.getAmount()));
			orderDetail.setDiscount(Arith.add(subOrderInfo.getDiscount(), orderDetail.getDiscount()));
			orderDetail.setQuantity(orderDetail.getQuantity()+1);
			if(orderDetail.getjOutRangeType()!=0){
				orderDetail.setjIsOutRange(true);
			}
			if(orderDetail.getdOutRangeType()!=0){
				orderDetail.setdIsOutRange(true);
			}
			
			if(ExpressTypeEnum.after_tomorow.getType().equals(subOrderInfo.getExpressType())){
				long days = DateUtil.getDiffDaysForDay(
						subOrderInfo.getSendSfUserTime(), 
						DateUtil.str2Date(subOrderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
						);
				orderDetail.setExpressDescribe("预计"+days+"天后送达");
			}
		}
		return orderDetail;
	}
	
	
	/**
	 *  订单支付成功
	  * @Title: paySuccess
	  * @Description: TODO
	  * @author: share 2016年8月15日
	  * @modify: share 2016年8月15日
	  * @param payment
	  * @see com.qbt.web.support.OrderSupport#paySuccess(com.qbt.persistent.entity.OrderPayInfo)
	 */
	@Override
	public void paySuccess(OrderPayInfo payment) {
		try {
			/**
			 * 修改订单信息
			 */
			Orders bigOrder = ordersService.findById(payment.getOrderId());
			bigOrder.setPayMethod(payment.getPayMethod());
			bigOrder.setPayStatus(BigOrderPayStatus.paid.getCode());
			bigOrder.setPayTime(new Date());
			ordersService.update(bigOrder);
			Integer couponId = null;
			
			List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(bigOrder.getNumber());
			// 参与满减的子订单信息
//			List<OrderActivity> activityList = activitySupport.getCachePayOrderActivity(bigOrder.getId());
//			Map<String,OrderActivity> activitySubOrderNumberSet = new HashMap<String,OrderActivity>();
//			for(OrderActivity activity : activityList){
//				activitySubOrderNumberSet.put(activity.getOrderId(),activity);
//			}
			Coupon coupon = null;
			Activity activity = null;
			UserWeixin userWeixin = userWeixinService.findByOpenId(bigOrder.getOpenId());
			/**
			 *  修改子订单
			 */
			for(OrderInfo orderInfo : subOrderList){
				if(orderInfo.getOrderStatus().intValue() != OrderStatus.un_pay.getCode().intValue()){
					LogCvt.info("子订单已非待支付状态，支付成功的订单不处理此记录，ID:"+orderInfo.getId()+",number:"+orderInfo.getNumber());
					continue;
				}
				couponId = orderInfo.getCouponId();
				String couponCode = orderInfo.getCouponCode();
				if(couponCode != null 
						&& couponCode.length() == 8 
						&& coupon == null){
					coupon = couponService.findById(payment.getCouponId());
					activity = activityService.findById(coupon.getActivityId());
				}
				//检查是否首单
				long count = orderInfoService.orderCount(orderInfo);
				if(count == 1){
					orderInfo.setFirstOrder(true);
				}
				orderInfo.setOrderStatus(OrderStatus.pay_succ.getCode());
//				orderInfo.setDiscount(0d);
				orderInfo.setPayId(payment.getId());
				orderInfo.setPayTime(payment.getCreateTime());
				// 登记满减记录
//				saveActivityOffBook(activitySubOrderNumberSet, orderInfo);
				// 登记订单使用券表记录
				saveOrderCounpon(couponId, coupon, activity, orderInfo, userWeixin);
				// 修改子订单状态
				orderInfoService.updateById(orderInfo);				
				//代下单支付，订单跑到客户头上
				if(orderInfo.getProxySelfUserId() >0 && !orderInfo.getUserId().equals(orderInfo.getProxySelfUserId())){
					orderInfoService.updateByProxUserId(orderInfo);
				}				
				// 添加客户信息
				saveUserContact(orderInfo, 1);
				// 检查订单预约取包时间是否在3天内，发送BSP
				sendSfBsp(orderInfo);
				// 是否VIP订单,会员卡设置为已使用
				checkVipOrder(orderInfo);
				 //添加历史联系人
				addUserOrderContact(orderInfo);
				// 登记二维码销售人员业务数据
				saleOrderInfo(orderInfo);
				//更新包包码使用记录状态
				saleBagCode(orderInfo);
				
			}
			
			// 短信消息发送
			for(OrderInfo orderInfo : subOrderList){
				messageAndWeixinSend(orderInfo);
			}
			/**
			 * 设置优惠券为已使用
			 */
			if(coupon != null){
//				Coupon coupon = couponService.findById(couponId);
				coupon.setUserId(bigOrder.getUserId());
				coupon.setUserName(userWeixin.getNickname());
				coupon.setStatus(2);
				if(coupon.getClaimType() == 0){
					coupon.setClaimType(1);
				}
				couponService.updateById(coupon);
			}
			
			
			reward(bigOrder,userWeixin);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 包包码业绩
	 * @param orderInfo
	 * @author wuwang
	 */
	private void saleBagCode(OrderInfo orderInfo) {
		if(orderInfo.getIsBagCode()){
			UserWeixin userWeixin = userWeixinService.findById(orderInfo.getUserId());
			BagCodeOrder bagCodeOrder = bagCodeOrderService.findByOrderId(orderInfo.getId());
			if(Checker.isNotEmpty(bagCodeOrder)&&bagCodeOrder.getStatus() == 0){
				bagCodeOrder.setResult(BagCodeOrderResult.paid.getDesc());
				bagCodeOrder.setStatus(1);
				bagCodeOrderService.updateById(bagCodeOrder);
				//给用户奖励券
				 Activity activity = activityService.findById(bagCodeOrder.getActivityId());
				 if(activity!=null 
						&& DateUtil.getDiffDaysForDay(new Date(), activity.getStartTime()) <= 0 
						&& DateUtil.getDiffDaysForDay(new Date(), activity.getEndTime()) >= 0){
					 if(activity.getType()==1 && activity.getStatus() == 1){
						 Coupon coupon = couponService.getCoupon(activity.getId());
						 if(coupon != null){
							 // 将此 奖券Code下的子奖券人绑定为该用户
							 Coupon params = new Coupon();
							 params.setCode(coupon.getCode());
							 params.setUserId(orderInfo.getUserId());
							 params.setOrderId(orderInfo.getOrderId());
							 params.setUserName(userWeixin.getNickname());
							 couponService.bindCoupon(params);
						 }
					 }else if(activity.getType()==2 && activity.getStatus() == 1){
						 //生成券
						 Coupon coupon = new Coupon();
						 coupon.setActivityId(activity.getId());
						 String couponCode = commonService.createCouponCode();
						 coupon.setCode(couponCode);
						 coupon.setChildCode(couponCode);
						 coupon.setType(1);//现金券
						 coupon.setAmount(activity.getCouponAmount());
						 coupon.setChildAmount(activity.getCouponAmount());
						 coupon.setLimitAmount(activity.getCouponLimitAmount());
						 Date nowDay = new Date();
						 coupon.setStartTime(nowDay);
						 coupon.setEndTime(DateUtils.addDays(nowDay, activity.getCouponLimitDay()));
						 coupon.setStatus(1);//1-未使用
						 coupon.setClaimType(1);//1-用户领取
						 coupon.setClaimTime(nowDay);
						 coupon.setUserId(orderInfo.getUserId());
						 coupon.setUserName(userWeixin.getNickname());
						 coupon.setOrderId(orderInfo.getOrderId());
						 coupon.setLockStatus(1);//1-锁定
						 couponService.insert(coupon);
					 }
				 }
			}
			
		}
		
	}

	/**
	 * 登记销售人员订单销售提成记录
	 * @param orderInfo
	 * @author wuwang 2017年8月14日
	 */
	public void saleOrderInfo(OrderInfo orderInfo) {
		try {
			LogCvt.info("用户下单销售提成");
			Integer proxyUserId = orderInfo.getProxyUserId();
			//UserWeixin weixin = userWeixinService.findById(orderInfo.getUserId());
			UserWeixin weixin = userWeixinService.findById(orderInfo.getProxySelfUserId());
			UserWeixin proxySelfUser = userWeixinService.findById(orderInfo.getProxySelfUserId());
			UserProxy userProxy = userProxyService.findByUserId(proxyUserId, orderInfo.getProxySelfUserId());
			if(proxyUserId != null && proxyUserId > 0){
				LogCvt.info("用户下单销售提成，代理下单");
				SaleUser saleUser = saleUserService.findByUserId(proxyUserId);
				if(saleUser == null || saleUser.getApplyStatus() != 2 || saleUser.getStatus() != 1 ){
					LogCvt.info("用户状态信息不正确不能享受销售提成");
					return;
				}
				SaleOrderInfo saleOrderInfo = new SaleOrderInfo();
				int type = saleUser.getType(); // 1-固定金额 2-按订单金额比例
				int orderDayType = saleUser.getOrderDayType(); // 1-不限 2-有限
				// 检查是否为规定期内的首单
				boolean matchDay = false;
				if(orderDayType == 2 && weixin.getSubscribeTime() != null && userProxy != null){
					Date subscripeDate = DateUtil.str2Date(DateUtil.formatDate(weixin.getSubscribeTime(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01);
					subscripeDate = DateUtil.calDateOfDay(subscripeDate, userProxy.getOrderDayValue() - 1);
					//subscripeDate = DateUtil.calDateOfDay(subscripeDate, saleUser.getOrderDayValue() - 1);
					long nowDayTime = DateUtil.str2Date(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01).getTime();
					matchDay = subscripeDate.getTime() - nowDayTime >=0;
				}
				if(orderInfo.getFirstOrder() && matchDay){
					//首单有效期内
					int ftype = saleUser.getFirstType(); // 1-固定金额 2-按订单金额比例
					if(ftype == 1){
						//奖励销售
						saleOrderInfo.setAmount(saleUser.getTypeValue());
						//奖励销售用户（券）
						 Activity activity = activityService.findById(saleUser.getActivityId());
						 if(activity!=null 
								&& DateUtil.getDiffDaysForDay(new Date(), activity.getStartTime()) <= 0 
								&& DateUtil.getDiffDaysForDay(new Date(), activity.getEndTime()) >= 0){
							 if(activity.getType()==1 && activity.getStatus() == 1){
								 Coupon coupon = couponService.getCoupon(activity.getId());
								 if(coupon != null){
									 // 将此 奖券Code下的子奖券人绑定为该用户
									 Coupon params = new Coupon();
									 params.setCode(coupon.getCode());
									 params.setUserId(orderInfo.getProxySelfUserId());
									 params.setOrderId(orderInfo.getOrderId());
									 params.setUserName(proxySelfUser.getNickname());
									 couponService.bindCoupon(params);
								 }
							 }else if(activity.getType()==2 && activity.getStatus() == 1){
								 //生成券
								 Coupon coupon = new Coupon();
								 coupon.setActivityId(activity.getId());
								 String couponCode = commonService.createCouponCode();
								 coupon.setCode(couponCode);
								 coupon.setChildCode(couponCode);
								 coupon.setType(1);//现金券
								 coupon.setAmount(activity.getCouponAmount());
								 coupon.setChildAmount(activity.getCouponAmount());
								 coupon.setLimitAmount(activity.getCouponLimitAmount());
								 Date nowDay = new Date();
								 coupon.setStartTime(nowDay);
								 coupon.setEndTime(DateUtils.addDays(nowDay, activity.getCouponLimitDay()));
								 coupon.setStatus(1);//1-未使用
								 coupon.setClaimType(1);//1-用户领取
								 coupon.setClaimTime(nowDay);
								 coupon.setUserId(orderInfo.getProxySelfUserId());
								 coupon.setUserName(proxySelfUser.getNickname());
								 coupon.setOrderId(orderInfo.getOrderId());
								 coupon.setLockStatus(1);//1-锁定
								 couponService.insert(coupon);
							 }
						 }
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getFirstTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(ftype);
				}else if(matchDay){
					if(type == 1){
						saleOrderInfo.setAmount(saleUser.getTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(type);
				}else if(proxyUserId.equals(orderInfo.getProxySelfUserId())){
					if(type == 1){
						saleOrderInfo.setAmount(saleUser.getTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(type);
				}else{
					return;
				}
				saleOrderInfo.setOrderAmount(orderInfo.getAmount());
				saleOrderInfo.setOrderId(orderInfo.getId());
				saleOrderInfo.setOrderTime(orderInfo.getCreateTime());
				saleOrderInfo.setSaleId(saleUser.getId());
				saleOrderInfo.setSettleStatus(1);
				saleOrderInfo.setStatus(2);
				saleOrderInfo.setTypeValue(saleUser.getTypeValue());
				saleOrderInfoService.insert(saleOrderInfo);
			}else{
				SaleUser saleUser = saleUserService.findById(weixin.getSalesmanId());
				if(saleUser == null)return;
				UserProxy userProxy02 = userProxyService.findByUserId(saleUser.getUserId(), orderInfo.getProxySelfUserId());
				int type = saleUser.getType(); // 1-固定金额 2-按订单金额比例
				int orderDayType = saleUser.getOrderDayType(); // 1-不限 2-有限
				// 检查是否为规定期内的首单
				boolean matchDay = false;
				if(orderDayType == 2 && userProxy02 != null){
					Date subscripeDate = DateUtil.str2Date(DateUtil.formatDate(weixin.getSubscribeTime(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01);
					subscripeDate = DateUtil.calDateOfDay(subscripeDate, userProxy02.getOrderDayValue() - 1);
					//subscripeDate = DateUtil.calDateOfDay(subscripeDate, saleUser.getOrderDayValue() - 1);
					long nowDayTime = DateUtil.str2Date(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01).getTime();
					matchDay = subscripeDate.getTime() - nowDayTime >=0;
				}
				SaleOrderInfo saleOrderInfo = new SaleOrderInfo();
				if(orderInfo.getFirstOrder() && matchDay){
					int ftype = saleUser.getFirstType(); // 1-固定金额 2-按订单金额比例
					if(ftype == 1){
						saleOrderInfo.setAmount(saleUser.getFirstTypeValue());
						//奖励销售用户（券）
						 Activity activity = activityService.findById(saleUser.getActivityId());
						 if(activity!=null 
								&& DateUtil.getDiffDaysForDay(new Date(), activity.getStartTime()) <= 0 
								&& DateUtil.getDiffDaysForDay(new Date(), activity.getEndTime()) >= 0){
							 if(activity.getType()==1 && activity.getStatus() == 1){
								 Coupon coupon = couponService.getCoupon(activity.getId());
								 if(coupon != null){
									// 将此 奖券Code下的子奖券人绑定为该用户
									 Coupon params = new Coupon();
									 params.setCode(coupon.getCode());
									 params.setUserId(orderInfo.getProxySelfUserId());
									 params.setOrderId(orderInfo.getOrderId());
									 params.setUserName(proxySelfUser.getNickname());
									 couponService.bindCoupon(params);
								 }
							 }else if(activity.getType()==2 && activity.getStatus() == 1){
								//生成券
								Coupon coupon = new Coupon();
								coupon.setActivityId(activity.getId());
								String couponCode = commonService.createCouponCode();
								coupon.setCode(couponCode);
								coupon.setChildCode(couponCode);
								coupon.setType(1);//现金券
								coupon.setAmount(activity.getCouponAmount());
								coupon.setChildAmount(activity.getCouponAmount());
								coupon.setLimitAmount(activity.getCouponLimitAmount());
								Date nowDay = new Date();
								coupon.setStartTime(nowDay);
								coupon.setEndTime(DateUtils.addDays(nowDay, activity.getCouponLimitDay()));
								coupon.setStatus(1);//1-未使用
								coupon.setClaimType(1);//1-用户领取
								coupon.setClaimTime(nowDay);
								coupon.setUserId(orderInfo.getProxySelfUserId());
								coupon.setUserName(proxySelfUser.getNickname());
								coupon.setOrderId(orderInfo.getOrderId());
								coupon.setLockStatus(1);//1-锁定
								couponService.insert(coupon);
							 }
						 }
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getFirstTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(ftype);
				}else if(matchDay){
					if(type == 1){
						saleOrderInfo.setAmount(saleUser.getTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(type);
				}else{
					return;
				}
				saleOrderInfo.setOrderAmount(orderInfo.getAmount());
				saleOrderInfo.setOrderId(orderInfo.getId());
				saleOrderInfo.setOrderTime(orderInfo.getCreateTime());
				saleOrderInfo.setSaleId(saleUser.getId());
				saleOrderInfo.setSettleStatus(1);
				saleOrderInfo.setStatus(2);
				saleOrderInfo.setTypeValue(saleUser.getTypeValue());
				saleOrderInfoService.insert(saleOrderInfo);
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 添加历史联系人
	 * @author: wuwang 2017年6月27日
	 * @modify: wuwang 2017年6月27日
	 * @param orderInfo
	 */
	
	private void addUserOrderContact(OrderInfo orderInfo) {
		String juuid = Md5.MD5Encode(""+orderInfo.getUserId()+orderInfo.getjContact()+orderInfo.getjMobile());
		//寄
		UserOrderContact j_uoc = userOrderContactService.findByUuid(juuid);
		if(j_uoc == null){
			j_uoc = new UserOrderContact();
			j_uoc.setUserId(orderInfo.getUserId());
			j_uoc.setContact(orderInfo.getjContact());
			j_uoc.setMobile(orderInfo.getjMobile());
			j_uoc.setUuid(juuid);
			userOrderContactService.insert(j_uoc);
		}
		
		String duuid = Md5.MD5Encode(""+orderInfo.getUserId()+orderInfo.getdContact()+orderInfo.getdMobile());
		//收
		UserOrderContact d_uoc = userOrderContactService.findByUuid(duuid);
		if(d_uoc == null){
			d_uoc = new UserOrderContact();
			d_uoc.setUserId(orderInfo.getUserId());
			d_uoc.setContact(orderInfo.getdContact());
			d_uoc.setMobile(orderInfo.getdMobile());
			d_uoc.setUuid(duuid);
			userOrderContactService.insert(d_uoc);
		}
	}


	/**
	 *  发送顺丰BSP
	  * @Title: sendSfBsp
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderInfo
	 */
	public void sendSfBsp(OrderInfo orderInfo){
		Date date = orderInfo.getSendSfUserTime();
		long diff = DateUtil.getDiffDaysForDay(orderInfo.getCreateTime(), date);
		if(diff > 3){
			LogCvt.info("3天外的订单添加到任务列中，暂时不发值顺丰，订单ID:"+orderInfo.getId());
		   Date dd = DateUtil.calDateOfDay(orderInfo.getSendSfUserTime(),-3);
		   Date delayTime = DateUtil.str2Date(DateUtil.formatDate(dd, DateUtil.DATE_FORMAT_01)+" 08:00:00",DateUtil.DATE_TIME_FORMAT_01);
			// 记录到任务列中
			OrderDelayTask task = new OrderDelayTask();
			task.setOrderId(orderInfo.getId());
			task.setReason("超约3天，延迟下单");
			task.setStatus(1);
			task.setDelayTime(delayTime);
			orderDelayTaskService.insert(task);
			return;
		}
		
		/**
		 * redis 队列处理发送顺丰和微信通知功能，走异步方式
		 * 发订单信息到顺丰接口
		 */
		String mqKey = RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_pay_sucess.getType());
		redisServer.lpush(mqKey, String.valueOf(orderInfo.getId()));
	}
	
	
	/**
	 *  更新VIP卡的使用状态
	  * @Title: checkVipOrder
	  * @Description: TODO
	  * @author: share 2017年1月4日
	  * @modify: share 2017年1月4日
	  * @param orderInfo
	 */
	private void checkVipOrder(OrderInfo orderInfo) {
		if(orderInfo.getIsVip()){
			VipInfo vipInfo = vipUserService.findById(orderInfo.getVipId());
			if(vipInfo == null){
				LogCvt.error("支付成功，获取VIP用户信息失败...");
				return;
			}
			
			if(!vipInfo.getUsedOrder()){
				vipInfo.setUsedOrder(true);
				vipUserService.updateUsedOrder(vipInfo);
			}
		}
	}
	
	/**
	 *   异步消息推送
	  * @Title: messageAndWeixinSend
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderInfo
	 */
	private void messageAndWeixinSend(OrderInfo orderInfo){
		String mqKey = RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_pay_message.getType());
		redisServer.lpush(mqKey, String.valueOf(orderInfo.getId()));
	}


	@Override
	public OrderCountVo orderCountByStatus(UserWeixin userweixin) {
		OrderCountVo vo = new OrderCountVo();
		vo.setUnpayCount(orderInfoService.findUnpayCountForWeiXin(userweixin.getId()));
		OrderCountDto dto = orderInfoService.findUnsignCountForWeiXin(userweixin.getId());
		if(Checker.isNotEmpty(dto)) {
			vo.setTransportCount(dto.getTransportCount());
			vo.setWaitCount(dto.getWaitCount());
			vo.setUnsignCount(dto.getTransportCount() + dto.getWaitCount());
		}
		return vo;
	}
	
	/**
	 * 
	 * saveActivityOffBook:(保存满减活动登记簿).
	 *
	 * @author huangyihao
	 * 2017年5月22日 下午4:40:33
	 * @param activitySubOrderNumberSet
	 * @param orderInfo
	 *
	 */
	private void saveActivityOffBook(Map<String, OrderActivity> activitySubOrderNumberSet ,OrderInfo orderInfo) {
		if(activitySubOrderNumberSet.containsKey(orderInfo.getNumber())){
			OrderActivity orderActivity = activitySubOrderNumberSet.get(orderInfo.getNumber());
			// 优惠订单登记簿
			if(orderActivity.getActivityId() > 0){
				OrderActivityBook orderActivityBook = new OrderActivityBook();
				orderActivityBook.setActivityId(orderActivity.getActivityId());
				orderActivityBook.setActivityName(orderActivity.getActivitName());
				orderActivityBook.setAmount(orderInfo.getAmount());
				orderActivityBook.setDiscount(orderInfo.getDiscount());
				orderActivityBook.setOrderId(orderInfo.getId());
				orderActivityBook.setStatus(1);
				orderActivityBook.setTotalAmount(orderInfo.getTotalAmount());
				orderActivityBook.setType(orderActivity.getActivityType());
				orderActivityBookService.insert(orderActivityBook);
			}
		}
	}
	
	/**
	 * 
	 * validCoupon:(优惠券校验).
	 *
	 * @author huangyihao
	 * 2017年5月22日 下午4:40:26
	 * @param coupon
	 * @param activity
	 * @param userId
	 * @param orderTotalAmount
	 * @return
	 *
	 */
	private double validCoupon(Coupon coupon, int userId, double orderTotalAmount){
		// 检查券号是否锁定
		String lockKey = RedisKeyUtil.Coupon_Pay_Lock_Redis_Key(coupon.getChildCode());
		int payExpireTime = 15 * 60;
		long flag  = redisServer.setnx(lockKey, String.valueOf(userId));
		if(flag == 1){
			redisServer.setex(lockKey, payExpireTime, String.valueOf(userId));
		}else{
			// 检查是否本人锁定定的券码
			int cacheUserId = Integer.parseInt(redisServer.get(lockKey));
			if(cacheUserId != userId){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券码已被他人锁定，在支付使用中");
			}
			// 重新刷新过期时间
			redisServer.setex(lockKey, payExpireTime, String.valueOf(userId));
		}
		//优惠券状态校验
		int status = coupon.getStatus() == 1 && DateUtil.getDiffDaysForDay(new Date(), coupon.getEndTime()) < 0 ? 3 : coupon.getStatus();
		if(status == 3){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券已失效");
		}else if(status != 1){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券码已被使用");
		}
		if(coupon.getLockStatus() != 0) {
			//throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "优惠券已被锁定，请在支付后再次使用");
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "在途订单签收后可使用");
		}
		if(DateUtil.getDiffDaysForDay(new Date(), coupon.getStartTime()) > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券无法提前使用");
		}
		//优惠券权限校验
		if(coupon.getUserId() > 0 && userId != coupon.getUserId()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无法使用他人领用券");
		}
		double childAmount = coupon.getChildAmount();
		double limitAmount = coupon.getLimitAmount();
		if(limitAmount >= orderTotalAmount){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"订单金额不满足此券使用");
		}
		// 优惠部分运费金额情况
		if(orderTotalAmount <= childAmount){
			childAmount = orderTotalAmount;
		}
		return childAmount;
	}
	
	/**
	 * 
	 * saveOrderCounpon:(登记订单消费券记录).
	 *
	 * @author huangyihao
	 * 2017年5月22日 下午4:57:58
	 * @param couponId
	 * @param coupon
	 * @param activity
	 * @param orderInfo
	 *
	 */
	private void saveOrderCounpon(int couponId, Coupon coupon, Activity activity, OrderInfo orderInfo, UserWeixin userWeixin) {
		if(Checker.isNotEmpty(orderInfo.getCouponCode())
				&& Checker.isNotEmpty(coupon)
				&& orderInfo.getCouponCode().equals(coupon.getChildCode())){
			// 登记订单消费券记录
			OrderCoupon orderCoupon = new OrderCoupon();
			orderCoupon.setActivityId(coupon.getActivityId());
			orderCoupon.setActivityName(activity.getName());
			orderCoupon.setAmount(orderInfo.getDiscount());
			orderCoupon.setBalance(0);
			orderCoupon.setCode(coupon.getChildCode());
			orderCoupon.setCouponId(coupon.getId());
			orderCoupon.setOrderId(orderInfo.getId());
			orderCoupon.setStatus(1);
			orderCoupon.setType(coupon.getType());
			orderCoupon.setUserId(orderInfo.getUserId());
			orderCoupon.setUserName(userWeixin.getNickname());
			orderCouponService.insert(orderCoupon);
		}
	}

	@Override
	public OrderDetailV2 userLastOrder(int userId) {
		OrderInfo info = orderInfoService.getUserLastOrder(userId);
		OrderDetailV2 detail = BeanUtil.a2b(info, OrderDetailV2.class);
		if(Checker.isNotEmpty(detail)){
			//获取地区的tree_id
			BaseSfArea jArea = baseSfAreaService.findById(detail.getjAreaId());
			detail.setjTreeId(Checker.isNotEmpty(jArea) ? jArea.getTreeId() : "");
			BaseSfArea dArea = baseSfAreaService.findById(detail.getdAreaId());
			detail.setdTreeId(Checker.isNotEmpty(dArea) ? dArea.getTreeId() : "");
			//获取个人地址标签
			if(detail.getjAddrType() == 4){
				UserAddress j_address = new UserAddress();
				j_address.setUserId(info.getUserId());
				j_address.setAreaId(detail.getjAreaId());
				j_address.setAddress(detail.getjAddress());
				j_address.setContact("");
				j_address.setMobile("");
				String juuid = SignCalculator.calUserAddressSign(j_address);
				UserAddress jAddress = userAddressService.findByUuid(juuid);
				detail.setjLabelType(Checker.isNotEmpty(jAddress) ? jAddress.getLabelType() : 3);
			}
			if(detail.getdAddrType() == 4){
				UserAddress d_address = new UserAddress();
				d_address.setUserId(info.getUserId());
				d_address.setAreaId(detail.getdAreaId());
				d_address.setAddress(detail.getdAddress());
				d_address.setContact("");
				d_address.setMobile("");
				String duuid = SignCalculator.calUserAddressSign(d_address);
				UserAddress dAddress = userAddressService.findByUuid(duuid);
				detail.setdLabelType(Checker.isNotEmpty(dAddress) ? dAddress.getLabelType() : 3);
			}
			if(detail.getdOutRangeType()>0){
				detail.setdIsOutRange(true);
			}
			if(detail.getjOutRangeType()>0){
				detail.setjIsOutRange(true);
			}
		}
		return detail;
	}
	
	/**
	 * 中奖业务实现
	 */
	public synchronized void reward(Orders bigOrder, UserWeixin userWinxin){
		//先查看当前是否有进行中的活动
		RewardActitvity ra = rewardService.findCurrentRewardActitvity();
		if(null != ra){
			String key = RedisKeyUtil.reward_actitvity_key(ra.getActitvityType(), ra.getId());
			Map<String, String> map = redisServer.getMap(key);
			int numerator = 0,denominator = 0;
			if(map == null|| map.keySet().size() == 0){
				map = new HashMap<String, String>();
				numerator = ra.getProbability();
				denominator = 10000;
			}else{
				numerator = Integer.parseInt(map.get("numerator"));
				denominator = Integer.parseInt(map.get("denominator"));
			}
			Random random = new Random();
			int value = random.nextInt(denominator);
			if(value < numerator){//中奖
				numerator--;
				Activity activity = activityService.findById(Integer.parseInt(ra.getPrize()));
				if(activity != null 
						&& DateUtil.getDiffDaysForDay(new Date(), activity.getStartTime()) <= 0 
						&& DateUtil.getDiffDaysForDay(new Date(), activity.getEndTime()) >= 0) {
					if(ra.getActitvityType() == 1 && activity.getType() == 1){ //限量现金券活动
						Coupon coupon = couponService.getCoupon(Integer.parseInt(ra.getPrize()));
						if(coupon != null){
							// 将此 奖券Code下的子奖券人绑定为该用户
							Coupon params = new Coupon();
							params.setCode(coupon.getCode());
							params.setUserId(bigOrder.getUserId());
							params.setOrderId(bigOrder.getId());
							params.setUserName(userWinxin.getNickname());
							couponService.bindCoupon(params);
							
							couponService.getCouponCodeByActivity(coupon.getActivityId(), coupon.getCode());
							
							WinnerList winnerList = new WinnerList();
							winnerList.setOrderId(bigOrder.getId());
							winnerList.setStatus(0);
							winnerList.setUserId(bigOrder.getUserId());
							winnerList.setUserInfo(userWinxin.getNickname());
							winnerList.setRewardActivityId(ra.getId());
							winnerList.setRewardActivityInfo(coupon.getCode());
							
							winnerListService.insert(winnerList);
						}
					}else if(ra.getActitvityType() == 1 && activity.getType() == 2) { //不限量现金券活动
						// 自动生成一张券
						Coupon coupon = new Coupon();
						coupon.setActivityId(activity.getId());
						String couponCode = commonService.createCouponCode();
						coupon.setCode(couponCode);
						coupon.setChildCode(couponCode);
						coupon.setType(1);//现金券
						coupon.setAmount(activity.getCouponAmount());
						coupon.setChildAmount(activity.getCouponAmount());
						coupon.setLimitAmount(activity.getCouponLimitAmount());
						Date nowDay = new Date();
						coupon.setStartTime(nowDay);
						coupon.setEndTime(DateUtils.addDays(nowDay, activity.getCouponLimitDay()));
						coupon.setStatus(1);//1-未使用
						coupon.setClaimType(1);//1-用户领取
						coupon.setClaimTime(nowDay);
						coupon.setUserId(bigOrder.getUserId());
						coupon.setUserName(userWinxin.getNickname());
						coupon.setOrderId(bigOrder.getId());
						coupon.setLockStatus(1);//1-锁定
						couponService.insert(coupon);
						
						WinnerList winnerList = new WinnerList();
						winnerList.setOrderId(bigOrder.getId());
						winnerList.setStatus(0);
						winnerList.setUserId(bigOrder.getUserId());
						winnerList.setUserInfo(userWinxin.getNickname());
						winnerList.setRewardActivityId(ra.getId());
						winnerList.setRewardActivityInfo(coupon.getCode());
						
						winnerListService.insert(winnerList);
					}
				}
				
			}
			denominator--;
			
			map.put("numerator", numerator+"");
			map.put("denominator", denominator+"");
			
			redisServer.putMap(key, map);
		}
		
	}

	@Override
	public Boolean isWinner(Integer orderId) {
		return couponService.isWinner(orderId);
	}
	
	@Override
	public OrderDetailV2 backOrder(String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		OrderDetailV2 detail = BeanUtil.a2b(orderInfo, OrderDetailV2.class);
		if(Checker.isNotEmpty(orderInfo)) {
			/**
			 * 寄件信息与收件信息调换
			 */
			detail.setjAreaId(orderInfo.getdAreaId());
			detail.setjTreePath(orderInfo.getdTreePath());
			detail.setjAddrType(orderInfo.getdAddrType());
			detail.setjAddrId(orderInfo.getdAddrId());
			detail.setjAddrName(orderInfo.getdAddrName());
			detail.setjAddress(orderInfo.getdAddress());
			detail.setjMobile(orderInfo.getdMobile());
			detail.setjContact(orderInfo.getdContact());
			detail.setjOutRangeType(orderInfo.getdOutRangeType());
			detail.setjOutRangePrice(orderInfo.getdOutRangePrice());
			detail.setjOutRangeTime(orderInfo.getdOutRangeTime());
			
			detail.setdAreaId(orderInfo.getjAreaId());
			detail.setdTreePath(orderInfo.getjTreePath());
			detail.setdAddrType(orderInfo.getjAddrType());
			detail.setdAddrId(orderInfo.getjAddrId());
			detail.setdAddrName(orderInfo.getjAddrName());
			detail.setdAddress(orderInfo.getjAddress());
			detail.setdMobile(orderInfo.getjMobile());
			detail.setdContact(orderInfo.getjContact());
			detail.setdOutRangeType(orderInfo.getjOutRangeType());
			detail.setdOutRangePrice(orderInfo.getjOutRangePrice());
			detail.setdOutRangeTime(orderInfo.getjOutRangeTime());
			
			//获取地区的tree_id
			BaseSfArea jArea = baseSfAreaService.findById(orderInfo.getjAreaId());
			detail.setdTreeId(Checker.isNotEmpty(jArea) ? jArea.getTreeId() : "");
			BaseSfArea dArea = baseSfAreaService.findById(orderInfo.getdAreaId());
			detail.setjTreeId(Checker.isNotEmpty(dArea) ? dArea.getTreeId() : "");
			
			//获取个人地址标签
			if(detail.getjAddrType() == 4){
				UserAddress j_address = new UserAddress();
				j_address.setUserId(orderInfo.getUserId());
				j_address.setAreaId(orderInfo.getjAreaId());
				j_address.setAddress(orderInfo.getjAddress());
				j_address.setContact("");
				j_address.setMobile("");
				String juuid = SignCalculator.calUserAddressSign(j_address);
				UserAddress jAddress = userAddressService.findByUuid(juuid);
				detail.setdLabelType(Checker.isNotEmpty(jAddress) ? jAddress.getLabelType() : 3);
			}
			if(detail.getdAddrType() == 4){
				UserAddress d_address = new UserAddress();
				d_address.setUserId(orderInfo.getUserId());
				d_address.setAreaId(orderInfo.getdAreaId());
				d_address.setAddress(orderInfo.getdAddress());
				d_address.setContact("");
				d_address.setMobile("");
				String duuid = SignCalculator.calUserAddressSign(d_address);
				UserAddress dAddress = userAddressService.findByUuid(duuid);
				detail.setjLabelType(Checker.isNotEmpty(dAddress) ? dAddress.getLabelType() : 3);
			}
			if(orderInfo.getdOutRangeType() > 0){
				detail.setjIsOutRange(true);
			}
			if(orderInfo.getjOutRangeType() > 0){
				detail.setdIsOutRange(true);
			}
		}
		return detail;
	}
}
