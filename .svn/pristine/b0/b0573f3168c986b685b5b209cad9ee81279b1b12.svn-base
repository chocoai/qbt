/**
 * Project Name:qbt-common
 * File Name:SaleUserType.java
 * Package Name:com.qbt.common.enums
 * Date:2017年2月8日下午2:28:05
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:SaleUserType
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午2:28:05
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum SaleUserType {
	//0-未知 1-固定金额 2-订单金额比例
	unknow(0, "未知"),
	percent_type(1, "固定金额￥"),
	rebate_type(2, "订单金额%"),
	;
	
	private int type;
	
	private String desc;
	
	private SaleUserType(int type, String desc){
		this.type = type;
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static SaleUserType getByType(int type){
		for(SaleUserType t : values()){
			if(t.getType() == type){
				return t;
			}
		}
		return null;
	}
	
}
