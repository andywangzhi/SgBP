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
@Table(name="mstb_sys_conf")
public class Conf implements java.io.Serializable {

    @Id  
    @Column(name="conf_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_conf")      
    @SequenceGenerator(name="seq_sys_conf",allocationSize=1,initialValue=1, sequenceName="seq_sys_conf") 
	private Long id;
	
	@Column(name="code",length = 20)
	private String code;
    
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="type_id")
	private Long typeId;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="name",length = 256, nullable = false)
	private String name;
	
	@Column(name="remark",length = 1024)
	private String remark;
	
	@Column(name="is_valid",length = 1)
	private String valid;

	@Transient
	private String typeName = "";
	
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}