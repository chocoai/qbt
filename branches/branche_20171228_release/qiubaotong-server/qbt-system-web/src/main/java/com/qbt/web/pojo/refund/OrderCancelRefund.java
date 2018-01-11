package com.qbt.web.pojo.refund;

public class OrderCancelRefund {

	// 订单ID
	private int id;
	// 总金额
	private double totalAmount;
	// 退款金额
	private double refundAmount;
	// 扣费金额
	private double feeAmount;
	// 是否弹框提示
	private boolean tip = false;
	// 提示信息
	private String tipMsg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}
	public boolean isTip() {
		return tip;
	}
	public void setTip(boolean tip) {
		this.tip = tip;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	
}
