
 /**
 * @Title: DeliverTmRespBody.java
 * @Package com.qbt.sf.api.bean.delivertm
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月5日
 * @version V1.0
 **/

package com.qbt.sf.api.bean.delivertm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmRespBody
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class DeliverTmRespBody {
	
	
	@XmlElementWrapper(name="DeliverTmResponse")
	@XmlElement(name="DeliverTm")
	private List<DeliverTmRespDeliver> deliverTm;

	
	/**
	 * getter method 
	 * @Title: getDeliverTm
	 * @return the deliverTm
	 */
	
	public List<DeliverTmRespDeliver> getDeliverTm() {
		return deliverTm;
	}

	
	/**
	* setter method
	* @param deliverTm the deliverTm to set
	*/
	
	public void setDeliverTm(List<DeliverTmRespDeliver> deliverTm) {
		this.deliverTm = deliverTm;
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
		return "DeliverTmRespBody [deliverTm=" + deliverTm + "]";
	}
	
	
	
}
