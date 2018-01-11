package com.geling.msg.service;

import com.geling.msg.db.vo.NotifyRequestVO;


public interface NotifySender {
	boolean send(NotifyRequestVO requestVO);
}
