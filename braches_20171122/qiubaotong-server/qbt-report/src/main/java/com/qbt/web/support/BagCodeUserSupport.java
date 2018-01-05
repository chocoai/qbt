/**
 * Project Name:qbt-report
 * File Name:BagCodeUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月25日下午2:48:59
 *
*/

package com.qbt.web.support;

import java.util.Map;

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.persistent.entity.SysUser;

/**
 * ClassName:BagCodeUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:48:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface BagCodeUserSupport {
	
	public Map<String, Object> export(BagCodeUserPageReq pageReq, String title, SysUser sysUser);
	
}
