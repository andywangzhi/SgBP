package com.gzepro.internal.query.common.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * Jdbc的特有查询接口
 * 
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface SpringJdbcQueryManager {
	/**
	 * @param sql
	 *            SQL命令，没有参数
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql);

	/**
	 * @param sql
	 *            SQL命令，带有参数?。例如：select * from user where age > ? and gender = ?
	 * @param args
	 *            参数数组，与sql中?出现的顺序一致。
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql, Object[] args);

	/**
	 * @param sql
	 *            SQL命令，带有命名参数。例如：select * from user where age > :age and gender
	 *            =:gender
	 * @param namedParametersMap
	 *            参数Map，key是参数名称，例如"age"；value是参数值。
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql, Map namedParametersMap);

	/**
	 * @param sql
	 *            SQL命令，没有参数
	 * 
	 * @param rm
	 *            ResultReader实例。
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql, RowMapper rm);

	/**
	 * @param sql
	 *            SQL命令，带有参数?。例如：select * from user where age > ? and gender = ?
	 * @param args
	 *            参数数组，与sql中?出现的顺序一致。
	 * 
	 * @param rm
	 *            ResultReader实例。
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql, Object[] args, RowMapper rm);

	/**
	 * @param sql
	 *            SQL命令，带有命名参数。例如：select * from user where age > :age and gender =
	 *            :gender
	 * @param namedParametersMap
	 *            参数Map，key是参数名称，例如"age"；value是参数值。
	 * 
	 * @param rm
	 *            ResultReader实例。
	 * 
	 * @return List<Map>
	 */
	public List springJdbcQueryForList(String sql, Map namedParametersMap,
			RowMapper rm);

	/**
	 * @param sql
	 *            SQL命令，没有参数。
	 * 
	 * @param requiredType返回对象的类型
	 * 
	 * @return 查询结果对象。
	 * 
	 */
	public Object springJdbcQueryForObject(String sql, Class requiredType);

	/**
	 * @param sql
	 *            SQL命令，带有参数?。例如：select name from user where id=?
	 * @param args参数数组，与sql中?出现的顺序一致。
	 * 
	 * @param requiredType返回对象的类型
	 * 
	 * @return 查询结果对象。
	 * 
	 */
	public Object springJdbcQueryForObject(String sql, Object[] args,
			Class requiredType);

	/**
	 * @param sql
	 *            SQL命令，带有参数?。例如：select name from user where id=?
	 * @param namedParametersMap
	 *            参数Map，key是参数名称，例如"id"；value是参数值。
	 * 
	 * @param requiredType返回对象的类型
	 * 
	 * @return 查询结果对象。
	 * 
	 */
	public Object springJdbcQueryForObject(String sql, Map namedParametersMap,
			Class requiredType);

	/**
	 * @param SQL
	 */
	public void execute(String SQL);

	/**
	 * @param SQL
	 *            SQL命令，带有参数?。例如：select name from user where id=?
	 * @param obj
	 *            参数数组，与sql中?出现的顺序一致。
	 * 
	 */
	public void update(String SQL, Object[] obj);

}
