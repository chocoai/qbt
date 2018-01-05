package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageReqVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogVo;

public interface BaseSfExpressLogSupport {

	List<BaseSfExpressLogPageVo> findByPage(BaseSfExpressLogPageReqVo reqVo);

	BaseSfExpressLogVo findById(Integer id);

}
