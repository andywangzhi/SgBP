package com.gzepro.internal.query.system.service;

import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Conf;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface ConfService {
	/**
	 * 增加一条数据
	 * @param conf
	 */
	public  Conf add(Conf conf);
	
	/**
	 * 修改一条数据
	 * @param conf
	 */
	public  Conf edit(Conf conf);
	
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
	public Conf codeExist(String code);
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Conf findById(Long id);
	
	
	/**
	 * 基础数据操作 获得所有数据的json格式串
	 * @return
	 */
	public String findConfJsonStr(Long typeId);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid);
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<Conf> findAll(Long typeId);
	
	/**
	 * 查找所有字典表中的所有数据
	 * 用于插入application
	 * @return
	 */
	public List<Conf> findConfAll();
	
	/**
	 * 查找字典表子类型的字典数据
	 * zjw
	 * @return
	 */
	public List<Conf> findChildConf(Long parentId);
	
	
	/**
	 * 通过code查找父字典
	 */
	public Conf findConf(String code,Long typeId);
}
