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
@Table(name = "mstb_sys_menu_dictionary")
public class MenuDictionary implements java.io.Serializable{
    @Id  
    @Column(name="m_d_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_m_d")      
    @SequenceGenerator(name="seq_sys_m_d",allocationSize=1,initialValue=1, sequenceName="seq_sys_m_d") 
	private Long id;

	@Column(name="dictionary_id")
	private Long dictionaryId;
    
    @Column(name="menu_id")
	private Long menuId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this. menuId =  menuId;
	}

	public Long getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(Long dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
}
