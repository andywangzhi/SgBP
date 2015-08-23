package com.gzepro.internal.query.system.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.common.util.tree.GridTreeUtil;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.Role;
import com.gzepro.internal.query.system.service.GroupService;
import com.gzepro.internal.query.system.service.RoleService;
import com.gzepro.internal.query.system.vo.TreeBean;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.role")
public class RoleAction extends SystemBaseJsonAction {
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private GroupService groupService;
	
	public String viewAdd() {
		return "add"; 
	}
	
	public String add() {
		role = roleService.add(role);
		this.saveSysLog(Constants.SYSTEM_ROLE, "新增,id="+role.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		role = roleService.findById(id);
		return "edit"; 
	}
	
	public String edit() {
		role = roleService.edit(role);
		this.saveSysLog(Constants.SYSTEM_ROLE, "修改,id="+role.getId());
		//roleMenuStr的格式为
		//menuid1;dicId1:dicId2:dicId3:dicId4,menuid2;dicId1:dicId4,
		roleService.saveRoleMenu(role.getId(),menuIds);
		String[] arrTmp = userIds.split("=");
		
		String groupUserIds = arrTmp[0];
		String roleUserIds = arrTmp[1];
		if(groupUserIds.equals("-1")){
			groupUserIds = "";
		}
		if(roleUserIds.equals("-1")){
			roleUserIds = "";
		}
		this.saveSysLog(Constants.SYSTEM_ROLERIGHT, "修改,roleid="+role.getId()+",menuIds="+menuIds);
		roleService.saveRoleAccount(role.getId(),roleUserIds);
		String allUserIds = "";
		
		if(groupUserIds.equals("")){
			allUserIds = roleUserIds;
		}else{
			if(roleUserIds.equals("")){
				allUserIds = groupUserIds;
			}else{
				allUserIds = groupUserIds+","+roleUserIds;
			}
		}
		groupService.saveAccount(role.getGroupId(), allUserIds);
		this.saveSysLog(Constants.SYSTEM_ACCOUNTRIGHT, "修改,roleid="+role.getId()+",userIds="+userIds);
		
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		role = roleService.findById(id);
		return "view"; 
	}

	public String delete() {
		roleService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_ROLE, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		roleService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_ROLE, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_ROLE, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_ROLE, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	
	public String findAll() {
		jsonPaging = this.getJsonPaging();
		String name = request.getParameter("name");//名称 用于搜索
		String remark = request.getParameter("remark");//描述 用于搜索
		String groupId = request.getParameter("groupId");//组ID 用于搜索
		String valid = request.getParameter("valid");//状态 用于搜索
		jsonPaging = roleService.findAll(jsonPaging,name,remark,groupId,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		role = roleService.findById(id);
		renderText(JSONUtils.toJSONString(role));
		return null; 
	}
	
	/**
	 * 加载授权表格树--用户组使用
	 * @return
	 */
	public String findGroupMenu() {
		HttpServletRequest request = this.getRequest();
		Long groupId = null;
		if(request.getParameter("groupId") != null && Long.parseLong(request.getParameter("groupId")) != 0L){
			groupId = Long.parseLong(request.getParameter("groupId"));
		}
		List<TreeBean> list = roleService.findAllMenu(groupId);
		int totalNum = list.size();
		
		// 调用工具类的方法计算起始行和终止行（为前开和后开的）。
		int[] rowStartEnd = GridTreeUtil.getStartAndEndInfo(request, totalNum,DEFAULT_PAGE_SIZE);
		
		// 调用工具类的方法得到json字符串。
		String jsonStr = GridTreeUtil.getJsonStr(list, request);
		renderText(jsonStr);
		return null; 
	}
	
	/**
	 * 加载授权表格树--角色使用
	 * @return
	 */
	public String findRootMenu() {
		Long roleId = Long.parseLong(request.getParameter("roleId"));
		Long groupId = Long.parseLong(request.getParameter("groupId"));
		List<TreeBean> list = roleService.findRootAll(groupId,roleId);
		int totalNum = list.size();
		
		// 调用工具类的方法计算起始行和终止行（为前开和后开的）。
		int[] rowStartEnd = GridTreeUtil.getStartAndEndInfo(request, totalNum,DEFAULT_PAGE_SIZE);
		
		// 调用工具类的方法得到json字符串。
		String jsonStr = GridTreeUtil.getJsonStr(list, request);
		renderText(jsonStr);
		return null; 
	}
	
	/**
	 * 获取用户组
	 * @return
	 */
	public String findUserRole() throws Exception{
		String name = request.getParameter("name");//名称 用于搜索
		String id = request.getParameter("groupId");//组Id 用于搜索
		Long groupId = 0L;
		if(name != null && !name.equals("")){
			name = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "UTF-8"), "UTF-8");
		}
		if(id != null && !id.equals("")){
			groupId =  new Long(id);
		}
		List<Role> list = roleService.findUserRole(groupId,name);
	   	ArrayList aList = new ArrayList();
		for(Role role:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", role.getId());
			jsonObject.put("name", role.getName());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
		return null; 
	}
	
	/**
	 * 通过用户ID获得用户已有的角色
	 * @return
	 */
	public String findSelectedRole() {
		String idStr = request.getParameter("accountId");//用户Id 用于搜索
		Long accountId = 0L;
		if(idStr != null && !idStr.equals("")){
			accountId = new Long(idStr);
		}
		List<Role> list = roleService.findSelectedRole(accountId);
	   	ArrayList aList = new ArrayList();
		for(Role role:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", role.getId());
			jsonObject.put("name", role.getName());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
		return null; 
	}
	private String userIds ;
	private String menuIds ;
	
	private Role role = new Role();

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	
}
