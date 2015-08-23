package com.gzepro.internal.query.system.service;

import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Account;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface AccountService {

	/**
	 * 增加一条数据
	 * @param account
	 */
	public  Account add(Account account);
	
	/**
	 * 修改一条数据
	 * @param account
	 */
	public  Account edit(Account account);
	
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
	public Account findById(Long id);
	
	
	/**
	 * 修改用户的语言
	 * @param ids
	 * @param status
	 */
	public  boolean saveLang(String ids,String lang);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String name,String realName,String groupId,String valid);
	
	/**
	 * 查找指定部门所有的用户数据
	 * @param deptCode
     * @param roleId 角色ID 在角色中加载组成员时，要去掉角色下已有的成员
	 * @return
	 */
	public List<Account> findAllByDeptCode(String deptId,Long roleId);
	
	/**
	 * 查找所有的组成员
	 * @param groupId
     * @param roleId 角色ID 在角色中加载组成员时，要去掉角色下已有的成员
	 * @param manager 是否组管理员
	 * @return
	 */
	public List<Account> findGroupAccount(Long groupId,Long roleId,String manager);
	
	/**
	 * 查找角色的所有用户
	 * @param roleId
	 * @return
	 */
	public List<Account> findRoleAccount(Long roleId);
	
	/**
	 * 通过名称查找用户
	 * @param name
	 * @return
	 */
	public Account findByName(String name);
	
	/**
	 * 通过名称查找用户
	 * @param name
	 * @param code
	 * @return
	 */
	public List<Account> findByNameOrCode(String name,String code);
	
	/**
	 * 通过名称查找用户,部门处使用,一个用户只能属于一个部门
	 * @param name
	 * @param code
	 * @return
	 */
	public List<Account> findByNameOrCodeForDept(String name,String code);
	
	/**
	 * 查找指定部门所有的用户数据
	 * @param deptCode
	 * @return
	 */
	public List<Account> findAllByDeptCode(String deptId);
	
	/**
	 * 通过用户ID获得用户所在的部门
	 * @param name
	 * @return
	 */
	public String findDeptByAccountId(Long accountId);
	
}