package com.qbt.sf.api.bean.delivertm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmReqBody
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class DeliverTmReqBody {
	
	 @XmlElement(name="DeliverTmRequest")
	  private DeliverTmReqDeliver deliverTmRequest;

	
	/**
	 * getter method 
	 * @Title: getDeliverTmRequest
	 * @return the deliverTmRequest
	 */
	public DeliverTmReqDeliver getDeliverTmRequest() {
		return deliverTmRequest;
	}

	
	/**
	* setter method
	* @param deliverTmRequest the deliverTmRequest to set
	*/
	public void setDeliverTmRequest(DeliverTmReqDeliver deliverTmRequest) {
		this.deliverTmRequest = deliverTmRequest;
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
		return "DeliverTmReqBody [deliverTmRequest=" + deliverTmRequest + "]";
	}

}
