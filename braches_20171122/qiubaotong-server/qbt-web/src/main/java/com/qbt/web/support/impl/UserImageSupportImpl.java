/**
 * Project Name:qbt-web
 * File Name:UserImageSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年1月11日上午11:31:02
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.UserImage;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.UserImageService;
import com.qbt.service.VipUserService;
import com.qbt.web.pojo.userImage.UserImageDeleteRequest;
import com.qbt.web.pojo.userImage.UserImageVo;
import com.qbt.web.support.UserImageSupport;

/**
 * ClassName:UserImageSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:31:02
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
	private WechatCommonSupport commonSupport;
	
	@Resource
	private VipUserService vipUserService;
	
	@Override
	public UserImageVo add(Integer userId, String pic, Integer type) {
		// 判断用户球包图片是否超过10张
		if(type == 1) {
			List<UserImage> imgList = userImageService.findByUserId(userId, type);
			if(imgList.size() == 10){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "球包图片最多10张");
			}
		}
		
		String accessToken = commonSupport.getAccessToken();
		String[] removeUrl = fileuploadScpService.imageWeixinDownToScp(new String[]{pic}, accessToken);
		
		UserImage image = new UserImage();
		image.setUserId(userId);
		image.setImageUrl(removeUrl[0]);
		image.setType(type);
		userImageService.insert(image);
		
		UserImageVo vo = BeanUtil.a2b(image, UserImageVo.class);
		return vo;
	}

	@Override
	public List<UserImageVo> list(Integer userId, Integer type) {
		List<UserImage> list = userImageService.findByUserId(userId, type);
		List<UserImageVo> voList = BeanUtil.list2list(list, UserImageVo.class);
		return voList;
	}

	@Override
	public boolean delete(UserImageDeleteRequest req) {
		// 查询原图片信息
		List<UserImage> imgList = userImageService.findByIds(req.getIds());
		// 批量删除图片
		int result = userImageService.deleteByIds(req.getIds());
		if(result > 0){
			List<VipInfo> userList = vipUserService.findByImageIds(req.getIds());
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
