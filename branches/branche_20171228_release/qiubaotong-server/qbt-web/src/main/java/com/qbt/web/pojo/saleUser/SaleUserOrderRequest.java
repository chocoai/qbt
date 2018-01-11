/**
 * Project Name:qbt-web
 * File Name:SaleUserOrderRequest.java
 * Package Name:com.qbt.web.pojo.saleUser
 * Date:2017年2月14日下午2:01:44
 *
*/

package com.qbt.web.pojo.saleUser;
/**
 * ClassName:SaleUserOrderRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月14日 下午2:01:44
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserOrderRequest {
	
	private String queryDate;
	
	private int settleStatus;

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public int getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(int settleStatus) {
		this.settleStatus = settleStatus;
	}
	
}
