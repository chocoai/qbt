package com.qbt.common.entity;

public class BaseAdminVo {

	private String cinemaId;
	private int id;		 //用于通用的id值存放
	private String name;     //文本框
	private String phone;     //文本框
	private int status = -1; //下拉框
	private String no;
	private String begTime;
	private String endTime;
	private boolean isCn = true;
	
	public String getBegTime() {
		return begTime;
	}
	public void setBegTime(String begTime) {
		this.begTime = begTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	private int[] ids;    //checkbox记录选择
	private int flag = -1;	     //更新状态
	
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCn() {
		return isCn;
	}
	public void setCn(boolean isCn) {
		this.isCn = isCn;
	}
	public Boolean getIsCn() {
		return isCn;
	}
	public void setIsCn(Boolean isCn) {
		this.isCn = isCn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
}