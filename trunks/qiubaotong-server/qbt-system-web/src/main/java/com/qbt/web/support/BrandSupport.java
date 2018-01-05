package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.brand.BrandPageReqVo;
import com.qbt.web.pojo.brand.BrandVo;

public interface BrandSupport {
	
	int add(BrandVo vo) throws BusinessException;
	
	boolean update(BrandVo vo) throws BusinessException;
	
	boolean delete(Integer id);
	
	BrandVo findById(Integer id);
	
	List<BrandVo> findByPage(BrandPageReqVo reqVo);
}
