/**
 * Project Name:qbt-report
 * File Name:SaleUserExportRequest.java
 * Package Name:com.qbt.web.pojo.saleUser
 * Date:2017年2月8日下午2:00:54
 *
*/

package com.qbt.web.pojo.saleUser;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

/**
 * ClassName:SaleUserExportRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午2:00:54
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserExportRequest extends Paging {
	
	private String salesmanCode;
	
	private String name;

    private String mobile;

    private String idcard;
	
    private String company;
    
    private Integer type;
    
    private Integer status;
    
    private Boolean isApply = true;//是否审核通过
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsApply() {
		return isApply;
	}

	public void setIsApply(Boolean isApply) {
		this.isApply = isApply;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
