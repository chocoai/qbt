package com.qbt.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/** 
 * ZIP压缩工具 
 *  
 * @author  zhouyun	    
 * @date 2013/7/10
 */


public class ZipUtils {
	public static final String EXT = ".zip";
	private static final String BASE_DIR = "@";
	private static final String SUB_DIR = ":";

	private static Log logger =  LogFactory.getLog(ZipUtils.class);

	public static Map<String,List<String>> readZipFile(String file) throws Exception {  
		Map<String,List<String>>  fileMap= new HashMap<String,List<String>>();
		ZipFile zf = new ZipFile(file);   
		Enumeration<? extends ZipEntry> enumer = zf.entries();
		while(enumer.hasMoreElements()){
			ZipEntry sub_file = enumer.nextElement();
			String fileName = sub_file.getName();
			logger.info("文件名："+fileName+"------start");
			//去掉路径
			fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
			if("".equals(fileName)){
			    continue;
			}
			InputStream ips = zf.getInputStream(sub_file);
			BufferedReader br = new BufferedReader(new InputStreamReader(ips,"gbk"));
			List<String> list = new ArrayList<String>();
			String line = "";
			long size = sub_file.getSize();
			if(size>0){
				while ((line = br.readLine()) != null) {
					String[] split_str = line.split("\\^\\^\\^");
					if(split_str!=null && split_str.length>0){
						for(String lineStr : split_str){
							list.add(lineStr);
						}
					}
				}
			}
			fileMap.put(fileName, list);
			logger.info("-----------"+fileName+"---end");
			br.close();
			ips.close();
		}
		logger.info("获取文件完成 ！ 共获取到"+fileMap.size()+"个文件");
		//zin.closeEntry();
		return fileMap;
	}
	
	public static byte[] getBytes(String filePath){
		byte[] buffer = null;  
		try {  
		    File file = new File(filePath);  
		    FileInputStream fis = new FileInputStream(file);  
		    ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
		    byte[] b = new byte[1000];  
		    int n;  
		    while ((n = fis.read(b)) != -1) {  
		        bos.write(b, 0, n);  
		    }  
		    fis.close();  
		    bos.close();  
		    buffer = bos.toByteArray();  
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}  
		return buffer;  
	}
	
	public static List<String> readAHRCUTransferFile(String file) throws Exception {
		List<String> list = new ArrayList<String>();
		ZipFile zf = new ZipFile(file);   
		Enumeration<? extends ZipEntry> enumer = zf.entries();
		while(enumer.hasMoreElements()){
			ZipEntry sub_file = enumer.nextElement();
			String fileName = sub_file.getName();
			logger.info("文件名："+fileName+"------start");
			//去掉路径
			fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
			if("".equals(fileName)){
			    continue;
			}
			InputStream ips = zf.getInputStream(sub_file);
			BufferedReader br = new BufferedReader(new InputStreamReader(ips,"utf-8"));
			String line = "";
			long size = sub_file.getSize();
			if(size>0){
				while ((line = br.readLine()) != null) {
					list.add(line);
				}
			}
			logger.info("-----------"+fileName+"---end");
			br.close();
			ips.close();
		}
		//zin.closeEntry();
		return list;
	}
	

	public static void main(String[] args) throws Exception {
		/*try {  
		    Map<String,List<String>> fileMap =  readZipFile("E:\\test\\test.zip");  
		    for (String key : fileMap.keySet()) {
		    	List<String> list = fileMap.get(key);
		    	System.out.println("------"+key+"  start------");
		    	for(int i=0 ;i<list.size();i++){
		    		String lineStr = list.get(i); 
		    		System.out.println(lineStr);
				    String[] fieldsArr =   lineStr.split(BASE_DIR);
				    for(int j=0 ;j<fieldsArr.length;j++){
						String[] fieldArr =   fieldsArr[j].split(SUB_DIR);
						if(fieldArr.length == 2){
							System.out.println(fieldArr[0]+"="+fieldArr[1]);
						}
				    }
		    	}
		    	System.out.println("------"+key+"  end------");
		    }
		} catch (Exception e) {
			e.printStackTrace();  
		}  */
		
	}
	
	
	
}