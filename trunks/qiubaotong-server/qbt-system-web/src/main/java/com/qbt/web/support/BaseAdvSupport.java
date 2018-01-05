package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseAdv.BaseAdvPageReqVo;
import com.qbt.web.pojo.baseAdv.BaseAdvVo;

public interface BaseAdvSupport {

	public void add(BaseAdvVo vo) throws BusinessException;

	public Boolean delete(Integer id);

	public Boolean update(BaseAdvVo reqVo);

	public List<BaseAdvVo> findByPage(BaseAdvPageReqVo reqVo);

	public BaseAdvVo findById(Integer id);
	
}
