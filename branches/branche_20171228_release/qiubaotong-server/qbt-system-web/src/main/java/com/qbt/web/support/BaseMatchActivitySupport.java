package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseMatchActivity.BaseMatchActivityPageReqVo;
import com.qbt.web.pojo.baseMatchActivity.BaseMatchActivityVo;

public interface BaseMatchActivitySupport {

	List<BaseMatchActivityVo> findByPage(BaseMatchActivityPageReqVo reqVo);

	void add(BaseMatchActivityVo vo);

	void updateById(BaseMatchActivityVo vo);

	BaseMatchActivityVo findById(Integer id);

	void deleteById(Integer id);

}
