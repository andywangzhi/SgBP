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
@Table(name = "mstb_sys_role_menu")
public class RoleMenu implements java.io.Serializable{
    @Id  
    @Column(name="r_f_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_sys_r_f")      
    @SequenceGenerator(name="seq_sys_r_f",allocationSize=1,initialValue=1, sequenceName="seq_sys_r_f") 
	private Long id;
	
	@Column(name="menu_id")
	private Long menuId;

	@Column(name="role_id")
	private Long roleId;
	
	@Column(name="right_id")
	private Long rightId;//当rightType=m对应的是菜单操作类型id,若rightType=d对应的是菜单数据字典id

	@Column(name="right_type",length = 5)
	private String rightType;//权限类型 m表示菜单权限 d表示数据字典权限
	
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRightId() {
		return rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

	public String getRightType() {
		return rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}
	
}
