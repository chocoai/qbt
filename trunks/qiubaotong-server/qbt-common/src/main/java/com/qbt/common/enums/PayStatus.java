package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum PayStatus {

	/**
	 * 第三方支付支付返回状态，1-初始化 2-成功 3-失败
	 */
	init(1,"初始化"),
	success(2,"成功"),
	fail(3,"失败");
	
	Integer code;
	String desc;

	private PayStatus(Integer code,String desc) { 
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
