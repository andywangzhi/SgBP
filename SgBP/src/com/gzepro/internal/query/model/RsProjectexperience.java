package com.gzepro.internal.query.model;

import java.math.BigDecimal;
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
 * RsProjectexperience entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_PROJECTEXPERIENCE")
public class RsProjectexperience implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7731912311932465488L;
	private String experienceid;
	private RsPerson rsPerson;
	private Date fromdate;
	private Date todate;
	private BigDecimal personnum;
	private String projname;
	private Double projmoney;
	private String projresponsibility;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;

	// Constructors

	/** default constructor */
	public RsProjectexperience() {
	}



	// Property accessors
	@Id
	@Column(name = "EXPERIENCEID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getExperienceid() {
		return this.experienceid;
	}

	public void setExperienceid(String experienceid) {
		this.experienceid = experienceid;
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

	@Column(name = "PERSONNUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPersonnum() {
		return this.personnum;
	}

	public void setPersonnum(BigDecimal personnum) {
		this.personnum = personnum;
	}

	@Column(name = "PROJNAME", nullable = false, length = 40)
	public String getProjname() {
		return this.projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	@Column(name = "PROJMONEY", precision = 18)
	public Double getProjmoney() {
		return this.projmoney;
	}

	public void setProjmoney(Double projmoney) {
		this.projmoney = projmoney;
	}

	@Column(name = "PROJRESPONSIBILITY", length = 200)
	public String getProjresponsibility() {
		return this.projresponsibility;
	}

	public void setProjresponsibility(String projresponsibility) {
		this.projresponsibility = projresponsibility;
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