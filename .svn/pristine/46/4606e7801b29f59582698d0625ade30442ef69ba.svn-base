package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OrgGroupAmountConfig;
import com.qbt.service.OrgGroupAmountConfigService;
import com.qbt.web.support.OrgGroupAmountConfigSupport;

@Service
public class OrgGroupAmountConfigSupportImpl implements OrgGroupAmountConfigSupport{

	@Resource
	private OrgGroupAmountConfigService orgGroupAmountConfigService;
	
	@Override
	public OrgGroupAmountConfig suitableOrgGroupAmountConfig(Double amount, Integer orgId) {
		OrgGroupAmountConfig orgGroupAmountConfig = orgGroupAmountConfigService.selectProperAmountConfig(amount, orgId);
		if(Checker.isNotEmpty(orgGroupAmountConfig)){
			return orgGroupAmountConfig;
		}else {
			return null;
		}
		
	}

}
