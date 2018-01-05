package com.qbt.web.pojo.baseNewsCatagory;

import com.qbt.common.result.Paging;

/**
 * 
 * <b>类名：</b>NewsCatagoryPageVo.java<br>
 * <p><b>标题：</b>球包通</p>
 * <p><b>描述：</b>新闻分类分页请求Vo</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @date  2017年3月24日 下午3:08:11
 */
public class NewsCatagoryPageVo extends Paging{
	
	private int id;
	
	private String name;
	
	private int sort;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	
}
