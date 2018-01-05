package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseSpecialStore.BaseSpecialStorePageReqVo;
import com.qbt.web.pojo.baseSpecialStore.BaseSpecialStoreVo;

public interface BaseSpecialStoreSupport {

	List<BaseSpecialStoreVo> findByPage(BaseSpecialStorePageReqVo reqVo);

	void add(BaseSpecialStoreVo vo);

	void updateById(BaseSpecialStoreVo vo);

	BaseSpecialStoreVo findById(Integer id);

	void deleteById(Integer id);

}
