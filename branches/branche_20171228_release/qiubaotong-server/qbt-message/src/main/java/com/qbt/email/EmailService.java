package com.qbt.email;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.EmailConfig;

public interface EmailService {

	public void sendEmail(String toAddress, String subject, String content, boolean validate);
	
	public void sendEmail(String subject, String content);
	
	public void sendEmail(String uuid, String subject, String content, List<String> recAddress, List<String> ccAddress, Map<String,byte[]> attachments, int templateId, String platform);
	
	public void sendEmail(EmailConfig emailConfig, String subject, String content);
	
	public void sendEmail(String uuid, String host, String port, String username, String password, String subject, String content, List<String> recAddress, List<String> ccAddress, Map<String,byte[]> attachments, int templateId, String platform);
}
