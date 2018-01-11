package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.AddrTypeEnum;
import com.qbt.common.enums.ApplyTypeEnum;
import com.qbt.common.enums.BigOrderPayStatus;
import com.qbt.common.enums.BigOrderStatus;
import com.qbt.common.enums.DeliveryStatus;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.LanguagesEnum;
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
import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.entity.BasePartnerLanguage;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.OrderPayInfo;
import com.qbt.persistent.entity.OrderShoppingCart;
import com.qbt.persistent.entity.Orders;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BasePartnerLanguageService;
import com.qbt.service.BasePartnerService;
import com.qbt.service.CommonService;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrderPayInfoService;
import com.qbt.service.OrderSettlementService;
import com.qbt.service.OrderShoppingCartService;
import com.qbt.service.OrdersService;
import com.qbt.service.UserAsApService;
import com.qbt.service.VipTypeService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderPageRequest;
import com.qbt.web.pojo.order.ShoppingCartOrderDetail;
import com.qbt.web.pojo.sf.DeliverRequest;
import com.qbt.web.pojo.shoppingCart.CartRequest;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.SfExpressSupport;
import com.qbt.web.support.ShoppingCartOrderSupport;
import com.qbt.web.support.SiteSupport;

@Service
public class ShoppingCartOrderSupportImpl implements ShoppingCartOrderSupport {

	@Resource
	private SfExpressSupport sfExpressSupport;
	@Resource
	private SiteSupport siteSupport;
	@Resource
	private CommonService commonService;
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
	private OrderInfoService orderInfoService;
	@Resource
	private OrdersService ordersService;
	@Resource
	private OrderOperateLogService orderOperateLogService;
	@Resource
	private OrderShoppingCartService shoppingCartService;
	@Resource
	private ActivitySupport activitySupport;
	@Resource
	private BaseCourseService baseCourseService;
	@Resource
	private VipUserService vipUserService;
	@Resource
	private VipTypeService vipTypeService;
	
