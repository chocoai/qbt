package com.geling.msg.logback;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geling.util.PathUtil;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;


/**
 *  logback 日志封装
  * @ClassName: LogCvt
  * @Description: TODO
  * @author share
  * @create-date 2012-10-9 上午09:27:30
  * @modify-date 2012-10-9 上午09:27:30
*
 */
public class LogCvt {
	public final static String NEWLINE = System.getProperty("line.separator", "\n"); // 

	private static final Logger logger = LoggerFactory.getLogger("com.geling.msg.logback");
	static {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		try {
			//configurator.doConfigure("logConfig.xml");
			String path = new PathUtil().getWebInfPath()+File.separatorChar+"WEB-INF/config/logConfig.xml";
			//String path="F:\\myself\\qiubaotong\\qiubaotong-server\\qbt-web\\src\\main\\webapp\\WEB-INF\\config\\logConfig.xml";
			configurator.doConfigure(new File(path));
		} catch (JoranException e) {			e.printStackTrace();
		}
		StatusPrinter.print(lc.getStatusManager());
	}

	public Logger getLogger() {
		return logger;
	}

	// --------------------------------------------LogBack
	// Info----------------------------------
	

	
	// Log a message at the INFO level.
	public static void info(String msg) {
		logger.info(msg);
	}
	
	
	// Log an exception (throwable) at the INFO level with an accompanying
	// message.
	public static void info(String msg, Throwable t) {
		logger.info(msg, t);
	}
	
	// Log a message at the DEBUG level.
	public static void debug(String msg) {
		logger.debug(msg);
	}
	
	// Log an exception (throwable) at the DEBUG level with an accompanying
	// message.
	public static void debug(String msg, Throwable t) {
		logger.debug(msg,t);
	}
	
	// Log a message at the WARN level.
	public static void warn(String msg) {
		logger.warn(msg);
	}
	
	// Log a message at the WARN level.
	public static void warn(String msg, Throwable t) {
		logger.warn(msg,t);
	}
	
	// Log a message at the ERROR level.
	public static void error(String msg) {
		logger.error(msg);
	}
	
	public static void error(String msg, Throwable t) {
		logger.error(msg,t);
	}
	
	// -------------------------LogBack
	// Warn--------------------------------------------
	// Log a message at the TRACE level.
	public static void trace(String msg) {
		logger.trace(msg);
	}

	// Log an exception (throwable) at the TRACE level with an accompanying
	// message.
	public static void trace(String msg, Throwable t) {
		logger.trace(msg,t);
		
	}

	
	
	public static void main(String[] args) {
		
		Exception ex =new Exception();
		
		LogCvt.error(ex.getMessage(),ex);
	}
}



