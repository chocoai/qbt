package com.geling.db.helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.geling.msg.logback.LogCvt;
 
/**
 * jdbc工具类
 * 
 * @author WANGYAN
 * 
 */
public final class JdbcUnits {
 
    /**
     * 数据库连接地址
     */
    private static String url ;
    /**
     * 用户名
     */
    private static String userName ;
    /**
     * 密码
     */
    private static String password;
     
    private static String driver;
 
    /**
     * 装载驱动
     */
    static {
         
        DbConfig config=new DbConfig();
        url=config.getUrl();
        userName=config.getUserName();
        password=config.getPassword();
        driver=config.getDriver();
         
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
 
    /**
     * 建立数据库连接
     * 
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
 
    /**
     * 释放连接
     * @param conn
     */
    private static void freeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            LogCvt.error(e.getMessage(),e);
        }
    }
 
    /**
     * 释放statement
     * @param statement
     */
    private static void freeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
        	 LogCvt.error(e.getMessage(),e);
        }
    }
 
    /**
     * 释放resultset
     * @param rs
     */
    private static void freeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
        	LogCvt.error(e.getMessage(),e);
        }
    }
 
    /**
     * 释放资源
     * 
     * @param conn
     * @param statement
     * @param rs
     */
    public static void free(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            freeResultSet(rs);
        }
        if (statement != null) {
            freeStatement(statement);
        }
        if (conn != null) {
            freeConnection(conn);
        }
    }
 
}