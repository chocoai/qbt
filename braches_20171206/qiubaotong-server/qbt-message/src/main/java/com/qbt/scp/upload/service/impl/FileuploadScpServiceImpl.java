package com.qbt.scp.upload.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.FileUploadUtils;
import com.qbt.common.util.QrCodeUtil;
import com.qbt.common.util.ScpConfig;
import com.qbt.common.util.ScpUtil;
import com.qbt.common.util.ToolsUtil;
import com.qbt.common.util.ZipCompressor;
import com.qbt.scp.upload.service.FileuploadScpService;
import com.qbt.service.CommonService;


@Service
public class FileuploadScpServiceImpl implements FileuploadScpService {
	
	@Value("${scp.host}")
    private String ip;
	
	@Value("${scp.port}")
    private String port;
	
	@Value("${scp.username}")
    private String userName;
	
	@Value("${scp.password}")
    private String passWord;
	
	@Value("${nginx.root.dir}")
	private String nginxPath;
	
	@Value("${local.images.dir}")
	private String localImagesPath;
	
	@Value("${remote.images.dir}")
	private String remoteImagesPath;
	
	@Value("${upload.weixin.url}")
	private String url;
	
	@Value("${local.excel.dir}")
	private String localExcelPath;
	
	@Value("${remote.excel.dir}")
	private String remoteExcelPath;
	
	@Value("${local.qrcode.dir}")
	private String localQrcodePath;
	
	@Value("${remote.qrcode.dir}")
	private String remoteQrcodePath;
	
	@Value("${nginx.root.dir}")
	private String nginxRootDir;
	
	@Resource
	private CommonService commonService;
	
    private ScpConfig getScpConfig() {
        if (!StringUtils.isEmpty(port)) {
            return new ScpConfig(ip, Integer.parseInt(port), userName, passWord);
        } else {
            return new ScpConfig(ip, 0, userName, passWord);
        }
    }
    
    /**
      * @Title: fileDownToScp
      * @Description:微信下载图片到本地，然后远程到scp服务器
      * @author: win10 2016年8月17日
      * @modify: win10 2016年8月17日
      * @param mediaIds
      * @param accessToken
      * @return
     */
    public String[] imageWeixinDownToScp(String[] mediaIds,String accessToken){
    	String[] localFile = new String[mediaIds.length];
    	try{
    		String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
	    	String[] scpFileName = new String[mediaIds.length];
	    	String[] remoteFile = new String[mediaIds.length];
	    	//微信下载图片到本地
	    	for (int i = 0; i < mediaIds.length; i++) {
	    		 String mediaId = mediaIds[i];
	    		 String requestUrl = url.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
	    		 //本地文件名称
	    		 mediaId = ToolsUtil.getUUID() + ".jpg";
	    		 //下载成本地
	    		 FileUploadUtils.downloadFile(requestUrl, mediaId, localImagesPath);
	    		 localFile[i] = localImagesPath + Constants.SLASH + mediaId;
	    		 scpFileName[i] = mediaId;
	    		 remoteFile[i] = remoteImagesPath.replace(nginxPath, "") + Constants.SLASH + dateStr + Constants.SLASH + mediaId; 
			}
	    	String scpPath = remoteImagesPath + Constants.SLASH + dateStr;
	    	//本地到SCP服务器
	    	ScpUtil.uploadFile(localFile,(String[]) scpFileName, scpPath, getScpConfig());
	    	return remoteFile;
    	}catch(Exception ex){
    		LogCvt.error(ex.getMessage(), ex);
    	}finally {
    		 for (String l : localFile) {
                 FileUploadUtils.delFiles(l);
             }
		}
    	return null;
	}
    
