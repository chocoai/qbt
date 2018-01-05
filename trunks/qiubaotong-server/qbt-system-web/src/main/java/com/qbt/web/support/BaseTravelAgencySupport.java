package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyPageReqVo;
import com.qbt.web.pojo.baseTravelAgency.BaseTravelAgencyVo;

public interface BaseTravelAgencySupport {

	List<BaseTravelAgencyVo> findByPage(BaseTravelAgencyPageReqVo reqVo);

	void add(BaseTravelAgencyVo vo);

	void updateById(BaseTravelAgencyVo vo);

	BaseTravelAgencyVo findById(Integer id);

	void deleteById(Integer id);

}
