package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.Urgent;
import com.qbt.web.pojo.urgent.UrgentAddReqVo;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;


public interface UrgentSupport {

	List<UrgentVo> findByPage(UrgentPageReqVo reqVo);
	
	UrgentVo findById(Integer id);
	
	int add(UrgentAddReqVo vo);
	
	boolean update(UrgentVo vo);
	
	List<Urgent> findByCondition(UrgentVo vo);
	
	int deleteById(Integer id);
}
