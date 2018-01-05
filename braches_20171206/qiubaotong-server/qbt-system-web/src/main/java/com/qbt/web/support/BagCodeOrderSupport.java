/**
 * Project Name:qbt-system-web
 * File Name:BagCodeOrder.java
 * Package Name:com.qbt.web.support
 * Date:2017年8月25日下午3:41:43
 *
*/

package com.qbt.web.support;
/**
 * ClassName:BagCodeOrder
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:41:43
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.List;

import com.qbt.bussiness.pojo.bagCode.BagCodeOrderPageReq;
import com.qbt.web.pojo.bagCode.BagCodeOrderVo;

public interface BagCodeOrderSupport {
	
	List<BagCodeOrderVo> findByPage(BagCodeOrderPageReq pageReq);
	
}
