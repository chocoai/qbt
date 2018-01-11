package com.qbt.sf.api.bean.scope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class ScopeReqDeliver {

	@XmlAttribute(name="custid")
	private String  custid;
	
	@Override
	public String toString() {
		return "ScopeReqDeliver [custid=" + custid + "]";
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
}
