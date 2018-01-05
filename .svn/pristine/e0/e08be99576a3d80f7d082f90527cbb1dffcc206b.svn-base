package com.qbt.data.migration.pgsql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private static String url = "jdbc:mysql://rm-bp153aw77hb98q95wo.mysql.rds.aliyuncs.com:3306/qbt?useUnicode=true";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "qiubaotong_dev";
	private static String password = "qiubaotongdev";

	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn == null)
			return;
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {

		}
	}
	
	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeStatement(Statement statement) {
		if (statement == null)
			return;
		try {
			if (!statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {

		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
