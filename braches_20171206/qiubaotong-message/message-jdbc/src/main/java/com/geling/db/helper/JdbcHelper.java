package com.geling.db.helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.geling.msg.logback.LogCvt;
 
/**
 * 数据库访问帮助类
 * 
 * @author WANGYAN
 * 
 */
public class JdbcHelper {
 
//    private static Connection conn = null;
//    private static PreparedStatement preparedStatement = null;
//    private static CallableStatement callableStatement = null;
 
    /**
     * 返回单个结果值，如count\min\max等
     * 
     * @param sql
     *            sql语句
     * @param paramters
     *            参数列表
     * @return 结果
     * @throws SQLException
     */
    public static Object getSingle(String sql, Object... paramters)
            throws SQLException {
        Object result = null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = JdbcUnits.getConnection();
        	preparedStatement = conn.prepareStatement(sql);

            LogCvt.debug("run sql ="+sql );
            
            for (int i = 0; i < paramters.length; i++) {
                preparedStatement.setObject(i + 1, paramters[i]);
            }
            rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                result = rs.getObject(1);
            }
            return result;
        } catch (SQLException e) {
        	LogCvt.error(e.getMessage(),e);
            throw new SQLException(e);
        } finally {
        	JdbcUnits.free(conn, preparedStatement, rs);
        }
    }
 
  
 
    /**
     * 用于增删改（带参数）
     * 
     * @param sql
     *            sql语句
     * @param paramters
     *            sql语句
     * @return 影响行数
     * @throws SQLException
     */
    public static int update(String sql, Object... paramters)
            throws SQLException {
    	
    	ResultSet rs = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
    	
        try {
        	
        	conn = JdbcUnits.getConnection();
            preparedStatement = conn.prepareStatement(sql);
 
            for (int i = 0; i < paramters.length; i++) {
                preparedStatement.setObject(i + 1, paramters[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	LogCvt.error(e.getMessage(),e);
            throw new SQLException(e);
        } finally {
        	JdbcUnits.free(conn, preparedStatement, rs);
        }
    }
 
 
    /**
     * 插入值后返回主键值
     * 
     * @param sql
     *            插入sql语句
     * @param paramters
     *            参数列表
     * @return 返回结果
     * @throws SQLException
     */
    public static Object insertWithReturnPrimeKey(String sql,
            Object... paramters) throws SQLException {
        Object result = null;
        

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conn = JdbcUnits.getConnection();
            preparedStatement = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                        
            for (int i = 0; i < paramters.length; i++) {
                preparedStatement.setObject(i + 1, paramters[i]);
            }
            result = preparedStatement.execute();
                      
            return result;
        } catch (SQLException e) {
        	LogCvt.error(e.getMessage(),e);
            throw new SQLException(e);
        }finally {
        	JdbcUnits.free(conn, preparedStatement, rs);
        }
 
    }

}