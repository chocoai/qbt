package com.qbt.web.support;

import java.util.Map;

import com.qbt.web.pojo.bill.BillPageReqVo;

public interface BillSupport {
	public Map<String, Object> export(String title,  BillPageReqVo vo);
}
