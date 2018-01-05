/**
 * Project Name:qbt-persistent
 * File Name:VipNoDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日上午10:41:39
 *
*/

package com.qbt.aop.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.aop.DataColletionSearch;
import com.qbt.common.util.Checker;
import com.qbt.service.VipCreateInfoService;
import com.qbt.service.VipUserService;

/**
 * ClassName:VipNoDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午10:41:39
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("vipNoDataSearch")
public class VipNoDataSearch implements DataColletionSearch {
	
	@Resource
	private VipUserService vipUserService;
	
	@Resource
	private VipCreateInfoService vipCreateInfoService;
	
	@Override
	public Set<String> searchData(Object... args) {
		Set<String> data = new HashSet<String>();
		List<String> vipNoList1 = vipUserService.findAllVipNo();
		if(Checker.isNotEmpty(vipNoList1)) {
			data.addAll(vipNoList1);
		}
		List<String> vipNoList2 = vipCreateInfoService.findAllVipNo();
		if(Checker.isNotEmpty(vipNoList2)) {
			data.addAll(vipNoList2);
		}
		return data;
	}
	
}
