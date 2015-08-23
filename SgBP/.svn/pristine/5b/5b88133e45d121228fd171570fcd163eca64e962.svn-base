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
 * RsEducationexperience entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_EDUCATIONEXPERIENCE")
public class RsEducationexperience implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3310534956894104610L;
	private String educationid;
	private RsPerson rsPerson;
	private Date fromdate;
	private Date todate;
	private String pcollege;
	private String specialtyname;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;
	private String xxlx;//学校类型

	// Constructors

	/** default constructor */
	public RsEducationexperience() {
	}


	// Property accessors
	@Id
	@Column(name = "EDUCATIONID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getEducationid() {
		return this.educationid;
	}

	public void setEducationid(String educationid) {
		this.educationid = educationid;
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

	@Column(name = "PCOLLEGE", nullable = false, length = 40)
	public String getPcollege() {
		return this.pcollege;
	}

	public void setPcollege(String pcollege) {
		this.pcollege = pcollege;
	}

	@Column(name = "SPECIALTYNAME", nullable = false, length = 40)
	public String getSpecialtyname() {
		return this.specialtyname;
	}

	public void setSpecialtyname(String specialtyname) {
		this.specialtyname = specialtyname;
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

	@Column(name = "XXLX", length = 2)
	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
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