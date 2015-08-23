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
@Table(name="mstb_sys_log") //表名
public class SysLog implements java.io.Serializable{
    @Id  
    @Column(name="log_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_log")      
    @SequenceGenerator(name="seq_sys_log",allocationSize=1,initialValue=1, sequenceName="seq_sys_log") 
	private Long id;
	
	@Column(name="log_type",length = 50)
	private String logType;

	@Column(name="login_id",length = 50)
	private String loginId;
	
	@Column(name="account_name",length = 50)
	private String accountName;

	@Column(name="oper_ip",length = 20)
	private String operIp;

	@Column(name="create_date",length = 7)
	private Date createDate;

	@Column(name="remark",length = 1024)
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}