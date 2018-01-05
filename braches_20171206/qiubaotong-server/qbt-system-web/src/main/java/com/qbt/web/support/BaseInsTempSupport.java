package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.BaseInsuredTemplate;
import com.qbt.web.pojo.baseInsTemp.BaseInsTempPageReqVo;
import com.qbt.web.pojo.baseInsTemp.BaseInsTempVo;

public interface BaseInsTempSupport {

	List<BaseInsTempVo> findByPage(BaseInsTempPageReqVo reqVo);

	void deleteById(Integer id);

	void add(BaseInsTempVo vo);

	void update(BaseInsTempVo vo);
	
	BaseInsuredTemplate insureValidPrice(double price);


}
