/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj;

/**
 * 人才统计查询条件
 */
public class QueryRctjListSO {
	private int forDate;//开始时间
	private int todate;//结束时间
	private String Pcounty;//区县
	private String specialtyType;// 专业类型
	private String technicallytype;//职称级别
	public int getForDate() {
		return forDate;
	}
	public void setForDate(int forDate) {
		this.forDate = forDate;
	}
	public int getTodate() {
		return todate;
	}
	public void setTodate(int todate) {
		this.todate = todate;
	}
	public String getPcounty() {
		return Pcounty;
	}
	public void setPcounty(String pcounty) {
		Pcounty = pcounty;
	}
	public String getSpecialtyType() {
		return specialtyType;
	}
	public void setSpecialtyType(String specialtyType) {
		this.specialtyType = specialtyType;
	}
	public String getTechnicallytype() {
		return technicallytype;
	}
	public void setTechnicallytype(String technicallytype) {
		this.technicallytype = technicallytype;
	}

}
