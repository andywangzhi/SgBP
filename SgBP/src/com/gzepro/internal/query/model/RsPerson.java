package com.gzepro.internal.query.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * RsPerson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_PERSON")
public class RsPerson implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1075145805944277642L;
	private String personid;
	private String pname;
	private String psex;
	private String pnation;
	private String ppolityvisage;
	private String idcard;
	private Date pbirthday;
	private String registeraddrprov;
	private String registeraddrcity;
	private String culturetype;
	private String specialtyname;
	private String specialtytype;
	private String pphoto;
	private String messageaddr;
	private String pphone;
	private String pemail;
	private String ppost;
	private String ptrade;
	private String ptradeother;
	private String pcounty;
	private String pquarters;
	private String pquartersother;
	private String workcompany;
	private String dutylevel;
	private String economykind;
	private String economykindother;
	private String persontype;
	private String specialtystrong;
	private String technicallymess;
	private String poperator;
	private Date operationaldate;
	private String auditstate;
	private String delestate;
	private String premark;
	private String graduatecollege;
	private String culturetypeother;
	private String adduser;
	private Date adddate;
	private String modifyuser;
	private Date modifydate;
	private String deleuser;
	private Date deledate;
	private String checkuser;
	private Date checkdate;
	private String validateuser;
	private Date validatedate;
	private String audituser;
	private Date auditdate;
	private String sourcetype;
	private String batchcode;
	private String deleapplystate;
	private String auditapplystate;
	private java.lang.String auditdetaildate;
	private String unitlvl;//单位隶属
	private String xllb;// 学历类别
	private String yjfx;// 研究方向

	// Constructors

	/** default constructor */
	public RsPerson() {
	}

	
	// Property accessors
	@Id
	@Column(name = "PERSONID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	@Column(name = "PNAME", nullable = false, length = 32)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "PSEX", nullable = false, length = 2)
	public String getPsex() {
		return this.psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	@Column(name = "PNATION", length = 2)
	public String getPnation() {
		return this.pnation;
	}

	public void setPnation(String pnation) {
		this.pnation = pnation;
	}

	@Column(name = "PPOLITYVISAGE", length = 2)
	public String getPpolityvisage() {
		return this.ppolityvisage;
	}

	public void setPpolityvisage(String ppolityvisage) {
		this.ppolityvisage = ppolityvisage;
	}

	@Column(name = "IDCARD", unique = true, nullable = false, length = 18)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PBIRTHDAY", nullable = false, length = 7)
	public Date getPbirthday() {
		return this.pbirthday;
	}

	public void setPbirthday(Date pbirthday) {
		this.pbirthday = pbirthday;
	}

	@Column(name = "REGISTERADDRPROV", length = 2)
	public String getRegisteraddrprov() {
		return this.registeraddrprov;
	}

	public void setRegisteraddrprov(String registeraddrprov) {
		this.registeraddrprov = registeraddrprov;
	}

	@Column(name = "REGISTERADDRCITY", length = 3)
	public String getRegisteraddrcity() {
		return this.registeraddrcity;
	}

	public void setRegisteraddrcity(String registeraddrcity) {
		this.registeraddrcity = registeraddrcity;
	}

	@Column(name = "CULTURETYPE", length = 2)
	public String getCulturetype() {
		return this.culturetype;
	}

	public void setCulturetype(String culturetype) {
		this.culturetype = culturetype;
	}

	@Column(name = "SPECIALTYNAME", length = 40)
	public String getSpecialtyname() {
		return this.specialtyname;
	}

	public void setSpecialtyname(String specialtyname) {
		this.specialtyname = specialtyname;
	}

	@Column(name = "SPECIALTYTYPE", length = 2)
	public String getSpecialtytype() {
		return this.specialtytype;
	}

	public void setSpecialtytype(String specialtytype) {
		this.specialtytype = specialtytype;
	}

	@Column(name = "PPHOTO")
	public String getPphoto() {
		return this.pphoto;
	}

	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}

	@Column(name = "MESSAGEADDR", length = 100)
	public String getMessageaddr() {
		return this.messageaddr;
	}

	public void setMessageaddr(String messageaddr) {
		this.messageaddr = messageaddr;
	}

	@Column(name = "PPHONE", nullable = false, length = 40)
	public String getPphone() {
		return this.pphone;
	}

	public void setPphone(String pphone) {
		this.pphone = pphone;
	}

	@Column(name = "PEMAIL", length = 40)
	public String getPemail() {
		return this.pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	@Column(name = "PPOST", length = 6)
	public String getPpost() {
		return this.ppost;
	}

	public void setPpost(String ppost) {
		this.ppost = ppost;
	}

	@Column(name = "PTRADE", nullable = false, length = 2)
	public String getPtrade() {
		return this.ptrade;
	}

	public void setPtrade(String ptrade) {
		this.ptrade = ptrade;
	}

	@Column(name = "PTRADEOTHER", length = 40)
	public String getPtradeother() {
		return this.ptradeother;
	}

	public void setPtradeother(String ptradeother) {
		this.ptradeother = ptradeother;
	}

	@Column(name = "PCOUNTY", nullable = false, length = 2)
	public String getPcounty() {
		return this.pcounty;
	}

	public void setPcounty(String pcounty) {
		this.pcounty = pcounty;
	}

	@Column(name = "PQUARTERS", length = 2)
	public String getPquarters() {
		return this.pquarters;
	}

	public void setPquarters(String pquarters) {
		this.pquarters = pquarters;
	}

	@Column(name = "PQUARTERSOTHER", length = 40)
	public String getPquartersother() {
		return this.pquartersother;
	}

	public void setPquartersother(String pquartersother) {
		this.pquartersother = pquartersother;
	}

	@Column(name = "WORKCOMPANY", length = 100)
	public String getWorkcompany() {
		return this.workcompany;
	}

	public void setWorkcompany(String workcompany) {
		this.workcompany = workcompany;
	}

	@Column(name = "DUTYLEVEL", length = 20)
	public String getDutylevel() {
		return this.dutylevel;
	}

	public void setDutylevel(String dutylevel) {
		this.dutylevel = dutylevel;
	}

	@Column(name = "ECONOMYKIND", length = 2)
	public String getEconomykind() {
		return this.economykind;
	}

	public void setEconomykind(String economykind) {
		this.economykind = economykind;
	}

	@Column(name = "ECONOMYKINDOTHER", length = 20)
	public String getEconomykindother() {
		return this.economykindother;
	}

	public void setEconomykindother(String economykindother) {
		this.economykindother = economykindother;
	}

	@Column(name = "PERSONTYPE", length = 32)
	public String getPersontype() {
		return this.persontype;
	}

	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	@Column(name = "SPECIALTYSTRONG", length = 200)
	public String getSpecialtystrong() {
		return this.specialtystrong;
	}

	public void setSpecialtystrong(String specialtystrong) {
		this.specialtystrong = specialtystrong;
	}

	@Column(name = "TECHNICALLYMESS", length = 50)
	public String getTechnicallymess() {
		return this.technicallymess;
	}

	public void setTechnicallymess(String technicallymess) {
		this.technicallymess = technicallymess;
	}

	@Column(name = "POPERATOR", nullable = false, length = 32)
	public String getPoperator() {
		return this.poperator;
	}

	public void setPoperator(String poperator) {
		this.poperator = poperator;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPERATIONALDATE", nullable = false, length = 7)
	public Date getOperationaldate() {
		return this.operationaldate;
	}

	public void setOperationaldate(Date operationaldate) {
		this.operationaldate = operationaldate;
	}

	@Column(name = "AUDITSTATE", nullable = false, length = 5)
	public String getAuditstate() {
		return this.auditstate;
	}

	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}

	@Column(name = "DELESTATE", nullable = false, length = 1)
	public String getDelestate() {
		return this.delestate;
	}

	public void setDelestate(String delestate) {
		this.delestate = delestate;
	}

	@Column(name = "PREMARK", length = 200)
	public String getPremark() {
		return this.premark;
	}

	public void setPremark(String premark) {
		this.premark = premark;
	}

	@Column(name = "GRADUATECOLLEGE", length = 50)
	public String getGraduatecollege() {
		return this.graduatecollege;
	}

	public void setGraduatecollege(String graduatecollege) {
		this.graduatecollege = graduatecollege;
	}

	@Column(name = "CULTURETYPEOTHER", length = 32)
	public String getCulturetypeother() {
		return this.culturetypeother;
	}

	public void setCulturetypeother(String culturetypeother) {
		this.culturetypeother = culturetypeother;
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

	@Column(name = "SOURCETYPE", length = 32)
	public String getSourcetype() {
		return this.sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	@Column(name = "BATCHCODE", length = 50)
	public String getBatchcode() {
		return this.batchcode;
	}

	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}
	@Column(name = "DELEAPPLYSTATE", length = 1)
	public String getDeleapplystate() {
		return this.deleapplystate;
	}

	public void setDeleapplystate(String deleapplystate) {
		this.deleapplystate = deleapplystate;
	}

	@Column(name = "AUDITAPPLYSTATE", length = 1)
	public String getAuditapplystate() {
		return this.auditapplystate;
	}

	public void setAuditapplystate(String auditapplystate) {
		this.auditapplystate = auditapplystate;
	}
	
	
	@Column(name = "AUDITDETAILDATE", length = 50)
    public String getAuditdetaildate() {
		return auditdetaildate;
	}
	public void setAuditdetaildate(String auditdetaildate) {
		this.auditdetaildate = auditdetaildate;
	}
	
	@Column(name = "UNITLVL", length =2 )
	public String getUnitlvl() {
		return unitlvl;
	}
	public void setUnitlvl(String unitlvl) {
		this.unitlvl = unitlvl;
	}

	@Column(name = "XLLB", length =2 )
	public String getXllb() {
		return xllb;
	}

	public void setXllb(String xllb) {
		this.xllb = xllb;
	}

	@Column(name = "YJFX", length =2 )
	public String getYjfx() {
		return yjfx;
	}

	public void setYjfx(String yjfx) {
		this.yjfx = yjfx;
	}

	
}