package com.qbt.scp.upload.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.Constants;
import com.qbt.common.util.FileUploadUtils;
import com.qbt.scp.upload.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Value("${image.file.path}")
	private String templatePath;
	
	@Value("${image.file.template}")
	private String imageTemplate;
	
	@Value("${local.images.dir}")
	private String localImagesPath;
	
	@Override
	public void composeImage(String fileName, String finalFileName, String saleName, String saleManCode){
        File templetimage = null;
        File QRCodeimage = null;
        BufferedImage templetimageBuffer = null;
        BufferedImage QRCodeimageBuffer = null;
        
		try {
			templetimage = new File(templatePath + imageTemplate);
			QRCodeimage = new File(localImagesPath + fileName);
			templetimageBuffer = ImageIO.read(templetimage);
			QRCodeimageBuffer = ImageIO.read(QRCodeimage);
		} catch (FileNotFoundException e) {
			throw new BusinessException("路径错误");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("文件读取错误");
		}

        Graphics g = templetimageBuffer.getGraphics();
        //合成二维码
		//      g.drawImage(QRCodeimageBuffer, 190, 411, QRCodeimageBuffer.getWidth()-192, QRCodeimageBuffer.getHeight()-192, null);
		      g.drawImage(QRCodeimageBuffer, 190, 245, QRCodeimageBuffer.getWidth()-192, QRCodeimageBuffer.getHeight()-192, null);
		      //加销售人员名称
		//      g.setColor(Color.white); 
//        g.drawImage(QRCodeimageBuffer, 190, 411, QRCodeimageBuffer.getWidth()-192, QRCodeimageBuffer.getHeight()-192, null);
//        g.drawImage(QRCodeimageBuffer, 190, 245, QRCodeimageBuffer.getWidth()-192, QRCodeimageBuffer.getHeight()-192, null);
        g.drawImage(QRCodeimageBuffer, 190, 245, QRCodeimageBuffer.getWidth()-192, QRCodeimageBuffer.getHeight()-192, null);
 
        //加销售人员名称
//        g.setColor(Color.white); 
        g.setColor(Color.black);
    	g.drawImage(templetimageBuffer, 0, 0, null ); 
    	g.setFont(new Font(null,Font.BOLD,40)); //字体、字型、字号 
    	g.drawString("我是"+saleName,180,90); //画文字 
        
    	//加销售人员号
    	g.setColor(Color.lightGray); 
    	g.setFont(new Font(null,Font.BOLD,25));
    	g.drawString(saleManCode,230,1090);
        
        g.dispose();
    	
		try {
			ImageIO.write(templetimageBuffer, "JPG", new File(localImagesPath + finalFileName));
		} catch (FileNotFoundException e) {
			throw new BusinessException("路径错误");
		} catch (IOException e) {
			throw new BusinessException("flush异常");
		}finally {
			 FileUploadUtils.delFiles(localImagesPath+Constants.SLASH + fileName);
		}
    }
	
}
