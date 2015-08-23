package com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy;

/**
 * 
  * @ClassName: ProjectExperienceDetaiDTO
  * @Description: TODO(项目经验)
  * @author 张建薇
  * @date Jul 27, 2012 4:23:51 PM
  *
 */
public class ProjectExperienceDetaiDTO {
	private String experienceid;//项目经验Id
	private String personId; //个人信息ID
	private String fromDate;//从何年何月开始
	private String toDate;//至何年何月完成
	private String personnum;//团队人数
	private String projname; //项目名称
	private String projmoney;//项目经费
	private String projresponsibility;//项目职责及业绩
	
	
	private String adduser;
	private String adddate;
	private String modifyuser;
	private String modifydate;
	
	public String getExperienceid() {
		return experienceid;
	}
	public void setExperienceid(String experienceid) {
		this.experienceid = experienceid;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
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
	public String getPersonnum() {
		return personnum;
	}
	public void setPersonnum(String personnum) {
		this.personnum = personnum;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getProjmoney() {
		return projmoney;
	}
	public void setProjmoney(String projmoney) {
		this.projmoney = projmoney;
	}
	public String getProjresponsibility() {
		return projresponsibility;
	}
	public void setProjresponsibility(String projresponsibility) {
		this.projresponsibility = projresponsibility;
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
	
	
}
