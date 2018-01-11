package com.qbt.common.enums;


/**
 *  支付状态
  * @ClassName: BigOrderPayStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum BigOrderPayStatus {

	/**
	 * 订单状态：
		1-待支付
		2-已支付
	 */
	un_pay(1,"待支付"),
	paid(2,"已支付");
	Integer code;
	String desc;

	private BigOrderPayStatus(Integer code,String desc) { 
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
	
	public static BigOrderPayStatus getByCode(Integer code){
		if(code != null){
			for(BigOrderPayStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
	
}
