package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RandomProvider;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.ActivityRule;
import com.qbt.persistent.entity.ActivityRuleConfig;
import com.qbt.persistent.entity.Coupon;
import com.qbt.service.ActivityRuleConfigService;
import com.qbt.service.ActivityRuleService;
import com.qbt.service.ActivityService;
import com.qbt.service.CommonService;
import com.qbt.service.CouponService;
import com.qbt.web.pojo.activity.ActivityAddReqVo;
import com.qbt.web.pojo.activity.ActivityPageReqVo;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.support.ActivitySupport;

@Service
public class ActivitySupportImpl implements ActivitySupport {
	
	@Resource
	private ActivityService activityService;
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private ActivityRuleService activityRuleService;
	
	@Resource
	private ActivityRuleConfigService activityRuleConfigService;
	
	@Resource
	private CommonService commonService;
	
	@Override
	public List<ActivityVo> findByPage(ActivityPageReqVo reqVo) {
		PageEntity<Activity> pageEntity = BeanUtil.pageConvert(reqVo, Activity.class);
		
		List<Activity> list = activityService.findByPage(pageEntity);
		List<ActivityVo> voList = new ArrayList<ActivityVo>();
		for(Activity act : list){
			ActivityVo vo = BeanUtil.a2b(act, ActivityVo.class);
			vo.setActivityStartTime(act.getStartTime());
			vo.setActivityEndTime(act.getEndTime());
			List<Coupon> couponList = couponService.selectCouponByActivityId(vo.getId());
			vo.setCouponCount(Checker.isNotEmpty(couponList) ? couponList.size() : 0);
			vo.setStartTime(act.getType() == 1 && Checker.isNotEmpty(couponList) ? couponList.get(0).getStartTime() : null);
			vo.setEndTime(act.getType() == 1 && Checker.isNotEmpty(couponList) ? couponList.get(0).getEndTime() : null);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public ActivityVo findById(Integer id) {
		Activity activity = activityService.findById(id);
		ActivityVo vo = BeanUtil.a2b(activity, ActivityVo.class);
		List<Coupon> couponList = couponService.selectCouponByActivityId(activity.getId());
		vo.setCouponCount(Checker.isNotEmpty(couponList) ? couponList.size() : 0);
		vo.setActivityStartTime(activity.getStartTime());
		vo.setActivityEndTime(activity.getEndTime());
		vo.setStartTime(activity.getType() == 1 && Checker.isNotEmpty(couponList) ? couponList.get(0).getStartTime() : null);
		vo.setEndTime(activity.getType() == 1 && Checker.isNotEmpty(couponList) ? couponList.get(0).getEndTime() : null);
		return vo;
	}

	@Override
	public int add(ActivityAddReqVo vo) {
		/**
		 * 新增活动的时候，可选规则或不选规则。
		 * 选了规则的情况，生成券的时候，要根据规则配置进行拆分多少个券和子券，
		 * 总券的个数等于，生成券的数X规则的总数量，一个code对应多个child_code。
		 * 比如100礼包生成10个券，配置：20 X2 和30X2,要生成总券10X(2+2)=40个，
		 * 10个不一致的code及每个code对应4不同的chid_code券码，
		 * 券表添加一字段limit_amount冗余配置表的limit_amount限额值。
		 */
		
		//查询是否存在重复活动名称或暗号
		if(vo.getType() == 1) { //限量券活动
			int count = activityService.isExist(vo.getName(), vo.getCode());
			if(count > 0){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "已存在活动名称或暗号");
			}
		}else if(vo.getType() == 2) { //不限量券活动
			List<Activity> actList = activityService.findByCondition(new Activity());
			Set<String> actCodes = new HashSet<String>();
			for(Activity a : actList) {
				actCodes.add(a.getCode());
			}
			vo.setCode(generateActivityCode(actCodes));
			int count = activityService.isExist(vo.getName(), null);
			if(count > 0){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "已存在活动名称");
			}
		}
		
		ActivityRule rule = null;
		if(vo.getRuleId() > 0){
			rule = activityRuleService.findById(vo.getRuleId());
			if(Checker.isEmpty(rule) || rule.getStatus() == 2){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效活动规则");
			}
			vo.setRuleName(rule.getName());
		}
		
		Activity activity = BeanUtil.a2b(vo, Activity.class);
		activity.setStartTime(vo.getActivityStartTime());
		activity.setEndTime(vo.getActivityEndTime());
		int activityId = activityService.insert(activity);
		if(activity.getType() == 1) { // 限量券活动
			List<Coupon> couponList = new ArrayList<Coupon>();
			Coupon coupon = null;
			if(activityId > 0 && vo.getRuleId() == 0){
				//生成券
				for(int i = 0; i < vo.getCouponCount(); i++){
					coupon = new Coupon();
					coupon.setActivityId(activityId);//活动id
					String code = commonService.createCouponCode();
					coupon.setCode(code);//生成随机券码
					coupon.setChildCode(code);
					coupon.setStatus(1);//1-未使用
					coupon.setClaimType(0);//0-未领取
					coupon.setType(vo.getCouponType());//现金券
					coupon.setAmount(vo.getAmount());
					coupon.setChildAmount(vo.getAmount());
					coupon.setStartTime(vo.getStartTime());
					coupon.setEndTime(vo.getEndTime());
					coupon.setLimitAmount(0d);
					coupon.setOrderId(0);
					coupon.setLockStatus(0);//0-非锁定 1-锁定
					couponList.add(coupon);
				}
			}else if(activityId > 0 && vo.getRuleId() != 0){
				List<ActivityRuleConfig> configs = activityRuleConfigService.findByRuleId(rule.getId());
				int configsSize = Checker.isNotEmpty(configs) ? configs.size() : 0;
				for(int i = 0; i < vo.getCouponCount(); i++){
					String code = commonService.createCouponCode();
					for(int j = 0; j < configsSize; j++){
						ActivityRuleConfig config = configs.get(j);
						for(int k = 0; k < config.getNumber(); k++){
							String childCode = commonService.createCouponCode();
							coupon = new Coupon();
							coupon.setActivityId(activityId);//活动id
							coupon.setCode(code);//生成随机券码
							coupon.setChildCode(childCode);
							coupon.setAmount(rule.getAmount());
							coupon.setChildAmount(config.getAmount());
							coupon.setStartTime(vo.getStartTime());
							coupon.setEndTime(vo.getEndTime());
							coupon.setStatus(1);//1-未使用
							coupon.setClaimType(0);//0-未领取
							coupon.setType(vo.getCouponType());//现金券
							coupon.setLimitAmount(config.getLimitAmount());
							coupon.setOrderId(0);
							coupon.setLockStatus(0);//0-非锁定 1-锁定
							couponList.add(coupon);
						}
					}
				}
			}
			if(Checker.isNotEmpty(couponList)){
				couponService.insertByBatch(couponList);
			}
		}
		return activityId;
	}
	
	private String generateActivityCode(Set<String> actCodes) {
		//暗码，唯一索引(暗号为4-6位的英文字母和数字组合)
		String code = RandomProvider.random(6);
		boolean flag = actCodes.add(code);
		while (!flag) {
			generateActivityCode(actCodes);
		}
		return code;
	}

	@Override
	public boolean updateStatus(ActivityVo vo) {
		Activity activity = activityService.findById(vo.getId());
		if(Checker.isEmpty(activity)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效活动数据");
		}
		activity.setStatus(vo.getStatus());
		return activityService.update(activity) > 0;
	}
	
}
