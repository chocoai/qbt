package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.enums.OrderSource;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.MD5Util;
import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.persistent.entity.OrderShoppingCart;
import com.qbt.service.BaseAirportService;
import com.qbt.service.BaseBankBranchService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.BaseSfPriceService;
import com.qbt.service.BaseSfSiteService;
import com.qbt.service.OrderShoppingCartService;
import com.qbt.service.UserAsApService;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.sf.DeliverRequest;
import com.qbt.web.pojo.shoppingCart.CartRequest;
import com.qbt.web.pojo.shoppingCart.ShoppingCart;
import com.qbt.web.support.ActivitySupport;
import com.qbt.web.support.CommonSupport;
import com.qbt.web.support.InsureTemplateSupport;
import com.qbt.web.support.SfExpressSupport;
import com.qbt.web.support.ShoppingCartSupport;
import com.qbt.web.support.SiteSupport;
import com.qbt.wechat.api.WechatApi;

/**
 *  购物车
  * @ClassName: ShoppingCartSupportImpl
  * @Description: TODO
  * @author share 2016年10月15日
  * @modify share 2016年10月15日
 */
@Service
public class ShoppingCartSupportImpl implements ShoppingCartSupport {
	
	@Resource
	private BaseSfPriceService baseSfPriceService;
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
	private OrderShoppingCartService shoppingCartService;
	@Resource
	private SfExpressSupport sfExpressSupport;
	@Resource
	private InsureTemplateSupport insureTemplateSupport;
	@Resource
	private UserAsApService userAsApService;
	@Resource
	private SiteSupport siteSupportImpl;
	@Resource
	private ActivitySupport activitySupport;
	@Resource
	private CommonSupport commonSupport;
	@Resource
	private WechatApi wechatApi;
	
	@Override
	public void addShoppingCart(OrderConfirm orderConfirm) {
		// TODO Auto-generated method stub
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
		
		int countQantity = shoppingCartService.count(orderConfirm.getUserId());
		if(countQantity + orderConfirm.getQuantity() > 99){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"清单球包超限，最多99包");
		}
		
