package com.gzepro.internal.query.system.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.SysLog;
import com.gzepro.internal.query.system.service.ChangeLogService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.changeLog")
public class ChangeLogAction extends SystemBaseJsonAction {

	private ChangeLogService changeLogService;
	public String toList() {
		return "success";
	}

	public String add() {
		sysLog.setCreateDate(new Date());
		sysLogService.add(sysLog);
		renderText("保存成功");
		return null;
	}

	public String viewEdit() {
		sysLog = sysLogService.findById(id);
		return "edit";
	}

	public String edit() {
		sysLog.setCreateDate(new Date());
		sysLogService.edit(sysLog);
		renderText("修改成功");
		return null;
	}

	public String view() {
		sysLog = sysLogService.findById(id);
		return "view";
	}

	public String delete() {
		sysLogService.delete(ids);
		renderText("删除成功");
		return null;
	}

	public String findAll() {
		String time = request.getParameter("time");//用于搜索
		String type = request.getParameter("changetype");//用于搜索
		jsonPaging = this.getJsonPaging();
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if(searchflag != null && searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		}
		jsonPaging = changeLogService.findAll(jsonPaging,time,type);
		renderText(toJSONString(jsonPaging));
		return null;
	}

	public String findById() {
		sysLog = sysLogService.findById(id);
		renderText(JSONUtils.toJSONString(sysLog));
		return null;
	}

	private String parentId;
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String load() {
		String res = "[";
		res += this.getJson(parentId);
		res += "]";
		System.out.println(res);
		renderText(res);
		return null;
	}

	public String getJson(String parentId) {
		String tempRes= "{\"attr\":{\"id\":\"1\"},\"state\":\"open\",\"data\":\"1\" ,\"children\":[{\"attr\":{\"id\":\"1187\"},\"state\":\"open\",\"data\":\"1187\"}]}";
		return tempRes;
	}

	private SysLog sysLog = new SysLog();

	public SysLog getSysLog() {
		return sysLog;
	}

	public void setSysLog(SysLog sysLog) {
		this.sysLog = sysLog;
	}

	public ChangeLogService getChangeLogService() {
		return changeLogService;
	}

	public void setChangeLogService(ChangeLogService changeLogService) {
		this.changeLogService = changeLogService;
	}
}
