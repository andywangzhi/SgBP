package com.gzepro.internal.query.soa.service.user.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class UserForm {
	private QueryUserListSO queryListSO = new QueryUserListSO();
	private RetrieveUserSO retrieveSO = new RetrieveUserSO();
	
	private UserDetailDTO dto = new UserDetailDTO();
	private List<UserListDTO> dtoList = new ArrayList<UserListDTO>();
	
	public QueryUserListSO getQueryListSO() {
		return queryListSO;
	}
	public void setQueryListSO(QueryUserListSO queryListSO) {
		this.queryListSO = queryListSO;
	}
	public RetrieveUserSO getRetrieveSO() {
		return retrieveSO;
	}
	public void setRetrieveSO(RetrieveUserSO retrieveSO) {
		this.retrieveSO = retrieveSO;
	}
	public UserDetailDTO getDto() {
		return dto;
	}
	public void setDto(UserDetailDTO dto) {
		this.dto = dto;
	}
	public List<UserListDTO> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<UserListDTO> dtoList) {
		this.dtoList = dtoList;
	}
}
