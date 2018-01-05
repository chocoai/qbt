package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPricePageReqVo;
import com.qbt.web.pojo.baseNewSfPrice.BaseNewSfPriceVo;

public interface BaseNewSfPriceSupport {

	List<BaseNewSfPriceVo> findByPage(BaseNewSfPricePageReqVo reqVo);

	void add(BaseNewSfPriceVo vo);

	BaseNewSfPriceVo findById(Integer id);

	void update(BaseNewSfPriceVo vo);

	void delete(Integer id);

}
