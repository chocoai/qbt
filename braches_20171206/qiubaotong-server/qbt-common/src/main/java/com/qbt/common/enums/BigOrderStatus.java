package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum BigOrderStatus {

	/**
	 * 订单状态：
		1-待支付
		2-已支付
	 */
	normal(1,"正常"),
	close(2,"关闭");
	Integer code;
	String desc;

	private BigOrderStatus(Integer code,String desc) { 
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
	
	public static BigOrderStatus getByCode(Integer code){
		if(code != null){
			for(BigOrderStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
	
}
