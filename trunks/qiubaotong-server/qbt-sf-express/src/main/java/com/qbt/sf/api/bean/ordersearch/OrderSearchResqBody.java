package com.qbt.sf.api.bean.ordersearch;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderSearchResqBody {

	public List<OrderSearchRespDeliver> getDeliverOrderSearch() {
		return deliverOrderSearch;
	}

	public void setDeliverOrderSearch(
			List<OrderSearchRespDeliver> deliverOrderSearch) {
		this.deliverOrderSearch = deliverOrderSearch;
	}

	@XmlElementWrapper(name="OrderSearchResponse")
	@XmlElement(name="OrderSearch")
	private List<OrderSearchRespDeliver> deliverOrderSearch;

	@Override
	public String toString() {
		return "OrderSearchResqBody [deliverOrderSearch=" + deliverOrderSearch
				+ "]";
	}
}

	
	