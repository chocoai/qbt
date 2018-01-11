package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.thirdOrder.ThirdOrderPageReqVo;
import com.qbt.web.pojo.thirdOrder.ThirdOrderVo;

public interface ThirdOrderSupport {
	
	public List<ThirdOrderVo> findByPage(ThirdOrderPageReqVo reqVo);
	
	public Boolean settlement(ThirdOrderVo vo);
	
	public Boolean settlementBatch(ThirdOrderPageReqVo vo, SysUser sysUser);
	
	public Boolean findSettlementBatch(ThirdOrderPageReqVo vo);
	
}
