/**
 * Project Name:qbt-common
 * File Name:CollectionType.java
 * Package Name:com.qbt.common.enums
 * Date:2017年3月9日下午3:48:48
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:CollectionType
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月9日 下午3:48:48
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum CollectionType {
	
	course("course", "球场")
	;
	
	private CollectionType(String type, String desc){
		this.type = type;
		this.desc = desc;
	}
	
	private String type;
	
	private String desc;

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
