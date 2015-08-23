/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RctjForm {
	private RetrieveRctjSO retrieveSO = new RetrieveRctjSO();
	private String swf;
	private Map<String, Map> dtoList = new HashMap<String, Map>();
	private Map<String, Long> countList = new LinkedHashMap<String, Long>();
	private Map<String, String> confList = new LinkedHashMap<String, String>();
	private Map<String, String> personTypeList = new LinkedHashMap<String, String>();
	public RetrieveRctjSO getRetrieveSO() {
		return retrieveSO;
	}

	public void setRetrieveSO(RetrieveRctjSO retrieveSO) {
		this.retrieveSO = retrieveSO;
	}

	public Map<String, Map> getDtoList() {
		return dtoList;
	}

	public void setDtoList(Map<String, Map> dtoList) {
		this.dtoList = dtoList;
	}

	public Map<String, String> getConfList() {
		return confList;
	}

	public void setConfList(Map<String, String> confList) {
		this.confList = confList;
	}

	
	public Map<String, String> getPersonTypeList() {
		return personTypeList;
	}

	public void setPersonTypeList(Map<String, String> personTypeList) {
		this.personTypeList = personTypeList;
	}
	
	public Map<String, Long> getCountList() {
		return countList;
	}

	public void setCountList(Map<String, Long> countList) {
		this.countList = countList;
	}

	/**
	 * 返回falsh的拼接字符
	 * 
	 * @return
	 */
	public String getSwf() {
		Long counts = new Long(0);
		// 政府\t5000\n工业\t50000\n农业\t105000\n矿业\t25000\n贸易\t3000\n服务业\t28000\n其他\t13000\n
		StringBuffer buffer = new StringBuffer();
		buffer.append("&xdata=");
		Long count = null;
		if (this.dtoList.size() == 1) {
			for (String s : dtoList.keySet()) {
				Map<String, Long> one = dtoList.get(s);
				for (String p : personTypeList.keySet()) {
				 count=	one.get(p);
				 if(count==null){
					 count=new Long(0);
				 }
				 buffer.append(personTypeList.get(p) + "\\t");
				 buffer.append(count.toString() + "\\n");
				 counts = counts + count;
				}
			}
			this.swf = counts.toString() + buffer.toString();
			return swf;
		} else {
			for (String s : confList.keySet()) {
				Map<String, Long> one = dtoList.get(s);
				if (one != null && one.size() > 0) {
					buffer.append(confList.get(s) + "\\t");
					count = new Long(0);
					for (String y : one.keySet()) {
						count = count + one.get(y);
					}
					buffer.append(count.toString() + "\\n");
					counts = counts + count;
				}
			}
			this.swf = counts.toString() + buffer.toString();
			return swf;
		}
	}

}