package com.qbt.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class StreamUtil {
	
	/**
	 *  关闭输入流
	  * @Title: closeInputStream
	  * @Description: TODO
	  * @author: share 2014年11月27日
	  * @modify: share 2014年11月27日
	  * @param @param streams    
	  * @return void    
	  * @throws
	 */
	public static void closeInputStream(InputStream ...streams){
		for(InputStream stream : streams){
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *  关闭输出流
	  * @Title: closeOutStream
	  * @Description: TODO
	  * @author: share 2014年11月27日
	  * @modify: share 2014年11月27日
	  * @param @param streams    
	  * @return void    
	  * @throws
	 */
	public static void closeOutStream(OutputStream ...streams){
		for(OutputStream stream : streams){
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeReaderStream(Reader ... readers) {
		// TODO Auto-generated method stub
		for(Reader reader : readers){
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

