package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.bill.BillPageReqVo;
import com.qbt.web.pojo.bill.BillVo;


public interface BillSupport {
	List<BillVo> findByPage(BillPageReqVo reqVo);
	BillVo findById(Integer id);
	void updateNumberById(Integer id,String number,Integer userId,String userName);
	void updateRemark(BillVo vo);
}
