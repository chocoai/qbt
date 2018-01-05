package com.qbt.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;

public class FileUploadUtils {

	public static final String FILE_PATH = "/upload/";  

	/**
	 * 下载文件数据流
	 * @Title: downloadFile
	 * @Description: TODO
	 * @author: froad-zjz 2014-8-27
	 * @modify: froad-zjz 2014-8-27
	 * @param @param httpFilePath    
	 * @return void    
	 * @throws Exception 
	 */
	public static void downloadFile(String httpFilePath,String fileName,String resourceDir) throws Exception{
	  int nRead = 0;   
	  HttpURLConnection httpConnection = null;
	  FileOutputStream fos = null;
	  BufferedInputStream bis = null;
	  try {   
		   URL url = new URL(httpFilePath);   
		   // 打开连接   
		   httpConnection = (HttpURLConnection) url.openConnection();
		   httpConnection.setConnectTimeout(10000);
		   httpConnection.setRequestMethod("GET");
		   httpConnection.connect();
		   // 获得文件长度   
		   File file = new File(resourceDir);
		   if(!file.isDirectory()){
			   file.mkdirs();
		   }
		   String filePath = resourceDir + File.separatorChar  + fileName;
		   file =  new File(filePath);
		   file.createNewFile();
		   
		   fos = new FileOutputStream(file);
		   bis= new BufferedInputStream(httpConnection.getInputStream());   
		   byte[] b = new byte[1024];   
		   // 读取网络文件,写入指定的文件中   
		   while ((nRead = bis.read(b)) != -1) {   
			   fos.write(b, 0, nRead);   
		   }
	  } catch (Exception e) {   
		  throw e;
	  }finally{
		  	try {
		  		if(fos != null){
		  			fos.close();
		  		}
			} catch (Exception e2) {
				LogCvt.error(e2.getMessage());
			}
		  	
		  	try {
		  		if(bis != null){
		  			bis.close();
		  		}
			} catch (Exception e2) {
				LogCvt.error(e2.getMessage());
			}
			  	
			if(httpConnection!=null){
				httpConnection.disconnect();  
			}
	  }
	 }   
	  
	 /**
	  *  获取文件流的长度
	   * @Title: getFileSize
	   * @Description: TODO
	   * @author: froad-zjz 2014-8-27
	   * @modify: froad-zjz 2014-8-27
	   * @param @param sURL
	   * @param @return    
	   * @return long    
	   * @throws
	  */
	 public static long getFileSize(HttpURLConnection httpConnection) {   
		  int nFileLength = -1;   
		  try {   
			   int responseCode = httpConnection.getResponseCode();   
			   if (responseCode >= 400) {   
				   LogCvt.info("Error Code : " + responseCode);   
				   return -2; //
			   }   
			   for(int i = 1;; i++) {   
				   String sHeader = httpConnection.getHeaderFieldKey(i);   
				   if(sHeader != null) {   
					   if (sHeader.equals("Content-Length")) {   
						  nFileLength = Integer.parseInt(httpConnection.getHeaderField(sHeader));   
						  break;
					   }  
				   }else{
					   break;
				   }
			   }
		  } catch (Exception e) {   
			  LogCvt.error(e.getMessage(),e); 
		  }
		  
		  return nFileLength;   
	 }
	
	 /**
	  *  获取文件后缀名
	   * @Title: fileSuffix
	   * @Description: TODO
	   * @author: froad-zjz 2014-8-27
	   * @modify: froad-zjz 2014-8-27
	   * @param @param url
	   * @param @return    
	   * @return String    
	   * @throws
	  */
	 public static String fileSuffix(String url){
		 int index = url.lastIndexOf(".");
		 if(index >0 ){
			 return url.substring(index);
		 }
		 return "";
	 }
	 
	 //文件上传  
    public static String uploadFile(MultipartFile file, HttpServletRequest request){
    	try {
    		 String fileName = file.getOriginalFilename();  
    	        // 获取图片的扩展名
    	        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
    	        // 新的图片文件名 = 获取时间戳+"."图片扩展名
    	        String newFileName = String.valueOf(System.currentTimeMillis())+ "." + extensionName;
    	        File tempFile = new File(FILE_PATH, newFileName);  
    	        if (!tempFile.getParentFile().exists()) {  
    	            tempFile.getParentFile().mkdir();  
    	        }  
    	        if (!tempFile.exists()) {  
    	            tempFile.createNewFile();  
    	        }  
    	        file.transferTo(tempFile);  
    	        return "comm/pic.jhtml?fileName=" + tempFile.getName(); 
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		}
    	
    	return null;
        
    }
    
