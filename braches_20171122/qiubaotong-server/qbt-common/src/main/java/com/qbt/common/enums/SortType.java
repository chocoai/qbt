/**
 * Project Name:qbt-common
 * File Name:SortType.java
 * Package Name:com.qbt.common.enums
 * Date:2017年3月10日上午10:49:06
 *
*/

package com.qbt.common.enums;
/**
 * ClassName:SortType
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月10日 上午10:49:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public enum SortType {
	
	 ASC(1, "升序排列"), 
	 DESC(-1, "降序排列")
	 ;
	 
	 private SortType(int type, String desc){
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
	 
}
