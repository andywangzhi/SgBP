/**
 * RsPersonVo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.base;

public class RsPersonVo  implements java.io.Serializable {
    private int adddate;

    private java.lang.String adduser;

    private java.lang.String auditapplystate;

    private int auditdate;

    private java.lang.String auditdetaildate;

    private java.lang.String auditstate;

    private java.lang.String audituser;

    private java.lang.String batchcode;

    private int checkdate;

    private java.lang.String checkuser;

    private java.lang.String cultureType;

    private java.lang.String culturetypeother;

    private java.lang.String deleapplystate;

    private int deledate;

    private java.lang.String delestate;

    private java.lang.String deleuser;

    private java.lang.String dutylevel;

    private java.lang.String economyKind;

    private java.lang.String economykindother;

    private java.lang.String graduatecollege;

    private java.lang.String idCard;

    private java.lang.String messageAddr;

    private int modifydate;

    private java.lang.String modifyuser;

    private int operationalDate;

    private int pbirthday;

    private java.lang.String pcounty;

    private java.lang.String pemail;

    private java.lang.String personId;

    private java.lang.String personType;

    private java.lang.String pname;

    private java.lang.String pnation;

    private java.lang.String poperator;

    private java.lang.String pphone;

    private java.lang.String pphoto;

    private java.lang.String ppolityvisage;

    private java.lang.String ppost;

    private java.lang.String pquarters;

    private java.lang.String pquartersother;

    private java.lang.String premark;

    private java.lang.String psex;

    private java.lang.String ptrade;

    private java.lang.String ptradeother;

    private java.lang.String registeraddrcity;

    private java.lang.String registeraddrprov;

    private java.lang.String sourcetype;

    private java.lang.String specialtyName;

    private java.lang.String specialtyStrong;

    private java.lang.String specialtytype;

    private java.lang.String technicallyMess;

    private java.lang.String unitlvl;

    private int validatedate;

    private java.lang.String validateuser;

    private java.lang.String workCompany;

    private java.lang.String xllb;

    private java.lang.String yjfx;

    public RsPersonVo() {
    }

    public RsPersonVo(
           int adddate,
           java.lang.String adduser,
           java.lang.String auditapplystate,
           int auditdate,
           java.lang.String auditdetaildate,
           java.lang.String auditstate,
           java.lang.String audituser,
           java.lang.String batchcode,
           int checkdate,
           java.lang.String checkuser,
           java.lang.String cultureType,
           java.lang.String culturetypeother,
           java.lang.String deleapplystate,
           int deledate,
           java.lang.String delestate,
           java.lang.String deleuser,
           java.lang.String dutylevel,
           java.lang.String economyKind,
           java.lang.String economykindother,
           java.lang.String graduatecollege,
           java.lang.String idCard,
           java.lang.String messageAddr,
           int modifydate,
           java.lang.String modifyuser,
           int operationalDate,
           int pbirthday,
           java.lang.String pcounty,
           java.lang.String pemail,
           java.lang.String personId,
           java.lang.String personType,
           java.lang.String pname,
           java.lang.String pnation,
           java.lang.String poperator,
           java.lang.String pphone,
           java.lang.String pphoto,
           java.lang.String ppolityvisage,
           java.lang.String ppost,
           java.lang.String pquarters,
           java.lang.String pquartersother,
           java.lang.String premark,
           java.lang.String psex,
           java.lang.String ptrade,
           java.lang.String ptradeother,
           java.lang.String registeraddrcity,
           java.lang.String registeraddrprov,
           java.lang.String sourcetype,
           java.lang.String specialtyName,
           java.lang.String specialtyStrong,
           java.lang.String specialtytype,
           java.lang.String technicallyMess,
           java.lang.String unitlvl,
           int validatedate,
           java.lang.String validateuser,
           java.lang.String workCompany,
           java.lang.String xllb,
           java.lang.String yjfx) {
           this.adddate = adddate;
           this.adduser = adduser;
           this.auditapplystate = auditapplystate;
           this.auditdate = auditdate;
           this.auditdetaildate = auditdetaildate;
           this.auditstate = auditstate;
           this.audituser = audituser;
           this.batchcode = batchcode;
           this.checkdate = checkdate;
           this.checkuser = checkuser;
           this.cultureType = cultureType;
           this.culturetypeother = culturetypeother;
           this.deleapplystate = deleapplystate;
           this.deledate = deledate;
           this.delestate = delestate;
           this.deleuser = deleuser;
           this.dutylevel = dutylevel;
           this.economyKind = economyKind;
           this.economykindother = economykindother;
           this.graduatecollege = graduatecollege;
           this.idCard = idCard;
           this.messageAddr = messageAddr;
           this.modifydate = modifydate;
           this.modifyuser = modifyuser;
           this.operationalDate = operationalDate;
           this.pbirthday = pbirthday;
           this.pcounty = pcounty;
           this.pemail = pemail;
           this.personId = personId;
           this.personType = personType;
           this.pname = pname;
           this.pnation = pnation;
           this.poperator = poperator;
           this.pphone = pphone;
           this.pphoto = pphoto;
           this.ppolityvisage = ppolityvisage;
           this.ppost = ppost;
           this.pquarters = pquarters;
           this.pquartersother = pquartersother;
           this.premark = premark;
           this.psex = psex;
           this.ptrade = ptrade;
           this.ptradeother = ptradeother;
           this.registeraddrcity = registeraddrcity;
           this.registeraddrprov = registeraddrprov;
           this.sourcetype = sourcetype;
           this.specialtyName = specialtyName;
           this.specialtyStrong = specialtyStrong;
           this.specialtytype = specialtytype;
           this.technicallyMess = technicallyMess;
           this.unitlvl = unitlvl;
           this.validatedate = validatedate;
           this.validateuser = validateuser;
           this.workCompany = workCompany;
           this.xllb = xllb;
           this.yjfx = yjfx;
    }


    /**
     * Gets the adddate value for this RsPersonVo.
     * 
     * @return adddate
     */
    public int getAdddate() {
        return adddate;
    }


    /**
     * Sets the adddate value for this RsPersonVo.
     * 
     * @param adddate
     */
    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }


    /**
     * Gets the adduser value for this RsPersonVo.
     * 
     * @return adduser
     */
    public java.lang.String getAdduser() {
        return adduser;
    }


    /**
     * Sets the adduser value for this RsPersonVo.
     * 
     * @param adduser
     */
    public void setAdduser(java.lang.String adduser) {
        this.adduser = adduser;
    }


    /**
     * Gets the auditapplystate value for this RsPersonVo.
     * 
     * @return auditapplystate
     */
    public java.lang.String getAuditapplystate() {
        return auditapplystate;
    }


    /**
     * Sets the auditapplystate value for this RsPersonVo.
     * 
     * @param auditapplystate
     */
    public void setAuditapplystate(java.lang.String auditapplystate) {
        this.auditapplystate = auditapplystate;
    }


    /**
     * Gets the auditdate value for this RsPersonVo.
     * 
     * @return auditdate
     */
    public int getAuditdate() {
        return auditdate;
    }


    /**
     * Sets the auditdate value for this RsPersonVo.
     * 
     * @param auditdate
     */
    public void setAuditdate(int auditdate) {
        this.auditdate = auditdate;
    }


    /**
     * Gets the auditdetaildate value for this RsPersonVo.
     * 
     * @return auditdetaildate
     */
    public java.lang.String getAuditdetaildate() {
        return auditdetaildate;
    }


    /**
     * Sets the auditdetaildate value for this RsPersonVo.
     * 
     * @param auditdetaildate
     */
    public void setAuditdetaildate(java.lang.String auditdetaildate) {
        this.auditdetaildate = auditdetaildate;
    }


    /**
     * Gets the auditstate value for this RsPersonVo.
     * 
     * @return auditstate
     */
    public java.lang.String getAuditstate() {
        return auditstate;
    }


    /**
     * Sets the auditstate value for this RsPersonVo.
     * 
     * @param auditstate
     */
    public void setAuditstate(java.lang.String auditstate) {
        this.auditstate = auditstate;
    }


    /**
     * Gets the audituser value for this RsPersonVo.
     * 
     * @return audituser
     */
    public java.lang.String getAudituser() {
        return audituser;
    }


    /**
     * Sets the audituser value for this RsPersonVo.
     * 
     * @param audituser
     */
    public void setAudituser(java.lang.String audituser) {
        this.audituser = audituser;
    }


    /**
     * Gets the batchcode value for this RsPersonVo.
     * 
     * @return batchcode
     */
    public java.lang.String getBatchcode() {
        return batchcode;
    }


    /**
     * Sets the batchcode value for this RsPersonVo.
     * 
     * @param batchcode
     */
    public void setBatchcode(java.lang.String batchcode) {
        this.batchcode = batchcode;
    }


    /**
     * Gets the checkdate value for this RsPersonVo.
     * 
     * @return checkdate
     */
    public int getCheckdate() {
        return checkdate;
    }


    /**
     * Sets the checkdate value for this RsPersonVo.
     * 
     * @param checkdate
     */
    public void setCheckdate(int checkdate) {
        this.checkdate = checkdate;
    }


    /**
     * Gets the checkuser value for this RsPersonVo.
     * 
     * @return checkuser
     */
    public java.lang.String getCheckuser() {
        return checkuser;
    }


    /**
     * Sets the checkuser value for this RsPersonVo.
     * 
     * @param checkuser
     */
    public void setCheckuser(java.lang.String checkuser) {
        this.checkuser = checkuser;
    }


    /**
     * Gets the cultureType value for this RsPersonVo.
     * 
     * @return cultureType
     */
    public java.lang.String getCultureType() {
        return cultureType;
    }


    /**
     * Sets the cultureType value for this RsPersonVo.
     * 
     * @param cultureType
     */
    public void setCultureType(java.lang.String cultureType) {
        this.cultureType = cultureType;
    }


    /**
     * Gets the culturetypeother value for this RsPersonVo.
     * 
     * @return culturetypeother
     */
    public java.lang.String getCulturetypeother() {
        return culturetypeother;
    }


    /**
     * Sets the culturetypeother value for this RsPersonVo.
     * 
     * @param culturetypeother
     */
    public void setCulturetypeother(java.lang.String culturetypeother) {
        this.culturetypeother = culturetypeother;
    }


    /**
     * Gets the deleapplystate value for this RsPersonVo.
     * 
     * @return deleapplystate
     */
    public java.lang.String getDeleapplystate() {
        return deleapplystate;
    }


    /**
     * Sets the deleapplystate value for this RsPersonVo.
     * 
     * @param deleapplystate
     */
    public void setDeleapplystate(java.lang.String deleapplystate) {
        this.deleapplystate = deleapplystate;
    }


    /**
     * Gets the deledate value for this RsPersonVo.
     * 
     * @return deledate
     */
    public int getDeledate() {
        return deledate;
    }


    /**
     * Sets the deledate value for this RsPersonVo.
     * 
     * @param deledate
     */
    public void setDeledate(int deledate) {
        this.deledate = deledate;
    }


    /**
     * Gets the delestate value for this RsPersonVo.
     * 
     * @return delestate
     */
    public java.lang.String getDelestate() {
        return delestate;
    }


    /**
     * Sets the delestate value for this RsPersonVo.
     * 
     * @param delestate
     */
    public void setDelestate(java.lang.String delestate) {
        this.delestate = delestate;
    }


    /**
     * Gets the deleuser value for this RsPersonVo.
     * 
     * @return deleuser
     */
    public java.lang.String getDeleuser() {
        return deleuser;
    }


    /**
     * Sets the deleuser value for this RsPersonVo.
     * 
     * @param deleuser
     */
    public void setDeleuser(java.lang.String deleuser) {
        this.deleuser = deleuser;
    }


    /**
     * Gets the dutylevel value for this RsPersonVo.
     * 
     * @return dutylevel
     */
    public java.lang.String getDutylevel() {
        return dutylevel;
    }


    /**
     * Sets the dutylevel value for this RsPersonVo.
     * 
     * @param dutylevel
     */
    public void setDutylevel(java.lang.String dutylevel) {
        this.dutylevel = dutylevel;
    }


    /**
     * Gets the economyKind value for this RsPersonVo.
     * 
     * @return economyKind
     */
    public java.lang.String getEconomyKind() {
        return economyKind;
    }


    /**
     * Sets the economyKind value for this RsPersonVo.
     * 
     * @param economyKind
     */
    public void setEconomyKind(java.lang.String economyKind) {
        this.economyKind = economyKind;
    }


    /**
     * Gets the economykindother value for this RsPersonVo.
     * 
     * @return economykindother
     */
    public java.lang.String getEconomykindother() {
        return economykindother;
    }


    /**
     * Sets the economykindother value for this RsPersonVo.
     * 
     * @param economykindother
     */
    public void setEconomykindother(java.lang.String economykindother) {
        this.economykindother = economykindother;
    }


    /**
     * Gets the graduatecollege value for this RsPersonVo.
     * 
     * @return graduatecollege
     */
    public java.lang.String getGraduatecollege() {
        return graduatecollege;
    }


    /**
     * Sets the graduatecollege value for this RsPersonVo.
     * 
     * @param graduatecollege
     */
    public void setGraduatecollege(java.lang.String graduatecollege) {
        this.graduatecollege = graduatecollege;
    }


    /**
     * Gets the idCard value for this RsPersonVo.
     * 
     * @return idCard
     */
    public java.lang.String getIdCard() {
        return idCard;
    }


    /**
     * Sets the idCard value for this RsPersonVo.
     * 
     * @param idCard
     */
    public void setIdCard(java.lang.String idCard) {
        this.idCard = idCard;
    }


    /**
     * Gets the messageAddr value for this RsPersonVo.
     * 
     * @return messageAddr
     */
    public java.lang.String getMessageAddr() {
        return messageAddr;
    }


    /**
     * Sets the messageAddr value for this RsPersonVo.
     * 
     * @param messageAddr
     */
    public void setMessageAddr(java.lang.String messageAddr) {
        this.messageAddr = messageAddr;
    }


    /**
     * Gets the modifydate value for this RsPersonVo.
     * 
     * @return modifydate
     */
    public int getModifydate() {
        return modifydate;
    }


    /**
     * Sets the modifydate value for this RsPersonVo.
     * 
     * @param modifydate
     */
    public void setModifydate(int modifydate) {
        this.modifydate = modifydate;
    }


    /**
     * Gets the modifyuser value for this RsPersonVo.
     * 
     * @return modifyuser
     */
    public java.lang.String getModifyuser() {
        return modifyuser;
    }


    /**
     * Sets the modifyuser value for this RsPersonVo.
     * 
     * @param modifyuser
     */
    public void setModifyuser(java.lang.String modifyuser) {
        this.modifyuser = modifyuser;
    }


    /**
     * Gets the operationalDate value for this RsPersonVo.
     * 
     * @return operationalDate
     */
    public int getOperationalDate() {
        return operationalDate;
    }


    /**
     * Sets the operationalDate value for this RsPersonVo.
     * 
     * @param operationalDate
     */
    public void setOperationalDate(int operationalDate) {
        this.operationalDate = operationalDate;
    }


    /**
     * Gets the pbirthday value for this RsPersonVo.
     * 
     * @return pbirthday
     */
    public int getPbirthday() {
        return pbirthday;
    }


    /**
     * Sets the pbirthday value for this RsPersonVo.
     * 
     * @param pbirthday
     */
    public void setPbirthday(int pbirthday) {
        this.pbirthday = pbirthday;
    }


    /**
     * Gets the pcounty value for this RsPersonVo.
     * 
     * @return pcounty
     */
    public java.lang.String getPcounty() {
        return pcounty;
    }


    /**
     * Sets the pcounty value for this RsPersonVo.
     * 
     * @param pcounty
     */
    public void setPcounty(java.lang.String pcounty) {
        this.pcounty = pcounty;
    }


    /**
     * Gets the pemail value for this RsPersonVo.
     * 
     * @return pemail
     */
    public java.lang.String getPemail() {
        return pemail;
    }


    /**
     * Sets the pemail value for this RsPersonVo.
     * 
     * @param pemail
     */
    public void setPemail(java.lang.String pemail) {
        this.pemail = pemail;
    }


    /**
     * Gets the personId value for this RsPersonVo.
     * 
     * @return personId
     */
    public java.lang.String getPersonId() {
        return personId;
    }


    /**
     * Sets the personId value for this RsPersonVo.
     * 
     * @param personId
     */
    public void setPersonId(java.lang.String personId) {
        this.personId = personId;
    }


    /**
     * Gets the personType value for this RsPersonVo.
     * 
     * @return personType
     */
    public java.lang.String getPersonType() {
        return personType;
    }


    /**
     * Sets the personType value for this RsPersonVo.
     * 
     * @param personType
     */
    public void setPersonType(java.lang.String personType) {
        this.personType = personType;
    }


    /**
     * Gets the pname value for this RsPersonVo.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this RsPersonVo.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the pnation value for this RsPersonVo.
     * 
     * @return pnation
     */
    public java.lang.String getPnation() {
        return pnation;
    }


    /**
     * Sets the pnation value for this RsPersonVo.
     * 
     * @param pnation
     */
    public void setPnation(java.lang.String pnation) {
        this.pnation = pnation;
    }


    /**
     * Gets the poperator value for this RsPersonVo.
     * 
     * @return poperator
     */
    public java.lang.String getPoperator() {
        return poperator;
    }


    /**
     * Sets the poperator value for this RsPersonVo.
     * 
     * @param poperator
     */
    public void setPoperator(java.lang.String poperator) {
        this.poperator = poperator;
    }


    /**
     * Gets the pphone value for this RsPersonVo.
     * 
     * @return pphone
     */
    public java.lang.String getPphone() {
        return pphone;
    }


    /**
     * Sets the pphone value for this RsPersonVo.
     * 
     * @param pphone
     */
    public void setPphone(java.lang.String pphone) {
        this.pphone = pphone;
    }


    /**
     * Gets the pphoto value for this RsPersonVo.
     * 
     * @return pphoto
     */
    public java.lang.String getPphoto() {
        return pphoto;
    }


    /**
     * Sets the pphoto value for this RsPersonVo.
     * 
     * @param pphoto
     */
    public void setPphoto(java.lang.String pphoto) {
        this.pphoto = pphoto;
    }


    /**
     * Gets the ppolityvisage value for this RsPersonVo.
     * 
     * @return ppolityvisage
     */
    public java.lang.String getPpolityvisage() {
        return ppolityvisage;
    }


    /**
     * Sets the ppolityvisage value for this RsPersonVo.
     * 
     * @param ppolityvisage
     */
    public void setPpolityvisage(java.lang.String ppolityvisage) {
        this.ppolityvisage = ppolityvisage;
    }


    /**
     * Gets the ppost value for this RsPersonVo.
     * 
     * @return ppost
     */
    public java.lang.String getPpost() {
        return ppost;
    }


    /**
     * Sets the ppost value for this RsPersonVo.
     * 
     * @param ppost
     */
    public void setPpost(java.lang.String ppost) {
        this.ppost = ppost;
    }


    /**
     * Gets the pquarters value for this RsPersonVo.
     * 
     * @return pquarters
     */
    public java.lang.String getPquarters() {
        return pquarters;
    }


    /**
     * Sets the pquarters value for this RsPersonVo.
     * 
     * @param pquarters
     */
    public void setPquarters(java.lang.String pquarters) {
        this.pquarters = pquarters;
    }


    /**
     * Gets the pquartersother value for this RsPersonVo.
     * 
     * @return pquartersother
     */
    public java.lang.String getPquartersother() {
        return pquartersother;
    }


    /**
     * Sets the pquartersother value for this RsPersonVo.
     * 
     * @param pquartersother
     */
    public void setPquartersother(java.lang.String pquartersother) {
        this.pquartersother = pquartersother;
    }


    /**
     * Gets the premark value for this RsPersonVo.
     * 
     * @return premark
     */
    public java.lang.String getPremark() {
        return premark;
    }


    /**
     * Sets the premark value for this RsPersonVo.
     * 
     * @param premark
     */
    public void setPremark(java.lang.String premark) {
        this.premark = premark;
    }


    /**
     * Gets the psex value for this RsPersonVo.
     * 
     * @return psex
     */
    public java.lang.String getPsex() {
        return psex;
    }


    /**
     * Sets the psex value for this RsPersonVo.
     * 
     * @param psex
     */
    public void setPsex(java.lang.String psex) {
        this.psex = psex;
    }


    /**
     * Gets the ptrade value for this RsPersonVo.
     * 
     * @return ptrade
     */
    public java.lang.String getPtrade() {
        return ptrade;
    }


    /**
     * Sets the ptrade value for this RsPersonVo.
     * 
     * @param ptrade
     */
    public void setPtrade(java.lang.String ptrade) {
        this.ptrade = ptrade;
    }


    /**
     * Gets the ptradeother value for this RsPersonVo.
     * 
     * @return ptradeother
     */
    public java.lang.String getPtradeother() {
        return ptradeother;
    }


    /**
     * Sets the ptradeother value for this RsPersonVo.
     * 
     * @param ptradeother
     */
    public void setPtradeother(java.lang.String ptradeother) {
        this.ptradeother = ptradeother;
    }


    /**
     * Gets the registeraddrcity value for this RsPersonVo.
     * 
     * @return registeraddrcity
     */
    public java.lang.String getRegisteraddrcity() {
        return registeraddrcity;
    }


    /**
     * Sets the registeraddrcity value for this RsPersonVo.
     * 
     * @param registeraddrcity
     */
    public void setRegisteraddrcity(java.lang.String registeraddrcity) {
        this.registeraddrcity = registeraddrcity;
    }


    /**
     * Gets the registeraddrprov value for this RsPersonVo.
     * 
     * @return registeraddrprov
     */
    public java.lang.String getRegisteraddrprov() {
        return registeraddrprov;
    }


    /**
     * Sets the registeraddrprov value for this RsPersonVo.
     * 
     * @param registeraddrprov
     */
    public void setRegisteraddrprov(java.lang.String registeraddrprov) {
        this.registeraddrprov = registeraddrprov;
    }


    /**
     * Gets the sourcetype value for this RsPersonVo.
     * 
     * @return sourcetype
     */
    public java.lang.String getSourcetype() {
        return sourcetype;
    }


    /**
     * Sets the sourcetype value for this RsPersonVo.
     * 
     * @param sourcetype
     */
    public void setSourcetype(java.lang.String sourcetype) {
        this.sourcetype = sourcetype;
    }


    /**
     * Gets the specialtyName value for this RsPersonVo.
     * 
     * @return specialtyName
     */
    public java.lang.String getSpecialtyName() {
        return specialtyName;
    }


    /**
     * Sets the specialtyName value for this RsPersonVo.
     * 
     * @param specialtyName
     */
    public void setSpecialtyName(java.lang.String specialtyName) {
        this.specialtyName = specialtyName;
    }


    /**
     * Gets the specialtyStrong value for this RsPersonVo.
     * 
     * @return specialtyStrong
     */
    public java.lang.String getSpecialtyStrong() {
        return specialtyStrong;
    }


    /**
     * Sets the specialtyStrong value for this RsPersonVo.
     * 
     * @param specialtyStrong
     */
    public void setSpecialtyStrong(java.lang.String specialtyStrong) {
        this.specialtyStrong = specialtyStrong;
    }


    /**
     * Gets the specialtytype value for this RsPersonVo.
     * 
     * @return specialtytype
     */
    public java.lang.String getSpecialtytype() {
        return specialtytype;
    }


    /**
     * Sets the specialtytype value for this RsPersonVo.
     * 
     * @param specialtytype
     */
    public void setSpecialtytype(java.lang.String specialtytype) {
        this.specialtytype = specialtytype;
    }


    /**
     * Gets the technicallyMess value for this RsPersonVo.
     * 
     * @return technicallyMess
     */
    public java.lang.String getTechnicallyMess() {
        return technicallyMess;
    }


    /**
     * Sets the technicallyMess value for this RsPersonVo.
     * 
     * @param technicallyMess
     */
    public void setTechnicallyMess(java.lang.String technicallyMess) {
        this.technicallyMess = technicallyMess;
    }


    /**
     * Gets the unitlvl value for this RsPersonVo.
     * 
     * @return unitlvl
     */
    public java.lang.String getUnitlvl() {
        return unitlvl;
    }


    /**
     * Sets the unitlvl value for this RsPersonVo.
     * 
     * @param unitlvl
     */
    public void setUnitlvl(java.lang.String unitlvl) {
        this.unitlvl = unitlvl;
    }


    /**
     * Gets the validatedate value for this RsPersonVo.
     * 
     * @return validatedate
     */
    public int getValidatedate() {
        return validatedate;
    }


    /**
     * Sets the validatedate value for this RsPersonVo.
     * 
     * @param validatedate
     */
    public void setValidatedate(int validatedate) {
        this.validatedate = validatedate;
    }


    /**
     * Gets the validateuser value for this RsPersonVo.
     * 
     * @return validateuser
     */
    public java.lang.String getValidateuser() {
        return validateuser;
    }


    /**
     * Sets the validateuser value for this RsPersonVo.
     * 
     * @param validateuser
     */
    public void setValidateuser(java.lang.String validateuser) {
        this.validateuser = validateuser;
    }


    /**
     * Gets the workCompany value for this RsPersonVo.
     * 
     * @return workCompany
     */
    public java.lang.String getWorkCompany() {
        return workCompany;
    }


    /**
     * Sets the workCompany value for this RsPersonVo.
     * 
     * @param workCompany
     */
    public void setWorkCompany(java.lang.String workCompany) {
        this.workCompany = workCompany;
    }


    /**
     * Gets the xllb value for this RsPersonVo.
     * 
     * @return xllb
     */
    public java.lang.String getXllb() {
        return xllb;
    }


    /**
     * Sets the xllb value for this RsPersonVo.
     * 
     * @param xllb
     */
    public void setXllb(java.lang.String xllb) {
        this.xllb = xllb;
    }


    /**
     * Gets the yjfx value for this RsPersonVo.
     * 
     * @return yjfx
     */
    public java.lang.String getYjfx() {
        return yjfx;
    }


    /**
     * Sets the yjfx value for this RsPersonVo.
     * 
     * @param yjfx
     */
    public void setYjfx(java.lang.String yjfx) {
        this.yjfx = yjfx;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RsPersonVo)) return false;
        RsPersonVo other = (RsPersonVo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.adddate == other.getAdddate() &&
            ((this.adduser==null && other.getAdduser()==null) || 
             (this.adduser!=null &&
              this.adduser.equals(other.getAdduser()))) &&
            ((this.auditapplystate==null && other.getAuditapplystate()==null) || 
             (this.auditapplystate!=null &&
              this.auditapplystate.equals(other.getAuditapplystate()))) &&
            this.auditdate == other.getAuditdate() &&
            ((this.auditdetaildate==null && other.getAuditdetaildate()==null) || 
             (this.auditdetaildate!=null &&
              this.auditdetaildate.equals(other.getAuditdetaildate()))) &&
            ((this.auditstate==null && other.getAuditstate()==null) || 
             (this.auditstate!=null &&
              this.auditstate.equals(other.getAuditstate()))) &&
            ((this.audituser==null && other.getAudituser()==null) || 
             (this.audituser!=null &&
              this.audituser.equals(other.getAudituser()))) &&
            ((this.batchcode==null && other.getBatchcode()==null) || 
             (this.batchcode!=null &&
              this.batchcode.equals(other.getBatchcode()))) &&
            this.checkdate == other.getCheckdate() &&
            ((this.checkuser==null && other.getCheckuser()==null) || 
             (this.checkuser!=null &&
              this.checkuser.equals(other.getCheckuser()))) &&
            ((this.cultureType==null && other.getCultureType()==null) || 
             (this.cultureType!=null &&
              this.cultureType.equals(other.getCultureType()))) &&
            ((this.culturetypeother==null && other.getCulturetypeother()==null) || 
             (this.culturetypeother!=null &&
              this.culturetypeother.equals(other.getCulturetypeother()))) &&
            ((this.deleapplystate==null && other.getDeleapplystate()==null) || 
             (this.deleapplystate!=null &&
              this.deleapplystate.equals(other.getDeleapplystate()))) &&
            this.deledate == other.getDeledate() &&
            ((this.delestate==null && other.getDelestate()==null) || 
             (this.delestate!=null &&
              this.delestate.equals(other.getDelestate()))) &&
            ((this.deleuser==null && other.getDeleuser()==null) || 
             (this.deleuser!=null &&
              this.deleuser.equals(other.getDeleuser()))) &&
            ((this.dutylevel==null && other.getDutylevel()==null) || 
             (this.dutylevel!=null &&
              this.dutylevel.equals(other.getDutylevel()))) &&
            ((this.economyKind==null && other.getEconomyKind()==null) || 
             (this.economyKind!=null &&
              this.economyKind.equals(other.getEconomyKind()))) &&
            ((this.economykindother==null && other.getEconomykindother()==null) || 
             (this.economykindother!=null &&
              this.economykindother.equals(other.getEconomykindother()))) &&
            ((this.graduatecollege==null && other.getGraduatecollege()==null) || 
             (this.graduatecollege!=null &&
              this.graduatecollege.equals(other.getGraduatecollege()))) &&
            ((this.idCard==null && other.getIdCard()==null) || 
             (this.idCard!=null &&
              this.idCard.equals(other.getIdCard()))) &&
            ((this.messageAddr==null && other.getMessageAddr()==null) || 
             (this.messageAddr!=null &&
              this.messageAddr.equals(other.getMessageAddr()))) &&
            this.modifydate == other.getModifydate() &&
            ((this.modifyuser==null && other.getModifyuser()==null) || 
             (this.modifyuser!=null &&
              this.modifyuser.equals(other.getModifyuser()))) &&
            this.operationalDate == other.getOperationalDate() &&
            this.pbirthday == other.getPbirthday() &&
            ((this.pcounty==null && other.getPcounty()==null) || 
             (this.pcounty!=null &&
              this.pcounty.equals(other.getPcounty()))) &&
            ((this.pemail==null && other.getPemail()==null) || 
             (this.pemail!=null &&
              this.pemail.equals(other.getPemail()))) &&
            ((this.personId==null && other.getPersonId()==null) || 
             (this.personId!=null &&
              this.personId.equals(other.getPersonId()))) &&
            ((this.personType==null && other.getPersonType()==null) || 
             (this.personType!=null &&
              this.personType.equals(other.getPersonType()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.pnation==null && other.getPnation()==null) || 
             (this.pnation!=null &&
              this.pnation.equals(other.getPnation()))) &&
            ((this.poperator==null && other.getPoperator()==null) || 
             (this.poperator!=null &&
              this.poperator.equals(other.getPoperator()))) &&
            ((this.pphone==null && other.getPphone()==null) || 
             (this.pphone!=null &&
              this.pphone.equals(other.getPphone()))) &&
            ((this.pphoto==null && other.getPphoto()==null) || 
             (this.pphoto!=null &&
              this.pphoto.equals(other.getPphoto()))) &&
            ((this.ppolityvisage==null && other.getPpolityvisage()==null) || 
             (this.ppolityvisage!=null &&
              this.ppolityvisage.equals(other.getPpolityvisage()))) &&
            ((this.ppost==null && other.getPpost()==null) || 
             (this.ppost!=null &&
              this.ppost.equals(other.getPpost()))) &&
            ((this.pquarters==null && other.getPquarters()==null) || 
             (this.pquarters!=null &&
              this.pquarters.equals(other.getPquarters()))) &&
            ((this.pquartersother==null && other.getPquartersother()==null) || 
             (this.pquartersother!=null &&
              this.pquartersother.equals(other.getPquartersother()))) &&
            ((this.premark==null && other.getPremark()==null) || 
             (this.premark!=null &&
              this.premark.equals(other.getPremark()))) &&
            ((this.psex==null && other.getPsex()==null) || 
             (this.psex!=null &&
              this.psex.equals(other.getPsex()))) &&
            ((this.ptrade==null && other.getPtrade()==null) || 
             (this.ptrade!=null &&
              this.ptrade.equals(other.getPtrade()))) &&
            ((this.ptradeother==null && other.getPtradeother()==null) || 
             (this.ptradeother!=null &&
              this.ptradeother.equals(other.getPtradeother()))) &&
            ((this.registeraddrcity==null && other.getRegisteraddrcity()==null) || 
             (this.registeraddrcity!=null &&
              this.registeraddrcity.equals(other.getRegisteraddrcity()))) &&
            ((this.registeraddrprov==null && other.getRegisteraddrprov()==null) || 
             (this.registeraddrprov!=null &&
              this.registeraddrprov.equals(other.getRegisteraddrprov()))) &&
            ((this.sourcetype==null && other.getSourcetype()==null) || 
             (this.sourcetype!=null &&
              this.sourcetype.equals(other.getSourcetype()))) &&
            ((this.specialtyName==null && other.getSpecialtyName()==null) || 
             (this.specialtyName!=null &&
              this.specialtyName.equals(other.getSpecialtyName()))) &&
            ((this.specialtyStrong==null && other.getSpecialtyStrong()==null) || 
             (this.specialtyStrong!=null &&
              this.specialtyStrong.equals(other.getSpecialtyStrong()))) &&
            ((this.specialtytype==null && other.getSpecialtytype()==null) || 
             (this.specialtytype!=null &&
              this.specialtytype.equals(other.getSpecialtytype()))) &&
            ((this.technicallyMess==null && other.getTechnicallyMess()==null) || 
             (this.technicallyMess!=null &&
              this.technicallyMess.equals(other.getTechnicallyMess()))) &&
            ((this.unitlvl==null && other.getUnitlvl()==null) || 
             (this.unitlvl!=null &&
              this.unitlvl.equals(other.getUnitlvl()))) &&
            this.validatedate == other.getValidatedate() &&
            ((this.validateuser==null && other.getValidateuser()==null) || 
             (this.validateuser!=null &&
              this.validateuser.equals(other.getValidateuser()))) &&
            ((this.workCompany==null && other.getWorkCompany()==null) || 
             (this.workCompany!=null &&
              this.workCompany.equals(other.getWorkCompany()))) &&
            ((this.xllb==null && other.getXllb()==null) || 
             (this.xllb!=null &&
              this.xllb.equals(other.getXllb()))) &&
            ((this.yjfx==null && other.getYjfx()==null) || 
             (this.yjfx!=null &&
              this.yjfx.equals(other.getYjfx())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getAdddate();
        if (getAdduser() != null) {
            _hashCode += getAdduser().hashCode();
        }
        if (getAuditapplystate() != null) {
            _hashCode += getAuditapplystate().hashCode();
        }
        _hashCode += getAuditdate();
        if (getAuditdetaildate() != null) {
            _hashCode += getAuditdetaildate().hashCode();
        }
        if (getAuditstate() != null) {
            _hashCode += getAuditstate().hashCode();
        }
        if (getAudituser() != null) {
            _hashCode += getAudituser().hashCode();
        }
        if (getBatchcode() != null) {
            _hashCode += getBatchcode().hashCode();
        }
        _hashCode += getCheckdate();
        if (getCheckuser() != null) {
            _hashCode += getCheckuser().hashCode();
        }
        if (getCultureType() != null) {
            _hashCode += getCultureType().hashCode();
        }
        if (getCulturetypeother() != null) {
            _hashCode += getCulturetypeother().hashCode();
        }
        if (getDeleapplystate() != null) {
            _hashCode += getDeleapplystate().hashCode();
        }
        _hashCode += getDeledate();
        if (getDelestate() != null) {
            _hashCode += getDelestate().hashCode();
        }
        if (getDeleuser() != null) {
            _hashCode += getDeleuser().hashCode();
        }
        if (getDutylevel() != null) {
            _hashCode += getDutylevel().hashCode();
        }
        if (getEconomyKind() != null) {
            _hashCode += getEconomyKind().hashCode();
        }
        if (getEconomykindother() != null) {
            _hashCode += getEconomykindother().hashCode();
        }
        if (getGraduatecollege() != null) {
            _hashCode += getGraduatecollege().hashCode();
        }
        if (getIdCard() != null) {
            _hashCode += getIdCard().hashCode();
        }
        if (getMessageAddr() != null) {
            _hashCode += getMessageAddr().hashCode();
        }
        _hashCode += getModifydate();
        if (getModifyuser() != null) {
            _hashCode += getModifyuser().hashCode();
        }
        _hashCode += getOperationalDate();
        _hashCode += getPbirthday();
        if (getPcounty() != null) {
            _hashCode += getPcounty().hashCode();
        }
        if (getPemail() != null) {
            _hashCode += getPemail().hashCode();
        }
        if (getPersonId() != null) {
            _hashCode += getPersonId().hashCode();
        }
        if (getPersonType() != null) {
            _hashCode += getPersonType().hashCode();
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getPnation() != null) {
            _hashCode += getPnation().hashCode();
        }
        if (getPoperator() != null) {
            _hashCode += getPoperator().hashCode();
        }
        if (getPphone() != null) {
            _hashCode += getPphone().hashCode();
        }
        if (getPphoto() != null) {
            _hashCode += getPphoto().hashCode();
        }
        if (getPpolityvisage() != null) {
            _hashCode += getPpolityvisage().hashCode();
        }
        if (getPpost() != null) {
            _hashCode += getPpost().hashCode();
        }
        if (getPquarters() != null) {
            _hashCode += getPquarters().hashCode();
        }
        if (getPquartersother() != null) {
            _hashCode += getPquartersother().hashCode();
        }
        if (getPremark() != null) {
            _hashCode += getPremark().hashCode();
        }
        if (getPsex() != null) {
            _hashCode += getPsex().hashCode();
        }
        if (getPtrade() != null) {
            _hashCode += getPtrade().hashCode();
        }
        if (getPtradeother() != null) {
            _hashCode += getPtradeother().hashCode();
        }
        if (getRegisteraddrcity() != null) {
            _hashCode += getRegisteraddrcity().hashCode();
        }
        if (getRegisteraddrprov() != null) {
            _hashCode += getRegisteraddrprov().hashCode();
        }
        if (getSourcetype() != null) {
            _hashCode += getSourcetype().hashCode();
        }
        if (getSpecialtyName() != null) {
            _hashCode += getSpecialtyName().hashCode();
        }
        if (getSpecialtyStrong() != null) {
            _hashCode += getSpecialtyStrong().hashCode();
        }
        if (getSpecialtytype() != null) {
            _hashCode += getSpecialtytype().hashCode();
        }
        if (getTechnicallyMess() != null) {
            _hashCode += getTechnicallyMess().hashCode();
        }
        if (getUnitlvl() != null) {
            _hashCode += getUnitlvl().hashCode();
        }
        _hashCode += getValidatedate();
        if (getValidateuser() != null) {
            _hashCode += getValidateuser().hashCode();
        }
        if (getWorkCompany() != null) {
            _hashCode += getWorkCompany().hashCode();
        }
        if (getXllb() != null) {
            _hashCode += getXllb().hashCode();
        }
        if (getYjfx() != null) {
            _hashCode += getYjfx().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RsPersonVo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://base.rcsm.provider.service.trade.support.gmcc.com/", "rsPersonVo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adduser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adduser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditapplystate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditapplystate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditdetaildate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditdetaildate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditstate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditstate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audituser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "audituser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkuser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cultureType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cultureType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("culturetypeother");
        elemField.setXmlName(new javax.xml.namespace.QName("", "culturetypeother"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleapplystate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleapplystate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deledate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deledate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delestate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "delestate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleuser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dutylevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dutylevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("economyKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "economyKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("economykindother");
        elemField.setXmlName(new javax.xml.namespace.QName("", "economykindother"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("graduatecollege");
        elemField.setXmlName(new javax.xml.namespace.QName("", "graduatecollege"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageAddr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messageAddr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifydate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifydate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifyuser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifyuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationalDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operationalDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pbirthday");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pbirthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcounty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcounty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pnation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("poperator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "poperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pphone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pphone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pphoto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pphoto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppolityvisage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppolityvisage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pquarters");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pquarters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pquartersother");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pquartersother"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptrade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptrade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptradeother");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ptradeother"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registeraddrcity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registeraddrcity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registeraddrprov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registeraddrprov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourcetype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourcetype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialtyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialtyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialtyStrong");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialtyStrong"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialtytype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialtytype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("technicallyMess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "technicallyMess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitlvl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitlvl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validatedate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validatedate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateuser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validateuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workCompany");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workCompany"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xllb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xllb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yjfx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yjfx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
