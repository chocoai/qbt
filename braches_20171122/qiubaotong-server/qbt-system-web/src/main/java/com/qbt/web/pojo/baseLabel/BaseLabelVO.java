package com.qbt.web.pojo.baseLabel;

import java.util.List;

public class BaseLabelVO {

	private Integer id;
	
	private String name;
	
	private Integer superId;
	
	private String content;
	
	private List<BaseLabelVO> item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSuperId() {
		return superId;
	}

	public void setSuperId(Integer superId) {
		this.superId = superId;
	}

	public List<BaseLabelVO> getItem() {
		return item;
	}

	public void setItem(List<BaseLabelVO> item) {
		this.item = item;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
