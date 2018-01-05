package com.qbt.web.pojo.saleQrcodeInfo;

import com.qbt.common.result.Paging;

public class SaleQrcodeInfoPageReqVo extends Paging {

	//销售二维码生成记录id
	private Integer qrcodeCreateInfoId;
	
	//销售人员编号
	private String salesmanCode;
	
	//全部-不传，0-未申请 1-已申请
	private Integer applyStatus;

	public Integer getQrcodeCreateInfoId() {
		return qrcodeCreateInfoId;
	}

	public void setQrcodeCreateInfoId(Integer qrcodeCreateInfoId) {
		this.qrcodeCreateInfoId = qrcodeCreateInfoId;
	}

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

}
