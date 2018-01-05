package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigAddReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigPageReqVo;
import com.qbt.web.pojo.sfNotifyConfig.SfNotifyConfigVo;


public interface SfNotifyConfigSupport {

	List<SfNotifyConfigVo> findByPage(SfNotifyConfigPageReqVo reqVo);
	
	int add(SfNotifyConfigAddReqVo vo);
	
	int deleteById(Integer id);
}
