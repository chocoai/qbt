package com.qbt.web.pojo.vip;

import java.math.BigDecimal;

public class VipTypeVo{
   
	private int id; 
    //会员卡名称 	
    private String name;
    //会员卡购买金额
    private BigDecimal amount;
    //下单金额
    private BigDecimal orderAmount;
    //有效期描述
    private String validDesc;
    //有效期，单位天
    private Integer valid;
    //细则
    private String rules;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getValidDesc() {
        return validDesc;
    }

    public void setValidDesc(String validDesc) {
        this.validDesc = validDesc == null ? null : validDesc.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

	
	/**
	 * getter method 
	 * @Title: getId
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}

	
	/**
	* setter method
	* @param id the id to set
	*/
	
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * getter method 
	 * @Title: getRules
	 * @return the rules
	 */
	
	public String getRules() {
		return rules;
	}

	
	/**
	* setter method
	* @param rules the rules to set
	*/
	
	public void setRules(String rules) {
		this.rules = rules;
	}
    
    

}