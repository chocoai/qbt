package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.SaleQrcodeInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.scp.upload.service.ImageService;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.SaleQrcodeInfoService;
import com.qbt.service.SaleUserService;
import com.qbt.timer.TimerService;

/**
 * 销售二维码合成
 * @author wuwang
 *
 */
@Service("saleUserQrcodeComposeImageService")
public class SaleUserQrcodeComposeImageServiceImpl extends TimerService {

	@Resource
	private ImageService composeImageService;
	
	@Resource
	private SaleUserService saleUserService;
	
	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Resource
	private SaleQrcodeInfoService saleQrcodeInfoService;
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		List<SaleUser> saleUserList = saleUserService.listByApplyStatus(2);
		//二维码壳模板
		for (SaleUser saleUser : saleUserList) {
			SaleQrcodeInfo saleQrcodeInfo = saleQrcodeInfoService.findByCode(saleUser.getSalesmanCode());
			try {
				fileuploadScpService.downloadFile(saleQrcodeInfo.getQrcode());
			} catch (Exception e) {
				throw new BusinessException("下载文件失败");
			}
			
			String finalFileName = saleUser.getSalesmanCode() + "bg.jpg";
			String fileName = saleUser.getSalesmanCode() + ".jpg";
			//合成
			composeImageService.composeImage(fileName, finalFileName, saleUser.getName(), saleUser.getSalesmanCode());
			
			String imageurl = null;
			try {
				imageurl = fileuploadScpService.uploadFile(finalFileName, finalFileName, "qrcode_" +saleQrcodeInfo.getQrcodeCreateInfoId());
			} catch (Exception e) {
				throw new BusinessException("上传文件失败");
			}
			
			SaleUser saleUser1 = new SaleUser();
			saleUser1.setId(saleUser.getId());
			//更新数据库图片url的值
			if(Checker.isNotEmpty(imageurl)){
				saleUser1.setQrcode(imageurl);
				saleUserService.updateForBoss(saleUser1);
			}
			
		}
		
	}

}
