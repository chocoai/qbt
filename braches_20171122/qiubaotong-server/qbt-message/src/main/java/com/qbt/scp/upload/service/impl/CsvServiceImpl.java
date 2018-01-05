/**
 * Project Name:qbt-message
 * File Name:CsvServiceImpl.java
 * Package Name:com.qbt.scp.upload.service.impl
 * Date:2017年3月16日上午9:44:48
 *
*/

package com.qbt.scp.upload.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.csvreader.CsvWriter;
import com.qbt.common.excel.ExcelConstants;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.FileUploadUtils;
import com.qbt.common.util.ScpConfig;
import com.qbt.common.util.ScpUtil;
import com.qbt.scp.upload.service.CsvService;

/**
 * ClassName:CsvServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月16日 上午9:44:48
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class CsvServiceImpl implements CsvService {
	
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
	
	@Value("${local.excel.dir}")
	private String localExcelPath;
	
	@Value("${remote.excel.dir}")
	private String remoteExcelPath;
	
	/**
	 * 是否需创建文件夹
	 */
	private boolean isNeedCreateFolder = true;
	
	/**
	 * 当前操作的csv文件名
	 */
	private String currentExcelName;
	
	/**
	 * 当前操作的excel文件名
	 */
	private String currentExcelPath;
	
	/**
	 * 多个excel时，文件夹名
	 */
	private String folderName;
	
	/**
	 * 当前row写入序号
	 */
	private long rowIndex = 0;
	
	/**
	 * 当前操作唯一ID
	 */
	private long writerID = 0;
	
	private ScpConfig getScpConfig() {
        if (!StringUtils.isEmpty(port)) {
            return new ScpConfig(ip, Integer.parseInt(port), userName, passWord);
        } else {
            return new ScpConfig(ip, 0, userName, passWord);
        }
    }
	
	@Override
	public String uploadCsv() throws Exception {
		String url = "";
		String csvFilePath = null;
		try {
			String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_YYYYMMDD);
			csvFilePath = this.currentExcelPath + Constants.SLASH + this.currentExcelName;
			String scpPath = remoteExcelPath + dateStr;
			ScpUtil.uploadFile(csvFilePath, currentExcelName, scpPath, getScpConfig());
			url = scpPath.replace(nginxPath, "") + Constants.SLASH + currentExcelName;
			
			this.writerID = 0;
			this.rowIndex = 0;
			this.isNeedCreateFolder = true;
		} catch (Exception e) {
			LogCvt.error("上传csv文件失败");
			throw e;
		} finally {
			FileUploadUtils.delFiles(csvFilePath);
		}
		return url;
	}

	@Override
	public void writeCsv(List<String> header, List<List<String>> data, String csvFileName) throws Exception {
		writeCsv(header, data, csvFileName, ',', null);
	}

	@Override
	public void writeCsv(List<String> header, List<List<String>> data, String csvFileName, char separator,
			Charset charset) throws Exception {
		if(charset == null){
			charset = Charset.forName("gbk");
		}
		
		//初始化
		if(this.writerID == 0){
			this.writerID = ExcelConstants.getUniqueId();
			this.folderName = String.valueOf(this.writerID);
			this.currentExcelName = String.valueOf(this.writerID);
		}
		
		long startTime = System.currentTimeMillis();
		//校验
		if (header == null || header.size() <= 0) {
			LogCvt.error("Excel标题栏不能为空");
			throw new BusinessException("Excel标题栏不能为空");
		}
		if(StringUtils.isEmpty(this.localExcelPath)){
			LogCvt.error("未找到配置项：（本地导出目录）" + "local.excel.dir");
			throw new BusinessException("导出失败");
		}
		
		//创建文件夹
		if (this.isNeedCreateFolder) {
			this.currentExcelPath = this.localExcelPath + this.folderName;
			makeDirs(this.currentExcelPath);
			this.isNeedCreateFolder = false;
		}
		
		if(this.rowIndex == 0){
			//获取Excel文件名
			this.currentExcelName = getCsvFileName();
			if(StringUtils.isNotEmpty(currentExcelName)){
				this.currentExcelName = csvFileName + "-" + getCsvFileName();
			}
		}
		
		//获取csv文件全路径
		String csvFilePath = this.currentExcelPath + Constants.SLASH + this.currentExcelName;
		
		File file = new File(csvFilePath);
		boolean alreadyExists = file.exists();
		CsvWriter csvWriter = null;
		try {
			csvWriter = new CsvWriter(new FileOutputStream(file, true), separator, charset);
			//写入标题栏
			if(!alreadyExists){
				csvWriter.writeRecord(header.toArray(new String[header.size()]));
			}
			
			for(List<String> dateStr : data){
				//写入内容
				csvWriter.writeRecord(dateStr.toArray(new String[dateStr.size()]));
				rowIndex++;
			}
		} catch (Exception e) {
			LogCvt.error("生成csv文件失败");
			throw e;
		} finally {
			if(csvWriter != null){
				csvWriter.flush();
				csvWriter.close();
			}
		}
		
		LogCvt.info("已导出条数："+this.rowIndex);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime-startTime);
		LogCvt.info("生成["+this.currentExcelName+"]，已导出："+this.rowIndex+"条，共耗时："+totalTime+"ms");
	}
	
	private String getCsvFileName() {
		String dateStr = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_05);
		String fileName = null;
		if(Checker.isNotEmpty(this.folderName)){
			fileName = dateStr + Constants.CSV_SUFFIX;
		}else{
			fileName = dateStr + Math.round((Math.random() * 10000)) + Constants.CSV_SUFFIX;
		}
		return fileName;
    }
	
	/**
	 * 创建目录
	 * @param dir
	 * @throws FroadBusinessException
	 */
	public void makeDirs(String dir) {
		File fileDir = new File(dir);
		if(!fileDir.exists()){
			if(!fileDir.mkdirs()){
				LogCvt.error("创建本地目录失败！");
				throw new BusinessException("导出失败");
			}
		}
	}
	
}
