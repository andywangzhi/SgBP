package com.gzepro.internal.query.soa.service.user.dto.rcsm.base;

import java.util.ArrayList;
import java.util.List;

import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;

public class RsPersonForm {
	private QueryRsPersonListSO queryListSO = new QueryRsPersonListSO();
	private RetrieveRsPersonSO retrieveSO = new RetrieveRsPersonSO();
	private List<RsAffixDTO> affixList = new ArrayList<RsAffixDTO>();
	private String parentCode;
	private String flag="0";
	private String idCard="";
	private String registeraddrprov="";
	private String registeraddrcity="";
	private String usercountry;
	private RsPersonDetailDTO dto = new RsPersonDetailDTO();
	private List<RsPersonListDTO> dtoList = new ArrayList<RsPersonListDTO>();
	public QueryRsPersonListSO getQueryListSO() {
		return queryListSO;
	}
	public void setQueryListSO(QueryRsPersonListSO queryListSO) {
		this.queryListSO = queryListSO;
	}
	public RetrieveRsPersonSO getRetrieveSO() {
		return retrieveSO;
	}
	public void setRetrieveSO(RetrieveRsPersonSO retrieveSO) {
		this.retrieveSO = retrieveSO;
	}
	public RsPersonDetailDTO getDto() {
		return dto;
	}
	public void setDto(RsPersonDetailDTO dto) {
		this.dto = dto;
	}
	public List<RsPersonListDTO> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<RsPersonListDTO> dtoList) {
		this.dtoList = dtoList;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRegisteraddrcity() {
		return registeraddrcity;
	}
	public void setRegisteraddrcity(String registeraddrcity) {
		this.registeraddrcity = registeraddrcity;
	}
	public String getRegisteraddrprov() {
		return registeraddrprov;
	}
	public void setRegisteraddrprov(String registeraddrprov) {
		this.registeraddrprov = registeraddrprov;
	}
	public List<RsAffixDTO> getAffixList() {
		return affixList;
	}
	public void setAffixList(List<RsAffixDTO> affixList) {
		this.affixList = affixList;
	}
	public String getUsercountry() {
		return usercountry;
	}
	public void setUsercountry(String usercountry) {
		this.usercountry = usercountry;
	}
	
}
