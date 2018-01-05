package com.qbt.web.pojo.order;

import com.qbt.common.result.Paging;

/**
 *  订单分页查询
  * @ClassName: OrderPageRequest
  * @Description: TODO
  * @author share 2016年10月9日
  * @modify share 2016年10月9日
 */
public class OrderPageRequest extends Paging {

	private int userId;
	
	private int orderStatus;
	
	private int applyId;
	
	private int type;// 1-个人机构订单。2-机构订单
	
	//非代下单-0，代下单-1
	private Integer proxyUserId = 0;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(Integer proxyUserId) {
		this.proxyUserId = proxyUserId;
	}
	
	
	
}
