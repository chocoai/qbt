package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.OrderComment;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.OrderCommentService;
import com.qbt.web.pojo.comment.CommentPageReqVo;
import com.qbt.web.pojo.comment.OrderCommentVo;
import com.qbt.web.support.OrderCommentSupport;

@Service
public class OrderCommentSupportImpl implements OrderCommentSupport {
	
	@Resource
	private OrderCommentService orderCommentService;
	
	@Override
	public List<OrderCommentVo> findByPage(CommentPageReqVo reqVo) {
		PageEntity<OrderComment> pageEntity = BeanUtil.pageConvert(reqVo, OrderComment.class);
		List<OrderComment> list = orderCommentService.findByPage(pageEntity);
		List<OrderCommentVo> voList = BeanUtil.list2list(list, OrderCommentVo.class);
		if(Checker.isNotEmpty(list)){
			for(int i = 0; i < list.size(); i++){
				OrderComment c = list.get(i);
				OrderCommentVo vo = voList.get(i);
				List<String> imgUrls = new ArrayList<String>();
				if(Checker.isNotEmpty(c.getUrl1())){
					imgUrls.add(c.getUrl1());
				}
				if(Checker.isNotEmpty(c.getUrl2())){
					imgUrls.add(c.getUrl2());
				}
				if(Checker.isNotEmpty(c.getUrl3())){
					imgUrls.add(c.getUrl3());
				}
				vo.setImgUrls(imgUrls);
			}
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public boolean updateComment(SysUser sysUser, OrderCommentVo vo) {
		OrderComment comment = new OrderComment();
		comment.setId(vo.getId());
		comment.setStatus(vo.getStatus());
		comment.setSysUserId(sysUser.getId());
		comment.setSysUserName(sysUser.getName());
		comment.setMemo(vo.getMemo());
		return orderCommentService.updateById(comment) > 0;
	}
	
}
