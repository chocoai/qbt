/**
 * Project Name:qbt-web
 * File Name:OrderDetailWaybill.java
 * Package Name:com.qbt.web.pojo.order
 * Date:2016年11月15日下午4:25:07
 *
*/

package com.qbt.web.pojo.order;

import java.util.List;

import com.qbt.web.pojo.sf.WayBill;

/**
 * ClassName:OrderDetailWaybill
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月15日 下午4:25:07
 * @author   haungyihao
 * @version  
 * @see 	 
 */
public class OrderDetailWaybill extends OrderDetail {
	
	private List<WayBill> waybills;

	public List<WayBill> getWaybills() {
		return waybills;
	}

	public void setWaybills(List<WayBill> waybills) {
		this.waybills = waybills;
	}
	
}
