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
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.Dictionary;
import com.gzepro.internal.query.system.model.Menu;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.service.DictionaryService;
import com.gzepro.internal.query.system.service.MenuService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.menu")
public class MenuAction extends SystemBaseJsonAction {
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private ConfService confService;
	
	@Resource
	private DictionaryService dictionaryService;
	
	private List<Dictionary> dicList = new ArrayList<Dictionary>();
	private List<Conf> confList = new ArrayList<Conf>();
	private List selectedDic = new ArrayList();
	
	public String viewAdd() {
		confList = confService.findAll(1L);
		dicList = dictionaryService.findAll();
		return "add"; 
	}
	
	public String add() {
		menu=menuService.add(menu);
		menuService.saveDic(menu.getId(),dicIds);
		this.saveSysLog(Constants.SYSTEM_MENU, "新增,id="+menu.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		menu = menuService.findById(id);
		confList = confService.findAll(1L);
		dicList = dictionaryService.findAll();
		if(menu.getParentId()==null){
			menu.setParentId(0L);
		}
		String dicIds = menu.getDicIds();
		if(dicIds != null && !dicIds.equals("")){
			String[] arr = dicIds.split(",");
			for(int i = 0 ; i < arr.length ; i++){
				selectedDic.add(arr[i]);
			}
		}
		return "edit"; 
	}
	
	public String edit() {
		menu = menuService.edit(menu);
		menuService.saveDic(menu.getId(),dicIds);
		this.saveSysLog(Constants.SYSTEM_MENU, "修改,id="+menu.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		menuService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_MENU, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_MENU, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_MENU, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		menu = menuService.findById(id);
		confList = confService.findAll(1L);
		dicList = dictionaryService.findAll();
		menu = menuService.findById(id);
		if(menu.getParentId()==null){
			menu.setParentId(0L);
		}
		String dicIds = menu.getDicIds();
		if(dicIds != null && !dicIds.equals("")){
			String[] arr = dicIds.split(",");
			for(int i = 0 ; i < arr.length ; i++){
				selectedDic.add(arr[i]);
			}
		}
		return "view"; 
	}

	public String delete() {
		menuService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_MENU, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String menuCodeExist(){
		String code = request.getParameter("menuCode");
		menu = menuService.menuCodeExist(code);
		if(menu!=null){
			renderText("true");
		}else{
			renderText("false");
		}
		return null;
	}
	
	public String findAll() {
		jsonPaging = this.getJsonPaging();
		String code = request.getParameter("code");//用于搜索
		String name = request.getParameter("name");//用于搜索
		String type = request.getParameter("type");//用于搜索
		String valid = request.getParameter("valid");//用于搜索
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		
		}
		jsonPaging = menuService.findAll(jsonPaging,code,name,type,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		menu = menuService.findById(id);
		renderText(JSONUtils.toJSONString(menu));
		return null; 
	}
	
	public String findMenuJsonStr() {
		String menuJsonStr = menuService.findMenuJsonStr();
		renderText(JSONUtils.toJSONString(menuJsonStr));
		return null; 
	}
	
	public String findGroupForJsonSec() {
		String selectedIds = request.getParameter("selectedIds");//已选菜单
		String menuJsonStr = menuService.findMenuJsonStrSec(selectedIds);
		renderText(JSONUtils.toJSONString(menuJsonStr));
		return null; 
	}
	
	public String findTypeForJson()
	{
		List<Conf> list = confService.findAll(1L);
	   	ArrayList aList = new ArrayList();
		for(Conf type:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", type.getId());
			jsonObject.put("name", type.getName());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	private String dicIds ;

	private Menu menu = new Menu();

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getDicIds() {
		return dicIds;
	}

	public void setDicIds(String dicIds) {
		this.dicIds = dicIds;
	}

	public List getSelectedDic() {
		return selectedDic;
	}

	public void setSelectedDic(List selectedDic) {
		this.selectedDic = selectedDic;
	}
	
	public List<Conf> getConfList() {
		return confList;
	}

	public void setConfList(List<Conf> confList) {
		this.confList = confList;
	}

	public void setDicList(List<Dictionary> dicList) {
		this.dicList = dicList;
	}

	public List<Dictionary> getDicList() {
		return dicList;
	}
	
}
