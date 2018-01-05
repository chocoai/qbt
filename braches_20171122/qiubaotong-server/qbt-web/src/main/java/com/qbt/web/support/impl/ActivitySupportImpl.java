package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.ActivityOff;
import com.qbt.persistent.entity.ActivityOffAmountConfig;
import com.qbt.persistent.entity.ActivityOffConfig;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.ActivityOffAmountConfigService;
import com.qbt.service.ActivityOffConfigService;
import com.qbt.service.ActivityOffService;
import com.qbt.service.ActivityService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.service.CommonService;
import com.qbt.service.OrderInfoService;
import com.qbt.web.pojo.activity.ActivityInfoVo;
import com.qbt.web.pojo.activity.ActivityOffAmountConfigVo;
import com.qbt.web.pojo.activity.ActivityOffConfigVo;
import com.qbt.web.pojo.activity.ActivityOrderRequest;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.activity.OrderActivity;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.shoppingCart.ShoppingCart;
import com.qbt.web.support.ActivitySupport;

/**
 *  活动支持
  * @ClassName: ActivitySupportImpl
  * @Description: TODO
  * @author share 2016年9月7日
  * @modify share 2016年9月7日
 */
@Service
public class ActivitySupportImpl implements ActivitySupport {

	@Resource
	private OrderInfoService orderInfoService;
	@Resource
	private ActivityOffService activityOffService;
	@Resource
	private ActivityOffAmountConfigService activityOffAmountConfigService;
	@Resource
	private ActivityService activityService;
	@Resource
	private BaseSfAreaService baseSfAreaService;
	@Resource
	private ActivityOffConfigService activityOffConfigService;
	@Resource
	private CommonService commonService;
	
	
	@Override
	public OrderActivity checkOrder(String orderId) {
		OrderInfo orderInfo = orderInfoService.findByNumber(orderId);
		
		int jAddrType = orderInfo.getjAddrType();
		int jAddrId = orderInfo.getjAddrId();
		int jAreaId = orderInfo.getjAreaId();
		String jAddrName = orderInfo.getjAddrName();
		int dAddrType = orderInfo.getdAddrType();
		int dAddrId = orderInfo.getdAddrId();
		int dAreaId = orderInfo.getdAreaId();
		String dAddrName = orderInfo.getdAddrName();
		double freight = orderInfo.getFreight();
		LogCvt.info("寄包地址信息，寄包类型："+jAddrType+",寄包地址："+jAddrName+",收包类型："+dAddrType+",收包地址："+dAddrName+",总金额："+freight);
		OrderActivity orderActivity = checkActivityOff(freight, jAddrType, jAddrId, jAreaId, dAddrType, dAddrId, dAreaId);
		orderActivity.setOrderId(orderId);
		return orderActivity;
	}
	
	
	/**
	 *  检查购物车订单信息是否满足满减
	  * @Title: checkShoppingCart
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param cart
	  * @return
	  * @see com.qbt.web.support.ActivitySupport#checkShoppingCart(com.qbt.persistent.entity.OrderShoppingCart)
	 */
	@Override
	public void checkShoppingCart(ShoppingCart cart) {
		int jAddrType = cart.getjAddrType();
		int jAddrId = cart.getjAddrId();
		int jAreaId = cart.getjAreaId();
		String jAddrName = cart.getjAddrName();
		int dAddrType = cart.getdAddrType();
		int dAddrId = cart.getdAddrId();
		int dAreaId = cart.getdAreaId();
		String dAddrName = cart.getdAddrName();
		double freight = cart.getFreight();
		LogCvt.info("寄包地址信息，寄包类型："+jAddrType+",寄包地址："+jAddrName+",收包类型："+dAddrType+",收包地址："+dAddrName+",总金额："+freight);
		OrderActivity orderActivity = checkActivityOff(freight, jAddrType, jAddrId, jAreaId, dAddrType, dAddrId, dAreaId);
		if(orderActivity.getdActivity() || orderActivity.getjActivity()){
			cart.setjActivity(orderActivity.getjActivity());
			cart.setdActivity(orderActivity.getdActivity());
			cart.setjAmount(orderActivity.getjAmount());
			cart.setdAmount(orderActivity.getdAmount());
		}
	}

