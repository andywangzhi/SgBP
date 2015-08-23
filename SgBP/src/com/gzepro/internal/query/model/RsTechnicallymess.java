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
 * RsTechnicallymess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_TECHNICALLYMESS")
public class RsTechnicallymess implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4635404184460487269L;
	private String techid;
	private RsPerson rsPerson;
	private String technicallytype;
	private String technicallylevel;
	private Date assessdate;
	private String premark;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;

	// Constructors

	/** default constructor */
	public RsTechnicallymess() {
	}



	// Property accessors
	@Id
	@Column(name = "TECHID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getTechid() {
		return this.techid;
	}

	public void setTechid(String techid) {
		this.techid = techid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONID", nullable = false)
	public RsPerson getRsPerson() {
		return this.rsPerson;
	}

	public void setRsPerson(RsPerson rsPerson) {
		this.rsPerson = rsPerson;
	}

	@Column(name = "TECHNICALLYTYPE", nullable = false, length = 40)
	public String getTechnicallytype() {
		return this.technicallytype;
	}

	public void setTechnicallytype(String technicallytype) {
		this.technicallytype = technicallytype;
	}

	@Column(name = "TECHNICALLYLEVEL", nullable = false, length = 2)
	public String getTechnicallylevel() {
		return this.technicallylevel;
	}

	public void setTechnicallylevel(String technicallylevel) {
		this.technicallylevel = technicallylevel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ASSESSDATE", length = 7)
	public Date getAssessdate() {
		return this.assessdate;
	}

	public void setAssessdate(Date assessdate) {
		this.assessdate = assessdate;
	}

	@Column(name = "PREMARK", length = 50)
	public String getPremark() {
		return this.premark;
	}

	public void setPremark(String premark) {
		this.premark = premark;
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