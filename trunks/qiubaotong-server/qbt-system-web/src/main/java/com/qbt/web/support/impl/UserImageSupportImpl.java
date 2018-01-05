/**
 * Project Name:qbt-system-web
 * File Name:UserImageSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月11日下午2:32:28
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.UserImageService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.userImage.UserImageVo;
import com.qbt.web.support.UserImageSupport;

/**
 * ClassName:UserImageSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 下午2:32:28
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class UserImageSupportImpl implements UserImageSupport {
	
	@Resource
	private UserImageService userImageService;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Resource
	private VipUserService vipUserService;
	
	@Override
	public List<UserImageVo> list(Integer userId, Integer type) {
		List<UserImage> list = userImageService.findByUserId(userId, type);
		List<UserImageVo> voList = BeanUtil.list2list(list, UserImageVo.class);
		return voList;
	}

	@Override
	public int add(UserImageVo vo) {
		// 判断用户球包图片是否超过10张
		if(vo.getType() == 1) {
			List<UserImage> imgList = userImageService.findByUserId(vo.getUserId(), vo.getType());
			if(imgList.size() == 10){
				throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "球包图片最多10张");
			}
		}
		
		UserImage image = BeanUtil.a2b(vo, UserImage.class);
		return userImageService.insert(image);
	}

	@Override
	public boolean delete(List<Integer> ids) {
		// 查询原图片信息
		List<UserImage> imgList = userImageService.findByIds(ids);
		// 批量删除图片
		int result = userImageService.deleteByIds(ids);
		if(result > 0){
			List<VipInfo> userList = vipUserService.findByImageIds(ids);
			List<Integer> userImgIdList = new ArrayList<Integer>();
			for(VipInfo info : userList){
				userImgIdList.add(info.getUserImgId());
			}
			
			List<String> listFile = new ArrayList<String>();
			for(UserImage i : imgList){
				if(Checker.isNotEmpty(userImgIdList) && userImgIdList.contains(i.getId())){
					continue;
				}
				listFile.add(i.getImageUrl());
			}
			// 删除远程图片
			fileuploadScpService.delRemoteFile(listFile);
		}
		return result > 0;
	}

}
