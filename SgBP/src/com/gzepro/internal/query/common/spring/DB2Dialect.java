package com.gzepro.internal.query.common.spring;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class DB2Dialect extends org.hibernate.dialect.DB2Dialect{
	@Override
	public String getCrossJoinSeparator() {
		return ", ";
	}
}
