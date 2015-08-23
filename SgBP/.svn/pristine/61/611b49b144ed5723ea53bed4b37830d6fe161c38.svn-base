package com.gzepro.internal.query.system.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.MD5Util;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.service.AccountService;
import com.gzepro.internal.query.system.service.DeptService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.account")
public class AccountAction extends SystemBaseJsonAction {

	@Resource
	private AccountService accountService;
	
	@Resource
	private DeptService deptService;
	
	public String viewAdd() {
		return "add";  
	}
	
	public String add() {
		account.setPassword(MD5Util.getMD5String(account.getPassword()));
		account=accountService.add(account);
		this.saveSysLog(Constants.SYSTEM_ACCOUNT, "新增,id="+account.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		account = accountService.findById(id);
		return "edit"; 
	}
	
	public String edit() {
		if(newpassword != null && !newpassword.trim().equals("")){
			account.setPassword(MD5Util.getMD5String(newpassword));
		}
		if(account.getUsertype()!=null&&account.getUsertype().equals("0")){
			account.setUsercountry("");
		}
		account = accountService.edit(account);
		this.saveSysLog(Constants.SYSTEM_ACCOUNT, "修改,id="+account.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		account = accountService.findById(id);
		return "view"; 
	}

	public String delete() {
		accountService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_MENU, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		accountService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_ACCOUNT, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_ACCOUNT, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_ACCOUNT, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String saveLang(){
		String lang = request.getParameter("lang");
		accountService.saveLang(ids,lang);
		renderText("修改语言"); 
		return null; 
	}
	
	public String findAll() {
		String name = request.getParameter("name");//用于搜索
		String realName = request.getParameter("realName");//用于搜索
		String groupId = request.getParameter("groupId");//用于搜索
		String valid = request.getParameter("valid");//用于搜索request.getParameter("first")
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		jsonPaging = this.getJsonPaging();
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);		
		}
		jsonPaging = accountService.findAll(jsonPaging,name,realName,groupId,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findAllByDeptIdForJson()
	{
		String deptId = request.getParameter("id");
		List<Account> list = accountService.findAllByDeptCode(deptId);
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN()+"-"+accountService.findDeptByAccountId(account.getId()));
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	public String findSelectedDeptAccountForJson()
	{
		String deptId = "0";
		if(request.getParameter("deptId") != null){
			deptId = request.getParameter("deptId");
		}
		List<Account> list = deptService.findAllAccountByDeptId(new Long(deptId));
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN()+"-"+accountService.findDeptByAccountId(account.getId()));
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	
	
	
	/**
	 * 查找组下的成员
	 * @return
	 */
	public String findGroupAccountForJson()
	{
		Long groupId = null;
		if(request.getParameter("groupId") != null){
			groupId = Long.parseLong(request.getParameter("groupId"));
		}
		Long roleId = null;
		if(request.getParameter("roleId") != null){
			roleId = Long.parseLong(request.getParameter("roleId"));
		}
		String manager = "";
		if(request.getParameter("manager") != null){
			manager = request.getParameter("manager").toString();
		}
		List<Account> list = accountService.findGroupAccount(groupId,roleId,manager);
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN()+"-"+accountService.findDeptByAccountId(account.getId()));
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	/**
	 * 查找角色下的用户
	 * @return
	 */
	public String findRoleAccountForJson()
	{
		Long roleId = null;
		if(request.getParameter("roleId") != null){
			roleId = Long.parseLong(request.getParameter("roleId"));
		}
		List<Account> list = accountService.findRoleAccount(roleId);
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN()+"-"+accountService.findDeptByAccountId(account.getId()));
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	/**
	 * 查找角色下的用户
	 * @return
	 */
	public String searchByNameOrCodeForJson() throws Exception
	{
		
		String name = request.getParameter("name");//名称 用于搜索
		if(name != null && !name.equals("")){
			name = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "UTF-8"), "UTF-8");
		}
		
		String code = request.getParameter("code");//名称 用于搜索
		if(code != null && !code.equals("")){
			code = java.net.URLDecoder.decode(java.net.URLDecoder.decode(code, "UTF-8"), "UTF-8");
		}
		
		List<Account> list = accountService.findByNameOrCode(name,code);
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN()+"-"+accountService.findDeptByAccountId(account.getId()));
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	/**
	 * 查找角色下的用户
	 * @return
	 */
	public String searchByNameOrCodeForDeptForJson() throws Exception
	{
		
		String name = request.getParameter("name");//名称 用于搜索
		if(name != null && !name.equals("")){
			name = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "UTF-8"), "UTF-8");
		}
		
		String code = request.getParameter("code");//名称 用于搜索
		if(code != null && !code.equals("")){
			code = java.net.URLDecoder.decode(java.net.URLDecoder.decode(code, "UTF-8"), "UTF-8");
		}
		
		List<Account> list = accountService.findByNameOrCodeForDept(name,code);
	   	ArrayList aList = new ArrayList();
		for(Account account:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", account.getId());
			jsonObject.put("name", account.getNameCN());
			jsonObject.put("title", account.getNameEN());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	/**
	 * 检查帐号是否存在
	 * @return
	 */
	public String checkCode(){
		String accountCode = request.getParameter("accountCode");
		account = accountService.findByName(accountCode);
		if(account!=null){
			renderText("true");
		}else{
			renderText("false");
		}
		return null; 
	}
	
	//修改密码
	public String viewPassword() {
		String name=this.readCookieSSO(request, this.getResponse());
		if(name!=null&&!"".equals(name)){
			account = accountService.findByName(name);
			return "pass"; 
		}
		return null;
	}
	
	public String editPassword() {
		String name=this.readCookieSSO(request, this.getResponse());
		if(name!=null&&!"".equals(name)){
			account = accountService.findByName(name);
			if(newpassword != null && !newpassword.trim().equals("")){
				account.setPassword(MD5Util.getMD5String(newpassword));
			}
			account = accountService.edit(account);
			this.saveSysLog(Constants.SYSTEM_ACCOUNT, "修改账户密码,id="+account.getId());
			renderText("修改成功"); 
		}
		return null; 
	}
	
	private String newpassword ;
	private Account account = new Account();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	private String readCookieSSO(HttpServletRequest request,HttpServletResponse response) {
		String cookieValue = "";
		try {
			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals(LoginAction.COOKIE_NAME)) {
						cookieValue = cookies[i].getValue();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cookieValue;
	}
}
