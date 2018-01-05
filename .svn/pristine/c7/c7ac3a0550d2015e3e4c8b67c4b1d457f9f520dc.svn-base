package com.qbt.sf.api.bean.queryfreight;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class QueryFreightRespBody {
	@XmlElementWrapper(name="QueryFreightResponse")
	@XmlElement(name="QueryFreight")
	private List<QueryFreightRespDeliver> deliverQueryFreight;

	@Override
	public String toString() {
		return "QueryFreightRespBody [deliverQueryFreight="
				+ deliverQueryFreight + "]";
	}

	public List<QueryFreightRespDeliver> getDeliverQueryFreight() {
		return deliverQueryFreight;
	}

	public void setDeliverQueryFreight(
			List<QueryFreightRespDeliver> deliverQueryFreight) {
		this.deliverQueryFreight = deliverQueryFreight;
	}
}



	