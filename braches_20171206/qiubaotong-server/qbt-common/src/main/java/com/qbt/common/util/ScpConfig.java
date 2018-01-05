package com.qbt.common.util;

public class ScpConfig {
	private String	ip;
	private int		port;
	private String	userName;
	private String	passWord;

	public ScpConfig(String ip, int port, String userName, String passWord) {
		this.ip = ip;
		this.port = port;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
