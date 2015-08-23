/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj;
/**
 * 人才统计信息
 */
public class RctjDetailDTO {
	private String area;//区域、专业、职称
	private String type;//人才类型
	private Long count;//数量
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
