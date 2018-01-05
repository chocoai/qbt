package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qbt.common.util.FileCheckUtil;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.web.support.CommonSupport;

@Service
public class CommonSupportImpl implements CommonSupport {

	@Resource
	private FileuploadScpService fileuploadScpService;
	
	@Override
	public String imageUpload(MultipartFile image) throws Exception {
		//图片格式检查
		FileCheckUtil.checkImage(image);
		return fileuploadScpService.imageUploadToScp(image);
	}

	@Override
	public String excelUpload(MultipartFile excel) throws Exception {
		FileCheckUtil.checkExcel(excel);
		return fileuploadScpService.excelUploadToScp(excel, "excel_import");
	}

}
