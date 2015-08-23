package com.gzepro.internal.query.system.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.base.action.AnonymousBaseAction;
import com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor;
import com.gzepro.internal.query.common.util.MD5Util;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.service.AccountService;
import com.gzepro.internal.query.system.service.SysLogService;
import com.gzepro.internal.query.system.service.TreeService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.login")
public class LoginAction extends AnonymousBaseAction{
	
	public static final String COOKIE_NAME = "_soa_query_";
	public static final String ACCOUNT_TYPE="_ACCOUNT_TYPE_";//登陆用户的类型:市本级/县级
	
	private String name;
	private String password;
	private String vercode; 
	@Resource
	private AccountService accountService;

	@Resource
	protected SysLogService sysLogService;
	
	@Resource
	private TreeService treeService;
	
	public String execute(){
		/*if (ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN) != null) {
			return this.SUCCESS;
		}*/
		name =  name.trim();
		password = password.trim();
		if(name != null && !name.equals("") && password != null && !password.equals("")){
			String md5Password = MD5Util.getMD5String(password.trim());
			//将用户名写入cookie中
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			this.writeCookieSSO(name,request,response);
			
			Account account = accountService.findByName(name);
			if(account != null){ 
				if(account.getPassword().equals(md5Password)){ 
					if(account.getValid().equals("1")){
						ActionContext.getContext().getSession().put(LoginInterceptor.USER_LOGIN, account);
						
						//保存当前登陆用户的身份
						ActionContext.getContext().getSession().put(LoginInterceptor.ACCOUNT_DIST_TYPE,treeService.checkAccountDist(account.getId()));
						
						ActionContext.getContext().getSession().put(LoginInterceptor.CUR_USER_LANG, (Integer.parseInt(account.getLang())-1));
						//保存当前登陆用户的语言, 0中文 1英文 2繁体 
						
						ActionContext.getContext().getSession().put(ACCOUNT_TYPE, account.getUsercountry());
						//登陆用户的类型:市本级/县级
						
						//访问日志添加
						this.saveSysLog(name, account.getNameCN(), "登陆", "登陆成功");
						return this.SUCCESS;
					}else{
						//访问日志添加
						this.saveSysLog(name, account.getNameCN(), "登陆", "用户已停用");
						addActionError("用户已停用");
						return ERROR;
					}
				}else{
					//访问日志添加
					this.saveSysLog(name, name, "登陆", "登陆失败,密码错误");
					addActionError("登陆失败,密码错误");
					return ERROR;
				}
			}else{
				//访问日志添加
				this.saveSysLog(name, name, "登陆", "登陆失败,用户不存在");
				addActionError("用户名不存在");
				return ERROR;
			}
		}else{
			this.saveSysLog(name, name, "登陆", "登陆失败,用户名或密码为空");
			addActionError("登陆失败,用户名或密码为空");
			return ERROR;
		}
	}
	/**
	 * 写cookie
	 * @param cookieValue
	 * @param request
	 * @param response
	 */
	private void writeCookieSSO(String cookieValue,HttpServletRequest request, HttpServletResponse response) {
		Cookie loginUserid = new Cookie(COOKIE_NAME,cookieValue);
		loginUserid.setMaxAge(-1);
		response.addCookie(loginUserid);
	}

	public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
}