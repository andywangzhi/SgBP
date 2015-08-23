package com.gzepro.internal.query.system.service;

import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.ConfType;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface ConfTypeService {
	/**
	 * 增加一条数据
	 * @param confType
	 */
	public  ConfType add(ConfType confType);
	
	/**
	 * 修改一条数据
	 * @param confType
	 */
	public  ConfType edit(ConfType confType);
	
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
	 * 删除多条数据
	 * @param ids
	 * @return
	 */
	public  boolean delete(String ids);
	
	/**
	 * 是否存在唯一的Code
	 */
	public ConfType codeExist(String code);
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public ConfType findById(Long id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String valid);
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<ConfType> findAll();
	
}
