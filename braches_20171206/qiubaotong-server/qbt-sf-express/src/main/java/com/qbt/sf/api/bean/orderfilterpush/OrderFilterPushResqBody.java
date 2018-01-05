package com.qbt.sf.api.bean.orderfilterpush;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.delivertm.DeliverTmRespDeliver;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderFilterPushResqBody {
	public List<OrderFilterPushRespDeliver> getDeliverOrderFilterPush() {
		return deliverOrderFilterPush;
	}

	public void setDeliverOrderFilterPush(
			List<OrderFilterPushRespDeliver> deliverOrderFilterPush) {
		this.deliverOrderFilterPush = deliverOrderFilterPush;
	}

	@XmlElementWrapper(name="OrderFilterPushResponse")
	@XmlElement(name=" OrderFilterPush")
	private List<OrderFilterPushRespDeliver> deliverOrderFilterPush;
}



	
	
	