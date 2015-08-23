package com.gzepro.internal.query.soa.service.user.dto.rcsm.preview;

import java.util.ArrayList;
import java.util.List;

import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessListDTO;

public class PreviewForm {
	
	private RsPersonListDTO personDetail = new RsPersonListDTO();
	private List<WorkexperienceListDTO> workexpList = new ArrayList<WorkexperienceListDTO>();
	private List<EducationexperienceListDTO> eduExpList = new ArrayList<EducationexperienceListDTO>();
	private List<TechnologicalHarvestListDTO> techHarvestList= new ArrayList<TechnologicalHarvestListDTO>();
	private List<ProjectExperienceListDTO> proExpList = new ArrayList<ProjectExperienceListDTO>();
	private List<TechnicallymessListDTO> techMessList = new ArrayList<TechnicallymessListDTO>();
	private List<RsAffixDTO> affixList = new ArrayList<RsAffixDTO>();	// 照片dto
	private List<RsAffixDTO> gdImg = new ArrayList<RsAffixDTO>();		// 采集表归档图
	/**
	 * @return the gdImg
	 */
	public List<RsAffixDTO> getGdImg() {
		return gdImg;
	}

	/**
	 * @param gdImg the gdImg to set
	 */
	public void setGdImg(List<RsAffixDTO> gdImg) {
		this.gdImg = gdImg;
	}

	private String uuid;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<RsAffixDTO> getAffixList() {
		return affixList;
	}

	public void setAffixList(List<RsAffixDTO> affixList) {
		this.affixList = affixList;
	}

	public RsPersonListDTO getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(RsPersonListDTO personDetail) {
		this.personDetail = personDetail;
	}

	public List<WorkexperienceListDTO> getWorkexpList() {
		return workexpList;
	}

	public void setWorkexpList(List<WorkexperienceListDTO> workexpList) {
		this.workexpList = workexpList;
	}

	public List<EducationexperienceListDTO> getEduExpList() {
		return eduExpList;
	}

	public void setEduExpList(List<EducationexperienceListDTO> eduExpList) {
		this.eduExpList = eduExpList;
	}

	public List<TechnologicalHarvestListDTO> getTechHarvestList() {
		return techHarvestList;
	}

	public void setTechHarvestList(List<TechnologicalHarvestListDTO> techHarvestList) {
		this.techHarvestList = techHarvestList;
	}

	public List<ProjectExperienceListDTO> getProExpList() {
		return proExpList;
	}

	public void setProExpList(List<ProjectExperienceListDTO> proExpList) {
		this.proExpList = proExpList;
	}

	public List<TechnicallymessListDTO> getTechMessList() {
		return techMessList;
	}

	public void setTechMessList(List<TechnicallymessListDTO> techMessList) {
		this.techMessList = techMessList;
	}
}
