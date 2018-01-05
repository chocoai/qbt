/**
 * Project Name:qbt-support
 * File Name:EmailTemplateSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年10月18日下午4:27:43
 *
*/

package com.qbt.bussiness.support.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.EmailTemplateCreatorSupport;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.util.Arith;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.dto.OrderEmailTempletDto;
import com.qbt.persistent.entity.EmailConfig;
import com.qbt.persistent.entity.EmailTemplate;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.entity.OrderEmail;
import com.qbt.persistent.entity.OrderEmailInsured;
import com.qbt.persistent.entity.OrderEmailTemplet;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.service.EmailConfigService;
import com.qbt.service.EmailTemplateService;
import com.qbt.service.OrderEmailInsuredService;
import com.qbt.service.OrderEmailService;
import com.qbt.service.OrderEmailTempletService;

/**
 * ClassName:EmailTemplateSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月18日 下午4:27:43
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class EmailTemplateCreatorSupportImpl implements EmailTemplateCreatorSupport {

	@Resource
	private EmailTemplateService emailTemplateService;
	@Resource
	private OrderEmailService orderEmailService;
	@Resource
	private OrderEmailInsuredService orderEmailInsuredService;
	@Resource
	private OrderEmailTempletService orderEmailTempletService;
	@Resource
	private EmailConfigService emailConfigService;
	
	@Override
	public List<OrderEmailTempletDto> orderPaySucc(OrderInfo orderInfo) {
		
		//下单选择保价，1－20W，自动发送邮件给华安保险，同时下发给顺丰的下单邮件及报文里，保价金额写0元。
		OrderEmail orderEmail = orderEmailService.findByCode("orderCreate");
		OrderEmailInsured orderEmailInsured = orderEmailInsuredService.findByMinMaxAndOrderEmailId(orderInfo.getInsuredValue(), orderEmail.getId());
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		List<OrderEmailTemplet> orderEmailTempletList = orderEmailTempletService.findByOrderEmailInsuredId(orderEmailInsured.getId());
		List<OrderEmailTempletDto> orderEmailTempletDtoList = new ArrayList<OrderEmailTempletDto>();
		for (OrderEmailTemplet orderEmailTemplet : orderEmailTempletList) {
			EmailTemplate emailTemplate = emailTemplateService.findByCode(orderEmailTemplet.getEmailTemplateCode());
			String subject = MessageFormat.format(emailTemplate.getSubject(), currendDate, orderInfo.getMailNo());
			String content = "";
			if(orderInfo.getInsuredValue() == 0){
				content = MessageFormat.format(emailTemplate.getContent(), 
						currendDate,
						ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
						getSendSfUserTime(orderInfo),
						orderInfo.getDeliverDate(),
						orderInfo.getNumber(),
						orderInfo.getMailNo(),
						getJInfo(orderInfo),
						getdInfo(orderInfo),
						"1.0"
						);
			}else{
				if(orderEmailTempletList.size()>1&&orderEmailTemplet.getEmailTemplateCode().equals("sf_orderCreate")){
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							orderInfo.getNumber(),
							orderInfo.getMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							"0.0"
							);
				}else{
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							orderInfo.getNumber(),
							orderInfo.getMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							Arith.mul(orderInfo.getInsuredValue(),10000)
							);
				}
				
			}
			String[] emailContent = new String[]{subject,content.toString()};
			OrderEmailTempletDto orderEmailTempletDto = new OrderEmailTempletDto();
			EmailConfig emailConfig = emailConfigService.findByCode(orderEmailTemplet.getEmailConfigCode());
			orderEmailTempletDto.setEmailConfig(emailConfig);
			orderEmailTempletDto.setEmailContent(emailContent);
			orderEmailTempletDtoList.add(orderEmailTempletDto);
		}
		
		return orderEmailTempletDtoList;
	}

	@Override
	public List<OrderEmailTempletDto> orderCancle(OrderInfo orderInfo) {
		OrderEmail orderEmail = orderEmailService.findByCode("orderCancle");
		OrderEmailInsured orderEmailInsured = orderEmailInsuredService.findByMinMaxAndOrderEmailId(orderInfo.getInsuredValue(), orderEmail.getId());
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		List<OrderEmailTemplet> orderEmailTempletList = orderEmailTempletService.findByOrderEmailInsuredId(orderEmailInsured.getId());
		List<OrderEmailTempletDto> orderEmailTempletDtoList = new ArrayList<OrderEmailTempletDto>();
		
		for (OrderEmailTemplet orderEmailTemplet : orderEmailTempletList) {
			EmailTemplate emailTemplate = emailTemplateService.findByCode(orderEmailTemplet.getEmailTemplateCode());
			String subject = MessageFormat.format(emailTemplate.getSubject(), currendDate, orderInfo.getMailNo());
			String content = "";
			if(orderInfo.getInsuredValue() == 0){
				content = MessageFormat.format(emailTemplate.getContent(), 
						currendDate,
						ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
						getSendSfUserTime(orderInfo),
						orderInfo.getDeliverDate(),
						orderInfo.getNumber(),
						orderInfo.getMailNo(),
						getJInfo(orderInfo),
						getdInfo(orderInfo),
						"1.0"
						);
			}else{
				if(orderEmailTempletList.size()>1&&orderEmailTemplet.getEmailTemplateCode().equals("sf_orderCancle")){
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							orderInfo.getNumber(),
							orderInfo.getMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							"0.0"
							);
				}else{
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							orderInfo.getNumber(),
							orderInfo.getMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							Arith.mul(orderInfo.getInsuredValue(),10000)
							);
				}
				
			}
			String[] emailContent = new String[]{subject,content.toString()};
			OrderEmailTempletDto orderEmailTempletDto = new OrderEmailTempletDto();
			EmailConfig emailConfig = emailConfigService.findByCode(orderEmailTemplet.getEmailConfigCode());
			orderEmailTempletDto.setEmailConfig(emailConfig);
			orderEmailTempletDto.setEmailContent(emailContent);
			orderEmailTempletDtoList.add(orderEmailTempletDto);
		}
		return orderEmailTempletDtoList;
	}
	
	
	@Override
	public List<OrderEmailTempletDto> orderModify(OrderInfo orderInfo, OrderChangeBook book) {
		OrderEmail orderEmail = orderEmailService.findByCode("orderModify");
		OrderEmailInsured orderEmailInsured = orderEmailInsuredService.findByMinMaxAndOrderEmailId(orderInfo.getInsuredValue(), orderEmail.getId());
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		List<OrderEmailTemplet> orderEmailTempletList = orderEmailTempletService.findByOrderEmailInsuredId(orderEmailInsured.getId());
		List<OrderEmailTempletDto> orderEmailTempletDtoList = new ArrayList<OrderEmailTempletDto>();
		
		for (OrderEmailTemplet orderEmailTemplet : orderEmailTempletList) {
			EmailTemplate emailTemplate = emailTemplateService.findByCode(orderEmailTemplet.getEmailTemplateCode());
			String subject = MessageFormat.format(emailTemplate.getSubject(), currendDate, orderInfo.getMailNo());
			String content = "";
			if(orderInfo.getInsuredValue() == 0){
				content = MessageFormat.format(emailTemplate.getContent(), 
						currendDate,
						ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
						getSendSfUserTime(orderInfo),
						orderInfo.getDeliverDate(),
						book.getOldOrderNumber(),
						book.getNewOrderNumber(),
						book.getOldMailNo(),
						book.getNewMailNo(),
						getJInfo(orderInfo),
						getdInfo(orderInfo),
						"1.0"
						);
			}else{
				if(orderEmailTempletList.size()>1&&orderEmailTemplet.getEmailTemplateCode().equals("sf_orderModify")){
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							book.getOldOrderNumber(),
							book.getNewOrderNumber(),
							book.getOldMailNo(),
							book.getNewMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							"0.0"
							);
				}else{
					content = MessageFormat.format(emailTemplate.getContent(), 
							currendDate,
							ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc(),
							getSendSfUserTime(orderInfo),
							orderInfo.getDeliverDate(),
							book.getOldOrderNumber(),
							book.getNewOrderNumber(),
							book.getOldMailNo(),
							book.getNewMailNo(),
							getJInfo(orderInfo),
							getdInfo(orderInfo),
							Arith.mul(orderInfo.getInsuredValue(),10000)
							);
				}
				
			}
			String[] emailContent = new String[]{subject,content.toString()};
			OrderEmailTempletDto orderEmailTempletDto = new OrderEmailTempletDto();
			EmailConfig emailConfig = emailConfigService.findByCode(orderEmailTemplet.getEmailConfigCode());
			orderEmailTempletDto.setEmailConfig(emailConfig);
			orderEmailTempletDto.setEmailContent(emailContent);
			orderEmailTempletDtoList.add(orderEmailTempletDto);
		}
		return orderEmailTempletDtoList;
	}
	
	private static String getSendSfUserTime(OrderInfo orderInfo){
		return DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
	}
	
	public static String getJInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		String addrName = orderInfo.getjAddrName();
		if(!StringUtil.isEmpty(addrName)){
			addrName = "("+addrName+")";
		}
		msgsb.append(addrName)
			.append(orderInfo.getjTreePath().replace(",", ""))
			.append(orderInfo.getjAddress());
		return msgsb.toString();
	}
	
	public static String getdInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		String addrName = orderInfo.getdAddrName();
		if(!StringUtil.isEmpty(addrName)){
			addrName = "("+addrName+")";
		}
		msgsb.append(addrName)
			.append(orderInfo.getdTreePath().replace(",", ""))
			.append(orderInfo.getdAddress());
		return msgsb.toString();
	}

}
