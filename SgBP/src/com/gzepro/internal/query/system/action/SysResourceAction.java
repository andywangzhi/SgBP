package com.gzepro.internal.query.system.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.SysResource;
import com.gzepro.internal.query.system.service.SysResourceService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.sysResource")
public class SysResourceAction extends SystemBaseJsonAction {
	
	@Resource
	private SysResourceService sysResourceService;
	
	public String viewAdd() {
		return "add"; 
	}
	
	public String add() {
		sysResource = sysResourceService.add(sysResource);
		this.saveSysLog(Constants.SYSTEM_RESOURCE, "新增,id="+sysResource.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		sysResource = sysResourceService.findById(id);
		return "edit"; 
	}
	
	public String edit() {
		sysResourceService.edit(sysResource);
		this.saveSysLog(Constants.SYSTEM_RESOURCE, "修改,id="+sysResource.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		sysResource = sysResourceService.findById(id);
		return "view"; 
	}

	public String delete() {
		sysResourceService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_RESOURCE, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		sysResourceService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_RESOURCE, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_RESOURCE, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_RESOURCE, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String resourceCodeExist(){
		String code = request.getParameter("resourceCode");
		sysResource = sysResourceService.resourceCodeExist(code);
		if(sysResource!=null){
			renderText("true");
		}else{
			renderText("false");
		}
		return null;
	}
	
	public String findAll() {
		jsonPaging = this.getJsonPaging();
		String code = request.getParameter("code");//用于搜索
		String dec = request.getParameter("dec");//用于搜索
		String type = request.getParameter("type");//用于搜索
		String valid = request.getParameter("valid");//用于搜索
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		
		}
		
		jsonPaging = sysResourceService.findAll(jsonPaging,code,dec,type,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		sysResource = sysResourceService.findById(id);
		renderText(JSONUtils.toJSONString(sysResource));
		return null; 
	}
	
	public String refreshResource() {
		ServletContext servletContext = ServletActionContext.getServletContext();
		//servletContext.removeAttribute("_WEB_SYS_RESOURCE_KEY_");
		List<SysResource> list = sysResourceService.findAll();
		Map<String,String[]> map = new HashMap<String,String[]>(); 
		//Map<String,String[]> map = (HashMap)servletContext.getAttribute("_WEB_SYS_RESOURCE_KEY_"); 
		if(list != null && list.size() >0){
			for(SysResource resource:list){
				String[] arr = new String[3];
				if(resource.getKey() != null && !resource.getKey().equals("")){
					if(resource.getNameZh() != null && !resource.equals("")){
						arr[0] = resource.getNameZh();
					}else{
						arr[0] = resource.getKey();
					}
					if(resource.getNameEn() != null && !resource.getNameEn().equals("")){
						arr[1] = resource.getNameEn();
					}else{
						arr[1] = resource.getKey();
					}
					if(resource.getNameTw() != null && !resource.getNameTw().equals("")){
						arr[2] = resource.getNameTw();
					}else{
						arr[2] = resource.getKey();
					}
					map.put(resource.getKey(), arr);
				}
			}
			servletContext.setAttribute("_WEB_SYS_RESOURCE_KEY_", map);
		}
		renderText("刷新成功");
		return null; 
	}
	
	private SysResource sysResource = new SysResource();

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}
	
}