	/**
	 *  检查子订单是否参与满减
	  * @Title: checkSubOrderInfo
	  * @Description: TODO
	  * @author: share 2016年10月18日
	  * @modify: share 2016年10月18日
	  * @param cart
	  * @see com.qbt.web.support.ActivitySupport#checkSubOrderInfo(com.qbt.web.pojo.order.OrderDetail)
	 */
	@Override
	public void checkSubOrderInfo(OrderDetail cart) {
		int jAddrType = cart.getjAddrType();
		int jAddrId = cart.getjAddrId();
		int jAreaId = cart.getjAreaId();
		String jAddrName = cart.getjAddressName();
		int dAddrType = cart.getdAddrType();
		int dAddrId = cart.getdAddrId();
		int dAreaId = cart.getdAreaId();
		String dAddrName = cart.getdAddressName();
		double freight = cart.getFreight();
		LogCvt.info("寄包地址信息，寄包类型："+jAddrType+",寄包地址："+jAddrName+",收包类型："+dAddrType+",收包地址："+dAddrName+",总金额："+freight);
		OrderActivity orderActivity = checkActivityOff(freight, jAddrType, jAddrId, jAreaId, dAddrType, dAddrId, dAreaId);
		if(orderActivity.getdActivity() || orderActivity.getjActivity()){
			cart.setjActivity(orderActivity.getjActivity());
			cart.setdActivity(orderActivity.getdActivity());
			cart.setjAmount(orderActivity.getjAmount());
			cart.setdAmount(orderActivity.getdAmount());
			cart.setActivityId(orderActivity.getActivityId());
		}
	}

	
	private OrderActivity checkActivityOff(double freight, int jAddrType, int jAddrId,
			int jAreaId, int dAddrType, int dAddrId, int dAreaId) {
		OrderActivity orderActivity = new OrderActivity();
		// 检查地区信息
		// 1-球场 2-地区
		int scope = 2;
		// 寄包地区信息
		BaseSfArea area = baseSfAreaService.findById(jAreaId);
		LogCvt.info("寄包地区信息："+area.getTreePath());
		// 区级信息获取市ID
		if(area.getLevel() == 4){
			jAreaId = area.getParentId();
		}
		ActivityOff jctivityOff = activityOffService.checkActivityId(scope, jAreaId);
		// 收包地区信息
		area = baseSfAreaService.findById(dAreaId);
		LogCvt.info("收包地区信息："+area.getTreePath());
		// 区级信息获取市ID
		if(area.getLevel() == 4){
			dAreaId = area.getParentId();
		}
		ActivityOff dctivityOff = activityOffService.checkActivityId(scope, dAreaId);
		long jstartTime = 0;
		long dstartTime = 0;
		if(jctivityOff != null || dctivityOff != null){
			if(jctivityOff != null){
				jstartTime = jctivityOff.getStartTime().getTime();
			}
			if(dctivityOff != null){
				dstartTime = dctivityOff.getStartTime().getTime();
			}
			if(jstartTime !=0 && dstartTime !=0){
				if(jstartTime <= dstartTime){
					return jOrderActivity(jctivityOff, freight);
				}else{
					return dOrderActivity(dctivityOff, freight);
				}
			}else{
				if(jstartTime > 0){
					return jOrderActivity(jctivityOff, freight);
				}else{
					return dOrderActivity(dctivityOff, freight);
				}
			}
			
		}
		
		
		// 首先匹配球场满减优惠
		scope = 1;
		// 寄包球场
		jctivityOff = null;
		if(jAddrType == 1){
			jctivityOff = activityOffService.checkActivityId(scope, jAddrId);
		}
		// 收包球场
		dctivityOff = null;
		if(dAddrType == 1){
			dctivityOff = activityOffService.checkActivityId(scope, dAddrId);
		}
		
		// 匹配球场活动时间开始优先级
		if(jctivityOff != null || dctivityOff != null){
			if(jctivityOff != null){
				jstartTime = jctivityOff.getStartTime().getTime();
			}
			if(dctivityOff != null){
				dstartTime = dctivityOff.getStartTime().getTime();
			}
			
			if(jstartTime !=0 && dstartTime !=0){
				if(jstartTime <= dstartTime){
					return jOrderActivity(jctivityOff, freight);
				}else{
					return dOrderActivity(dctivityOff, freight);
				}
			}else{
				if(jstartTime > 0){
					return jOrderActivity(jctivityOff, freight);
				}else{
					return dOrderActivity(dctivityOff, freight);
				}
			}
		}
		
		return orderActivity;
	}

	/**
	 *  寄方优惠活动
	  * @Title: jOrderActivity
	  * @Description: TODO
	  * @author: share 2016年9月9日
	  * @modify: share 2016年9月9日
	  * @param jctivityOff
	  * @param orderInfo
	  * @return
	 */
	private OrderActivity jOrderActivity(ActivityOff jctivityOff,double totalAmount) {
		OrderActivity orderActivity = new OrderActivity();
		List<ActivityOffAmountConfig> activityConfitList = activityOffAmountConfigService.findByActivityId(jctivityOff.getId());
		ActivityOffAmountConfig config = getFraviteAmount(activityConfitList, totalAmount);
		if(config != null){
			orderActivity.setActivityId(jctivityOff.getId());
			orderActivity.setActivitName(config.getActivityName());
			orderActivity.setjAmount(config.getAmountType() == 1 ? config.getAmount() : Arith.mul(totalAmount, Arith.div(config.getAmount(), 100)));
			orderActivity.setjActivity(true);
			orderActivity.setActivityType(jctivityOff.getType());
		}
		return orderActivity;
	}

