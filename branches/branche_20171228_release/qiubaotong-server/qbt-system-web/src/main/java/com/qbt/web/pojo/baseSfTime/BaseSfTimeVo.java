package com.qbt.web.pojo.baseSfTime;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseSfTimeVo {
	
	//id
	private int id;
	
	//节日名称
	@NotNull(message = "名称不能为空")
	private String name;
	
	//开始日期
	@NotNull(message = "开始日期不能为空")
	private Date startDate;

	//结束日期
	@NotNull(message = "结束日期不能为空")
    private Date endDate;
    
    //调整日期
	@NotNull(message = "调整日期不能为空")
    private Date adjustDate;
    
    //参考日期
	@NotNull(message = "参考日期不能为空")
    private Date referenceDate;
    
    //备注
    private String remark;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getAdjustDate() {
		return adjustDate;
	}

	public void setAdjustDate(Date adjustDate) {
		this.adjustDate = adjustDate;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
