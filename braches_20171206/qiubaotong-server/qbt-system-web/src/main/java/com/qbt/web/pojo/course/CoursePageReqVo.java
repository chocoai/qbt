package com.qbt.web.pojo.course;

import com.qbt.common.result.Paging;

public class CoursePageReqVo extends Paging {
	
	private String name;
	
	private Integer areaId;
	
	//球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
	private Integer status;
	
    private Boolean isDelete;
    
    // 是否偏远球场
 	private Boolean isOutRange;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsOutRange() {
		return isOutRange;
	}

	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}

}
