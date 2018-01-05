package com.qbt.web.pojo.order;

public class HistoryOrderAddressVo {
	
	
	 // 寄件地址名称
    private String jAddressName;
    // 寄件地址省市区
    private String jCityName;
    // 寄件地址类型
    private Integer jAddrType;
    // 寄件地址地区ID
    private Integer jAreaId;
    // 寄件地址地区ID
    private String jAddress;
    // 地区信息
    private Integer jAddrId;
    
	private String jtreeId;
	
	private String dtreeId;
	
	 // 寄件地址名称
    private String dAddressName;
    // 收件地址类型
    private Integer dAddrType;
    // 收件地址地区ID
    private Integer dAreaId;
    // 收件地址地区ID
    private String dAddress;
    // 地区信息
    private Integer dAddrId;
    
 // 收件地址省市区
    private String dCityName;
    
 // 寄件偏远类型 0-非偏远 1-球场 4-地区
    private Integer jOutRangeType;
    // 收件偏远类型 0-非偏远 1-球场 4-地区
    private Integer dOutRangeType;
    
  //寄件地区偏远费用
    private Double jOutRangePrice;
	//收件地区偏远费用
    private Double dOutRangePrice;
	

	public String getjAddressName() {
		return jAddressName;
	}

	public void setjAddressName(String jAddressName) {
		this.jAddressName = jAddressName;
	}

	public String getjCityName() {
		return jCityName;
	}

	public void setjCityName(String jCityName) {
		this.jCityName = jCityName;
	}

	public Integer getjAddrType() {
		return jAddrType;
	}

	public void setjAddrType(Integer jAddrType) {
		this.jAddrType = jAddrType;
	}

	public Integer getjAreaId() {
		return jAreaId;
	}

	public void setjAreaId(Integer jAreaId) {
		this.jAreaId = jAreaId;
	}

	public String getjAddress() {
		return jAddress;
	}

	public void setjAddress(String jAddress) {
		this.jAddress = jAddress;
	}

	public Integer getjAddrId() {
		return jAddrId;
	}

	public void setjAddrId(Integer jAddrId) {
		this.jAddrId = jAddrId;
	}

	public String getdAddressName() {
		return dAddressName;
	}

	public void setdAddressName(String dAddressName) {
		this.dAddressName = dAddressName;
	}

	public Integer getdAddrType() {
		return dAddrType;
	}

	public void setdAddrType(Integer dAddrType) {
		this.dAddrType = dAddrType;
	}

	public Integer getdAreaId() {
		return dAreaId;
	}

	public void setdAreaId(Integer dAreaId) {
		this.dAreaId = dAreaId;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public Integer getdAddrId() {
		return dAddrId;
	}

	public void setdAddrId(Integer dAddrId) {
		this.dAddrId = dAddrId;
	}

	public String getdCityName() {
		return dCityName;
	}

	public void setdCityName(String dCityName) {
		this.dCityName = dCityName;
	}

	public Integer getjOutRangeType() {
		return jOutRangeType;
	}

	public void setjOutRangeType(Integer jOutRangeType) {
		this.jOutRangeType = jOutRangeType;
	}

	public Integer getdOutRangeType() {
		return dOutRangeType;
	}

	public void setdOutRangeType(Integer dOutRangeType) {
		this.dOutRangeType = dOutRangeType;
	}

	public Double getjOutRangePrice() {
		return jOutRangePrice;
	}

	public void setjOutRangePrice(Double jOutRangePrice) {
		this.jOutRangePrice = jOutRangePrice;
	}

	public Double getdOutRangePrice() {
		return dOutRangePrice;
	}

	public void setdOutRangePrice(Double dOutRangePrice) {
		this.dOutRangePrice = dOutRangePrice;
	}

	public String getJtreeId() {
		return jtreeId;
	}

	public void setJtreeId(String jtreeId) {
		this.jtreeId = jtreeId;
	}

	public String getDtreeId() {
		return dtreeId;
	}

	public void setDtreeId(String dtreeId) {
		this.dtreeId = dtreeId;
	}


	
	

}