	/**
	 *  收方优惠活动
	  * @Title: jOrderActivity
	  * @Description: TODO
	  * @author: share 2016年9月9日
	  * @modify: share 2016年9月9日
	  * @param jctivityOff
	  * @param orderInfo
	  * @return
	 */
	private OrderActivity dOrderActivity(ActivityOff dctivityOff,double totalAmount) {
		OrderActivity orderActivity = new OrderActivity();
		List<ActivityOffAmountConfig> activityConfitList = activityOffAmountConfigService.findByActivityId(dctivityOff.getId());
		ActivityOffAmountConfig config = getFraviteAmount(activityConfitList, totalAmount);
		if(config != null){
			orderActivity.setActivityId(dctivityOff.getId());
			orderActivity.setActivitName(config.getActivityName());
			orderActivity.setdAmount(config.getAmountType() == 1 ? config.getAmount() : Arith.mul(totalAmount, Arith.div(config.getAmount(), 100)));
			orderActivity.setdActivity(true);
			orderActivity.setActivityType(dctivityOff.getType());
		}
		return orderActivity;
	}

	private ActivityOffAmountConfig getFraviteAmount(List<ActivityOffAmountConfig> activityConfitList,double amount){
		
		for(ActivityOffAmountConfig config : activityConfitList){
			if(amount >= config.getLimitAmount()){
				LogCvt.info("已匹配最优活动金额："+amount+",优惠/折扣:"+config.getAmount()+(config.getAmountType() == 2 ? "%" : ""));
				return config;
			}
			LogCvt.info("非匹配活动金额："+amount+",优惠限额:"+config.getLimitAmount()+",条件无法满足.");
		}
		return null;
	}

	/**
	 *  活动列表查询
	  * @Title: list
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param type 1-进行中 2-即将开始 3-已结束
	  * @return
	  * @see com.qbt.web.support.ActivitySupport#list(int)
	 */
	@Override
	public List<ActivityVo> list(int type) {
		if(!(type >=1&&type <=3)){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "参数错误");
		}
		List<ActivityOff> activityOffList = activityOffService.list(type);
		List<ActivityVo> list = BeanUtil.list2list(activityOffList, ActivityVo.class);
		return list;
	}

	/**
	 *  活动详情
	  * @Title: detail
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @param id
	  * @return
	  * @see com.qbt.web.support.ActivitySupport#detail(int)
	 */
	@Override
	public ActivityInfoVo detail(int id) {
		ActivityOff off = activityOffService.findById(id);
		 new ActivityInfoVo();
		if(Checker.isNotEmpty(off)){
			ActivityInfoVo vo = BeanUtil.a2b(off, ActivityInfoVo.class);
			
			List<ActivityOffConfig> configs = activityOffConfigService.findByActivityId(id);
			List<ActivityOffConfigVo> voList = BeanUtil.list2list(configs, ActivityOffConfigVo.class);
			vo.setConfigs(voList);
			
			List<ActivityOffAmountConfig> amountConfigs = activityOffAmountConfigService.findByActivityId(id);
			List<ActivityOffAmountConfigVo> amountVoList = BeanUtil.list2list(amountConfigs, ActivityOffAmountConfigVo.class);
			vo.setAmountConfigs(amountVoList);
			return vo;
		}else{
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "活动不存在");
		}
		
	}


	@Override
	public void cachePayOrderActivity(int bigOrderId, List<OrderActivity> activityList) {
		String key = RedisKeyUtil.pay_order_suborder_activity_key(String.valueOf(bigOrderId));
		commonService.unlock(key);
		commonService.lock(key, JSonUtil.toJSonString(activityList), 30 * 60 *1000);
	}


	@Override
	public List<OrderActivity> getCachePayOrderActivity(int bigOrderId) {
		String key = RedisKeyUtil.pay_order_suborder_activity_key(String.valueOf(bigOrderId));
		String json = commonService.getLockValue(key);
		List<?> list = JSonUtil.toObject(json, List.class);
		List<OrderActivity> activityList = new ArrayList<OrderActivity>();
		if(Checker.isNotEmpty(list)){
			for(Object obj : list){
				activityList.add(JSonUtil.toObject(JSonUtil.toJSonString(obj), OrderActivity.class));
			}
		}
		list.clear();
		commonService.unlock(key);
		return activityList;
	}


	@Override
	public OrderActivity checkActivityOff(ActivityOrderRequest request) {
		return checkActivityOff(request.getFreight(), request.getjAddrType(), request.getjAddrId(), request.getjAreaId(),
				request.getdAddrType(), request.getdAddrId(), request.getdAreaId());
	}

}
