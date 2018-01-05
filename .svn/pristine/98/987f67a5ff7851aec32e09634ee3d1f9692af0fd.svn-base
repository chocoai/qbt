/**
 * Project Name:qbt-web
 * File Name:SaleUserSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月7日下午2:29:12
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.saleUser.SaleUserApplyVo;
import com.qbt.web.pojo.saleUser.SaleUserOrderRequest;
import com.qbt.web.pojo.saleUser.SaleUserOrderVo;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeRequest;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeVo;
import com.qbt.web.pojo.saleUser.SaleUserVo;

/**
 * ClassName:SaleUserSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午2:29:12
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface SaleUserSupport {
	
	public SaleUserVo detail(Integer userId);
	
	public boolean apply(UserWeixin userWeixin, SaleUserApplyVo applyVo);
	
	public String codeCompany(String salesmanCode);
	
	public List<SaleUserOrderVo> orderList(UserWeixin userWeixin, SaleUserOrderRequest req);
	
	public List<SaleUserSubcripbeVo> subcripbeList(UserWeixin userWeixin, SaleUserSubcripbeRequest req);
}
