package com.qbt.sf.api.bean.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class IdentitySearchReqBody {
	 @XmlElement(name=" IdentitySearchRequest")
	 private  IdentitySearchReqDeliver identitySearchRequest;

	@Override
	public String toString() {
		return "IdentitySearchReqBody [identitySearchRequest="
				+ identitySearchRequest + "]";
	}

	public IdentitySearchReqDeliver getIdentitySearchRequest() {
		return identitySearchRequest;
	}

	public void setIdentitySearchRequest(
			IdentitySearchReqDeliver identitySearchRequest) {
		this.identitySearchRequest = identitySearchRequest;
	}
}
