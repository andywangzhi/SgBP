package com.gzepro.internal.query.soa.action.rcsm.zcxx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessForm;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.soa.service.user.impl.TechnicallymessService;

/**
 * 
 * 
 * 职称信息action！
 * 
 * @author 王志 E-mail:wangzhi291@163.com
 * @version 1.0
 * Created On: 2012-8-4
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.Technicallymess")
public class TechnicallymessAction extends SoaBaseJsonAction {
	@Resource
	private TechnicallymessService technicallymessService;// 通过spring注入业务实例
	private TechnicallymessForm form = new TechnicallymessForm();// 查询表单封装对象
	@Resource
	private RsPersonService rsPersonService;

	private String message;

	/**
	 * 查询职称信息列表
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
				this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
				// 调用ws
				List<TechnicallymessDetaiDTO> dtoList = (List<TechnicallymessDetaiDTO>) technicallymessService
						.findAll(form.getRetrieveSO().getPersonId(), menuId,
								this.getAccount().getId());
				form.setPersonId(form.getRetrieveSO().getPersonId());
				if(this.getSession().get("auditstate")!=null){
					form.setAuditstate(this.getSession().get("auditstate").toString());
				}
				if(dtoList!=null&&dtoList.size()>0){
					form.setDtoList(dtoList);
				}else{
					form.setDtoList(new ArrayList<TechnicallymessDetaiDTO>());
				}
				return "list";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "list";
		}
	}

	/**
	 * 新增/编辑职称信息信息
	 */
	public String input() {

		return "input";
	}

	/**
	 * 保存职称信息信息
	 */
	public String saveOrUpdate() {
		List<TechnicallymessDetaiDTO> list = form.getDtoList();
		String personId = form.getRetrieveSO().getPersonId();
		if (personId != null && !personId.equals("")) {// 编辑
			try {
				for (TechnicallymessDetaiDTO so : list) {
					if(null == so)
						continue;
					so.setPersonId(personId);
					if (so.getTechId() != null && so.getTechId().length() > 0) {
						if (so.getTechnicallyLevel() == null
								|| so.getTechnicallyLevel().length() <= 0) {
							technicallymessService.delete(so.getTechId());
						} else {
							so.setModifyuser(this.getAccount().getLoginCode());
							so.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							technicallymessService.saveOrUpdate(so);
						}
						
					} else {
						so.setAdduser(this.getAccount().getLoginCode());
						so.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
						technicallymessService.saveOrUpdate(so);
					}
				}
				
			this.setMessage("saveOk");
		} catch (Exception ex) {
			this.setMessage("saveFail");
			// 统一异常处理类
			this.handleException(queryInputParameter,
					Constants.SOA_TECH, ex);
		}
		}
		return "query";
	}

	/**
	 * 保存职称信息信息
	 */
	public String ajaxSaveOrUpdate() {
		JSONObject json=new	JSONObject();
		List<TechnicallymessDetaiDTO> list = form.getDtoList();
		String personId = form.getRetrieveSO().getPersonId();
		if (personId != null && !personId.equals("")) {// 编辑
			try {
				for (TechnicallymessDetaiDTO so : list) {
					if(null == so)
						continue;
					so.setPersonId(personId);
						if (so.getTechId() != null && so.getTechId().length() > 0) {
							if (so.getTechnicallyLevel() == null
									|| so.getTechnicallyLevel().length() <= 0) {
								technicallymessService.delete(so.getTechId());
							} else {
								so.setModifyuser(this.getAccount().getLoginCode());
								so.setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
								technicallymessService.saveOrUpdate(so);
							}
							
						} else {
							so.setAdduser(this.getAccount().getLoginCode());
							so.setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
							technicallymessService.saveOrUpdate(so);
						}
					
				}				
				json.put("flag", 1);
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			json.put("flag", 2);
			this.handleException(queryInputParameter,
					Constants.SOA_TECH, ex);
		}
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 查看职称信息详细信息
	 */
	public String view() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			// 调用ws
			TechnicallymessDetaiDTO dto = (TechnicallymessDetaiDTO) technicallymessService
					.view(form.getRetrieveSO(), menuId, this.getAccount()
							.getId());
			if(dto!=null){
				form.setDto(dto);
			}else{
				form.setDto(new TechnicallymessDetaiDTO());
			}
			return "view";
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "view";
		}
	}

	/**
	 * 删除职称信息信息
	 */
	public String delete() {
		List<TechnicallymessDetaiDTO> list = form.getDtoList();
		String personId = form.getRetrieveSO().getPersonId();
		try {
			if (personId != null && !personId.equals("")) {// 编辑
				for (TechnicallymessDetaiDTO so : list) {
						if (so.getTechId() != null
								&& so.getTechId().length() > 0&&(null == so.getPersonId() || so.getPersonId().trim().length()==0)) {
							technicallymessService.delete(so.getTechId());
						}
				}
			}
			this.setMessage("deleteOk");
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.setMessage("deleteFail");
			this.handleException(form.getRetrieveSO().getPersonId(),
					Constants.SOA_TECH, ex);
		}
		return "query";
	}

	//删除选中的记录
	public String deleteBySelect() {
		try {
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String techId : ids) {
					this.saveSysLog(Constants.SOA_TECH, techId);//保存查询日志
					int result = technicallymessService.delete(techId);
				}
			}
			this.setMessage("deleteOk");
		}catch (Exception ex) {
			this.setMessage("deleteFail");
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_TECH, ex);
		}
		return "query";
	}
	
	//删除选中的记录
	public String ajaxDeleteBySelect() {
		JSONObject json=new	JSONObject();
		try {
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String techId : ids) {
					this.saveSysLog(Constants.SOA_TECH, techId);//保存查询日志
					int result = technicallymessService.delete(techId);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_TECH, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 删除人员所有的职称信息信息
	 */
	public String deleteAll() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, form.getRetrieveSO()
					.getPersonId());// 保存查询日志
			int result = technicallymessService.deleteAll(form.getRetrieveSO()
					.getPersonId());
			return "delete";
		} catch (Exception ex) {
			// 统一异常处理类
			// ex.printStackTrace();
			this.handleException(form.getRetrieveSO().getPersonId(),
					Constants.SOA_TECH, ex);
			return "delete";
		}
	}

	public TechnicallymessForm getForm() {
		return form;
	}

	public void setForm(TechnicallymessForm form) {
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

	public TechnicallymessService getTechnicallymessService() {
		return technicallymessService;
	}

	public void setTechnicallymessService(
			TechnicallymessService technicallymessService) {
		this.technicallymessService = technicallymessService;
	}
}
