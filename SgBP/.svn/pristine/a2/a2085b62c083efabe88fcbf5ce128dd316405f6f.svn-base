package com.gzepro.internal.query.system.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.base.SystemBaseJsonAction;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.Dictionary;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.service.DictionaryService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.dictionary")
public class DictionaryAction extends SystemBaseJsonAction { 
	
	@Resource
	private DictionaryService dictionaryService;
	
	@Resource
	private ConfService confService; 
	
	private List<Conf> confList = new ArrayList<Conf>();
	private List selectedDic = new ArrayList(); 
	public String viewAdd() {
		confList = confService.findAll(1L);
		return "add"; 
	}
	
	public String add() {
		dictionary.setSensitive("1");
		dictionary = dictionaryService.add(dictionary);
		String str = "";
		if(!menuIds.equals("")){
			String[] arr = menuIds.split(",");
			for(int i=0; i<arr.length;i++){
				if(i==0){
					str = arr[i].trim();
				}else{
					str += arr[i].trim();
				}
			}
		}
		dictionaryService.saveMenuDic(dictionary.getId(),str); 
		this.saveSysLog(Constants.SYSTEM_DICTIONARY, "新增,id="+dictionary.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		confList = confService.findAll(1L);
		dictionary = dictionaryService.findById(id);
		return "edit"; 
	}
	
	public String edit()  throws Exception{
		dictionaryService.edit(dictionary);
		String str = "";
		if(!menuIds.equals("")){
			String[] arr = menuIds.split(",");
			for(int i=0; i<arr.length;i++){
				if(i==0){
					str = arr[i].trim();
				}else{
					str += ","+arr[i].trim();
				}
			}
		}
		dictionaryService.saveMenuDic(dictionary.getId(),str);
		this.saveSysLog(Constants.SYSTEM_DICTIONARY, "修改,id="+dictionary.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		confList = confService.findAll(1L);
		dictionary = dictionaryService.findById(id);
		return "view"; 
	}

	public String delete() {
		dictionaryService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_DICTIONARY, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		dictionaryService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_DICTIONARY, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_DICTIONARY, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_DICTIONARY, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String dictionaryCodeExist(){
		String code = request.getParameter("dictionaryCode");
		dictionary = dictionaryService.dictionaryCodeExist(code);
		if(dictionary!=null){
			renderText("true");
		}else{
			renderText("false");
		}
		return null;
	}
	
	public String findAll() {
		String code = request.getParameter("code");//用于搜索
		String name = request.getParameter("name");//用于搜索
		String type = request.getParameter("type");//用于搜索
		String valid = request.getParameter("valid");//用于搜索
		String sensitive = request.getParameter("sensitive");//用于搜索
		jsonPaging = this.getJsonPaging();
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		
		}
		jsonPaging = dictionaryService.findAll(jsonPaging,code,name,type,valid,sensitive);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findAllForMenuId() {
		String menuId = request.getParameter("menuId");//菜单Id
		if(menuId == null || menuId.equals("0") ){
			menuId = "0";
		}
		this.setPage(1);
		this.setRows(1000);
		jsonPaging = this.getJsonPaging();
		jsonPaging = dictionaryService.findAll(jsonPaging,new Long(menuId));
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		dictionary = dictionaryService.findById(id);
		renderText(JSONUtils.toJSONString(dictionary));
		return null; 
	}
	
	private Dictionary dictionary = new Dictionary();

	private String menuIds = "";
	private String roleIds = "";
	
	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public List<Conf> getConfList() {
		return confList;
	}

	public void setConfList(List<Conf> confList) {
		this.confList = confList;
	}

	public List getSelectedDic() {
		return selectedDic;
	}

	public void setSelectedDic(List selectedDic) {
		this.selectedDic = selectedDic;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	
}
