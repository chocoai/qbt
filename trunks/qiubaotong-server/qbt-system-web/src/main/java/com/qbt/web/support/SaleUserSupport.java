/**
 * Project Name:qbt-system-web
 * File Name:SaleUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月7日下午7:08:09
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleAbleInfo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleReq;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleAbleInfo;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleReq;
import com.qbt.web.pojo.saleUser.SaleUserPageReqVo;
import com.qbt.web.pojo.saleUser.SaleUserUpdateBatch;
import com.qbt.web.pojo.saleUser.SaleUserVo;

/**
 * ClassName:SaleUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午7:08:09
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SaleUserSupport {
	
	public List<SaleUserVo> findByPage(SaleUserPageReqVo reqVo);
	
	public SaleUserVo detail(Integer id);
	
	public boolean update(SaleUserVo vo);
	
	public boolean updateStatus(SaleUserVo vo);
	
	public boolean audit(SaleUserVo vo, SysUser sysUser);
	
	public boolean updateBatch(SaleUserUpdateBatch batch);
	
	public SaleOrderSettleAbleInfo saleOrderSettleInfo(SaleOrderSettleReq req);
	
	public boolean settleSaleOrder(SaleOrderSettleReq req, SysUser sysUser);
	
	public SaleSubcripbeSettleAbleInfo saleSubcripbeSettleInfo(SaleSubcripbeSettleReq req);
	
	public boolean settleSubcripbe(SaleSubcripbeSettleReq req, SysUser sysUser);
}
