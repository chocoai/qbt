package com.qbt.scp.upload.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface FileuploadScpService {
	
	public String[] imageWeixinDownToScp(String[] mediaIds,String accessToken);
	
	public String[] httpImageDownToScp(String[] requestUrls, String dirName, List<String> fileNameList, boolean isZip);
	 
	public void delRemoteFile(List<String> listFile);
	
	/**
	 * 图片上传到scp
	 * @param image
	 * @return
	 */
	public String imageUploadToScp(MultipartFile image) throws Exception;
	
	/**
	 * 
	 * createQrcodeToScp:(本地生成二维码, 上传至scp服务器).
	 *
	 * @author huangyihao
	 * 2017年2月21日 上午11:02:05
	 * @param content
	 * @return
	 *
	 */
	public String createQrcodeToScp(String content) throws Exception;
	
	/**
	 * scp下载文件
	 * @param scpFileName
	 * @throws Exception
	 */
	public void downloadFile(String scpFileName) throws Exception;

	/**
	 * scp上传文件
	 * @param localFile
	 * @param scpFileName
	 * @param scpPath
	 * @throws Exception
	 */
	public String uploadFile(String localFile, String scpFileName, String scpPath) throws Exception;
	
	/**
	 * 
	 * httpImageDownToScp:(从http下载图片到文件服务器).
	 *
	 * @author huangyihao
	 * 2017年3月16日 下午2:51:10
	 * @param requestUrls
	 * @return
	 *
	 */
	public String[] httpImageDownToScp(String[] requestUrls, boolean isZip);
	
	/**
	 * 
	 * httpImageDownToScp:(从http下载图片到文件服务器).
	 *
	 * @author huangyihao
	 * 2017年3月16日 下午2:51:10
	 * @param requestUrls
	 * @return
	 *
	 */
	public String[] httpImageDownToScp(String[] requestUrls);
	
	/**
	 * 
	 * excelUploadToScp:(上传excel文件到文件服务器).
	 *
	 * @author huangyihao
	 * 2016年11月24日 上午9:54:19
	 * @param excel
	 * @param newExcelName
	 * @return 文件远程scp路径
	 * @throws Exception
	 *
	 */
	public String excelUploadToScp(MultipartFile excel, String newExcelName) throws Exception;
	
	/**
	 * 
	 * excelDownloadFromScp:(下载excel文件到本地).
	 *
	 * @author huangyihao
	 * 2016年11月30日 下午3:52:53
	 * @param scpFilePath
	 * @return
	 *
	 */
	public String excelDownloadFromScp(String scpFilePath) throws Exception;
}
