
 /**
 * @Title: XmlSms.java
 * @Package com.geling.msg.config
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater Administrator 2016年11月1日
 * @version V1.0
 **/

package com.geling.msg.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
  * @ClassName: XmlSms
  * @Description: TODO
  * @author Administrator 2016年11月1日
  * @modify Administrator 2016年11月1日
  */
@XStreamAlias("sms")
public class XmlSms {

	@XStreamImplicit
	private List<SmsServiceConfig> config;

	
	/**
	 * getter method 
	 * @Title: getConfig
	 * @return the config
	 */
	
	public List<SmsServiceConfig> getConfig() {
		return config;
	}

	
	/**
	* setter method
	* @param config the config to set
	*/
	
	public void setConfig(List<SmsServiceConfig> config) {
		this.config = config;
	}

}
