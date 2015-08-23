package com.gzepro.internal.query.system.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.system.base.SystemBaseAction;
import com.gzepro.internal.query.system.service.TreeService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.main")
public class MainAction  extends SystemBaseAction {
	@Resource
	private TreeService treeService;
	private String menuJsonStr = "";
	private String nameCN = "";
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		  menuJsonStr = treeService.loadUserMenuForJson(this.getAccount().getId(),this.getLang());///判断用户是否有权限
		  setNameCN(this.getAccount().getNameCN());
		  String allUrl=treeService.loadAllUrl();
		  if(menuJsonStr == null || menuJsonStr.equals("")){
			  menuJsonStr = "[]";
			  this.saveSysLog("登陆", "无权限");
		  }
		  getSession().put("menuJsonStr", menuJsonStr);
		  getSession().put("allUrl", allUrl);
		 return SUCCESS;
	} 
	/**
	 * @return the nameCN
	 */
	public String getNameCN() {
		return nameCN;
	}
	/**
	 * @param nameCN the nameCN to set
	 */
	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}
	public String getMenuJsonStr() {
		return menuJsonStr;
	}
	public void setMenuJsonStr(String menuJsonStr) {
		this.menuJsonStr = menuJsonStr;
	}

	
}

