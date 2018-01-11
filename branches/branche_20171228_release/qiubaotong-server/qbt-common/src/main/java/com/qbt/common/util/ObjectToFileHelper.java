/**
 * File: ObjectToFileHelper.java
 * Description: 将序列化对象持久到文件中,同时可以从文件中读取
 * Copyright 2010 GamaxPay. All rights reserved
 *  
 */
package com.qbt.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.qbt.common.logback.LogCvt;

/**
 * 将对象写入文件,并可以从文件读取
 * @author jacky
 *
 */
public class ObjectToFileHelper {
	
	
	private ObjectToFileHelper(){	
	}
	
	/**
	 * 将对象写入到文件中去
	 * @param filepath 将要被写入的文件
	 * @param objs	   将要被写入的对象
	 */
	public static void writeObjectFile(String filepath,Object...objs){
		writeToFile(filepath,objs);
	}
	
	/**
	 * 将对象写入到文件中去
	 * @param filepath 将要被写入的文件
	 * @param objs	   将要被写入的对象
	 */
	public static void writeToFile(String filepath, Object[] objs) {  
		
		ObjectOutputStream oos = null;  		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < objs.length; i++) {
				oos.writeObject(objs[i]);
			}
		} catch (FileNotFoundException fnf) {
			LogCvt.error("文件没有发现", fnf);
        	throw new RuntimeException(fnf);
		}catch (IOException ioe) {
			LogCvt.error("IO发生异常", ioe);
        	throw new RuntimeException(ioe);
		}finally{
			try {  
				oos.close();  
			} catch (IOException e) {  
				LogCvt.error("文件关闭出错", e);
	        	throw new RuntimeException(e);  
			}  
		}    
		
	}
	
	/**
	 * 返回在文件中指定位置的对象
	 * @param filepath 存储对象的文件
	 * @param i		   从1开始
	 * @return		 存储的对象
	 */
	public static Object readFromFile(String filepath, int i){
		ObjectInputStream ois = null;
		Object obj = null; 
		FileInputStream fis;
		try {
			 fis = new FileInputStream(filepath);
			 ois = new ObjectInputStream(fis);
			 for (int j = 0; j < i; j++) {  
				 obj = ois.readObject();
			 }
		}catch (FileNotFoundException fnf) {
			LogCvt.error("文件没有发现", fnf);
        	throw new RuntimeException(fnf);
		}catch (IOException ioe) {
			LogCvt.error("IO发生异常", ioe);
        	throw new RuntimeException(ioe);
		}catch (ClassNotFoundException cnfe) {
			LogCvt.error("类未发现", cnfe);
        	throw new RuntimeException(cnfe);
		}finally{
			try{
				 ois.close();  
			}catch (IOException e) { 
				LogCvt.error("IO发生异常", e);
	        	throw new RuntimeException(e);
			}
		}
		return obj;
	}

}
