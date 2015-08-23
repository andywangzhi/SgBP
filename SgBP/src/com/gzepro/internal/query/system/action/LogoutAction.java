package com.gzepro.internal.query.system.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.base.action.AnonymousBaseAction;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Online;
import com.gzepro.internal.query.system.service.OnlineService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.logout")
public class LogoutAction  extends AnonymousBaseAction{
	@Resource
	private OnlineService onlineService;
	public String execute() throws Exception {
		    super.execute();
		    Account account = this.getAccount();
		    if(account != null){
			    this.saveSysLog(account.getLoginCode(), account.getNameCN(), "退出", "退出成功");//系统退出日志
			    deleteOnline(account);//在线用户数据
		    }
			ActionContext.getContext().getSession().clear();
			
			return SUCCESS;
	}
	
	/**
	 * 在线日志删除
	 * @param remark
	 */
	public void deleteOnline(Account account){
		Online online = onlineService.findByLoginId(account.getLoginCode());
		if(online!=null){
			onlineService.deleteById(online.getId());
		}
	}
}
