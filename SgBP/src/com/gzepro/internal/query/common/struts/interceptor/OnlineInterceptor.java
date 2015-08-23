package com.gzepro.internal.query.common.struts.interceptor;

import java.util.Date;

import javax.annotation.Resource;

import com.gzepro.internal.query.common.struts.ContextPvd;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Online;
import com.gzepro.internal.query.system.service.OnlineService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
public class OnlineInterceptor extends AbstractInterceptor{
	
	@Resource
	protected OnlineService onlineService;
	
	@Resource
	protected ContextPvd contextPvd;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	   Account account = (Account) ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);
	   if(account != null) {
		   saveOpdateOnline(account);
		   return invocation.invoke();
	   } 
	   return invocation.invoke();
	}
	
	/**
	 * 在线日志增加或者修改
	 * @param remark
	 */
	public void saveOpdateOnline(Account account){
		Online online = onlineService.findByLoginId(account.getLoginCode());
		if(online!=null){
			online.setLastVisitDate(new Date());
			online.setOperIp(contextPvd.getRemoteIp());
			onlineService.edit(online);
		}else{
			online = new Online();
			online.setLoginId(account.getLoginCode());
			online.setAccountName(account.getNameCN());
			online.setLoginDate(new Date());
			online.setLastVisitDate(new Date());
			online.setOperIp(contextPvd.getRemoteIp());
			online.setAccountLevel("");;
			onlineService.add(online);
		}
		onlineService.deleteOverOnline();//删除过期的在线用户数据
	}
}
