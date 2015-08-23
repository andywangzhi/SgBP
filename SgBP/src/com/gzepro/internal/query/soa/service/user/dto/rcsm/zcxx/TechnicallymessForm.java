package com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx;

import java.util.ArrayList;
import java.util.List;




public class TechnicallymessForm {
	private List<QueryTechnicallymessListSO> QueryListSO = new ArrayList<QueryTechnicallymessListSO>();
	private QueryTechnicallymessListSO retrieveSO =new QueryTechnicallymessListSO();
	
	private String personId="";
	private List<TechnicallymessDetaiDTO> dtoList = new ArrayList<TechnicallymessDetaiDTO>();
	private TechnicallymessDetaiDTO Dto =new TechnicallymessDetaiDTO();
	private String auditstate;
	
	private String selected="";
	public String getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}

	public List<QueryTechnicallymessListSO> getQueryListSO() {
		return QueryListSO;
	}
	public void setQueryListSO(List<QueryTechnicallymessListSO> queryListSO) {
		QueryListSO = queryListSO;
	}
	public List<TechnicallymessDetaiDTO> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<TechnicallymessDetaiDTO> dtoList) {
		this.dtoList = dtoList;
	}
	public QueryTechnicallymessListSO getRetrieveSO() {
		return retrieveSO;
	}
	public void setRetrieveSO(QueryTechnicallymessListSO retrieveSO) {
		this.retrieveSO = retrieveSO;
	}
	public TechnicallymessDetaiDTO getDto() {
		return Dto;
	}
	public void setDto(TechnicallymessDetaiDTO dto) {
		Dto = dto;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
}
