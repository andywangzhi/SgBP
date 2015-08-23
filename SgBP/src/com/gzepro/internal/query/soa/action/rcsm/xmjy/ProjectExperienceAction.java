package com.gzepro.internal.query.soa.action.rcsm.xmjy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceForm;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.QueryProjectExperienceListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.RetrieveProjectExperienceSO;
import com.gzepro.internal.query.soa.service.user.impl.ProjectExperienceService;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;

/**
 * 
 * 
 * 项目经验action！
 * 
 * @author 王志 E-mail:wangzhi291@163.com
 * @version 1.0
 * Created On: 2012-8-4
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.ProjectExperience")
public class ProjectExperienceAction extends SoaBaseJsonAction {
	@Resource
	private ProjectExperienceService projectExperienceService;// 通过spring注入业务实例
	private ProjectExperienceForm form = new ProjectExperienceForm();// 查询表单封装对象

	private String message;
	@Resource
	private RsPersonService rsPersonService;
	/**
	 * 查询项目经验列表
	 */
	@SuppressWarnings("unchecked")
	public String query() {
		try {
			 String personId = (String) this.getSession().get("personId");
			 if (personId == null || personId.trim().length() < 1) {
			 return "out";
			 } 
			 form.getRetrieveSO().setPersonId(personId);
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("list");
			this.saveSysLog(Constants.SOA_PROJ, queryInputParameter);// 保存查询日志
			// 调用ws
			List<ProjectExperienceDetaiDTO> dtoList = (List<ProjectExperienceDetaiDTO>) projectExperienceService
					.findAll(form.getRetrieveSO().getPersonId(), menuId, this
							.getAccount().getId());
			if(this.getSession().get("auditstate")!=null){
				form.setAuditstate(this.getSession().get("auditstate").toString());
			}
			if (dtoList != null && dtoList.size() > 0) {
				form.setDtoList(dtoList);
				form.setPersonId(form.getRetrieveSO().getPersonId());
			} else {
				form.setDtoList(new ArrayList<ProjectExperienceDetaiDTO>());
				form.setPersonId(form.getRetrieveSO().getPersonId());
			}
			return "list";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_PROJ, ex);
			return "list";
		}
	}

	/**
	 * 新增/编辑项目经验信息
	 */
	public String input() {
		String experienceid = form.getRetrieveSO().getExperienceid();
		if (experienceid != null && !experienceid.equals("")) {// 编辑
			try {
				ProjectExperienceDetaiDTO dto = (ProjectExperienceDetaiDTO) projectExperienceService
						.find(form.getRetrieveSO());
				if(dto!=null){
					form.setDto(dto);
				}else{
					form.setDto(new ProjectExperienceDetaiDTO());
				}
			} catch (Exception ex) {
				// 统一异常处理类
				this.handleException(queryInputParameter, Constants.SOA_PROJ,
						ex);
			}
		}
		return "input";
	}

	/**
	 * 保存项目经验信息
	 */
	public String saveOrUpdate() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this
					.saveSysLog(Constants.SOA_PROJ, form.getDto()
							.getExperienceid());// 保存查询日志
			String personId = form.getRetrieveSO().getPersonId();
			List<ProjectExperienceDetaiDTO> dtoList = form.getDtoList();
			for (ProjectExperienceDetaiDTO dto : dtoList) {
				if(dto==null){
					continue;
				}else{
					if (dto.getExperienceid() != null
							&& dto.getExperienceid().length() == 32) {// 主键ID 是否为空
						if (dto.getProjname() != null
								&& dto.getProjname().length() > 0
								&& dto.getProjresponsibility() != null
								&& dto.getProjresponsibility().length() > 0) {
							// 有主键ID 有项目名称和角色 即为修改
							dto.setPersonId(personId);
							dto.setModifydate(this.getAccount().getLoginCode());
							dto.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							projectExperienceService.saveOrUpdate(dto);
		
						} 
					} else {
						if (dto.getProjname() != null
								&& dto.getProjname().length() > 0
								&& dto.getProjresponsibility() != null
								&& dto.getProjresponsibility().length() > 0) {
							// ID为空 但是项目名称和项目角色不为空 即为添加
							dto.setPersonId(personId);
							dto.setAdduser(this.getAccount().getLoginCode());
							dto.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							projectExperienceService.saveOrUpdate(dto);
						}
	
					}
				}
			}

			this.setMessage("saveOk");
		} catch (Exception ex) {
			this.setMessage("saveFail");
			// 统一异常处理类
			// ex.printStackTrace();
			this.handleException(form.getDto().getExperienceid(),
					Constants.SOA_PROJ, ex);
		}
		return "query";
	}

	/**
	 * ajax保存项目经验信息
	 */
	public String ajaxSaveOrUpdate() {
		JSONObject json=new	JSONObject();
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this
					.saveSysLog(Constants.SOA_PROJ, form.getDto()
							.getExperienceid());// 保存查询日志
			String personId = form.getRetrieveSO().getPersonId();
			List<ProjectExperienceDetaiDTO> dtoList = form.getDtoList();
			for (ProjectExperienceDetaiDTO dto : dtoList) {
				if(dto==null){
					continue;
				}else{
					if (dto.getExperienceid() != null
							&& dto.getExperienceid().length() == 32) {// 主键ID 是否为空
						if (dto.getProjname() != null
								&& dto.getProjname().length() > 0
								&& dto.getProjresponsibility() != null
								&& dto.getProjresponsibility().length() > 0) {
							// 有主键ID 有项目名称和角色 即为修改
							dto.setPersonId(personId);
							dto.setModifydate(this.getAccount().getLoginCode());
							dto.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							projectExperienceService.saveOrUpdate(dto);
							
						} 
					} else {
						if (dto.getProjname() != null
								&& dto.getProjname().length() > 0
								&& dto.getProjresponsibility() != null
								&& dto.getProjresponsibility().length() > 0) {
							// ID为空 但是项目名称和项目角色不为空 即为添加
							dto.setPersonId(personId);
							dto.setAdduser(this.getAccount().getLoginCode());
							dto.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							projectExperienceService.saveOrUpdate(dto);
						}
	
					}
				}
			}

			json.put("flag", 1);
		} catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getDto().getExperienceid(),
					Constants.SOA_PROJ, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 查看项目经验详细信息
	 */
	public String view() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("view");
			this.saveSysLog(Constants.SOA_PROJ, queryInputParameter);// 保存查询日志
			// 调用ws
			ProjectExperienceDetaiDTO dto = (ProjectExperienceDetaiDTO) projectExperienceService
					.view(form.getRetrieveSO(), menuId, this.getAccount()
							.getId());
			if(dto!=null){
				form.setDto(dto);
			}else{
				form.setDto(new ProjectExperienceDetaiDTO());
			}
			return "view";
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_PROJ, ex);
			return "view";
		}
	}

	/**
	 * 删除项目经验信息
	 */
	public String delete() {
		this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
		this.saveSysLog(Constants.SOA_PROJ, form.getRetrieveSO()
				.getExperienceid());// 保存查询日志
		String personId = form.getRetrieveSO().getPersonId();
		List<ProjectExperienceDetaiDTO> dtoList = form.getDtoList();
		try {
			if (personId != null && personId.length() == 32) {
				for (ProjectExperienceDetaiDTO dto : dtoList) {
					if (dto.getExperienceid() != null
							&& dto.getExperienceid().length() == 32&&(null == dto.getPersonId() || dto.getPersonId().trim().length()==0)) {// 主键ID
						// 是否为空
						projectExperienceService.delete(dto.getExperienceid());
					}
				}
			}
			this.setMessage("deleteOk");
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.setMessage("deleteFail");
			this.handleException(form.getRetrieveSO().getPersonId(),
					Constants.SOA_PROJ, ex);
		}
		return "query";
	}

	
	//删除选中的记录
	public String deleteBySelect() {
		try {
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String proExpId : ids) {
					this.saveSysLog(Constants.SOA_PROJ, proExpId);//保存查询日志
					int result = projectExperienceService.delete(proExpId);
				}
			}
			this.setMessage("deleteOk");
		}catch (Exception ex) {
			this.setMessage("deleteFail");
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_PROJ, ex);
		}
		return "query";
	}
	
	//ajax删除选中的记录
	public String ajaxDeleteBySelect() {
		JSONObject json=new	JSONObject();
		try {
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String proExpId : ids) {
					this.saveSysLog(Constants.SOA_PROJ, proExpId);//保存查询日志
					int result = projectExperienceService.delete(proExpId);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_PROJ, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 删除人员所有的项目经验信息
	 */
	public String deleteAll() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PROJ, form.getRetrieveSO()
					.getPersonId());// 保存查询日志
			int result = projectExperienceService.deleteAll(form
					.getRetrieveSO().getPersonId());
			return "delete";
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.handleException(form.getRetrieveSO().getPersonId(),
					Constants.SOA_PROJ, ex);
			return "delete";
		}
	}

	/**
	 * 检查输入参数
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private void validateInput(String type) throws Exception {
		if (type.equals("list")) {
			QueryProjectExperienceListSO queryListSO = form.getQueryListSO();// 获得参数对象
		} else if (type.equals("view")) {
			RetrieveProjectExperienceSO retrieveSO = form.getRetrieveSO();// 获得参数对象
			String rsPersonId = retrieveSO.getPersonId();
			// 保存输入参数
			queryInputParameter = rsPersonId;
			// 分析输入参数
			if (rsPersonId.equals("")) {
				throw new ValidateException(Constants.ERROR_NOINPUT);
			}
		}
	}

	public ProjectExperienceForm getForm() {
		return form;
	}

	public void setForm(ProjectExperienceForm form) {
		this.form = form;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RsPersonService getRsPersonService() {
		return rsPersonService;
	}

	public void setRsPersonService(RsPersonService rsPersonService) {
		this.rsPersonService = rsPersonService;
	}
}
