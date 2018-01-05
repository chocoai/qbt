/**
 * Project Name:qbt-report
 * File Name:OrderCostItemSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年1月19日下午5:11:53
 *
*/

package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderCostItem.ReportCostItemRequest;
import com.qbt.web.pojo.orderCostItem.ReportCostItemVo;

/**
 * ClassName:OrderCostItemSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午5:11:53
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderCostItemSupport {
	
	/**
	 * 订单增减项目明细报表导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, ReportCostItemRequest req);
	
	/**
	 * 订单增减项目明细报表分页查询
	 * @param req
	 * @return
	 */
	public List<ReportCostItemVo> findByPage(ReportCostItemRequest req);
	
	
}
