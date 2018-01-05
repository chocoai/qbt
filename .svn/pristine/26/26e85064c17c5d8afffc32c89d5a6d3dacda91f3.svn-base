package com.qbt.email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.HttpClientUtil;
import com.qbt.common.util.JSonUtil;
import com.qbt.common.util.MailSenderInfo;
import com.qbt.common.util.SimpleMailSender;
import com.qbt.persistent.entity.EmailConfig;


@Service("email")
public class EmailServiceImpl implements EmailService {
	
	@Value("${email.host}")
    private String host;

	@Value("${email.port}")
    private String port;
	
	@Value("${email.username}")
    private String username;
	
	@Value("${email.password}")
    private String password;
	
	@Value("${email.sendFrom}")
    private String sendFrom;
	
	@Value("${email.sendTo}")
    private String sendTo;
	
	@Value("${email.sendToCc}")
    private String sendToCc;
	
	@Value("${email.request.url}")
	private String requestUrl;
	

	/***
	 * 发送邮件
	 * @param toAddress 接收邮件人
	 * @param subject   主题
	 * @param content   内容
	 * @param validate  是否要验证
	 */
	public void sendEmail(String toAddress, String subject , String content,boolean validate){
		MailSenderInfo mailInfo = new MailSenderInfo(host, port, username, password, sendFrom);
		mailInfo.setValidate(validate);
		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendHtmlMail(mailInfo);// 发送html格式
	}
	
	public void sendEmail(String subject , String content){
//		MailSenderInfo mailInfo = new MailSenderInfo(host, port, username, password, sendFrom);
//		mailInfo.setValidate(true);
//		mailInfo.setToAddress(sendTo);
//		mailInfo.setToCcAddress(sendToCc);
//		mailInfo.setSubject(subject);
//		mailInfo.setContent(content);
//		SimpleMailSender sms = new SimpleMailSender();
//		sms.sendTextMail(mailInfo);// 发送html格式
		
		List<String> recAddress = Checker.isNotEmpty(sendTo) ? Arrays.asList(sendTo.split(";")) : new ArrayList<String>();
		List<String> ccAddress = Checker.isNotEmpty(sendToCc) ? Arrays.asList(sendToCc.split(";")) : new ArrayList<String>();
		sendEmail(null, subject, content, recAddress, ccAddress, null, 0, "qbt");
	}

	@Override
	public void sendEmail(String uuid, String subject, String content, 
			List<String> recAddress, List<String> ccAddress,
			Map<String, byte[]> attachments, 
			int templateId, String platform) {
		LogCvt.info("发送邮件内容：" + content);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uuid", uuid);
		jsonObj.put("host", host);
		jsonObj.put("port", port);
		jsonObj.put("username", username);
		jsonObj.put("password", password);
		jsonObj.put("subject", subject);
		jsonObj.put("fromAddress", username);
		jsonObj.put("fromUserName", "球包通");
		jsonObj.put("recAddress", recAddress);
		jsonObj.put("ccAddress", ccAddress);
		jsonObj.put("attachments", attachments);
		jsonObj.put("type", "EMAIL");
		Map<String, String> data = new HashMap<String, String>();
		data.put("value", content);
		jsonObj.put("data", data);
		jsonObj.put("templateId", templateId);
		jsonObj.put("platform", platform);
		
		HttpClientUtil.httpPost(requestUrl, jsonObj.toJSONString());
	}

	@Override
	public void sendEmail(EmailConfig emailConfig, String subject, String content) {
		if(emailConfig == null) {
			LogCvt.error("找不到邮箱配置");
			return;
		}
		sendEmail(null, 
				emailConfig.getHost(), 
				emailConfig.getPort(), 
				emailConfig.getUsername(), 
				emailConfig.getPassword(),
				subject, 
				content, 
				JSonUtil.toObject(emailConfig.getSendTo(), List.class), 
				JSonUtil.toObject(emailConfig.getSendToCc(), List.class),
				null, 
				0, 
				emailConfig.getPlatform());
	}

	@Override
	public void sendEmail(String uuid, String host, String port, 
			String username, String password, 
			String subject, String content, 
			List<String> recAddress, List<String> ccAddress, 
			Map<String, byte[]> attachments,
			int templateId, String platform) {
		LogCvt.info("发送邮件内容：" + content);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uuid", uuid);
		jsonObj.put("host", host);
		jsonObj.put("port", port);
		jsonObj.put("username", username);
		jsonObj.put("password", password);
		jsonObj.put("subject", subject);
		jsonObj.put("fromAddress", username);
		jsonObj.put("fromUserName", "球包通");
		jsonObj.put("recAddress", recAddress);
		jsonObj.put("ccAddress", ccAddress);
		jsonObj.put("type", "EMAIL");
		Map<String, String> data = new HashMap<String, String>();
		data.put("value", content);
		jsonObj.put("data", data);
		jsonObj.put("templateId", 0);
		jsonObj.put("platform", platform);
		
		HttpClientUtil.httpPost(requestUrl, jsonObj.toJSONString());
	}

}
