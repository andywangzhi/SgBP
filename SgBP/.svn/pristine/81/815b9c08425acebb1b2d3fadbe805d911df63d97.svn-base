package com.gzepro.internal.query.soa.action.rcsm.kjcg;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.QueryTechnologicalHarvestListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.RetrieveTechnologicalHarvestSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestForm;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.soa.service.user.impl.TechnologicalHarvestService;

/**
 * 
  * @ClassName: TechnologicalHarvestAction
  * @Description: TODO(后台业务系统科技成果Action类)
  * @author 张建薇
  * @date Jul 25, 2012 10:31:10 AM
  *
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.kjcg")
public class TechnologicalHarvestAction extends SoaBaseJsonAction{
	@Resource
	private TechnologicalHarvestService technologicalHarvestService;// 通过spring注入业务实例
	private TechnologicalHarvestForm form = new TechnologicalHarvestForm();// 查询表单封装对象
	
	private String message;
	@Resource
	private RsPersonService rsPersonService;
	
	/**
	 * 查询科技成果列表
	 */
	public String query() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("list");
			this.saveSysLog(Constants.SOA_TEC, queryInputParameter);//保存查询日志
		    // 调用ws
			String personId = (String) this.getSession().get("personId");
			if(personId == null || personId.trim().length() < 1) {
				return "out";
			} else {
				form.getRetrieveSO().setPersonId(personId);
				List<TechnologicalHarvestListDTO> dtoList = (List<TechnologicalHarvestListDTO>) technologicalHarvestService.query(form.getQueryListSO(), menuId, this.getAccount().getId());
				if(dtoList!=null&&dtoList.size()>0){
					form.setDtoList(dtoList);
				}else{
					form.setDtoList(new ArrayList<TechnologicalHarvestListDTO>());
				}
				return "list";
			}
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_TEC, ex);
			return "list";
		}
	}
	
	/**
	 * 查询科技成果列表
	 */
	public String queryByPerId() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("list");
			this.saveSysLog(Constants.SOA_TEC, queryInputParameter);//保存查询日志
		    // 调用ws
			String personId = (String) this.getSession().get("personId");
			if(personId == null || personId.trim().length() < 1) {
				return "out";
			} else {
				form.getQueryListSO().setPersonId(personId);
				form.getRetrieveSO().setPersonId(personId);
				if(form.getQueryListSO().getPersonId() != null && form.getQueryListSO().getPersonId().trim().length() > 0) {
					List<TechnologicalHarvestListDTO> dtoList = (List<TechnologicalHarvestListDTO>) technologicalHarvestService.findAll(form.getQueryListSO().getPersonId(), menuId, this.getAccount().getId());
					if(dtoList!=null&&dtoList.size()>0){
						form.setDtoList(dtoList);
					}else{
						form.setDtoList(new ArrayList<TechnologicalHarvestListDTO>());
					}
				}
				if(this.getSession().get("auditstate")!=null){
					form.setAuditstate(this.getSession().get("auditstate").toString());
				}
				return "list";
			}
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_TEC, ex);
			return "list";
		}
	}
	
	/**
	 * 保存科技成果信息
	 */
	public String saveOrUpdate() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TEC, form.getDto().getHarvestId());//保存查询日志
			String personId = "";
			for(int i = 0; i < form.getDtoList().size(); i++) {
				TechnologicalHarvestListDTO dto = (TechnologicalHarvestListDTO)(form.getDtoList()).get(i);
				personId = dto.getPersonId();
				if(dto != null && StrUtils.strIsNull(dto.getPersonId()) && StrUtils.strIsNull(dto.getAssessDate())
						&& StrUtils.strIsNull(dto.getAssessDep()) && StrUtils.strIsNull(dto.getHarvestLevel())
						&& StrUtils.strIsNull(dto.getHarvestLevel())) {
					if(StrUtils.strIsNull(dto.getHarvestId())) {
						dto.setModifydate(DateUtil.getCurDate());
						dto.setModifyuser(this.getAccount().getLoginCode());
					} else {
						dto.setAdddate(DateUtil.getCurDate());
						dto.setAdduser(this.getAccount().getLoginCode());
					}
					int result = technologicalHarvestService.saveOrUpdate(dto);
				}
			}
			this.setMessage("saveOk");
			return "save";
		}catch (Exception ex) {
			// 统一异常处理类
			this.setMessage("saveFail");
			//ex.printStackTrace();
			this.handleException(form.getDto().getHarvestId(),Constants.SOA_TEC, ex);
			return "save";
		}
	}
	
	/**
	 * ajax保存科技成果信息
	 */
	public String ajaxSaveOrUpdate() {
		JSONObject json=new	JSONObject();
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TEC, form.getDto().getHarvestId());//保存查询日志
			String personId = "";
			for(int i = 0; i < form.getDtoList().size(); i++) {
				TechnologicalHarvestListDTO dto = (TechnologicalHarvestListDTO)(form.getDtoList()).get(i);
				personId = dto.getPersonId();
				if(dto != null && StrUtils.strIsNull(dto.getPersonId()) && StrUtils.strIsNull(dto.getAssessDate())
						&& StrUtils.strIsNull(dto.getAssessDep()) && StrUtils.strIsNull(dto.getHarvestLevel())
						&& StrUtils.strIsNull(dto.getHarvestLevel())) {
					if(StrUtils.strIsNull(dto.getHarvestId())) {
						dto.setModifydate(DateUtil.getCurDate());
						dto.setModifyuser(this.getAccount().getLoginCode());
					} else {
						dto.setAdddate(DateUtil.getCurDate());
						dto.setAdduser(this.getAccount().getLoginCode());
					}
					int result = technologicalHarvestService.saveOrUpdate(dto);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getDto().getHarvestId(),Constants.SOA_TEC, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	
	/**
	 * 删除科技成果信息
	 */
	public String delete() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TEC, form.getRetrieveSO().getHarvestId());//保存查询日志
			for(int i = 0; i < form.getDtoList().size(); i++) {
				TechnologicalHarvestListDTO dto = (TechnologicalHarvestListDTO)(form.getDtoList()).get(i);
				if(dto != null && StrUtils.strIsNull(dto.getHarvestId())
						&& !StrUtils.strIsNull(dto.getPersonId())) {
					int result = technologicalHarvestService.delete(dto.getHarvestId());
				}
			}
			this.setMessage("deleteOk");
			return "delete";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.setMessage("deleteFail");
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_TEC, ex);
			return "delete";
		}
	}
	
	/**
	 * ajax删除科技成果信息
	 */
	public String ajaxDelete() {
		JSONObject json=new	JSONObject();
		try{
			String selected=form.getSelected();
			if(selected!=null&&!"".equals(selected)&&selected.indexOf(",")>0){
				String[] ids=selected.split(",");
				for (String techHarvestId : ids) {
					this.saveSysLog(Constants.SOA_PROJ, techHarvestId);//保存查询日志
					int result = technologicalHarvestService.delete(techHarvestId);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_TEC, ex);
			return "delete";
		}
		outputJson(json);
		return this.NONE;
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
			QueryTechnologicalHarvestListSO queryListSO = form.getQueryListSO();// 获得参数对象
		}else if(type.equals("view")){
			RetrieveTechnologicalHarvestSO retrieveSO=form.getRetrieveSO();// 获得参数对象
			String rsPersonId = retrieveSO.getPersonId(); 
			//保存输入参数
			queryInputParameter=rsPersonId;
			// 分析输入参数
			if(rsPersonId.equals("") ){
				throw new ValidateException(Constants.ERROR_NOINPUT);
			}
		}
	}
	
	
	public TechnologicalHarvestForm getForm() {
		return form;
	}
	public void setForm(TechnologicalHarvestForm form) {
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
