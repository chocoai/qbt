package com.qbt.web.pojo.baseNewsCatagory;

import javax.validation.constraints.NotNull;

/***
 * 
 * <b>类名：</b>BaseNewsCatagoryVo.java<br>
 * <p><b>标题：</b>球包通</p>
 * <p><b>描述：</b>新闻类型前端请求实体类</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @date  2017年3月24日 下午2:56:25
 */
public class BaseNewsCatagoryVo {
	
	private int id;
	
	@NotNull(message = "类型名称不能为空")
	private String name;
	
	@NotNull(message = "排序不能为空")
	private Integer sort;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
