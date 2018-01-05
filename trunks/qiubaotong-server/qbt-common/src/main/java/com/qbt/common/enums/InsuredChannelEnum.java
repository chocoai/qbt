/**
 * Project Name:qbt-common
 * File Name:InsuredChannelEnum.java
 * Package Name:com.qbt.common.enums
 * Date:2017年10月26日下午2:44:47
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:InsuredChannelEnum
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月26日 下午2:44:47
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum InsuredChannelEnum {
	
	sf("sf", "顺丰"),
	ha("ha", "华安"),
	;
	
	private InsuredChannelEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	private String code;
	
	private String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
	public static InsuredChannelEnum getByCode(String code) {
		if(code != null) {
			for(InsuredChannelEnum i : values()) {
				if(i.getCode().equals(code)) return i;
			}
		}
		return null;
	}
	
}
