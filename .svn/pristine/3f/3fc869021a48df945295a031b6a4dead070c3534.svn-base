/**
 * Project Name:qbt-common
 * File Name:SaleUserFirstType.java
 * Package Name:com.qbt.common.enums
 * Date:2017年3月27日下午3:41:29
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:SaleUserFirstType
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月27日 下午3:41:29
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum SaleUserFirstType {
	/**
	 * 0-未知 1-固定金额 2-订单金额比例
	 */
	unknow(0, "未知"),
	money(1, "固定金额￥"),
	percent(2, "订单金额比例%"),
	;
	
	private SaleUserFirstType(int type, String desc){
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
	
	public static SaleUserFirstType getByType(int type){
		for(SaleUserFirstType firstType : values()){
			if(firstType.getType() == type){
				return firstType;
			}
		}
		return null;
	}
}
