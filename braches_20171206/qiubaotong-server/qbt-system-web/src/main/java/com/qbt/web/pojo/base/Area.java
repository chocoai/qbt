package com.qbt.web.pojo.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuwang
 *
 */
public class Area {
	private String name;
	private String treePath;
	private int id;
	private int superId;
	private int level;
	private List<Area> items = new ArrayList<Area>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTreePath() {
		return treePath;
	}
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSuperId() {
		return superId;
	}
	public void setSuperId(int superId) {
		this.superId = superId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<Area> getItems() {
		return items;
	}
	public void setItems(List<Area> items) {
		this.items = items;
	}
	
}
