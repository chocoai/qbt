package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.smsMessage.SmsMessagePageReqVo;
import com.qbt.web.pojo.smsMessage.SmsMessageVo;

public interface SmsMessageSupport {

	List<SmsMessageVo> findByPage(SmsMessagePageReqVo reqVo);

}
