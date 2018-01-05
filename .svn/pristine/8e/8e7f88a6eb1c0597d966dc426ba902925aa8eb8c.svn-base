package com.geling.msg.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.geling.dao.EmailDao;
import com.geling.dao.impl.EmailDaoImpl;
import com.geling.msg.db.vo.NotifyRequestVO;
import com.geling.msg.entity.NotifyRequestStatus;
import com.geling.msg.entity.RequestConstant;
import com.geling.msg.entity.email.EmailNotifyRequestEntity;
import com.geling.msg.logback.LogCvt;
import com.geling.msg.service.NotifySender;
import com.geling.msg.util.JSonUtil;

/**
 * @description 
 * @author Fred
 * @time 2013-5-27 下午3:17:23
 */
public class MailSenderImpl implements NotifySender {

	private JavaMailSender javaMailSender;
	
	private String defaultFromUserName = "球包通";
	private String fromAddress;

	/**
	 * @param defaultFromUserName the defaultFromUserName to set
	 */
	public void setDefaultFromUserName(String defaultFromUserName) {
		this.defaultFromUserName = defaultFromUserName;
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public boolean send(NotifyRequestVO requestVO) {
		EmailNotifyRequestEntity mailRequest = null;
		String body = null;
		JavaMailSenderImpl senderImpl = null;
		MimeMessage mailMessage = null;
		MimeMessageHelper messageHelper = null;
		Map<String,InputStreamSource> attachments = null;
		List<String> toAddrList = null;
		List<String> ccAddrList = null;
		LogCvt.info("-MailSenderImpl-开始发送邮件,NotifyRequest::" + requestVO);
		
		mailRequest = JSonUtil.toObject(requestVO.getRequestBody(), EmailNotifyRequestEntity.class);
		int requestStatus = 0;
		mailRequest.setRequestTime(new Date());
		mailRequest.setUuid(requestVO.getUuid());
		mailRequest.setFromAddress(mailRequest.getFromAddress() == null ? fromAddress : mailRequest.getFromAddress());
		mailRequest.setFromUserName(mailRequest.getFromUserName() == null ? defaultFromUserName	: mailRequest.getFromUserName());
		requestStatus = requestVO.getStatus().value();
		mailRequest.setRequestStatus(requestStatus);
		/**
		 * 入库
		 */
		EmailDao emailDao = new EmailDaoImpl();
		if(emailDao.countByUuid(requestVO.getUuid()) == 0){
			emailDao.insert(mailRequest);
		}
		
		LogCvt.debug("Mail Request Data : [" + mailRequest.getData() + "]");
		
		if (mailRequest.getData().get(RequestConstant.STREAM_NOTIFY_KEY) != null){
			body = mailRequest.getData().get(RequestConstant.STREAM_NOTIFY_KEY);
		}
		else{
			//直接变为json字符串
			body = JSonUtil.toJSonString(mailRequest.getData());
		}
		boolean isSucc = true;
		senderImpl = new JavaMailSenderImpl();
		mailMessage = senderImpl.createMimeMessage();
		try {
			messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			toAddrList = mailRequest.getRecAddress();
			messageHelper.setTo((String[]) toAddrList.toArray(new String[toAddrList.size()]));
			messageHelper.setFrom(mailRequest.getFromAddress() == null ? fromAddress : mailRequest.getFromAddress(), 
							mailRequest.getFromUserName() == null ? defaultFromUserName	: mailRequest.getFromUserName());
			ccAddrList = mailRequest.getCcAddress();
			messageHelper.setCc((String[]) ccAddrList.toArray(new String[ccAddrList.size()]));
			messageHelper.setSubject(mailRequest.getSubject());
			messageHelper.setText(body, true);
			
			attachments = convertAttachment(mailRequest.getAttachments());
			for(String key:attachments.keySet()){
				messageHelper.addAttachment(MimeUtility.encodeWord(key), attachments.get(key));
			}
			javaMailSender.send(mailMessage);
			requestStatus = NotifyRequestStatus.SUCCESS.value();
		} catch (MailSendException e) {
			LogCvt.error(e.getMessage(),e);
			
			if (e.getMessageExceptions()[0] instanceof SendFailedException){
				SendFailedException failedException = null;
				failedException = (SendFailedException) e.getMessageExceptions()[0];
				
				LogCvt.info("Clear invalid address(es) and resend.");
				// 清楚无效地址
				for (int i = 0; i < failedException.getInvalidAddresses().length; i++){
					toAddrList.remove(failedException.getInvalidAddresses()[i].toString());
					ccAddrList.remove(failedException.getInvalidAddresses()[i].toString());
				}
				
				// 清楚无效地址，重新发送
				if (toAddrList.size() > 0 || ccAddrList.size() > 0){
					try {
						messageHelper.setTo((String[]) toAddrList.toArray(new String[toAddrList.size()]));
						messageHelper.setCc((String[]) ccAddrList.toArray(new String[ccAddrList.size()]));
						javaMailSender.send(mailMessage);
						requestStatus = NotifyRequestStatus.SUCCESS.value();
					} catch (Exception e2) {
						LogCvt.error(e2.getMessage(),e2);
						isSucc = false;
						requestStatus = 2;
					}
				} else {
					LogCvt.error("All addresses are invalid, the mail will not be deliveried");
					isSucc = false;
					requestStatus = 2;
				}
			} else {
				isSucc = false;
				requestStatus = 2;
			}
		} catch (MessagingException e) {
			LogCvt.error(e.getMessage(),e);
			isSucc = false;
			requestStatus = 2;
		} catch (UnsupportedEncodingException e) {
			LogCvt.error(e.getMessage(),e);
			isSucc = false;
			requestStatus = 2;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
			isSucc = false;
			requestStatus = 2;
		}finally{
			mailRequest.setRequestStatus(requestStatus);
			emailDao.update(mailRequest);
		}
		return isSucc;
	}

	private Map<String, InputStreamSource> convertAttachment(Map<String,byte[]> attachments) {
		if(attachments == null) return new HashMap<String, InputStreamSource>();
		Map<String, InputStreamSource> result = new HashMap<String, InputStreamSource>();
		for(String key:attachments.keySet()){
			InputStreamSource inputStreamSource = null;
			inputStreamSource = new ByteArrayResource(attachments.get(key));
			result.put(key,inputStreamSource);
		}
		return result;
	}
}
