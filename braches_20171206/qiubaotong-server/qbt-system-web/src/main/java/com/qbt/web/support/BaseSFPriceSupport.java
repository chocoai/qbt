package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.web.pojo.baseSFPrice.BaseSFPricePageReqVo;
import com.qbt.web.pojo.baseSFPrice.BaseSFPriceVo;

public interface BaseSFPriceSupport {

	List<BaseSFPriceVo> findByPage(BaseSFPricePageReqVo reqVo);

	void deleteById(Integer id);

	void add(BaseSFPriceVo vo);

	void updateById(BaseSfPrice baseSfPrice);

}
