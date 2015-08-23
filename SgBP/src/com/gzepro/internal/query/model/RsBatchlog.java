package com.gzepro.internal.query.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * RsBatchlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_BATCHLOG")
public class RsBatchlog implements java.io.Serializable {

	private static final long serialVersionUID = -1053188021233568493L;
	private String logid;
	private String lognumber;
	private String typeid;
	private String adduser;
	private Date adddate;
	private Long total =new Long(0);
	private Long successcount =new Long(0);
	private Long failcount =new Long(0);
	private String errorlog ;
	private StringBuffer errorlogs =new StringBuffer();

	// Constructors

	/** default constructor */
	public RsBatchlog() {
	}

	
	// Property accessors
	@Id
	@Column(name = "LOGID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getLogid() {
		return this.logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	@Column(name = "LOGNUMBER", nullable = false, length = 32)
	public String getLognumber() {
		return this.lognumber;
	}

	public void setLognumber(String lognumber) {
		this.lognumber = lognumber;
	}

	@Column(name = "TYPEID", nullable = false, length = 40)
	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	@Column(name = "ADDUSER", nullable = false, length = 32)
	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	@Temporal(value = TemporalType.TIMESTAMP) 
	@Column(name = "ADDDATE", nullable = false, length = 7)
	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	@Column(name = "TOTAL", precision = 22, scale = 0)
	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	public void setTotals() {
		this.total = this.total+1;
	}

	@Column(name = "SUCCESSCOUNT", precision = 22, scale = 0)
	public Long getSuccesscount() {
		return this.successcount;
	}

	public void setSuccesscount(Long successcount) {
		this.successcount = successcount;
	}
	
	public void setSuccesscounts() {
		this.successcount = this.successcount+1;
	}

	@Column(name = "FAILCOUNT", precision = 22, scale = 0)
	public Long getFailcount() {
		return this.failcount;
	}

	public void setFailcounts() {
		this.failcount = this.failcount+1;
	}

	public void setFailcount(Long failcount) {
		this.failcount = failcount;
	}

	@Type(type="text")
	@Column(name = "ERRORLOG" )
	public String getErrorlog() {
		this.errorlog=(this.errorlogs==null?"":this.errorlogs.toString());
		return this.errorlog;
	}

	
	public void setErrorlog(String errorlog) {
		this.errorlog = errorlog;
		if(errorlog!=null){
			this.errorlogs=new StringBuffer(errorlog);
		}else{
			this.errorlogs=new StringBuffer("");
		}
		
	}

	@Transient
	public StringBuffer getErrorlogs() {
		return this.errorlogs;
	}

}