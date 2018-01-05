package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseNews.BaseNewsCategoryVo;
import com.qbt.web.pojo.baseNews.BaseNewsOfficialVo;
import com.qbt.web.pojo.baseNews.BaseNewsPageReqVo;
import com.qbt.web.pojo.baseNews.BaseNewsVo;

public interface BaseNewsSupport {

	void add(BaseNewsVo vo);

	List<BaseNewsVo> findByPage(BaseNewsPageReqVo reqVo);

	void update(BaseNewsVo vo);

	BaseNewsVo findById(Integer id);

	void updateStatus(Integer id, int status);

	void delete(Integer id);

	List<BaseNewsVo> list(Integer categoryId);

	BaseNewsVo findByIdOfficial(Integer id);

	void updateReadTimes();

	List<BaseNewsOfficialVo> findByPageOfficial(BaseNewsPageReqVo reqVo);

	List<BaseNewsCategoryVo> listGroupByCategoryId();

}
