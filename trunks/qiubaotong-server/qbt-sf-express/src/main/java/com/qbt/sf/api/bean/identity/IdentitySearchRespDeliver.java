package com.qbt.sf.api.bean.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class IdentitySearchRespDeliver {
	@XmlAttribute(name="result")
	private String result;

	@Override
	public String toString() {
		return "IdentitySearchRespDeliver [result=" + result + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}


 
	