package com.gzepro.internal.query.soa.service.user.dto.rcsm.base;

/**
 * 
  * @ClassName: QueryRsPersonListSO
  * @Description: TODO(用户列表查询条件)
  * @author 张建薇
  * @date Jul 24, 2012 7:13:14 PM
  *
 */
public class QueryRsPersonListSO {
	
	private String personId;//个人信息ID
	private String pname;	//姓名
	private String psex;	//性别
	private String pnation;	//民族
	private String ppolityvisage;	//政治面貌
	private String idCard;	//公民身份号码
	private String pbirthday;	//出生年月
	private String registeraddrprov;//(新增加字段)
	private String registeraddrcity;//(新增加字段)
	private String cultureType;	//文化程度
	private String specialtyName;	//专业名称
	private String specialtytype;//(新增加字段)
	private String pphoto;	//照片
	private String messageAddr;	//通讯地址
	private String pphone;	//联系电话
	private String pemail;	//电子邮箱
	private String ppost;	//邮编
	private String ptrade;	//现所在行业
	private String ptradeother;//(新增加字段)
	private String pcounty;	//所在县区
	private String pquarters;	//现从事岗位
	private String pquartersother;//(新增加字段)
	private String workCompany;	//现就业单位名称
	private String dutylevel;//(新增加字段)
	private String economyKind;	//单位性质
	private String economykindother;//(新增加字段)
	private String personType;	//人才类型
	private String specialtyStrong;	//专业特长
	private String technicallyMess;	//职称信息
	private String poperator;	//填表人员
	private String operationalDate;	//填表日期
	
	//以下字段修改时间2012-08-11
	private String auditstate;
	private String delestate;
	private String premark;
	private String graduatecollege;
	private String culturetypeother;
	private String adduser;
	private String adddate;
	private String modifyuser;
	private String modifydate;
	private String deleuser;
	private String deledate;
	private String checkuser;
	private String checkdate;
	private String validateuser;
	private String validatedate;
	private String audituser;
	private String auditdate;
	private String sourcetype;
	private String batchcode;
	private String fromDate;
	private String toDate;
	private String technicallyType;//职称技能专业名称ok
	private String technicallyLevel;//职称技能级别ok
	private String harvestName;//科技成果名称ok
	private String harvestLevel;//成果级别
	private String corpName;//单位名称
	private String assessDep;//发证单位
	private String forage;//开始年龄
	private String toage;//结束年龄
	private String personKind;//人才分类
	
	private String auditdetaildate;
	 private String unitlvl;//单位隶属
    public String getAuditdetaildate() {
		return auditdetaildate;
	}
	public void setAuditdetaildate(String auditdetaildate) {
		this.auditdetaildate = auditdetaildate;
	}
	
    private String deleapplystate;	// 删除 启用状态
    private String auditapplystate;	// 审核 	启用状态
	
