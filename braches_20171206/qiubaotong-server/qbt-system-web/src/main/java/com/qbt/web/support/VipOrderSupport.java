package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.vipOrder.VipOrderPageReqVo;
import com.qbt.web.pojo.vipOrder.VipOrderVo;

public interface VipOrderSupport {

	List<VipOrderVo> findByPage(VipOrderPageReqVo reqVo);

	VipOrderVo findById(Integer id);

	boolean upOrderSettlement(Integer id);
}
