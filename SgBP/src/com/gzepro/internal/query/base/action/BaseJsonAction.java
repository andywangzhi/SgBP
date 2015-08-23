package com.gzepro.internal.query.base.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.common.util.json.JsonPaging;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class BaseJsonAction extends BaseAction {
	
	protected JsonPaging jsonPaging = new JsonPaging();
	
	protected List list = new ArrayList();
	protected Integer page;//当前页数
	protected Integer rows;//每页的记录数
	protected Integer total;//总记录数
	protected String sort;//排序字段
	protected String order;//asc或者dec
	
	protected HttpServletRequest request = this.getRequest();
	
	public String toJSONString(JsonPaging jsonPaging) {
		return "{\"total\": "+jsonPaging.getTotal()+",\"rows\": "
		                +JSONUtils.toJSONString(jsonPaging.getList())+"}";
	}
	
	public JsonPaging getJsonPaging() {
		jsonPaging.setPage(page);
		jsonPaging.setRows(rows);
		jsonPaging.setSort(sort);
		jsonPaging.setOrder(order);
		jsonPaging.setPage(page);
		jsonPaging.setTotal(total);
		return jsonPaging;
	}
	public void setJsonPaging(JsonPaging jsonPaging) {
		this.jsonPaging = jsonPaging;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
