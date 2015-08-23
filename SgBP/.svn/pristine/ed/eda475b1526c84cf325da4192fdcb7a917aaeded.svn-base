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
@Table(name="mstb_sys_conf_type")
public class ConfType implements java.io.Serializable {

    @Id  
    @Column(name="type_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_conf_type")      
    @SequenceGenerator(name="seq_sys_conf_type",allocationSize=1,initialValue=1, sequenceName="seq_sys_conf_type") 
	private Long id;
	
	@Column(name="code",length = 20)
	private String code;
    
	@Column(name="name",length = 256, nullable = false)
	private String name;
	
	@Column(name="remark",length = 1024)
	private String remark;
	
	@Column(name="is_valid",length = 1)
	private String valid;

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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
}