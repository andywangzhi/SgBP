package com.gzepro.internal.query.system.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.service.OnlineService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.online")
public class OnlineAction extends SystemBaseJsonAction {
	
	@Resource
	private OnlineService onlineService;
	
	public String findAll() {
		jsonPaging = this.getJsonPaging();
		jsonPaging = onlineService.findAll(jsonPaging);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
}
