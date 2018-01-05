package com.qbt.persistent.dto;

import java.util.Date;

public class SaleQrcodeCreateInfoDto {

	//生成批次
	private String name;
  	
  	//生成日期
  	private Date createTime;
  	
  	//销售人员号
  	private String salesmanCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}
	
  	
}
