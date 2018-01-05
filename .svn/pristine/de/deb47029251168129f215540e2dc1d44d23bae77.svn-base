/**
 * Project Name:qbt-system-web
 * File Name:BagCodeUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月25日下午2:41:31
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.bagCode.BagCodeUserPageReq;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BagCodeUserDto;
import com.qbt.persistent.entity.BagCodeUser;
import com.qbt.service.BagCodeUserService;
import com.qbt.web.pojo.bagCode.BagCodeUserVo;
import com.qbt.web.support.BagCodeUserSupport;

/**
 * ClassName:BagCodeUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:41:31
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeUserSupportImpl implements BagCodeUserSupport {
	
	@Resource
	private BagCodeUserService bagCodeUserService;
	
	@Override
	public List<BagCodeUserVo> findByPage(BagCodeUserPageReq pageReq) {
		PageEntity<BagCodeUserDto> pageEntity = BeanUtil.pageConvert(pageReq, BagCodeUserDto.class);
		List<BagCodeUser> list = bagCodeUserService.findByPage(pageEntity);
		List<BagCodeUserVo> voList = BeanUtil.list2list(list, BagCodeUserVo.class);
		pageReq.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
