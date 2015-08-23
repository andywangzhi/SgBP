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
@Table(name="mstb_sys_group") //表名
public class Group implements java.io.Serializable{
    @Id  
    @Column(name="group_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_group")      
    @SequenceGenerator(name="seq_sys_group",allocationSize=1,initialValue=1, sequenceName="seq_sys_group") 
	private Long id;
	
	@Column(name="name",length = 50, nullable = false)
	private String name;
	
	@Column(name="group_level")
	private Integer groupLevel;
	
	@Column(name="creator")
	private Long creator;
	
	@Column(name="create_date",length = 7)
	private Date createDate;

	@Column(name="remark",length = 500)
	private String remark;

	@Column(name="is_valid",length = 1)
	private String valid;


	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String creatorName = "";
	@Transient
	private String groupManager = "";
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupLevel() {
		return groupLevel;
	}

	public void setGroupLevel(Integer groupLevel) {
		this.groupLevel = groupLevel;
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

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(String groupManager) {
		this.groupManager = groupManager;
	}
	
}