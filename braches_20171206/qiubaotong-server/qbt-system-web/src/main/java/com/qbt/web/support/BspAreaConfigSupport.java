package com.qbt.web.support;

import java.util.List;

import com.qbt.common.result.Paging;
import com.qbt.web.pojo.bspAreaConfig.BspAreaConfigVo;

public interface BspAreaConfigSupport {
	
	List<BspAreaConfigVo> findByPage(Paging paging);
	
	int add(BspAreaConfigVo vo);
	
	boolean delete(Integer id);
}
