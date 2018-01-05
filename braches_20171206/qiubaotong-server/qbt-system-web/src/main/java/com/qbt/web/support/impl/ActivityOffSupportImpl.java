package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ActivityOffPriority;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.ActivityOff;
import com.qbt.persistent.entity.ActivityOffAmountConfig;
import com.qbt.persistent.entity.ActivityOffConfig;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.service.ActivityOffAmountConfigService;
import com.qbt.service.ActivityOffConfigService;
import com.qbt.service.ActivityOffService;
import com.qbt.service.BaseCourseService;
import com.qbt.service.BaseSfAreaService;
import com.qbt.web.pojo.activityOff.ActivityOffAmountConfigVo;
import com.qbt.web.pojo.activityOff.ActivityOffConfigVo;
import com.qbt.web.pojo.activityOff.ActivityOffDetailVo;
import com.qbt.web.pojo.activityOff.ActivityOffPageReqVo;
import com.qbt.web.pojo.activityOff.ActivityOffVo;
import com.qbt.web.pojo.order.OrderActivityRequestVo;
import com.qbt.web.pojo.order.OrderActivityResponseVo;
import com.qbt.web.support.ActivityOffSupport;

@Service
public class ActivityOffSupportImpl implements ActivityOffSupport {
	
	@Resource
	private ActivityOffService activityOffService;
	
	@Resource
	private ActivityOffConfigService activityOffConfigService;
	
	@Resource
	private ActivityOffAmountConfigService activityOffAmountConfigService;
	
	@Resource
	private BaseSfAreaService baseSfAreaService;
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Override
	public int add(ActivityOffDetailVo vo) throws BusinessException {
		//校验活动时间
		if(vo.getStartTime().compareTo(vo.getEndTime()) > 0){
			throw new BusinessException("起始时间不能大于开始时间");
		}
		//设置权重
		if(vo.getType() == 3){
			vo.setScope(1);//球场
			vo.setPriority(ActivityOffPriority.course_cut.getPriority());
		}else if(vo.getType() == 4){
			vo.setScope(2);//地区
			vo.setPriority(ActivityOffPriority.area_cut.getPriority());
		}
		
		if(vo.getConfigs() == null || vo.getConfigs().isEmpty()){
			throw new BusinessException("活动地域或球场配置不能为空");
		}
		
		if(vo.getAmountConfigs() == null || vo.getAmountConfigs().isEmpty()){
			throw new BusinessException("活动限额金额不能为空");
		}
		
		ActivityOff off = BeanUtil.a2b(vo, ActivityOff.class);
		off.setStatus(1);
		List<ActivityOffConfig> configList = BeanUtil.list2list(vo.getConfigs(), ActivityOffConfig.class);
		//规则范围配置检查
		for(ActivityOffConfig c : configList){
			if(vo.getScope() == 1){
				//球场
				BaseCourse course = baseCourseService.findById(c.getScopeId());
				if(Checker.isEmpty(course)){
					throw new BusinessException("查无此球场");
				}
				c.setScopeName(course.getName());
			}else if(vo.getScope() == 2){
				//地区
				BaseSfArea area = baseSfAreaService.findById(c.getScopeId());
				if(Checker.isEmpty(area)){
					throw new BusinessException("查无此地区");
				}
				c.setScopeName(area.getTreePath());
			}
			
		}
		// 规则金额配置检查
		List<ActivityOffAmountConfig> amountList = BeanUtil.list2list(vo.getAmountConfigs(), ActivityOffAmountConfig.class);
		for(ActivityOffAmountConfig amount : amountList){
			if(amount.getAmountType() == 1 && amount.getAmount() > amount.getLimitAmount()){
				throw new BusinessException("优惠金额不能大于限制金额");
			}else if(amount.getAmountType() == 2 
					&& (amount.getAmount() < 0 || amount.getAmount() > 100)){
				throw new BusinessException("无效优惠折扣");
			}
		}
		
		int id = activityOffService.insert(off);
		if(id > 0){
			for(ActivityOffConfig c : configList){
				c.setActivityId(id);
				c.setActivityName(off.getName());
			}
			for(ActivityOffAmountConfig amount : amountList){
				amount.setActivityId(id);
				StringBuilder activityName = new StringBuilder();
				activityName.append("满")
						.append(amount.getLimitAmount())
						.append("减")
						.append(amount.getAmount())
						.append(amount.getAmountType() == 2 ? "%" : "元");
				amount.setActivityName(activityName.toString());
			}
			activityOffConfigService.insertByBatch(configList);
			activityOffAmountConfigService.insertByBatch(amountList);
		}
		
		return id;
	}

