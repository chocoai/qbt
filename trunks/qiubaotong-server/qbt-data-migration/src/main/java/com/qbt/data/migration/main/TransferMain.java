package com.qbt.data.migration.main;

import java.io.File;
import java.net.URI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qbt.common.logback.LogCvt;
import com.qbt.data.migration.config.ServicePool;
import com.qbt.data.migration.config.XmlService;
import com.qbt.data.migration.utils.XStreamHandle;

/**
 * Hello world!
 *
 */
public class TransferMain {
    public static void main( String[] args ) throws Exception{
    	/**
    	 * 加载spring配置文件
    	 */
    	
    	ApplicationContext ctxs = new ClassPathXmlApplicationContext("classpath*:context/applicationContext*.xml");
    	
    	LogCvt.info("启动服务,加载配置文件");
    	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    	String filePath = classloader.getResource("transfer.xml").toString();
    	System.out.println(filePath);
    	File xml = new File(new URI(filePath));
        ServicePool.loadService(XStreamHandle.toBean(xml, XmlService.class));
    }
}
