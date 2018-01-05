/**
 * Project Name:qbt-web
 * File Name:OrderCountVo.java
 * Package Name:com.qbt.web.pojo.order
 * Date:2017年6月27日上午9:52:20
 *
*/

package com.qbt.web.pojo.order;
/**
 * ClassName:OrderCountVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年6月27日 上午9:52:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCountVo {
	
	//未支付数量
	private int unpayCount;
	
	//待取件数量
	private int waitCount;
	
	//运输中数量
	private int transportCount;
	
	//未送达数量
	private int unsignCount;

	public int getUnpayCount() {
		return unpayCount;
	}

	public void setUnpayCount(int unpayCount) {
		this.unpayCount = unpayCount;
	}

	public int getWaitCount() {
		return waitCount;
	}

	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}

	public int getTransportCount() {
		return transportCount;
	}

	public void setTransportCount(int transportCount) {
		this.transportCount = transportCount;
	}

	public int getUnsignCount() {
		return unsignCount;
	}

	public void setUnsignCount(int unsignCount) {
		this.unsignCount = unsignCount;
	}
	
}
