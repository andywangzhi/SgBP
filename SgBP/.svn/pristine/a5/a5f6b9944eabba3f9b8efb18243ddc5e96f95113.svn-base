package com.gzepro.internal.query.soa.extaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo;
import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo;
import com.gzepro.internal.query.common.persistence.BaseDao;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.extaction.OutRsAffixService;
import com.gzepro.internal.query.soa.extaction.OutRsPersonService;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.QueryRsPersonListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessListDTO;
import com.gzepro.internal.query.soa.service.user.impl.EducationexperienceService;
import com.gzepro.internal.query.soa.service.user.impl.ProjectExperienceService;
import com.gzepro.internal.query.soa.service.user.impl.RsAffixService;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.soa.service.user.impl.TechnicallymessService;
import com.gzepro.internal.query.soa.service.user.impl.TechnologicalHarvestService;
import com.gzepro.internal.query.soa.service.user.impl.WorkexperienceService;
import com.gzepro.internal.query.system.model.ChangeDetail;

@Service("dataChangeAtion")
public class DataChangeAtion {
	@Resource
	private OutRsPersonService outRsPersonService;
	
	@Resource
	private OutRsAffixService outRsAffixService;
	@Resource
	private OutRsEducationexperienceService outRsEducationexperienceService;
	@Resource
	private OutRsProjectExperienceService outRsProjectExperienceService;
	@Resource
	private OutRsTechnicallymessService outRsTechnicallymessService;
	@Resource
	private OutRsTechnologicalHarvestService outRsTechnologicalHarvestService;
	@Resource
	private OutRsWorkexperienceService outRsWorkexperienceService;
	@Resource
	private BaseDao baseDao;
	

	@Resource 
	private ProjectExperienceService projectExperienceService;
	@Resource
	private RsAffixService rsAffixService;
	@Resource
	private RsPersonService rsPersonService;
	@Resource
	private EducationexperienceService educationexperienceService;
	@Resource
	private TechnicallymessService technicallymessService;
	@Resource
	private TechnologicalHarvestService technologicalHarvestService;
	@Resource
	private WorkexperienceService workexperienceService;
	
	private SetValuefromObject setValuefromObject = new SetValuefromObject();
	
	
	public DataChangeAtion(){}
	
