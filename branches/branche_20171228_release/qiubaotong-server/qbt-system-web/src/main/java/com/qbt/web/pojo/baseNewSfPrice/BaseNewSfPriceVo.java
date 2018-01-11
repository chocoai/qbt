package com.qbt.web.pojo.baseNewSfPrice;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseNewSfPriceVo {

	//id
	private int id;
	
	//创建时间
	private Date createTime;
	
	//寄件地区
	@NotNull(message = "寄件地区不能为空")
	private String startArea;

	//收件地区
	@NotNull(message = "收件地区不能为空")
    private String endArea;

    //次晨优惠价格
	@NotNull(message = "次晨优惠价格不能为空")
    private double cichenFavourablePrice;

    //次晨球包通价格
	@NotNull(message = "次晨球包通价格不能为空")
    private double cichenQbtPrice;

    //次日优惠价格
	@NotNull(message = "次日优惠价格不能为空")
    private double ciriFavourablePrice;

    //次日球包通价格
	@NotNull(message = "次日球包通价格不能为空")
    private double ciriQbtPrice;

    //隔日优惠价格
	@NotNull(message = "隔日优惠价格不能为空")
    private double geriFavourablePrice;

    //隔日球包通价格
	@NotNull(message = "隔日球包通价格不能为空")
    private double geriQbtPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStartArea() {
		return startArea;
	}

	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}

	public String getEndArea() {
		return endArea;
	}

	public void setEndArea(String endArea) {
		this.endArea = endArea;
	}

	public double getCichenFavourablePrice() {
		return cichenFavourablePrice;
	}

	public void setCichenFavourablePrice(double cichenFavourablePrice) {
		this.cichenFavourablePrice = cichenFavourablePrice;
	}

	public double getCichenQbtPrice() {
		return cichenQbtPrice;
	}

	public void setCichenQbtPrice(double cichenQbtPrice) {
		this.cichenQbtPrice = cichenQbtPrice;
	}

	public double getCiriFavourablePrice() {
		return ciriFavourablePrice;
	}

	public void setCiriFavourablePrice(double ciriFavourablePrice) {
		this.ciriFavourablePrice = ciriFavourablePrice;
	}

	public double getCiriQbtPrice() {
		return ciriQbtPrice;
	}

	public void setCiriQbtPrice(double ciriQbtPrice) {
		this.ciriQbtPrice = ciriQbtPrice;
	}

	public double getGeriFavourablePrice() {
		return geriFavourablePrice;
	}

	public void setGeriFavourablePrice(double geriFavourablePrice) {
		this.geriFavourablePrice = geriFavourablePrice;
	}

	public double getGeriQbtPrice() {
		return geriQbtPrice;
	}

	public void setGeriQbtPrice(double geriQbtPrice) {
		this.geriQbtPrice = geriQbtPrice;
	}
	
}