	@Override
	public boolean update(Integer id) throws BusinessException {
		ActivityOff query = activityOffService.findById(id);
		if(query.getStatus() == 2){
			throw new BusinessException("活动已被禁用, 不能再次启用");
		}
		ActivityOff off = new ActivityOff();
		off.setId(id);
		off.setStatus(2);
		int result1 = activityOffService.updateById(off);
		return result1 > 0;
	}

	@Override
	public boolean delete(Integer id) {
		int result1 = activityOffConfigService.deleteByActivityId(id);
		int result2 = activityOffAmountConfigService.deleteByActivityId(id);
		int result3 = activityOffService.deleteById(id);
		return result1 + result2 + result3 > 0;
	}

	@Override
	public ActivityOffDetailVo findById(Integer id) {
		ActivityOff off = activityOffService.findById(id);
		ActivityOffDetailVo detail = BeanUtil.a2b(off, ActivityOffDetailVo.class);
		if(Checker.isNotEmpty(detail)){
			List<ActivityOffConfig> configs = activityOffConfigService.findByActivityId(id);
			List<ActivityOffConfigVo> voList = BeanUtil.list2list(configs, ActivityOffConfigVo.class);
			detail.setConfigs(voList);
			
			List<ActivityOffAmountConfig> amountConfigs = activityOffAmountConfigService.findByActivityId(id);
			List<ActivityOffAmountConfigVo> amountVoList = BeanUtil.list2list(amountConfigs, ActivityOffAmountConfigVo.class);
			detail.setAmountConfigs(amountVoList);
		}
		return detail;
	}

	@Override
	public List<ActivityOffVo> findByPage(ActivityOffPageReqVo reqVo) {
		PageEntity<ActivityOff> pageEntity = BeanUtil.pageConvert(reqVo, ActivityOff.class);
		
		List<ActivityOff> list = activityOffService.findByPage(pageEntity);
		List<ActivityOffVo> voList = BeanUtil.list2list(list, ActivityOffVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public OrderActivityResponseVo checkActivity(OrderActivityRequestVo orderActivityVo) {
		int jAddrType = orderActivityVo.getjAddrType();
		int jAddrId = orderActivityVo.getjAddrId();
		int jAreaId = orderActivityVo.getjAreaId();
		String jAddrName = orderActivityVo.getjAddrName();
		int dAddrType = orderActivityVo.getdAddrType();
		int dAddrId = orderActivityVo.getdAddrId();
		int dAreaId = orderActivityVo.getdAreaId();
		String dAddrName = orderActivityVo.getdAddrName();
		double freight = orderActivityVo.getFreight();
		LogCvt.info("寄包地址信息，寄包类型："+jAddrType+",寄包地址："+jAddrName+",收包类型："+dAddrType+",收包地址："+dAddrName+",总金额："+freight);
		OrderActivityResponseVo orderActivity = checkActivityOff(freight, jAddrType, jAddrId, jAreaId, dAddrType, dAddrId, dAreaId);
		return orderActivity;
	}
	

	private OrderActivityResponseVo checkActivityOff(double totalAmount, int jAddrType, int jAddrId,
			int jAreaId, int dAddrType, int dAddrId, int dAreaId) {
		OrderActivityResponseVo orderActivity = new OrderActivityResponseVo();
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
					return jOrderActivity(jctivityOff,totalAmount);
				}else{
					return dOrderActivity(dctivityOff,totalAmount);
				}
			}else{
				if(jstartTime > 0){
					return jOrderActivity(jctivityOff,totalAmount);
				}else{
					return dOrderActivity(dctivityOff,totalAmount);
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
					return jOrderActivity(jctivityOff,totalAmount);
				}else{
					return dOrderActivity(dctivityOff,totalAmount);
				}
			}else{
				if(jstartTime > 0){
					return jOrderActivity(jctivityOff,totalAmount);
				}else{
					return dOrderActivity(dctivityOff,totalAmount);
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
	private OrderActivityResponseVo jOrderActivity(ActivityOff jctivityOff,double totalAmount) {
		OrderActivityResponseVo orderActivity = new OrderActivityResponseVo();
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
	private OrderActivityResponseVo dOrderActivity(ActivityOff dctivityOff,double totalAmount) {
		OrderActivityResponseVo orderActivity = new OrderActivityResponseVo();
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

}