	@Override
	public String orderCreate(CartRequest request) {
		List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		int quantity = 0;
		int[] ids = request.getIds();
		int userId = request.getUserId();
		List<OrderShoppingCart> shoppingCartList = shoppingCartService.findByIds(userId, ids);
		/**
		 * 业务订单校验
		 */
		for(OrderShoppingCart cartVo: shoppingCartList){
			 DeliverRequest deliverReq = new DeliverRequest();
			 deliverReq.setBusiness_type(cartVo.getExpressType());
			 deliverReq.setSrc_area_id(cartVo.getjAreaId());
			 deliverReq.setDest_area_id(cartVo.getdAreaId());
			 deliverReq.setConsigned_time(DateUtil.formatDate(cartVo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
			 /**
			  *  订单价格校验
			 */
			 // 顺丰速运价格计算
			 if(cartVo.getjAddrType() == 1){
				 deliverReq.setSrc_course_id(cartVo.getjAddrId());
			 }
			 if(cartVo.getdAddrType() == 1){
				 deliverReq.setDest_course_id(cartVo.getdAddrId());
			 }
			// 预约取包时间校验
			if(cartVo.getSendSfUserTime().getTime() < System.currentTimeMillis()){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"下单失败，部分清单取包时间已失效");
			}
			/**
			 * 订单价格校验
			 */
			double sfPrice = 0;
			try {
				// 顺丰速运价格计算
				sfPrice = sfExpressSupport.query_sf_expect_price_v2(deliverReq);
				if(sfPrice <= 0){
					throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"订单金额无效");
				}
			} catch (Exception e) {
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"下单失败，部分清单取包时间已失效");
			}
			// 保价金额
			Double insureRate = null;
			double insurePrice = cartVo.getInsuredFee();
			double totalPrice = Arith.add(sfPrice, insurePrice);
			LogCvt.info("购物车清单下单保价金额："+insurePrice+",总金额:"+totalPrice);
			quantity += cartVo.getQuantity();
			for(int i = 0 ; i < cartVo.getQuantity(); i++){
				// 子订单信息
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setProxyUserId(cartVo.getProxyUserId());
				orderInfo.setUserId(cartVo.getUserId());
				orderInfo.setNumber(commonService.createOrderId());
				orderInfo.setAmount(0d);
				orderInfo.setTotalAmount(totalPrice);
				orderInfo.setOrderStatus(OrderStatus.un_pay.getCode());
				orderInfo.setRefundStatus(RefundStatus.refund_normal.getCode());
				orderInfo.setDeliveryStatus(DeliveryStatus.un_send_sf.getCode());
				orderInfo.setBpsStatus(SfBpsStatus.un_send.getCode());
				orderInfo.setQuestionStatus(QuestionStatus.normal.getCode());
				orderInfo.setOrderSource(OrderSource.weixin.getCode());
				orderInfo.setSendSfUserTime(cartVo.getSendSfUserTime());
				orderInfo.setFreight(sfPrice);
				orderInfo.setInsuredFee(insurePrice);
				orderInfo.setInsuredRates(insureRate);
				orderInfo.setInsuredValue(cartVo.getInsuredValue());
				orderInfo.setExpressType(cartVo.getExpressType());
				orderInfo.setIsHandleQuestion(true);
				orderInfo.setDeliverDate(cartVo.getDeliverDate());
				orderInfo.setSendTimeSection(cartVo.getSendTimeSection());
				orderInfo.setDiscount(0d);
				// 寄件信息
				orderInfo.setjAddrType(cartVo.getjAddrType());
				orderInfo.setjAddress(cartVo.getjAddress());
				orderInfo.setjAddrId(cartVo.getjAddrType() != 4?cartVo.getjAddrId():0);
				orderInfo.setjAddrName(cartVo.getjAddrName());
				orderInfo.setjAreaId(cartVo.getjAreaId());
				orderInfo.setjContact(cartVo.getjContact());
				orderInfo.setjMobile(cartVo.getjMobile());
				orderInfo.setjTreePath(cartVo.getjTreePath());
				// 收件信息
				orderInfo.setdAddrType(cartVo.getdAddrType());
				orderInfo.setdAddress(cartVo.getdAddress());
				orderInfo.setdAddrId(cartVo.getdAddrType() != 4?cartVo.getdAddrId():0);
				orderInfo.setdAddrName(cartVo.getdAddrName());
				orderInfo.setdAreaId(cartVo.getdAreaId());
				orderInfo.setdContact(cartVo.getdContact());
				orderInfo.setdMobile(cartVo.getdMobile());
				orderInfo.setdTreePath(cartVo.getdTreePath());
				// other
				orderInfo.setIsHelped(false);
				orderInfo.setIsDelete(false);
				orderInfo.setRemark("");
				orderInfo.setOpenid(request.getOpenid());
				orderInfo.setMd5(cartVo.getMd5());
				orderInfo.setInputDiscount(0d);
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
					orderInfo.setIsHelped(true);
					// 合作社待下单：客服收款：否，财务收款：否。
					orderInfo.setKfReceivableStatus(2);
					orderInfo.setCwReceivableStatus(2);
				}
				// 偏远寄件球场信息
				if(orderInfo.getjAddrType() == AddrTypeEnum.course.getType()){
					BaseCourse jCourse = baseCourseService.findById(orderInfo.getjAddrId());
					orderInfo.setjOutRangeType(jCourse.getIsOutRange()? 1 : 0);
					orderInfo.setjOutRangeTime(jCourse.getOutRangeTime());
					orderInfo.setjOutRangePrice(jCourse.getOutRangePrice());
				}else{
					orderInfo.setjOutRangeType(0);
					orderInfo.setjOutRangeTime(0d);
					orderInfo.setjOutRangePrice(0d);
				}
				// 偏远收件球场信息
				if(orderInfo.getdAddrType() == AddrTypeEnum.course.getType()){
					BaseCourse dCourse = baseCourseService.findById(orderInfo.getdAddrId());
					orderInfo.setdOutRangeType(dCourse.getIsOutRange() ? 1 : 0);
					orderInfo.setdOutRangeTime(dCourse.getOutRangeTime());
					orderInfo.setdOutRangePrice(dCourse.getOutRangePrice());
				}else{
					orderInfo.setdOutRangeType(0);
					orderInfo.setdOutRangeTime(0d);
					orderInfo.setdOutRangePrice(0d);
				}
				
				orderInfoList.add(orderInfo);
			}
		}
		/**
		 * 添加大订单
		 */
		OrderInfo forderInfo = orderInfoList.get(0);
		Orders order = new Orders();
		if(forderInfo.getdAddrType() == 4){
			order.setdAddrName(forderInfo.getdAddress());
		}else{
			order.setdAddrName(forderInfo.getdAddrName());
		}
		order.setdContact(forderInfo.getdContact());
		order.setdMobile(forderInfo.getdMobile());
		order.setdTreePath(forderInfo.getdTreePath());
		order.setIsDelete(false);
		order.setIsHelped(forderInfo.getIsHelped());
		if(forderInfo.getjAddrType() == 4){
			order.setjAddrName(forderInfo.getjAddress());
		}else{
			order.setjAddrName(forderInfo.getjAddrName());
		}
		order.setjContact(forderInfo.getjContact());
		order.setjMobile(forderInfo.getjMobile());
		order.setjTreePath(forderInfo.getjTreePath());
		order.setNumber(commonService.createBigOrderId());
		order.setOpenId(forderInfo.getOpenid());
		order.setOrderSource(forderInfo.getOrderSource());
		order.setOrderStatus(BigOrderStatus.normal.getCode());
		order.setPayMethod(0);
		order.setPayStatus(BigOrderPayStatus.un_pay.getCode());
		order.setPayTime(null);
		order.setQuantity(quantity);
		order.setThirdId(forderInfo.getThirdId());
		order.setThirdName(forderInfo.getThirdName());
		order.setThirdType(forderInfo.getThirdType());
		order.setAssistantName(forderInfo.getAssistantName());
		order.setUserId(userId);
		order.setSubNumber(forderInfo.getNumber());
		int orderId = ordersService.insert(order);
		/**
		 * 添加子订单
		 */
		for(OrderInfo orderInfo : orderInfoList){
			orderInfo.setOrderId(orderId);
			orderInfo.setOrderNumber(order.getNumber());
			orderInfoService.inser(orderInfo);
			/**
			 * 记录订单日志
			 */
			OrderOperateLog log = new OrderOperateLog();
			log.setAction("下单");
			log.setDescription(orderInfo.getThirdId() >0?orderInfo.getThirdName()+"助理下单":"客户下单");
			log.setOperatorId(orderInfo.getUserId());
			log.setOperatorName(request.getUserName());
			log.setOperatorType(OrderOperateTypeEnum.weixin_user.getCode());
			log.setOrderId(orderInfo.getId());
			orderOperateLogService.insert(log);
		}
		
		/**
		 * 清空选中的购物车信息
		 */
		shoppingCartService.deleteByIds(ids, userId);
		return order.getNumber();
	}

	/**
	 *  待支付订单详情
	  * @Title: unpayOrderDetail
	  * @Description: TODO
	  * @author: share 2016年10月19日
	  * @modify: share 2016年10月19日
	  * @param orderId
	  * @return
	  * @see com.qbt.web.support.ShoppingCartOrderSupport#unpayOrderDetail(java.lang.String)
	 */
	@Override
	public ShoppingCartOrderDetail unpayOrderDetail(String orderId) {
		List<OrderInfo> orderInfoList = orderInfoService.findByOrderNumber(orderId);
		if(Checker.isEmpty(orderInfoList)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "查无记录");
		}
		Orders orders = ordersService.findByNumber(orderId);
		if(orders.getOrderStatus() == BigOrderStatus.close.getCode().intValue()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "订单已失效，不能继续支付！");
		}
		OrderInfo orderInfo = orderInfoList.get(0);
		long sendSfTime = orderInfo.getSendSfUserTime().getTime();
		// 会员卡信息
		List<VipInfo> vipInfos = vipUserService.findByUserId(orderInfo.getProxySelfUserId());
		List<VipInfo> validVipInfos = new ArrayList<VipInfo>();
		// 合作机构信息
		int thridId = orderInfo.getThirdId()==null?0:orderInfo.getThirdId();
		String[] partnerLangs = null;
		// 检查是否本人订单或该合作社下订单
		if(thridId > 0){
			UserAssistantApply apply = userAsApService.findPartnerByUserId(orderInfo.getUserId(), ApplyTypeEnum.partner.getCode());
			List<BasePartnerLanguage> languageList = basePartnerLanguageService.listByPartnerlId(apply.getApplyId());
			partnerLangs = new String[languageList.size()];
			for( int i = 0 ; i < languageList.size(); i++){
				BasePartnerLanguage lang = languageList.get(i);
				partnerLangs[i] = lang.getEname()+":"+lang.getName();
			}
		}else{
			for(VipInfo vipInfo : vipInfos){
				// 检查用户是否是VIP购买用户
				long vipExpireTime = (vipInfo.getValidTime().getTime() + 24 * 60 * 60 * 1000);
				if(vipInfo != null && vipInfo.getStatus() == 1 && vipExpireTime > System.currentTimeMillis() && sendSfTime < vipExpireTime){
					// 检查是否有在途的vip订单
					OrderInfo lastVipOrder = orderInfoService.getLastVipOrder(orderInfo.getUserId(),vipInfo.getId());
					if(lastVipOrder != null){
						long deliverDate = DateUtil.str2Date(lastVipOrder.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01).getTime();
						vipInfo.setLastOrderDeliverTime(deliverDate);
					}
					validVipInfos.add(vipInfo);
				}
			}
			
		}
		
		// 大订单信息
		ShoppingCartOrderDetail bigOrderDetail = new ShoppingCartOrderDetail();
		bigOrderDetail.setOrderNumber(orderId);
		if(thridId > 0){
			bigOrderDetail.setPartnerOrder(true);
			bigOrderDetail.setPartnerLangs(partnerLangs);
		}
		
		// 子订单信息
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		int i = 0;
		Map<String,Integer> uniqueMap = new HashMap<String,Integer>();
		for(OrderInfo subOrderInfo : orderInfoList){
			String key = subOrderInfo.getMd5();
			int orderStatus = subOrderInfo.getOrderStatus();
			if(orderStatus != OrderStatus.un_pay.getCode()){
				bigOrderDetail.setInvalidCount(bigOrderDetail.getInvalidCount()+1);
				continue;
			}
			boolean matchVipOrder = false;
			double orderAmout = 0;
			int vipIds = 0;
			// 检查满足哪个vip信息
			Iterator<VipInfo> it = validVipInfos.iterator();  
			while(it.hasNext()){  
				VipInfo vipInfo = it.next();
				// 检查是否满足VIP订单要求
				if(vipInfo.getLastOrderDeliverTime() < subOrderInfo.getSendSfUserTime().getTime()
						&& subOrderInfo.getjMobile().equals(subOrderInfo.getdMobile())
						&& subOrderInfo.getjContact().equals(subOrderInfo.getdContact())
						&& subOrderInfo.getjMobile().equals(vipInfo.getMobile())
						&& subOrderInfo.getdContact().equals(vipInfo.getUserName())
						&& thridId == 0
					){
					matchVipOrder = true;
					orderAmout = vipInfo.getOrderAmount();
					key = key + "_vip_" + orderAmout;
					vipIds = vipInfo.getId();
					it.remove();
					break;
				}
			}
			
			if(uniqueMap.containsKey(key)){
				orderDetailList.get(uniqueMap.get(key)).getNumbers().add(subOrderInfo.getNumber());
				if(matchVipOrder){
					orderDetailList.get(uniqueMap.get(key)).getVipIds().add(vipIds);
				}
			}else{
				OrderDetail detail = getOrderDetail(subOrderInfo);
				detail.getNumbers().add(subOrderInfo.getNumber());
				detail.getVipIds().add(vipIds);
				if(!matchVipOrder){
					activitySupport.checkSubOrderInfo(detail);
					orderDetailList.add(detail);
					uniqueMap.put(key,i);
				}else{
					detail.setVipOrder(true);
					detail.setVipOrderAmount(orderAmout);
					detail.setOutRangeAmount(Arith.add(subOrderInfo.getjOutRangePrice(),subOrderInfo.getdOutRangePrice()));
					orderDetailList.add(detail);
					uniqueMap.put(key,i);
				}
				i++;
			}
		}
		bigOrderDetail.setSubOrders(orderDetailList);
		return bigOrderDetail;
	}

	@Override
	public List<BigOrderDetail> orderList(OrderPageRequest order) {
		List<BigOrderDetail> result = new ArrayList<BigOrderDetail>();
		int pageNo = order.getPageNo();
		int pageSize = order.getPageSize();
		int lastRecordId = order.getLastRecordId();
		int userId = order.getUserId();
		int orderStatus = order.getOrderStatus();
		Integer proxyUserId = null;
		if(order.getProxyUserId().equals(0)){
			proxyUserId = order.getProxyUserId();
		}else{
			proxyUserId = order.getUserId();
		}
		OrderPageDto pageDto = new OrderPageDto();
		pageDto.setLastRecordId(lastRecordId);
		pageDto.setOrderStatus(orderStatus);
		pageDto.setPageNo(pageNo);
		pageDto.setPageSize(pageSize);
		pageDto.setUserId(userId);
		pageDto.setProxyUserId(proxyUserId);//到这里
		
		List<Orders> orderList = ordersService.findByUserIdForWeiXin(pageDto);
		order.setHasNext(orderList.size() == pageSize);
		for(Orders orderInfo : orderList){
			result.add(BeanUtil.a2b(orderInfo, BigOrderDetail.class));
		}
		return result;
	}

	@Override
	public void paySuccess(OrderPayInfo payment) {

	}

	@Override
	public List<BigOrderDetail> queryPartnerOrder(OrderPageRequest order) {
		List<BigOrderDetail> result = new ArrayList<BigOrderDetail>();
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
		
		List<Orders> orderList = ordersService.queryPartnerOrder(pageDto);
		order.setHasNext(orderList.size() == pageSize);
		for(Orders orderInfo : orderList){
			result.add(BeanUtil.a2b(orderInfo, BigOrderDetail.class));
		}
		return result;
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
		detail.setOrderNumber(orderInfo.getOrderNumber());
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
		return detail;
	}


}
