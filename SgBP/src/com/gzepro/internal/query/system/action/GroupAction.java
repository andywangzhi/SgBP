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
import com.gzepro.internal.query.system.model.Group;
import com.gzepro.internal.query.system.service.GroupService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.group")
public class GroupAction extends SystemBaseJsonAction {

	@Resource
	private GroupService groupService;
	
	public String viewAdd() {
		return "add"; 
	}
	
	public String add() {
		group = groupService.add(group);
		String groupAdminIds = "";
		String groupAccounts = "";
		 
		if(manegerIds != null && !manegerIds.equals("")){
 			String[] arr=manegerIds.split("=");
			if(arr.length==2){
				 String str0 = arr[1];//组管理员
		         String str1 = arr[0];//组用户
		     
				if(str0 != null && !str0.equals("-1")){
		        	if(str0.endsWith(","))str0=str0.substring(0,str0.length()-1);
		        	groupAdminIds = str0;
		        }
				if(str1 != null && !str1.equals("-1")){
		        	if(str1.endsWith(","))str1=str1.substring(0,str1.length()-1);
		        	groupAccounts = str1;
		        }
			}else if(arr.length==1){
		        String str0 = arr[0];
				if(str0 != null && !str0.equals("")){
		        	if(str0.endsWith(","))str0=str0.substring(0,str0.length()-1);
		        	groupAdminIds = str0;
		        }
			}
		}
		groupService.saveRight(group.getId(),groupAdminIds,menuIds);
		groupService.saveAccount(group.getId(),groupAccounts);//保存组成员
		this.saveSysLog(Constants.SYSTEM_GROUP, "新增,id="+group.getId());
		this.saveSysLog(Constants.SYSTEM_GROUPRIGHT, "新增,id="+group.getId()+",menuIds="+menuIds);
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		group = groupService.findById(id);
		return "edit"; 
	}
	
	public String edit() {
		group = groupService.edit(group);
		String groupAdminIds = "";
		String groupAccounts = "";
		if(manegerIds != null && !manegerIds.equals("")){
			String[] arr=manegerIds.split("=");
	        String str0 = arr[0];
	        String str1 = arr[1];
			if(str0 != null && !str0.equals("")){
	        	if(str0.endsWith(","))str0=str0.substring(0,str0.length()-1);
		        groupAccounts = str0;
	        }
			if(str1 != null && !str1.equals("")){
	        	if(str1.endsWith(","))str1=str1.substring(0,str1.length()-1);
	        	groupAdminIds = str1;
	        }
		}
		groupService.saveRight(group.getId(),groupAdminIds,menuIds);
		groupService.saveAccount(group.getId(),groupAccounts);//保存组成员
		this.saveSysLog(Constants.SYSTEM_GROUP, "修改,id="+group.getId());
		this.saveSysLog(Constants.SYSTEM_GROUPRIGHT, "修改,id="+group.getId()+",menuIds="+menuIds);
		renderText("修改成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		boolean flag = groupService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_GROUP, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_GROUP, "停用,ids="+ids);
		}else if(status.equals("2")){
			if(!flag){
				renderText("false"); 
				return null; 
			}
			this.saveSysLog(Constants.SYSTEM_GROUP, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		group = groupService.findById(id);
		return "view"; 
	}

	public String delete() {
		groupService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_GROUP, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String findAll() {
		jsonPaging = this.getJsonPaging();
		String name = request.getParameter("name");//名称 用于搜索
		String remark = request.getParameter("remark");//描述 用于搜索
		String valid = request.getParameter("valid");//状态 用于搜索
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		
		}
		jsonPaging = groupService.findAll(jsonPaging,name,remark,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		group = groupService.findById(id);
		renderText(JSONUtils.toJSONString(group));
		return null; 
	}
	
	/**
	 * 加载登陆用户可选择的组,超级管理员和系统管理员组的成员可加载所有的组
	 * @return
	 */
	public String findUserGroup() {
		List<Group> list = groupService.findLoginUserGroup(this.getAccount().getId());
	   	ArrayList aList = new ArrayList();
	   	if(list != null){
			for(Group group:list){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("id", group.getId());
				jsonObject.put("name", group.getName());
				aList.add(jsonObject);
			}
	   	}
		renderText(JSONUtils.toJSONString(aList));
		return null; 
	}
	
	/**
	 * 获取用户组
	 * @return
	 */
	public String findGroup() throws Exception{
		String name = request.getParameter("name");//名称 用于搜索
		if(name != null && !name.equals("")){
			name = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "UTF-8"), "UTF-8");
		}
		List<Group> list = groupService.findUserGroup(name);
	   	ArrayList aList = new ArrayList();
		for(Group group:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", group.getId());
			jsonObject.put("name", group.getName());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
		return null; 
	}
	
	public String findGroupForJson() {
		String selectedIds = request.getParameter("selectedIds");//已选角色
		String menuJsonStr = groupService.findGroupForJson(selectedIds);
		renderText(JSONUtils.toJSONString(menuJsonStr));
		return null; 
	}
	
	private String manegerIds ;
	private String menuIds ;
	
	private Group group = new Group();

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getManegerIds() {
		return manegerIds;
	}

	public void setManegerIds(String manegerIds) {
		this.manegerIds = manegerIds;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