	public String getDeleapplystate() {
		return deleapplystate;
	}
	public void setDeleapplystate(String deleapplystate) {
		this.deleapplystate = deleapplystate;
	}
	public String getAuditapplystate() {
		return auditapplystate;
	}
	public void setAuditapplystate(String auditapplystate) {
		this.auditapplystate = auditapplystate;
	}
	//组合查询时间
	private String dateStr;
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public String getPnation() {
		return pnation;
	}
	public void setPnation(String pnation) {
		this.pnation = pnation;
	}
	public String getPpolityvisage() {
		return ppolityvisage;
	}
	public void setPpolityvisage(String ppolityvisage) {
		this.ppolityvisage = ppolityvisage;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPbirthday() {
		return pbirthday;
	}
	public void setPbirthday(String pbirthday) {
		this.pbirthday = pbirthday;
	}
	public String getRegisteraddrprov() {
		return registeraddrprov;
	}
	public void setRegisteraddrprov(String registeraddrprov) {
		this.registeraddrprov = registeraddrprov;
	}
	public String getRegisteraddrcity() {
		return registeraddrcity;
	}
	public void setRegisteraddrcity(String registeraddrcity) {
		this.registeraddrcity = registeraddrcity;
	}
	public String getCultureType() {
		return cultureType;
	}
	public void setCultureType(String cultureType) {
		this.cultureType = cultureType;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public String getSpecialtytype() {
		return specialtytype;
	}
	public void setSpecialtytype(String specialtytype) {
		this.specialtytype = specialtytype;
	}
	public String getPphoto() {
		return pphoto;
	}
	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}
	public String getMessageAddr() {
		return messageAddr;
	}
	public void setMessageAddr(String messageAddr) {
		this.messageAddr = messageAddr;
	}
	public String getPphone() {
		return pphone;
	}
	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPpost() {
		return ppost;
	}
	public void setPpost(String ppost) {
		this.ppost = ppost;
	}
	public String getPtrade() {
		return ptrade;
	}
	public void setPtrade(String ptrade) {
		this.ptrade = ptrade;
	}
	public String getPtradeother() {
		return ptradeother;
	}
	public void setPtradeother(String ptradeother) {
		this.ptradeother = ptradeother;
	}
	public String getPcounty() {
		return pcounty;
	}
	public void setPcounty(String pcounty) {
		this.pcounty = pcounty;
	}
	public String getPquarters() {
		return pquarters;
	}
	public void setPquarters(String pquarters) {
		this.pquarters = pquarters;
	}
	public String getPquartersother() {
		return pquartersother;
	}
	public void setPquartersother(String pquartersother) {
		this.pquartersother = pquartersother;
	}
	public String getWorkCompany() {
		return workCompany;
	}
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}
	public String getDutylevel() {
		return dutylevel;
	}
	public void setDutylevel(String dutylevel) {
		this.dutylevel = dutylevel;
	}
	public String getEconomyKind() {
		return economyKind;
	}
	public void setEconomyKind(String economyKind) {
		this.economyKind = economyKind;
	}
	public String getEconomykindother() {
		return economykindother;
	}
	public void setEconomykindother(String economykindother) {
		this.economykindother = economykindother;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getSpecialtyStrong() {
		return specialtyStrong;
	}
	public void setSpecialtyStrong(String specialtyStrong) {
		this.specialtyStrong = specialtyStrong;
	}
	public String getTechnicallyMess() {
		return technicallyMess;
	}
	public void setTechnicallyMess(String technicallyMess) {
		this.technicallyMess = technicallyMess;
	}
	public String getPoperator() {
		return poperator;
	}
	public void setPoperator(String poperator) {
		this.poperator = poperator;
	}
	public String getOperationalDate() {
		return operationalDate;
	}
	public void setOperationalDate(String operationalDate) {
		this.operationalDate = operationalDate;
	}
	public String getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}
	public String getDelestate() {
		return delestate;
	}
	public void setDelestate(String delestate) {
		this.delestate = delestate;
	}
	public String getPremark() {
		return premark;
	}
	public void setPremark(String premark) {
		this.premark = premark;
	}
	public String getGraduatecollege() {
		return graduatecollege;
	}
	public void setGraduatecollege(String graduatecollege) {
		this.graduatecollege = graduatecollege;
	}
	public String getCulturetypeother() {
		return culturetypeother;
	}
	public void setCulturetypeother(String culturetypeother) {
		this.culturetypeother = culturetypeother;
	}
	public String getAdduser() {
		return adduser;
	}
	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public String getModifyuser() {
		return modifyuser;
	}
	public void setModifyuser(String modifyuser) {
		this.modifyuser = modifyuser;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	public String getDeleuser() {
		return deleuser;
	}
	public void setDeleuser(String deleuser) {
		this.deleuser = deleuser;
	}
	public String getDeledate() {
		return deledate;
	}
	public void setDeledate(String deledate) {
		this.deledate = deledate;
	}
	public String getCheckuser() {
		return checkuser;
	}
	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getValidateuser() {
		return validateuser;
	}
	public void setValidateuser(String validateuser) {
		this.validateuser = validateuser;
	}
	public String getValidatedate() {
		return validatedate;
	}
	public void setValidatedate(String validatedate) {
		this.validatedate = validatedate;
	}
	public String getAudituser() {
		return audituser;
	}
	public void setAudituser(String audituser) {
		this.audituser = audituser;
	}
	public String getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(String auditdate) {
		this.auditdate = auditdate;
	}
	public String getSourcetype() {
		return sourcetype;
	}
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	public String getBatchcode() {
		return batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getUnitlvl() {
		return unitlvl;
	}
	public void setUnitlvl(String unitlvl) {
		this.unitlvl = unitlvl;
	}
	public String getTechnicallyType() {
		return technicallyType;
	}
	public void setTechnicallyType(String technicallyType) {
		this.technicallyType = technicallyType;
	}
	public String getTechnicallyLevel() {
		return technicallyLevel;
	}
	public void setTechnicallyLevel(String technicallyLevel) {
		this.technicallyLevel = technicallyLevel;
	}
	public String getHarvestLevel() {
		return harvestLevel;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getAssessDep() {
		return assessDep;
	}
	public void setAssessDep(String assessDep) {
		this.assessDep = assessDep;
	}
	public void setHarvestLevel(String harvestLevel) {
		this.harvestLevel = harvestLevel;
	}
	public String getForage() {
		return forage;
	}
	public void setForage(String forage) {
		this.forage = forage;
	}
	public String getToage() {
		return toage;
	}
	public void setToage(String toage) {
		this.toage = toage;
	}
	public String getHarvestName() {
		return harvestName;
	}
	public void setHarvestName(String harvestName) {
		this.harvestName = harvestName;
	}
	public String getPersonKind() {
		return personKind;
	}
	public void setPersonKind(String personKind) {
		this.personKind = personKind;
	}
	
}
