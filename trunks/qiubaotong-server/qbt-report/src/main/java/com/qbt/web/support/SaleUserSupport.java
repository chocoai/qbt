/**
 * Project Name:qbt-report
 * File Name:SaleUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月8日下午1:58:41
 *
*/

package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.saleUser.SaleUserExportRequest;

/**
 * ClassName:SaleUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午1:58:41
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SaleUserSupport {
	
	public Map<String, Object> exportSaleUser(SaleUserExportRequest req, SysUser sysUser);
	
}
