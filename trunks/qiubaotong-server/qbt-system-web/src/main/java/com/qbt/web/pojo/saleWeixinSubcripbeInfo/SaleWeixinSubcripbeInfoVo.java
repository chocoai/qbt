package com.qbt.web.pojo.saleWeixinSubcripbeInfo;

import java.util.Date;

public class SaleWeixinSubcripbeInfoVo {

	//新拉关注日期时间
	private Date createTime;
	
    //每一新拉关注奖金
    private Double amount;

    //结算状态（1-未结算 2-已结算）
    private Integer settleStatus;
    
    //结算日期
    private Date settleTime;

    //结算人
    private String sysUserName;

    //结算方式（支付方式 1-微信 3-支付宝 4-汇款 5-现金）
    private Integer settleMethod;
    
    //备注
    private String remark;
    
    //微信昵称
    private String nickname;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(Integer settleStatus) {
		this.settleStatus = settleStatus;
	}

	public Date getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public Integer getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(Integer settleMethod) {
		this.settleMethod = settleMethod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
}
