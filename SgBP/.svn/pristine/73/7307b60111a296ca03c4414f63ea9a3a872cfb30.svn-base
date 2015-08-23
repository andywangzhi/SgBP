package com.gzepro.internal.query.soa.action.rcsm.need;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed;
import com.gzepro.internal.query.base.action.BaseJsonAction;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.need.RsPersonneedForm;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonneedService;

/**
 * 人才需求管理
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.rsPersonneed")
public class RsPersonneedAction extends BaseJsonAction{
	
    private RsPersonneedForm form = new RsPersonneedForm();
    @Resource
	private RsPersonneedService	 rsPersonneedService;

	/*添加或修改招工信息
	public String addOrUpdate(){
		JSONObject json=new	JSONObject();
		try{
			//如果已经申请关注就不再申请			
			Account account=(Account)ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);	
			if(!account.getUserflag().equals("cop")){
				json.put("flag", 1);//添加失败
				outputJson(json);
				return NONE;
			}
			form.getRsPersonneed().setModifydate(DateUtil.getCurDateTime());
			form.getRsPersonneed().setNeedcopname(account.getLoginCode());
			form.getRsPersonneed().setModifyuser(account.getLoginCode());
			if(form.getRsPersonneed().getNeedid() == null || form.getRsPersonneed().getNeedid().equals("")){
				form.getRsPersonneed().setAdduser(account.getLoginCode());
				form.getRsPersonneed().setBackupone("申请中");
				rsPersonneedSer.add(form.getRsPersonneed());
			}else{
				rsPersonneedSer.update(form.getRsPersonneed());
			}						
			json.put("flag", 0);//添加成功
		}catch (Exception e) {
			e.printStackTrace();
			json.put("flag", 1);//添加失败
		}
		outputJson(json);
		return NONE;
	}*/
	
	public String toaddpage() throws Exception{
		if(form.getBusiness().equals("add")){						
			
		}else{
			if(form.getRsPersonneed().getNeedid() != null && !form.getRsPersonneed().getNeedid().equals("")){				
				RsPersonneed obj = new RsPersonneed();
				obj.setNeedid(form.getRsPersonneed().getNeedid());
				Paging pag = rsPersonneedService.queryByPage(paging, obj);
				if(pag.getVoList() != null && pag.getVoList().size() > 0){
					form.setRsPersonneed((RsPersonneed)pag.getVoList().get(0));
				}				
			}
		}		
		return "neededit";
	}
	
	/*private List<RsAttention> findAttenList(String needno){
		RsAttention obj = new RsAttention();
		obj.setNeedno(needno);
		Paging paging = new Paging();
		paging.setPageSize(50);
		List<RsAttention> list = rsAttentionSer.queryByPage(paging, obj);
		return list;
	}*/
	public String toviewpagefortj() throws Exception{
		if(form.getBusiness().equals("add")){						
			
		}else{
			if(form.getRsPersonneed().getNeedid() != null && !form.getRsPersonneed().getNeedid().equals("")){				
				RsPersonneed obj = new RsPersonneed();
				obj.setNeedid(form.getRsPersonneed().getNeedid());
				Paging pag = rsPersonneedService.queryByPage(paging, obj);
				if(pag.getVoList() != null && pag.getVoList().size() > 0){
					form.setRsPersonneed((RsPersonneed)pag.getVoList().get(0));
				}				
			}
		}	
		return "neededitforadmin";
	}
	
	
	public String toviewpage() throws Exception{
		if(form.getBusiness().equals("add")){						
			
		}else{
			if(form.getRsPersonneed().getNeedid() != null && !form.getRsPersonneed().getNeedid().equals("")){				
				RsPersonneed obj = new RsPersonneed();
				obj.setNeedid(form.getRsPersonneed().getNeedid());
				Paging pag = rsPersonneedService.queryByPage(paging, obj);
				if(pag.getVoList() != null && pag.getVoList().size() > 0){
					form.setRsPersonneed((RsPersonneed)pag.getVoList().get(0));
				}				
			}
		}
		return "neededitforadmin";
	}
	
	/*public static String getNeedNo(){
		String needNo;
		try {
			Thread.sleep(11);
			needNo = DateUtil.getYYYYMMDDHHMMSSDate(new Date());
			if(needNo.length()<15){
				needNo += String.valueOf(Math.round(Math.random()*10)) + String.valueOf(Math.round(Math.random()*10));;
			}
			
		} catch (InterruptedException e) {
			
			needNo = DateUtil.getYYYYMMDDHHMMSSDate(new Date())+String.valueOf(Math.round(Math.random()*10))+String.valueOf(Math.round(Math.random()*10));
			if(needNo.length()<15){
				needNo += String.valueOf(Math.round(Math.random()*10));
			}
		}
		return needNo;
	}*/
	
	/**
	 *  查询页面
	 
	public String query() {
		try {							
			Account account=(Account)ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);		
			if(!account.getUserflag().equals("cop")){
				return "error";
			}
			form.getRsPersonneedQuery().setAdduser(account.getLoginCode());
			form.getRsPersonneedQuery().setNeedcopname(account.getLoginCode());
			List<RsPersonneed> dtoList = (List<RsPersonneed>) rsPersonneedSer.queryByPage(paging,form.getRsPersonneedQuery());
			form.setDtoList(dtoList);	
			return "needlist";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}*/
	
	public String toneedlist(){
		try {						
			RsPersonneed rsPersonneedQuery=form.getRsPersonneedQuery();
			rsPersonneedQuery.setNeedcopname((rsPersonneedQuery.getNeedcopname()==null?null:rsPersonneedQuery.getNeedcopname().trim()));
			rsPersonneedQuery.setNeedno(((rsPersonneedQuery.getNeedno()==null?null:rsPersonneedQuery.getNeedno().trim())));
			Paging pagingTemp = rsPersonneedService.queryByPage(paging,form.getRsPersonneedQuery());
			if(pagingTemp != null && pagingTemp.getVoList()!= null ){
				form.setDtoList(pagingTemp.getVoList());
			}else{
				form.setDtoList(new ArrayList<RsPersonneed>());
			}
				
			return "needlistforadmin";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}		
		
	}	
	/*public String deleteNeed(){
		Account account=(Account)ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);		
		if(!account.getUserflag().equals("cop")){
			return "error";
		}
		JSONObject json=new	JSONObject();
		try{			
			if(form.getIds() != null && !form.getIds().equals("")){
				String [] arr_id = form.getIds().split(",");
				for(String id : arr_id){
					rsPersonneedSer.deleteById(id);
				}			
			}
			json.put("flag", 0);//添加成功
		}catch(Exception e){
			e.printStackTrace();
			json.put("flag", 1);//添加成功
		}
		outputJson(json);
		return NONE;
	}*/


	

	public RsPersonneedForm getForm() {
		return form;
	}

	public void setForm(RsPersonneedForm form) {
		this.form = form;
	}

}
