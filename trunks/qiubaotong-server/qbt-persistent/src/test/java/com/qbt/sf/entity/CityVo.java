package com.qbt.sf.entity;

public class CityVo {
	private long distId;
	private String code;
	private int level;
	private long parentId;
	private String parentCode;
	private String countryCode;
	private String name;
	private String lang;
	public int getDistId() {
		if(distId == 10086328435877l){
			return 2000001;
		}
		return (int)distId;
	}
	public void setDistId(long distId) {
		this.distId = distId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParentId() {
		if(parentId == 10086328435877l){
			return 2000001;
		}
		return (int)parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
