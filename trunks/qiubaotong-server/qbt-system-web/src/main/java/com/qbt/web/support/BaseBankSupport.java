package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.baseBank.BaseBankPageReqVo;
import com.qbt.web.pojo.baseBank.BaseBankVo;

public interface BaseBankSupport {

	List<BaseBankVo> findByPage(BaseBankPageReqVo reqVo);

	public void add(BaseBankVo vo) throws BusinessException;

	void updateById(BaseBankVo vo);

	Boolean delete(Integer id, Boolean isDelete);

}
