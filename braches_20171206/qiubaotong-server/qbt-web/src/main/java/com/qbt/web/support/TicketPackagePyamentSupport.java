package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.TicketPackagePayment;
import com.qbt.web.pojo.ticketPackagePayment.TicketPackagePaymentRequest;

public interface TicketPackagePyamentSupport {

	public Map<String,String> pay(TicketPackagePaymentRequest payRequest);
	
	public TicketPackagePayment findByUuid(String uuid);
	
	public void updatePayment(TicketPackagePayment payment);
	
	public void createTicketPackageAfterPaid(int orderId);
}
