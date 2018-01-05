package com.qbt.sf.api.bean.orderfilterpush;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @ClassName: OrderFilterPushOption
 * @Description: TODO
 * @author wuwang-win8 2016年8月5日
 * @modify wuwang-win8 2016年8月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderFilterPushOption {
	@XmlAttribute
	private String j_tel ;
	@XmlAttribute
	private String country ;
	@XmlAttribute
	private String province ;
	@XmlAttribute
	private String city ;
	@XmlAttribute
	private String county ;
	@XmlAttribute
	private String d_country ;
	@XmlAttribute
	private String d_province  ;
	@XmlAttribute
	private String d_city  ;
	@XmlAttribute
	private String d_county  ;
	@XmlAttribute
	private String  j_address  ;
	@XmlAttribute
	private String d_tel  ;
	@XmlAttribute
	private String j_custid  ;
	public String getJ_tel() {
		return j_tel;
	}
	public void setJ_tel(String j_tel) {
		this.j_tel = j_tel;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getD_country() {
		return d_country;
	}
	public void setD_country(String d_country) {
		this.d_country = d_country;
	}
	public String getD_province() {
		return d_province;
	}
	public void setD_province(String d_province) {
		this.d_province = d_province;
	}
	public String getD_city() {
		return d_city;
	}
	public void setD_city(String d_city) {
		this.d_city = d_city;
	}
	public String getD_county() {
		return d_county;
	}
	public void setD_county(String d_county) {
		this.d_county = d_county;
	}
	public String getJ_address() {
		return j_address;
	}
	public void setJ_address(String j_address) {
		this.j_address = j_address;
	}
	public String getD_tel() {
		return d_tel;
	}
	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}
	public String getJ_custid() {
		return j_custid;
	}
	public void setJ_custid(String j_custid) {
		this.j_custid = j_custid;
	}
	
	
	
	
	
	
	
	 
	 
	

	
}
