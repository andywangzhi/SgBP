/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl;

/**
 * 工作经历详细信息查询条件
 */
public class RetrieveWorkexperienceSO {
	private String personId;//个人信息ID
	private String workId;//工作经历ID
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
}
