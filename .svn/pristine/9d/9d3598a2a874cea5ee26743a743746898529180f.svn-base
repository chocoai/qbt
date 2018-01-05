package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum OrderSource {

	/**
	 *订单来源：
	1-微信下单
	2-电话下单
	3-PC下单
	4-APP下单(预留)
	 */
	weixin(1,"微信下单"),
	phone(2,"电话下单"),
	pc_online(3,"PC下单"),
	app(4,"APP下单"),
	boss(5,"BOSS下单"),
	;
	
	Integer code;
	String desc;

	private OrderSource(Integer code,String desc) { 
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
