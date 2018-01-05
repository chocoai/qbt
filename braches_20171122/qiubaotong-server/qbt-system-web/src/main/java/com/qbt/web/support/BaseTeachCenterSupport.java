package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseTeachCenter.BaseTeachCenterPageReqVo;
import com.qbt.web.pojo.baseTeachCenter.BaseTeachCenterVo;

public interface BaseTeachCenterSupport {

	List<BaseTeachCenterVo> findByPage(BaseTeachCenterPageReqVo reqVo);

	void add(BaseTeachCenterVo vo);

	void updateById(BaseTeachCenterVo vo);

	BaseTeachCenterVo findById(Integer id);

	void deleteById(Integer id);

}
