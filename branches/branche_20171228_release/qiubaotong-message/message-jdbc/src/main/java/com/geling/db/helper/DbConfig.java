package com.geling.db.helper;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.geling.msg.logback.LogCvt;
 
/**
 * 数据库配置文件读取方法
 * @author WANGYAN
 *
 */
public class DbConfig {
     
	
    private String driver;
    private String url;
    private String userName;
    private String password;
    private static String  pathname;
     
    public DbConfig() {
    	
        FileReader fr = null;
        Properties p=new Properties();
        try {
        	fr = new FileReader(new File(pathname));
        	
            p.load(fr);
            this.driver=p.getProperty("driver");
            this.url=p.getProperty("url");
            this.userName=p.getProperty("username");
            this.password=p.getProperty("password");
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	LogCvt.error(e.getMessage(),e);
        }
         
    }
     
    public String getDriver() {
        return driver;
    }
    public String getUrl() {
        return url;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

	
	/**
	 * getter method 
	 * @Title: getPathname
	 * @return the pathname
	 */
	
	public static String getPathname() {
		return pathname;
	}

	
	/**
	* setter method
	* @param pathname the pathname to set
	*/
	
	public static void setPathname(String pathname) {
		DbConfig.pathname = pathname;
	}


     
     
 
}