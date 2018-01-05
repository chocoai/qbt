package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.basePartner.BasePartnerPageReqVo;
import com.qbt.web.pojo.basePartner.BasePartnerVO;

public interface BasePartnerSupport {

	void insert(BasePartnerVO vo);

	List<BasePartnerVO> findByPage(BasePartnerPageReqVo reqVo);

	void update(BasePartnerVO vo);

	BasePartnerVO findById(Integer id);

	void updateStatus(Integer id, int status);

}