    public static File getFile(String fileName) {  
        return new File(FILE_PATH, fileName);  
    } 
    
    
    /**
	 * 保存本地文件
	 * 
	 * @param newFileName
	 * @param savePath
	 * @param file
     * @throws Exception 
	 */
	public static void saveFile(String savePath, MultipartFile file) throws Exception {
		FileOutputStream out = null;
		try {
			// String fileDir = savePath.substring(0,
			// savePath.lastIndexOf(File.separator));
			File saveFile = new File(savePath);
			if (!saveFile.getParentFile().exists()) {
				if (!saveFile.getParentFile().mkdirs()) {
					throw new RuntimeException("创建本地临时文件路径失败");
				}
			}
			// 输出文件
			out = new FileOutputStream(savePath);
			out.write(file.getBytes());
			out.flush();
		} catch (Exception e) {
			LogCvt.error("文件保存失败.", e);
			throw e;
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				LogCvt.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 */
	public static void delFiles(String filePath) {
		File tmpfile = new File(filePath);
		if (tmpfile.exists()) {
			tmpfile.delete();
		}
	}

	
	/**
	 * 单图片上传
	 * 
	 * @param request
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String upladImage(HttpServletRequest request, MultipartFile file) throws IOException {
		String picPath = ToolsUtil.getUploadFilePath(request) + ToolsUtil.getFileSavePath();
		/* 从当时时间MD5强制重命名图片 */
		String picTime = System.currentTimeMillis() + "";
		String picType = file.getContentType();
		LogCvt.info("图片格式：" + picType);
		String fileName = "";

		if ("image/jpeg".equals(picType) || "image/pjpeg".equals(picType)) {
			fileName = picTime.concat(".jpg");
		} else if ("image/png".equals(picType)) {
			fileName = picTime.concat(".png");
		} else if ("image/bmp".equals(picType)) {
			fileName = picTime.concat(".bmp");
		} else if ("image/gif".equals(picType)) {
			fileName = picTime.concat(".gif");
		} else {
			throw new BusinessException("图片上传格式不对");
		}
		/* 保存文件 */
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(picPath, fileName));
		return ToolsUtil.getFileSavePath() + File.separator + fileName;
	}
	
	

	/**
	 * 多图片上传
	 * 
	 * @param request
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String[] upladImage(HttpServletRequest request, MultipartFile[] files) throws IOException {
		String[] filePath = new String[files.length];
		int index = 0;
		for (MultipartFile file : files) {
			if (file.getSize() > 0) {
				filePath[index] = upladImage(request, file);
			} else {
				filePath[index] = "";
			}
			index++;
		}
		return filePath;
	}

	/**
	 * 附件上传
	 * 
	 * @param request
	 * @param file
	 * @param path
	 *            保存路径
	 * @param isImage
	 *            是否图片
	 * @return
	 * @throws IOException
	 */
	public static String uploadFile(MultipartFile file, String path, boolean isImage) throws IOException {
		String fileType = file.getContentType();
		LogCvt.info("附件格式：" + fileType);
		if (isImage) {
			if (!checkPictureFormat(fileType)) {
				throw new BusinessException("图片上传格式不对");
			}
			if (file.getSize() > (1024000 * 2)) {
				throw new BusinessException("图片最大不能超过2M");
			}
		} else {
			if (!checkFileFormat(fileType)) {
				throw new BusinessException("附件上传格式不对");
			}
			if (file.getSize() > (1024000 * 5)) {
				throw new BusinessException("附件最大不能超过5M");
			}
		}
		
		/* 保存文件 */
		path = path.replace("\\", "/");
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, file.getOriginalFilename()));
		String savePath = path + file.getOriginalFilename();
		return savePath.replace("\\", "/");
		
	}

	
	public static boolean checkFileFormat(String fileType) {
		String[] fileFormat = { "application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document" };
		for (int i = 0; i < fileFormat.length; i++) {
			if (fileFormat[i].equals(fileType)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkPictureFormat(String fileType) {
		String[] fileFormat = { "image/jpeg", "image/pjpeg", "image/png", "image/bmp", "image/gif" };
		for (int i = 0; i < fileFormat.length; i++) {
			if (fileFormat[i].equals(fileType)) {
				return true;
			}
		}
		return false;
	}
    
	 
	 public static void main(String[] args) {
		 System.out.println(fileSuffix("aaaa.//aa//aa.doc"));
	 }
}