		/**
		 * 购物车
		 */
		String deliverDate = orderConfirm.getDeliver_time();
		// 1-course球场，2-airport机场,3-bank银行,5-顺丰网店
		int srcType = orderConfirm.getSrc_type();
		int srcId = orderConfirm.getSrc_id();
		String jAddrName = "",dAddrName = "";
		jAddrName = siteSupportImpl.getAddrName(srcType, srcId);
		int destType = orderConfirm.getDest_type();
		int destId = orderConfirm.getDest_id();
		dAddrName = siteSupportImpl.getAddrName(destType, destId);
		// 购物车信息
		OrderShoppingCart shoppingCart = new OrderShoppingCart();
		shoppingCart.setProxyUserId(orderConfirm.getProxyUserId());
		shoppingCart.setUserId(orderConfirm.getUserId());
		shoppingCart.setOrderSource(OrderSource.weixin.getCode());
		shoppingCart.setSendSfUserTime(consignedTime);
		shoppingCart.setFreight(sfPrice);
		shoppingCart.setInsuredFee(insurePrice);
		shoppingCart.setInsuredRates(insureRate);
		shoppingCart.setInsuredValue((double)orderConfirm.getInsure_price());
		shoppingCart.setExpressType(orderConfirm.getBusiness_type());
		shoppingCart.setDeliverDate(deliverDate);
		shoppingCart.setSendTimeSection(orderConfirm.getConsigned_time());
		// 寄件信息
		shoppingCart.setjAddrType(orderConfirm.getSrc_type());
		shoppingCart.setjAddress(orderConfirm.getSrc_address());
		shoppingCart.setjAddrId(orderConfirm.getSrc_type() != 4?orderConfirm.getSrc_id():0);
		shoppingCart.setjAddrName(jAddrName);
		shoppingCart.setjAreaId(orderConfirm.getSrc_area_id());
		shoppingCart.setjContact(orderConfirm.getSrc_name());
		shoppingCart.setjMobile(orderConfirm.getSrc_moibile());
		shoppingCart.setjTreePath(orderConfirm.getSrc_province()+","+orderConfirm.getSrc_city()+","+orderConfirm.getSrc_district());
		// 收件信息
		shoppingCart.setdAddrType(orderConfirm.getDest_type());
		shoppingCart.setdAddress(orderConfirm.getDest_address());
		shoppingCart.setdAddrId(orderConfirm.getDest_type() != 4?orderConfirm.getDest_id():0);
		shoppingCart.setdAddrName(dAddrName);
		shoppingCart.setdAreaId(orderConfirm.getDest_area_id());
		shoppingCart.setdContact(orderConfirm.getDest_name());
		shoppingCart.setdMobile(orderConfirm.getDest_moibile());
		shoppingCart.setdTreePath(orderConfirm.getDest_province()+","+orderConfirm.getDest_city()+","+orderConfirm.getDest_district());
		shoppingCart.setQuantity(orderConfirm.getQuantity());
		// md5串
		String md5 = makeMd5(shoppingCart);
		shoppingCart.setMd5(md5);
		// 检查是否相同
		Integer cartId = shoppingCartService.checkExists(orderConfirm.getUserId(), md5);
		if(cartId != null && cartId > 0){
			shoppingCartService.addQuantity(cartId,orderConfirm.getQuantity());
		}else{
			shoppingCartService.insert(shoppingCart);
		}
		
	}
	
	/**
	 *  购物车MD5串 唯一值
	  * @Title: makeMd5
	  * @Description: TODO
	  * @author: share 2016年10月15日
	  * @modify: share 2016年10月15日
	  * @param shoppingCart
	  * @return
	 */
	private String makeMd5(OrderShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(shoppingCart.getUserId());
		sb.append(shoppingCart.getSendSfUserTime());
		sb.append(shoppingCart.getFreight());
		sb.append(shoppingCart.getDeliverDate());
		sb.append(shoppingCart.getSendTimeSection());
		sb.append(shoppingCart.getInsuredFee());
		sb.append(shoppingCart.getInsuredRates());
		sb.append(shoppingCart.getInsuredValue());
		sb.append(shoppingCart.getjAddress());
		sb.append(shoppingCart.getjAddrName());
		sb.append(shoppingCart.getjContact());
		sb.append(shoppingCart.getjMobile());
		sb.append(shoppingCart.getjTreePath());
		sb.append(shoppingCart.getjAddrId());
		sb.append(shoppingCart.getjAddrType());
		sb.append(shoppingCart.getjAreaId());
		sb.append(shoppingCart.getdAddress());
		sb.append(shoppingCart.getdAddrName());
		sb.append(shoppingCart.getdContact());
		sb.append(shoppingCart.getdMobile());
		sb.append(shoppingCart.getdTreePath());
		sb.append(shoppingCart.getdAddrId());
		sb.append(shoppingCart.getdAddrType());
		sb.append(shoppingCart.getdAreaId());
		sb.append(shoppingCart.getdAreaId());
		sb.append(shoppingCart.getExpressType());
		LogCvt.debug("购物车MD5加签值："+sb.toString());
		return MD5Util.MD5Encode(sb.toString(), "utf-8");
	}
	
	/**
	 *  拉取购物车
	  * @Title: getShoppingCart
	  * @Description: TODO
	  * @author: share 2016年10月15日
	  * @modify: share 2016年10月15日
	  * @param id
	  * @see com.qbt.web.support.ShoppingCartSupport#getShoppingCart(int)
	 */
	@Override
	public List<ShoppingCart> getShoppingCart(int id) {
		// TODO Auto-generated method stub
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		 List<OrderShoppingCart> shoppingCartList = shoppingCartService.findByUserId(id);
		 for(OrderShoppingCart cart : shoppingCartList){
			 ShoppingCart cartVo = BeanUtil.a2b(cart, ShoppingCart.class);
			 Date sendSfUserTime = cartVo.getSendSfUserTime();
			 if(sendSfUserTime.getTime() < System.currentTimeMillis()){
				 cartVo.setStatus(2);
				 cartVo.setRemark("超过了预约取件时间，订单已失效！");
				 cartList.add(cartVo);
				 continue;
			 }
			 // 非当天的取包时间的订单不检查时效
			 long diff = DateUtil.getDiffDays(sendSfUserTime, new Date());
			 if(diff > 1){
				 activitySupport.checkShoppingCart(cartVo);
				 cartList.add(cartVo);
				 continue;
			 }
			 // 检查官网时效.
			 double sfPrice = 0;
			 try {
				 DeliverRequest request = new DeliverRequest();
				 // 顺丰速运价格计算
				 if(cartVo.getjAddrType() == 1){
					 request.setSrc_course_id(cartVo.getjAddrId());
				 }
				 if(cartVo.getdAddrType() == 1){
					 request.setDest_course_id(cartVo.getdAddrId());
				 }
				 request.setBusiness_type(cartVo.getExpressType());
				 request.setSrc_area_id(cartVo.getjAreaId());
				 request.setDest_area_id(cartVo.getdAreaId());
				 request.setConsigned_time(DateUtil.formatDate(sendSfUserTime, DateUtil.DATE_TIME_FORMAT_01));
				 sfPrice = sfExpressSupport.query_sf_expect_price_v2(request);
			} catch (Exception e) {
				// TODO: handle exception
				LogCvt.error("拉取购物车清单校验球包订单时效失败："+e.getMessage(),e);
			}
			if(sfPrice != cart.getFreight()){
				 cartVo.setStatus(2);
				 cartVo.setRemark("超过了预约取件时间，订单已失效！");
			}else{
				activitySupport.checkShoppingCart(cartVo);
			}
			 // 设置状态
			 cartList.add(cartVo);
		 }
		 return cartList;
	}

	/**
	 *  更新购物车商品数量
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param id
	  * @param req
	  * @see com.qbt.web.support.ShoppingCartSupport#update(java.lang.Integer, com.qbt.web.pojo.shoppingCart.CartRequest)
	 */
	@Override
	public void update(CartRequest req) {
		// TODO Auto-generated method stub
		int[] ids = req.getIds();
		int[] nums = req.getNums();
		int userId = req.getUserId();
		int totalCount = 0;
		for(int num : nums){
			totalCount += num;
		}
		int countQantity = shoppingCartService.count(userId,ids);
		if(countQantity + totalCount > 99){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL,"清单球包超限，最多99包");
		}
		
		for(int i = 0; i< ids.length; i ++){
			int id = ids[i];
			int num = nums[i];
			shoppingCartService.updateQuantity(userId,id, num);
		}
		
	}

	/**
	 *  清除购物车
	  * @Title: delete
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param req
	  * @see com.qbt.web.support.ShoppingCartSupport#delete(com.qbt.web.pojo.shoppingCart.CartRequest)
	 */
	@Override
	public void delete(CartRequest req) {
		// TODO Auto-generated method stub
		int[] ids = req.getIds();
		int userId = req.getUserId();
		if(ids == null || ids.length == 0){
			LogCvt.error("无清单ID数据，清购物车清单失败");
			return;
		}
		shoppingCartService.deleteByIds(ids,userId);
	}

	/**
	 *  计算清单个数
	  * @Title: count
	  * @Description: TODO
	  * @author: share 2016年10月21日
	  * @modify: share 2016年10月21日
	  * @param userId
	  * @return
	  * @see com.qbt.web.support.ShoppingCartSupport#count(java.lang.Integer)
	 */
	@Override
	public Integer count(Integer userId) {
		// TODO Auto-generated method stub
		return shoppingCartService.count(userId);
	}
	
}
