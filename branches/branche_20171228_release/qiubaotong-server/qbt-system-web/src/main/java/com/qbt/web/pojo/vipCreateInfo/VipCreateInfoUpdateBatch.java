/**
 * Project Name:qbt-system-web
 * File Name:VipCreateInfoUpdateBatchVo.java
 * Package Name:com.qbt.web.pojo.vipCreateInfo
 * Date:2017年1月5日上午10:35:51
 *
*/

package com.qbt.web.pojo.vipCreateInfo;

import java.util.List;

/**
 * ClassName:VipCreateInfoUpdateBatchVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月5日 上午10:35:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class VipCreateInfoUpdateBatch {
	
	private List<Integer> ids;
	
	private Double payAmount;

    private Integer payMethod;
    
    private Integer status;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
