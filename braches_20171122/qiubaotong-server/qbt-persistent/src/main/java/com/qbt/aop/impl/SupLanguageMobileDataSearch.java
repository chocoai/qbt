/**
 * Project Name:qbt-persistent
 * File Name:SupLanguageMobileDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日下午3:09:07
 *
*/

package com.qbt.aop.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.aop.DataColletionSearch;
import com.qbt.service.SupLanguageMobileService;

/**
 * ClassName:SupLanguageMobileDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 下午3:09:07
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("supLanguageMobileDataSearch")
public class SupLanguageMobileDataSearch implements DataColletionSearch {
	
	@Resource
	private SupLanguageMobileService supLanguageMobileService;
	
	@Override
	public Set<String> searchData(Object... args) {
		return new HashSet<String>(supLanguageMobileService.findAllMobile());
	}

}
