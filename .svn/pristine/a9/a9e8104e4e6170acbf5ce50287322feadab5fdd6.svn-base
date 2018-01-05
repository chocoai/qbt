/**
 * Project Name:qbt-common
 * File Name:SaleUserFirstType.java
 * Package Name:com.qbt.common.enums
 * Date:2017年3月27日下午3:41:29
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:SaleUserOrderDayType
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月27日 下午3:41:29
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum SaleUserOrderDayType {
	/**
	 * 代下单日类型 1-不限 2-有限制天数
	 */
	unlimited(1, "不限"),
	limited(2, "有限制天数"),
	;
	
	private SaleUserOrderDayType(int type, String desc){
		this.type = type;
		this.desc = desc;
	}
	
	private int type;
	
	private String desc;

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public static SaleUserOrderDayType getByType(int type){
		for(SaleUserOrderDayType dayType : values()){
			if(dayType.getType() == type){
				return dayType;
			}
		}
		return null;
	}
}
