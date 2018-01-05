/**
 * Project Name:qbt-persistent
 * File Name:ChannelQrcodeDataSearch.java
 * Package Name:com.qbt.aop.impl
 * Date:2017年7月13日上午10:48:26
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
import com.qbt.service.ChannelQrcodeInfoService;

/**
 * ClassName:ChannelQrcodeDataSearch
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午10:48:26
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("channelQrcodeCodeDataSearch")
public class ChannelQrcodeCodeDataSearch implements DataColletionSearch {
	
	@Resource
	private  ChannelQrcodeInfoService channelQrcodeInfoService;
	
	@Override
	public Set<String> searchData(Object... args) {
		List<String> codeList = channelQrcodeInfoService.findAllChannelQrcodeCode();
		Set<String> data = new HashSet<String>();
		if(Checker.isNotEmpty(codeList)) {
			data.addAll(codeList);
		}
		return data;
	}

}
