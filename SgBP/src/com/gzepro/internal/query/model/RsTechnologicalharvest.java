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
 * RsTechnologicalharvest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_TECHNOLOGICALHARVEST")
public class RsTechnologicalharvest implements java.io.Serializable {

	private static final long serialVersionUID = 808732715999790178L;
	private String harvestid;
	private RsPerson rsPerson;
	private Date assessdate;
	private String harvestlevel;
	private String harvestname;
	private String assessdep;
	private String pdemo;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;

	// Constructors

	/** default constructor */
	public RsTechnologicalharvest() {
	}



	// Property accessors
	@Id
	@Column(name = "HARVESTID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getHarvestid() {
		return this.harvestid;
	}

	public void setHarvestid(String harvestid) {
		this.harvestid = harvestid;
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
	@Column(name = "ASSESSDATE", nullable = false, length = 7)
	public Date getAssessdate() {
		return this.assessdate;
	}

	public void setAssessdate(Date assessdate) {
		this.assessdate = assessdate;
	}

	@Column(name = "HARVESTLEVEL", nullable = false, length = 10)
	public String getHarvestlevel() {
		return this.harvestlevel;
	}

	public void setHarvestlevel(String harvestlevel) {
		this.harvestlevel = harvestlevel;
	}

	@Column(name = "HARVESTNAME", nullable = false, length = 40)
	public String getHarvestname() {
		return this.harvestname;
	}

	public void setHarvestname(String harvestname) {
		this.harvestname = harvestname;
	}

	@Column(name = "ASSESSDEP", nullable = false, length = 40)
	public String getAssessdep() {
		return this.assessdep;
	}

	public void setAssessdep(String assessdep) {
		this.assessdep = assessdep;
	}

	@Column(name = "PDEMO", length = 200)
	public String getPdemo() {
		return this.pdemo;
	}

	public void setPdemo(String pdemo) {
		this.pdemo = pdemo;
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