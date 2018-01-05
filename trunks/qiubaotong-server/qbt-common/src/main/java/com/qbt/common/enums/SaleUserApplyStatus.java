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
public enum SaleUserApplyStatus {
	
	//1-待审核 2-审核通过 3-审核不通过
	wait(1, "待审核"),
	success(2, "审核通过"),
	fail(3, "审核不通过"),
	;
	
	private int status;
	
	private String desc;
	
	private SaleUserApplyStatus(int status, String desc){
		this.status = status;
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static SaleUserApplyStatus getByStatus(int status){
		for(SaleUserApplyStatus t : values()){
			if(t.getStatus() == status){
				return t;
			}
		}
		return null;
	}
	
}