    /**
     * 多张图片一次上传scp
     */
    @Override
    public String[] httpImageDownToScp(String[] requestUrls, String dirName, List<String> fileNameList, boolean isZip){
    	String[] localFile = new String[requestUrls.length];
    	String zipName = "";
    	String localZipPath = "";
    	try{
	    	String[] scpFileName = new String[requestUrls.length];
	    	String[] remoteFile = new String[requestUrls.length];
	    	dirName = Checker.isNotEmpty(dirName) ? dirName : DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
	    	if(Checker.isEmpty(fileNameList)){
	    		fileNameList = new ArrayList<String>();
	    		for(int i = 0; i < requestUrls.length; i++){
	    			fileNameList.add(ToolsUtil.getUUID());
	    		}
	    	}
	    	//微信下载图片到本地
	    	String fileName = null;
	    	String localFilePath = localImagesPath + Constants.SLASH + dirName;
	    	for (int i = 0; i < requestUrls.length; i++) {
	    		 String requestUrl = requestUrls[i];
	    		 //本地文件名称
	 			 fileName = fileNameList.get(i)+".jpg";
	    		 //下载成本地
	 			
	    		 FileUploadUtils.downloadFile(requestUrl, fileName, localFilePath);
	    		 localFile[i] = localFilePath + Constants.SLASH + fileName;
	    		 scpFileName[i] = fileName;
	    		 remoteFile[i]=remoteImagesPath.replace(nginxPath, "") + Constants.SLASH + dirName + Constants.SLASH + fileName; 
			}
	    	String scpPath = remoteImagesPath + Constants.SLASH + dirName;
	    	 
	    	//本地到SCP服务器
	    	ScpUtil.uploadFile(localFile,(String[]) scpFileName, scpPath, getScpConfig());
	    	
	    	//将文件夹压缩成zip
	    	if(isZip){
	    		zipName = dirName + ".zip";
	    		localZipPath = localImagesPath + Constants.SLASH + zipName;
	    		ZipCompressor zc = new ZipCompressor(localZipPath);
	    		zc.compress(localFilePath + Constants.SLASH);
	    		
	    		//本地zip到SCP服务器
	    		ScpUtil.uploadFile(localZipPath, zipName, scpPath, getScpConfig());
	    	}
	    	
	    	return remoteFile;
    	}catch(Exception ex){
    		LogCvt.error(ex.getMessage(), ex);
    	}finally {
    		 for (String l : localFile) {
                 FileUploadUtils.delFiles(l);
             }
    		 if(Checker.isNotEmpty(localZipPath)){
    			 FileUploadUtils.delFiles(localZipPath);
    		 }
		}
    	return null;
	}
    
    
    /**
      * @Title: delFile
      * @Description: 删除远程文件
      * @author: win10 2016年8月19日
      * @modify: win10 2016年8月19日
      * @param listFile
     */
    public void delRemoteFile(List<String> listFile){
    	try {
    		if(listFile != null && !listFile.isEmpty()){
    			List<String> newPath = new ArrayList<String>();
    			for(String file : listFile){
    				String newFile = !file.contains(nginxPath) ? nginxPath.concat(file) : file;
    				newPath.add(newFile);
    			}
    			ScpUtil.delFile(newPath, getScpConfig());
    		}
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
    }

	/**
	 * 创建目录
	 * @param dir
	 * @throws FroadBusinessException
	 */
	public void makeDirs(String dir) throws Exception {
		File fileDir = new File(dir);
		if(!fileDir.exists()){
			if(!fileDir.mkdirs()){
				LogCvt.error("创建本地目录失败！");
				throw new Exception("导出失败");
			}
		}
	}
	
	@Override
	public String imageUploadToScp(MultipartFile image) throws Exception {
		if(image == null){
			return null;
		}
		String localFile = null;
		String remoteFile = null;
		String scpFileName = null;
		try {
			String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
			String fileName = image.getOriginalFilename();
			String det = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = ToolsUtil.getUUID() + det;
			//下载图片到本地
			String savePath = localImagesPath + Constants.SLASH + dateStr + Constants.SLASH + newFileName;
			FileUploadUtils.saveFile(savePath, image);
			localFile = savePath;
			scpFileName = newFileName;
			remoteFile = remoteImagesPath.replace(nginxPath, "") + Constants.SLASH + dateStr + Constants.SLASH + newFileName;
			
			String scpPath = remoteImagesPath + Constants.SLASH + dateStr;
	    	//本地到SCP服务器
	    	ScpUtil.uploadFile(localFile, scpFileName, scpPath, getScpConfig());
		} catch (Exception e) {
			LogCvt.error("图片上传失败!", e);
			throw e;
		} finally {
			if(localFile != null){
				FileUploadUtils.delFiles(localFile);
			}
		}
		return remoteFile;
	}

	@Override
	public String createQrcodeToScp(String content) throws Exception {
		String remoteFile = null;
		try {
			String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
			String qrcodeFileName = ToolsUtil.getUUID()+".jpg";
			String savePath = localQrcodePath + Constants.SLASH + dateStr + Constants.SLASH + qrcodeFileName;
			
			QrCodeUtil.generateQrCode(content, savePath);
			
			String scpPath = remoteQrcodePath + Constants.SLASH + dateStr;
			remoteFile = remoteQrcodePath.replace(nginxPath, "") + dateStr + Constants.SLASH + qrcodeFileName;
			
			//本地到SCP服务器
	    	ScpUtil.uploadFile(savePath, qrcodeFileName, scpPath, getScpConfig());
		} catch (Exception e) {
			LogCvt.error("二维码上传失败!", e);
			throw e;
		}
		return remoteFile;
	}
	
	@Override
	public void downloadFile(String scpFileName) throws Exception {
		try {
			ScpUtil.downloadFile(nginxRootDir + scpFileName, localImagesPath, getScpConfig());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public String uploadFile(String localFile, String scpFileName, String scpPath) throws Exception {
		try {
			ScpUtil.uploadFile(localImagesPath + localFile, scpFileName, remoteImagesPath + scpPath, getScpConfig());
			String imageSrc = remoteImagesPath +  scpPath + Constants.SLASH + scpFileName;
			return imageSrc.replace(nginxPath, "");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			throw e;
		}finally {
			FileUploadUtils.delFiles(localImagesPath + localFile);
		}
	}

	@Override
	public String[] httpImageDownToScp(String[] requestUrls) {
		return httpImageDownToScp(requestUrls, null, null, false);
	}

	@Override
	public String[] httpImageDownToScp(String[] requestUrls, boolean isZip) {
		return httpImageDownToScp(requestUrls, null, null, isZip);
	}

	@Override
	public String excelUploadToScp(MultipartFile excel, String newExcelName) throws Exception {
		if(excel == null){
			return null;
		}
		String localFile = null;
		String remoteFile = null;
		String scpFileName = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			String fileName = excel.getOriginalFilename();
			String det = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = (Checker.isNotEmpty(newExcelName) ? newExcelName : fileName.substring(0, fileName.lastIndexOf("."))) + "_" + DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05) + det;
			//下载图片到本地
			String savePath = localExcelPath + Constants.SLASH + format.format(new Date()) + Constants.SLASH + newFileName;
			FileUploadUtils.saveFile(savePath, excel);
			localFile = savePath;
			scpFileName = newFileName;
			remoteFile = remoteExcelPath.replace(nginxPath, "") + Constants.SLASH + format.format(new Date()) + Constants.SLASH + newFileName; 
			
			String scpPath = remoteExcelPath + Constants.SLASH + format.format(new Date());
	    	//本地到SCP服务器
	    	ScpUtil.uploadFile(localFile, scpFileName, scpPath, getScpConfig());
		} catch (Exception e) {
			LogCvt.error("excel文件上传失败!", e);
			throw e;
		} finally {
			if(localFile != null){
				FileUploadUtils.delFiles(localFile);
			}
		}
		return remoteFile;
	}

	@Override
	public String excelDownloadFromScp(String scpFilePath) throws Exception {
		try {
			String localDir = localExcelPath + Constants.SLASH + DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
			String scpFileName = !scpFilePath.contains(nginxPath) ? nginxPath.concat(scpFilePath) : scpFilePath;
			ScpUtil.downloadFile(scpFileName, localDir, getScpConfig());
			String localFilePath = localDir + Constants.SLASH + scpFileName.substring(scpFileName.lastIndexOf(Constants.SLASH) + 1);
			return localFilePath;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			throw e;
		}
	}
	

}
