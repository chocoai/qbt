package com.qbt.data.migration.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qbt.common.logback.LogCvt;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.config.ServicePool;
import com.qbt.data.migration.pgsql.db.JDBCUtil;

public abstract class AbstractProcess implements Process {
	private static Logger logger = LoggerFactory.getLogger(AbstractProcess.class);
	/**
	 *  模块名称
	 */
	protected String name;
	
	protected Connection connection;
	
	protected Statement st;
	
	protected ResultSet rs;
	
	protected List<String> columnList = new ArrayList<String>();
	/**
	 * 服务配置
	 */
	protected ProcessServiceConfig config;

	
	public AbstractProcess(String name,ProcessServiceConfig config){
		this.name = name;
		this.config = config;
	}
	
	/**
	 *  线程执行主体流程体系聚合
	  * @Title: run
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param 
	  * @throws
	  * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = true;
		long begtime = System.currentTimeMillis();
		try {
			begin();
			before();
			st = connection.createStatement();
			String sql = config.getSql();
			LogCvt.info("执行SQL："+sql);
			if(sql != null && !"".equals(sql.trim())){
				rs = st.executeQuery(sql);
				ResultSetMetaData metadata = rs.getMetaData();
				int columnCount = metadata.getColumnCount();
				for(int i= 1; i <= columnCount;i++){
					columnList.add(metadata.getColumnName(i));
				}
			}
			process();
		} catch (Exception e) {
			flag = false;
			exception(e);
		} finally{
			end();
			// 进行下一个任务
			if(flag){
				next();
			}
			logger.info("数据转移,模块名["+name+"]结束,耗时:"+(System.currentTimeMillis()-begtime)+"毫秒");
		}
	}
	
	/**
	 *  初始化相关信息
	  * @Title: begin
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param 
	  * @throws
	  * @see com.froad.process.Process#begin()
	 */
	@Override
	public void begin() {
		// TODO Auto-generated method stub
		logger.info("转移模块["+name+"]开始...");
		try {
			/**
			 *  初始化数据库连接
			 */
			connection = JDBCUtil.getConnection();
			LogCvt.debug("open-获取数据库连接");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(),e);
		}
	
		
	}
	
	/**
	 *  处理完成后续事情
	  * @Title: end
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param 
	  * @throws
	  * @see com.froad.process.Process#end()
	 */
	@Override
	public void end() {
		// TODO Auto-generated method stub
		try {
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(connection != null){
				LogCvt.debug("close-关闭数据库连接");
				connection.close();
			}
			
		} catch (Exception e) {
			logger.error("关闭数据连接异常...",e);
		}
		
	}

	/**
	 * 异常处理
	  * @Title: exception
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param @param e
	  * @throws
	  * @see com.froad.process.Process#exception(java.lang.Exception)
	 */
	@Override
		// TODO Auto-generated method stub
	public void exception(Exception e) {
		// 异常回滚信息
		logger.error("程序处理异常,mysql数据进行异常回滚...", e);
		logger.error("转移模块["+name+"]异常,无法执行下一模块["+config.getServiceNext()+"]");
	}

	/**
	 *  下一步
	  * @Title: next
	  * @Description: TODO
	  * @author: share 2015年4月29日
	  * @modify: share 2015年4月29日
	  * @param @param config
	  * @throws
	  * @see com.froad.process.Process#next(com.froad.config.Config)
	 */
	@Override
	public void next() {
		// TODO Auto-generated method stub
		ServicePool.nextService(config);
	}
	
	
}

