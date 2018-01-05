package com.qbt.web.pojo.couponCodeActivity;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class CouponCodeActivityVo {

	private int id;
	
	//优惠码名称
	@NotNull(message = "名称不能为空")
	private String name;

	//优惠开始时间
	@NotNull(message = "优惠开始时间不能为空")
    private Date startTime;

    //优惠结束时间
	@NotNull(message = "优惠结束时间不能为空")
    private Date endTime;

    //优惠码
    private String code;

    //优惠次数(-1无限)
    private Integer count;

    //已使用次数
    private Integer useCount;

    //规则（满）
    @NotNull(message = "规则不能为空")
    private Double ruleFull;

    //规则（减）
    @NotNull(message = "规则不能为空")
    private Double ruleReduce;
    
    //创建时间
    private Date createTime;

    //状态（1-正常 2-无效）
    private Integer status;

    //备注
    private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getUseCount() {
		return useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getRuleFull() {
		return ruleFull;
	}

	public void setRuleFull(Double ruleFull) {
		this.ruleFull = ruleFull;
	}

	public Double getRuleReduce() {
		return ruleReduce;
	}

	public void setRuleReduce(Double ruleReduce) {
		this.ruleReduce = ruleReduce;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
