/**
 * Project Name:qbt-report
 * File Name:BagCodeOrderSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月25日下午3:49:32
 *
*/

package com.qbt.web.support;

import java.util.Map;

import com.qbt.bussiness.pojo.bagCode.BagCodeOrderPageReq;
import com.qbt.persistent.entity.SysUser;

/**
 * ClassName:BagCodeOrderSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:49:32
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BagCodeOrderSupport {
	
	public Map<String, Object> export(BagCodeOrderPageReq pageReq, String title, SysUser sysUser);
}
