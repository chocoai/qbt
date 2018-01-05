/**
 * Project Name:qbt-system-web
 * File Name:BagCodeOrderSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月25日下午3:46:06
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.pojo.bagCode.BagCodeOrderPageReq;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BagCodeOrderDto;
import com.qbt.persistent.entity.BagCodeOrder;
import com.qbt.service.BagCodeOrderService;
import com.qbt.web.pojo.bagCode.BagCodeOrderVo;
import com.qbt.web.support.BagCodeOrderSupport;

/**
 * ClassName:BagCodeOrderSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:46:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeOrderSupportImpl implements BagCodeOrderSupport {
	
	@Resource
	private BagCodeOrderService bagCodeOrderService;
	
	@Override
	public List<BagCodeOrderVo> findByPage(BagCodeOrderPageReq pageReq) {
		PageEntity<BagCodeOrderDto> pageEntity = BeanUtil.pageConvert(pageReq, BagCodeOrderDto.class);
		List<BagCodeOrder> list = bagCodeOrderService.findByPage(pageEntity);
		List<BagCodeOrderVo> voList = BeanUtil.list2list(list, BagCodeOrderVo.class);
		pageReq.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
