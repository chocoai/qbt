package com.qbt.common.util;

import org.springframework.web.multipart.MultipartFile;

import com.qbt.common.exception.BusinessException;

public class FileCheckUtil {
	
	/**
	 * 图片检查
	 * @tilte checkImage
	 * @author zxl
	 * @date 2015年12月8日 上午10:13:28
	 */
	public static void checkImage(MultipartFile img) {
		String[] type = {"jpg","jpeg","bmp","png"};
		if(img != null && img.getOriginalFilename().indexOf(".")>0){
			String det = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
			for(String t : type){
				if(t.equals(det)){
					return;
				}
			}
			throw new BusinessException("只允许上传JPG,JPEG,PNG,BMP格式图片!");
		}else{
			throw new BusinessException("图片格式不正确!");
		}
	}
	
	public static void checkExcel(MultipartFile excel){
		String[] type = {"xlsx","xls"};
		if(excel != null && excel.getOriginalFilename().indexOf(".")>0){
			String det = excel.getOriginalFilename().substring(excel.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
			for(String t : type){
				if(t.equals(det)){
					return;
				}
			}
			throw new BusinessException("只允许上传xls,xlsx格式文件!");
		}else{
			throw new BusinessException("文件格式不正确!");
		}
	}
	
}
