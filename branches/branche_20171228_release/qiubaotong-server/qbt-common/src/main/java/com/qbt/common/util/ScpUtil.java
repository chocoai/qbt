package com.qbt.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qbt.common.logback.LogCvt;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;

public class ScpUtil {

	/**
	 * 创建连接
	 * 
	 * @tilte connectServer
	 * @date 2015年4月15日 上午10:57:33
	 * @param cfg
	 * @return
	 * @throws Exception
	 */
	private static Connection connectServer(ScpConfig cfg) throws Exception {
		boolean isAuthed = false;
		Connection scpConnection = null;
		if (cfg.getPort() == 0) {
			scpConnection = new Connection(cfg.getIp());
		} else {
			scpConnection = new Connection(cfg.getIp(), cfg.getPort());
		}
		scpConnection.connect();
		isAuthed = scpConnection.authenticateWithPassword(cfg.getUserName(), cfg.getPassWord());
		if (!isAuthed) {
			throw new Exception("connect auth failed!");
		}
		return scpConnection;
	}

	/**
	 * 文件上传
	 * 
	 * @tilte uploadFile
	 * @author zxl
	 * @date 2015年4月15日 上午11:09:21
	 * @param localFilePath
	 *            本地文件
	 * @param scpFileName
	 *            远程保存文件名
	 * @param scpDir
	 *            远程目录
	 * @param cfg
	 *            连接配置
	 * @throws Exception
	 */
	public static void uploadFile(String localFilePath, String scpFileName, String scpDir, ScpConfig cfg) throws Exception {
		SCPClient scpClient = null;
		Connection scpConnection = null;
		try {
			scpConnection = connectServer(cfg);
			scpClient = scpConnection.createSCPClient();
			// 检查远程目录，不存在创建
			createDir(scpDir, scpConnection);
			// 文件上传
			scpClient.put(localFilePath, scpFileName, scpDir, "0774");
		} catch (Exception e) {
			throw e;
		} finally {
			closeServer(scpConnection);
		}
	}

	/**
	 * 从远程下载文件
	 * 
	 * @param srcDir
	 * @param fileName
	 * @param localDir
	 * @param scp
	 * @throws RuntimeException
	 */
	public static void downloadFile(String scpFileName, String localDir, ScpConfig scp) throws Exception {
		Connection scpConnection = null;
		SCPClient scpClient = null;
		try {
			scpConnection = connectServer(scp);
			File localPath = new File(localDir);
			if (!localPath.exists() || !localPath.isDirectory()) {
				localPath.mkdirs();
			}
			scpClient = scpConnection.createSCPClient();
			scpClient.get(scpFileName, localDir);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			throw new RuntimeException("文件下载失败", e);
		} finally {
			if (scpConnection != null) {
				scpConnection.close();
			}
		}
	}

	/**
	 * 文件上传 批量
	 * 
	 * @tilte uploadFile
	 * @author zxl
	 * @date 2015年4月15日 上午11:09:21
	 * @param localFilePath
	 *            本地文件
	 * @param scpFileName
	 *            远程保存文件名
	 * @param scpDir
	 *            远程目录
	 * @param cfg
	 *            连接配置
	 * @throws Exception
	 */
	public static void uploadFile(String[] localFilePath, String[] scpFileName, String scpDir, ScpConfig cfg) throws Exception {
		SCPClient scpClient = null;
		Connection scpConnection = null;
		try {
			scpConnection = connectServer(cfg);
			scpClient = scpConnection.createSCPClient();
			// 检查远程目录，不存在创建
			createDir(scpDir, scpConnection);
			// 文件上传
			scpClient.put(localFilePath, scpFileName, scpDir, "0774");
		} catch (Exception e) {
			throw e;
		} finally {
			closeServer(scpConnection);
		}
	}

	/**
	 * 远程删除文件
	 * 
	 * @param fileName
	 * @param cfg
	 * @throws Exception
	 */
	public static void delFile(String fileName, ScpConfig cfg) throws Exception {
		Connection scpConnection = null;
		SFTPv3Client sftpClient = null;
		try {
			scpConnection = connectServer(cfg);
			sftpClient = new SFTPv3Client(scpConnection);

			sftpClient.rm(fileName);

		} catch (Exception e) {
			throw e;
		} finally {
			closeServer(scpConnection);
		}
	}
	
	public static void delFile(List<String> fileName, ScpConfig cfg) throws Exception {
		Connection scpConnection = null;
		SFTPv3Client sftpClient = null;
		try {
			scpConnection = connectServer(cfg);
			sftpClient = new SFTPv3Client(scpConnection);

			for (String f : fileName) {
				sftpClient.rm(f);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			closeServer(scpConnection);
		}
	}

	/**
	 * 远程目录创建
	 * 
	 * @tilte createDir
	 * @author zxl
	 * @date 2015年4月15日 上午11:12:10
	 * @param dirName
	 * @param scpConnection
	 * @throws IOException
	 */
	private static void createDir(String dirName, Connection scpConnection) throws IOException {
		SFTPv3Client sftpClient = null;

		try {
			sftpClient = new SFTPv3Client(scpConnection);
			sftpClient.mkdir(dirName, 0775);
		} catch (IOException e) {
			// 目录存在,不处理
		} finally {
			if (null != sftpClient) {
				sftpClient.close();
			}
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @tilte closeServer
	 * @author zxl
	 * @date 2015年4月15日 上午11:12:57
	 * @param scpConnection
	 */
	private static void closeServer(Connection scpConnection) {
		try {
			if (scpConnection != null)
				scpConnection.close();
		} catch (Exception e) {
			LogCvt.debug("关闭远程scp服务连接失败", e);
		}
	}

	public static void main(String[] args) throws Exception {
		//String localFilePath, String scpFileName, String scpDir, ScpConfig cfg
		String localFilePath="C:\\Users\\win10\\Desktop\\球包通短信模板.txt";
		String scpFileName="球包通短信模板.txt";
		String scpDir="/upload/images/account";
		ScpConfig cfg=new ScpConfig("114.55.225.3", 22, "upload", "upload!@#");
		uploadFile(localFilePath,scpFileName,scpDir,cfg);
	}
}
