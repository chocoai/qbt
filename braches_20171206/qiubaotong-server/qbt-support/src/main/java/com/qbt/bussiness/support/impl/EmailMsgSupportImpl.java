/**
 * Project Name:qbt-support
 * File Name:EmailMsgSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年8月2日下午4:13:15
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.EmailMsgSupport;
import com.qbt.bussiness.support.EmailTemplateCreatorSupport;
import com.qbt.email.EmailService;
import com.qbt.persistent.dto.OrderEmailTempletDto;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:EmailMsgSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 下午4:13:15
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class EmailMsgSupportImpl implements EmailMsgSupport {
	
	@Resource
	private EmailService emailService;
	
	@Resource
	private EmailTemplateCreatorSupport emailTemplateSupport;
	
	@Override
	public void orderPaySuccNotify(OrderInfo orderInfo) {
		//String[] emails = EmailTemplate.orderPaySucc(orderInfo);
		//emailService.sendEmail(emails[0], emails[1]);
		List<OrderEmailTempletDto> orderEmailTempletDtoList = emailTemplateSupport.orderPaySucc(orderInfo);
		for (OrderEmailTempletDto orderEmailTempletDto : orderEmailTempletDtoList) {
			emailService.sendEmail(orderEmailTempletDto.getEmailConfig(), orderEmailTempletDto.getEmailContent()[0], orderEmailTempletDto.getEmailContent()[1]);
		}
	}

	@Override
	public void orderCancleNotify(OrderInfo orderInfo) {
		//String[] emails = EmailTemplate.orderCancle(orderInfo);
		//emailService.sendEmail(emails[0], emails[1]);
		List<OrderEmailTempletDto> orderEmailTempletDtoList = emailTemplateSupport.orderCancle(orderInfo);
		for (OrderEmailTempletDto orderEmailTempletDto : orderEmailTempletDtoList) {
			emailService.sendEmail(orderEmailTempletDto.getEmailConfig(), orderEmailTempletDto.getEmailContent()[0], orderEmailTempletDto.getEmailContent()[1]);
		}
	}

	@Override
	public void orderModifyNotify(OrderInfo orderInfo, OrderChangeBook book) {
		//String[] emails = EmailTemplate.orderModify(orderInfo, book);
		//emailService.sendEmail(emails[0], emails[1]);
		List<OrderEmailTempletDto> orderEmailTempletDtoList =  emailTemplateSupport.orderModify(orderInfo, book);
		for (OrderEmailTempletDto orderEmailTempletDto : orderEmailTempletDtoList) {
			emailService.sendEmail(orderEmailTempletDto.getEmailConfig(), orderEmailTempletDto.getEmailContent()[0], orderEmailTempletDto.getEmailContent()[1]);
		}
	}

}
