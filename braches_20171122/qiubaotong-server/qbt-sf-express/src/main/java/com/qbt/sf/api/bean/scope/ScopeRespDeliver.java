package com.qbt.sf.api.bean.scope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class ScopeRespDeliver {
	@XmlAttribute(name="name")
	private String name;
	@XmlAttribute(name="value")
	private String value;
	@XmlAttribute(name="value1")
	private String value1;
	@XmlAttribute(name="value2")
	private String value2;
	@XmlAttribute(name="value3")
	private String value3;
	@XmlAttribute(name="value4")
	private String value4;
	@XmlAttribute(name="value5")
	private String value5;
	@Override
	public String toString() {
		return "ScopeRespDeliver [name=" + name + ", value=" + value
				+ ", value1=" + value1 + ", value2=" + value2 + ", value3="
				+ value3 + ", value4=" + value4 + ", value5=" + value5 + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getValue3() {
		return value3;
	}
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	public String getValue4() {
		return value4;
	}
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	public String getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		this.value5 = value5;
	}
}


