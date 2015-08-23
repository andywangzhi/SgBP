package com.gzepro.internal.query.soa.service.user.dto.rcsm.need;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed;


public class RsPersonneedForm {
	//保存用
	private RsPersonneed rsPersonneed = new RsPersonneed();
	private RsPersonneed rsPersonneedQuery = new RsPersonneed();
	private List<RsPersonneed> dtoList = new ArrayList<RsPersonneed>();
	

	private String ids = "";
	//区别选择add、修改edit、查看view
	private String business = "view";

	public RsPersonneed getRsPersonneed() {
		return rsPersonneed;
	}

	public void setRsPersonneed(RsPersonneed rsPersonneed) {
		this.rsPersonneed = rsPersonneed;
	}

	public RsPersonneed getRsPersonneedQuery() {
		return rsPersonneedQuery;
	}

	public void setRsPersonneedQuery(RsPersonneed rsPersonneedQuery) {
		this.rsPersonneedQuery = rsPersonneedQuery;
	}

	public List<RsPersonneed> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<RsPersonneed> dtoList) {
		this.dtoList = dtoList;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
