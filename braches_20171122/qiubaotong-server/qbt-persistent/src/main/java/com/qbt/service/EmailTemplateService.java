/**
 * Project Name:qbt-persistent
 * File Name:EmailTemplateService.java
 * Package Name:com.qbt.service
 * Date:2017年10月18日下午4:09:07
 *
*/

package com.qbt.service;

import com.qbt.persistent.entity.EmailTemplate;

/**
 * ClassName:EmailTemplateService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月18日 下午4:09:07
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface EmailTemplateService {

	EmailTemplate findByCode(String code);

}
