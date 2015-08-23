package com.gzepro.internal.query.soa.action.rcsm.gzjl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.QueryWorkexperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.RetrieveWorkexperienceSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceForm;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.soa.service.user.impl.WorkexperienceService;

/**
 * 
 * @ClassName: WorkexperienceAction
 * @Description: TODO(后台业务系统工作简历Action类)
 * @author 张建薇
 * @date Jul 25, 2012 10:31:10 AM
 * 
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.Workexperience")
public class WorkexperienceAction extends SoaBaseJsonAction {
	@Resource
	private WorkexperienceService workexperienceService;// 通过spring注入业务实例
	private WorkexperienceForm form = new WorkexperienceForm();// 查询表单封装对象
	@Resource
	private RsPersonService rsPersonService;

	
	//测试入口
	@Override
	public String execute() throws Exception {
		try{
			//做测试
			String personId = (String) this.getSession().get("personId");
			if(personId == null || personId.trim().length() < 1) {
				return "out";
			}else{
				List<WorkexperienceDetailDTO> dtoDetailList=(List<WorkexperienceDetailDTO>) workexperienceService.findAll(personId,menuId,this.getAccount().getId());
				if(dtoDetailList!=null&&dtoDetailList.size()>0){
					form.setDtoDetailList(dtoDetailList);
				}else{
					form.setDtoDetailList(new ArrayList<WorkexperienceDetailDTO>());
				}
				form.getRetrieveSO().setPersonId(personId); 
				if(this.getSession().get("auditstate")!=null){
					form.setAuditstate(this.getSession().get("auditstate").toString());
				}
				return "list";
			}
		}catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_WORK, ex);
			return "error";
		}
	}
	
	/**
	 * 查询工作简历列表
	 */
	public String query() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("list");
			this.saveSysLog(Constants.SOA_WORK, queryInputParameter);//保存查询日志
		    // 调用ws
			List<WorkexperienceListDTO> dtoList = (List<WorkexperienceListDTO>) workexperienceService.query(form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<WorkexperienceListDTO>());
			}
			return "list";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_WORK, ex);
			return "list";
		}
	}
	
	/**
	 * 新增/编辑工作简历信息
	 */
	public String input() {
		String workId = form.getRetrieveSO().getWorkId();
		if(workId != null && !workId.equals("")){//编辑
			try {
				WorkexperienceDetailDTO dto= (WorkexperienceDetailDTO) workexperienceService.find(form.getRetrieveSO());
				form.setDto(dto);
			} catch (Exception ex) {
				// 统一异常处理类
				this.handleException(queryInputParameter,Constants.SOA_WORK, ex);
			}
		}
		return "input";
	}
	
	/**
	 * 保存工作简历信息
	 */
	public String saveOrUpdate() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_WORK, form.getDto().getWorkId());//保存查询日志
			List<WorkexperienceDetailDTO> dtoDetailList=form.getDtoDetailList();
			for (WorkexperienceDetailDTO dto : dtoDetailList) {
				if(null == dto)
					continue;
				if(dto.getFromDate()!=null&&!"".equals(dto.getFromDate())&&dto.getToDate()!=null&&!"".equals(dto.getToDate())&&dto.getCompanyName()!=null&&!"".equals(dto.getCompanyName())){
					dto.setPersonId(form.getRetrieveSO().getPersonId());//personID
					if(dto.getAdddate()==null||"".equals(dto.getAdddate())){
						dto.setAdduser(this.getAccount().getLoginCode());
						dto.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
					}else{
						dto.setModifyuser(this.getAccount().getLoginCode());
						dto.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
					}
					WorkexperienceListDTO dtoListObj=new WorkexperienceListDTO();
					CloneUtil.cloneObject(dto, dtoListObj, null);
					int result = workexperienceService.saveOrUpdate(dtoListObj);//再新增加
				}
			}
			form.setFlag("1");
			return "save";
		}catch (Exception ex) {
			this.handleException(form.getDto().getWorkId(),Constants.SOA_WORK, ex);
			form.setFlag("2");
			return "error";
		}
	}
	
	public String ajaxSaveOrUpdate() {
		JSONObject json=new	JSONObject();
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_WORK, form.getDto().getWorkId());//保存查询日志
			List<WorkexperienceDetailDTO> dtoDetailList=form.getDtoDetailList();
			for (WorkexperienceDetailDTO dto : dtoDetailList) {
				if(null == dto)
					continue;
				if(dto.getFromDate()!=null&&!"".equals(dto.getFromDate())&&dto.getToDate()!=null&&!"".equals(dto.getToDate())&&dto.getCompanyName()!=null&&!"".equals(dto.getCompanyName())){
					dto.setPersonId(form.getRetrieveSO().getPersonId());//personID
					if(dto.getAdddate()==null||"".equals(dto.getAdddate())){
						dto.setAdduser(this.getAccount().getLoginCode());
						dto.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
					}else{
						dto.setModifyuser(this.getAccount().getLoginCode());
						dto.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
					}
					WorkexperienceListDTO dtoListObj=new WorkexperienceListDTO();
					CloneUtil.cloneObject(dto, dtoListObj, null);
					int result = workexperienceService.saveOrUpdate(dtoListObj);//再新增加
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			this.handleException(form.getDto().getWorkId(),Constants.SOA_WORK, ex);
			json.put("flag", 2);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 查看工作简历详细信息
	 */
	public String view() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("view");
			this.saveSysLog(Constants.SOA_WORK, queryInputParameter);//保存查询日志
			//调用ws
			WorkexperienceDetailDTO dto= (WorkexperienceDetailDTO) workexperienceService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
			if(dto!=null){
				form.setDto(dto);
			}else{
				form.setDto(new WorkexperienceDetailDTO());
			}
			return "view";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_WORK, ex);
			return "view";
		}
	}
	
	/**
	 * 删除工作简历信息
	 */
	public String delete() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_WORK, form.getRetrieveSO().getWorkId());//保存查询日志
			int result = workexperienceService.delete(form.getRetrieveSO().getWorkId());
			return "delete";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_WORK, ex);
			return "delete";
		}
	}
	
	/**
	 * 删除工作简历信息
	 */
	public String ajaxDeleteBySelect() {
		JSONObject json=new	JSONObject();
		try{
			this.resetPromptMessage();
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String workId : ids) {
					this.saveSysLog(Constants.SOA_WORK, workId);//保存查询日志
					workexperienceService.delete(workId);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_WORK, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 删除已选的工作简历信息
	 */
	public String deleteBySelect() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String workId : ids) {
					this.saveSysLog(Constants.SOA_WORK, workId);//保存查询日志
					int result = workexperienceService.delete(workId);
				}
			}
			form.setFlag("3");
			return "delete";
		}catch (Exception ex) {
			form.setFlag("4");
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_WORK, ex);
			return "delete";
		}
	}
	
	/**
	 * 删除人员所有的工作简历信息
	 */
	public String deleteAll() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_WORK, form.getRetrieveSO().getPersonId());//保存查询日志
			int result = workexperienceService.deleteALL(form.getRetrieveSO().getPersonId());
			return "delete";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_WORK, ex);
			return "delete";
		}
	}
	
	/**
	 * 检查输入参数
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	private void validateInput(String type)throws Exception{
		if(type.equals("list"))
		{
			QueryWorkexperienceListSO queryListSO = form.getQueryListSO();// 获得参数对象
		}else if(type.equals("view")){
			RetrieveWorkexperienceSO retrieveSO=form.getRetrieveSO();// 获得参数对象
			String rsPersonId = retrieveSO.getPersonId(); 
			//保存输入参数
			queryInputParameter=rsPersonId;
			// 分析输入参数
			if(rsPersonId.equals("") ){
				throw new ValidateException(Constants.ERROR_NOINPUT);
			}
		}
	}
	
	public WorkexperienceForm getForm() {
		return form;
	}

	public void setForm(WorkexperienceForm form) {
		this.form = form;
	}

	public RsPersonService getRsPersonService() {
		return rsPersonService;
	}

	public void setRsPersonService(RsPersonService rsPersonService) {
		this.rsPersonService = rsPersonService;
	}
}
