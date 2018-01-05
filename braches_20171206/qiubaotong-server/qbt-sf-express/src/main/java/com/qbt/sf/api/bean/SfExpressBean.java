/**
 * @Title: SfExpressBean.java
 * @Package com.qbt.sf.api.bean
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月5日
 * @version V1.0
**/

package com.qbt.sf.api.bean;

/**
  * @ClassName: SfExpressBean
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
 */
public class SfExpressBean {
	
	private String url;
	private String checkWord;
	/**
	  * @Title: getUrl
	  * @Description: TODO
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	* setter method
	* @param url the url to set
	*/
	
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * getter method 
	 * @Title: getCheckWord
	 * @return the checkWord
	 */
	
	public String getCheckWord() {
		return checkWord;
	}
	/**
	* setter method
	* @param checkWord the checkWord to set
	*/
	
	public void setCheckWord(String checkWord) {
		this.checkWord = checkWord;
	}
	
	

}
