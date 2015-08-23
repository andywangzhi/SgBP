/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl;

/**
 * 工作经历列表查询条件
 */
public class QueryWorkexperienceListSO {
	private String workId;    //工作经历ID
	private String personId;  //个人信息ID
	private String fromDate;     //从何年何月
	private String toDate;       //至何年何月
	private String companyName;  //单位名称
	private String pposition;    //从事岗位或领域
	
	private String adduser;
	private String adddate;
	private String modifyuser;
	private String modifydate;
	
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPposition() {
		return pposition;
	}
	public void setPposition(String pposition) {
		this.pposition = pposition;
	}
	public String getAdduser() {
		return adduser;
	}
	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public String getModifyuser() {
		return modifyuser;
	}
	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	
}
