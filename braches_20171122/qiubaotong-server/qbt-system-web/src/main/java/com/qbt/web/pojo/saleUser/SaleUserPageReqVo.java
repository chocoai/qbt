/**
 * Project Name:qbt-system-web
 * File Name:SaleUserPageReqVo.java
 * Package Name:com.qbt.web.pojo.saleUser
 * Date:2017年2月7日下午7:13:28
 *
*/

package com.qbt.web.pojo.saleUser;

import java.util.Date;

import com.qbt.common.result.Paging;

/**
 * ClassName:SaleUserPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午7:13:28
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserPageReqVo extends Paging {
	
	private String salesmanCode;
	
	private String name;

    private String mobile;

    private String idcard;
	
    private String company;
    
    private Integer type;
    
    private Integer status;
    
    private Boolean isApply;//是否审核通过
    
    private String qrcodeCreateInfoName;
    
    private Date startDate;
    
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

	public String getQrcodeCreateInfoName() {
		return qrcodeCreateInfoName;
	}

	public void setQrcodeCreateInfoName(String qrcodeCreateInfoName) {
		this.qrcodeCreateInfoName = qrcodeCreateInfoName;
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
