package com.gzepro.internal.query.system.model;

import java.util.Date;

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
@Table(name="mstb_sys_role") //表名
public class Role implements java.io.Serializable {
    @Id  
    @Column(name="role_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_role")      
    @SequenceGenerator(name="seq_sys_role",allocationSize=1,initialValue=1, sequenceName="seq_sys_role") 
	private Long id;
	
	@Column(name="group_id")
	private Long groupId;
    
	@Column(name="role_name",length = 50, nullable = false)
	private String name;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="pin_grading")
	private Integer pinGrading;
	
	@Column(name="creator")
	private Long creator;
	
	@Column(name="create_date",length = 7)
	private Date createDate;
	
	@Column(name="remark",length = 500)
	private String remark;

	@Column(name="is_valid",length = 1)
	private String valid;
	
	@Column(name="is_manager",length = 1)
	private String manager;
	
	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String creatorName = "";
	@Transient
	private String groupName = "";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Integer getPinGrading() {
		return pinGrading;
	}

	public void setPinGrading(Integer pinGrading) {
		this.pinGrading = pinGrading;
	}
	
}