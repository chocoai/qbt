/**
 * Project Name:qbt-persistent
 * File Name:EmailMessageDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年10月27日下午4:41:59
 *
*/

package com.qbt.persistent.dto;

import com.qbt.persistent.entity.EmailMessage;

/**
 * ClassName:EmailMessageDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月27日 下午4:41:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class EmailMessageDto extends EmailMessage {
	
	//邮箱地址
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
