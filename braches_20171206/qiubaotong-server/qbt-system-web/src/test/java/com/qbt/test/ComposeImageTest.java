package com.qbt.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ComposeImageTest {

    /**
     * 图片合成
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
    	File fileDir = new File("E:/data/test");
    	File[] files = fileDir.listFiles();
    	long startTime = System.currentTimeMillis();
    	for(File file : files){
    		
    		if(file.isDirectory()){
    			continue;
    		}
    		
    		InputStream imagein = new FileInputStream("E:/data/qrcode_bg.png");
            String fileNamge = file.getName().substring(0,file.getName().lastIndexOf("."));
            InputStream imagein2 = new FileInputStream(file);
            
            BufferedImage image = ImageIO.read(imagein);
            BufferedImage image2 = ImageIO.read(imagein2);
            Graphics g = image.getGraphics();
            g.drawImage(image2, 188, 414,250 , 250, null);
            Font font = new Font("黑体", Font.BOLD, 13);
            g.setFont(font);
            Color c = new Color(196,195,195);
            g.setColor(c); //根据图片的背景设置水印颜色  
            g.drawString(fileNamge, 265, 1090);
            
            font = new Font("黑体", Font.BOLD, 48);
            g.setFont(font);
            g.setColor(Color.white); //根据图片的背景设置水印颜色  
//            g.drawString("我是张三", 210, 95);
//            g.drawString("我是张三三", 180, 98);
            g.drawString("我是张三三张三三张三三三", 5, 98);
            
            g.dispose();
            OutputStream outImage = new FileOutputStream("E:/data/test/test/" + fileNamge + ".jpg");
          
            ImageIO.write(image, "JPG", new File("E:/data/test/test/", fileNamge+".jpg"));
            
//            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
//            enc.encode(image);
            imagein.close();
            imagein2.close();
            outImage.close();
    	}
    	System.out.println(("生成耗时："+(System.currentTimeMillis() - startTime)/1000)+"秒");
    }
}