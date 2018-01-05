/**
 * Project Name:qbt-support
 * File Name:EmailTemplateSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年10月18日下午4:27:28
 *
*/

package com.qbt.bussiness.support;

import java.util.List;

import com.qbt.persistent.dto.OrderEmailTempletDto;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:EmailTemplateSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月18日 下午4:27:28
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface EmailTemplateCreatorSupport {
	
	public List<OrderEmailTempletDto> orderPaySucc(OrderInfo orderInfo);

	public List<OrderEmailTempletDto> orderCancle(OrderInfo orderInfo);

	public List<OrderEmailTempletDto> orderModify(OrderInfo orderInfo, OrderChangeBook book);
	
	
}
