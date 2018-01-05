package com.geling.msg.entity.wechat;


import com.alibaba.fastjson.JSONObject;
import com.geling.msg.entity.NotifyRequestEntity;
import com.geling.msg.entity.RequestType;

/**
 * 
  * @ClassName: WechatNotifyRequestEntity
  * @Description: TODO
  * @author chenxiaocong 2016年10月29日
  * @modify chenxiaocong 2016年10月29日
 */
public class WechatNotifyRequestEntity extends NotifyRequestEntity{

	private static final long serialVersionUID = -3201293391095438002L;

	public WechatNotifyRequestEntity() {
		super();
		setType(RequestType.WECHAT);
	}
	
	//下推通知微信内容
	private JSONObject wechatData = null;
	//平台ID
	private String sysId = null;

	
	/**
	 * getter method 
	 * @Title: getWechatData
	 * @return the wechatData
	 */
	
	public JSONObject getWechatData() {
		return wechatData;
	}
	
	/**
	* setter method
	* @param wechatData the wechatData to set
	*/
	
	public void setWechatData(JSONObject wechatData) {
		this.wechatData = wechatData;
	}
	
	/**
	 * getter method 
	 * @Title: getSysId
	 * @return the sysId
	 */
	
	public String getSysId() {
		return sysId;
	}
	
	/**
	* setter method
	* @param sysId the sysId to set
	*/
	
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	
	
	
	
}
