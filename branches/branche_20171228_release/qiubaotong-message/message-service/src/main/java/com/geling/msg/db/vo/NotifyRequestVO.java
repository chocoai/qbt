package com.geling.msg.db.vo;


import java.util.Date;
import java.util.UUID;

import com.geling.msg.entity.NotifyRequestEntity;
import com.geling.msg.entity.NotifyRequestStatus;
import com.geling.msg.util.JSonUtil;

/**
 * @description 
 * @author Fred
 * @time 2013-5-17 下午2:59:42
 */
public class NotifyRequestVO extends NotifyRequestEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * Request ID
	 */
	private String _id = null;
	
	/**
	 * Request Creation Time
	 */
	private Date requestTime = null;
	
	/**
	 * Message Delivery Status
	 */
	private NotifyRequestStatus status = null;
	
	/**
	 * Last Update Time
	 */
	private Date updateTime = null;
	
	/**
	 * Retry Count
	 */
	private int retryCount = 3;
	
	/**
	 * Request Message Body
	 */
	private String requestBody = null;
	
	/**
	 * Constructor 
	 */
	public NotifyRequestVO() {
		_id = UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @return the status
	 */
	public NotifyRequestStatus getStatus() {
		return status;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @return the retryCount
	 */
	public int getRetryCount() {
		return retryCount;
	}

	/**
	 * @return the requestBody
	 */
	public String getRequestBody() {
		return requestBody;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(NotifyRequestStatus status) {
		this.status = status;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @param retryCount the retryCount to set
	 */
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * @param requestBody the requestBody to set
	 */
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
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
