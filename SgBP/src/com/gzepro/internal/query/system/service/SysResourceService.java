/*
 * Copyright (c) 2009-2012 by fsll
 * All rights reserved.
 */

package com.gzepro.internal.query.system.service;
import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.SysResource;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface SysResourceService {
	/**
	 * 增加一条数据
	 * @param sysResource
	 */
	public  SysResource add(SysResource sysResource);
	
	/**
	 * 修改一条数据
	 * @param sysResource
	 */
	public  SysResource edit(SysResource sysResource);
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status);
	
	/**
	 * 通过ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(Long id);
	
	/**
	 * 检测资源Code
	 */
	public SysResource  resourceCodeExist(String code);
	
	/**
	 * 删除多条数据
	 * @param ids
	 * @return
	 */
	public  boolean delete(String ids);
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public SysResource findById(Long id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String dec,String type,String valid);
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<SysResource> findAll();
	
}
