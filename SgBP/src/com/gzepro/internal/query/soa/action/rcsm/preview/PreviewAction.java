package com.gzepro.internal.query.soa.action.rcsm.preview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.preview.PreviewForm;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessListDTO;
import com.gzepro.internal.query.soa.service.user.impl.EducationexperienceService;
import com.gzepro.internal.query.soa.service.user.impl.ProjectExperienceService;
import com.gzepro.internal.query.soa.service.user.impl.RsAffixService;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.soa.service.user.impl.TechnicallymessService;
import com.gzepro.internal.query.soa.service.user.impl.TechnologicalHarvestService;
import com.gzepro.internal.query.soa.service.user.impl.WorkexperienceService;

/**
 * 
  * @ClassName: RsPersonAction
  * @Description: TODO(后台业务系统人员信息预览Action类)
  * @author 张建薇
  * @date Jul 25, 2012 10:31:10 AM
  *
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.PreviewAction")
public class PreviewAction  extends SoaBaseJsonAction{

	@Resource
	private RsPersonService rsPersonService;
	@Resource
	private ProjectExperienceService projectExperienceService;
	@Resource
	private EducationexperienceService educationexperienceService;
	@Resource
	private TechnicallymessService technicallymessService;
	@Resource
	private TechnologicalHarvestService technologicalHarvestService;
	@Resource
	private WorkexperienceService workexperienceService;
	@Resource
	private RsAffixService rsAffixService;
	
	private PreviewForm form;
	
	private String ifPrint;
	
	/**
	 * @return the ifPrint
	 */
	public String getIfPrint() {
		return ifPrint;
	}

	/**
	 * @param ifPrint the ifPrint to set
	 */
	public void setIfPrint(String ifPrint) {
		this.ifPrint = ifPrint;
	}

	/**
	 * 默认方法，查询预览页面所需要人员所有信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		
		RsPersonListDTO personDetail = new RsPersonListDTO();//人员基本信息
		List<ProjectExperienceListDTO> proExpList=new ArrayList<ProjectExperienceListDTO>();//项目经验
		List<EducationexperienceListDTO> eduExpList=new ArrayList<EducationexperienceListDTO>();//教育经历
		List<TechnicallymessListDTO> techMessList =new ArrayList<TechnicallymessListDTO>();//职称信息
		List<TechnologicalHarvestListDTO> techHarvestList=new ArrayList<TechnologicalHarvestListDTO>();//科技成果
		List<WorkexperienceListDTO> workexpList=new ArrayList<WorkexperienceListDTO>();//工作经历
		try {
			if(form.getUuid()!=null&&!"".equals(form.getUuid())){
				if(rsPersonService.find(form.getUuid(),menuId,this.getAccount().getId())!=null){
					personDetail=((List<RsPersonListDTO>)rsPersonService.find(form.getUuid(),menuId,this.getAccount().getId())).get(0);//拿人员基本信息
				}
				
				if(projectExperienceService.findAll(form.getUuid(),menuId,this.getAccount().getId())!=null){
					proExpList=(List<ProjectExperienceListDTO>) projectExperienceService.findAll(form.getUuid(),menuId,this.getAccount().getId());//拿项目经验
				}
				
				if(educationexperienceService.findAll(form.getUuid(), menuId, this.getAccount().getId())!=null){
					eduExpList=(List<EducationexperienceListDTO>) educationexperienceService.findAll(form.getUuid(), menuId, this.getAccount().getId());//拿教育经历
				}
				
				if(technicallymessService.findAll(form.getUuid(),menuId,this.getAccount().getId())!=null){
					techMessList=(List<TechnicallymessListDTO>) technicallymessService.findAll(form.getUuid(),menuId,this.getAccount().getId());//拿职称信息
				}
				
				if(technologicalHarvestService.findAll(form.getUuid(),menuId, this.getAccount().getId())!=null){
					techHarvestList=(List<TechnologicalHarvestListDTO>) technologicalHarvestService.findAll(form.getUuid(),menuId, this.getAccount().getId());//拿科技成果
				}
				
				if(workexperienceService.findAll(form.getUuid(),menuId, this.getAccount().getId())!=null){
					workexpList=(List<WorkexperienceListDTO>) workexperienceService.findAll(form.getUuid(),menuId, this.getAccount().getId());//拿工作经历
				}
				String pt = personDetail.getPersonType();
				if(pt != null && pt.trim().length() > 0) {
					Map<String, String> map = new HashMap<String, String>();
					pt = pt.trim();
					String[] pts = pt.split(",");
					for(String p : pts) {
						if(p != null && p.trim().length() > 0) {
							map.put(p.trim(), p.trim());
						}
					}
					this.request.setAttribute("_PERSON_TYPE", map);
				}
				// 照片
				RsAffixDTO rsAffix = new RsAffixDTO();
				rsAffix.setPersonId(form.getUuid());
				rsAffix.setDeleDate("0");
				rsAffix.setAffixType("1");
				List<RsAffixDTO> affixList = (List<RsAffixDTO>) rsAffixService.query(rsAffix, menuId, this.getAccount().getId());
				
				// 采集表归档图
				RsAffixDTO gdImg = new RsAffixDTO();
				gdImg.setPersonId(form.getUuid());
				gdImg.setDeleDate("0");
				gdImg.setAffixType("2");
				List<RsAffixDTO> gdList = (List<RsAffixDTO>) rsAffixService.query(gdImg, menuId, this.getAccount().getId());
				
				form.setPersonDetail(personDetail);
				form.setProExpList(proExpList);
				form.setEduExpList(eduExpList);
				form.setTechMessList(techMessList);
				form.setTechHarvestList(techHarvestList);
				form.setWorkexpList(workexpList);
				if(affixList!=null&&affixList.size()>0){
					form.setAffixList(affixList);
				}else{
					form.setAffixList(new ArrayList<RsAffixDTO>());
				}
				form.setGdImg(gdList);
				// 打印的时候查询不需要重新设置session
				if(null != personDetail && personDetail.getPersonId().length()>0 &&(null==ifPrint || ifPrint.trim().length()==0)){
					this.getSession().put("personId",personDetail.getPersonId());
					this.getSession().put("personName",personDetail.getPname());
					this.getSession().put("personIdCard", personDetail.getIdCard());
					this.getSession().put("auditstate", personDetail.getAuditstate());
				}
				
			}
			if(null!=ifPrint && ifPrint.trim().equals("1")){
				return "print";
			}
			return "view";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PREVIEW, ex);
			return "error";
		}
	}

	public PreviewForm getForm() {
		return form;
	}

	public void setForm(PreviewForm form) {
		this.form = form;
	}

}
