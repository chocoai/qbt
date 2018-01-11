package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.vipOrder.VipOrderRequest;

public interface VipOrderSupport {

	Map<String, Object> export(SysUser sysUser, String title, VipOrderRequest req);

}
