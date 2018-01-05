package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrderInfo;

public class BossOrderInfo extends OrderInfo {
	
	//关键字查询：用户名(模糊) 寄件人(模糊) 收件人(模糊)
	private String keyWord;
	
	//用户姓名
	private String userName;
	
	//用户昵称
	private String nickname;
	
	//用户手机号
	private String mobile;
	
	//取件起始时间
	private Date begSendTime;

	// 取件结束时间
	private Date endSendTime;
	
	//取件起始时间
	private Date begCreateTime;

	// 取件结束时间
	private Date endCreateTime;
	
	//预计到达开始时间
	private Date deliverStartTime;
		
	//预计到达结束时间
	private Date deliverEndTime;
	
	//地址类型:1-course球场，2-airport机场,3-bank银行,4-address个人地址
    private Integer addrType;
    
    //非个人地址ID，个人地址为0
    private Integer addrId;
    
    //寄收人手机号
    private String concactMobile;
    
	//偏远类型 0-非偏远 1-球场 4-地区
    private Integer outRangeType;
    
    //销售人员名称
    private String saleUserName;
    
    //销售人id
    private Integer saleUserId;
    
  	//支付开始时间
  	private Date payTimeStartTime;
  	
  	//支付结束时间
  	private Date payTimeEndTime;
  	
  	private int[] ids;
  	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBegSendTime() {
		return begSendTime;
	}

	public void setBegSendTime(Date begSendTime) {
		this.begSendTime = begSendTime;
	}

	public Date getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(Date endSendTime) {
		this.endSendTime = endSendTime;
	}

	public Date getDeliverStartTime() {
		return deliverStartTime;
	}

	public void setDeliverStartTime(Date deliverStartTime) {
		this.deliverStartTime = deliverStartTime;
	}

	public Date getDeliverEndTime() {
		return deliverEndTime;
	}

	public void setDeliverEndTime(Date deliverEndTime) {
		this.deliverEndTime = deliverEndTime;
	}

	public Integer getAddrType() {
		return addrType;
	}

	public void setAddrType(Integer addrType) {
		this.addrType = addrType;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getConcactMobile() {
		return concactMobile;
	}

	public void setConcactMobile(String concactMobile) {
		this.concactMobile = concactMobile;
	}

	public Integer getOutRangeType() {
		return outRangeType;
	}

	public void setOutRangeType(Integer outRangeType) {
		this.outRangeType = outRangeType;
	}

	public Date getBegCreateTime() {
		return begCreateTime;
	}

	public void setBegCreateTime(Date begCreateTime) {
		this.begCreateTime = begCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getSaleUserName() {
		return saleUserName;
	}


	public void setSaleUserName(String saleUserName) {
		this.saleUserName = saleUserName;
	}

	public Integer getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(Integer saleUserId) {
		this.saleUserId = saleUserId;
	}

	public Date getPayTimeStartTime() {
		return payTimeStartTime;
	}

	public void setPayTimeStartTime(Date payTimeStartTime) {
		this.payTimeStartTime = payTimeStartTime;
	}

	public Date getPayTimeEndTime() {
		return payTimeEndTime;
	}

	public void setPayTimeEndTime(Date payTimeEndTime) {
		this.payTimeEndTime = payTimeEndTime;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	
}
