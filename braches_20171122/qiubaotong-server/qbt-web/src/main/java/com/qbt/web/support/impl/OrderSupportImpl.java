package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.bussiness.pojo.vip.VipOrderConfirmResponse;
import com.qbt.bussiness.support.EmailMsgSupport;
import com.qbt.bussiness.support.OrderCommonSupport;
import com.qbt.bussiness.support.SmsMsgSupport;
import com.qbt.bussiness.support.VipCommonSupport;
import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.enums.AddrTypeEnum;
import com.qbt.common.enums.ApplyTypeEnum;
import com.qbt.common.enums.BigOrderPayStatus;
import com.qbt.common.enums.BigOrderStatus;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.ExceptionTypeEnum;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.enums.LanguagesEnum;
import com.qbt.common.enums.MqTypeEnum;
import com.qbt.common.enums.OrderOperateTypeEnum;
import com.qbt.common.enums.OrderSource;
import com.qbt.common.enums.OrderStatus;
import com.qbt.common.enums.QuestionStatus;
import com.qbt.common.enums.RefundStatus;
import com.qbt.common.enums.SettlementStatusEnum;
import com.qbt.common.enums.SfBpsStatus;
import com.qbt.common.enums.SysConfigEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Paging;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.Md5;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.email.EmailService;
import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.entity.BasePartnerLanguage;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.OrderActivityBook;
import com.qbt.persistent.entity.OrderComment;
import com.qbt.persistent.entity.OrderCoupon;
import com.qbt.persistent.entity.OrderDelayTask;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.OrderSettlement;
import com.qbt.persistent.entity.OrderWaybill;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.entity.OutRangeAddress;
import com.qbt.persistent.entity.SaleOrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserAssistantFee;
import com.qbt.persistent.entity.UserContact;
import com.qbt.persistent.entity.UserOrderContact;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.redis.RedisService;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.ActivityOffService;
import com.qbt.service.ActivityService;
import com.qbt.service.BagCodeOrderService;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BasePartnerLanguageService;
import com.qbt.service.BasePartnerService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfPriceService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.service.CommonService;
import com.qbt.service.CouponService;
import com.qbt.service.OrderActivityBookService;
import com.qbt.service.OrderCommentService;
import com.qbt.service.OrderCouponService;
import com.qbt.service.OrderDelayTaskService;
import com.qbt.service.OrderExceptionBookService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrderPayInfoService;
import com.qbt.service.OrderRefundService;
import com.qbt.service.OrderSettlementService;
import com.qbt.service.OrderWaybillService;
import com.qbt.service.OrdersService;
import com.qbt.service.OutRangeAddressService;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.UserAsApService;
import com.qbt.service.UserAssistantFeeService;
import com.qbt.service.UserAssistantService;
import com.qbt.service.UserContactService;
import com.qbt.service.UserKfService;
import com.qbt.service.UserOrderContactService;
import com.qbt.service.UserProxyService;
import com.qbt.service.UserWeixinService;
import com.qbt.service.VipTypeService;
import com.qbt.service.VipUserService;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.sms.api.service.SmsSendService;
import com.qbt.web.pojo.activity.ActivityOrderRequest;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.pojo.assistant.AssistantDelivery;
import com.qbt.web.pojo.assistant.AssistantOrder;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.CommentRequest;
import com.qbt.web.pojo.order.HistoryOrderAddressVo;
import com.qbt.web.pojo.order.OfficialOrderConfirm;
import com.qbt.web.pojo.order.OrderCommentInfo;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.pojo.order.OrderDetailWaybill;
import com.qbt.web.pojo.order.OrderPageRequest;
import com.qbt.web.pojo.sf.WayBill;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.AreaSupport;
import com.qbt.web.support.InsureTemplateSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.SfExpressSupport;
import com.qbt.web.support.SysConfigSupport;
import com.qbt.web.support.UrgentSupport;
import com.qbt.web.support.VipInfoSupport;
import com.qbt.wechat.api.WechatApi;

