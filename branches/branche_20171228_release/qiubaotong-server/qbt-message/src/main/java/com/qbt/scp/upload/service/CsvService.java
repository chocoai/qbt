/**
 * Project Name:qbt-message
 * File Name:CsvService.java
 * Package Name:com.qbt.scp.upload.service
 * Date:2017年3月16日上午9:44:16
 *
*/

package com.qbt.scp.upload.service;

import java.nio.charset.Charset;
import java.util.List;

/**
 * ClassName:CsvService
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月16日 上午9:44:16
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface CsvService {
	
	/**
	 * 上传本地csv文件到文件服务器上
	 * @return 返回远程文件url
	 * @throws Exception
	 */
	public String uploadCsv() throws Exception;
	
	/**
	 * 往本地写入csv文件
	 * @param header
	 * @param data
	 * @param csvFileName
	 * @throws Exception
	 */
	public void writeCsv(List<String> header, List<List<String>> data, String csvFileName) throws Exception;
	
	/**
	 * 往本地写入csv文件
	 * @param header 标题
	 * @param data 数据
	 * @param csvFileName csv文件名(不带后缀)
	 * @param separator csv分隔符
	 * @param charset	字符集编码
	 * @throws Exception
	 */
	public void writeCsv(List<String> header, List<List<String>> data, String csvFileName, char separator, Charset charset) throws Exception;
	
}
