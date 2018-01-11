/**
 * Project Name:qbt-shansong
 * File Name:ShansongRequest.java
 * Package Name:com.qbt.shansong.entity
 * Date:2017年2月23日下午3:25:38
 *
*/

package com.qbt.shansong.entity;
/**
 * ClassName:ShansongRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午3:25:38
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ShansongRequest {
	
	//合作伙伴编号
	private String partnerNo;
	
	//签名加密
	private String signature;

	public String getPartnerNo() {
		return partnerNo;
	}

	public void setPartnerNo(String partnerNo) {
		this.partnerNo = partnerNo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
