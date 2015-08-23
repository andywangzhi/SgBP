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
@Table(name="mstb_sys_menu")
public class Menu implements java.io.Serializable {

    @Id  
    @Column(name="menu_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_menu")      
    @SequenceGenerator(name="seq_sys_menu",allocationSize=1,initialValue=1, sequenceName="seq_sys_menu") 
	private Long id;
	
	@Column(name="name_zh",length = 256, nullable = false)
	private String nameZh;
	
	@Column(name="name_tw",length = 256, nullable = false)
	private String nameTw;
	
	@Column(name="name_en",length = 256, nullable = false)
	private String nameEn;
	
	@Column(name="code",length = 50, nullable = false)
	private String code;
	
	@Column(name="type_id")
	private Long typeId;
	
	@Column(name="model",length = 10)
	private String model;
	
	@Column(name="icon",length = 50)
	private String icon;
	
	@Column(name="url",length = 256)
	private String url;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="remark",length = 1024)
	private String remark;
	
	@Column(name="creator")
	private Long creator;
	 
	@Column(name="create_date",length = 7)
	private Date createDate;
	
	@Column(name="is_valid",length = 1)
	private String valid;
	
	@Column(name="parent_id")
	private Long parentId;

	/****** 以下字段不存储数据库,仅用于页面显示 *******/
	@Transient
	private String parentName = "";
	@Transient
	private String creatorName = "";
	@Transient
	private String typeName = "";
	
	@Transient
	private String dicIds = "";//菜单的敏感字段
	
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

	public String getNameZh() {
		return nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getDicIds() {
		return dicIds;
	}

	public void setDicIds(String dicIds) {
		this.dicIds = dicIds;
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

	public String getNameTw() {
		return nameTw;
	}

	public void setNameTw(String nameTw) {
		this.nameTw = nameTw;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}