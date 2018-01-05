/**
 * Project Name:qbt-persistent
 * File Name:OrderCountDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年6月27日下午2:03:12
 *
*/

package com.qbt.persistent.dto;
/**
 * ClassName:OrderCountDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年6月27日 下午2:03:12
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCountDto {
	
	private int transportCount;
	
	private int waitCount;

	public int getTransportCount() {
		return transportCount;
	}

	public void setTransportCount(int transportCount) {
		this.transportCount = transportCount;
	}

	public int getWaitCount() {
		return waitCount;
	}

	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}
	
}
