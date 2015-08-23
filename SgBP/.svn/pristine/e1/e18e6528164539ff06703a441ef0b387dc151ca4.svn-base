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
@Table(name="mstb_sys_group_account") //表名
public class GroupAccount implements java.io.Serializable {
    @Id  
    @Column(name="g_a_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_g_a")      
    @SequenceGenerator(name="seq_sys_g_a",allocationSize=1,initialValue=1, sequenceName="seq_sys_g_a") 
	private Long id;
	
	@Column(name = "account_id")
	private Long accountId;
    

	@Column(name = "group_id")
	private Long groupId;

	@Column(name="is_manager",length = 1)
	private String manager;
	
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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}