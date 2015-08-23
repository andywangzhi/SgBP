package com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj;

import java.util.ArrayList;
import java.util.List;

import com.gzepro.internal.query.model.RsBatchlog;

public class BatchlogForm {

	private String lognumber;
	private String fromDate;
	private String toDate;
	private String adduser;
	private String typeid;
	private List<RsBatchlog> dtoList = new ArrayList<RsBatchlog>();
	
	public BatchlogForm() {
	}
	public String getLognumber() {
		return lognumber;
	}
	public void setLognumber(String lognumber) {
		this.lognumber = lognumber;
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
	public String getAdduser() {
		return adduser;
	}
	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public List<RsBatchlog> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<RsBatchlog> dtoList) {
		this.dtoList = dtoList;
	}
	
}
