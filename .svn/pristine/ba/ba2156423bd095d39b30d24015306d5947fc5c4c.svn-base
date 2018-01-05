package com.qbt.mybatis.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.ReflectHelper;


/**
 *用于实现自动分页
* <p>Function: SQLInterceptor</p>
* <p>Description: 自动分页实现</p>
* @author zhaoxy@thankjava.com
* @date 2014-12-18 上午10:30:29
* @version 1.0
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageSQLInterceptor implements Interceptor {

	
	public Object intercept(Invocation invocation) throws Throwable {
		
		if (!(invocation.getTarget() instanceof StatementHandler)) {
			return invocation.proceed();
		}
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		
		// 分离代理对象链
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		
		//获取sql参数对象
		Object parameterObject = boundSql.getParameterObject();
		
		if(parameterObject == null){
			return invocation.proceed();
		}else{
			if(parameterObject instanceof PageEntity){ //如果传入的参数是PageEntity则需要分页处理
				doPageEntityProcess(invocation, metaStatementHandler, boundSql, (PageEntity)parameterObject,parameterObject); 
			}else if(parameterObject instanceof Map){
			    Map<String, Object> params = (Map)parameterObject;
			    for(Map.Entry<String, Object> paramter : params.entrySet()){
			        if(paramter.getKey()==null||paramter.getKey().startsWith("param")){
			            continue;
			        }
			        if(paramter.getValue() instanceof PageEntity){
			            doPageEntityProcess(invocation, metaStatementHandler, boundSql,(PageEntity)paramter.getValue(),parameterObject); 
			        }
			    }
			}
			return invocation.proceed();
		}
	}

    private void doPageEntityProcess(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, PageEntity pageEntity,Object params) {
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        // 获取源生sql
        String sql = boundSql.getSql();
        //设置分页总条数，分页总页数
        ReflectHelper.invokeMethod(pageEntity, ReflectHelper.getMethod(pageEntity, "setTotalCount", int.class), getTotalCount(sql, params, metaStatementHandler, invocation,mappedStatement,boundSql));
        //将源sql拼接分页sql
        metaStatementHandler.setValue("delegate.boundSql.sql", buildPageSQL(sql,pageEntity));
    }

	/**
	 * 为SQL设置limit分页
	* <p>Function: buildPageSQL</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2014-12-17 下午6:37:37
	* @version 1.0
	* @param sql
	* @param pageEntity
	* @return
	 */
	private String buildPageSQL(String sql,PageEntity<?> pageEntity) {
	    if(sql.toLowerCase().contains(" limit ")){
	        return sql;
	    }
	    
		StringBuffer buffer = new StringBuffer(sql);
		
		//反射分页属性
		int pageSize = (Integer)ReflectHelper.getFieldVal(pageEntity, "pageSize");
		int pageNumber = (Integer)ReflectHelper.getFieldVal(pageEntity, "pageNumber");
		
		int limitIndex = (pageNumber - 1) * pageSize ; //计算实际数据库的分页下标
		int limitSize = pageSize;
		buffer.append(" limit " + limitIndex);
		buffer.append(" , " + limitSize);
		return buffer.toString();
	}

	/**
	 * 获取总数据条数
	* <p>Function: buildCountSQL</p>
	* <p>Description: 将源分页对象反射总数据条数，总页数</p>
	* @author zhaoxy@thankjava.com
	* @date 2014-12-17 下午6:42:43
	* @version 1.0
	* @param sql
	* @param pageEntity
	* @param metaStatementHandler
	* @param invocation
	* @return
	 */
	private int getTotalCount(String sql,Object params,MetaObject metaStatementHandler,Invocation invocation,MappedStatement mappedStatement,BoundSql sourceSql) {
		metaStatementHandler.setValue("delegate.boundSql.sql", sql);
		Connection con = (Connection) invocation.getArgs()[0];//获取创建连接
		PreparedStatement ps = null;  
        ResultSet rs = null;
        String lowerCaseSql = sql.toLowerCase();
		try {
			if(lowerCaseSql.contains("order by")){
				lowerCaseSql = lowerCaseSql.substring(0, lowerCaseSql.indexOf("order by"));
			}
			String autoCountSQL = null;
			if(lowerCaseSql.contains("group ")){
			    autoCountSQL = "select count(0) from (".concat(lowerCaseSql).concat(") as ct");
			}else{
			    autoCountSQL = "select count(0) from " + lowerCaseSql.substring(lowerCaseSql.indexOf("from ") + 4);
			}
			ps = con.prepareStatement(autoCountSQL);
			BoundSql boundSql = mappedStatement.getBoundSql(params);
			setCountSQLParameters(ps, mappedStatement, boundSql, boundSql.getParameterObject());  
			rs = ps.executeQuery();
	        if (rs.next()) {  
	            return rs.getInt(1);//获取count(0) 的返回结果
	        }
	        rs.close();
	        ps.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return 0;
	}

	/**
	 * 将sql和参数进行绑定设值
	* <p>Function: setCountSQLParameters</p>
	* <p>Description: </p>
	* @author zhaoxy@thankjava.com
	* @date 2014-12-18 上午11:44:55
	* @version 1.0
	* @param ps
	* @param mappedStatement
	* @param boundSql
	* @param parameterObject
	 */
	private void setCountSQLParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,Object parameterObject){  
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
		try {
			parameterHandler.setParameters(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
	
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {}

}
