/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月1日下午5:53:49
 *
*/

package com.qbt.web.support;
/**
 * ClassName:OrgGroupSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午5:53:49
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orgGroup.OrgGroupDetailVo;
import com.qbt.web.pojo.orgGroup.OrgGroupPageReq;
import com.qbt.web.pojo.orgGroup.OrgGroupVo;

public interface OrgGroupSupport {
	
	List<OrgGroupVo> findByPage(OrgGroupPageReq reqVo);
	
	int add(OrgGroupDetailVo vo, SysUser sysUser);
	
	boolean update(OrgGroupDetailVo vo, SysUser sysUser);
	
	boolean delete(Integer id);
	
	OrgGroupDetailVo detail(Integer id);
	
	List<OrgGroupVo> list();
}
