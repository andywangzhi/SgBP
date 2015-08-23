package com.gzepro.internal.query.system.service;


import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.ChangeDetail;
import com.gzepro.internal.query.system.model.SysLog;


/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface ChangeLogService {
	/**
	 * 增加一条数据
	 * @param sysLog
	 */
	public  ChangeDetail add(ChangeDetail changeDetail);
	
	/**
	 * 修改一条数据
	 * @param sysLog
	 */
	public  ChangeDetail edit(ChangeDetail changeDetail);
	
	/**
	 * 通过ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id);
	
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
	public ChangeDetail findById(String id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String time,String type);
	
}
