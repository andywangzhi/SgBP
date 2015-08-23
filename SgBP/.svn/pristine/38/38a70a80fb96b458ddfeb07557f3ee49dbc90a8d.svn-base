package com.gzepro.internal.query.common.struts.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gzepro.internal.query.base.action.Anonymous;
import com.gzepro.internal.query.system.model.Account;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor{
	public static final String USER_LOGIN = "_USER_LOGIN_";

	public static final String ORIGINAL_URL = "_ORIGINAL_URL_";
	
	public static final String GZEPRO_NUM="_GZEPRO_NUM_";
	
	public static final String CUR_USER_LANG="_CUR_USER_LANG_";//保存当前登陆用户的语言
	
	public static final String ACCOUNT_DIST_TYPE="_ACCOUNT_DIST_TYPE_";//保存当前登陆用户的身份
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	   Action action = (Action)invocation.getAction();
	   String actionClassName = action.getClass().toString();
	   String className = actionClassName.substring(actionClassName.lastIndexOf(".")+1).trim();
	   ActionContext ctx = invocation.getInvocationContext();
	   HttpServletRequest request = ServletActionContext.getRequest();
	   Map session = ctx.getSession();
	   Account account = (Account) session.get(USER_LOGIN);
	   if(account != null && !className.equals("InitAction")) {
		   return invocation.invoke();
	   }else if(action != null && className.equals("InitAction")) {
			   return invocation.invoke();
	   }else if (action instanceof Anonymous) {
			return invocation.invoke();
		}
	   session.put(ORIGINAL_URL, buildOriginalURL(request));
	   return Action.LOGIN;
	}
	/**
	 * 组装请求的url
	 * 
	 * @param request
	 * @return
	 */
	private String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String[] values = (String[]) parameters.get(key);
				for (int i = 0; i < values.length; i++) {
					originalURL.append(key).append("=").append(values[i])
							.append("&");
				}
			}
		}
		return originalURL.toString();
	}
	
}
