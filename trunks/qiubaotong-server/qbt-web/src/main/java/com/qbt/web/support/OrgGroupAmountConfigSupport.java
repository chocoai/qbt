package com.qbt.web.support;

import com.qbt.persistent.entity.OrgGroupAmountConfig;

public interface OrgGroupAmountConfigSupport {

	OrgGroupAmountConfig suitableOrgGroupAmountConfig(Double amount, Integer orgId);

}
