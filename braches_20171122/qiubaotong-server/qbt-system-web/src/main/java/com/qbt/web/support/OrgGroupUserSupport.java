/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月2日上午10:30:36
 *
*/

package com.qbt.web.support;
/**
 * ClassName:OrgGroupUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午10:30:36
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.common.ImportRespVo;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserImportReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserPageReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserVo;

public interface OrgGroupUserSupport {
	
	List<OrgGroupUserVo> findByPage(OrgGroupUserPageReq reqVo);
	
	OrgGroupUserVo detail(Integer id);
	
	int add(OrgGroupUserVo vo, SysUser sysUser);
	
	boolean update(OrgGroupUserVo vo, SysUser sysUser);
	
	boolean delete(List<Integer> ids);
	
	ImportRespVo importFile(OrgGroupUserImportReq importReq, SysUser sysUser) throws Exception;
	
}
