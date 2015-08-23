package com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg;

import java.util.ArrayList;
import java.util.List;

public class TechnologicalHarvestForm {
	private QueryTechnologicalHarvestListSO queryListSO = new QueryTechnologicalHarvestListSO();
	private RetrieveTechnologicalHarvestSO retrieveSO = new RetrieveTechnologicalHarvestSO();
	
	private TechnologicalHarvestDetailDTO dto = new TechnologicalHarvestDetailDTO();
	private List<TechnologicalHarvestListDTO> dtoList = new ArrayList<TechnologicalHarvestListDTO>();
	private String auditstate;
	private String selected="";
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}
	public QueryTechnologicalHarvestListSO getQueryListSO() {
		return queryListSO;
	}
	public void setQueryListSO(QueryTechnologicalHarvestListSO queryListSO) {
		this.queryListSO = queryListSO;
	}
	public RetrieveTechnologicalHarvestSO getRetrieveSO() {
		return retrieveSO;
	}
	public void setRetrieveSO(RetrieveTechnologicalHarvestSO retrieveSO) {
		this.retrieveSO = retrieveSO;
	}
	public TechnologicalHarvestDetailDTO getDto() {
		return dto;
	}
	public void setDto(TechnologicalHarvestDetailDTO dto) {
		this.dto = dto;
	}
	public List<TechnologicalHarvestListDTO> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<TechnologicalHarvestListDTO> dtoList) {
		this.dtoList = dtoList;
	}

}
