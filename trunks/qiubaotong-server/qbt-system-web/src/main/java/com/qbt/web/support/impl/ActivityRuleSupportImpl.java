package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.ActivityRule;
import com.qbt.persistent.entity.ActivityRuleConfig;
import com.qbt.service.ActivityRuleConfigService;
import com.qbt.service.ActivityRuleService;
import com.qbt.web.pojo.activityRule.ActivityRuleConfigVo;
import com.qbt.web.pojo.activityRule.ActivityRuleDetailVo;
import com.qbt.web.pojo.activityRule.ActivityRulePageReqVo;
import com.qbt.web.pojo.activityRule.ActivityRuleVo;
import com.qbt.web.support.ActivityRuleSupport;

@Service
public class ActivityRuleSupportImpl implements ActivityRuleSupport {
	
	@Resource
	private ActivityRuleService activityRuleService;
	
	@Resource
	private ActivityRuleConfigService activityRuleConfigService;
	
	@Override
	public List<ActivityRuleVo> list() {
		List<ActivityRule> list = activityRuleService.findAllByStatus(1);//1-正常
		List<ActivityRuleVo> voList = BeanUtil.list2list(list, ActivityRuleVo.class);
		return voList;
	}

	@Override
	public List<ActivityRuleVo> findByPage(ActivityRulePageReqVo reqVo) {
		PageEntity<ActivityRule> pageEntity = BeanUtil.pageConvert(reqVo, ActivityRule.class);
		
		List<ActivityRule> list = activityRuleService.findByPage(pageEntity);
		List<ActivityRuleVo> voList = BeanUtil.list2list(list, ActivityRuleVo.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public ActivityRuleDetailVo findById(int id) {
		ActivityRule rule = activityRuleService.findById(id);
		ActivityRuleDetailVo vo = BeanUtil.a2b(rule, ActivityRuleDetailVo.class);
		List<ActivityRuleConfig> configs = activityRuleConfigService.findByRuleId(id);
		if(Checker.isNotEmpty(rule) && Checker.isNotEmpty(configs)){
			List<ActivityRuleConfigVo> configVos = BeanUtil.list2list(configs, ActivityRuleConfigVo.class);
			vo.setConfigs(configVos);
		}
		return vo;
	}

	@Override
	public int add(ActivityRuleDetailVo vo) throws BusinessException {
		//金额校验
		double ruleAmount = vo.getAmount();
		if(Checker.isNotEmpty(vo.getConfigs())){
			double configAmount = 0;
			for(ActivityRuleConfigVo c : vo.getConfigs()){
				configAmount += Arith.mul(c.getAmount(), c.getNumber());
			}
			if(ruleAmount != configAmount){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "规则总金额与配置总金额不相等");
			}
		}
		
		ActivityRule rule = BeanUtil.a2b(vo, ActivityRule.class);
		int ruleId = activityRuleService.insert(rule);
		if(ruleId > 0 && Checker.isNotEmpty(vo.getConfigs())){
			List<ActivityRuleConfig> configs = new ArrayList<ActivityRuleConfig>();
			ActivityRuleConfig config = null;
			for(ActivityRuleConfigVo c : vo.getConfigs()){
				config = BeanUtil.a2b(c, ActivityRuleConfig.class);
				config.setRuleId(ruleId);
				configs.add(config);
			}
			activityRuleConfigService.insertByBatch(configs);
		}
		return ruleId;
	}

	@Override
	public boolean update(ActivityRuleDetailVo vo) throws BusinessException {
		//金额校验
		double ruleAmount = vo.getAmount();
		if(Checker.isNotEmpty(vo.getConfigs())){
			double configAmount = 0;
			for(ActivityRuleConfigVo c : vo.getConfigs()){
				configAmount += Arith.mul(c.getAmount(), c.getNumber());
			}
			if(ruleAmount != configAmount){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "规则总金额与配置总金额不相等");
			}
		}
		ActivityRule rule = BeanUtil.a2b(vo, ActivityRule.class);
		int ruleId = vo.getId();
		int c1 = activityRuleService.updateById(rule);
		int c2 = 0;
		if(c1 > 0){
			//先删除配置，再添加
			activityRuleConfigService.deleteByRuleId(ruleId);
			if(Checker.isNotEmpty(vo.getConfigs())){
				List<ActivityRuleConfig> configs = new ArrayList<ActivityRuleConfig>();
				ActivityRuleConfig config = null;
				for(ActivityRuleConfigVo c : vo.getConfigs()){
					config = BeanUtil.a2b(c, ActivityRuleConfig.class);
					config.setRuleId(ruleId);
					configs.add(config);
				}
				c2 = activityRuleConfigService.insertByBatch(configs);
			}
		}
		return c1 + c2 > 0;
	}

}
