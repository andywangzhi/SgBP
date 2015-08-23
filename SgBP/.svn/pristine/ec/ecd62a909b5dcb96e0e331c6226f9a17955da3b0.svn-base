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
 * RsAffix entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_AFFIX")
public class RsAffix implements java.io.Serializable {

	private static final long serialVersionUID = 1742228661386323123L;
	private String affixid;
	private RsPerson rsPerson;
	private String affixname;
	private String barcode;
	private String uploadperson;
	private Date uploaddate;
	private String affixstyle;
	private String affixtype;
	private String affixcontext;
	private String deleuser;
	private Date deledate;
	private String modifyuser;
	private Date modifydate;
	private String checkuser;
	private Date checkdate;
	private String validateuser;
	private Date validatedate;
	private String audituser;
	private Date auditdate;
	private String delestate;
	private String auditstate;

	// Constructors

	/** default constructor */
	public RsAffix() {
	}



	// Property accessors
	@Id
	@Column(name = "AFFIXID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getAffixid() {
		return this.affixid;
	}

	public void setAffixid(String affixid) {
		this.affixid = affixid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONID", nullable = false)
	public RsPerson getRsPerson() {
		return this.rsPerson;
	}

	public void setRsPerson(RsPerson rsPerson) {
		this.rsPerson = rsPerson;
	}

	@Column(name = "AFFIXNAME", nullable = false, length = 50)
	public String getAffixname() {
		return this.affixname;
	}

	public void setAffixname(String affixname) {
		this.affixname = affixname;
	}

	@Column(name = "BARCODE", length = 32)
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(name = "UPLOADPERSON", nullable = false, length = 32)
	public String getUploadperson() {
		return this.uploadperson;
	}

	public void setUploadperson(String uploadperson) {
		this.uploadperson = uploadperson;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOADDATE", nullable = false, length = 7)
	public Date getUploaddate() {
		return this.uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	@Column(name = "AFFIXSTYLE", nullable = false, length = 2)
	public String getAffixstyle() {
		return this.affixstyle;
	}

	public void setAffixstyle(String affixstyle) {
		this.affixstyle = affixstyle;
	}

	@Column(name = "AFFIXTYPE", nullable = false, length = 2)
	public String getAffixtype() {
		return this.affixtype;
	}

	public void setAffixtype(String affixtype) {
		this.affixtype = affixtype;
	}

	@Column(name = "AFFIXCONTEXT", nullable = false)
	public String getAffixcontext() {
		return this.affixcontext;
	}

	public void setAffixcontext(String affixcontext) {
		this.affixcontext = affixcontext;
	}

	@Column(name = "DELEUSER", length = 32)
	public String getDeleuser() {
		return this.deleuser;
	}

	public void setDeleuser(String deleuser) {
		this.deleuser = deleuser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DELEDATE", length = 7)
	public Date getDeledate() {
		return this.deledate;
	}

	public void setDeledate(Date deledate) {
		this.deledate = deledate;
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

	@Column(name = "CHECKUSER", length = 32)
	public String getCheckuser() {
		return this.checkuser;
	}

	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHECKDATE", length = 7)
	public Date getCheckdate() {
		return this.checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	@Column(name = "VALIDATEUSER", length = 32)
	public String getValidateuser() {
		return this.validateuser;
	}

	public void setValidateuser(String validateuser) {
		this.validateuser = validateuser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDATEDATE", length = 7)
	public Date getValidatedate() {
		return this.validatedate;
	}

	public void setValidatedate(Date validatedate) {
		this.validatedate = validatedate;
	}

	@Column(name = "AUDITUSER", length = 32)
	public String getAudituser() {
		return this.audituser;
	}

	public void setAudituser(String audituser) {
		this.audituser = audituser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AUDITDATE", length = 7)
	public Date getAuditdate() {
		return this.auditdate;
	}

	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}

	@Column(name = "DELESTATE", nullable = false, length = 1)
	public String getDelestate() {
		return this.delestate;
	}

	public void setDelestate(String delestate) {
		this.delestate = delestate;
	}

	@Column(name = "AUDITSTATE", nullable = false, length = 3)
	public String getAuditstate() {
		return this.auditstate;
	}

	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}

}