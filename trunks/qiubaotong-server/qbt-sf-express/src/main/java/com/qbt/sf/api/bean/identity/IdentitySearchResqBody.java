package com.qbt.sf.api.bean.identity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class IdentitySearchResqBody {
	@XmlElementWrapper(name="IdentitySearchResponse")
	@XmlElement(name="IdentitySearch")
	private List<IdentitySearchRespDeliver> deliverIdentitySearch;

	@Override
	public String toString() {
		return "IdentitySearchResqBody [deliverIdentitySearch="
				+ deliverIdentitySearch + "]";
	}

	public List<IdentitySearchRespDeliver> getDeliverIdentitySearch() {
		return deliverIdentitySearch;
	}

	public void setDeliverIdentitySearch(
			List<IdentitySearchRespDeliver> deliverIdentitySearch) {
		this.deliverIdentitySearch = deliverIdentitySearch;
	}
	
}




	