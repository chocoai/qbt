package com.qbt.common.enums;

public enum PaymethodEnum {
	/**
	 * 支付方式：
	 * 1-微信支付
	 * 98-合作方下单免支付
	 * 99-现金券满额支付
	 */
	weixin_pay(1,"微信支付"),
	boss_vip_pay(2,"boss购买"),
	alipay(3, "支付宝"),
	remittance_pay(4, "汇款"),
	cash_pay(5, "现金"),
	boss_pay(97,"boss代支付"),
	partner_pay(98,"合作方代支付"),
	un_pay(99,"现金券满额支付")
	;
	Integer code;
	String desc;

	private PaymethodEnum(Integer code,String desc) { 
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

	public static PaymethodEnum getByCode(Integer code){
		if(code != null){
			for(PaymethodEnum p : values()){
				if(p.getCode() == code){
					return p;
				}
			}
		}
		return null;
	}
}
