package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteReqVo;
import com.qbt.web.pojo.baseCourseSfSite.BaseCourseSfSiteVo;

public interface BaseCourseSfSiteSupport {

	List<BaseCourseSfSiteVo> findByPage(BaseCourseSfSiteReqVo reqVo);

	void add(BaseCourseSfSiteVo vo);

	void updateById(BaseCourseSfSiteVo vo);

	BaseCourseSfSiteVo findById(Integer id);

	void deleteById(Integer id);

}
