package com.gzepro.internal.query.system.service;

import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Dept;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface DeptService {
	/**
	 * 增加一条数据
	 * @param dept
	 */
	public  Dept add(Dept dept,String accountIds);
	
	/**
	 * 修改一条数据
	 * @param dept
	 */
	public  Dept edit(Dept dept,String accountIds);
	
	
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
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Dept findById(Long id);
	
	/**
	 * 是否存在唯一的Code
	 */
	public Dept codeExist(String code);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String valid);
	
	/**
	 * 查找所有的数据
	 * @param id
	 * @return
	 */
	public List<Dept> findAll();
	
	/**
	 * 
	 * @param nameCN
	 * @return
	 */
	public  List<Dept> loadDeptNodesList(String nameCN);
	
	/**
	 * 基础数据操作 获得所有数据的json格式串
	 * @return
	 */
	public String findDeptJsonStr();
	
	/**
	 * 通过部门ID查找部门用户
	 * @param deptId
	 * @return
	 */
	public List<Account> findAllAccountByDeptId(Long deptId);
	
}
