package com.geling.msg.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("template")
public class SmsServiceConfig {

	@XStreamAlias("tid")
	private String tid;
	
	@XStreamAlias("tcontent")
	private String tcontent;

	
	/**
	 * getter method 
	 * @Title: getTid
	 * @return the tid
	 */
	
	public String getTid() {
		return tid;
	}

	
	/**
	* setter method
	* @param tid the tid to set
	*/
	
	public void setTid(String tid) {
		this.tid = tid;
	}

	
	/**
	 * getter method 
	 * @Title: getTcontent
	 * @return the tcontent
	 */
	
	public String getTcontent() {
		return tcontent;
	}

	
	/**
	* setter method
	* @param tcontent the tcontent to set
	*/
	
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	
	

}

