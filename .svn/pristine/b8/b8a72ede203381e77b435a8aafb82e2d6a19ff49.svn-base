package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseSfTime.BaseSfTimePageReqVo;
import com.qbt.web.pojo.baseSfTime.BaseSfTimeVo;

public interface BaseSfTimeSupport {

	List<BaseSfTimeVo> findByPage(BaseSfTimePageReqVo reqVo);

	void add(BaseSfTimeVo vo) throws BusinessException;

	void updateById(BaseSfTimeVo vo) throws BusinessException;

	BaseSfTimeVo findById(Integer id);

	void deleteById(Integer id);

}
