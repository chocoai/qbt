package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseSfSite.BaseSfSitePageReqVo;
import com.qbt.web.pojo.baseSfSite.BaseSfSiteVo;

public interface BaseSfSiteSupport {

	List<BaseSfSiteVo> findByPage(BaseSfSitePageReqVo reqVo);

	void updateById(BaseSfSiteVo Vo);

	void add(BaseSfSiteVo vo) throws BusinessException;

	void deleteById(Integer id);

	BaseSfSiteVo findById(Integer id);
	
	Boolean delete(Integer id, Boolean isDelete);

}
