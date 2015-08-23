package com.gzepro.internal.query.base.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.struts.ContextPvd;
import com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor;
import com.gzepro.internal.query.system.action.LoginAction;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.SysLog;
import com.gzepro.internal.query.system.service.SysLogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("anonymous.base")
public class AnonymousBaseAction extends ActionSupport implements Anonymous{
	@Resource
	protected SysLogService sysLogService;
	@Resource
	protected ContextPvd contextPvd;
	
	protected String loginAccountUserName = "";
	
	public String execute() throws Exception{
		//从cookie中读用户信息
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		loginAccountUserName = this.readCookieSSO(request, response);
		return this.SUCCESS;
	}
	
	
	/**
	 * 获得当前的登陆用户
	 * @return
	 */
	public Account getAccount() {
		Account loginAccount = (Account) ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);
		return loginAccount;
	}
	
	/**
	 * 系统日志添加
	 * @param loginId 登陆ID 
	 * @param realName 用户名
	 * @param logType 登陆 退出 故障 其他为模块的具体名称
	 * @param remark  备注
	 */
	public void saveSysLog(String loginId,String realName,String logType, String remark){
		SysLog sysLog = new SysLog();
		sysLog.setLoginId(loginId);
		sysLog.setAccountName(realName);
		
		sysLog.setOperIp(contextPvd.getRemoteIp());
		sysLog.setLogType(logType);
		sysLog.setRemark(remark);
		sysLog.setCreateDate(new Date());
		sysLogService.add(sysLog);
	}
	
	/**
	 * 读取cookie
	 * @param request
	 * @param response
	 * @return
	 */
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


	public String getLoginAccountUserName() {
		return loginAccountUserName;
	}


	public void setLoginAccountUserName(String loginAccountUserName) {
		this.loginAccountUserName = loginAccountUserName;
	}
	
}
