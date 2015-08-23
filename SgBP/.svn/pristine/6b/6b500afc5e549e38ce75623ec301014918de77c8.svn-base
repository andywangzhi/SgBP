package com.gzepro.internal.query.system.model;

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
@Table(name="mstb_sys_account_role") //表名
public class AccountRole implements java.io.Serializable {
    @Id  
    @Column(name="a_r_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_a_r")      
    @SequenceGenerator(name="seq_sys_a_r",allocationSize=1,initialValue=1, sequenceName="seq_sys_a_r") 
	private Long id;
	
	@Column(name = "account_id")
	private Long accountId;
    
	@Column(name = "role_id")
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}