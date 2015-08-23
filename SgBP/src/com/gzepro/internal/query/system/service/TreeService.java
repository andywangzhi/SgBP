package com.gzepro.internal.query.system.service;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface TreeService {
	/**
	 * 加截登陆用户的菜单.只支持两级 返回的是Json格式
	 */
	public String loadUserMenuForJson(Long accountId,int lang);
	
	public String loadAllUrl();
	/**
	 * 通过用户id获得用户的身份
	 * @param accountId 用户Id
	 * @return 1 为超级管理员 2系统管理员 3组管理员 4普通用户
	 */
	public int checkAccountDist(Long accountId);
}

