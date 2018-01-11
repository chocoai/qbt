package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.assistant.AdminUserAssistantVO;
import com.qbt.web.pojo.assistant.UserAssistantPageReqVo;

public interface AdminUserAssistantSupport {

	List<AdminUserAssistantVO> findByPage(UserAssistantPageReqVo reqVo);

}
