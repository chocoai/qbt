package com.geling.msg.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("wechats")
public class XmlWechat {
	
	@XStreamImplicit
	private List<WechatServiceConfig> config;

	@XStreamAlias("template_url")
	private String  template_url;
	
	
	@XStreamAlias("acess_token_url")
	private String  acess_token_url;
	
	
	public List<WechatServiceConfig> getConfig() {
		return config;
	}

	public void setConfig(List<WechatServiceConfig> config) {
		this.config = config;
	}

	
	/**
	 * getter method 
	 * @Title: getTemplate_url
	 * @return the template_url
	 */
	
	public String getTemplate_url() {
		return template_url;
	}

	
	/**
	* setter method
	* @param template_url the template_url to set
	*/
	
	public void setTemplate_url(String template_url) {
		this.template_url = template_url;
	}

	
	/**
	 * getter method 
	 * @Title: getAcess_token_url
	 * @return the acess_token_url
	 */
	
	public String getAcess_token_url() {
		return acess_token_url;
	}

	
	/**
	* setter method
	* @param acess_token_url the acess_token_url to set
	*/
	
	public void setAcess_token_url(String acess_token_url) {
		this.acess_token_url = acess_token_url;
	}

	
}

