package com.qbt.sf.api.bean.scope;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class ScopeRespBody {
	@XmlElementWrapper(name="ScopeResponse")
	@XmlElement(name="Scope")
	private List<ScopeRespDeliver> deliverScope;
	
	@Override
	public String toString() {
		return "ScopeRespBody [deliverScope=" + deliverScope + "]";
	}

	public List<ScopeRespDeliver> getDeliverScope() {
		return deliverScope;
	}

	public void setDeliverScope(List<ScopeRespDeliver> deliverScope) {
		this.deliverScope = deliverScope;
	}
	
}


