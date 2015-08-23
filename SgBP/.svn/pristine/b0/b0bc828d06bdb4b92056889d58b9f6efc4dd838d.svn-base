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

import org.hibernate.annotations.GenericGenerator;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Entity 
@Table(name="MSTB_DATACHANGEDETAIL") //表名
public class ChangeDetail implements java.io.Serializable{
	
    @Id  
    @Column(name="ID",unique = true, nullable = false, length = 35)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
    
    private String id;
    
    @Column(name="IDCARD",length = 50, nullable = true)
	private String idcard;
	
	@Column(name="DCHANGDETAIL",length = 50, nullable = true)
	private String dchangdetail;
	
	@Column(name="DCHANGTYPE",length = 50, nullable = true)
	private String dchangtype;
	
	@Column(name="DCHANGTIME",length = 50, nullable = true)
	private String dchangtime;
	
	@Column(name="DREMARK",length = 200, nullable = true)
	private String dremark;
	
	@Column(name="CHANGEDATE",length = 35, nullable = true)
	private String changedate;
	
	@Column(name="CHECKSTATE",length = 35, nullable = true)
	private String checkstate;
	
	public ChangeDetail(String id, String idcard, String dchangdetail,
			String dchangtype, String dchangtime, String dremark) {
		super();
		this.id = id;
		this.idcard = idcard;
		this.dchangdetail = dchangdetail;
		this.dchangtype = dchangtype;
		this.dchangtime = dchangtime;
		this.dremark = dremark;
	}

	public ChangeDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getDchangdetail() {
		return dchangdetail;
	}

	public void setDchangdetail(String dchangdetail) {
		this.dchangdetail = dchangdetail;
	}

	public String getDchangtype() {
		return dchangtype;
	}

	public void setDchangtype(String dchangtype) {
		this.dchangtype = dchangtype;
	}

	public String getDchangtime() {
		return dchangtime;
	}

	public void setDchangtime(String dchangtime) {
		this.dchangtime = dchangtime;
	}

	public String getDremark() {
		return dremark;
	}

	public void setDremark(String dremark) {
		this.dremark = dremark;
	}

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public String getCheckstate() {
		return checkstate;
	}

	public void setCheckstate(String checkstate) {
		this.checkstate = checkstate;
	}



	
}