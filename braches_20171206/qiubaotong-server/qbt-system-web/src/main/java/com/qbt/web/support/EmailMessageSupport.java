package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.emailMessage.EmailMessagePageReqVo;
import com.qbt.web.pojo.emailMessage.EmailMessageVo;

public interface EmailMessageSupport {

	List<EmailMessageVo> findByPage(EmailMessagePageReqVo reqVo);
	
	boolean resend(String uuid);
}
