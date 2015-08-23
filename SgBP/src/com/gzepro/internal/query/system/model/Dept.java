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
@Table(name="mstb_sys_dept") //表名
public class Dept implements java.io.Serializable {
    @Id  
    @Column(name="dept_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_dept")      
    @SequenceGenerator(name="seq_sys_dept",allocationSize=1,initialValue=1, sequenceName="seq_sys_dept") 
	private Long id;
	
	@Column(name="dept_code",length = 10)
	private String code;
    
	@Column(name="name_cn",length = 100)
	private String nameCN;
	
	@Column(name="name_en",length = 100)
	private String nameEN;
	
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="remark",length = 500)
	private String remark;

	@Column(name="is_valid",length = 1)
	private String valid;

	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String parentName = "";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
