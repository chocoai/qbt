package com.qbt.web.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 * @author andy.li
 * @date 2018-1-5 
 * @version V3.0
 */
public class ZxingUtil {
	private static final Map<EncodeHintType, ErrorCorrectionLevel> encodeMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
	private static final Map<DecodeHintType, ErrorCorrectionLevel> decodeMap=new HashMap<DecodeHintType, ErrorCorrectionLevel>();
	private static final String charset="UTF-8",format="png";
	private static final int size=150;
	private ZxingUtil() {}

	/**
	 * 生成二维码图片
	 * @author andy.li
	 * @date 2018-1-5 
	 * @param file
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void createQRCode(String data, File file)
			throws WriterException, IOException {
		MatrixToImageWriter.writeToFile(new MultiFormatWriter().encode(
				new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, size, size, encodeMap), format, file);
	}

	/**
	 * 读取二维码信息
	 * @author andy.li
	 * @date 2018-1-5 
	 * @param filePath 二维码图片路径
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NotFoundException
	 */
	public static String readQRCode(String filePath)
			throws FileNotFoundException, IOException, NotFoundException {
		return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath))))),decodeMap).getText();
	}
	
	/**
	 * 图片转字节数组
	 * @author andy.li
	 * @date 2018-1-5 
	 * @param path
	 * @return
	 */
	public static byte[] imageTobyte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 删除某个文件夹下的所有文件
	 * @author andy.li
	 * @param delpath
	 * @return
	 * @throws Exception
	 */
    public static void deletefile(String delpath) throws Exception {  
      
           File file = new File(delpath);  
           if(file.isDirectory()) {
        	   String[] filelist = file.list(); 
        	   for (int i = 0; i < filelist.length; i++) {  
                   File delfile = new File(delpath + "\\" + filelist[i]);  
                   delfile.delete(); 
               }  
           }
    }  
    
	
	/**
	 * 生成一个简易的二维码code
	 * @return
	 */
	public static String GetQrCode()
	{
		StringBuffer sb=new StringBuffer();
		int temp_num;
		for(int i=0;i<6;i++)
		{
			temp_num=(int)(Math.random()*10);
			sb.append(temp_num);
		}
		return sb.toString();
	}

}
