package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseSfArea.BaseSfAreaVo;

public interface BaseSfAreaSupport {

	public void add(BaseSfAreaVo vo) throws BusinessException;

	public BaseSfAreaVo findById(int id);

	public List<BaseSfAreaVo> findByParentId(int parentId);

	public void update(BaseSfAreaVo vo) throws BusinessException;

	public BaseSfAreaVo findByName(String name);

	public BaseSfAreaVo findByDistrict(String name, String district);

	public List<BaseSfAreaVo> findByLevel(int level);

	public List<BaseSfAreaVo> findDistrictByParentId(int id);
}