	/**
	 * 将内网数据更新到外网 内网数据过滤条件为已审核的数据及上一次交换后的数据
	 * @param listSo
	 * @return
	 * @throws Exception
	 */
	public int rspersonDataChangeFormIn(QueryRsPersonListSO listSo) throws Exception{
		try{
			Paging paging =new Paging();
			paging.setTotalPages(1);
			paging.setPageSize(100);
			for(int i = 1; i <= paging.getTotalPages(); i++){
				paging.setCurrentIndex(i);
				Paging pagingFirst = rsPersonService.queryByPageforExt(paging, listSo);
				if(pagingFirst == null){
					return 0;
				}
				paging.setTotalPages(pagingFirst.getTotalPages());
				List<com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo> voList = (List<com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo>)pagingFirst.getVoList();
				if(voList == null || voList.size() == 0){
					return 0;
				}
				for(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo vo : voList){
					saveOrUpdatePersonOut(vo);
					
				}
				if(i % 10 == 0){
					System.out.println("已经交换了："+ i*100 + " 先休息下");
					Thread.sleep(20 * 1000);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
			
		}
		
		return 0;
	}
	
	/**
	 * 将内网的人才基本信息更新到外网 
	 * @param inVo 内网人才基本信息实体
	 * @return  是否成功
	 * @throws Exception
	 */
	private String saveOrUpdatePersonOut(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo inVo) throws Exception{
		try {
			String dchangdetail = "从实名系统交换到公共服务平台";
			String dchangtype = "修改数据";
			com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo outVo = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo();
			outVo.setIdCard(inVo.getIdCard());
			outVo.setIsvalid("1");
			outVo.setAuditstate("1%1");
			Paging paging = new Paging();
			//List<com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo> voList = outRsPersonService.queryByPage(paging, outVo);
			Paging pagingback = outRsPersonService.queryByPage(paging, outVo);
			List<com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo> voList = null;
			if(pagingback != null){
				voList = (List<com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo>)pagingback.getVoList();
			}			
			com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo newoutVo = null;
			if(voList == null || voList.size() == 0){
				dchangtype = "新增数据";
				 newoutVo = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo();
			}else{
				newoutVo = voList.get(0);
			}
			com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo newVo = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo();
			boolean isTrue = true;
			int value = inVo.getAuditdate() - newoutVo.getAuditdate() ;
			if(value >= 0){
				isTrue = false;
			}
			if(!isTrue){			
				newVo = setValuefromObject.personSetValueFormIn(newoutVo, inVo);
				String id = outRsPersonService.saveOrUpdate(newVo);
				if(id != null && id.length()<40){
					saveOrUpdateforAffixIn(inVo.getPersonId(),id);
					saveOrUpdateforEducationIn(inVo.getPersonId(),id);
					saveOrUpdateforProjectIn(inVo.getPersonId(),id);
					saveOrUpdatefortechnicallymessIn(inVo.getPersonId(),id);
					saveOrUpdatefortechnologicalHarvestIn(inVo.getPersonId(),id);
					saveOrUpdateforworkIn(inVo.getPersonId(),id);	
				}	
				ChangeDetail obj = new ChangeDetail();
				obj.setDchangdetail(dchangdetail);
				obj.setDchangtype(dchangtype);
				obj.setCheckstate("成功");
				obj.setChangedate(DateUtil.getCurDate());
				obj.setDchangtime(DateUtil.getCurDateTime());
				obj.setIdcard(inVo.getIdCard());
				baseDao.saveOrUpdate(obj);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return "true";
	}
	/**
	 * 更新或新增附件表数据 每个人才对应一个附件
	 * @param personIdIn 实名系统
	 * @param personIdOut 公共服务
	 * @return 更新结果
	 * @throws Exception 
	 */
	private String saveOrUpdateforAffixIn(String personIdIn,String personIdOut) throws Exception{
		ArrayList<RsAffixDTO> inAffixList= (ArrayList<RsAffixDTO>)rsAffixService.queryByPersonId(personIdIn, null, null);
		if(inAffixList == null || inAffixList.size() == 0){
			return "true";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo> outAffixList = outRsAffixService.queryByPersonId(personIdOut);
		com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo newVo = setValuefromObject.affixSetValueFormIn(inAffixList.get(0));
		newVo.setPersonId(personIdOut);	
		newVo.setAffixId("");
		//外网没有则新增
		if(outAffixList != null && outAffixList.size() > 0){
			newVo.setAffixId(outAffixList.get(0).getAffixId());		
		}
		outRsAffixService.saveOrUpdate(newVo);
		return "true";
	}
	Long menuId = 999L;
	/**
	 * 更新或新增教育简历  每个人才可能有多个教育简历
	 * @param personIdIn 实名系统人才ID
	 * @param personIdOut 公共服务ID
	 * @return 更新结果
	 * @throws Exception 
	 */
	private String saveOrUpdateforEducationIn(String personIdIn,String personIdOut) throws Exception{
		//点击的菜单ID
		List<EducationexperienceListDTO> dtoList = (List<EducationexperienceListDTO>)educationexperienceService.findAll(personIdIn, menuId, menuId);
		//没有教育简历则返回
		if(dtoList == null || dtoList.size() == 0){
			return "false";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo> outList = outRsEducationexperienceService.findAll(personIdOut);
		for(EducationexperienceListDTO dto : dtoList){
			com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo newVo = setValuefromObject.educationSetValueFormIn(dto);
			newVo.setPersonId(personIdOut);
			newVo.setEducationId("");
			if(outList != null && outList.size() > 0){
				for(com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo outVo : outList){
					if(outVo.getPcollege().equals(dto.getPcollege()) && 
							outVo.getSpecialtyName().equals(dto.getSpecialtyName())){
						//内容相同则更新
						newVo.setEducationId(outVo.getEducationId());
						break;
					}
				}
			}
			outRsEducationexperienceService.saveOrUpdate(newVo);
		}
		
		return "true";
	}
	
	/**
	 * 更新或新增外网项目经验 
	 * @param personIdIn 内网人才Id
	 * @param personIdOut 外网人才ID
	 * @return 更新结果
	 * @throws Exception
	 */
	private String saveOrUpdateforProjectIn(String personIdIn,String personIdOut) throws Exception{
		List<ProjectExperienceListDTO> dtoList = (List<ProjectExperienceListDTO>)projectExperienceService.findAll(personIdIn, menuId, menuId);
		if(dtoList == null || dtoList.size() == 0){
			return "false";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo> outList = outRsProjectExperienceService.findAll(personIdOut);
		for(ProjectExperienceListDTO dto :dtoList){
			com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo newVo = setValuefromObject.projectSetValueFormIn(dto);
			newVo.setExperienceid("");
			newVo.setPersonId(personIdOut);
			if(outList != null && outList.size() > 0){
				for(com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo outVo : outList){
					//如是同一条数据则修改
					if(outVo.getProjresponsibility().equals(dto.getProjresponsibility()) && 
							outVo.getProjname().equals(dto.getProjname())){
						newVo.setExperienceid(outVo.getExperienceid());
						break;
					}
				}
			}
			outRsProjectExperienceService.saveOrUpdate(newVo);
		}
		return "true";
	}
	
	/**
	 * 更新或新增外网职称技能
	 * @param personIdIn 内网人才ID 
	 * @param personIdOut 外网人才ID
	 * @return 更新结果
	 * @throws Exception
	 */
	private String saveOrUpdatefortechnicallymessIn(String personIdIn,String personIdOut) throws Exception{
		List<TechnicallymessListDTO> dtoList = (List<TechnicallymessListDTO>)technicallymessService.findAll(personIdIn, menuId, menuId);
		if(dtoList == null || dtoList.size() == 0){
			return "false";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo> outList = outRsTechnicallymessService.findAll(personIdOut);
		for(TechnicallymessListDTO dto :dtoList){
			com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo newVo = setValuefromObject.technicallymessSetValueFormIn(dto);
			newVo.setTechId("");
			newVo.setPersonId(personIdOut);
			if(outList != null && outList.size() > 0){
				for(com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo outVo : outList){
					//内容相同则更新
					if(outVo.getTechnicallyType().equals(dto.getTechnicallyType()) && 
							outVo.getTechnicallyLevel().equals(dto.getTechnicallyLevel())){
						newVo.setTechId(outVo.getTechId());
						break;
					}
				}
			}
			outRsTechnicallymessService.saveOrUpdate(newVo);
		}
		return "true";
	}
	
	/**
	 * 更新或新增外网科技成果 
	 * @param personIdIn 内网人才ID
	 * @param personIdOut 外网人才ID
	 * @return 更新结果
	 * @throws Exception
	 */
	private String saveOrUpdatefortechnologicalHarvestIn(String personIdIn,String personIdOut) throws Exception{
		List<TechnologicalHarvestListDTO> dtoList = (List<TechnologicalHarvestListDTO>)technologicalHarvestService.findAll(personIdIn, menuId, menuId);
		if(dtoList == null || dtoList.size() == 0){
			return "false";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo> outList = outRsTechnologicalHarvestService.findAll(personIdOut);
		for(TechnologicalHarvestListDTO dto :dtoList){
			com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo newVo = setValuefromObject.technologicalHarvestSetValueFormIn(dto);
			newVo.setHarvestId("");
			newVo.setPersonId(personIdOut);
			if(outList != null && outList.size() > 0){
				for(com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo outVo : outList){
					if(outVo.getHarvestLevel().equals(dto.getHarvestLevel()) && 
							outVo.getHarvestName().equals(dto.getHarvestName()) && 
							outVo.getAssessDep().equals(dto.getAssessDep())){
						//内容相同则更新
						newVo.setHarvestId(outVo.getHarvestId());
						break;
					}
				}
			}
			outRsTechnologicalHarvestService.saveOrUpdate(newVo);
		}
		return "true";
	}
	
	/**
	 * 更新或新增外网工作经验
	 * @param personIdIn 内网人才ID
	 * @param personIdOut 外网人才ID
	 * @return 更新结果
	 * @throws Exception
	 */
	private String saveOrUpdateforworkIn(String personIdIn,String personIdOut) throws Exception{
		List<WorkexperienceDetailDTO> dtoList = (List<WorkexperienceDetailDTO>)workexperienceService.findAll(personIdIn, menuId, menuId);
		if(dtoList == null || dtoList.size() == 0){
			return "false";
		}
		List<com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo> outList = outRsWorkexperienceService.findAll(personIdOut);
		for(WorkexperienceDetailDTO dto :dtoList){
			com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo newVo = setValuefromObject.workSetValueFormIn(dto);
			newVo.setWorkId("");
			newVo.setPersonId(personIdOut);
			if(outList != null && outList.size() > 0){
				for(com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo outVo : outList){
					if(outVo.getCompanyName().equals(dto.getCompanyName()) && 
							outVo.getPposition().equals(dto.getPposition())){
						//内容相同则更新
						newVo.setWorkId(outVo.getWorkId());
						break;
					}
				}
			}
			outRsWorkexperienceService.saveOrUpdate(newVo);
		}
		return "true";
	}
	
	/**
	 * 更新或新增内网人才数据 外网过滤条件为已经审核并且是上一次交换后审核的数据
	 * @param listSo
	 * @return
	 * @throws Exception
	 */
	public int repersonDataChangeFormOut(RsPersonOutQo listSo) throws Exception{
		try {
			listSo.setIsvalid("1");
			Paging paging =new Paging();
			paging.setTotalPages(1);
			paging.setPageSize(100);
			for(int i = 1; i <= paging.getTotalPages(); i++){
				paging.setCurrentIndex(i);
				Paging pagingFirst = outRsPersonService.queryByPage(paging, listSo);
				if(pagingFirst == null){
					return 0;
				}
				paging.setTotalPages(pagingFirst.getTotalPages());
				List<com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo> voList = (List<com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo>)pagingFirst.getVoList();
				if(voList == null || voList.size() == 0){
					return 0;
				}
				for(com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo vo : voList){
					saveOrUpdatePersonIn(vo);
				}
				if(i % 10 == 0){
					System.out.println("已经交换了："+ i*100 + " 先休息下");
					Thread.sleep(20 * 1000);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return 0;
	}
	
	/**
	 * 将外网的人才基本信息更新到内网
	 * @param inVo 内网人才基本信息实体
	 * @return  是否成功
	 * @throws Exception
	 */
	private String saveOrUpdatePersonIn(com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo outVo) throws Exception{
		try {			
			String dchangdetail = "从公共服务平台交换到实名系统";
			String dchangtype = "修改数据";
			
			QueryRsPersonListSO queryListSO = new QueryRsPersonListSO();
			queryListSO.setIdCard(outVo.getIdCard());
			Paging paging = new Paging();
			List<RsPersonListDTO> voList = (List<RsPersonListDTO>)rsPersonService.queryByPage(paging, queryListSO,menuId,menuId);
			RsPersonDetailDTO newInVo = new RsPersonDetailDTO();
			if(voList == null || voList.size() == 0){
				dchangtype = "新增数据";
				newInVo = new RsPersonDetailDTO();
			}else{
				newInVo = (RsPersonDetailDTO)CloneUtil.cloneObject(voList.get(0),newInVo,null);
			}
			RsPersonDetailDTO newVo = new RsPersonDetailDTO();
			boolean isTrue = true;
			String str_value = newInVo.getAuditdate();
			if(newInVo.getAuditdate() == null || newInVo.getAuditdate().equals("0")){
				str_value = "";
			}else{
				str_value = newInVo.getAuditdate().substring(newInVo.getAuditdate().lastIndexOf("/")+1) +"-"+
						newInVo.getAuditdate().substring(0, 2)+"-"+ newInVo.getAuditdate().substring(3, 5);
			}
			int value = outVo.getAuditdate() - dealDate(str_value);
			if(value > 0){
				isTrue = false;
			}

			RsPersonListDTO inVo = new RsPersonListDTO();
			if(!isTrue){			
				newVo = setValuefromObject.personSetValueFormOut(newInVo, outVo);
				String id = rsPersonService.saveOrUpdate(newVo);
				if(id != null && id.length()<40){
					newVo.setPersonId(id);
					saveOrUpdateforAffixOut(newVo.getPersonId(),outVo.getPersonId());
					saveOrUpdateforEducationOut(newVo.getPersonId(),outVo.getPersonId());
					saveOrUpdateforProjectOut(newVo.getPersonId(),outVo.getPersonId());
					saveOrUpdatefortechnicallymessOut(newVo.getPersonId(),outVo.getPersonId());
					saveOrUpdatefortechnologicalHarvestOut(newVo.getPersonId(),outVo.getPersonId());
					saveOrUpdateforworkOut(newVo.getPersonId(),outVo.getPersonId());	
				}		
				ChangeDetail obj = new ChangeDetail();
				obj.setDchangdetail(dchangdetail);
				obj.setDchangtype(dchangtype);
				obj.setCheckstate("成功");
				obj.setChangedate(DateUtil.getCurDate());
				obj.setDchangtime(DateUtil.getCurDateTime());
				obj.setIdcard(outVo.getIdCard());
				baseDao.saveOrUpdate(obj);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return "true";
	}
	
	/**
	 * 处理日期 格式为yyyy-MM-dd
	 * @return 返回日期的整形
	 */
	public int dealDate(String inputQuery){
		int dateInt = 0;
		if(inputQuery!=null && !inputQuery.trim().equals("")){
			Date beginDate=DateUtil.getDate(inputQuery,"yyyy-MM-dd");  //yyyy-MM-dd
    		int bYYYY = DateUtil.getYear(beginDate);
    		int bMM = DateUtil.getMonth(beginDate);
    		int bDD = DateUtil.getDay(beginDate);
    		if( bMM <=9 ){
    			dateInt= Integer.parseInt(bYYYY +"0"+ bMM);
    		}else{
    			dateInt= Integer.parseInt(bYYYY +""+ bMM);
    		}
    		if( bDD <=9 ){
    			dateInt= Integer.parseInt(dateInt +"0"+ bDD);
    		}else{
    			dateInt= Integer.parseInt(dateInt +""+ bDD);
    		}
    	}
		return dateInt;
	}
	
	private String saveOrUpdateforAffixOut(String personIdIn,String personIdOut){
		List<com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo> outAffixList;
		ArrayList<RsAffixDTO> inAffixList;
		try {
			outAffixList = outRsAffixService.queryByPersonId(personIdOut);
			if(outAffixList == null || outAffixList.size() == 0){
				return "true";
			}
			inAffixList = (ArrayList<RsAffixDTO>)rsAffixService.queryByPersonId(personIdIn, menuId, menuId);			
			RsAffixDTO newVo = setValuefromObject.affixSetValueFormOut(outAffixList.get(0));
			newVo.setPersonId(personIdIn);	
			newVo.setAffixId("");
			//内网有则修改
			if(inAffixList != null && inAffixList.size() > 0){
				newVo.setAffixId(inAffixList.get(0).getAffixId());		
			}
			rsAffixService.saveOrUpdate(newVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
	}
	private String saveOrUpdateforEducationOut(String personIdIn,String personIdOut){
		List<EducationexperienceListDTO> dtoList;
		try {
			List<com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo> outList = outRsEducationexperienceService.findAll(personIdOut);			
			//没有教育简历则返回
			if(outList == null || outList.size() == 0){
				return "false";
			}
			dtoList = (List<EducationexperienceListDTO>)educationexperienceService.findAll(personIdIn, menuId, menuId);			
			for(com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo  dto: outList){
				EducationexperienceDetaiDTO newVo = setValuefromObject.educationSetValueFormOut(dto);
				newVo.setPersonId(personIdIn);
				newVo.setEducationId("");
				if(dtoList != null && dtoList.size() > 0){
					for(EducationexperienceListDTO outVo : dtoList){
						if(outVo.getPcollege().equals(dto.getPcollege()) && 
								outVo.getSpecialtyName().equals(dto.getSpecialtyName())){
							newVo.setEducationId(outVo.getEducationId());
							break;
						}
					}
				}
				educationexperienceService.saveOrUpdate(newVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
	}
	private String saveOrUpdateforProjectOut(String personIdIn,String personIdOut){
		List<ProjectExperienceListDTO> dtoList;
		try {
			List<com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo> outList = outRsProjectExperienceService.findAll(personIdOut);			
			if(outList == null || outList.size() == 0){
				return "false";
			}
			dtoList = (List<ProjectExperienceListDTO>)projectExperienceService.findAll(personIdIn, menuId, menuId);			
			for(com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo dto :outList){
				ProjectExperienceDetaiDTO newVo = setValuefromObject.projectSetValueFormOut(dto);
				newVo.setExperienceid("");
				newVo.setPersonId(personIdIn);
				if(dtoList != null && dtoList.size() > 0){
					for(ProjectExperienceListDTO outVo : dtoList){
						//如是同一条数据则修改
						if(outVo.getProjresponsibility().equals(dto.getProjresponsibility()) && 
								outVo.getProjname().equals(dto.getProjname())){
							newVo.setExperienceid(outVo.getExperienceid());
							break;
						}
					}
				}
				projectExperienceService.saveOrUpdate(newVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
	}
	private String saveOrUpdatefortechnicallymessOut(String personIdIn,String personIdOut){
		List<TechnicallymessListDTO> dtoList;
		try {
			List<com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo> outList = outRsTechnicallymessService.findAll(personIdOut);			
			if(outList == null || outList.size() == 0){
				return "false";
			}
			dtoList = (List<TechnicallymessListDTO>)technicallymessService.findAll(personIdIn, menuId, menuId);
			for(com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo dto :outList){
				TechnicallymessDetaiDTO newVo = setValuefromObject.technicallymessSetValueFormOut(dto);
				newVo.setTechId("");
				newVo.setPersonId(personIdIn);
				if(dtoList != null && dtoList.size() > 0){
					for(TechnicallymessListDTO outVo : dtoList){
						if(outVo.getTechnicallyType().equals(dto.getTechnicallyType()) && 
								outVo.getTechnicallyLevel().equals(dto.getTechnicallyLevel())){
							newVo.setTechId(outVo.getTechId());
							break;
						}
					}
				}
				technicallymessService.saveOrUpdate(newVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
	}
	private String saveOrUpdatefortechnologicalHarvestOut(String personIdIn,String personIdOut){
		List<TechnologicalHarvestListDTO> dtoList;
		try {
			List<com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo> outList = outRsTechnologicalHarvestService.findAll(personIdOut);
			
			if(outList == null || outList.size() == 0){
				return "false";
			}
			dtoList = (List<TechnologicalHarvestListDTO>)technologicalHarvestService.findAll(personIdIn, menuId, menuId);
			for(com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo dto :outList){
				TechnologicalHarvestListDTO newVo = setValuefromObject.technologicalHarvestSetValueFormOut(dto);
				newVo.setHarvestId("");
				newVo.setPersonId(personIdIn);
				if(dtoList != null && dtoList.size() > 0){
					for(TechnologicalHarvestListDTO outVo : dtoList){
						if(outVo.getHarvestLevel().equals(dto.getHarvestLevel()) && 
								outVo.getHarvestName().equals(dto.getHarvestName()) && 
								outVo.getAssessDep().equals(dto.getAssessDep())){
							newVo.setHarvestId(outVo.getHarvestId());
							break;
						}
					}
				}
				technologicalHarvestService.saveOrUpdate(newVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "true";
	}
	private String saveOrUpdateforworkOut(String personIdIn,String personIdOut){
		List<WorkexperienceDetailDTO> dtoList;
		try {
			List<com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo> outList = outRsWorkexperienceService.findAll(personIdOut);
			if(outList == null || outList.size() == 0){
				return "false";
			}
			dtoList = (List<WorkexperienceDetailDTO>)workexperienceService.findAll(personIdIn, menuId, menuId);			
			for(com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo dto :outList){
				WorkexperienceListDTO newVo = setValuefromObject.workSetValueFormOut(dto);
				newVo.setWorkId("");
				newVo.setPersonId(personIdIn);
				if(dtoList != null && dtoList.size() > 0){
					for(WorkexperienceDetailDTO outVo : dtoList){
						if(outVo.getCompanyName().equals(dto.getCompanyName()) && 
								outVo.getPposition().equals(dto.getPposition())){
							newVo.setWorkId(outVo.getWorkId());
							break;
						}
					}
				}
				workexperienceService.saveOrUpdate(newVo);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "true";
	}
		
	
	
	
	public OutRsPersonService getOutRsPersonService() {
		return outRsPersonService;
	}

	public void setOutRsPersonService(OutRsPersonService outRsPersonService) {
		this.outRsPersonService = outRsPersonService;
	}

	public RsPersonService getRsPersonService() {
		return rsPersonService;
	}

	public void setRsPersonService(RsPersonService rsPersonService) {
		this.rsPersonService = rsPersonService;
	}

	public OutRsAffixService getOutRsAffixService() {
		return outRsAffixService;
	}

	public void setOutRsAffixService(OutRsAffixService outRsAffixService) {
		this.outRsAffixService = outRsAffixService;
	}

	public RsAffixService getRsAffixService() {
		return rsAffixService;
	}

	public void setRsAffixService(RsAffixService rsAffixService) {
		this.rsAffixService = rsAffixService;
	}

	public OutRsEducationexperienceService getOutRsEducationexperienceService() {
		return outRsEducationexperienceService;
	}

	public void setOutRsEducationexperienceService(
			OutRsEducationexperienceService outRsEducationexperienceService) {
		this.outRsEducationexperienceService = outRsEducationexperienceService;
	}

	public EducationexperienceService getEducationexperienceService() {
		return educationexperienceService;
	}

	public void setEducationexperienceService(
			EducationexperienceService educationexperienceService) {
		this.educationexperienceService = educationexperienceService;
	}

	public OutRsProjectExperienceService getOutRsProjectExperienceService() {
		return outRsProjectExperienceService;
	}

	public void setOutRsProjectExperienceService(
			OutRsProjectExperienceService outRsProjectExperienceService) {
		this.outRsProjectExperienceService = outRsProjectExperienceService;
	}

	public ProjectExperienceService getProjectExperienceService() {
		return projectExperienceService;
	}

	public void setProjectExperienceService(
			ProjectExperienceService projectExperienceService) {
		this.projectExperienceService = projectExperienceService;
	}

	public OutRsTechnicallymessService getOutRsTechnicallymessService() {
		return outRsTechnicallymessService;
	}

	public void setOutRsTechnicallymessService(
			OutRsTechnicallymessService outRsTechnicallymessService) {
		this.outRsTechnicallymessService = outRsTechnicallymessService;
	}

	public OutRsTechnologicalHarvestService getOutRsTechnologicalHarvestService() {
		return outRsTechnologicalHarvestService;
	}

	public void setOutRsTechnologicalHarvestService(
			OutRsTechnologicalHarvestService outRsTechnologicalHarvestService) {
		this.outRsTechnologicalHarvestService = outRsTechnologicalHarvestService;
	}

	public TechnicallymessService getTechnicallymessService() {
		return technicallymessService;
	}

	public void setTechnicallymessService(
			TechnicallymessService technicallymessService) {
		this.technicallymessService = technicallymessService;
	}

	public TechnologicalHarvestService getTechnologicalHarvestService() {
		return technologicalHarvestService;
	}

	public void setTechnologicalHarvestService(
			TechnologicalHarvestService technologicalHarvestService) {
		this.technologicalHarvestService = technologicalHarvestService;
	}

	public OutRsWorkexperienceService getOutRsWorkexperienceService() {
		return outRsWorkexperienceService;
	}

	public void setOutRsWorkexperienceService(
			OutRsWorkexperienceService outRsWorkexperienceService) {
		this.outRsWorkexperienceService = outRsWorkexperienceService;
	}

	public WorkexperienceService getWorkexperienceService() {
		return workexperienceService;
	}

	public void setWorkexperienceService(WorkexperienceService workexperienceService) {
		this.workexperienceService = workexperienceService;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
	
}
