/**
 * Project Name:qbt-system-web
 * File Name:VipCreateSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月4日上午11:19:30
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.vipCreate.VipCreateGenerate;
import com.qbt.web.pojo.vipCreate.VipCreatePageReqVo;
import com.qbt.web.pojo.vipCreate.VipCreateVo;

/**
 * ClassName:VipCreateSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午11:19:30
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCreateSupport {
	
	boolean generateVipCard(VipCreateGenerate generate, SysUser sysUser);
	
	List<VipCreateVo> findByPage(VipCreatePageReqVo reqVo);
	
}
