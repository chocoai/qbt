/**
 * Project Name:qbt-system-web
 * File Name:BagCodeUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月25日下午2:40:30
 *
*/

package com.qbt.web.support;
/**
 * ClassName:BagCodeUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:40:30
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.List;

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.web.pojo.bagCode.BagCodeUserVo;

public interface BagCodeUserSupport {
	
	List<BagCodeUserVo> findByPage(BagCodeUserPageReq pageReq);
	
}
