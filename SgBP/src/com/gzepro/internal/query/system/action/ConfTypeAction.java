package com.gzepro.internal.query.system.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.ConfType;
import com.gzepro.internal.query.system.service.ConfTypeService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.confType")
public class ConfTypeAction extends SystemBaseJsonAction { 
	
	@Resource
	private ConfTypeService confTypeService;
	
	public String viewAdd() {
		return "add"; 
	}
	
	public String add() {
		confType.setValid("1");
		confType = confTypeService.add(confType);; 
		this.saveSysLog(Constants.SYSTEM_CONFTYPE, "新增,id="+confType.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		confType = confTypeService.findById(id);
		return "edit"; 
	}
	
	public String edit()  throws Exception{
		confTypeService.edit(confType);
		this.saveSysLog(Constants.SYSTEM_CONFTYPE, "修改,id="+confType.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		confType = confTypeService.findById(id);
		return "view"; 
	}

	public String delete() {
		confTypeService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_CONFTYPE, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		confTypeService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_CONFTYPE, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_CONFTYPE, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_CONFTYPE, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String codeExist(){
		String code = request.getParameter("code");
		confType = confTypeService.codeExist(code);
		if(confType!=null){
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
		if(searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		}
		jsonPaging = confTypeService.findAll(jsonPaging,code,name,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	 
	public String findById() { 
		confType = confTypeService.findById(id);
		renderText(JSONUtils.toJSONString(confType));
		return null; 
	}
	
	private ConfType confType = new ConfType();
	
	public ConfType getConfType() {
		return confType;
	}

	public void setConfType(ConfType confType) {
		this.confType = confType;
	}
	
}
