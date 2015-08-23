package com.gzepro.internal.query.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Entity 
@Table(name="MSTB_SYS_DATACHANGETIME") //表名
public class ChangeTime implements java.io.Serializable{
    @Id  
    @Column(name="ID")
    private String id;
	
	public ChangeTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChangeTime(String id, String dlastchangetime, String dchangehours,
			String dchangeminute, String discanchange) {
		super();
		this.id = id;
		this.dlastchangetime = dlastchangetime;
		this.dchangehours = dchangehours;
		this.dchangeminute = dchangeminute;
		this.discanchange = discanchange;
	}

	@Column(name="DLASTCHANGETIME",length = 50, nullable = true)
	private String dlastchangetime;
	
	@Column(name="DCHANGEHOURS",length = 50, nullable = false)
	private String dchangehours;
	
	@Column(name="DCHANGEMINUTE",length = 50, nullable = false)
	private String dchangeminute;
	
	@Column(name="DISCANCHANGE",length = 50, nullable = false)
	private String discanchange;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDlastchangetime() {
		return dlastchangetime;
	}

	public void setDlastchangetime(String dlastchangetime) {
		this.dlastchangetime = dlastchangetime;
	}

	public String getDchangehours() {
		return dchangehours;
	}

	public void setDchangehours(String dchangehours) {
		this.dchangehours = dchangehours;
	}

	public String getDchangeminute() {
		return dchangeminute;
	}

	public void setDchangeminute(String dchangeminute) {
		this.dchangeminute = dchangeminute;
	}

	public String getDiscanchange() {
		return discanchange;
	}

	public void setDiscanchange(String discanchange) {
		this.discanchange = discanchange;
	}

	
}