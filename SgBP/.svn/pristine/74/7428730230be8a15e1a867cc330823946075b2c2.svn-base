package com.gzepro.internal.query.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Entity 
@Table(name="mstb_sys_online") //表名
public class Online implements java.io.Serializable{
    @Id  
    @Column(name="online_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_online")      
    @SequenceGenerator(name="seq_sys_online",allocationSize=1,initialValue=1, sequenceName="seq_sys_online") 
	private Long id;
    
	@Column(name="login_id",length = 50,nullable = false)
	private String loginId;
	
	@Column(name="account_name",length = 50)
	private String accountName;
	
	@Column(name="oper_ip",length = 20, nullable = false)
	private String operIp;
	
	@Column(name="login_date",length = 7)
	private Date loginDate;
	
	@Column(name="last_visit_date",length = 7)
	private Date lastVisitDate;
	
	
	@Column(name="account_level",length = 20)
	private String accountLevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
}
