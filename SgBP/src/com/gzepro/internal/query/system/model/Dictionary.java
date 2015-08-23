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
@Table(name="mstb_sys_dictionary") //表名
public class Dictionary  implements java.io.Serializable{
	
    @Id  
    @Column(name="dictionary_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_dictionary")      
    @SequenceGenerator(name="seq_sys_dictionary",allocationSize=1,initialValue=1, sequenceName="seq_sys_dictionary") 
	private Long id;
    
	@Column(name="dic_code",length = 20)
	private String code;
	
	@Column(name="dic_name",length = 100)
	private String name;
	
	@Column(name="type_id")
	private Long typeId;
	
	@Column(name="remark",length = 1000)
	private String remark;
	
	@Column(name="creator")
	private Long creator;
	
	@Column(name="create_date",length = 7)
	private Date createDate;
	
	@Column(name="is_sensitive",length = 1)
	private String sensitive;
	
	@Column(name="is_valid",length = 1)
	private String valid;

	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String creatorName = "";
	
	@Transient
	private String typeName = "";
	
	
	@Transient
	private String menuIds = "";//敏感信息关联的菜单
	
	
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

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getSensitive() {
		return sensitive;
	}

	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	
}

