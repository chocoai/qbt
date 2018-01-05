package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum RefundStatus {

	/**
	 * 退款状态：
		1-正常状态
		2-待退款
		3-退款中
		4-退款完成
		5-退款失败
	 */
	refund_normal(1,"正常状态"),
	refund_wait(2,"待退款"),
	refund_ing(3,"退款中"),
	refund_sucess(4,"退款完成"),
	refund_fail(5,"退款失败");
	
	Integer code;
	String desc;

	private RefundStatus(Integer code,String desc) { 
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

	public static RefundStatus getByCode(Integer code){
		if(code != null){
			for(RefundStatus s : values()){
				if(s.getCode() == code){
					return s;
				}
			}
		}
		return null;
	}
}
