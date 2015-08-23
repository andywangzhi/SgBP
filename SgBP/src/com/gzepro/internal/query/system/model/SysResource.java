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
@Table(name="mstb_sys_resource") //表名
public class SysResource implements java.io.Serializable {
    @Id  
    @Column(name="resource_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_resource")      
    @SequenceGenerator(name="seq_sys_resource",allocationSize=1,initialValue=1, sequenceName="seq_sys_resource") 
	private Long id;
	
	@Column(name="res_key",length = 500, nullable = false)
	private String key;
    
	@Column(name="name_zh")
	private String nameZh;
	
	@Column(name="name_en")
	private String nameEn;
	
	@Column(name="name_tw")
	private String nameTw;

	@Column(name="use_type",length = 100, nullable = false)
	private String useType;
	
	@Column(name="remark",length = 1024)
	private String remark;
	
	@Column(name="creator")
	private Long creator;
	
	@Column(name="create_date",length = 7)
	private Date createDate;

	@Column(name="is_valid",length = 1)
	private String valid;

	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String creatorName = "";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getNameTw() {
		return nameTw;
	}

	public void setNameTw(String nameTw) {
		this.nameTw = nameTw;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

}