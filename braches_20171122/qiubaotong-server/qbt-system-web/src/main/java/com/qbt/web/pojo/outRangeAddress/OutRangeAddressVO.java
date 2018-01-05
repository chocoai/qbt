package com.qbt.web.pojo.outRangeAddress;

import javax.validation.constraints.NotNull;

public class OutRangeAddressVO {
	
	private int id;
	
	@NotNull(message = "地区不能为空")
	private Integer areaId;

    private String treePath;
    
    //偏远球场时效(天数)
    @NotNull(message = "时效不能为空")
    private Double outRangeTime;

    //偏远球场价格
    @NotNull(message = "偏远球场价格不能为空")
    private Double outRangePrice;

    //地址（添加）
    private String[] addressArr;
    
    //地址（返回）
    private String address;
    
    private String treeId;
    
    //备注
    private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public Double getOutRangeTime() {
		return outRangeTime;
	}

	public void setOutRangeTime(Double outRangeTime) {
		this.outRangeTime = outRangeTime;
	}

	public Double getOutRangePrice() {
		return outRangePrice;
	}

	public void setOutRangePrice(Double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	public String[] getAddressArr() {
		return addressArr;
	}

	public void setAddressArr(String[] addressArr) {
		this.addressArr = addressArr;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}