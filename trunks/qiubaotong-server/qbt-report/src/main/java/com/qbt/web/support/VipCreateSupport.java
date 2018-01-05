/**
 * Project Name:qbt-report
 * File Name:VipCreateSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月4日下午2:10:08
 *
*/

package com.qbt.web.support;

import java.util.Map;

import com.qbt.persistent.entity.SysUser;

/**
 * ClassName:VipCreateSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 下午2:10:08
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCreateSupport {
	
	public Map<String, Object> exportVipCreateInfo(Integer vipCreateId, SysUser sysUser);
	
}
