package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.vipType.VipTypePageReqVo;
import com.qbt.web.pojo.vipType.VipTypeVo;

public interface VipTypeSupport {

	List<VipTypeVo> findByPage(VipTypePageReqVo reqVo);

	VipTypeVo findById(Integer id);

	void updateStatus(VipTypeVo vo);

	void add(VipTypeVo vo);

}
