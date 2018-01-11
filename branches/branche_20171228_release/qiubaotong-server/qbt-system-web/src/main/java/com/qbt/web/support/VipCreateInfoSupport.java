/**
 * Project Name:qbt-system-web
 * File Name:VipCreateInfoSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月5日上午10:23:46
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoPageReqVo;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoUpdateBatch;
import com.qbt.web.pojo.vipCreateInfo.VipCreateInfoVo;

/**
 * ClassName:VipCreateInfoSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月5日 上午10:23:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCreateInfoSupport {
	
	List<VipCreateInfoVo> findByPage(VipCreateInfoPageReqVo reqVo);
	
	boolean updateBatch(VipCreateInfoUpdateBatch updateBatch);
}
