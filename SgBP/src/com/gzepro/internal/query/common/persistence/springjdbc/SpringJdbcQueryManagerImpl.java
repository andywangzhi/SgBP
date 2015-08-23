package com.gzepro.internal.query.common.persistence.springjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.persistence.SpringJdbcQueryManager;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("springJdbcQueryManager")
public class SpringJdbcQueryManagerImpl implements
		SpringJdbcQueryManager {
	
	private JdbcTemplate jdbcTemplate;
	
	@Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
    	this.jdbcTemplate=jdbcTemplate;
    } 
	
	public List springJdbcQueryForList(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	public List springJdbcQueryForList(String sql, Object[] args) {
		return jdbcTemplate.queryForList(sql, args);
	}

	public List springJdbcQueryForList(String sql, Map namedParametersMap) {
		Convert c = new Convert(sql, namedParametersMap);
		return this.springJdbcQueryForList(c.getSql(), c.getArgs());
	}
	
	
	
	public List springJdbcQueryForList(String sql, RowMapper rm) {
		return jdbcTemplate.query(sql, rm);
	}

	public List springJdbcQueryForList(String sql, Object[] args, RowMapper rm) {
		return jdbcTemplate.query(sql, args, rm);
	}

	public List springJdbcQueryForList(String sql, Map namedParametersMap,RowMapper rm) {
		Convert c = new Convert(sql, namedParametersMap);
		return this.springJdbcQueryForList(c.getSql(), c.getArgs(), rm);
	}
	
	
	
	public Object springJdbcQueryForObject(String sql, Class requiredType) {
		return jdbcTemplate.queryForObject(sql, requiredType);
	}

	public Object springJdbcQueryForObject(String sql, Object[] args,
			Class requiredType) {
		return jdbcTemplate.queryForObject(sql, args, requiredType);
	}

	public Object springJdbcQueryForObject(String sql, Map namedParametersMap,Class requiredType) {
		Convert c = new Convert(sql, namedParametersMap);
		return this.springJdbcQueryForObject(c.getSql(), c.getArgs(),
				requiredType);
	}
	
	public void execute(String SQL) {
		jdbcTemplate.execute(SQL);
	}
	
	public void update(String SQL, Object[] obj) {
		jdbcTemplate.update(SQL, obj);
	}

	/**
	 * 将命名参数转换为数组参数
	 */
	private static class Convert {

		private String sql;

		private Object[] args;

		public Convert(String namedParametersSQL, Map namedParametersMap) {
			if (namedParametersMap == null || namedParametersMap.isEmpty()) {
				this.setSql(namedParametersSQL);
				this.setArgs(null);
				return;
			}
			List argList = new ArrayList(namedParametersMap.size());
			StringBuffer sb = new StringBuffer(namedParametersSQL);
			int fromIndex = 0;
			while (true) {
				int i = sb.indexOf(":", fromIndex);
				if (i < 0)
					break;
				int j = this.indexOfEnd(sb, i);
				String key = sb.substring(i + 1, j);
				Object o = namedParametersMap.get(key);
				argList.add(o);
				sb.replace(i, j, "?");
				fromIndex = i;
			}
			this.setSql(sb.toString());
			this.setArgs(argList.toArray());
		}

		private int indexOfEnd(StringBuffer sb, int fromIndex) {
			int j1 = this.indexOf(sb, " ", fromIndex);
			int j2 = this.indexOf(sb, "\n", fromIndex);
			int j3 = this.indexOf(sb, "\t", fromIndex);
			int j4 = this.indexOf(sb, "\r", fromIndex);
			int j5 = this.indexOf(sb, ")", fromIndex);
			int j = min(j1, j2);
			j = min(j, j3);
			j = min(j, j4);
			return min(j, j5);
		}

		private int min(int a, int b) {
			return (a < b ? a : b);
		}

		private int indexOf(StringBuffer sb, String searchString, int fromIndex) {
			int j = sb.indexOf(searchString, fromIndex);
			if (j < 0) {
				return sb.length();
			} else {
				return j;
			}
		}

		public Object[] getArgs() {
			return args;
		}

		public void setArgs(Object[] args) {
			this.args = args;
		}

		public String getSql() {
			return sql;
		}

		public void setSql(String sql) {
			this.sql = sql;
		}
	}

}
