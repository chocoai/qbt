package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.base.BaseVersionVo;

public interface BaseVersionSupport {
	
	List<BaseVersionVo> findAll();

	Integer add(BaseVersionVo vo);
}
