package com.gzepro.internal.query.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Entity 
@Table(name="mstb_sys_account") //表名
public class Account  implements java.io.Serializable{
    @Id  
    @Column(name="account_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_account")      
    @SequenceGenerator(name="seq_sys_account",allocationSize=1,initialValue=1, sequenceName="seq_sys_account") 
	private Long id;
	
	@Column(name="login_code",length = 10)
	private String loginCode;
	
	@Column(name="password",length = 200)
	private String password;
	
	@Column(name="name_cn",length = 30)
	private String nameCN;
	
	@Column(name="name_en",length = 30)
	private String nameEN;
	
	@Column(name="gender",length = 4)
	private String gender;
	
	@Column(name="email",length = 100)
	private String email;
	
	@Column(name="tel",length = 100)
	private String tel;
	
	@Column(name="address",length = 200)
	private String address;
	
	@Column(name="remark",length = 1000)
	private String remark;
	
	@Column(name="lang",length = 1)
	private String lang;
	
	@Column(name="is_valid",length = 1)
	private String valid;
	
	@Column(name="user_type",length = 2)
	private String usertype;
	
	@Column(name="user_country",length = 2)
	private String usercountry;
	
	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String groupNames = "";
	
	@Transient
	private String roleNames = "";
	
	@Transient
	private String deptIds = "";//用户所属的部门
	
	@Transient
	private String deptNames = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getGroupNames() {
		return groupNames;
	}

	public void setGroupNames(String groupNames) {
		this.groupNames = groupNames;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(String deptNames) {
		this.deptNames = deptNames;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsercountry() {
		return usercountry;
	}

	public void setUsercountry(String usercountry) {
		this.usercountry = usercountry;
	}
	
}

