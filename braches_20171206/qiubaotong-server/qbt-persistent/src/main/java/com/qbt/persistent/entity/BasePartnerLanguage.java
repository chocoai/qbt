package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BasePartnerLanguage extends BaseEntity {
	
	private int partnerlId;
	
	private int languageId;
	
	private String name;
	
	private String ename;

	public int getPartnerlId() {
		return partnerlId;
	}

	public void setPartnerlId(int partnerlId) {
		this.partnerlId = partnerlId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	
	
	
}
