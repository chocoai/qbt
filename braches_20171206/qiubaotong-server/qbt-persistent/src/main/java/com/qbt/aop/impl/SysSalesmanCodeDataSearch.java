/**
 * Project Name:qbt-persistent
 * File Name:SysSalesmanCodeDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日上午11:35:41
 *
*/

package com.qbt.aop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.aop.DataColletionSearch;
import com.qbt.service.SaleQrcodeInfoService;

/**
 * ClassName:SysSalesmanCodeDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午11:35:41
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("sysSalesmanCodeDataSearch")
public class SysSalesmanCodeDataSearch implements DataColletionSearch {
	
	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Override
	public List<String> searchData(Object... args) {
		return saleQrcodeInfoService.findNoApplySalesmanCode();
	}

}
