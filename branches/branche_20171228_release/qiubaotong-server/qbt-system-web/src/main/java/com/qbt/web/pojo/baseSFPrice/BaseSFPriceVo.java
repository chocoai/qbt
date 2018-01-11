package com.qbt.web.pojo.baseSFPrice;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class BaseSFPriceVo {
	
	private int id;
	
	@NotNull(message = "出发省不能为空")
	private String startProvince;

	@NotNull(message = "出发市不能为空")
    private String startCity;

    @NotNull(message = "到达省不能为空")
    private String endProvince;

    @NotNull(message = "到达市不能为空")
    private String endCity;

    private BigDecimal cichenSfPrice;
    
    private BigDecimal cichenQbtPrice;
    
    private BigDecimal cichenFirstPrice;

    private BigDecimal cichenSecondPrice;
    
    private BigDecimal ciriSfPrice;
    
    private BigDecimal ciriQbtPrice;

    private BigDecimal ciriFirstPrice;

    private BigDecimal ciriSecondPrice;

    private BigDecimal jiriSfPrice;

    private BigDecimal jiriQbtPrice;

    private BigDecimal jiriFirstPrice;

    private BigDecimal jiriSecondPrice;

    private BigDecimal geriSfPrice;

    private BigDecimal geriQbtPrice;

    private BigDecimal geriFirstPrice;

    private BigDecimal geriSecondPrice;


	public String getStartProvince() {
		return startProvince;
	}

	public void setStartProvince(String startProvince) {
		this.startProvince = startProvince;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	public String getEndProvince() {
		return endProvince;
	}

	public void setEndProvince(String endProvince) {
		this.endProvince = endProvince;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	public BigDecimal getCichenSfPrice() {
		return cichenSfPrice;
	}

	public void setCichenSfPrice(BigDecimal cichenSfPrice) {
		this.cichenSfPrice = cichenSfPrice;
	}

	public BigDecimal getCichenQbtPrice() {
		return cichenQbtPrice;
	}

	public void setCichenQbtPrice(BigDecimal cichenQbtPrice) {
		this.cichenQbtPrice = cichenQbtPrice;
	}

	public BigDecimal getCichenFirstPrice() {
		return cichenFirstPrice;
	}

	public void setCichenFirstPrice(BigDecimal cichenFirstPrice) {
		this.cichenFirstPrice = cichenFirstPrice;
	}

	public BigDecimal getCichenSecondPrice() {
		return cichenSecondPrice;
	}

	public void setCichenSecondPrice(BigDecimal cichenSecondPrice) {
		this.cichenSecondPrice = cichenSecondPrice;
	}

	public BigDecimal getCiriSfPrice() {
		return ciriSfPrice;
	}

	public void setCiriSfPrice(BigDecimal ciriSfPrice) {
		this.ciriSfPrice = ciriSfPrice;
	}

	public BigDecimal getCiriQbtPrice() {
		return ciriQbtPrice;
	}

	public void setCiriQbtPrice(BigDecimal ciriQbtPrice) {
		this.ciriQbtPrice = ciriQbtPrice;
	}

	public BigDecimal getCiriFirstPrice() {
		return ciriFirstPrice;
	}

	public void setCiriFirstPrice(BigDecimal ciriFirstPrice) {
		this.ciriFirstPrice = ciriFirstPrice;
	}

	public BigDecimal getCiriSecondPrice() {
		return ciriSecondPrice;
	}

	public void setCiriSecondPrice(BigDecimal ciriSecondPrice) {
		this.ciriSecondPrice = ciriSecondPrice;
	}

	public BigDecimal getJiriSfPrice() {
		return jiriSfPrice;
	}

	public void setJiriSfPrice(BigDecimal jiriSfPrice) {
		this.jiriSfPrice = jiriSfPrice;
	}

	public BigDecimal getJiriQbtPrice() {
		return jiriQbtPrice;
	}

	public void setJiriQbtPrice(BigDecimal jiriQbtPrice) {
		this.jiriQbtPrice = jiriQbtPrice;
	}

	public BigDecimal getJiriFirstPrice() {
		return jiriFirstPrice;
	}

	public void setJiriFirstPrice(BigDecimal jiriFirstPrice) {
		this.jiriFirstPrice = jiriFirstPrice;
	}

	public BigDecimal getJiriSecondPrice() {
		return jiriSecondPrice;
	}

	public void setJiriSecondPrice(BigDecimal jiriSecondPrice) {
		this.jiriSecondPrice = jiriSecondPrice;
	}

	public BigDecimal getGeriSfPrice() {
		return geriSfPrice;
	}

	public void setGeriSfPrice(BigDecimal geriSfPrice) {
		this.geriSfPrice = geriSfPrice;
	}

	public BigDecimal getGeriQbtPrice() {
		return geriQbtPrice;
	}

	public void setGeriQbtPrice(BigDecimal geriQbtPrice) {
		this.geriQbtPrice = geriQbtPrice;
	}

	public BigDecimal getGeriFirstPrice() {
		return geriFirstPrice;
	}

	public void setGeriFirstPrice(BigDecimal geriFirstPrice) {
		this.geriFirstPrice = geriFirstPrice;
	}

	public BigDecimal getGeriSecondPrice() {
		return geriSecondPrice;
	}

	public void setGeriSecondPrice(BigDecimal geriSecondPrice) {
		this.geriSecondPrice = geriSecondPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	


}
