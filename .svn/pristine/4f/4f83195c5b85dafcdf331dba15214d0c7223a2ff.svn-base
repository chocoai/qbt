package com.qbt.common.enums;


/**
 *  订单状态
  * @ClassName: OrderStatus
  * @Description: TODO
  * @author share 2016年8月13日
  * @modify share 2016年8月13日
 */
public enum QuestionStatus {

	/**
	 * 问题签收：
	1-正常签收
	2-异常签收
	注：问题签收备注、是否解决
	 */
	normal(1,"正常签收"),
	exception(2,"异常签收"),
	;
	
	Integer code;
	String desc;

	private QuestionStatus(Integer code,String desc) { 
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}


	public String getDesc() {
		return desc;
	}

	public static QuestionStatus getByCode(Integer code){
		if(code != null){
			for(QuestionStatus q : values()){
				if(q.getCode() == code){
					return q;
				}
			}
		}
		return null;
	}
	
}
