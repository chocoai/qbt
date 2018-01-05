package com.geling.msg.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.geling.util.JSonUtil;

/**
 * @description 
 * @author Fred
 * @time 2013-5-17 下午2:59:42
 */
public abstract class NotifyRequestEntity implements Serializable {

	private static final long serialVersionUID = 3685342912363342430L;

	/**
	 * Business ID
	 */
	private String bizId = null;
	
	/**
	 * Business Code
	 */
	private String bizCode = null;
	
	/**
	 * Merchant Code
	 */
	private long merchantCode = 0L;
	
	/**
	 * Request Type, SMS|HTTP|EMAIL
	 */
	private RequestType type = null;
	
	/**
	 * Template ID
	 */
	private long templateId = 0l;
	
	/**
	 * Message Content
	 */
	private Map<String, String> data = new HashMap<String, String>();
	
	// 标识码
	private String uuid;
	
	/**
	 * @return the bizId
	 */
	public String getBizId() {
		return bizId;
	}

	/**
	 * @return the bizCode
	 */
	public String getBizCode() {
		return bizCode;
	}

	/**
	 * @return the merchantCode
	 */
	public Long getMerchantCode() {
		return merchantCode;
	}

	/**
	 * @return the type
	 */
	public RequestType getType() {
		return type;
	}

	/**
	 * @return the templateId
	 */
	public long getTemplateId() {
		return templateId;
	}

	/**
	 * @return the data
	 */
	public Map<String, String> getData() {
		return data;
	}

	/**
	 * @param bizId the bizId to set
	 */
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	/**
	 * @param bizCode the bizCode to set
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	/**
	 * @param merchantCode the merchantCode to set
	 */
	public void setMerchantCode(long merchantCode) {
		this.merchantCode = merchantCode;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(RequestType type) {
		this.type = type;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Convert to JSON String
	 * 
	 * @return JSON String
	 */
	public String toJsonString(){
		return JSonUtil.toJSonString(this);
	}
	
}
