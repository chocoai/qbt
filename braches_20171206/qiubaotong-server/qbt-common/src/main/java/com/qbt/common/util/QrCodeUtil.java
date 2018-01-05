package com.qbt.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qbt.common.logback.LogCvt;

public class QrCodeUtil {
	
	/**
	 * 生成二维码
	 * 
	 * @param keyword - QrCodeType + content
	 * @param qrCodeFolder
	 * @param logoFolder
	 * @param logoUrl
	 * @param clientId
	 * @return
	 */
	public static void generateQrCode(String keyword,File file){
		try {
			/**
			 * 生成普通二维码
			 */
			LogCvt.info(new StringBuffer("开始生成普通二维码: ").append(keyword).toString());
			
			generateNormalQrCode(keyword, QrCodeConstants.QR_IMAGE_WIDTH, QrCodeConstants.QR_IMAGE_HEIGHT,file);
		} catch (Exception e) {
			LogCvt.error(new StringBuffer("生成二维码失败: ").append(keyword).toString(),e);
		}
	}
	
	/**
	 *  生成二维码,文件落地保存指定目录
	  * @Title: generateQrCode
	  * @Description: TODO
	  * @author: share 2017年2月20日
	  * @modify: share 2017年2月20日
	  * @param keyword
	  * @param targetFilePath
	 */
	public static void generateQrCode(String keyword,String targetFilePath){
		try {
			/**
			 * 生成普通二维码
			 */
			LogCvt.info(new StringBuffer("开始生成普通二维码: ").append(keyword).toString());
			File file = new File(targetFilePath);
			
			generateNormalQrCode(keyword, QrCodeConstants.QR_IMAGE_WIDTH, QrCodeConstants.QR_IMAGE_HEIGHT,file);
		} catch (Exception e) {
			LogCvt.error(new StringBuffer("生成二维码失败: ").append(keyword).toString(),e);
		}
	}
	
	/**
	 * 生成普通二维码
	 * 
	 * @param content 二维码内容
	 * @param width 图片宽度
	 * @param height 图片高度
	 * @throws WriterException 
	 * @throws IOException 
	 */
	private static void generateNormalQrCode(String content, int width, int height,File file) throws WriterException, IOException{
		Hashtable<EncodeHintType, Object> hints = null;
		BitMatrix byteMatrix = null;
		
		hints = new Hashtable<EncodeHintType, Object>();
		// 设置编码类型为utf-8
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 设置二维码纠错能力级别为Q（25%容错率）
		if(content.length() > 10){
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		}else{
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
		}
		
		// 生成二维码
		byteMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, width, height, hints);
		
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				throw new RuntimeException("创建本地临时文件路径失败");
			}
		}
		
		// 写入文件
		MatrixToImageWriter.writeToFile(byteMatrix, "jpg", file);
	}

	public static void main(String[] args) {
		generateQrCode("weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXX&mch_id=XXXXX&product_id=XXXXXX&time_stamp=XXXXXX&nonce_str=XXXXX", new File("/data/qiubaotong/file/qrcode/20170220/zzz1.jpg"));
	}
}