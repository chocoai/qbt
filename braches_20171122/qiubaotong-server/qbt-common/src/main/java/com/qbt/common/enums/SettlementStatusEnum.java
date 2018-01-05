package com.qbt.common.enums;

/**
 *  助理类型
  * @ClassName: ApplyTypeEnum
  * @Description: TODO
  * @author share 2016年8月24日
  * @modify share 2016年8月24日
 */
public enum SettlementStatusEnum {

	un_settlement(1,"未结算"),
	suc_settlement(2,"已结算"),
	invalid_settlement(3,"无效结算记录"),
	;
	Integer code;
	String desc;

	private SettlementStatusEnum(Integer code,String desc) { 
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static SettlementStatusEnum getByCode(Integer code){
		if(code != null){
			for(SettlementStatusEnum s : values()){
				if (s.getCode() == code) return s;
			}
		}
		return null;
	}
	
}
