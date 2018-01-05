package com.qbt.common.enums;

public enum DeliveryStatus {

	/**
	 * 物流状态：
		1-尚未下单至顺丰
		2-待上门收件
		3-顺丰已取件
		4-顺丰已取件(客服确认)
		5-物流运输中
		6-派送中
		7-已签收
	 */
	un_send_sf(1,"尚未下单至顺丰"),
	wait_sf_recive(2,"待上门收件"),
	sf_recived(3,"顺丰已取件"),
	kf_confirm_recived(4,"顺丰已取件(客服确认)"),
	transport_ing(5,"物流运输中"),
	delivery_ing(6,"派送中"),
	signed(7,"已签收")
	;
	
	Integer code;
	String desc;

	private DeliveryStatus(Integer code,String desc) { 
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
	
	public static String getDesc(int type) {
		for(DeliveryStatus deliver : DeliveryStatus.values()){
			if(deliver.getCode().intValue() == type){
				return deliver.getDesc();
			}
		}
		return null;
	}
}
