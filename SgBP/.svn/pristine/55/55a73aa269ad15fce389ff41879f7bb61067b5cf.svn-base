package com.gzepro.internal.query.system.service;


import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Dictionary;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface DictionaryService {
	/**
	 * 增加一条数据
	 * @param dictionary
	 */
	public  Dictionary add(Dictionary dictionary);
	
	/**
	 * 修改一条数据
	 * @param dictionary
	 */
	public  Dictionary edit(Dictionary dictionary);
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status);
	
	/**
	 * 保存菜单的敏感信息
	 * @param dicId 敏感信息id
	 * @param menuIds 菜单id
	 * @return
	 */
	public boolean saveMenuDic(Long dicId,String menuIds);
	
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
	public Dictionary dictionaryCodeExist(String code);
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Dictionary findById(Long id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid,String sensitive);
	
	/**
	 * 查找指定菜单的可控字段
	 * @param jsonPaging
	 * @param menuId
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,Long menuId);
	
	/**
	 * 查找所有的数据
	 * @param id
	 * @return
	 */
	public List<Dictionary> findAll();
	
}
