/**
 * Project Name:qbt-report
 * File Name:BagCodeUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月25日下午2:55:57
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.BagCodeUserDto;
import com.qbt.persistent.entity.BagCodeUser;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.BagCodeUserService;
import com.qbt.web.support.BagCodeUserSupport;

/**
 * ClassName:BagCodeUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:55:57
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeUserSupportImpl implements BagCodeUserSupport {
	
	@Resource
	private BagCodeUserService bagCodeUserService;
	
	@Override
	public Map<String, Object> export(BagCodeUserPageReq pageReq, String title, SysUser sysUser) {
		PageEntity<BagCodeUserDto> pageEntity = BeanUtil.pageConvert(pageReq, BagCodeUserDto.class);
		pageEntity.setPageSize(PageEntity.MAX_PAGE_SIZE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("startTime", DateUtil.formatDate(pageReq.getStartTime(), DateUtil.DATE_FORMAT_02));
		map.put("endTime", DateUtil.formatDate(pageReq.getEndTime(), DateUtil.DATE_FORMAT_02));
		map.put("keyword", pageReq.getKeyword());
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		
		int pageNo = 0;
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			
			List<BagCodeUser> list = bagCodeUserService.findByPage(pageEntity);
			Map<String, String> data = null;
			for(BagCodeUser user : list) {
				data = new HashMap<String, String>();
				data.put("bagCodePartnerName", user.getBagCodePartnerName());
				data.put("bagCode", user.getBagCode());
				data.put("nickname", user.getNickname());
				data.put("name", user.getName());
				data.put("mobile", user.getMobile());
				data.put("activityName", user.getActivityName());
				data.put("createTime", DateUtil.formatDate(user.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
				listMap.add(data);
			}
			
		} while (pageNo < pageEntity.getPageCount());
		
		map.put("list", listMap);
		return map;
	}

}
