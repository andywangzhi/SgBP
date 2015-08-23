package com.gzepro.internal.query.system.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.Dept;
import com.gzepro.internal.query.system.service.DeptService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.dept")
public class DeptAction extends SystemBaseJsonAction {
	
	@Resource
	private DeptService deptService;
	
	public String viewAdd() {
		return "add"; 
	}
	
	public String add() {
		dept = deptService.add(dept,accountIds);; 
		this.saveSysLog(Constants.SYSTEM_DEPT, "新增,id="+dept.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		dept = deptService.findById(id);
		if(dept.getParentId()==null){
			dept.setParentId(0L);
		}
		return "edit"; 
	}
	
	public String edit()  throws Exception{
		deptService.edit(dept,accountIds);
		this.saveSysLog(Constants.SYSTEM_DEPT, "修改,id="+dept.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		dept = deptService.findById(id);
		if(dept.getParentId()==null){
			dept.setParentId(0L);
		}
		return "view"; 
	}

	public String delete() {
		deptService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_DEPT, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		deptService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_DEPT, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_DEPT, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_DEPT, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String codeExist(){
		String code = request.getParameter("code");
		dept = deptService.codeExist(code);
		if(dept!=null){
			renderText("true");
		}else{
			renderText("false");
		}
		return null;
	}
	
	public String findAll() {
		String code = request.getParameter("code");//用于搜索
		String name = request.getParameter("name");//用于搜索
		String valid = request.getParameter("valid");//用于搜索
		jsonPaging = this.getJsonPaging();
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		}
		jsonPaging = deptService.findAll(jsonPaging,code,name,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findJSONByDeptName()throws Exception{
		String name = request.getParameter("name");
		if(name != null && !name.equals("")){
			name = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "UTF-8"), "UTF-8");
		}
		List<Dept> list =  deptService.loadDeptNodesList(name);
	   	ArrayList aList = new ArrayList();
		for(Dept dept:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", dept.getId());
			jsonObject.put("name", dept.getNameCN());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
		return null;
 	}
	
	public String findDeptJsonStr() {
		String deptJsonStr = deptService.findDeptJsonStr();
		renderText(JSONUtils.toJSONString(deptJsonStr));
		return null; 
	}
	
	private Dept dept = new Dept();

	private String accountIds = "";
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(String accountIds) {
		this.accountIds = accountIds;
	}
	
}
