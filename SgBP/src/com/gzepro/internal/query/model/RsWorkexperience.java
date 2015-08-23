package com.gzepro.internal.query.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * RsWorkexperience entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_WORKEXPERIENCE")
public class RsWorkexperience implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4959889290632299605L;
	private String workid;
	private RsPerson rsPerson;
	private Date fromdate;
	private Date todate;
	private String companyname;
	private String pposition;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;

	// Constructors

	/** default constructor */
	public RsWorkexperience() {
	}

	

	// Property accessors
	@Id
	@Column(name = "WORKID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getWorkid() {
		return this.workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONID", nullable = false)
	public RsPerson getRsPerson() {
		return this.rsPerson;
	}

	public void setRsPerson(RsPerson rsPerson) {
		this.rsPerson = rsPerson;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FROMDATE", nullable = false, length = 7)
	public Date getFromdate() {
		return this.fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TODATE", nullable = false, length = 7)
	public Date getTodate() {
		return this.todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	@Column(name = "COMPANYNAME", nullable = false, length = 40)
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Column(name = "PPOSITION", length = 20)
	public String getPposition() {
		return this.pposition;
	}

	public void setPposition(String pposition) {
		this.pposition = pposition;
	}

	@Column(name = "ADDUSER", nullable = false, length = 32)
	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ADDDATE", nullable = false, length = 7)
	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	@Column(name = "MODIFYUSER", length = 32)
	public String getModifyuser() {
		return this.modifyuser;
	}

	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE", length = 7)
	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

}