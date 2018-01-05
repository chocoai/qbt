/**
 * Project Name:qbt-system-web
 * File Name:BaseAdvertSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年10月10日上午10:04:29
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.baseAdvert.BaseAdvertPageReq;
import com.qbt.web.pojo.baseAdvert.BaseAdvertVo;

/**
 * ClassName:BaseAdvertSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午10:04:29
 * @author   wuwang
 * @version  
 * @see 	 
 */
public interface BaseAdvertSupport {

	List<BaseAdvertVo> findByPage(BaseAdvertPageReq pageReq);

	void updateStatus(Integer id, int status);

	BaseAdvertVo findById(Integer id);

	void update(SysUser sysUser, BaseAdvertVo reqVo);

	
	
}
