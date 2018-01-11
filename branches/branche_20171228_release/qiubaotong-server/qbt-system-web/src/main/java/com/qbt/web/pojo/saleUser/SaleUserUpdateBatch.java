/**
 * Project Name:qbt-system-web
 * File Name:SaleUserUpdateBatch.java
 * Package Name:com.qbt.web.pojo.saleUser
 * Date:2017年2月7日下午7:48:28
 *
*/

package com.qbt.web.pojo.saleUser;

import java.util.List;

/**
 * ClassName:SaleUserUpdateBatch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午7:48:28
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserUpdateBatch {
	
	private List<Integer> ids;
	
	private Integer type;

    private Double typeValue;
	
    private double subscribeValue;
	
    private Integer status;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(Double typeValue) {
		this.typeValue = typeValue;
	}

	public double getSubscribeValue() {
		return subscribeValue;
	}

	public void setSubscribeValue(double subscribeValue) {
		this.subscribeValue = subscribeValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
