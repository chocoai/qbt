/**
 * @Title: DeliverTmResp.java
 * @Package com.qbt.sf.api.bean.delivertm
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.delivertm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.RespErr;

/**
  * @ClassName: DeliverTmResp
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class DeliverTmResp {
	
    @XmlAttribute
    private String  service="DeliverTmService";
    
    
    @XmlElement(name="Head")
    private String  head;
    
    
    @XmlElement(name="Body")
    private DeliverTmRespBody body;
    
    
    @XmlElement(name="ERROR")
    private RespErr error;


	
	/**
	 * getter method 
	 * @Title: getService
	 * @return the service
	 */
	
	public String getService() {
		return service;
	}


	
	/**
	* setter method
	* @param service the service to set
	*/
	
	public void setService(String service) {
		this.service = service;
	}


	
	/**
	 * getter method 
	 * @Title: getHead
	 * @return the head
	 */
	
	public String getHead() {
		return head;
	}


	
	/**
	* setter method
	* @param head the head to set
	*/
	
	public void setHead(String head) {
		this.head = head;
	}


	
	/**
	 * getter method 
	 * @Title: getBody
	 * @return the body
	 */
	
	public DeliverTmRespBody getBody() {
		return body;
	}


	
	/**
	* setter method
	* @param body the body to set
	*/
	
	public void setBody(DeliverTmRespBody body) {
		this.body = body;
	}





	
	 
	/**
	 * getter method 
	 * @Title: getError
	 * @return the error
	 */
	
	public RespErr getError() {
		return error;
	}



	
	/**
	* setter method
	* @param error the error to set
	*/
	
	public void setError(RespErr error) {
		this.error = error;
	}



	/**
	  * @Title: toString
	  * @Description: TODO
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @return
	  * @see java.lang.Object#toString()
	  */
	
	@Override
	public String toString() {
		return "DeliverTmResp [service=" + service + ", head=" + head + ", body=" + body + ", error=" + error + "]";
	}

    

}
