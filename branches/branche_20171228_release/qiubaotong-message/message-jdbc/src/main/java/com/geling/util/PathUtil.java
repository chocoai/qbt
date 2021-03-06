package com.geling.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 *   普通JAVA获取   WEB项目下的WEB-INF目录
  * @ClassName: PathUtil
  * @Description: TODO
  * @author chenxiaocong 2016年10月29日
  * @modify chenxiaocong 2016年10月29日
 */
public class PathUtil {
	
	public String getWebInfPath(){
		URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
		String path = url.toString();
		int index = path.indexOf("WEB-INF");
		
		if(index == -1){
			index = path.indexOf("classes");
		}
		
		if(index == -1){
			index = path.indexOf("bin");
		}
		
		path = path.substring(0, index);
		
		if(path.startsWith("zip")){//当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		}else if(path.startsWith("file")){//当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(5);
		}else if(path.startsWith("jar")){//当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(9); 
		}
		try {
			path =  URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
