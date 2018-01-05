package com.geling.msg.entity.email;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.geling.msg.entity.NotifyRequestEntity;
import com.geling.msg.entity.RequestType;

public class EmailNotifyRequestEntity extends NotifyRequestEntity {
	private static final long serialVersionUID = -5374645574068926972L;

	public EmailNotifyRequestEntity() {
		super();
		setType(RequestType.EMAIL);
	}
	// 接收者列表
	private List<String> recAddress = new ArrayList<String>();
	// 发送者地址
	private String fromAddress;
	// 发送者名称
	private String fromUserName;
	// 抄送地址列表
	private List<String> ccAddress = new ArrayList<String>();
	// 邮件主题
	private String subject;
	// 邮件附件
	private Map<String, byte[]> attachments = new HashMap<String, byte[]>();
	// 平台
	private String platform;
	// 请求时间
	private Date requestTime;
	// 更新时间
	private Date updateTime;
	// 发送状态 0-发送中 1-成功 2-失败
	private int requestStatus;

	/**
	 * @return the attachments
	 */
	public Map<String, byte[]> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments
	 *            the attachments to set
	 */
	public void setAttachments(Map<String, byte[]> attachments) {
		this.attachments = attachments;
	}

	/**
	 * 添加单个附件。
	 * 
	 * @param attachmentName
	 *            附件名称
	 * @param content
	 *            附件内容
	 */
	public void addAttachment(String attachmentName, InputStream content)
			throws IOException {
		//附件文件限制300KB
		if(content.available() > (300*1024) || !isCapacity(content.available())){
			throw new IOException("邮件附件必需小于300kb!");
		}
		this.attachments.put(attachmentName, IOUtils.toByteArray(content));
		
	}
	
	
	public boolean isCapacity(int addLength){
		int size = 0 ;
		for(String key:attachments.keySet()){
			size += attachments.get(key).length;
		}
		size += addLength;
		if(size > 300 *1024  )
			return false;;
		return true;
	}


	/**
	 * 删除单个附件
	 * 
	 * @param attachmentName
	 *            附件名称
	 */
	public void removeAttachment(String attachmentName) {
		if (this.attachments.containsKey(attachmentName)) {
			this.attachments.remove(attachmentName);
		}
	}

	public List<String> getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(List<String> recAddress) {
		this.recAddress = recAddress;
	}

	public void addRecAddress(String recAddress) {
		this.recAddress.add(recAddress);
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public List<String> getCcAddress() {
		return ccAddress;
	}

	public void addCcAddress(String ccAddress) {
		this.ccAddress.add(ccAddress);
	}

	public void setCcAddress(List<String> ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailNotifyRequest [ccAddress=" + ccAddress + ", fromAddress="
				+ fromAddress + "fromUserName = " + fromUserName
				+ ", recAddress=" + recAddress + ", subject=" + subject + "]"
				+ super.toString();
	}

	/**
	 * 发送者用户名，用于邮件显示 .默认值为方付通
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * 设置发送者用户名，用于邮件显示 。
	 * @param fromUserName 发送者用户名，用于邮件显示
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

}
