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
import com.gzepro.internal.query.system.model.ConfType;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.service.ConfTypeService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.conf")
public class ConfAction extends SystemBaseJsonAction { 
	
	@Resource
	private ConfService confService;
	
	@Resource
	private ConfTypeService confTypeService;
	
	public String viewAdd() {
		confTypeList = confTypeService.findAll();
		return "add"; 
	}
	
	public String add() {
		conf.setValid("1");
		conf = confService.add(conf);; 
		this.saveSysLog(Constants.SYSTEM_CONF, "新增,id="+conf.getId());
		renderText("保存成功"); 
		return null; 
	}
	
	public String viewEdit() {
		confTypeList = confTypeService.findAll();
		conf = confService.findById(id);
		if(conf.getParentId()==null){
			conf.setParentId(0L);
		}
		return "edit"; 
	}
	
	public String edit()  throws Exception{
		confService.edit(conf);
		this.saveSysLog(Constants.SYSTEM_CONF, "修改,id="+conf.getId());
		renderText("修改成功"); 
		return null; 
	}
	
	public String view() {
		confTypeList = confTypeService.findAll();
		conf = confService.findById(id);
		if(conf.getParentId()==null){
			conf.setParentId(0L);
		}
		return "view"; 
	}

	public String delete() {
		confService.delete(ids);
		this.saveSysLog(Constants.SYSTEM_CONF, "彻底删除,id="+ids);
		renderText("删除成功"); 
		return null; 
	}
	
	public String saveStatus(){
		String status = request.getParameter("status");
		confService.saveStatus(ids,status);
		if(status.equals("1")){
			this.saveSysLog(Constants.SYSTEM_CONF, "激活,ids="+ids);
		}else if(status.equals("0")){
			this.saveSysLog(Constants.SYSTEM_CONF, "停用,ids="+ids);
		}else if(status.equals("2")){
			this.saveSysLog(Constants.SYSTEM_CONF, "删除,ids="+ids);
		}
		renderText("修改成功"); 
		return null; 
	}
	
	public String codeExist(){
		String code = request.getParameter("code");
		conf = confService.codeExist(code);
		if(conf!=null){
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
		jsonPaging = this.getJsonPaging();
		String searchflag=request.getParameter("searchflag");//是否刚才点击的是搜索按钮
		if (searchflag.equals("1"))  //如果是点击了搜索 把查询列表置为第一页
		{
			jsonPaging.setPage(1);
		}
		jsonPaging = confService.findAll(jsonPaging,code,name,type,valid);
		renderText(toJSONString(jsonPaging));
		return null; 
	}
	
	public String findById() {
		confTypeList = confTypeService.findAll();
		conf = confService.findById(id);
		renderText(JSONUtils.toJSONString(conf));
		return null; 
	}
	
	public String findTypeForJson()
	{
		List<ConfType> list = confTypeService.findAll();
	   	ArrayList aList = new ArrayList();
		for(ConfType confType:list){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", confType.getId());
			jsonObject.put("name", confType.getName());
			aList.add(jsonObject);
		}
		renderText(JSONUtils.toJSONString(aList));
  	    return null;
	}
	
	public String findConfJsonStr() {
		Long typeId = null;
		String confJsonStr = confService.findConfJsonStr(typeId);
		renderText(JSONUtils.toJSONString(confJsonStr));
		return null; 
	}
	
	private Conf conf = new Conf();

	private List<ConfType> confTypeList;
	
	public Conf getConf() {
		return conf;
	}

	public void setConf(Conf conf) {
		this.conf = conf;
	}
	
	public List<ConfType> getConfTypeList() {
		return confTypeList;
	}

	public void setConfTypeList(List<ConfType> confTypeList) {
		this.confTypeList = confTypeList;
	}
}
