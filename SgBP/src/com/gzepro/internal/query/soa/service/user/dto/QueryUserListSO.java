package com.gzepro.internal.query.soa.service.user.dto;

/**
 * 用户列表查询条件
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class QueryUserListSO {
    private String userId;//用户ID
    private String userName;//用户名称
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
