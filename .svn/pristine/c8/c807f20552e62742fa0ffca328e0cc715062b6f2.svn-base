package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.TicketPackagePayment;
import com.qbt.persistent.mapper.TicketPackagePaymentMapper;
import com.qbt.service.TicketPackagePaymentService;

/**
 * @ClassName: TicketPackagePaymentServiceImpl
 */
@Service
public class TicketPackagePaymentServiceImpl implements TicketPackagePaymentService {

	@Resource
	private TicketPackagePaymentMapper ticketPackagePaymentMapper;

	@Override
	public int insert(TicketPackagePayment ticketPackagePayment) {
		return ticketPackagePaymentMapper.insert(ticketPackagePayment);
	}

	@Override
	public TicketPackagePayment findByUserId(int userId, int paymethod) {
		return ticketPackagePaymentMapper.findByUserId(userId, paymethod);
	}

	@Override
	public TicketPackagePayment findByUuid(String uuid) {
		return ticketPackagePaymentMapper.findByUuid(uuid);
	}

	/**
	 * @Title: update
	 * @param ticketPackagePayment
	 * @return
	 */
	@Override
	public int updateById(TicketPackagePayment ticketPackagePayment) {
		return ticketPackagePaymentMapper.updateById(ticketPackagePayment);
	}

}
