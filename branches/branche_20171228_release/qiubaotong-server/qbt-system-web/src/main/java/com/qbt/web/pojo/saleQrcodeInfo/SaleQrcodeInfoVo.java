package com.qbt.web.pojo.saleQrcodeInfo;

public class SaleQrcodeInfoVo {

	//销售人员编号
	private String salesmanCode;

	//申请状态（0-未申请 1-已申请）
    private Integer applyStatus;

    //工作单位
    private String company;

    //销售人员二维码url
    private String qrcode;

    //提成方式（0-未知 1-固定金额 2-订单金额比例）
    private Integer type;
    
    //代下单每单提成
    private Double typeValue;
    
    //关注奖金金额
    private Double subscribeValue;
    
    //id
    private int id;
    
    //销售人员名称
    private String name;
    
    //首单提成方式: 0-未知 1-固定金额 2-订单金额比例
    private Integer firstType;
    
    //每单提成
    private Double firstTypeValue;
    
    //代下单日类型 1-不限 2-有限制天数
    private Integer orderDayType;
    
    //代下单日
    private Integer orderDayValue;
    
    //销售人员的id
    private Integer saleUserId;

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(Double typeValue) {
		this.typeValue = typeValue;
	}

	public Double getSubscribeValue() {
		return subscribeValue;
	}

	public void setSubscribeValue(Double subscribeValue) {
		this.subscribeValue = subscribeValue;
	}

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

	public Integer getFirstType() {
		return firstType;
	}

	public void setFirstType(Integer firstType) {
		this.firstType = firstType;
	}

	public Double getFirstTypeValue() {
		return firstTypeValue;
	}

	public void setFirstTypeValue(Double firstTypeValue) {
		this.firstTypeValue = firstTypeValue;
	}

	public Integer getOrderDayType() {
		return orderDayType;
	}

	public void setOrderDayType(Integer orderDayType) {
		this.orderDayType = orderDayType;
	}

	public Integer getOrderDayValue() {
		return orderDayValue;
	}

	public void setOrderDayValue(Integer orderDayValue) {
		this.orderDayValue = orderDayValue;
	}

	public Integer getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(Integer saleUserId) {
		this.saleUserId = saleUserId;
	}
    
}
