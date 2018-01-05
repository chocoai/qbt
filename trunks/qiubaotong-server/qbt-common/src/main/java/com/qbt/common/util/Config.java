package com.qbt.common.util;

public class Config {

	private static String tomcat_port  = "8080";
	
	private static String tomcat_ip	  = "127.0.0.1";

	public static String getTomcat_port() {
		return tomcat_port;
	}

	public static void setTomcat_port(String tomcat_port) {
		Config.tomcat_port = tomcat_port;
	}

	public static String getTomcat_ip() {
		return tomcat_ip;
	}

	public static void setTomcat_ip(String tomcat_ip) {
		Config.tomcat_ip = tomcat_ip;
	}

	
}
