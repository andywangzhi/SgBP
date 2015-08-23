/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.system.vo;


/**
 * 菜单Bean
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class TreeBean {
	private String disid;//菜单ID
	private String disname;//菜单名称
	private String disparentId;//父菜单ID
	private String disparentName;//父菜单名称
	private String isLeaf;//是否是叶子
	private String rddisbled;//加载时是否选中
	private String operStr;//操作类型选择框
	private String dicStr;//数据字典选择框
	public String getDisid() {
		return disid;
	}
	public void setDisid(String disid) {
		this.disid = disid;
	}
	public String getDisname() {
		return disname;
	}
	public void setDisname(String disname) {
		this.disname = disname;
	}
	public String getDisparentId() {
		return disparentId;
	}
	public void setDisparentId(String disparentId) {
		this.disparentId = disparentId;
	}
	public String getDisparentName() {
		return disparentName;
	}
	public void setDisparentName(String disparentName) {
		this.disparentName = disparentName;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getRddisbled() {
		return rddisbled;
	}
	public void setRddisbled(String rddisbled) {
		this.rddisbled = rddisbled;
	}
	public String getOperStr() {
		return operStr;
	}
	public void setOperStr(String operStr) {
		this.operStr = operStr;
	}
	public String getDicStr() {
		return dicStr;
	}
	public void setDicStr(String dicStr) {
		this.dicStr = dicStr;
	}
}
