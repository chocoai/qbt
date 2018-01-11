package com.qbt.web.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.sms.api.service.SmsSendService;
import com.qbt.web.pojo.message.MessageVo;

/**
 *  消息发送
  * @ClassName: MessageController
  * @Description: TODO
  * @author share 2016年9月2日
  * @modify share 2016年9月2日
 */
@Controller
@RequestMapping("message")
public class MessageController {

	@Resource
	private SmsSendService smsSendService;
	
	/**
	 *  短信发送
	  * @Title: send
	  * @Description: TODO
	  * @author: share 2016年9月2日
	  * @modify: share 2016年9月2日
	  * @param vo
	  * @return
	 */
	@RequestMapping(value="send", method = RequestMethod.POST)
	public Result<String> send(@RequestBody MessageVo message){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(message);
		} catch (ValidationException e) {
			result.setCode(e.getErrorCode());
			result.setCode(e.getMessage());
		}
		HashMap<String,Object> map = smsSendService.sendSms(message.getMobiles(), message.getTemplate_id(), message.getContents());
		if (!"000000".equals(map.get("statusCode"))) {
			result.setCode("8001");
			result.setMsg("短信发送失败");
		}
		
		return result;
	}
	
}