/**
 *  订单管理
  * @ClassName: OrderSupportImpl
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
@Service
public class OrderSupportImpl implements OrderSupport {

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
	private RedisService redisServer;
	@Resource
	private OrderOperateLogService orderOperateLogService;
	@Resource
	private UserWeixinService userWeixinService;
	@Resource
	private OrderDelayTaskService orderDelayTaskService;
	@Resource
	private WechatCommonSupport commonSupport;
	@Resource
	private WechatApi wechatApi;
	@Resource
	private OrderExceptionBookService orderExceptionBookService;
	@Resource
	private OrderRefundService orderRefundService;
	@Resource
	private UserKfService userKfService;
	@Resource
	private SmsSendService smsSendService;
	@Resource
	private UserAssistantService userAssistantService;
	@Resource
	private UserAssistantFeeService userAssistantFeeService;
	@Resource
	private CouponService couponService;
	@Resource
	private SfExpressSupport sfExpressSupport;
	@Resource
	private OrderCouponService orderCouponService;
	@Resource
	private ActivityService activityService;
	@Resource
	private OrderCommentService orderCommentService;
	@Resource
	private FileuploadScpService fileuploadScpService;
	@Resource
	private EmailService emailService;
	@Resource
	private ActivityOffService activityOffService;
	@Resource
	private OrderActivityBookService orderActivityBookService;
	@Resource
	private ActivitySupport activitySupport;
	@Resource
	private UserAsApService userAsApService;
	@Resource
	private BasePartnerService basePartnerService;
	@Resource
	private BasePartnerLanguageService basePartnerLanguageService;
	@Resource
	private OrderSettlementService orderSettlementService;
	@Resource
	private OrderPayInfoService orderPayInfoService;
	@Resource
	private UserContactService userContactService;
	@Resource
	private  VipTypeService vipTypeService;
	@Resource
	private  VipUserService vipUserService;
	@Resource
	private OrderWaybillService orderWaybillService;
	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	@Resource
	private SaleUserService saleUserService;
	@Resource
	private VipInfoSupport vipInfoSupport;
	@Resource
	private UserProxyService userProxyService;
	@Resource
	private SmsCodeService smsCodeService;
	@Resource
	private UserOrderContactService userOrderContactService;
	@Resource
	private OutRangeAddressService outRangeAddressService;
	@Resource
	private SmsMsgSupport smsMessageSupport;
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	@Resource
	private EmailMsgSupport emailMsgSupport;
	@Resource
	private OrderCommonSupport orderCommonSupport;
	@Resource
	private BagCodeOrderService bagCodeOrderService;
	@Resource
	private VipCommonSupport vipCommonSupport;
	
	@Resource
	private SysConfigSupport sysConfigSupport;
	
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
		/**
		 * 业务订单校验
		 */
		// 预约取包时间校验
		String timeSection = orderConfirm.getConsigned_time();
		Date consignedTime = DateUtil.str2Date(timeSection.substring(0,16)+":00", DateUtil.DATE_TIME_FORMAT_01);
		if(consignedTime.getTime() < System.currentTimeMillis()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包时间已失效");
		}
		if(orderConfirm.getSrc_area_id() == orderConfirm.getDest_area_id() && orderConfirm.getSrc_address().equals(orderConfirm.getDest_address())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包和送包地址不能相同");
		}
		/**
		 *  订单价格校验
		 */
		// 顺丰速运价格计算
		if(orderConfirm.getSrc_type() == 1){
			orderConfirm.setSrc_course_id(orderConfirm.getSrc_id());
		}
		if(orderConfirm.getDest_type() == 1){
			orderConfirm.setDest_course_id(orderConfirm.getDest_id());
		}
		double sfPrice = sfExpressSupport.query_sf_expect_price_v2(orderConfirm);
		// 保价金额
		Double insureRate = null;
		BaseInsuredTemplate template = insureTemplateSupport.findValid();
		double insurePrice = insureTemplateSupport.insureValidPrice(orderConfirm.getInsure_price(), 1);
		insureRate = template.getInsuredRates().doubleValue();
		double totalPrice = Arith.add(sfPrice, insurePrice);
		LogCvt.info("保价金额："+insurePrice+",总金额:"+totalPrice);
		if(totalPrice != orderConfirm.getPrice() || totalPrice <= 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"订单金额无效");
		}
		//时效校验
		String deliverDate = orderConfirm.getDeliver_time();
		if(consignedTime.getTime() > DateUtil.str2Date(deliverDate, DateUtil.DATE_TIME_FORMAT_01).getTime()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "取件时间不能大于到达时间");
		}
		/**
		 * 订单信息组装
		 */
		// 1-course球场，2-airport机场,3-bank银行,5-顺丰网店
		int srcType = orderConfirm.getSrc_type();
		int srcId = orderConfirm.getSrc_id();
		String jAddrName = "",dAddrName = "";
		jAddrName = getAddrName(srcType, srcId);
		int destType = orderConfirm.getDest_type();
		int destId = orderConfirm.getDest_id();
		dAddrName = getAddrName(destType, destId);
		// 订单信息
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setProxySelfUserId(orderConfirm.getProxySelfUserId());
		orderInfo.setProxyUserId(orderConfirm.getProxyUserId());
		orderInfo.setUserId(orderConfirm.getUserId());
		orderInfo.setAmount(0d);
		orderInfo.setTotalAmount(totalPrice);
		orderInfo.setOrderStatus(OrderStatus.un_pay.getCode());
		orderInfo.setRefundStatus(RefundStatus.refund_normal.getCode());
		orderInfo.setDeliveryStatus(DeliveryStatus.un_send_sf.getCode());
		orderInfo.setBpsStatus(SfBpsStatus.un_send.getCode());
		orderInfo.setQuestionStatus(QuestionStatus.normal.getCode());
		orderInfo.setOrderSource(OrderSource.weixin.getCode());
		orderInfo.setSendSfUserTime(consignedTime);
		orderInfo.setFreight(sfPrice);
		orderInfo.setInsuredFee(insurePrice);
		orderInfo.setInsuredRates(insureRate);
		orderInfo.setInsuredValue((double)orderConfirm.getInsure_price());
		orderInfo.setExpressType(orderConfirm.getBusiness_type());
		orderInfo.setIsHandleQuestion(true);
		orderInfo.setDeliverDate(deliverDate);
		orderInfo.setSendTimeSection(orderConfirm.getConsigned_time());
		orderInfo.setDiscount(0d);
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
		orderInfo.setRemark("");
		orderInfo.setOpenid(orderConfirm.getOpenid());
		orderInfo.setInputDiscount(0d);
		orderInfo.setPlayTime(orderConfirm.getPlayTime());
		// thrid info
		UserAssistantApply apply = userAsApService.findPartnerByUserId(orderInfo.getUserId(), ApplyTypeEnum.partner.getCode());
		if(apply == null){
			orderInfo.setThirdType(1);
			orderInfo.setThirdId(0);
			// 微信支付：客服收款：无需收款。财务收款：是。
			orderInfo.setKfReceivableStatus(0);
			orderInfo.setCwReceivableStatus(1);
		}else{
			orderInfo.setThirdType(2);
			orderInfo.setThirdId(apply.getApplyId());
			orderInfo.setThirdName(apply.getApplyName());
			orderInfo.setAssistantName(apply.getName());
			// 合作社待下单：客服收款：否，财务收款：否。
			orderInfo.setKfReceivableStatus(2);
			orderInfo.setCwReceivableStatus(2);
		}
		// 偏远寄件信息
		BaseCourse jCourse = baseCourseService.findById(orderInfo.getjAddrId());
		BaseCourse dCourse = baseCourseService.findById(orderInfo.getdAddrId());
		OutRangeAddress jAddress = outRangeAddressService.findByAreaId(orderInfo.getjAreaId(), orderInfo.getjAddress());
		OutRangeAddress dAddress = outRangeAddressService.findByAreaId(orderInfo.getdAreaId(), orderInfo.getdAddress());;
		if(orderInfo.getjAddrType() == AddrTypeEnum.address.getType() && Checker.isNotEmpty(jAddress)) {
			orderInfo.setjOutRangeType(4);
			orderInfo.setjOutRangeTime(jAddress.getOutRangeTime());
			orderInfo.setjOutRangePrice(jAddress.getOutRangePrice());
		}else if(orderInfo.getjAddrType() == AddrTypeEnum.course.getType() && Checker.isNotEmpty(jCourse)){
			orderInfo.setjOutRangeType(jCourse.getIsOutRange() ? 1 :0);
			orderInfo.setjOutRangeTime(jCourse.getOutRangeTime());
			orderInfo.setjOutRangePrice(jCourse.getOutRangePrice());
		}else{
			orderInfo.setjOutRangeType(0);
			orderInfo.setjOutRangeTime(0d);
			orderInfo.setjOutRangePrice(0d);
		}
		
		// 偏远收件信息
		if(orderInfo.getdAddrType() == AddrTypeEnum.address.getType() && Checker.isNotEmpty(dAddress)) {
			orderInfo.setdOutRangeType(4);
			orderInfo.setdOutRangeTime(dAddress.getOutRangeTime());
			orderInfo.setdOutRangePrice(dAddress.getOutRangePrice());
		}else if(orderInfo.getdAddrType() == AddrTypeEnum.course.getType() && Checker.isNotEmpty(dCourse)){
			orderInfo.setdOutRangeType(dCourse.getIsOutRange() ? 1 : 0);
			orderInfo.setdOutRangeTime(dCourse.getOutRangeTime());
			orderInfo.setdOutRangePrice(dCourse.getOutRangePrice());
		}else{
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
		order.setQuantity(orderConfirm.getQuantity());
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
		orderInfoService.inser(orderInfo);
		
		// 添加客户信息
		saveUserContact(orderInfo, 0);
		
		for(int i = 1 ; i < order.getQuantity(); i++){
			orderInfo.setNumber(commonService.createOrderId());
			orderInfo.setOrderId(orderId);
			orderInfo.setOrderNumber(order.getNumber());
			orderInfo.setMd5(uuid);
			orderInfoService.inser(orderInfo);
			/**
			 * 记录订单日志
			 */
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("下单");
			log.setDescription(apply !=null ?apply.getApplyName()+"助理下单":"客户下单");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName(orderConfirm.getUserName());
			log.setOperatorType(OrderOperateTypeEnum.weixin_user.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
		}
		
		/**
		 * 若是代理下推清单，微信通知
		 */
		 if(orderConfirm.getCreate_method() == 3){
			 UserProxy userProxy = userProxyService.findByUserId(orderConfirm.getProxyUserId(), orderConfirm.getUserId());
			 wechatMessageSupport.proxyOrderNotify(orderInfo, userProxy, orderConfirm.getProxyOpenid(), "");
			 
			 Map<String,String> replaceMap = new HashMap<String,String>();
			 replaceMap.put("html", "order.html#!/mpay/"+order.getNumber());
			 replaceMap.put("uid", "0");
			 String url = wechatApi.getAuthUrl(replaceMap);
			 wechatMessageSupport.proxyAddOrderNotify(orderInfo, orderConfirm.getOpenid(), url);
		 }
		
		return order.getNumber();
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
	 *  订单详情
	  * @Title: orderDetail
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param id
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.OrderSupport#orderDetail(java.lang.Integer, java.lang.String)
	 */
	@Override
	public OrderDetail orderDetail(int userId, String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		/**
		 * 检查订单是否此用户
		 */
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息不存在");
		}
		
		int thridId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
		String[] partnerLangs = null;
		// 检查是否本人订单或该合作社下订单
		if(thridId > 0){
			// thrid info
			UserAssistantApply apply = userAsApService.findPartnerByUserId(orderInfo.getUserId(), ApplyTypeEnum.partner.getCode());
//			if(apply == null || apply.getApplyId().intValue() != thridId){
//				result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
//				result.setMsg("订单信息无权查看");
//				return result;
//			}
			if(orderInfo.getOrderStatus() == 1){
				List<BasePartnerLanguage> languageList = basePartnerLanguageService.listByPartnerlId(apply.getApplyId());
				partnerLangs = new String[languageList.size()];
				for( int i = 0 ; i < languageList.size(); i++){
					BasePartnerLanguage lang = languageList.get(i);
					partnerLangs[i] = lang.getEname()+":"+lang.getName();
				}
			}
		}
//		else if(orderInfo.getUserId().intValue() != userId){
//			result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
//			result.setMsg("订单信息无权查看");
//			return result;
//		}
		
		OrderDetail detail = getOrderDetail(orderInfo);
		if(thridId > 0){
			detail.setPartnerOrder(true);
			detail.setPartnerLangs(partnerLangs);
		}
		
		return detail;
	}
	
	/**
	 *  球包助理查看订单详情
	  * @Title: orderDetail
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param applyId
	  * @param applyType
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.OrderSupport#orderDetail(int, int, java.lang.String)
	 */
	@Override
	public OrderDetail orderDetail(int applyId, int applyType, String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		/**
		 * 检查订单是否此次球包助理能查看
		 */
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息不存在");
		}
		if(orderInfo.getdAddrId() != applyId && orderInfo.getdAddrType() != applyType){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息无权查看");
		}
		
		OrderDetail detail = getOrderDetail(orderInfo);
		return detail;
	}

	/**
	 *  订单详情组装
	  * @Title: getOrderDetail
	  * @Description: TODO
	  * @author: share 2016年8月19日
	  * @modify: share 2016年8月19日
	  * @param orderInfo
	  * @return
	 */
	private OrderDetail getOrderDetail(OrderInfo orderInfo) {
		OrderDetail detail = new OrderDetail();
		detail.setAmount(orderInfo.getAmount());
		detail.setBusnissType(orderInfo.getExpressType());
		detail.setCreateTime(orderInfo.getCreateTime().getTime());
		detail.setDeliverTime(orderInfo.getDeliverDate());
		detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
		detail.setDiscount(orderInfo.getDiscount());
		detail.setjMobile(orderInfo.getjMobile());
		detail.setjUserName(orderInfo.getjContact());
		if(orderInfo.getjAddrType() == 4){
			detail.setjAddressName(orderInfo.getjAddress());
		}else{
			detail.setjAddressName(orderInfo.getjAddrName());
		}
		detail.setjAddrId(orderInfo.getjAddrId());
		detail.setjCityName(orderInfo.getjTreePath());
		detail.setjAreaId(orderInfo.getjAreaId());
		detail.setjAddrType(orderInfo.getjAddrType());
		detail.setjAddress(orderInfo.getjAddress());
		
		detail.setdMobile(orderInfo.getdMobile());
		detail.setdUserName(orderInfo.getdContact());
		if(orderInfo.getdAddrType() == 4){
			detail.setdAddressName(orderInfo.getdAddress());
		}else{
			detail.setdAddressName(orderInfo.getdAddrName());
		}
		detail.setdAddrId(orderInfo.getdAddrId());
		detail.setdCityName(orderInfo.getdTreePath());
		detail.setdAreaId(orderInfo.getdAreaId());
		detail.setdAddrType(orderInfo.getdAddrType());
		detail.setdAddress(orderInfo.getdAddress());
		detail.setFreight(orderInfo.getFreight());
		detail.setMailNo(orderInfo.getMailNo());
		detail.setNumber(orderInfo.getNumber());
		detail.setOrderStatus(orderInfo.getOrderStatus());
		detail.setPayId(orderInfo.getPayId());
		detail.setPayTime(orderInfo.getPayTime());
		detail.setRefundStatus(orderInfo.getRefundStatus());
		detail.setSendTimeSection(orderInfo.getSendTimeSection());
		detail.setTotalAmount(orderInfo.getTotalAmount());
		detail.setInsureFee(orderInfo.getInsuredFee()==null?0:orderInfo.getInsuredFee());
		detail.setInsureValue(orderInfo.getInsuredValue()==null?0:orderInfo.getInsuredValue());
		detail.setComment(orderInfo.getIsComment()==null?false:orderInfo.getIsComment());
		detail.setRemark(orderInfo.getRemark());
		detail.setLangName(LanguagesEnum.getByCode(orderInfo.getLangEname()));
		detail.setVipOrder(orderInfo.getIsVip());
		detail.setPlayTime(orderInfo.getPlayTime());
		
		double jOutRangeAmout = orderInfo.getjOutRangePrice() == null?0:orderInfo.getjOutRangePrice();
		double dOutRangeAmout = orderInfo.getdOutRangePrice() == null?0:orderInfo.getdOutRangePrice();
		detail.setOutRangeAmount(Arith.add(jOutRangeAmout, dOutRangeAmout));
		detail.setjOutRangeType(orderInfo.getjOutRangeType());
		detail.setdOutRangeType(orderInfo.getdOutRangeType());
		if(orderInfo.getjOutRangeType()!=0){
			detail.setjOutRangePrice(orderInfo.getjOutRangePrice());
			detail.setjIsOutRange(true);
		}
		
		if(orderInfo.getdOutRangeType()!=0){
			detail.setdOutRangePrice(orderInfo.getdOutRangePrice());
			detail.setdIsOutRange(true);
		}
		
		double originInsuredFee = insureTemplateSupport.insureValidPrice(detail.getInsureValue(), 2);
		detail.setDiscountInsuredFee(originInsuredFee - detail.getInsureFee());
		
		if(orderInfo.getIsOrg()){
			detail.setDiscountType(3);
		}
		
		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			detail.setExpressDescribe("预计"+days+"天后送达");
		}
		
		return detail;
	}
	
	
	/**
	 *  订单列表查询
	  * @Title: orderList
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param userId
	  * @return
	  * @see com.qbt.web.support.OrderSupport#orderList(int)
	 */
	@Override
	public List<OrderDetail> orderList(OrderPageRequest order) {
		List<OrderDetail> result = new ArrayList<OrderDetail>();
		int pageNo = order.getPageNo();
		int pageSize = order.getPageSize();
		int lastRecordId = order.getLastRecordId();
		int userId = order.getUserId();
		int orderStatus = order.getOrderStatus();
		int lastRownum  = order.getLastRownum();
		Integer proxyUserId = null;
		if(order.getProxyUserId().equals(0)){
			proxyUserId=order.getProxyUserId();
		}else{
			proxyUserId = order.getUserId();
		}
		
		OrderPageDto pageDto = new OrderPageDto();
		pageDto.setLastRecordId(lastRecordId);
		pageDto.setOrderStatus(orderStatus);
		pageDto.setPageNo(pageNo);
		pageDto.setPageSize(pageSize);
		pageDto.setUserId(userId);
		pageDto.setProxyUserId(proxyUserId);
		pageDto.setLastRownum(lastRownum);
		
		List<OrderInfo> orderInfoList = orderInfoService.findByUserIdForWeiXin(pageDto);
		order.setHasNext(orderInfoList.size() == pageSize);
		for(OrderInfo orderInfo : orderInfoList){
			OrderDetail detail = new OrderDetail();
			detail.setId(orderInfo.getId());
			detail.setCreateTime(orderInfo.getCreateTime().getTime());
			detail.setjMobile(orderInfo.getjMobile());
			detail.setjUserName(orderInfo.getjContact());
			detail.setjAddrType(orderInfo.getjAddrType());
			if(orderInfo.getjAddrType() == 4){
				detail.setjAddressName(orderInfo.getjAddress());
			}else{
				detail.setjAddressName(orderInfo.getjAddrName());
			}
			detail.setjCityName(orderInfo.getjTreePath());
			detail.setdMobile(orderInfo.getdMobile());
			detail.setdUserName(orderInfo.getdContact());
			detail.setdAddrType(orderInfo.getdAddrType());
			if(orderInfo.getdAddrType() == AddrTypeEnum.address.getType()){
				detail.setdAddressName(orderInfo.getdAddress());
			}else{
				detail.setdAddressName(orderInfo.getdAddrName());
			}
			detail.setdCityName(orderInfo.getdTreePath());
			detail.setNumber(orderInfo.getNumber());
			detail.setOrderStatus(orderInfo.getOrderStatus());
			detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
			detail.setSendTimeSection(orderInfo.getSendTimeSection());
			detail.setComment(orderInfo.getIsComment() == null ? false : orderInfo.getIsComment());
			detail.setRownum(orderInfo.getRownum());
			//下单后至取件4个小时前显示“取消”，离取件时间还有4小时时，隐藏“取消”功能。
			boolean flag = DateUtils.addHours(orderInfo.getSendSfUserTime(), -4).after(new Date());
			if(orderInfo.getOrderStatus() == OrderStatus.pay_succ.getCode() 
					&& orderInfo.getDeliveryStatus() <= DeliveryStatus.wait_sf_recive.getCode()
					&& flag) {
				detail.setCancelAble(true);
			}
			if(DateUtil.getDiffDaysForDay(orderInfo.getSendSfUserTime(), new Date()) == 0) {
				detail.setIsCurrent(true);
			}
			detail.setIsConfirmReceive(orderInfo.getIsConfirmReceive());
			detail.setIsDrawedBill(orderInfo.getIsDrawedBill());
			
			
			result.add(detail);
		}
		return result;
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
			if(bigOrder.getOrderSource().intValue() == OrderSource.pc_online.getCode().intValue()){
				pxPaySuccess(payment);
				return;
			}
			bigOrder.setPayMethod(payment.getPayMethod());
			bigOrder.setPayStatus(BigOrderPayStatus.paid.getCode());
			bigOrder.setPayTime(new Date());
			ordersService.update(bigOrder);
			
			List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(bigOrder.getNumber());
			// 参与满减的子订单信息
			List<OrderActivity> activityList = activitySupport.getCachePayOrderActivity(bigOrder.getId());
			// 或
			String redisKey = RedisKeyUtil.pay_vip_order_suborder_key(bigOrder.getId());
			String value = commonService.getLockValue(redisKey);
			commonService.unlock(redisKey);
			List<String> vipOrderIds = new ArrayList<String>();
			List<Integer> vipIds = new ArrayList<Integer>();
			if(Checker.isNotEmpty(value)){
				String[] values = value.split("_");
				vipOrderIds = JSonUtil.toObject(values[0], List.class);
				vipIds = JSonUtil.toObject(values[1], List.class);
			}
			
			Map<String,OrderActivity> activitySubOrderNumberSet = new HashMap<String,OrderActivity>();
			for(OrderActivity activity : activityList){
				activitySubOrderNumberSet.put(activity.getOrderId(),activity);
			}
			// 使用优惠券的情况
			int couponId = payment.getCouponId();
			String couponCode = payment.getCouponCode();
			Coupon coupon = null;
			Activity activity = null;
			Map<String,Double> couponDiscountMap = null;
			if(couponId > 0 && couponCode != null && couponCode.length() == 8){
				coupon = couponService.findById(payment.getCouponId());
				activity = activityService.findById(coupon.getActivityId());
				couponDiscountMap = clacCouponDiscout(subOrderList, activitySubOrderNumberSet, coupon,vipOrderIds);
			}
			
			/**
			 *  修改子订单
			 */
			UserWeixin userWeixin = userWeixinService.findByOpenId(bigOrder.getOpenId());
			for(OrderInfo orderInfo : subOrderList){
				if(orderInfo.getOrderStatus().intValue() != OrderStatus.un_pay.getCode().intValue()){
					LogCvt.info("子订单已非待支付状态，支付成功的订单不处理此记录，ID:"+orderInfo.getId()+",number:"+orderInfo.getNumber());
					continue;
				}
				//检查是否首单
				long count = orderInfoService.orderCount(orderInfo);
				if(count == 1){
					orderInfo.setFirstOrder(true);
				}
				orderInfo.setAmount(orderInfo.getTotalAmount());
				orderInfo.setOrderStatus(OrderStatus.pay_succ.getCode());
				orderInfo.setDiscount(0d);
				orderInfo.setPayId(payment.getId());
				orderInfo.setPayTime(payment.getCreateTime());
				// 是否VIP订单
				if(vipOrderIds.contains(orderInfo.getNumber())){
					
					VipInfo vipInfo = vipUserService.findById(vipIds.get(vipOrderIds.indexOf(orderInfo.getNumber())));
					double sfPrice = orderInfo.getFreight();
					double vipOrderAmount = vipInfo.getOrderAmount().doubleValue();
					double outRangePrice = Arith.add(orderInfo.getjOutRangePrice(),orderInfo.getdOutRangePrice());
					double vipDiscount =  sfPrice < vipOrderAmount?0:Arith.sub(Arith.sub(sfPrice, vipOrderAmount),outRangePrice);
					
					double vipTotalPrice = Arith.add(vipOrderAmount, orderInfo.getInsuredFee());
					vipTotalPrice = Arith.add(vipTotalPrice, outRangePrice);
					orderInfo.setAmount(vipTotalPrice);
					orderInfo.setDiscount(vipDiscount);
					if(vipDiscount==0){
						orderInfo.setFavorableDesc("");
						orderInfo.setVipId(0);
						orderInfo.setIsVip(false);
					}else{
						orderInfo.setFavorableDesc("会员卡订单");
						orderInfo.setVipId(vipInfo.getId());
						orderInfo.setIsVip(true);
					}
				}
				// 登记满减记录
				saveActivityOffBook(activitySubOrderNumberSet, orderInfo);
				// 登记订单使用券表记录
				saveOrderCounpon(couponId, couponCode, coupon, activity, couponDiscountMap, orderInfo, userWeixin);
				// 修改子订单状态
				orderInfoService.updateById(orderInfo);
				//代下单支付，订单跑到客户头上
				if(orderInfo.getProxySelfUserId() >0 && !orderInfo.getUserId().equals(orderInfo.getProxySelfUserId())){
					orderInfoService.updateByProxUserId(orderInfo);
				}
				// 如果是合作方免支付下单，添加结算记录
				saveSettlement(orderInfo, payment.getPayAmount());
				// 添加客户信息
				saveUserContact(orderInfo, 1);
				// 检查订单预约取包时间是否在3天内，发送BSP
				sendSfBsp(orderInfo);
				// 是否VIP订单,会员卡设置为已使用
				checkVipOrder(orderInfo);
				// 登记二维码销售人员业务数据
				saleOrderInfo(orderInfo);
			    //添加历史联系人
				addUserOrderContact(orderInfo);
				
			}
			
			// 短信消息发送
			for(OrderInfo orderInfo : subOrderList){
				messageAndWeixinSend(orderInfo);
			}
			/**
			 * 设置优惠券为已使用
			 */
			if( couponId > 0 && payment.getCouponCode() != null && payment.getCouponCode().length() == 8){
				coupon.setUserId(bigOrder.getUserId());
				coupon.setUserName(userWeixin.getNickname());
				coupon.setStatus(2);
				if(coupon.getClaimType() == 0){
					coupon.setClaimType(1);
				}
				couponService.updateById(coupon);
			}
			
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 添加历史联系人
	 * @param orderInfo
	 * * @author: wuwang 2017年6月27日
	  * @modify: wuwang 2017年6月27日
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
	 *  订单支付成功
	  * @Title: paySuccess
	  * @Description: TODO
	  * @author: share 2016年8月15日
	  * @modify: share 2016年8月15日
	  * @param payment
	  * @see com.qbt.web.support.OrderSupport#paySuccess(com.qbt.persistent.entity.OrderPayInfo)
	 */
	public void pxPaySuccess(OrderPayInfo payment) {
		try {
			/**
			 * 修改订单信息
			 */
			Orders bigOrder = ordersService.findById(payment.getOrderId());
			bigOrder.setPayMethod(payment.getPayMethod());
			bigOrder.setPayStatus(BigOrderPayStatus.paid.getCode());
			bigOrder.setPayTime(new Date());
			ordersService.update(bigOrder);
			
			UserWeixin user = userWeixinService.findByOpenId(bigOrder.getOpenId());
			List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(bigOrder.getNumber());
			 /*
			  *  修改子订单
			 */
			for(OrderInfo orderInfo : subOrderList){
				if(orderInfo.getOrderStatus().intValue() != OrderStatus.un_pay.getCode().intValue()){
					LogCvt.info("子订单已非待支付状态，支付成功的订单不处理此记录，ID:"+orderInfo.getId()+",number:"+orderInfo.getNumber());
					continue;
				}
				//检查是否首单
				long count = orderInfoService.orderCount(orderInfo);
				if(count == 1){
					orderInfo.setFirstOrder(true);
				}
				orderInfo.setOrderStatus(OrderStatus.pay_succ.getCode());
				orderInfo.setPayId(payment.getId());
				orderInfo.setPayTime(payment.getCreateTime());
				// 修改子订单状态
				orderInfoService.updateById(orderInfo);
				// 添加客户信息
				saveUserContact(orderInfo, 1);
				// 检查订单预约取包时间是否在3天内，发送BSP
				sendSfBsp(orderInfo);
				// 是否VIP订单,会员卡设置为已使用
				checkVipOrder(orderInfo);
				// 登记二维码销售人员业务数据
				saleOrderInfo(orderInfo);
			}
			
			// 更新订单为此用户
			ordersService.updateUserId(payment.getOrderId(), user.getId(), user.getOpenid());
			orderInfoService.updateUserId(payment.getOrderId(), user.getId(), user.getOpenid());
			
			// 短信消息发送
			for(OrderInfo orderInfo : subOrderList){
				messageAndWeixinSend(orderInfo);
			}
			
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
	}

	/**
	 *  登记销售人员订单销售提成记录
	  * @Title: saleOrderInfo
	  * @Description: TODO
	  * @author: share 2017年2月7日
	  * @modify: share 2017年2月7日
	  * @param orderInfo
	 */
	private void saleOrderInfo(OrderInfo orderInfo) {
		try {
			LogCvt.info("用户下单销售提成");
			Integer proxyUserId = orderInfo.getProxyUserId();
			UserWeixin weixin = userWeixinService.findById(orderInfo.getUserId());
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
				if(orderDayType == 2 && weixin.getSubscribeTime() != null){
					Date subscripeDate = DateUtil.str2Date(DateUtil.formatDate(weixin.getSubscribeTime(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01);
					subscripeDate = DateUtil.calDateOfDay(subscripeDate, saleUser.getOrderDayValue() - 1);
					long nowDayTime = DateUtil.str2Date(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01).getTime();
					matchDay = subscripeDate.getTime() - nowDayTime >=0;
				}
				if(orderInfo.getFirstOrder() && (orderDayType == 1 || matchDay)){
					int ftype = saleUser.getFirstType(); // 1-固定金额 2-按订单金额比例
					if(ftype == 1){
						saleOrderInfo.setAmount(saleUser.getFirstTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getFirstTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(ftype);
				}else{
					if(type == 1){
						saleOrderInfo.setAmount(saleUser.getTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setType(type);
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
				int type = saleUser.getType(); // 1-固定金额 2-按订单金额比例
				int orderDayType = saleUser.getOrderDayType(); // 1-不限 2-有限
				// 检查是否为规定期内的首单
				boolean matchDay = false;
				if(orderDayType == 2){
					Date subscripeDate = DateUtil.str2Date(DateUtil.formatDate(weixin.getSubscribeTime(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01);
					subscripeDate = DateUtil.calDateOfDay(subscripeDate, saleUser.getOrderDayValue() - 1);
					long nowDayTime = DateUtil.str2Date(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_01), DateUtil.DATE_FORMAT_01).getTime();
					matchDay = subscripeDate.getTime() - nowDayTime >=0;
				}
				if(orderInfo.getFirstOrder() && (orderDayType == 1 || matchDay)){
					SaleOrderInfo saleOrderInfo = new SaleOrderInfo();
					int ftype = saleUser.getFirstType(); // 1-固定金额 2-按订单金额比例
					if(ftype == 1){
						saleOrderInfo.setAmount(saleUser.getFirstTypeValue());
					}else{
						saleOrderInfo.setAmount(Arith.round(Arith.mul(Arith.div(saleUser.getFirstTypeValue(), 100,4),orderInfo.getAmount()),2));
					}
					saleOrderInfo.setOrderAmount(orderInfo.getAmount());
					saleOrderInfo.setOrderId(orderInfo.getId());
					saleOrderInfo.setOrderTime(orderInfo.getCreateTime());
					saleOrderInfo.setSaleId(saleUser.getId());
					saleOrderInfo.setSettleStatus(1);
					saleOrderInfo.setStatus(2)       ;
					saleOrderInfo.setType(type);
					saleOrderInfo.setTypeValue(saleUser.getTypeValue());
					saleOrderInfoService.insert(saleOrderInfo);
				}
			}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
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
	 *  保存订单使用券记录
	  * @Title: saveOrderCounpon
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param couponId
	  * @param coupon
	  * @param activity
	  * @param couponDiscountMap
	  * @param orderInfo
	 */
	private void saveOrderCounpon(int couponId, String couponCode, Coupon coupon, Activity activity, 
			Map<String, Double> couponDiscountMap, OrderInfo orderInfo, UserWeixin userWeixin) {
		if(couponId > 0 
				&& couponCode != null 
				&& couponCode.length() == 8 
				&& couponDiscountMap.containsKey(orderInfo.getNumber())){
			Double discount = couponDiscountMap.get(orderInfo.getNumber());
			try{
				// 登记订单消费券记录
				OrderCoupon orderCoupon = new OrderCoupon();
				orderCoupon.setActivityId(coupon.getActivityId());
				orderCoupon.setActivityName(activity.getName());
				orderCoupon.setAmount(discount);
				orderCoupon.setBalance(0);
				orderCoupon.setCode(coupon.getChildCode());
				orderCoupon.setCouponId(coupon.getId());
				orderCoupon.setOrderId(orderInfo.getId());
				orderCoupon.setStatus(1);
				orderCoupon.setType(coupon.getType());
				orderCoupon.setUserId(orderInfo.getUserId());
				orderCoupon.setUserName(userWeixin.getNickname());
				orderCouponService.insert(orderCoupon);
			}catch(Exception e){
				LogCvt.error(e.getMessage(),e);
			}
			// 计算实际支付金额
			orderInfo.setAmount(Arith.sub(orderInfo.getTotalAmount(),discount));
			orderInfo.setDiscount(discount);
			orderInfo.setFavorableDesc(activity.getName());
			orderInfo.setCouponCode(coupon.getChildCode());
			orderInfo.setCouponId(coupon.getId());
		}
	}

	private void saveActivityOffBook(Map<String, OrderActivity> activitySubOrderNumberSet, OrderInfo orderInfo) {
		if(activitySubOrderNumberSet.containsKey(orderInfo.getNumber())){
			OrderActivity orderActivity = activitySubOrderNumberSet.get(orderInfo.getNumber());
			double discount = 0;
			if(orderActivity.getjActivity()){
				discount = orderActivity.getjAmount();
			}else if(orderActivity.getdActivity()){
				discount = orderActivity.getdAmount();
			}
			// 计算实际支付金额
			orderInfo.setAmount(Arith.sub(orderInfo.getTotalAmount(),discount));
			orderInfo.setDiscount(discount);
			orderInfo.setFavorableDesc(orderActivity.getActivitName());
			// 优惠订单登记簿
			OrderActivityBook orderActivityBook = new OrderActivityBook();
			orderActivityBook.setActivityId(orderActivity.getActivityId());
			orderActivityBook.setActivityName(orderActivity.getActivitName());
			orderActivityBook.setAmount(orderInfo.getAmount());
			orderActivityBook.setDiscount(discount);
			orderActivityBook.setOrderId(orderInfo.getId());
			orderActivityBook.setStatus(1);
			orderActivityBook.setTotalAmount(orderInfo.getTotalAmount());
			orderActivityBook.setType(orderActivity.getActivityType());
			orderActivityBookService.insert(orderActivityBook);
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
		//long diff = DateUtil.getDiffDaysForDay(orderInfo.getCreateTime(), date);
		long diff = DateUtil.getDiffDaysForDay(orderInfo.getPayTime(), date);
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
	
	/**
	 *  保存结算记录和下单日志
	  * @Title: saveSettlement
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderInfo
	 */
	private void saveSettlement(OrderInfo orderInfo,double payAmount){
		int thirdId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
		String thirdName = orderInfo.getThirdName()==null?"":orderInfo.getThirdName();
		if(thirdId > 0){
			BasePartner partber = basePartnerService.findById(thirdId);
			double settleFee = 0;
			double settleModeValue = 0;
			int settleModel = 1;
			double settleAmount = 0;
			double orderAmount = orderInfo.getAmount();
			if(partber != null){
				settleModeValue = partber.getSettleModeValue();
				settleModel = partber.getSettleMode();
				if(settleModel == 2){
					settleFee = Arith.mul(orderAmount,Arith.div(settleModeValue, 100));
					settleAmount = Arith.sub(orderAmount, settleFee);
				}else if(settleModel == 3){
					settleFee = settleModeValue;
					settleAmount = Arith.sub(orderAmount, settleFee);
				}
			}
			OrderSettlement orderSettlement = new OrderSettlement();
			orderSettlement.setOrderAmount(orderAmount);
			orderSettlement.setOrderId(orderInfo.getId());
			orderSettlement.setOrderTotalAmount(orderInfo.getTotalAmount());
			orderSettlement.setOrderDicount(orderInfo.getDiscount());
			orderSettlement.setSettleAmount(settleAmount);
			orderSettlement.setSettleFee(settleFee);
			orderSettlement.setSettleModel(settleModel);
			orderSettlement.setSettleModeValue(settleModeValue);
			orderSettlement.setSettleState(1);
			orderSettlement.setThirdId(thirdId);
			orderSettlement.setThirdName(thirdName);
			orderSettlement.setUserId(orderInfo.getUserId());
			orderSettlement.setUserName(userWeixinService.findByOpenId(orderInfo.getOpenid()).getNickname());
			orderSettlementService.insert(orderSettlement);
			/**登记日志*/
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("合作社下单免支付");
			log.setDescription(thirdName+"订单下单免支付");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName("球包通系统");
			log.setOperatorType(OrderOperateTypeEnum.qbt_system.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
		}else{
			/**
			 * 记录订单日志
			 */
			if(payAmount > 0){
				OrderOperateLog log = new OrderOperateLog();
				log.setAction("微信支付回调");
				log.setDescription("微信支付异步通知");
				log.setOperatorId(orderInfo.getUserId());
				log.setOperatorName("微信系统");
				log.setOperatorType(OrderOperateTypeEnum.weixin.getCode());
				log.setOrderId(orderInfo.getId());
				orderOperateLogService.insert(log);
			}else{
				OrderOperateLog log = new OrderOperateLog();
				log.setAction("订单代金券支付");
				log.setDescription("订单代金券支付完成，抵扣所有金额");
				log.setOperatorId(orderInfo.getUserId());
				log.setOperatorName("球包通系统");
				log.setOperatorType(OrderOperateTypeEnum.qbt_system.getCode());
				log.setOrderId(orderInfo.getId());
				orderOperateLogService.insert(log);
			}
		}
	}
	
	/**
	 *  计算平摊优惠金额
	  * @Title: clacCouponDiscout
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param subOrderList
	  * @param activitySubOrderNumberSet
	  * @param coupon
	  * @return
	 */
	private Map<String,Double> clacCouponDiscout(List<OrderInfo> subOrderList, Map<String, OrderActivity> activitySubOrderNumberSet,
			Coupon coupon,List<String> vipOrderId) {
		Map<String,Double> couponDiscountMap = new HashMap<String,Double>();
		double orderTotalAmount = 0;
		// 计算优惠券总金额,总优惠额，平摊优惠金额
		List<OrderInfo> subOrderTempList = new ArrayList<OrderInfo>();
		for(OrderInfo orderInfo : subOrderList){
			// 剔除满减订单
			if(activitySubOrderNumberSet.containsKey(orderInfo.getNumber()) || vipOrderId.contains(orderInfo.getNumber())){
				continue;
			}
			orderTotalAmount = Arith.add(orderTotalAmount, orderInfo.getFreight());
			subOrderTempList.add(orderInfo);
		}
		double childAmount = coupon.getChildAmount();
		// 优惠部分运费金额情况
		if(orderTotalAmount > childAmount){
			double usedAmount = 0;
			for(int i = 0; i < subOrderTempList.size(); i++ ){
				OrderInfo orderInfo = subOrderTempList.get(i);
				// 计算分摊比例
				if(i != subOrderTempList.size()-1){
					double rate = Arith.div(orderInfo.getFreight(), orderTotalAmount);
					double couponDiscount = Arith.mul(childAmount, rate);
					couponDiscountMap.put(orderInfo.getNumber(), couponDiscount);
					usedAmount = Arith.add(usedAmount, couponDiscount);
				}else{
					double couponDiscount = Arith.sub(childAmount, usedAmount);
					couponDiscountMap.put(orderInfo.getNumber(), couponDiscount);
				}
			}
		}else{
			// 运费全部抵扣
			for(OrderInfo orderInfo : subOrderTempList){
				couponDiscountMap.put(orderInfo.getNumber(), orderInfo.getFreight());
			}
		}
		return couponDiscountMap;
		
	}

	/**
	 *  订单删除
	  * @Title: delete
	  * @Description: TODO
	  * @author: share 2016年8月16日
	  * @modify: share 2016年8月16日
	  * @param id
	  * @param orderId
	  * @see com.qbt.web.support.OrderSupport#delete(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void delete(Integer userId, String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR, "无效订单记录");
		}
		int thridId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
		// 检查是否本人订单或该合作社下订单
		if(thridId > 0){
			UserAssistantApply apply = userAsApService.findPartnerByUserId(orderInfo.getUserId(), ApplyTypeEnum.partner.getCode());
			if(apply == null || apply.getApplyId().intValue() != thridId){
				throw new WechatException(ErrorCodeEnum.ERROR, "无权删除此订单");
			}
		}else if(orderInfo.getUserId().intValue() != userId.intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR, "无权删除此订单");
		}
		if(orderInfo.getOrderStatus().intValue() == OrderStatus.pay_succ.getCode().intValue() 
				&& orderInfo.getDeliveryStatus().intValue() < DeliveryStatus.signed.getCode().intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR, "支付中未签收的订单不能删除");
		}
		orderInfo.setIsDelete(true);
		orderInfo.setDeleteTime(new Date());
		orderInfoService.updateById(orderInfo);
		
		// 记录大订单id
		List<Integer> supOrderId = new ArrayList<Integer>();
		if (orderInfo.getOrderId() != 0) {
			supOrderId.add(orderInfo.getOrderId());
		}
		// 检查是否关闭大订单
		orderCommonSupport.closeBigOrder(supOrderId);
	}
	

	private void wechatMessageSend(OrderInfo orderInfo){
		// 1、下单人微信推送
		wechatMessageSupport.createOrderNotify(orderInfo);
		// 2、客服人员\财务人员 微信推送
		// 2.1财务
		List<UserWeixin> kfList = userWeixinService.findByKfType(1);//1-财务
		if(Checker.isNotEmpty(kfList)){
			//微信通知客服
			for(UserWeixin kf : kfList){
				wechatMessageSupport.createOrderCwNotify(orderInfo, kf.getOpenid());
			}
		}
		// 2.2客服
		kfList = userWeixinService.findByKfType(0);//1-财务
		if(Checker.isNotEmpty(kfList)){
			//微信通知客服
			for(UserWeixin kf : kfList){
				wechatMessageSupport.createOrderKfNotify(orderInfo, kf.getOpenid());
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
	
	/**
	 *  短信发送
	  * @Title: messageSend
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @return
	  * @throws Exception
	 */
	private void messageSend(OrderInfo orderInfo) throws Exception {
		// 1、通知寄包人
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
			smsMessageSupport.createOrderJpMsgToJContact(orderInfo);
		}else{
			smsMessageSupport.createOrderMsgToJContact(orderInfo);
		}
		
		// 2、通知收包人
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.createOrderJpMsgToDContact(orderInfo);
			}else{
				smsMessageSupport.createOrderMsgToDContact(orderInfo);
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124160.getCode(), SmsMessageTemplate.createM_124160(orderInfo));
			} 
			
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124159.getCode(), SmsMessageTemplate.createM_124159(orderInfo));
			}
		}*/
	}

	/**
	 *  订单取消
	  * @Title: cancel
	  * @Description: TODO
	  * @author: share 2016年8月16日
	  * @modify: share 2016年8月16日
	  * @param id
	  * @param orderId
	  * @see com.qbt.web.support.OrderSupport#cancel(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void cancel(Integer userId, String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR, "无效订单记录");
		}
		int thridId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
		// 检查是否本人订单或该合作社下订单
		if(thridId > 0){
			UserAssistantApply apply = userAsApService.findPartnerByUserId(orderInfo.getUserId(), ApplyTypeEnum.partner.getCode());
			if(apply == null || apply.getApplyId().intValue() != thridId){
				throw new WechatException(ErrorCodeEnum.ERROR, "无权删除此订单");
			}
		}else if(orderInfo.getUserId().intValue() != userId.intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR, "无权删除此订单");
		}
		
		if(orderInfo.getOrderStatus().intValue() == OrderStatus.pay_ing.getCode().intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR, "支付中订单不能取消");
		}
		if(orderInfo.getOrderStatus().intValue() == OrderStatus.kf_close.getCode()
		  ||orderInfo.getOrderStatus().intValue() == OrderStatus.sys_close.getCode()
		  ||orderInfo.getOrderStatus().intValue() == OrderStatus.user_close.getCode()){
			throw new WechatException(ErrorCodeEnum.ERROR, "已关闭订单不能取消");
		}
		if(orderInfo.getDeliveryStatus().intValue() > DeliveryStatus.wait_sf_recive.getCode()){
			throw new WechatException(ErrorCodeEnum.ERROR, "快递已收件订单不能取消");
		}
		if(orderInfo.getRefundStatus().intValue() > RefundStatus.refund_normal.getCode()){
			throw new WechatException(ErrorCodeEnum.ERROR, "退款订单不能重复取消");
		}
		
		/**
		 * 支付成功退款
		 */
		if(orderInfo.getOrderStatus().intValue() == OrderStatus.pay_succ.getCode().intValue()){
			
//			if(DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_FORMAT_01).equals(DateUtil.formatDate(new Date(),DateUtil.DATE_FORMAT_01))){
//				throw new WechatException(ErrorCodeEnum.ERROR, "当天取包订单不能取消，请联系客服");
//			}
			if(DateUtil.getDiffDaysForDay(orderInfo.getSendSfUserTime(), new Date()) > 0) {
				throw new WechatException(ErrorCodeEnum.ERROR, "该订单已超过可取消时间，请联系客服");
			}
			
			/**
			 * 订单信息登记退款
			 */
			UserWeixin userWeixin = userWeixinService.findByOpenId(orderInfo.getOpenid());
			int orderPayType = orderPayInfoService.findById(orderInfo.getPayId()).getPayMethod();
			OrderRefund refund = new OrderRefund();
			refund.setAmount(orderInfo.getAmount());
			refund.setRealAmount(orderInfo.getAmount());
			refund.setFee(0d);
			refund.setIsNotice(false);
			refund.setMobile(userWeixin.getMobile());
			refund.setOrderId(orderInfo.getId());
			refund.setStatus(1);
			refund.setUserId(orderInfo.getUserId());
			refund.setUserName(userWeixin.getName());
			refund.setUuid(commonService.createRefundId());
			refund.setOrderPayType(orderPayType);
			refund.setRemark("正常退款");
			//取件前一天取消不收取费用，取件当天客户微信端取消收取20元费用。
			if(DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_FORMAT_01).equals(DateUtil.formatDate(new Date(),DateUtil.DATE_FORMAT_01))){
				double fee = 20;
				refund.setRealAmount(Arith.sub(orderInfo.getAmount(), fee));
				refund.setFee(fee);
				refund.setRemark("即日用户取消");
			}
			orderRefundService.insert(refund);
			orderInfo.setRefundStatus(RefundStatus.refund_ing.getCode());
			/**
			 * 使用优惠券支付的，退回优惠券
			 */
			
//			if(orderInfo.getCouponId() != null && orderInfo.getCouponId() > 0 && orderInfo.getCouponCode().length() == 8){
//				orderCouponService.updateByOrderCancel(orderInfo.getCouponId(), orderInfo.getId(),orderInfo.getDiscount());
//				// 如果优惠券使用订单都取消
//				if(orderInfoService.countCouponOrder(orderInfo.getOrderId(),orderInfo.getCouponId()) == 1){
//					couponService.updateStatusById(orderInfo.getCouponId(), 1);
//				}
//			}
			
			/**
			 * 若是合作方下单，取消订单，结算记录至成无效
			 */
			// 如果是合作方免支付下单，添加结算记录
			int thirdId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
			if(thirdId > 0){
				OrderSettlement orderSettlement = new OrderSettlement();
				orderSettlement.setOrderId(orderInfo.getId());
				orderSettlement.setSettleState(SettlementStatusEnum.invalid_settlement.getCode());
				orderSettlement.setRemark("订单取消");
				orderSettlementService.updateByOrderId(orderSettlement);
			}
			
			/**
			 * 将优惠活动记录至成无效退款
			 */
			orderActivityBookService.updateStatus(orderInfo.getId());
			/**
			 * 将销售二维码人员的订单至成无效
			 */
			saleOrderInfoService.updateStatus(orderInfo.getId(),3);
			
			/**
			 * 登记仪表盘
			 */
			OrderExceptionBook orderExceptionBook = new OrderExceptionBook();
			orderExceptionBook.setOrderId(orderInfo.getId()); 
			orderExceptionBook.setOrderNumber(orderInfo.getNumber());
			orderExceptionBook.setIsDealed(false);
			orderExceptionBook.setOrderStatus(orderInfo.getOrderStatus());
			orderExceptionBook.setDescription("订单支付成功，用户发起取消订单，请确认退款信息和顺丰沟通取消订单");
			orderExceptionBook.setType(ExceptionTypeEnum.check_status.getCode());
			orderExceptionBookService.insert(orderExceptionBook);
			
			// 消息通知
			sendMsg(orderInfo);
			// 发送邮件
			emailMsgSupport.orderCancleNotify(orderInfo);
		}
		
		orderInfo.setOrderStatus(OrderStatus.user_close.getCode());
		orderInfoService.updateById(orderInfo);
		
		// 记录大订单id
		List<Integer> supOrderId = new ArrayList<Integer>();
		if (orderInfo.getOrderId() != 0) {
			supOrderId.add(orderInfo.getOrderId());
		}
		// 检查是否关闭大订单
		orderCommonSupport.closeBigOrder(supOrderId);
		
		/**
		 * 登记订单日志
		 */
		OrderOperateLog log = new OrderOperateLog();
		log.setAction("取消订单");
		log.setDescription("用户取消订单，若已支付订单已发退保邮件通知");
		log.setOperatorId(orderInfo.getUserId());
		log.setOperatorName(userWeixinService.findByOpenId(orderInfo.getOpenid()).getName());
		log.setOperatorType(OrderOperateTypeEnum.weixin_user.getCode());
		log.setOrderId(orderInfo.getId());
		orderOperateLogService.insert(log);
		
	}

	private void sendMsg(OrderInfo orderInfo) {
		// 发微信通知
		// 1、下单人微信推送
		wechatMessageSupport.orderCancelNotify(orderInfo);
		// 2、客服人员微信推送
		List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
		if(Checker.isNotEmpty(kfList)){
			//微信通知客服
			for(UserWeixin kf : kfList){
				wechatMessageSupport.orderCancelKfNotify(orderInfo, kf.getOpenid());
			}
		}
		// 3、财务人员微信推送
		kfList = userWeixinService.findByKfType(1);//1-财务
		if(Checker.isNotEmpty(kfList)){
			//微信通知客服
			for(UserWeixin kf : kfList){
				wechatMessageSupport.orderCancelCwNotify(orderInfo, kf.getOpenid());
			}
		}
		try {
			// 短信通知
			// 1、通知寄包人
//			String[] jmobiles = new String[]{orderInfo.getjMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.sendOrderCancelJpMsgToJContact(orderInfo);
			}else{
				smsMessageSupport.sendOrderCancelMsgToJContact(orderInfo);
			}
			if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
				// 2、通知收包人
//				String[] dmobiles = new String[]{orderInfo.getdMobile()};
				if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
					smsMessageSupport.sendOrderCancelJpMsgToDContact(orderInfo);
				}else{
					smsMessageSupport.sendOrderCancelMsgToDContact(orderInfo);
				}
			}
			
			/*// 球包助理
			// 3、球场人员
			// 寄方
			if(orderInfo.getjAddrType() != 4){
				List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
				if(assistantList != null && !assistantList.isEmpty()){
					String[] siteMobile = new String[assistantList.size()];
					int i = 0;
					for(UserAssistant assistant : assistantList){
						siteMobile[i] = assistant.getMobile();
						i++;
					}
					smsSendService.sendSms(siteMobile, SmsTemplate.M_112645.getCode(), SmsMessageTemplate.createM_112645(orderInfo));
				} 
			}
			// 收方
			if(orderInfo.getdAddrType() != 4){
				List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
				if(assistantList != null && !assistantList.isEmpty()){
					String[] siteMobile = new String[assistantList.size()];
					int i = 0;
					for(UserAssistant assistant : assistantList){
						siteMobile[i] = assistant.getMobile();
						i++;
					}
					smsSendService.sendSms(siteMobile, SmsTemplate.M_112645.getCode(), SmsMessageTemplate.createM_112645(orderInfo));
				}
			}*/
			
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
	}
	
	/**
	 *  
	  * @Title: queryAssistantOrder
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param assistant
	  * @return
	  * @see com.qbt.web.support.OrderSupport#queryAssistantOrder(com.qbt.web.pojo.assistant.AssistantOrder)
	 */
	@Override
	public List<OrderDetail> queryAssistantOrder(AssistantOrder assistant) {
		List<OrderDetail> result = new ArrayList<OrderDetail>();
		List<OrderInfo> orderInfoList = orderInfoService.queryAssistantOrder(assistant.getApplyType(),assistant.getApplyId(),assistant.getType(),assistant.getKeyword());
		for(OrderInfo orderInfo : orderInfoList){
			OrderDetail detail = new OrderDetail();
			detail.setCreateTime(orderInfo.getCreateTime().getTime());
			detail.setjMobile(orderInfo.getjMobile());
			detail.setjUserName(orderInfo.getjContact());
			detail.setjAddrType(orderInfo.getjAddrType());
			if(orderInfo.getjAddrType() == 4){
				detail.setjAddressName(orderInfo.getjAddress());
			}else{
				detail.setjAddressName(orderInfo.getjAddrName());
			}
			detail.setjCityName(orderInfo.getjTreePath());
			detail.setdMobile(orderInfo.getdMobile());
			detail.setdUserName(orderInfo.getdContact());
			detail.setdAddrType(orderInfo.getdAddrType());
			if(orderInfo.getdAddrType() == 4){
				detail.setdAddressName(orderInfo.getdAddress());
			}else{
				detail.setdAddressName(orderInfo.getdAddrName());
			}
			detail.setdCityName(orderInfo.getdTreePath());
			detail.setNumber(orderInfo.getNumber());
			detail.setOrderStatus(orderInfo.getOrderStatus());
			detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
			detail.setDeliverTime(orderInfo.getDeliverDate());
			detail.setSendTimeSection(orderInfo.getSendTimeSection());
			result.add(detail);
		}
		return result;
	}
	
	
	@Override
	public List<OrderDetail> queryPartnerOrder(OrderPageRequest order) {
		List<OrderDetail> result = new ArrayList<OrderDetail>();
		int applyId = order.getApplyId();
		int pageNo = order.getPageNo();
		int pageSize = order.getPageSize();
		int lastRecordId = order.getLastRecordId();
		int userId = order.getUserId();
		int orderStatus = order.getOrderStatus();
		
		OrderPageDto pageDto = new OrderPageDto();
		pageDto.setApplyId(applyId);
		pageDto.setLastRecordId(lastRecordId);
		pageDto.setOrderStatus(orderStatus);
		pageDto.setPageNo(pageNo);
		pageDto.setPageSize(pageSize);
		pageDto.setUserId(userId);
		pageDto.setThirdType(2);
		pageDto.setType(order.getType());
		BasePartner partner = basePartnerService.findById(applyId);
		if(partner == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "合作社不存在");
		}
		boolean shareOrder = partner.getShareOrder();
		pageDto.setShareOrder(shareOrder);
		
		
		List<OrderInfo> orderInfoList = orderInfoService.queryPartnerOrder(pageDto);
		order.setHasNext(orderInfoList.size() == pageSize);
		for(OrderInfo orderInfo : orderInfoList){
			OrderDetail detail = new OrderDetail();
			detail.setId(orderInfo.getId());
			detail.setCreateTime(orderInfo.getCreateTime().getTime());
			detail.setjMobile(orderInfo.getjMobile());
			detail.setjUserName(orderInfo.getjContact());
			detail.setjAddrType(orderInfo.getjAddrType());
			if(orderInfo.getjAddrType() == 4){
				detail.setjAddressName(orderInfo.getjAddress());
			}else{
				detail.setjAddressName(orderInfo.getjAddrName());
			}
			detail.setjCityName(orderInfo.getjTreePath());
			detail.setdMobile(orderInfo.getdMobile());
			detail.setdUserName(orderInfo.getdContact());
			detail.setdAddrType(orderInfo.getdAddrType());
			if(orderInfo.getdAddrType() == 4){
				detail.setdAddressName(orderInfo.getdAddress());
			}else{
				detail.setdAddressName(orderInfo.getdAddrName());
			}
			detail.setdCityName(orderInfo.getdTreePath());
			detail.setNumber(orderInfo.getNumber());
			detail.setOrderStatus(orderInfo.getOrderStatus());
			detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
			detail.setDeliverTime(orderInfo.getDeliverDate());
			detail.setSendTimeSection(orderInfo.getSendTimeSection());
			detail.setAssistantName(orderInfo.getAssistantName());
			result.add(detail);
		}
		return result;
	}

	/**
	 *  球包助理收包
	  * @Title: delivery
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param userWeixin
	  * @param applyId
	  * @param applyType
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.OrderSupport#delivery(com.qbt.persistent.entity.UserWeixin, int, int, java.lang.String)
	 */
	@Override
	public void receiver(UserWeixin userWeixin,AssistantDelivery ssistantDelivery) {
		 int applyId = ssistantDelivery.getApplyId();
		 int applyType = ssistantDelivery.getApplyType();
		 String orderId = ssistantDelivery.getOrderId();
		 String remark = ssistantDelivery.getRemark();
		 int opeType  = ssistantDelivery.getOptType();
		 
		UserAssistant userAssistant = userAssistantService.selectByUserId(userWeixin.getId());
		/**
		 * 检查订单是否此次球包助理能查看
		 */
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息不存在");
		}
		if(orderInfo.getdAddrId() != applyId || orderInfo.getdAddrType() != applyType){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息无权查看");
		}
		if(orderInfo.getDeliveryStatus() == 7){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "不能重复收包");
		}
		
		orderInfo.setSignRemark(remark);
		orderInfo.setDeliveryStatus(DeliveryStatus.signed.getCode());
		if(opeType == 2){
			orderInfo.setQuestionStatus(QuestionStatus.exception.getCode());
			orderInfo.setIsHandleQuestion(false);
			
			/**
			 * 登记仪表盘
			 */
			OrderExceptionBook orderExceptionBook = new OrderExceptionBook();
			orderExceptionBook.setOrderId(orderInfo.getId()); 
			orderExceptionBook.setOrderNumber(orderInfo.getNumber());
			orderExceptionBook.setIsDealed(false);
			orderExceptionBook.setOrderStatus(orderInfo.getOrderStatus());
			orderExceptionBook.setDescription("球包助理问题签收，备注:"+remark);
			orderExceptionBook.setType(ExceptionTypeEnum.course_recive_fail.getCode());
			orderExceptionBookService.insert(orderExceptionBook);
			
			List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
			if(Checker.isNotEmpty(kfList)){
				//微信通知客服
				for(UserWeixin kf : kfList){
					wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
				}
			}
			
		}
		orderInfoService.updateById(orderInfo);
		
		// 登记分润信息
		UserAssistantFee useFee = new UserAssistantFee();
		useFee.setAssistantId(userAssistant.getId());
		useFee.setFee(5d);
		useFee.setOrderId(orderInfo.getId());
		useFee.setPaid(false);
		useFee.setType(1);
		userAssistantFeeService.inserAssistant(useFee);
		
		// 登记日志
		OrderOperateLog log = new OrderOperateLog();
		log.setAction("球包助理签收");
		log.setDescription("球包助理签收,备注："+remark);
		log.setOperatorId(userAssistant.getId());
		log.setOperatorName(userAssistant.getName());
		log.setOperatorType(OrderOperateTypeEnum.sys_kf.getCode());
		log.setOrderId(orderInfo.getId());
		orderOperateLogService.insert(log);
		/**
		 * 将销售二维码人员的订单至成有效
		 */
		saleOrderInfoService.updateStatus(orderInfo.getId(),1);
		// 消息发送
		sendMsgBySign(orderInfo);
	}
	

	private void sendMsgBySign(OrderInfo orderInfo) {
		String acceptTime = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		// 1、通知寄包人
//		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		// 2、通知寄包人
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
			smsMessageSupport.sendOrderSignJpMsgToJContact(orderInfo);
		}else{
			smsMessageSupport.sendOrderSignMsgToJContact(orderInfo);
		}
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
			// 2、通知收包人
//			jmobiles = new String[]{orderInfo.getdMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
				smsMessageSupport.sendOrderSignJpMsgToDContact(orderInfo);
			}else{
				smsMessageSupport.sendOrderSignMsgToDContact(orderInfo);
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_112399.getCode(), SmsMessageTemplate.createM_112399(orderInfo,acceptTime));
			} 
			
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_112399.getCode(), SmsMessageTemplate.createM_112399(orderInfo,acceptTime));
			}
		}*/
		
		/**
		 * 微信发送
		 */
		// 1、下单人微信推送
		wechatMessageSupport.orderSignNotify(orderInfo, acceptTime);
	}
	
	/**
	 *  助理寄包
	  * @Title: delivery
	  * @Description: TODO
	  * @author: share 2016年8月22日
	  * @modify: share 2016年8月22日
	  * @param userWeixin
	  * @param ssistantDelivery
	  * @see com.qbt.web.support.OrderSupport#delivery(com.qbt.persistent.entity.UserWeixin, com.qbt.web.pojo.assistant.AssistantDelivery)
	 */
	@Override
	public void delivery(UserWeixin userWeixin,AssistantDelivery ssistantDelivery) {
		 int applyId = ssistantDelivery.getApplyId();
		 int applyType = ssistantDelivery.getApplyType();
		 String orderId = ssistantDelivery.getOrderId();
		 String remark = ssistantDelivery.getRemark();
		 int opeType  = ssistantDelivery.getOptType();
		 
		UserAssistant userAssistant = userAssistantService.selectByUserId(userWeixin.getId());
		/**
		 * 检查订单是否此次球包助理能查看
		 */
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息不存在");
		}
		if(orderInfo.getjAddrId() != applyId || orderInfo.getjAddrType() != applyType){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单信息无权查看");
		}
		if(orderInfo.getDeliveryStatus() >=4){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "不能重复操作寄包");
		}
		int deliverStatus = orderInfo.getDeliveryStatus();
		orderInfo.setSentRemark(remark);
		orderInfo.setDeliveryStatus(DeliveryStatus.kf_confirm_recived.getCode());
		if(opeType == 2){
			/**
			 * 登记仪表盘
			 */
			OrderExceptionBook orderExceptionBook = new OrderExceptionBook();
			orderExceptionBook.setOrderId(orderInfo.getId()); 
			orderExceptionBook.setOrderNumber(orderInfo.getNumber());
			orderExceptionBook.setIsDealed(false);
			orderExceptionBook.setOrderStatus(orderInfo.getOrderStatus());
			orderExceptionBook.setDescription("球包助理问题寄包，备注:"+remark);
			orderExceptionBook.setType(ExceptionTypeEnum.course_recive_fail.getCode());
			orderExceptionBookService.insert(orderExceptionBook);
			
			List<UserWeixin> kfList = userWeixinService.findByKfType(0);//0-普通客服
			if(Checker.isNotEmpty(kfList)){
				//微信通知客服
				for(UserWeixin kf : kfList){
					wechatMessageSupport.exceptionBookNotify(orderExceptionBook, kf.getOpenid());
				}
			}
		}
		orderInfoService.updateById(orderInfo);
		
		// 登记分润信息
		UserAssistantFee useFee = new UserAssistantFee();
		useFee.setAssistantId(userAssistant.getId());
		useFee.setFee(5d);
		useFee.setOrderId(orderInfo.getId());
		useFee.setPaid(false);
		useFee.setType(2);
		userAssistantFeeService.inserAssistant(useFee);
		
		// 登记日志
		OrderOperateLog log = new OrderOperateLog();
		log.setAction("球包助理代寄");
		log.setDescription("球包助理代寄,备注："+remark);
		log.setOperatorId(userAssistant.getId());
		log.setOperatorName(userAssistant.getName());
		log.setOperatorType(OrderOperateTypeEnum.sys_kf.getCode());
		log.setOrderId(orderInfo.getId());
		orderOperateLogService.insert(log);
		if(deliverStatus == DeliveryStatus.wait_sf_recive.getCode()){
			// 消息发送
			sendMsgByRecive(orderInfo);
		}
	}
	
	

	private void sendMsgByRecive(OrderInfo orderInfo) {
		String acceptTime = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		// 1、通知寄包人已取件
//		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//			smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112395.getCode(), SmsMessageTemplate.createM_112395(orderInfo,acceptTime)));
		}else{
			//smsSendService.sendSms(jmobiles, SmsTemplate.M_162520.getCode(), SmsMessageTemplate.createM_162520J(orderInfo,acceptTime));
		}
		// 2、通知收包人已取件
		if(!orderInfo.getjMobile().equals(orderInfo.getdMobile())){
//			jmobiles = new String[]{orderInfo.getdMobile()};
			if(LanguagesEnum.checkIsJapanese(orderInfo.getLangEname())){
//				smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112395.getCode(), SmsMessageTemplate.createM_112395(orderInfo,acceptTime)));
			}else{
				//smsSendService.sendSms(jmobiles, SmsTemplate.M_162520.getCode(), SmsMessageTemplate.createM_162520D(orderInfo,acceptTime));
			}
		}
		/*// 3、球场人员
		// 寄方
		if(orderInfo.getjAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getjAddrId(), orderInfo.getjAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124157.getCode(), SmsMessageTemplate.createM_124157(orderInfo,acceptTime));
			} 
		}
		// 收方
		if(orderInfo.getdAddrType() != 4){
			List<UserAssistant> assistantList = userAssistantService.findAssistantBySiteId(orderInfo.getdAddrId(), orderInfo.getdAddrType());
			if(assistantList != null && !assistantList.isEmpty()){
				String[] siteMobile = new String[assistantList.size()];
				int i = 0;
				for(UserAssistant assistant : assistantList){
					siteMobile[i] = assistant.getMobile();
					i++;
				}
				smsSendService.sendSms(siteMobile, SmsTemplate.M_124157.getCode(), SmsMessageTemplate.createM_124157(orderInfo,acceptTime));
			}
		}*/
		
		/**
		 * 微信发送
		 */
		// 1、下单人微信推送
		wechatMessageSupport.orderReciveNotify(orderInfo, acceptTime);
	}

	/**
	 *  路由查询
	  * @Title: queryKeyword
	  * @Description: TODO
	  * @author: share 2016年8月25日
	  * @modify: share 2016年8月25日
	  * @param keyword
	  * @return
	  * @see com.qbt.web.support.OrderSupport#queryKeyword(java.lang.String)
	 */
	@Override
	public OrderDetail queryKeyword(String keyword) {
		OrderInfo orderInfo = orderInfoService.queryKeyword(keyword);
		if(orderInfo == null){
			throw new WechatException(ErrorCodeEnum.ERROR, "订单信息不存在");
		}
		OrderDetail detail = new OrderDetail();
		detail.setCreateTime(orderInfo.getCreateTime().getTime());
		detail.setjUserName(orderInfo.getjContact());
		detail.setjAddress(orderInfo.getjAddress());
		detail.setjAddrType(orderInfo.getjAddrType());
		detail.setjAddressName(orderInfo.getjAddrName());
		detail.setjCityName(orderInfo.getjTreePath());
		detail.setdUserName(orderInfo.getdContact());
		detail.setdAddress(orderInfo.getdAddress());
		detail.setdAddrType(orderInfo.getdAddrType());
		detail.setdAddressName(orderInfo.getdAddrName());
		detail.setdCityName(orderInfo.getdTreePath());
		detail.setNumber(orderInfo.getNumber());
		detail.setOrderStatus(orderInfo.getOrderStatus());
		detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
		detail.setDeliverTime(orderInfo.getDeliverDate());
		detail.setSendTimeSection(orderInfo.getSendTimeSection());
		detail.setBusnissType(orderInfo.getExpressType());
		detail.setMailNo(orderInfo.getMailNo());
		return detail;
	}

	@Override
	public void addComment(UserWeixin userWeixin, CommentRequest req) {
		OrderInfo orderInfo = orderInfoService.findByNumber(req.getOrderNumber());
		if(orderInfo == null){
			throw new WechatException("订单信息不存在");
		}
		OrderComment comment = new OrderComment();
		comment.setUserId(userWeixin.getId());
		comment.setUserName(userWeixin.getNickname());
		comment.setHeadImgUrl(userWeixin.getHeadImgUrl());
		comment.setOrderId(orderInfo.getId());
		comment.setOrderNumber(orderInfo.getNumber());
		comment.setjTreePath(orderInfo.getjTreePath().substring(0, orderInfo.getjTreePath().lastIndexOf(",")));
		comment.setdTreePath(orderInfo.getdTreePath().substring(0, orderInfo.getdTreePath().lastIndexOf(",")));
		comment.setContent(req.getContent());
		comment.setKfLevel(req.getKfLevel());
		comment.setSfPackLevel(req.getSfPackLevel());
		comment.setSfDeliverLevel(req.getSfDeliverLevel());
		comment.setSfServiceLevel(req.getSfServiceLevel());
		comment.setTotalLevel(Arith.div((comment.getKfLevel() + comment.getSfPackLevel() + comment.getSfDeliverLevel() + comment.getSfServiceLevel()), 4));
		comment.setStatus(1);//1-待审核
		comment.setIsTop(false);
		if(req.getPics() != null){
			String accessToken = commonSupport.getAccessToken();
			String[] remoteUrls = fileuploadScpService.imageWeixinDownToScp(req.getPics(), accessToken);
			if(remoteUrls != null){
				int length = remoteUrls.length;
				switch (length) {
				case 1:
					comment.setUrl1(remoteUrls[0]);
					break;
				case 2:
					comment.setUrl1(remoteUrls[0]);
					comment.setUrl2(remoteUrls[1]);
					break;
				case 3:
					comment.setUrl1(remoteUrls[0]);
					comment.setUrl2(remoteUrls[1]);
					comment.setUrl3(remoteUrls[2]);
					break;
				default:
					break;
				}
			}
		}
		//添加订单评论
		orderCommentService.insert(comment);
		
		//更新订单评论状态
		orderInfoService.updateCommentById(orderInfo.getId(), orderInfo.getNumber(), true);
	}

	@Override
	public List<OrderCommentInfo> commentList(Paging page) {
		List<OrderComment> list = orderCommentService.queryForWechat(page.getLastRecordId(), page.getPageSize());
		List<OrderCommentInfo> infoList = BeanUtil.list2list(list, OrderCommentInfo.class);
		if(Checker.isNotEmpty(list)){
			page.setHasNext(list.size() == page.getPageSize());
			for(int i = 0; i < list.size(); i++){
				OrderComment c = list.get(i);
				OrderCommentInfo info = infoList.get(i);
				List<String> imgUrls = new ArrayList<String>();
				if(Checker.isNotEmpty(c.getUrl1())){
					imgUrls.add(c.getUrl1());
				}
				if(Checker.isNotEmpty(c.getUrl2())){
					imgUrls.add(c.getUrl2());
				}
				if(Checker.isNotEmpty(c.getUrl3())){
					imgUrls.add(c.getUrl3());
				}
				info.setImgUrls(imgUrls);
			}
		}
		return infoList;
	}

	@Override
	public OrderCommentInfo findByOrderNumber(String orderNumber) {
		OrderComment comment = orderCommentService.findByOrderNumber(orderNumber);
		OrderCommentInfo info = BeanUtil.a2b(comment, OrderCommentInfo.class);
		if(Checker.isNotEmpty(comment)){
			List<String> imgUrls = new ArrayList<String>();
			if(Checker.isNotEmpty(comment.getUrl1())){
				imgUrls.add(comment.getUrl1());
			}
			if(Checker.isNotEmpty(comment.getUrl2())){
				imgUrls.add(comment.getUrl2());
			}
			if(Checker.isNotEmpty(comment.getUrl3())){
				imgUrls.add(comment.getUrl3());
			}
			info.setImgUrls(imgUrls);
		}
		return info;
	}
	
	/**
	 *  
	  * @Title: lastOrder
	  * @Description: TODO
	  * @author: share 2016年9月23日
	  * @modify: share 2016年9月23日
	  * @param id
	  * @return
	  * @see com.qbt.web.support.OrderSupport#lastOrder(java.lang.Integer)
	 */
	@Override
	public OrderDetail lastOrder(Integer userId,Integer proxyUserId) {
		OrderInfo orderInfo = orderInfoService.findLastOrderByUserId(userId,proxyUserId);
		
		OrderDetail detail = new OrderDetail();
		if(orderInfo != null){
			detail.setCreateTime(orderInfo.getCreateTime().getTime());
			detail.setjMobile(orderInfo.getjMobile());
			detail.setjUserName(orderInfo.getjContact());
			if(orderInfo.getjAddrType() == 4){
				detail.setjAddressName(orderInfo.getjAddress());
			}else{
				detail.setjAddressName(orderInfo.getjAddrName());
			}
			detail.setjAddrId(orderInfo.getjAddrId());
			detail.setjAreaId(orderInfo.getjAreaId());
			detail.setjAddrType(orderInfo.getjAddrType());
			detail.setjCityName(orderInfo.getjTreePath());
			detail.setdMobile(orderInfo.getdMobile());
			detail.setdUserName(orderInfo.getdContact());
			if(orderInfo.getdAddrType() == 4){
				detail.setdAddressName(orderInfo.getdAddress());
			}else{
				detail.setdAddressName(orderInfo.getdAddrName());
			}
			detail.setdAddrId(orderInfo.getdAddrId());
			detail.setdAreaId(orderInfo.getdAreaId());
			detail.setdAddrType(orderInfo.getdAddrType());
			detail.setdCityName(orderInfo.getdTreePath());
			detail.setDeliverTime(orderInfo.getDeliverDate());
			detail.setSendTimeSection(orderInfo.getSendTimeSection());
			detail.setNumber(orderInfo.getNumber());
		}
		
		return detail;
	}

	@Override
	public List<OrderDetail> trackOrder(int userId, String keyword) {
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		if(Checker.isNotEmpty(keyword)){
			OrderInfo orderInfo = orderInfoService.findByNumber(keyword);
			if(Checker.isEmpty(orderInfo)){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "订单信息不存在");
			}
			detailList.add(getOrderDetail(orderInfo));
		}else{
			List<OrderInfo> orderList = orderInfoService.findRecentOrderByUserId(userId, 30);
			if(Checker.isNotEmpty(orderList)){
				for(OrderInfo orderInfo : orderList){
					detailList.add(getOrderDetail(orderInfo));
				}
			}
		}
		return detailList;
	}

	/**
	 *  大订单查询子订单
	  * @Title: orderSubList
	  * @Description: TODO
	  * @author: share 2016年10月20日
	  * @modify: share 2016年10月20日
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.OrderSupport#orderSubList(java.lang.String)
	 */
	@Override
	public List<OrderDetail> orderSubList(String orderId) {
		List<OrderDetail> result = new ArrayList<OrderDetail>();
		List<OrderInfo> orderInfoList = orderInfoService.findByOrderNumber(orderId);
		for(OrderInfo orderInfo : orderInfoList){
			OrderDetail detail = new OrderDetail();
			detail.setId(orderInfo.getId());
			detail.setCreateTime(orderInfo.getCreateTime().getTime());
			detail.setjMobile(orderInfo.getjMobile());
			detail.setjUserName(orderInfo.getjContact());
			detail.setjAddrType(orderInfo.getjAddrType());
			if(orderInfo.getjAddrType() == 4){
				detail.setjAddressName(orderInfo.getjAddress());
			}else{
				detail.setjAddressName(orderInfo.getjAddrName());
			}
			detail.setjCityName(orderInfo.getjTreePath());
			detail.setdMobile(orderInfo.getdMobile());
			detail.setdUserName(orderInfo.getdContact());
			detail.setdAddrType(orderInfo.getdAddrType());
			if(orderInfo.getdAddrType() == 4){
				detail.setdAddressName(orderInfo.getdAddress());
			}else{
				detail.setdAddressName(orderInfo.getdAddrName());
			}
			detail.setdCityName(orderInfo.getdTreePath());
			detail.setNumber(orderInfo.getNumber());
			detail.setOrderNumber(orderInfo.getOrderNumber());
			detail.setOrderStatus(orderInfo.getOrderStatus());
			detail.setDeliveryStatus(orderInfo.getDeliveryStatus());
			detail.setSendTimeSection(orderInfo.getSendTimeSection());
			detail.setComment(orderInfo.getIsComment()==null?false:orderInfo.getIsComment());
			result.add(detail);
		}
		return result;
	}

	@Override
	public OrderDetailWaybill trackOrder(String keyword) {
		OrderInfo orderInfo = orderInfoService.trackOrder(keyword);
		if(Checker.isEmpty(orderInfo)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "订单信息不存在");
		}
		OrderDetail orderDetail = getOrderDetail(orderInfo);
		OrderDetailWaybill ow = BeanUtil.a2b(orderDetail, OrderDetailWaybill.class);
		
		List<OrderWaybill> wayList = orderWaybillService.findByOrderId(orderInfo.getId());
		List<WayBill> wayBillList = new ArrayList<WayBill>();
		for(OrderWaybill orderWaybill : wayList){
			WayBill way = new WayBill();
			way.setAcceptAddress(orderWaybill.getAcceptAddress());
			way.setAcceptTime(orderWaybill.getAcceptTime().getTime());
			way.setRemark(orderWaybill.getRemark());
			wayBillList.add(way);
		}
		ow.setWaybills(wayBillList);
		
		return ow;
	}

	@Override
	public String officialOrderCreate(OfficialOrderConfirm orderConfirm) {
		/**
		 * 业务订单校验
		 */
		// 预约取包时间校验
		String timeSection = orderConfirm.getConsigned_time();
		Date consignedTime = DateUtil.str2Date(timeSection.substring(0,16)+":00", DateUtil.DATE_TIME_FORMAT_01);
		if(consignedTime.getTime() < System.currentTimeMillis()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包时间已失效");
		}
		if(orderConfirm.getSrc_area_id() == orderConfirm.getDest_area_id() && orderConfirm.getSrc_address().equals(orderConfirm.getDest_address())){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"取包和送包地址不能相同");
		}
		
		// 替换地区ID的市名称
		BaseSfArea jArea =  baseSfAreaService.findById(orderConfirm.getSrc_area_id());
		BaseSfArea jCityArea = baseSfAreaService.findById(jArea.getParentId());
		orderConfirm.setSrc_city(jCityArea.getFullName());
		String[] jtreePath = jArea.getTreePath().split(",");
		orderConfirm.setSrc_province(jtreePath[0]);
		orderConfirm.setSrc_district(jtreePath[2]);
		BaseSfArea dArea =  baseSfAreaService.findById(orderConfirm.getDest_area_id());
		BaseSfArea dCityArea = baseSfAreaService.findById(dArea.getParentId());
		orderConfirm.setDest_city(dCityArea.getFullName());
		String[] dtreePath = dArea.getTreePath().split(",");
		orderConfirm.setDest_province(dtreePath[0]);
		orderConfirm.setDest_district(dtreePath[2]);
		
		/**
		 *  订单价格校验
		 */
		// 顺丰速运价格计算
		if(orderConfirm.getSrc_type() == 1){
			orderConfirm.setSrc_course_id(orderConfirm.getSrc_id());
		}
		if(orderConfirm.getDest_type() == 1){
			orderConfirm.setDest_course_id(orderConfirm.getDest_id());
		}
		double sfPrice = sfExpressSupport.query_sf_expect_price_v2(orderConfirm);
		orderConfirm.setFreight(sfPrice);
		
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
		if(insurePrice < 0) insurePrice = 0d;
		
		// 1-course球场，2-airport机场,3-bank银行,5-顺丰网店
		int srcType = orderConfirm.getSrc_type();
		int srcId = orderConfirm.getSrc_id();
		String jAddrName = "",dAddrName = "";
		jAddrName = getAddrName(srcType, srcId);
		int destType = orderConfirm.getDest_type();
		int destId = orderConfirm.getDest_id();
		dAddrName = getAddrName(destType, destId);
		
		ActivityOrderRequest activityOrderRequest = new ActivityOrderRequest();
		activityOrderRequest.setdAddrId(destId);
		activityOrderRequest.setdAddrName(dAddrName);
		activityOrderRequest.setdAddrType(destType);
		activityOrderRequest.setdAreaId(orderConfirm.getDest_area_id());
		activityOrderRequest.setFreight(orderConfirm.getFreight());
		activityOrderRequest.setjAddrId(srcId);
		activityOrderRequest.setjAddrName(jAddrName);
		activityOrderRequest.setjAddrType(srcType);
		activityOrderRequest.setjAreaId(orderConfirm.getSrc_area_id());
		OrderActivity orderActivity = activitySupport.checkActivityOff(activityOrderRequest);
		double  discount = 0;
		if(orderActivity.getjActivity()){
			discount = Arith.add(discount, orderActivity.getjAmount());
		}else if(orderActivity.getdActivity()){
			discount = Arith.add(discount, orderActivity.getdAmount());
		}
		double totalPrice = Arith.add(sfPrice, insurePrice);
		double realPrice = Arith.sub(totalPrice, discount);
		
		/**
		 * VIP 订单
		 */
		VipOrderConfirmRequest vipOrderConfirmRequest = new VipOrderConfirmRequest();
		vipOrderConfirmRequest.setConsignedTime(orderConfirm.getConsigned_time());
		vipOrderConfirmRequest.setjMobile(orderConfirm.getSrc_moibile());
		vipOrderConfirmRequest.setjName(orderConfirm.getSrc_name());
		vipOrderConfirmRequest.setdMobile(orderConfirm.getDest_moibile());
		vipOrderConfirmRequest.setdName(orderConfirm.getDest_name());
		vipOrderConfirmRequest.setSrcCourseId(orderConfirm.getSrc_course_id());
		vipOrderConfirmRequest.setDestCourseId(orderConfirm.getDest_course_id());
		vipOrderConfirmRequest.setNum(orderConfirm.getQuantity());
		vipOrderConfirmRequest.setSrc_area_id(orderConfirm.getSrc_area_id());
		vipOrderConfirmRequest.setSrc_address(orderConfirm.getSrc_address());
		vipOrderConfirmRequest.setDest_area_id(orderConfirm.getDest_area_id());
		vipOrderConfirmRequest.setDest_address(orderConfirm.getDest_address());
		VipOrderConfirmResponse vipOrderConfirm = vipCommonSupport.checkVipOrder(vipOrderConfirmRequest);
		int num = vipOrderConfirm.getNum();
		boolean isVipOrder = vipOrderConfirm.isVipOrder();
		int[] vipIds = vipOrderConfirm.getVipId();
		double[] vipOrderAmounts = vipOrderConfirm.getVipOrderAmount();
		double outRangeAmount = vipOrderConfirm.getOutRangeAmount();
		
		double orderTotalPrice = Arith.mul(orderConfirm.getQuantity()-num,realPrice);
		if(orderTotalPrice < 0) orderTotalPrice = 0;
		if(isVipOrder){
			for(double vipOrderAmount : vipOrderAmounts){
				double vipTotalPrice = Arith.add(vipOrderAmount, insurePrice);
				vipTotalPrice = Arith.add(vipTotalPrice, outRangeAmount);
				if(vipTotalPrice < 0) vipTotalPrice = 0;
				orderTotalPrice = Arith.add(orderTotalPrice,vipTotalPrice);
			}
		}
		LogCvt.info("保价金额："+insurePrice+",实付金额:"+realPrice+",计算总金额:"+orderTotalPrice);
		
		//时效校验
		String deliverDate = orderConfirm.getDeliver_time();
		if(consignedTime.getTime() > DateUtil.str2Date(deliverDate, DateUtil.DATE_TIME_FORMAT_01).getTime()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "取件时间不能大于到达时间");
		}
		
		//短信验证码校验
		smsCodeService.checkSmsCode(orderConfirm.getMobile(), orderConfirm.getSmsCode(), orderConfirm.getSmsToken());
		
		/**
		 * 订单信息组装
		 */
		// 订单信息
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setProxyUserId(0);
		orderInfo.setUserId(0);
		orderInfo.setTotalAmount(totalPrice);
		orderInfo.setOrderStatus(OrderStatus.un_pay.getCode());
		orderInfo.setRefundStatus(RefundStatus.refund_normal.getCode());
		orderInfo.setDeliveryStatus(DeliveryStatus.un_send_sf.getCode());
		orderInfo.setBpsStatus(SfBpsStatus.un_send.getCode());
		orderInfo.setQuestionStatus(QuestionStatus.normal.getCode());
		orderInfo.setOrderSource(OrderSource.pc_online.getCode());
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
		orderInfo.setDiscount(0d);
		
		if(isVipOrder){
			double vipDiscount =  sfPrice < vipOrderAmounts[0] ? 0 : Arith.sub(Arith.sub(sfPrice, vipOrderAmounts[0]), outRangeAmount);
			double vipTotalPrice = Arith.add(vipOrderAmounts[0], insurePrice);
			vipTotalPrice = Arith.add(vipTotalPrice, outRangeAmount);
			orderInfo.setAmount(vipTotalPrice);
			orderInfo.setDiscount(vipDiscount);
			if(vipDiscount==0){
				orderInfo.setFavorableDesc("");
				orderInfo.setVipId(0);
				orderInfo.setIsVip(false);
			}else{
				orderInfo.setFavorableDesc("会员卡订单");
				orderInfo.setVipId(vipIds[0]);
				orderInfo.setIsVip(true);
			}
		}else{
			orderInfo.setAmount(realPrice);
			orderInfo.setDiscount(discount);
			orderInfo.setFavorableDesc(orderActivity.getActivitName());
			orderInfo.setIsVip(false);
		}
		
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
		orderInfo.setIsOrg(false);
		orderInfo.setIsBagCode(false);
		orderInfo.setRemark("");
		orderInfo.setOpenid("");
		orderInfo.setInputDiscount(0d);
		orderInfo.setPlayTime(orderConfirm.getPlayTime());
		// thrid info
		orderInfo.setThirdType(1);
		orderInfo.setThirdId(0);
		// 微信支付：客服收款：无需收款。财务收款：是。
		orderInfo.setKfReceivableStatus(0);
		orderInfo.setCwReceivableStatus(1);
		// 偏远寄件信息
		BaseCourse jCourse = baseCourseService.findById(orderInfo.getjAddrId());
		BaseCourse dCourse = baseCourseService.findById(orderInfo.getdAddrId());
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
		order.setOpenId("");
		order.setOrderSource(orderInfo.getOrderSource());
		order.setOrderStatus(BigOrderStatus.normal.getCode());
		order.setPayMethod(0);
		order.setPayStatus(BigOrderPayStatus.un_pay.getCode());
		order.setPayTime(null);
		order.setQuantity(orderConfirm.getQuantity());
		order.setThirdId(orderInfo.getThirdId());
		order.setThirdName(orderInfo.getThirdName());
		order.setThirdType(orderInfo.getThirdType());
		order.setAssistantName(orderInfo.getAssistantName());
		order.setUserId(0);
		order.setSubNumber(subNumber);
		int orderId = ordersService.insert(order);
		
		String uuid = ToolsUtil.getUUID();
		orderInfo.setNumber(subNumber);
		orderInfo.setOrderId(orderId);
		orderInfo.setOrderNumber(order.getNumber());
		orderInfo.setMd5(uuid);
		orderInfoService.inser(orderInfo);
		
		// 添加客户信息
		saveUserContact(orderInfo, 0);
		
		for(int i = 1 ; i < order.getQuantity(); i++){
			OrderInfo subOrderInfo = BeanUtil.a2b(orderInfo, OrderInfo.class);
			
			if(i < num){
				double vipDiscount =  sfPrice < vipOrderAmounts[i] ? 0 : Arith.sub(Arith.sub(sfPrice, vipOrderAmounts[i]), outRangeAmount);
				double vipTotalPrice = Arith.add(vipOrderAmounts[i], insurePrice);
				vipTotalPrice = Arith.add(vipTotalPrice, outRangeAmount);
				subOrderInfo.setAmount(vipTotalPrice);
				subOrderInfo.setDiscount(vipDiscount);
				if(vipDiscount==0){
					subOrderInfo.setFavorableDesc("");
					subOrderInfo.setVipId(0);
					subOrderInfo.setIsVip(false);
				}else{
					subOrderInfo.setFavorableDesc("会员卡订单");
					subOrderInfo.setVipId(vipIds[i]);
					subOrderInfo.setIsVip(true);
				}
			}else{
				subOrderInfo.setMd5(uuid);
				subOrderInfo.setAmount(realPrice);
				subOrderInfo.setTotalAmount(totalPrice);
				subOrderInfo.setDiscount(discount);
				subOrderInfo.setFavorableDesc(orderActivity.getActivitName());
				subOrderInfo.setIsVip(false);
			}
			
			subOrderInfo.setNumber(commonService.createOrderId());
			subOrderInfo.setOrderId(orderId);
			subOrderInfo.setOrderNumber(order.getNumber());
			subOrderInfo.setMd5(uuid);
			orderInfoService.inser(subOrderInfo);
			/**
			 * 记录订单日志
			 */
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("下单");
			log.setDescription("客户下单");
			log.setOperatorId(subOrderInfo.getUserId());
			log.setOperatorName("");
			log.setOperatorType(OrderOperateTypeEnum.weixin_user.getCode());
			log.setOrderId(subOrderInfo.getId());
			orderOperateLogService.insert(log);
		}
		
		return order.getNumber();
	}

	@Override
	public BigOrderDetail officialUnpayOrderDetail(String orderNumber) {
		Orders bigOrder = ordersService.findByNumber(orderNumber);
		List<OrderInfo> subOrderList = orderInfoService.findByOrderNumber(orderNumber);
		BigOrderDetail orderDetail = BeanUtil.a2b(bigOrder, BigOrderDetail.class);
		double totalAmount = 0;
		double amount = 0;
		double insuredValue = 0;
		double insuredFee = 0;
		double discount = 0;
		double vipOrderAmount = 0;
		double outRangeAmount = 0;
		Integer busnissType = 0;
		String deliverTime = null;
		String sendTimeSection = null;
		Integer jAddrType = null;
		Integer dAddrType = null;
		Integer quantity = bigOrder.getQuantity();
		for(OrderInfo subOrder : subOrderList){
			orderDetail.getNumbers().add(subOrder.getNumber());
			if(subOrder.getOrderStatus() != OrderStatus.un_pay.getCode()){
				quantity--;
				continue;
			}
			totalAmount = subOrder.getFreight();
			amount += subOrder.getAmount();
			insuredValue = subOrder.getInsuredValue();
			insuredFee = subOrder.getInsuredFee();
			if(subOrder.getIsVip()){
				vipOrderAmount += subOrder.getDiscount();
			}else{
				discount += subOrder.getDiscount();
			}
			outRangeAmount += (subOrder.getjOutRangePrice() + subOrder.getdOutRangePrice());
			busnissType = Integer.valueOf(subOrder.getExpressType());
			deliverTime = subOrder.getDeliverDate();
			sendTimeSection = subOrder.getSendTimeSection();
			jAddrType = subOrder.getjAddrType();
			dAddrType = subOrder.getdAddrType();
			
			orderDetail.setPlayTime(subOrder.getPlayTime());
			
			if(ExpressTypeEnum.after_tomorow.getType().equals(subOrder.getExpressType())){
				long days = DateUtil.getDiffDaysForDay(
						subOrder.getSendSfUserTime(), 
						DateUtil.str2Date(subOrder.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
						);
				orderDetail.setExpressDescribe("预计"+days+"天后送达");
			}
			
			orderDetail.setjOutRangeType(subOrder.getjOutRangeType());
			orderDetail.setdOutRangeType(subOrder.getdOutRangeType());
		}
		if(Checker.isNotEmpty(orderDetail)){
			orderDetail.setTotalAmount(totalAmount);
			orderDetail.setAmount(amount);
			orderDetail.setInsureValue(insuredValue);
			orderDetail.setInsureFee(insuredFee);
			orderDetail.setDiscount(discount);
			orderDetail.setVipOrderAmount(vipOrderAmount);
			orderDetail.setOutRangeAmount(outRangeAmount);
			orderDetail.setBusnissType(busnissType);
			orderDetail.setDeliverTime(deliverTime);
			orderDetail.setSendTimeSection(sendTimeSection);
			orderDetail.setjAddrType(jAddrType);
			orderDetail.setdAddrType(dAddrType);
			orderDetail.setQuantity(quantity);
			OrderActivity orderActivity = activitySupport.checkOrder(orderDetail.getNumbers().get(0));
			if(Checker.isNotEmpty(orderActivity)){
				orderDetail.setjActivity(orderActivity.getjActivity());
				orderDetail.setdActivity(orderActivity.getdActivity());
			}
		}
		
		
		return orderDetail;
	}

	@Override
	public void confirm(Integer id) {
		OrderInfo info = orderInfoService.findById(id);
		if(info.getDeliveryStatus() != DeliveryStatus.signed.getCode()){
			sendMsgBySign(info);
		}
		orderInfoService.updateConfirmReceiveById(id);
	}

	@Override
	public List<OrderDetailV2> findForBill(Integer userId) {
//		  final int PASTDAY = 30;
		  int PASTDAY = Integer.parseInt(sysConfigSupport.findByCode(SysConfigEnum.billTimeLimit.getCode()));
		  Calendar calendar = Calendar.getInstance();  
		  calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - PASTDAY); 
		  Date days = calendar.getTime();  
		  String date = DateUtil.formatDate(days);
		  List<OrderInfo> orderInfoList = orderInfoService.findByBill(userId, date);
		  List<OrderDetailV2> list = BeanUtil.list2list(orderInfoList, OrderDetailV2.class);
		  return list;
	}

	@Override
	public List<HistoryOrderAddressVo> findAddressHistory(Integer userId) {
	
		List<HistoryOrderAddressVo> orderDetailList = new ArrayList<HistoryOrderAddressVo>();
		
		List<OrderInfo> orderList = orderInfoService.findAddressHistoryById(userId);
	
		if(Checker.isEmpty(orderList))
		{
			return null;
		}
		
		Map<Integer,Integer> keymap = new HashMap<Integer,Integer>();
		
		for(OrderInfo orderInfo : orderList)
		{
			if(Checker.isNotEmpty(keymap.get(orderInfo.getjAreaId())) && keymap.get(orderInfo.getjAreaId()).equals(orderInfo.getdAreaId()))
			{
				continue;
			}
			
			HistoryOrderAddressVo orderDetial = new HistoryOrderAddressVo();
			orderDetial.setjAddress(orderInfo.getjAddress());		
			orderDetial.setjAddressName(orderInfo.getjAddrName());
			orderDetial.setjAreaId(orderInfo.getjAreaId());
			orderDetial.setjAddrId(orderInfo.getjAddrId());
			orderDetial.setjAddrType(orderInfo.getjAddrType());
			orderDetial.setjOutRangeType(orderInfo.getjOutRangeType());
			orderDetial.setjOutRangePrice(orderInfo.getjOutRangePrice());
			
			
			orderDetial.setdAddress(orderInfo.getdAddress());
			orderDetial.setdAddressName(orderInfo.getdAddrName());
			orderDetial.setdAreaId(orderInfo.getdAreaId());
			orderDetial.setdAddrType(orderInfo.getdAddrType());
			orderDetial.setdAddrId(orderInfo.getdAddrId());
			orderDetial.setdOutRangeType(orderInfo.getdOutRangeType());
			orderDetial.setdOutRangePrice(orderInfo.getdOutRangePrice());
			
			orderDetial.setjCityName(orderInfo.getjTreePath());
			orderDetial.setdCityName(orderInfo.getdTreePath());

			BaseSfArea area = baseSfAreaService.findById(orderInfo.getjAreaId());
			if(area !=null){
				orderDetial.setJtreeId(area.getTreeId());
			}
			
			
			area = baseSfAreaService.findById(orderInfo.getdAreaId());
			if(area !=null){
				orderDetial.setDtreeId(area.getTreeId());
			}
			keymap.put(orderDetial.getjAreaId(),orderDetial.getdAreaId());
			orderDetailList.add(orderDetial);
		}
		
	
		return orderDetailList;
	}
	
	
}
