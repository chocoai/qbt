/**
 * Project Name:qbt-system-web
 * File Name:SaleUserSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年2月7日下午7:49:57
 *
*/

package com.qbt.web.support.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.dto.SaleUserDto;
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.SaleQrcodeCreateInfo;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.redis.RedisService;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.scp.upload.service.ImageService;
import com.qbt.service.ActivityService;
import com.qbt.service.SaleOrderInfoService;
import com.qbt.service.SaleQrcodeCreateInfoService;
import com.qbt.service.SaleQrcodeInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.service.SaleWeixinSubcripbeInfoService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleAbleInfo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleReq;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleAbleInfo;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleReq;
import com.qbt.web.pojo.saleUser.SaleUserPageReqVo;
import com.qbt.web.pojo.saleUser.SaleUserUpdateBatch;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.support.SaleUserSupport;
import com.qbt.wechat.api.WechatApi;

/**
 * ClassName:SaleUserSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午7:49:57
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SaleUserSupportImpl implements SaleUserSupport {
	
	@Resource
	private ImageService composeImageService;
	
	
	@Resource
	private SaleUserService saleUserService;
	
	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Resource
	private SaleQrcodeCreateInfoService saleQrcodeCreateInfoService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private SaleOrderInfoService saleOrderInfoService;
	
	@Resource
	private SaleWeixinSubcripbeInfoService saleWeixinSubcripbeInfoService;
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Resource
	private ActivityService activityService;
	
	@Override
	public List<SaleUserVo> findByPage(SaleUserPageReqVo reqVo) {
		PageEntity<SaleUserDto> pageEntity = BeanUtil.pageConvert(reqVo, SaleUserDto.class);
		List<SaleUserDto> list = saleUserService.findByPage(pageEntity);
		List<SaleUserVo> voList = BeanUtil.list2list(list, SaleUserVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public SaleUserVo detail(Integer id) {
		SaleUser saleUser = saleUserService.findById(id);
		SaleUserVo saleUserVo = BeanUtil.a2b(saleUser, SaleUserVo.class);
		if(Checker.isNotEmpty(saleUser)){
			UserWeixin user = userWeixinService.findById(saleUser.getUserId());
			saleUserVo.setNickname(Checker.isNotEmpty(user) ? user.getNickname() : "");
			
			SaleQrcodeInfo qrcodeInfo = saleQrcodeInfoService.findByCode(saleUser.getSalesmanCode());
			saleUserVo.setQrcodeCreateInfoName(Checker.isNotEmpty(qrcodeInfo) ? qrcodeInfo.getQrcodeCreateInfoName() : "");
			
			Activity activity = activityService.findById(saleUser.getActivityId());
			saleUserVo.setActivityName(Checker.isNotEmpty(activity) ? activity.getName() : "");
			saleUserVo.setActivityType(Checker.isNotEmpty(activity) ? activity.getType() : null);
			saleUserVo.setCouponLimitDay(Checker.isNotEmpty(activity) ? activity.getCouponLimitDay() : 0);
		}
		return saleUserVo;
	}

	@Override
	public boolean update(SaleUserVo vo) {
		SaleUser saleUser = BeanUtil.a2b(vo, SaleUser.class);
		SaleUser saleUserTemp = saleUserService.findById(vo.getId());
		if(saleUserTemp.getApplyStatus() == 2){
			if(!vo.getName().equals(saleUserTemp.getName())){
				SaleQrcodeInfo saleQrcodeInfo = saleQrcodeInfoService.findByCode(saleUserTemp.getSalesmanCode());
				//合成二维码
				//销售二维码
				try {
					fileuploadScpService.downloadFile(saleQrcodeInfo.getQrcode());
				} catch (Exception e) {
					throw new BusinessException("下载文件失败");
				}
				//二维码壳模板
				String fileName = saleUserTemp.getSalesmanCode() + ".jpg";
				String finalFileName = saleUserTemp.getSalesmanCode() + "bg.jpg";
				//合成
				composeImageService.composeImage(fileName, finalFileName, saleUser.getName(), saleUserTemp.getSalesmanCode());
				
				//上传到scp
				String imageurl = null;
				try {
					imageurl = fileuploadScpService.uploadFile(finalFileName, finalFileName, "qrcode_" + saleQrcodeInfo.getQrcodeCreateInfoId());
				} catch (Exception e) {
					throw new BusinessException("上传文件失败");
				}
				
				//更新数据库图片url的值
				if(Checker.isNotEmpty(imageurl)){
					saleUser.setQrcode(imageurl);
				}
		}
		}
		return saleUserService.updateForBoss(saleUser) > 0;
	}

	@Override
	public boolean updateStatus(SaleUserVo vo) {
		SaleUser saleUser = saleUserService.findById(vo.getId());
		if(Checker.isEmpty(saleUser)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效销售人员信息");
		}
		SaleUser edit = new SaleUser();
		edit.setId(saleUser.getId());
		edit.setStatus(vo.getStatus());
		edit.setStatusTime(new Date());
		return saleUserService.updateById(edit) > 0;
	}

	@Override
	public boolean audit(SaleUserVo vo, SysUser sysUser) {
		/**
		 * 当"审核状态"为"待审核"时，"审核状态"可以变更为"审核通过/ 审核不通过"；
		 * 当"审核状态"为"审核通过"时，"审核状态"不能再变更；
		 * 当"审核状态"为"审核不通过"时，"审核状态"可以变更为"待审核/审核通过"；
		 * 当"审核状态"更新为"审核通过"时，"有效状态"更新为"有效"，点击可切换；
		 * 当"审核状态"更新为"审核不通过"时，"有效状态"一定为"无效"；
		 */
		SaleUser saleUser = saleUserService.findById(vo.getId());
		if(Checker.isEmpty(saleUser)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效销售人员信息");
		}
		if(saleUser.getApplyStatus() == 2){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "审核已通过，不能重复审核");
		}
		saleUser.setApplyStatus(vo.getApplyStatus());
		SaleQrcodeInfo qrcodeInfo = null;
		if(vo.getApplyStatus() == 3){
			saleUser.setStatus(2);
			saleUser.setStatusTime(new Date());
		}else if(vo.getApplyStatus() == 2){
			saleUser.setStatus(1);
			saleUser.setStatusTime(new Date());
			
			//如果销售人员号为空, 则从队列中取一条销售人员号填充
			if(Checker.isEmpty(saleUser.getSalesmanCode())){
				qrcodeInfo = getSysQrcode(saleUser.getUserId());
				saleUser.setSalesmanCode(qrcodeInfo.getSalesmanCode());
				saleUser.setQrcode(qrcodeInfo.getQrcode());
//				saleUser.setType(qrcodeInfo.getType());
//				saleUser.setTypeValue(qrcodeInfo.getTypeValue());
//				saleUser.setSubscribeValue(qrcodeInfo.getSubscribeValue());
//				saleUser.setFirstType(qrcodeInfo.getFirstType());
//				saleUser.setFirstTypeValue(qrcodeInfo.getFirstTypeValue());
//				saleUser.setOrderDayType(qrcodeInfo.getOrderDayType());
//				saleUser.setOrderDayValue(qrcodeInfo.getOrderDayValue());
			}
			
			//合成二维码
			//销售二维码
			try {
				fileuploadScpService.downloadFile(saleUser.getQrcode());
			} catch (Exception e) {
				throw new BusinessException("下载文件失败");
			}
			//二维码壳模板
			String fileName = saleUser.getSalesmanCode() + ".jpg";
			String finalFileName = saleUser.getSalesmanCode() + "bg.jpg";
			//合成
			composeImageService.composeImage(fileName, finalFileName, saleUser.getName(), saleUser.getSalesmanCode());
			//上传到scp
			String imageurl = null;
			try {          
				imageurl = fileuploadScpService.uploadFile(finalFileName, finalFileName, "qrcode_" +qrcodeInfo.getQrcodeCreateInfoId());
			} catch (Exception e) {
				throw new BusinessException("上传文件失败");
			}
			
			//更新数据库图片url的值
			if(Checker.isNotEmpty(imageurl)){
				saleUser.setQrcode(imageurl);
			}
			
		}
		saleUser.setSysUserId(sysUser.getId());
		saleUser.setSysUserName(sysUser.getName());
		saleUser.setSysUserMobile(sysUser.getMobile());
		saleUser.setApplyTime(new Date());
		int result = saleUserService.updateById(saleUser);
		
		//审核成功,更新二维码记录申请状态,二维码生成记录申请数量
		if(saleUser.getApplyStatus() == 2){
			if(Checker.isEmpty(qrcodeInfo)){
				qrcodeInfo = saleQrcodeInfoService.findByCode(saleUser.getSalesmanCode());
			}
			qrcodeInfo.setId(qrcodeInfo.getId());
			qrcodeInfo.setApplyStatus(1);//0-未申请 1-已申请
			saleQrcodeInfoService.updateById(qrcodeInfo);
			
			SaleQrcodeCreateInfo createInfo = saleQrcodeCreateInfoService.findById(qrcodeInfo.getQrcodeCreateInfoId());
			createInfo.setId(createInfo.getId());
			createInfo.setApplyNumber(createInfo.getApplyNumber() + 1);
			saleQrcodeCreateInfoService.updateById(createInfo);
		}
		
		//审核成功/失败 发微信通知用户
		if(saleUser.getApplyStatus() == 2 || saleUser.getApplyStatus() == 3){
			UserWeixin userWeixin = userWeixinService.findById(saleUser.getUserId());
			wechatMessageSupport.saleUserApplyNotify(saleUser, userWeixin.getOpenid());
		}
		
		return result > 0;
	}
	
	@Override
	public boolean updateBatch(SaleUserUpdateBatch batch) {
		SaleUserDto dto = BeanUtil.a2b(batch, SaleUserDto.class);
		if(Checker.isNotEmpty(dto.getStatus())){
			dto.setStatusTime(new Date());
		}
		return saleUserService.udpateBatch(dto) > 0;
	}

	@Override
	public SaleOrderSettleAbleInfo saleOrderSettleInfo(SaleOrderSettleReq req) {
		SaleOrderInfoDto dto = BeanUtil.a2b(req, SaleOrderInfoDto.class);
		SaleOrderInfoDto info = saleOrderInfoService.settleAbleInfo(dto);
		SaleOrderSettleAbleInfo ableInfo = BeanUtil.a2b(info, SaleOrderSettleAbleInfo.class);
		return ableInfo;
	}

	@Override
	public boolean settleSaleOrder(SaleOrderSettleReq req, SysUser sysUser) {
		SaleOrderInfoDto dto = BeanUtil.a2b(req, SaleOrderInfoDto.class);
		dto.setSysUserId(sysUser.getId());
		dto.setSysUserName(sysUser.getName());
		int result = saleOrderInfoService.settleOrder(dto);
		return result > 0;
	}

	@Override
	public SaleSubcripbeSettleAbleInfo saleSubcripbeSettleInfo(SaleSubcripbeSettleReq req) {
		SaleWeixinSubcripbeInfoDto dto = BeanUtil.a2b(req, SaleWeixinSubcripbeInfoDto.class);
		SaleWeixinSubcripbeInfoDto info = saleWeixinSubcripbeInfoService.settleAbleInfo(dto);
		SaleSubcripbeSettleAbleInfo ableInfo = BeanUtil.a2b(info, SaleSubcripbeSettleAbleInfo.class);
		return ableInfo;
	}

	@Override
	public boolean settleSubcripbe(SaleSubcripbeSettleReq req, SysUser sysUser) {
		SaleWeixinSubcripbeInfoDto dto = BeanUtil.a2b(req, SaleWeixinSubcripbeInfoDto.class);
		dto.setSysUserId(sysUser.getId());
		dto.setSysUserName(sysUser.getName());
		int result = saleWeixinSubcripbeInfoService.settleOrder(dto);
		return result > 0;
	}
	
	/**
	 * 
	 * getSysQrcode:(获取系统生成二维码信息).
	 *
	 * @author huangyihao
	 * 2017年3月14日 下午4:20:09
	 * @param userId
	 * @return
	 *
	 */
	private SaleQrcodeInfo getSysQrcode(Integer userId){
		SaleQrcodeInfo qrcodeInfo = null;
		String salesmanCode = saleQrcodeInfoService.getSysSalemanCode();
		if(Checker.isEmpty(salesmanCode)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "系统生成二维码批次已被全部申请, 请重新生成二维码");
		}
		qrcodeInfo = saleQrcodeInfoService.findByCode(salesmanCode);
		if(Checker.isEmpty(qrcodeInfo)){
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效二维码");
		}
		if(qrcodeInfo.getApplyStatus() == 1){
			getSysQrcode(userId);
		}
		int count = saleUserService.existCode(userId, salesmanCode);
		if(count > 0){
			getSysQrcode(userId);
		}
		return qrcodeInfo;
	}
	
}
