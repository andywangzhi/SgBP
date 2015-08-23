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
@Table(name="mstb_sys_group_menu") //表名
public class GroupMenu implements java.io.Serializable{
    @Id  
    @Column(name="g_m_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_g_m")      
    @SequenceGenerator(name="seq_sys_g_m",allocationSize=1,initialValue=1, sequenceName="seq_sys_g_m") 
	private Long id;
	
	@Column(name="menu_id")
	private Long menuId;

	@Column(name="group_id")
	private Long groupId;

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
		this.menuId = menuId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
}