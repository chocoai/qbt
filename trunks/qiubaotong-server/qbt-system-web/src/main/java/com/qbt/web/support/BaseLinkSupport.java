package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baselink.BaseLinkPageReqVo;
import com.qbt.web.pojo.baselink.BaseLinkVo;


public interface BaseLinkSupport {

	void add(BaseLinkVo vo);

	void update(BaseLinkVo vo);

	BaseLinkVo findById(Integer id);

	void delete(Integer id);

	List<BaseLinkVo> findByPage(BaseLinkPageReqVo reqVo);

	List<BaseLinkVo> list();



}
