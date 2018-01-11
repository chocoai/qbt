package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum OrderStatus {

	/**
	 * 订单状态：
		1-待支付
		2-支付中
		3-支付成功
		4-支付失败(可重新)
		5-订单关闭-用户取消
		6-订单关闭-系统关单
		7-订单关闭-客服取消
		8-订单关闭-修改渠道
	 */
	un_pay(1,"待支付"),
	pay_ing(2,"支付中"),
	pay_succ(3,"支付成功"),
	pay_fail(4,"支付失败(可重新)"),
	user_close(5,"订单关闭-用户取消"),
	sys_close(6,"订单关闭-系统关单"),
	kf_close(7,"订单关闭-客服取消"),
	mail_change(8,"订单关闭-修改渠道");
	Integer code;
	String desc;

	private OrderStatus(Integer code,String desc) { 
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
	
	public static OrderStatus getByCode(Integer code){
		if(code != null){
			for(OrderStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
	
}
